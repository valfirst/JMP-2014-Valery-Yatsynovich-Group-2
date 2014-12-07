package bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Julia on 12/6/14.
 */
@Entity
@Table(name = "address", catalog = "orgchat")
public class Address {

    @Id
    @Column(name = "address_id")
    private int address_id;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private int building;

    @Column(name = "department")
    private int department;

    @Column(name = "apt")
    private int apt;

    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    private Set<Employee> employee = new HashSet<Employee>();

    public Address(){}

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getApt() {
        return apt;
    }

    public void setApt(int apt) {
        this.apt = apt;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", department=" + department +
                ", apt=" + apt +
                '}';
    }
}
