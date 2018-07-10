package service;

import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    public void add(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(project);
        closeTransaction();
    }

    public void update(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(project);
        closeTransaction();
    }

    public void remove(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(project);
        closeTransaction();
    }

    public List<Project> getAll() throws SQLException {
        String sql = "SELECT * FROM PROJECT";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projects = query.list();

        //close session with a transaction
        closeTransaction();
        return projects;
    }

    public Project getById(Long id) throws SQLException {
        String sql = "SELECT * FROM PROJECT WHERE ID = :id";

        openTransactionSession();
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);
        Project project = (Project) query.getSingleResult();

        //close session with a transaction
        closeTransaction();
        return project;
    }
}
