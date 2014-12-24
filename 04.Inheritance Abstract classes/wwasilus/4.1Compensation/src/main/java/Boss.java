import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public class Boss extends Employee {
    private ArrayList<HeadOfTeams> teams;

    public Boss(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        super(name, surname, dateOfBirth, dateOfAcceptanceForWork);
        teams = new ArrayList<HeadOfTeams>();
    }

    public ArrayList<HeadOfTeams> getTeams() {
        return teams;
    }

    public void setTeams(HeadOfTeams team) {
        this.teams.add(team);
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

    public BigDecimal calculationSalaryRateAll(Date begin, Date end) {
        BigDecimal rateDevelopers = new BigDecimal("0.0");
        for (HeadOfTeams headOfTeams : getTeams()) {
            rateDevelopers = rateDevelopers.add(headOfTeams.calculationSalaryRate(begin, end));
            for (Developers developer : headOfTeams.getDevelopers()) {
                rateDevelopers = rateDevelopers.add(developer.calculationSalaryRate(begin, end));
            }
            for (SalesManagers salesManagers : headOfTeams.getSalesManagerses()) {
                rateDevelopers = rateDevelopers.add(salesManagers.calculationSalaryRate(salesManagers.calculationSumOrder(begin,end)));
            }
        }
        return rateDevelopers.add(calculationSalaryRate(begin, end));
    }


}
