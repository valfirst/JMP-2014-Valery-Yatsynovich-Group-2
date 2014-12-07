package bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Julia on 12/6/14.
 */
@Entity
@Table(name = "personal_info", catalog = "orgchat")
public class EmployeePersonalInfo {

    @Id
    @Column(name = "empl_id")
    private int empl_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_id")
    private Employee employee;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "governmentalId")
    private String governmentalId;

    @Column(name = "visa_records")
    private String visa_records;

    @Column(name = "driver_license_exp")
    private String driver_license_exp;

    public EmployeePersonalInfo(){}

    public EmployeePersonalInfo(String first_name, String last_name, String phone, Date birthday,
                                String governmentalId, String visa_records, String driver_license_exp){
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone;
        this.birthday = birthday;
        this.governmentalId = governmentalId;
        this.visa_records = visa_records;
        this.driver_license_exp = driver_license_exp;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGovernmentalId() {
        return governmentalId;
    }

    public void setGovernmentalId(String governmentalId) {
        this.governmentalId = governmentalId;
    }

    public String getVisa_records() {
        return visa_records;
    }

    public void setVisa_records(String visa_records) {
        this.visa_records = visa_records;
    }

    public String getDriver_license_exp() {
        return driver_license_exp;
    }

    public void setDriver_license_exp(String driver_license_exp) {
        this.driver_license_exp = driver_license_exp;
    }

    @Override
    public String toString() {
        return "EmployeePersonalInfo{" +
                "empl_id=" + empl_id +
                ", employee=" + employee +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", birthday=" + birthday +
                ", governmentalId='" + governmentalId + '\'' +
                ", visa_records='" + visa_records + '\'' +
                ", driver_license_exp='" + driver_license_exp + '\'' +
                '}';
    }
}
