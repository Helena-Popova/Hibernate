package bl;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {

    @Getter
    private Session session;

    @Getter
    private Transaction transaction;

    public Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransaction() {
        transaction.commit();
        closeSession();
    }

}
