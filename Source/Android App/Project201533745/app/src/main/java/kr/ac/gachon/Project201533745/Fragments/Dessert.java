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

//Dessert Fragment
public class Dessert extends Fragment {
    Context context;
    RecyclerView recyclerView;
    ArrayList<MenuItem> menuItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v=inflater.inflate(R.layout.fragment_dessert, container, false);
        context=container.getContext();
        menuItems=new ArrayList<MenuItem>();

        MenuItem d1=new MenuItem(R.drawable.d1,"인절미찰떡토스트",4500);
        MenuItem d2=new MenuItem(R.drawable.d2,"치즈찰떡토스트",4500);
        MenuItem d3=new MenuItem(R.drawable.d3,"핫도그",3000);
        MenuItem d4=new MenuItem(R.drawable.d4,"초코칩쿠키",1500);
        MenuItem d5=new MenuItem(R.drawable.d5,"퐁당쇼콜라",3500);
        MenuItem d6=new MenuItem(R.drawable.d6,"카라멜크로넛",4500);
        MenuItem d7=new MenuItem(R.drawable.d7,"딸기와플",5000);
        MenuItem d8=new MenuItem(R.drawable.d8,"치즈케익",4500);
        MenuItem d9=new MenuItem(R.drawable.d9,"초코무스케익",4500);
        MenuItem d10=new MenuItem(R.drawable.d10,"쿠키크로넛",4500);
        MenuItem d11=new MenuItem(R.drawable.d11,"크로크무슈",3500);

        menuItems.add(d1);
        menuItems.add(d2);
        menuItems.add(d3);
        menuItems.add(d4);
        menuItems.add(d5);
        menuItems.add(d6);
        menuItems.add(d7);
        menuItems.add(d8);
        menuItems.add(d9);
        menuItems.add(d10);
        menuItems.add(d11);

        recyclerView = (androidx.recyclerview.widget.RecyclerView)v.findViewById(R.id.desserList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter menuAdapter =new MenuAdapter(context,menuItems);
        recyclerView.setAdapter(menuAdapter);

        return v;
    }
}