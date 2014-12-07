import bean.Employee;
import bean.Project;
import bean.Unit;
import dao.WorkUnitDao;
import org.hibernate.SessionFactory;
import service.WorkUnitService;
import util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getHibernateUtil().getSessionFactory();
        sessionFactory.openSession();

//        WorkUnitDao workUnitDao = new WorkUnitDao();

        WorkUnitService workUnitService = new WorkUnitService();
        System.out.println(workUnitService.get(Unit.class, 1));

        System.out.println("Hello world! ");

        sessionFactory.close();
    }
}
