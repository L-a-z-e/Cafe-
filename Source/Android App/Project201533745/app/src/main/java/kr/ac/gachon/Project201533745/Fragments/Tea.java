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

//Tea Fragment
public class Tea extends Fragment {

    Context context;
    RecyclerView recyclerView;
    ArrayList<MenuItem> menuItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v=inflater.inflate(R.layout.fragment_tea, container, false);
        context=container.getContext();
        menuItems=new ArrayList<MenuItem>();

        MenuItem t1=new MenuItem(R.drawable.t1,"유자차",3000);
        MenuItem t2=new MenuItem(R.drawable.t2,"레몬티",3000);
        MenuItem t3=new MenuItem(R.drawable.t3,"자몽티",3000);
        MenuItem t4=new MenuItem(R.drawable.t4,"녹차",3000);
        MenuItem t5=new MenuItem(R.drawable.t5,"캐모마일",3000);
        MenuItem t6=new MenuItem(R.drawable.t6,"페퍼민트",3000);
        MenuItem t7=new MenuItem(R.drawable.t7,"얼그레이",3000);
        MenuItem t8=new MenuItem(R.drawable.t8,"아이스티",2500);

        menuItems.add(t1);
        menuItems.add(t2);
        menuItems.add(t3);
        menuItems.add(t4);
        menuItems.add(t5);
        menuItems.add(t6);
        menuItems.add(t7);
        menuItems.add(t8);

        recyclerView = (androidx.recyclerview.widget.RecyclerView)v.findViewById(R.id.teaList);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter menuAdapter =new MenuAdapter(context,menuItems);
        recyclerView.setAdapter(menuAdapter);

        return v;
    }
}