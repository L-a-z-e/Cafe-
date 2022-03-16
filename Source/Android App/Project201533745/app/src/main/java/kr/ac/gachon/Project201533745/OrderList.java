package kr.ac.gachon.Project201533745;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.ac.gachon.Project201533745.Design.OrderAdapter;
import kr.ac.gachon.Project201533745.Rest.ResponseResult;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import kr.ac.gachon.Project201533745.Rest.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderList extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView priceTv;
    Button addMenuBtn, orderBtn;
//주문전 장바구니 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.recyclerView);
        priceTv = findViewById(R.id.priceTv);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter(this, MainActivity.orderArrayList);
        recyclerView.setAdapter(orderAdapter);

        SetPriceTv();

        addMenuBtn = findViewById(R.id.addMenuBtn);
        orderBtn = findViewById(R.id.orderBtn);

        addMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(OrderList.this, PayActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SetPriceTv() {
        int price = 0;
        for (Order order : MainActivity.orderArrayList) {
            price += order.getPrice();
        }
        priceTv.setText(price + " 원");
    }


}
