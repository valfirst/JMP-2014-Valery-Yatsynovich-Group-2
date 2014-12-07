package service;

import bean.Address;
import bean.EmployeeStatus;
import bean.Project;

import java.util.Date;
import java.util.Set;

/**
 * Created by Julia on 12/7/14.
 */
public interface IWorkUnitService {

    void addEmployeeToUnit(int employeeId, int unitId) throws ServiceException;
    void assignEmployeeForProject(int employeeId, int projectId) throws ServiceException;
    void createEmployee(String first_name, String last_name, String phone_number, Date birthday, String governmentalId, String visa_records, String driver_license_exp, int emp_unit, Set<Address> addresses, EmployeeStatus status,
                        Set<Project> projects) throws ServiceException;
    void createUnit(String unit_name, String department) throws ServiceException;
    void createProject(String project_name, int unit) throws ServiceException;



}
