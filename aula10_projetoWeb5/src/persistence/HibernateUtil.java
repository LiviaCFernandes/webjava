
package persistence;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

//abrir o arquivo apenas uma vez
//abre o banco de dados ~dao
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            sessionFactory = new AnnotationConfiguration().configure("config/mysql_hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
