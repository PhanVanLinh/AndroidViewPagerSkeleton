package toong.vn.androidviewpagerskeleton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androidviewpagerskeleton.fragment.FragmentContainer;

public class MainActivity extends AppCompatActivity {
    ViewPager mPager;

    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());

        mPagerAdapter.addFragment(FragmentContainer.newInstance(1));
        mPagerAdapter.addFragment(FragmentContainer.newInstance(2));
        mPagerAdapter.addFragment(FragmentContainer.newInstance(3));
        mPagerAdapter.addFragment(FragmentContainer.newInstance(4));
        mPagerAdapter.addFragment(FragmentContainer.newInstance(5));

        mPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mPager.setAdapter(mPagerAdapter);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
