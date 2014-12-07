package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Julia on 12/7/14.
 */
public class HibernateUtil {

    private static HibernateUtil hibernateUtil = null;
    private static SessionFactory sessionFactory = null;
    private final ThreadLocal sessions = new ThreadLocal();

    private HibernateUtil() {
        try {
            sessionFactory = new AnnotationConfiguration().
                    configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.exit(0);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    public Session getSession(){
        Session session = (Session) sessions.get();
        if(session == null){
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public static synchronized HibernateUtil getHibernateUtil(){
        if(hibernateUtil == null){
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

}
