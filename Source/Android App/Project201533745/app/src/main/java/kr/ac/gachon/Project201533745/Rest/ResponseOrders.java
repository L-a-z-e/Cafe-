package kr.ac.gachon.Project201533745.Rest;

//주문 응답 클래스
public class ResponseOrders {
    String UserID;
    String Contents;
    int Price;
    int status;
    int OrderID;

    public ResponseOrders(String userID, String contents, int price,  int status, int orderID) {
        UserID = userID;
        Contents = contents;
        Price = price;

        this.status = status;
        OrderID = orderID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    @Override
    public String toString() {
        return "ResponseOrders{" +
                "UserID='" + UserID + '\'' +
                ", Contents='" + Contents + '\'' +
                ", Price=" + Price +
                ", status=" + status +
                '}';
    }
}
