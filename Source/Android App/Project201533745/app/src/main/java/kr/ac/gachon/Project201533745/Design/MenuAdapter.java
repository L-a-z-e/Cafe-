package kr.ac.gachon.Project201533745.Design;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.gachon.Project201533745.MenuItem;
import kr.ac.gachon.Project201533745.R;
import kr.ac.gachon.Project201533745.menu_details;

//리사이클러뷰 어댑터
public class MenuAdapter extends  RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<MenuItem> menuItems;


    public MenuAdapter(){}
    public MenuAdapter(Context context, ArrayList<MenuItem> menuItems){
        this.context=context;
        this.menuItems=menuItems;

    }




    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        View v;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.menu_Image);
            name = (TextView) view.findViewById(R.id.menu_Name);
            price=(TextView)view.findViewById(R.id.menu_Price);
            v=(View)view.findViewById(R.id.view_menu);

        }



    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_menu, viewGroup, false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        ViewHolder myviewholder=(ViewHolder) viewHolder;




        myviewholder.img.setImageResource(menuItems.get(position).getImg());
        myviewholder.name.setText(menuItems.get(position).getName());
        myviewholder.price.setText(menuItems.get(position).getPrice()+" 원");
        myviewholder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(context, menu_details.class);
                i.putExtra("menuItem",menuItems.get(position));
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }
}
