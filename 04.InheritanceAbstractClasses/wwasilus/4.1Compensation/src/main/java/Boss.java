import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Witold on 07.12.2014.
 */
public class Boss extends Employee {
    private List<TeamLeader> teams;

    public Boss(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        super(name, surname, dateOfBirth, dateOfAcceptanceForWork);
        teams = new ArrayList<TeamLeader>();
    }

    public List<TeamLeader> getTeams() {
        return teams;
    }

    public void setTeams(TeamLeader team) {
        this.teams.add(team);
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

    public BigDecimal calculationSalaryRateAll(Date begin, Date end) {
        BigDecimal rateDevelopers = new BigDecimal("0.0");
        for (TeamLeader teamLeader : getTeams()) {
            rateDevelopers = rateDevelopers.add(teamLeader.calculationSalaryRate(begin, end));
            for (Developers developer : teamLeader.getDevelopers()) {
                rateDevelopers = rateDevelopers.add(developer.calculationSalaryRate(begin, end));
            }
            for (SalesManagers salesManagers : teamLeader.getSalesManagerses()) {
                rateDevelopers = rateDevelopers.add(salesManagers.calculationSalaryRate(
                        salesManagers.calculationSumOrder(begin, end)));
            }
        }
        return rateDevelopers.add(calculationSalaryRate(begin, end));
    }
}
