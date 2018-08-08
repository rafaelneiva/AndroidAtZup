package br.com.zup.androidatzup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                int pageWidth = page.getWidth();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                } else if (position <= 1) { // [-1,1]

                    try {
                        TextView tvTitle = page.findViewById(R.id.section_label);

                        if ((int) tvTitle.getTag() == 1) {
                            tvTitle.setTranslationY((position) * (pageWidth / 2));

                        } else if ((int) tvTitle.getTag() == 2) {
                            tvTitle.setTranslationY(-(position) * (pageWidth / 2));
                            tvTitle.setRotationX((position) * (pageWidth / 1.2f));

                        } else if ((int) tvTitle.getTag() == 3) {
                            tvTitle.setTranslationY((position) * (pageWidth / 2));
                            tvTitle.setTranslationX((position) * (pageWidth / 0.5f));
                            tvTitle.setRotationY((position) * (pageWidth / 0.5f));

                        } else {
                            tvTitle.setTranslationY((position) * (pageWidth / 2));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                }
            }
        });
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return PlaceholderOneFragment.newInstance();
                case 1:
                    return PlaceholderTwoFragment.newInstance();
                case 2:
                    return PlaceholderThreeFragment.newInstance();
                case 3:
                    return PlaceholderFourFragment.newInstance();
                case 4:
                    return PlaceholderFiveFragment.newInstance();
                case 5:
                    return PlaceholderSixFragment.newInstance();
                default:
                    return PlaceholderOneFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}
