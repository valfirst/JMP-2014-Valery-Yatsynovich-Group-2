package bean;

/**
 * Created by Julia on 12/6/14.
 */
public enum EmployeeStatus {

    STUDENT("Student"),
    FULL_TIME("Full time employee"),
    PART_TIME("Part time employee"),
    NOT_ACTIVE("Not active");


    private String status;

    EmployeeStatus(String empStatus){
        this.status = empStatus;
    }

    public String getStatus(){
        return this.status;
    }
}
