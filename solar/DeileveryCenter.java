@Service
public class DeliveryCenter {
    public void deliverOrder(DinnerCart dinnerCart, User user) {
        checkDeliveryCondition(dinnerCart, user);
        CallResult callResult = callRiders();
        if (callResult.isSuccess()) {
            deliverOrder();
        }
    }

    private void checkDeliveryCondition(DinnerCart dinnerCart, User user) {
        if (dinnerCart.isOverWeight()) {
            throw new OrderException("주문이 불가능합니다.");
        }
        if (user.isAbuser()) {
            throw new OrderException("주문이 불가능합니다.");
        }
    }

    private CallResult callRiders() {
        if(Callcenter.getAnyRiders().hasRiders()) {
            return CallResult.ofSuccess();
        }
        return CallResult.ofFail();
    }

    private void deliverOrder(DinnerCart dinnerCart, User user) {
        log.info("저녁 배달 시작");
    }
}