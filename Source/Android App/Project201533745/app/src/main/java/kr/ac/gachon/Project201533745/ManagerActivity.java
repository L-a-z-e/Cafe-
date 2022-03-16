package kr.ac.gachon.Project201533745;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.List;

import kr.ac.gachon.Project201533745.Design.OrderView;
import kr.ac.gachon.Project201533745.Rest.ResponseOrders;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerActivity extends AppCompatActivity {
    RestAPI restAPI;
    String tag = getClass().getSimpleName();
    LinearLayout orderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        orderLayout = findViewById(R.id.orderLayout);

        init();
    }
//총 주문 목록 받아오기
    private void init() {
        restAPI = new RestAPI(getString(R.string.ip));
        Call<List<ResponseOrders>> call = restAPI.getRetrofitService().GetOrders();
        call.enqueue(new Callback<List<ResponseOrders>>() {
            @Override
            public void onResponse(Call<List<ResponseOrders>> call, Response<List<ResponseOrders>> response) {
                if (response.isSuccessful()) {
                    List<ResponseOrders> responseOrders = response.body();
                    for (ResponseOrders order : responseOrders) {
                        //응답받은 데이터를 화면에 표시
                        Log.d(tag, order.toString());
                        OrderView orderView = new OrderView(ManagerActivity.this);
                        orderView.SetOrderView(order, true);
                        orderLayout.addView(orderView);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ResponseOrders>> call, Throwable t) {

            }
        });
    }
}
