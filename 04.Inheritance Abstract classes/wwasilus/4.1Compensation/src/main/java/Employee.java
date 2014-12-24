import java.awt.datatransfer.StringSelection;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public abstract class Employee {
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Date dateOfAcceptanceForWork;
    protected double salaryRate;

    public Employee(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAcceptanceForWork = dateOfAcceptanceForWork;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfAcceptanceForWork() {
        return dateOfAcceptanceForWork;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    abstract public void setSalaryRate(double rate);

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfAcceptanceForWork=" + dateOfAcceptanceForWork +
                ", salaryRate=" + salaryRate +
                '}';
    }
}
