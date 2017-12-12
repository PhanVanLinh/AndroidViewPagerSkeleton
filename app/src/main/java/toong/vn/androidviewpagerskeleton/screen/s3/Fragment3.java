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
import toong.vn.androidviewpagerskeleton.fragment.ChildContainerFragment;

public class Fragment3 extends ChildContainerFragment {
    ViewPager mPager;
    PagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_3, container, false);
        rootView.findViewById(R.id.go_to_3_sub_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo3Sub1AndAddToBackStack();
            }
        });
        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getChildFragmentManager());
        return rootView;
    }

    private void goTo3Sub1AndAddToBackStack() {
        //        getChildFragmentManager().beginTransaction()
        //                .replace(R.id.frame_3_container, new Fragment3sub1())
        //                .addToBackStack("")
        //                .commit();

        getParentFragment().getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frame_container, new Fragment3sub1())
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onVisible() {
        super.onVisible();
        if (mPagerAdapter.getCount() == 0) {
            mPagerAdapter.addFragment(new Fragment3a());
            mPagerAdapter.addFragment(new Fragment3b());
            mPagerAdapter.addFragment(new Fragment3c());
            mPager.setAdapter(mPagerAdapter);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPager == null) {
            return;
        }
        Fragment selectedFragment = mPagerAdapter.getItem(mPager.getCurrentItem());
        if (selectedFragment == null) {
            return;
        }
        selectedFragment.setUserVisibleHint(isVisibleToUser);
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

        PagerAdapter(FragmentManager fm) {
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

        void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}