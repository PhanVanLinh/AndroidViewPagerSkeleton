package toong.vn.androidviewpagerskeleton.fragment;

/**
 * Created by PhanVanLinh on 06/12/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class FragmentHelpLoadDataWhenVisible extends BaseFragment {
    private boolean mUserVisibleHint;

    @Override
    public void onStart() {
        super.onStart();
        if (mUserVisibleHint) {
            onVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mUserVisibleHint = isVisibleToUser;
        if (mUserVisibleHint && isResumed()) {
            onVisible();
        }
    }
}
