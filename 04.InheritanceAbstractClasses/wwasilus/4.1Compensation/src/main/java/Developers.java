import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public class Developers extends Employee {

    private ArrayList<String> technology;

    public Developers(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        super(name, surname, dateOfBirth, dateOfAcceptanceForWork);
        technology = new ArrayList<String>();
    }

    public ArrayList<String> getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology.add(technology);
    }

    @Override
    public void setSalaryRate(double rate) {
        super.salaryRate = rate;
    }

    public BigDecimal calculationSalaryRate(Date begin, Date end) {
        if (begin.before(super.getDateOfAcceptanceForWork())) {
            begin = super.getDateOfAcceptanceForWork();
        }
        if (super.getDateOfAcceptanceForWork().after(end)) {
            return new BigDecimal("0.00");
        } else {
            BigDecimal sumDays = new BigDecimal((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000));
            return sumDays.multiply(new BigDecimal(super.getSalaryRate())).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
    }
}
