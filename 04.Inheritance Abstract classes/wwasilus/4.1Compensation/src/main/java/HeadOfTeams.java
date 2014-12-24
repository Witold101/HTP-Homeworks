import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public class HeadOfTeams extends Employee {

    private ArrayList<Developers> developers;
    private ArrayList<SalesManagers> salesManagerses;

    public HeadOfTeams(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        super(name, surname, dateOfBirth, dateOfAcceptanceForWork);
        developers = new ArrayList<Developers>();
        salesManagerses=new ArrayList<SalesManagers>();
    }

    public ArrayList<Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developers developer) {
        developers.add(developer);
    }

    public ArrayList<SalesManagers> getSalesManagerses() {
        return salesManagerses;
    }

    public void setSalesManagerses(SalesManagers salesManagerses) {
        this.salesManagerses.add(salesManagerses);
    }

    @Override
    public void setSalaryRate(double rate) {
        salaryRate = rate;
    }

    public BigDecimal calculationSalaryRate(Date begin, Date end) {
        if (begin.before(getDateOfAcceptanceForWork())) {
            begin = getDateOfAcceptanceForWork();
        }
        if (getDateOfAcceptanceForWork().after(end)) {
            return new BigDecimal("0.00");
        } else {
            BigDecimal sumDays = new BigDecimal((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000));
            return sumDays.multiply(new BigDecimal(getSalaryRate())).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
    }

    public BigDecimal calculationSalaryRateDevelopers(Date begin, Date end) {
        BigDecimal rateDevelopers = new BigDecimal("0.0");
        for (Developers developer : getDevelopers()) {
            rateDevelopers = rateDevelopers.add(developer.calculationSalaryRate(begin, end));
        }
        return rateDevelopers;
    }

}
