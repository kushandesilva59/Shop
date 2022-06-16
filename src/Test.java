import Entity.Order;
import Entity.OrderDetail;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId("OR006");
        order.setId("2022-06-16");
        order.setCustomerId("C00-002");

        OrderDetail o1 = new OrderDetail();
        o1.setOrderId("OR006");
        o1.setProductId("P00-003");
        o1.setQty(10);
        o1.setUnitPrice(100);
        o1.setOrder(order);

        OrderDetail o2 = new OrderDetail();
        o2.setOrderId("OR006");
        o2.setProductId("P00-004");
        o2.setQty(5);
        o2.setUnitPrice(50);
        o2.setOrder(order);


        order.getOrderDetails().add(o1);
        order.getOrderDetails().add(o2);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();





        transaction.commit();
        session.close();

    }
}
