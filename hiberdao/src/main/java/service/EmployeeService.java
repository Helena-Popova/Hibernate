package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {

    public void add(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(employee);
        closeTransaction();
    }

    public void update(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransaction();
    }

    public void remove(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransaction();
    }

    public List<Employee> getAll() throws SQLException {
        String sql = "SELECT * FROM EMPLOYEE";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        //close session with a transaction
        closeTransaction();
        return employeeList;
    }

    public Employee getById(Long id) throws SQLException {
        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();

        //close session with a transaction
        closeTransaction();
        return employee;
    }
}
