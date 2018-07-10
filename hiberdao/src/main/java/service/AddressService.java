package service;

import bl.SessionUtil;
import dao.AdressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressService extends SessionUtil implements AdressDAO {
    public void add(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(address);
        closeTransaction();
    }

    public void update(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransaction();
    }

    public void remove(Address address) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(address);
        closeTransaction();
    }

    public List<Address> getAll() throws SQLException {
        String sql = "SELECT * FROM ADDRESS";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        //close session with a transaction
        closeTransaction();
        return addressList;
    }

    public Address getById(Long id) throws SQLException {
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";


        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Address address = (Address) query.getSingleResult();
        //close session with a transaction
        closeTransaction();

        return address;
    }
}
