package toong.vn.androidviewpagerskeleton.screen.s4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.ChildContainerFragment;

public class Fragment4 extends ChildContainerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_4, container, false);
        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}