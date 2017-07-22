package rashjz.info.com.az.domain;

public class OrderDelivery {
    String mob1;
    String mob2;
    String orderId;
    String metroID;

    public OrderDelivery() {
    }

    public String getMob1() {
        return mob1;
    }

    public void setMob1(String mob1) {
        this.mob1 = mob1;
    }

    public String getMob2() {
        return mob2;
    }

    public void setMob2(String mob2) {
        this.mob2 = mob2;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMetroID() {
        return metroID;
    }

    public void setMetroID(String metroID) {
        this.metroID = metroID;
    }

    @Override
    public String toString() {
        return "OrderDelivery{" +
                "mob1='" + mob1 + '\'' +
                ", mob2='" + mob2 + '\'' +
                ", orderId='" + orderId + '\'' +
                ", metroID='" + metroID + '\'' +
                '}';
    }
}
