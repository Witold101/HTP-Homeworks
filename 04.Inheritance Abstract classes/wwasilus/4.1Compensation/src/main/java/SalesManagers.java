import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public class SalesManagers extends Employee {
    private ArrayList<Order> foundOrders;

    public SalesManagers(String name, String surname, Date dateOfBirth, Date dateOfAcceptanceForWork) {
        super(name, surname, dateOfBirth, dateOfAcceptanceForWork);
        this.foundOrders = new ArrayList<Order>();
    }

    public void findOrder(Order order) {
        foundOrders.add(order);
    }

    @Override
    public void setSalaryRate(double percent) {
        salaryRate = percent;
    }

    public BigDecimal calculationSumOrder(Date begin, Date end) {
        BigDecimal summOrder = new BigDecimal("0.0");
        for (Order rezult : foundOrders) {
            if (rezult.getDateOrder().before(end) && rezult.getDateOrder().after(begin)) {
                summOrder = summOrder.add(rezult.getPrice());
            }
        }
        return summOrder;
    }

    public BigDecimal calculationSalaryRate(BigDecimal sumOrder) {
        BigDecimal salaryRate = new BigDecimal(super.getSalaryRate());
        return ((sumOrder.multiply(salaryRate)).divide(new BigDecimal("100.0"))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String toString() {
        String rezult = "";
        for (Order order : foundOrders) {
            rezult = rezult +"\n"+ "numberOrder - " + order.getNumberOrder() + " price - " + order.getPrice() + " date - " + order.getDateOrder();
        }
        return super.toString() + "SalesManagers{" + rezult + '}';
    }
}
