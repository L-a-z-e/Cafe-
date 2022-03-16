package kr.ac.gachon.Project201533745;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class menu_details extends AppCompatActivity {
    ImageView img;
    TextView name, price, NumTv;
    Button minusBtn, plusBtn, addOrderBtn, orderBtn;
    CheckBox shotCb, syrupCb, iceCb;
    int number = 1;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        img = (ImageView) findViewById(R.id.imageView_menu);
        name = (TextView) findViewById(R.id.tvName);
        price = (TextView) findViewById(R.id.tvWon);

        menuItem = (MenuItem) getIntent().getSerializableExtra("menuItem");
        img.setImageResource(menuItem.getImg());
        name.setText(menuItem.getName());
        price.setText(menuItem.getPrice() + "원");


        plusBtn = findViewById(R.id.btnPlus);
        minusBtn = findViewById(R.id.btnMinus);
        NumTv = findViewById(R.id.tvNumber);

        shotCb = findViewById(R.id.shotCb);
        syrupCb = findViewById(R.id.syrupCb);
        iceCb = findViewById(R.id.iceCb);

        addOrderBtn = findViewById(R.id.addOrderBtn);
        orderBtn = findViewById(R.id.orderBtn);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPlus();
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numMinus();
            }
        });

        addOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOrder();
            }
        });
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_details.this, OrderList.class);
                startActivity(intent);
                AddOrder();
            }
        });
    }
    //수량 추가
    private void numPlus() {
        number++;
        NumTv.setText(Integer.toString(number));
    }
    //수량 감소
    private void numMinus() {
        if (number >= 1) {
            number--;
            NumTv.setText(Integer.toString(number));
        }
    }

    //주문표에 추가
    private void AddOrder() {
        Order order = new Order(menuItem, shotCb.isChecked(), syrupCb.isChecked(), iceCb.isChecked(), number);
        MainActivity.orderArrayList.add(order);
        Toast.makeText(this, "주문표에 추가되었습니다", Toast.LENGTH_SHORT).show();
        finish();
    }
}
