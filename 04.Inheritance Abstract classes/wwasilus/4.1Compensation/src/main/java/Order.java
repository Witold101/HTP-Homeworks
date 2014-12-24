import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Witold on 07.12.2014.
 */
public class Order {
    private int numberOrder;
    private BigDecimal price;
    private Date dateOrder;
    private Date dateExecutions;

    public enum StatusOrder {ACCEPTED, EXECUTED}

    private StatusOrder status;

    public Order(int numberOrder, BigDecimal price, Date dateOrder) {
        this.price = price;
        this.dateOrder = dateOrder;
        this.status = StatusOrder.ACCEPTED;
        this.numberOrder = numberOrder;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public Date getDateExecutions() {
        return dateExecutions;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void executionOrder(Date date) {
        this.dateExecutions = date;
        this.status = StatusOrder.EXECUTED;
    }
}
