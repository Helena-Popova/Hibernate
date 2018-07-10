package dao;

import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface AdressDAO {


    void add(Address address) throws SQLException;

    void update(Address address) throws SQLException;

    void remove(Address address) throws SQLException;

    List<Address> getAll() throws SQLException;

    Address getById(Long id) throws SQLException;
}
