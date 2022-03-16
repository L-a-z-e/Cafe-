package kr.ac.gachon.Project201533745.Rest;

import java.util.List;
import kr.ac.gachon.Project201533745.Order;

//주문 요청 파라미터 전송
public class RequestOrder {
    String UserID;
    List<Order> Orders;

    public RequestOrder(String userID, List<Order> orders) {
        UserID = userID;
        Orders = orders;
    }
    public String getUserID() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }
    public List<Order> getOrders() {
        return Orders;
    }
    public void setOrders(List<Order> orders) {
        Orders = orders;
    }
}
