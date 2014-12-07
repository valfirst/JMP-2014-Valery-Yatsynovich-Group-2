package bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Julia on 12/6/14.
 */
@Entity
@Table(name = "employee", catalog = "orgchat")
public class Employee {

    @Id
    @Column(name = "empl_id")
    private int employee_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_id")
    private EmployeePersonalInfo personalInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_unit")
    private Unit unit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employeesprojects",
            joinColumns = {@JoinColumn(name = "empl_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<Project>();

    private EmployeeStatus status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employeesaddresses",
                joinColumns = {@JoinColumn(name = "empl_id")},
                inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> addresses = new HashSet<Address>();

    public Employee(){}

    public Employee(EmployeePersonalInfo info, Unit unit, Set<Project> projects, Set<Address> addresses){
        this.personalInfo = info;
        this.unit = unit;
        this.projects = projects;
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public EmployeePersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(EmployeePersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", personalInfo=" + personalInfo +
                ", unit=" + unit +
                ", status=" + status +
                '}';
    }
}
