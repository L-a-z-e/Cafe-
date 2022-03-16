package kr.ac.gachon.Project201533745.Rest;

import java.io.Serializable;

//로그인 응답 결과 저장
public class ResponseLogin implements Serializable {
    String ID;
    int Manager;

    public ResponseLogin(String ID, int manager) {
        this.ID = ID;
        Manager = manager;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getManager() {
        return Manager;
    }

    public void setManager(int manager) {
        Manager = manager;
    }
}

