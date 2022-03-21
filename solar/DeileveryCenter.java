@Service
public class DeliveryCenter {
    public void deliverOrder(DinnerCart dinnerCart, User user) {
        deliverOrder();
    }

    private void deliverOrder(DinnerCart dinnerCart, User user) {
        log.info("저녁 배달 시작");
    }
}