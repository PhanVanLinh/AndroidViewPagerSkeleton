package toong.vn.androidviewpagerskeleton.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by PhanVanLinh on 12/7/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class SubChildContainerFragment extends Fragment {
    protected String TAG = getClass().getSimpleName();
    private boolean userVisibleHint;

    @Override
    public void onStart() {
        super.onStart();
        if (getParentFragment().getUserVisibleHint() && userVisibleHint) {
            onVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        userVisibleHint = isVisibleToUser;
        if (isVisibleToUser && isResumed()) {
            onVisible();
        }
    }

    public void onVisible() {
        Log.i(TAG, "-----");
        Log.i(TAG, "FRAGMENT VISIBLE");
        Log.i(TAG, "-----");
        Toast.makeText(getActivity(), "" + TAG + "visible", Toast.LENGTH_SHORT).show();
    }
}
