package kr.ac.gachon.Project201533745.Design;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.ac.gachon.Project201533745.ManagerActivity;
import kr.ac.gachon.Project201533745.R;
import kr.ac.gachon.Project201533745.Rest.ResponseOrders;
import kr.ac.gachon.Project201533745.Rest.ResponseResult;
import kr.ac.gachon.Project201533745.Rest.RestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderView extends RelativeLayout {
    TextView personTv, orderTv, priceTv;
    Button confirmBtn;
    Context context;
    int OrderID;

    public OrderView(Context context) {
        super(context);
        init(context);
    }

    public OrderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    //커스텀 뷰에 있는 객체 초기화
    private void init(Context context) {
        this.context = context;
        //다른 xml파일을 이용하기 위해서 사용
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //화면을 표시할 뷰
        View view = inflater.inflate(R.layout.view_order_manager, OrderView.this, false);
        //해당 뷰 안에 있을 뷰들
        personTv = view.findViewById(R.id.personTv);
        orderTv = view.findViewById(R.id.orderTv);
        priceTv = view.findViewById(R.id.priceTv);
        confirmBtn = view.findViewById(R.id.confirmBtn);
        //최상단 뷰를 표시
        addView(view);
    }

    //내용 설정
    public void SetOrderView(ResponseOrders order, boolean manager) {
        personTv.setText("주문자: "+order.getUserID());
        String content=order.getContents();
        content=content.replace(",", "\n");
        orderTv.setText("주문내역: "+content);
        priceTv.setText("총 가격:"+order.getPrice());
        OrderID=order.getOrderID();

        if(manager) {
            if(order.getStatus()==1) {
                confirmBtn.setEnabled(false);
                confirmBtn.setText("수령완료");
            } else {
                confirmBtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SetStatusDone();
                    }
                });}
        } else {
            confirmBtn.setVisibility(GONE);
        }

    }
//완료상태로 변경
    private void SetStatusDone() {
        RestAPI restAPI=new RestAPI(context.getResources().getString(R.string.ip));
        Call<ResponseResult> call=restAPI.getRetrofitService().UpdateStatus(OrderID);
        call.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                if(response.isSuccessful()) {
                    if(response.body().getResult().equals("Ok")) {
                        Toast.makeText(context, "상태가 변경되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, ManagerActivity.class);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {

            }
        });
    }
}
