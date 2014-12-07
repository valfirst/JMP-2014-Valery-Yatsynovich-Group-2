package service;

import bean.*;
import dao.WorkUnitDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.Set;


/**
 * Created by Julia on 12/7/14.
 */
public class WorkUnitService<T> extends WorkUnitDao<T> implements IWorkUnitService{

    private static Session session;
    private Transaction transaction;

    @Override
    public void addEmployeeToUnit(int employeeId, int unitId) throws ServiceException {

         if(employeeId <= 0 || unitId <= 0){
             throw new ServiceException("Identifiers are invalid");
         }
         if(session == null){
             session = getCurrentSession();
         }
         this.transaction = session.beginTransaction();
         Employee employee = (Employee) get(Employee.class, employeeId);
         if(employee == null){
             throw new ServiceException("Sorry, but employee with this identifier is not found in our system.");
         }
         Unit unit = (Unit) get(Unit.class, unitId);
         if(unit == null){
             throw new ServiceException("Sorry, but unit with this identifier is not found in our system.");
         }

         employee.setUnit(unit);
         if(!unit.getEmployees().contains(employee)){
             unit.getEmployees().add(employee);
         }

         transaction.commit();

    }

    @Override
    public void assignEmployeeForProject(int employeeId, int projectId) throws ServiceException {

        if(employeeId <= 0 || projectId <= 0){
            throw new ServiceException("Identifiers are invalid");
        }
        if(session == null){
            session = getCurrentSession();
        }
        this.transaction = session.beginTransaction();
        Employee employee = (Employee) get(Employee.class, employeeId);
        if(employee == null){
            throw new ServiceException("Sorry, but employee with this identifier is not found in our system.");
        }

        Project project = (Project) get(Project.class, projectId);
        if(project == null){
            throw new ServiceException("Sorry, but project with this identifier is not found in our system.");
        }

        if(!employee.getProjects().contains(project)){
            employee.getProjects().add(project);
        }
        if(!project.getEmployees().contains(employee)){
            project.getEmployees().add(employee);
        }

        transaction.commit();
    }

    @Override
    public void createEmployee(String first_name, String last_name, String phone_number, Date birthday,
                               String governmentalId, String visa_records, String driver_license_exp,
                               int emp_unit, Set<Address> addresses, EmployeeStatus status,
                               Set<Project> projects) throws ServiceException {

        if(first_name == null || last_name == null || phone_number == null || birthday == null ||
        governmentalId == null || visa_records == null || driver_license_exp == null || emp_unit <= 0){
            throw new ServiceException("One/all of entered parameter/parameters is/are invalid");
        }
        if(session == null){
            session = getCurrentSession();
        }
        this.transaction = session.beginTransaction();

        EmployeePersonalInfo employeePersonalInfo = new EmployeePersonalInfo(first_name, last_name, phone_number,
                birthday, governmentalId, visa_records, driver_license_exp);
        employeePersonalInfo.setEmpl_id(getList(EmployeePersonalInfo.class).size() + 1);

        Unit unit = (Unit) get(Unit.class, emp_unit);
        if(unit == null){
            throw new ServiceException("Entered unit is not found. please, create unit first.");
        }

        Employee employee = new Employee();
        employee.setEmployee_id(getList(Employee.class).size() + 1);
        employee.setUnit(unit);
        employee.setPersonalInfo(employeePersonalInfo);
        employee.setAddresses(addresses);
        employee.setStatus(status);
        employee.setProjects(projects);

        session.save(employee);
        transaction.commit();
    }

    @Override
    public void createUnit(String unit_name, String department) throws ServiceException {
        if(unit_name == null || department == null){
            throw new ServiceException("Invalid parameters are entered.");
        }
        if(session == null){
            session = getCurrentSession();
        }

        Unit unit = new Unit();
        unit.setUnit_id(getList(Unit.class).size() + 1);
        unit.setUnit_name(unit_name);
        unit.setDepartment(department);

        session.save(unit);
        transaction.commit();

    }

    @Override
    public void createProject(String project_name, int unit_id) throws ServiceException {
        if(project_name == null || unit_id <= 0){
            throw new ServiceException("Invalid parameters are entered.");
        }
        if(session == null){
            session = getCurrentSession();
        }
        Unit unit = (Unit) get(Unit.class, unit_id);
        if(unit == null){
            throw new ServiceException("Entered unit is not found. please, create unit first.");
        }

        Project project = new Project();
        project.setProject_id(getList(Project.class).size() + 1);
        project.setName(project_name);
        project.setUnit(unit);

        session.save(project);
        transaction.commit();
    }
}
