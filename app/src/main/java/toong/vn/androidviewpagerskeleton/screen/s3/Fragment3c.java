package toong.vn.androidviewpagerskeleton.screen.s3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.BaseFragment;

public class Fragment3c extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_3c, container, false);
        return rootView;
    }
}