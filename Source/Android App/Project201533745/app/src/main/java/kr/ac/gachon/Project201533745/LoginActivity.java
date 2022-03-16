package kr.ac.gachon.Project201533745;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import kr.ac.gachon.Project201533745.Rest.RequestLogin;
import kr.ac.gachon.Project201533745.Rest.ResponseLogin;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText idEt, PwEt;
    Button loginBtn,registerbtn;
    String tag = getClass().getSimpleName();
    public static String UserID;
    String token=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEt = findViewById(R.id.userid_main);
        PwEt = findViewById(R.id.password_main);
        loginBtn = findViewById(R.id.loginbtn);
        registerbtn = findViewById(R.id.registerbtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        getToken();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
//로그인 (매니저 or 일반 사용자 구분)
    private void Login() {
        if (idEt.getText().toString().length() == 0) {
            Toast.makeText(this, "ID를 입력하세요", Toast.LENGTH_SHORT).show();
        } else if (PwEt.getText().toString().length() == 0) {
            Toast.makeText(this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
        } else {
            RestAPI restAPI = new RestAPI(getString(R.string.ip));
            Call<ResponseLogin> call = restAPI.getRetrofitService().PostLogin(new RequestLogin(idEt.getText().toString(), PwEt.getText().toString(), token));
            call.enqueue(new Callback<ResponseLogin>() {
                //서버 연결 성공
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    Log.d(tag, "서버 응답 완료");
                    //제대로된 응답을 받아 왔을 때
                    if (response.isSuccessful()) {
                        Log.d(tag, "결과 있음");
                        ResponseLogin responseLogin = response.body();
                        UserID = responseLogin.getID();

                        Intent intent;
                        //사용자의 직급에 따라 다른 액티비티로 이동
                        if (response.body().getManager() != 1) {
                            intent = new Intent(LoginActivity.this, MainActivity.class);
                        } else {
                            intent = new Intent(LoginActivity.this, ManagerActivity.class);
                        }
                        intent.putExtra("responseLogin", responseLogin);
                        startActivity(intent);
                        finish();
                    }
                }

                //서버 연결 실패
                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Log.e(tag, t.getMessage());
                }
            });
        }
    }
//fcm용 토큰
    private void getToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {

                            return;
                        }

                        // Get new Instance ID token
                        token = task.getResult().getToken();
                        Log.e("token", token);
                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token)

                    }
                });
    }
}
