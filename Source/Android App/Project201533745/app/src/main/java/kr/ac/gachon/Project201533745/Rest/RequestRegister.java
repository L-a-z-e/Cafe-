package kr.ac.gachon.Project201533745.Rest;


//회원가입 요청 파라미터 전송
public class RequestRegister {
    String ID, Password, Email;

    public RequestRegister(String ID, String password, String email) {
        this.ID = ID;
        Password = password;
        Email = email;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
