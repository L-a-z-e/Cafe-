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

public class MyOrderListActivity extends AppCompatActivity {
    LinearLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_list);
        contentLayout=findViewById(R.id.contentLayout);

        GetMyOrder();
    }
//일반 사용자용 주문 내역확인
    private void GetMyOrder() {
        RestAPI restAPI=new RestAPI(getResources().getString(R.string.ip));
        Call<List<ResponseOrders>> call=restAPI.getRetrofitService().GetMyOrders(LoginActivity.UserID);
        call.enqueue(new Callback<List<ResponseOrders>>() {
            @Override
            public void onResponse(Call<List<ResponseOrders>> call, Response<List<ResponseOrders>> response) {
                if(response.isSuccessful()) {
                    List<ResponseOrders> list=response.body();
                    for(ResponseOrders orders:list) {
                        OrderView orderView=new OrderView(MyOrderListActivity.this);
                        orderView.SetOrderView(orders, false);
                        Log.d("order", orders.toString());
                        contentLayout.addView(orderView);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ResponseOrders>> call, Throwable t) {

            }
        });
    }
}
