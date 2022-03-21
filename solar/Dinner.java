@Service
public class Dinner {
    private final DeliveryCenter deliveryCenter;

    public void orderDinner(User user, Order order) {
        DinnerCart dinnerCart = orderFood();
        deliveryCenter.deliverOrder(DinnerCart dinnerCart, User user);
    }

    private DinnerCart orderFood(Order order) {
        Food appitizer = new Appitizer(order);
        Food mainDish = new Main(order);
        Food dessert = new Dessert(order);
        return DinnerCart.of(appitizer,mainDish,dessert);
    }
}