package com.example.bdtravelzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class NilgiriActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilgiri);
        tabLayout =findViewById(R.id.tableLayoutId);
        ViewPager viewPager = findViewById(R.id.viewPagerId);

        setTitle("নীলগিরি");
       // Log.d("key","first");
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        //Log.d("key","second");
        tabLayout.setupWithViewPager(viewPager);
        //Log.d("key","thirdd");
        setUpTabIcons();
        //Log.d("key","fouth");
    }

    private void setUpTabIcons(){
        //Log.d("key","5th");
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_info_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_ondemand_video_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_directions_car_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_restaurant_black_24dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_local_hotel_black_24dp);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] text= {"info","Video","travel","food","hotel"};

        MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            //Log.d("key","7th");

        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
           // Log.d("key","8th");

            switch(position){

                case 0:
                    return new infoFragment();
                case 1:
                    return new videoFragment();
                case 2:
                    return new travelFragment();
                case 3:
                    return new foodFragment();
                case 4:
                    return new hotelFragment();

            }

            return null;

        }

        @Override
        public int getCount() { //Log.d("key","14th");
            return 5;
        }


        public CharSequence getPageTitle(int position) { //Log.d("key","15th");
            return text[position];
        }
    }

}





