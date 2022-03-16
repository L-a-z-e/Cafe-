package kr.ac.gachon.Project201533745.Design;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.gachon.Project201533745.MainActivity;
import kr.ac.gachon.Project201533745.MenuItem;
import kr.ac.gachon.Project201533745.Order;
import kr.ac.gachon.Project201533745.OrderList;
import kr.ac.gachon.Project201533745.R;
import kr.ac.gachon.Project201533745.menu_details;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>  {

    Context context;
    LayoutInflater inflater;
    ArrayList<Order> orderArrayList;

    public OrderAdapter(Context context, ArrayList<Order> orderArrayList) {
        this.context = context;
        this.orderArrayList = orderArrayList;
    }

    public OrderAdapter() {
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView img;
        TextView contentTv;
        Button removeBtn;
        View v;
        public ViewHolder(View view) {
            super(view);
            img=view.findViewById(R.id.menuImage);
            contentTv=view.findViewById(R.id.contentTv);
            removeBtn=view.findViewById(R.id.removeBtn);
        }

    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_order_normal, viewGroup, false);
        context=viewGroup.getContext();
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder viewHolder, final int position) {
        OrderAdapter.ViewHolder myviewholder=(OrderAdapter.ViewHolder) viewHolder;
        String content="";
        content+=orderArrayList.get(position).getMenuItem().getName()+"\t";
        content+=orderArrayList.get(position).getPrice()+"\n(";
        if(!orderArrayList.get(position).isIce()&&!orderArrayList.get(position).isShot()&&!orderArrayList.get(position).isSyrup()) {
            content+="선택 안함";
        } else {
            if(orderArrayList.get(position).isShot())
                content+="샷추가, ";
            if(orderArrayList.get(position).isSyrup())
                content+="시럽추가, ";
            if(orderArrayList.get(position).isIce())
                content+="아이스, ";
            content=content.substring(0, content.length()-2);
        }
        content+=")";

        myviewholder.img.setImageResource(orderArrayList.get(position).getMenuItem().getImg());
        myviewholder.contentTv.setText(content);

        //메뉴 삭제
        myviewholder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.orderArrayList.remove(position);
                Intent intent=new Intent(context, OrderList.class);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }
}
