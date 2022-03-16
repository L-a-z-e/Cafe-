package kr.ac.gachon.Project201533745;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import kr.ac.gachon.Project201533745.Fragments.Coffee;
import kr.ac.gachon.Project201533745.Fragments.Dessert;
import kr.ac.gachon.Project201533745.Fragments.NonCoffee;
import kr.ac.gachon.Project201533745.Fragments.Tea;

//일반사용자 음료선택페이지
public class MainActivity extends AppCompatActivity {
    public static ArrayList<Order> orderArrayList;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    FloatingActionButton fab;

    FragmentManager manager;
    ArrayList<Fragment> fraglist = new ArrayList<>();
    ArrayList<String> titlelist = new ArrayList<>();

    Coffee sub1 = new Coffee();
    NonCoffee sub2 = new NonCoffee();
    Tea sub3 = new Tea();
    Dessert sub4 = new Dessert();

    TextView myOrderListTv, logoutTv;
    Button drawerBtn;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderArrayList = new ArrayList<>();

        tabLayout = (TabLayout) findViewById(R.id.tabs2);

        titlelist.add("COFFEE");
        titlelist.add("NON-COFFEE");
        titlelist.add("TEA");
        titlelist.add("DESSERT");

        fraglist.add(sub1);
        fraglist.add(sub2);
        fraglist.add(sub3);
        fraglist.add(sub4);

        pager = (ViewPager) findViewById(R.id.pager2);
        manager = getSupportFragmentManager();
        tabLayout.setupWithViewPager(pager);
        pageradapter adapter = new pageradapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        myOrderListTv = findViewById(R.id.myOrderListTv);
        logoutTv = findViewById(R.id.logoutTv);
        drawerBtn = findViewById(R.id.drawerBtn);
        drawerLayout = findViewById(R.id.drawerLayout);
//플로팅액션버튼 - 장바구니 기능
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,OrderList.class);
            startActivity(intent);

            }
        });
//로그인 로그아웃 주문내역 드로어레이아웃
        drawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        logoutTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

        myOrderListTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyOrderListActivity.class);
                startActivity(intent);
            }
        });
    }
//로그아웃
    private void Logout() {
        orderArrayList = null;
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }
//프래그먼트 어댑터
    class pageradapter extends FragmentPagerAdapter {

        public pageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fraglist.get(i);
        }

        @Override
        public int getCount() {
            return fraglist.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelist.get(position);
        }

    }

}

