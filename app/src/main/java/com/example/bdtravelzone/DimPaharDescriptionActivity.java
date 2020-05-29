package com.example.bdtravelzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class DimPaharDescriptionActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimpahar_description);

        tabLayout =findViewById(R.id.tableLayoutId);
        ViewPager viewPager = findViewById(R.id.viewPagerId);

        textView = (TextView) findViewById(R.id.nilacholtitleID);
        setTitle("ডিম পাহাড়");

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        setUpTabIcons();
    }

    private void setUpTabIcons(){

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_info_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_ondemand_video_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_directions_car_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_restaurant_black_24dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_local_hotel_black_24dp);

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] text= {"info","Video","travel","food","hotel"};

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
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
        public int getCount() {
            return 5;
        }


        public CharSequence getPageTitle(int position) {
            return text[position];
        }
    }

}


