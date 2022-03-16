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

//Coffee Fragment
public class Coffee extends Fragment {
    Context context;


    RecyclerView recyclerView;
    ArrayList<MenuItem> menuItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View v = inflater.inflate(R.layout.fragment_coffee, container, false);
        context = container.getContext();
        menuItems = new ArrayList<MenuItem>();

        MenuItem c1 = new MenuItem(R.drawable.c1, "아메리카노", 2000);
        MenuItem c2 = new MenuItem(R.drawable.c2, "꿀아메리카노", 2500);
        MenuItem c3 = new MenuItem(R.drawable.c3, "카페라떼", 2500);
        MenuItem c4 = new MenuItem(R.drawable.c4, "카라멜마끼아또", 3000);
        MenuItem c5 = new MenuItem(R.drawable.c5, "바닐라라떼", 3000);
        MenuItem c6 = new MenuItem(R.drawable.c6, "카페모카", 3000);
        MenuItem c7 = new MenuItem(R.drawable.c7, "민트카페모카", 3500);
        MenuItem c8 = new MenuItem(R.drawable.c8, "카푸치노", 2500);
        MenuItem c9 = new MenuItem(R.drawable.c9, "티라미수라떼", 3500);
        MenuItem c10 = new MenuItem(R.drawable.c10, "연유라떼", 3000);
        MenuItem c11 = new MenuItem(R.drawable.c11, "헤이즐넛아메리카노", 2500);
        MenuItem c12 = new MenuItem(R.drawable.c12, "바닐라아메리카노", 2500);

        menuItems.add(c1);
        menuItems.add(c2);
        menuItems.add(c3);
        menuItems.add(c4);
        menuItems.add(c5);
        menuItems.add(c6);
        menuItems.add(c7);
        menuItems.add(c8);
        menuItems.add(c9);
        menuItems.add(c10);
        menuItems.add(c11);
        menuItems.add(c12);

        recyclerView = (androidx.recyclerview.widget.RecyclerView) v.findViewById(R.id.coffeeList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter menuAdapter = new MenuAdapter(context, menuItems);
        recyclerView.setAdapter(menuAdapter);

        return v;
    }
}