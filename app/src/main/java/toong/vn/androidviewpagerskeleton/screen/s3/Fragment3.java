package toong.vn.androidviewpagerskeleton.screen.s3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.BaseFragment;

public class Fragment3 extends BaseFragment {
    ViewPager mPager;
    PagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_3, container, false);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getChildFragmentManager());

        mPagerAdapter.addFragment(new Fragment3a());
        mPagerAdapter.addFragment(new Fragment3b());
        mPagerAdapter.addFragment(new Fragment3c());

        mPager.setAdapter(mPagerAdapter);
        return rootView;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (mPager == null) {
//            return;
//        }
//        Fragment selectedFragment = mPagerAdapter.getItem(mPager.getCurrentItem());
//        if (selectedFragment == null) {
//            return;
//        }
//        selectedFragment.setUserVisibleHint(isVisibleToUser);
//    }

    @Override
    public void onVisible() {
        super.onVisible();
        if (mPager == null) {
            return;
        }
        Fragment selectedFragment = mPagerAdapter.getItem(mPager.getCurrentItem());
        if (selectedFragment == null) {
            return;
        }
        ((BaseFragment) selectedFragment).onVisible();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
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