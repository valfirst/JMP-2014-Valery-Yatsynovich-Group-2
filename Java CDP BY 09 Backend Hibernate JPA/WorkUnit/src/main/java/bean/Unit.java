package bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Julia on 12/6/14.
 */
@Entity
@Table(name = "unit", catalog = "orgchat")
public class Unit {

    @Id
    @Column(name = "unit_id")
    private int unit_id;

    @Column(name = "unit_name")
    private String unit_name;

    @Column(name = "department")
    private String department;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_unit")
    private List<Employee> employees;

    public Unit(){}

    public Unit(String name, String department, List<Employee> employees){
         this.unit_name = name;
        this.department = department;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unit_id=" + unit_id +
                ", unit_name='" + unit_name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
