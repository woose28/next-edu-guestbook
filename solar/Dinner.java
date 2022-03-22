@Service
public class Dinner {
    private final DeliveryCenter deliveryCenter;

    public void orderDinner(User user, Order order) {
        checkPreCondition(user, order);
        DinnerCart dinnerCart = orderFood();
        deliveryCenter.deliverOrder(DinnerCart dinnerCart, User user);
    }

    private void checkPreCondition(User user, Order order) {
        checkUserCondition(user);
        checkOrderCondition(order);
    }

    private void checkUserCondition(User user) {
        private static int MAX_ABUSE_COUNT = 5;
        if (user.getAbuseHistory().length > MAX_ABUSE_COUNT) {
            throw new OrderException("주문이 불가능합니다.");
        }
    }

    private void checkOrderCondition(Order order) {
        if (order.isInValidOrderTime() && order.isInValidPrice()) {
            throw new OrderException("주문이 불가능합니다.");
        }
    }

    private DinnerCart orderFood(Order order) {
        Food appitizer = new Appitizer(order);
        Food mainDish = new Main(order);
        Food dessert = new Dessert(order);
        return DinnerCart.of(appitizer,mainDish,dessert);
    }
}