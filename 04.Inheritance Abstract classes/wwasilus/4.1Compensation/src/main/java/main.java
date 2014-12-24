import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Witold on 07.12.2014.
 */
public class main {
    public static void main(String[] args) {
        Random random = new Random();

        String dateString = "03.11.1980";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateBossDay = format.parse(dateString, new ParsePosition(0));
        Date dateBossWork = format.parse("05.07.2013", new ParsePosition(0));
        Boss boss = new Boss("Петров", "Василий", dateBossDay, dateBossWork);
        boss.setSalaryRate(150.0);

        SalesManagers salesManager = new SalesManagers("Иванов", "Василий", dateBossDay, dateBossWork);
        salesManager.setSalaryRate(3);

        Date beginDate = format.parse("03.10.2013", new ParsePosition(0));
        Date endDate = format.parse("08.12.2014", new ParsePosition(0));

        int numberHeadOfTeams = random.nextInt(5) + 3;

        for (int i = 0; i < numberHeadOfTeams; i++) {
            boss.setTeams(new HeadOfTeams("Иван " + i, "Иванов", dateBossDay, dateBossWork));
            boss.getTeams().get(i).setSalaryRate(100.0);
            for (int ii = 0; ii < random.nextInt(10) + 5; ii++) {
                boss.getTeams().get(i).setDevelopers(new Developers("Сергей " + ii, "Программист", dateBossDay, dateBossWork));
                boss.getTeams().get(i).getDevelopers().get(ii).setSalaryRate(50.0);
            }
            for (int ii = 0; ii < random.nextInt(5) + 1; ii++) {
                boss.getTeams().get(i).setSalesManagerses(new SalesManagers("Андрей " + ii, "Менеджер", dateBossDay, dateBossWork));
                boss.getTeams().get(i).getSalesManagerses().get(ii).setSalaryRate(3);
                for (int i1 = 0; i1 < random.nextInt(20); i1++) {
                    String stringDate = "" + (random.nextInt(30) + 1) + "." + (random.nextInt(11) + 1) + "." + (random.nextInt(3) + 2012);
                    Date randomDate = format.parse(stringDate, new ParsePosition(0));
                    boss.getTeams().get(i).getSalesManagerses().get(ii).findOrder(new Order(i1, new BigDecimal(random.nextInt(10000) + 1000), randomDate));
                }
            }
        }

        System.out.println("Заработок боса - " + boss.calculationSalaryRate(beginDate, endDate));
        for (HeadOfTeams headOfTeams : boss.getTeams()) {
            System.out.println("Заработок руководителя проекта - " + headOfTeams.getName() +
                    " = " + headOfTeams.calculationSalaryRate(beginDate, endDate));
            System.out.println("Общий зароботок всех программистов - " + headOfTeams.calculationSalaryRateDevelopers(beginDate, endDate));
            for (Developers developers : headOfTeams.getDevelopers()) {
                System.out.println("Заработок программиста - " + developers.getName() + " = " +
                        developers.calculationSalaryRate(beginDate, endDate));
            }
            for (SalesManagers salesManagers : headOfTeams.getSalesManagerses()) {
                System.out.println("Заработок менеджера - " + salesManagers.getName() + " = " +
                        salesManagers.calculationSalaryRate(salesManagers.calculationSumOrder(beginDate, endDate)));
                System.out.println(salesManagers.toString());
            }
        }

       System.out.println("Вся зарплата - " + boss.calculationSalaryRateAll(beginDate, endDate));
    }
}
