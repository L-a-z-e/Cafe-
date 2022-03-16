package kr.ac.gachon.Project201533745.Rest;

//로그인 요청 파라미터 전송
public class RequestLogin {
    String ID, Password;
    String Token;

    public RequestLogin(String ID, String password, String token) {
        this.ID = ID;
        Password = password;
        Token = token;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
