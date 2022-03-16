package kr.ac.gachon.Project201533745.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kr.ac.gachon.Project201533745.MenuItem;
import kr.ac.gachon.Project201533745.Design.MenuAdapter;
import kr.ac.gachon.Project201533745.R;

//NonCoffee Fragment
public class NonCoffee extends Fragment {

    Context context;
    RecyclerView recyclerView;
    ArrayList<MenuItem> menuItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v=inflater.inflate(R.layout.fragment_non_coffee, container, false);
        context=container.getContext();
        menuItems=new ArrayList<MenuItem>();

        MenuItem n1=new MenuItem(R.drawable.n1,"오레오초코",3500);
        MenuItem n2=new MenuItem(R.drawable.n2,"딸기우유라떼",3500);
        MenuItem n3=new MenuItem(R.drawable.n3,"딸기슈크림프라페",4000);
        MenuItem n4=new MenuItem(R.drawable.n4,"레몬에이드",3000);
        MenuItem n5=new MenuItem(R.drawable.n5,"유니콘매직에이드",3500);
        MenuItem n6=new MenuItem(R.drawable.n6,"플레인요거트스무디",4000);
        MenuItem n7=new MenuItem(R.drawable.n7,"쿠키프라페",4000);
        MenuItem n8=new MenuItem(R.drawable.n8,"망고요거트스무디",4000);
        MenuItem n9=new MenuItem(R.drawable.n9,"유니콘프라페",4500);
        MenuItem n10=new MenuItem(R.drawable.n10,"딸기요거트스무디",4000);
        MenuItem n11=new MenuItem(R.drawable.n11,"민트프라페",4000);
        MenuItem n12=new MenuItem(R.drawable.n12,"초코바나나",3500);

        menuItems.add(n1);
        menuItems.add(n2);
        menuItems.add(n3);
        menuItems.add(n4);
        menuItems.add(n5);
        menuItems.add(n6);
        menuItems.add(n7);
        menuItems.add(n8);
        menuItems.add(n9);
        menuItems.add(n10);
        menuItems.add(n11);
        menuItems.add(n12);

        recyclerView = (androidx.recyclerview.widget.RecyclerView)v.findViewById(R.id.noncoffeeList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter menuAdapter =new MenuAdapter(context,menuItems);
        recyclerView.setAdapter(menuAdapter);

        return v;
    }
}