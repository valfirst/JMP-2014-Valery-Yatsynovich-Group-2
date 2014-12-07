package bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Julia on 12/6/14.
 */
@Entity
@Table(name = "project", catalog = "orgchat")
public class Project {

    @Id
    @Column(name = "project_id")
    private int project_id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "unit")
    private Unit unit;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<Employee>();

    public Project(){}

    public Project(String name, Unit unit, Set<Employee> employees){
        this.name = name;
        this.unit = unit;
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}
