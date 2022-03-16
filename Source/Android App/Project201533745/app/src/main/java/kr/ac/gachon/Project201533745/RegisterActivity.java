package kr.ac.gachon.Project201533745;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import kr.ac.gachon.Project201533745.Rest.RequestRegister;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    String tag = getClass().getSimpleName();
    Button RegistButton;
    EditText userid, email, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegistButton = (Button) findViewById(R.id.registbutton);
        userid = (EditText) findViewById(R.id.userid);
        email = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password1);

        RegistButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            Register();

            }
        });

    }
//회원가입
    private void Register() {
        if (userid.getText().toString().length() == 0) {
            Toast.makeText(this, "ID를 입력하세요", Toast.LENGTH_SHORT).show();
        } else if (email.getText().toString().length() == 0) {
            Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
        } else if (password1.getText().toString().length() == 0) {
            Toast.makeText(this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
        } else
         {
            RestAPI restAPI = new RestAPI(getString(R.string.ip));
            Call<RequestRegister> call = restAPI.getRetrofitService().PostRegister(new RequestRegister(userid.getText().toString(), password1.getText().toString(), email.getText().toString()));
            call.enqueue(new Callback<RequestRegister>() {
                @Override
                public void onResponse(Call<RequestRegister> call, Response<RequestRegister> response) {
                    if (response.isSuccessful()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "회원가입 되었습니다.", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }

                @Override
                public void onFailure(Call<RequestRegister> call, Throwable t) {
                    Log.e(tag, t.getMessage());
                }
            });
        }

    }
}




