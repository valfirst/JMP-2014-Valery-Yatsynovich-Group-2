package Model;

/**
 * Created by Julia on 10/25/14.
 */
public class Person {

    private double id;
    private Account account;

    public Person(){
        this.id = Math.random();
    }

    public Person(Account account){
        this.id = Math.random();
        this.account = account;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", account=" + account +
                '}';
    }
}
