package kr.ac.gachon.Project201533745;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import kr.ac.gachon.Project201533745.Rest.RequestOrder;
import kr.ac.gachon.Project201533745.Rest.ResponseResult;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import kr.ac.gachon.Project201533745.Sqlite.DbOpenHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayActivity extends AppCompatActivity {
    EditText cardEt, MonthEt, YearEt, cvvEt, nameEt;
    CheckBox saveCb;
    Button payBtn;
    String number, name;
    int month, year, cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        cardEt = findViewById(R.id.cardEt);
        MonthEt = findViewById(R.id.expMonth);
        YearEt = findViewById(R.id.expYear);
        cvvEt = findViewById(R.id.cvv);
        nameEt = findViewById(R.id.nameEt);
        saveCb = findViewById(R.id.saveCb);
        payBtn = findViewById(R.id.payBtn);


        GetCard();
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pay();
            }
        });
    }
//save card 체크시 변수 저장 메서드
    private void setAll() {
        number = cardEt.getText().toString();
        month = Integer.parseInt(MonthEt.getText().toString());
        year = Integer.parseInt(YearEt.getText().toString());
        cvv = Integer.parseInt(cvvEt.getText().toString());
        name = nameEt.getText().toString();
    }
// 저장된 변수 SQLite DB에 저장
    private void SaveCard() {
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this, "card", null, 1);
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        dbOpenHelper.newCard(database, number, month, year, cvv, name);
        database.close();
        dbOpenHelper.close();
    }
//결제시 주문요청, 카드 저장(체크시) 수행
    private void Pay() {
        setAll();
        if(saveCb.isChecked()) {
            SaveCard();
        }
        Order();
    }
//저장된 카드 정보 가져오기
    private void GetCard() {
        DbOpenHelper openHelper=new DbOpenHelper(this, "card", null, 1);
        SQLiteDatabase database=openHelper.getWritableDatabase();

        String query="select * from card";
        Cursor cursor=database.rawQuery(query, null);
        if(cursor.getCount()!=0) {
            cursor.moveToNext();
            number=cursor.getString(0);
            month=cursor.getInt(1);
            year=cursor.getInt(2);
            cvv=cursor.getInt(3);
            name=cursor.getString(4);

            cardEt.setText(number);
            MonthEt.setText(Integer.toString(month));
            YearEt.setText(Integer.toString(year));
            cvvEt.setText(Integer.toString(cvv));
            nameEt.setText(name);
        }

        cursor.close();
        database.close();
        openHelper.close();
    }
    //주문하기
    private void Order() {
        RestAPI restAPI=new RestAPI(getResources().getString(R.string.ip));
      Call<ResponseResult> call=restAPI.getRetrofitService().PostOrder(new RequestOrder(LoginActivity.UserID, MainActivity.orderArrayList));
      call.enqueue(new Callback<ResponseResult>() {
          @Override
          public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
              if(response.isSuccessful()) {
                  if(response.body().getResult().equals("Ok")) {
                      Toast.makeText(PayActivity.this, "결제가 완료되었습니다", Toast.LENGTH_SHORT).show();
                      finish();
                  }
              } else
                  Toast.makeText(PayActivity.this, "결제에 실패하였습니다", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onFailure(Call<ResponseResult> call, Throwable t) {
              Toast.makeText(PayActivity.this, "서버연결에 실패했습니다", Toast.LENGTH_SHORT).show();
          }
      });
    }
}
