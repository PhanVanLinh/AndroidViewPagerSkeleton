package toong.vn.firebaserecycleradaptermutipleviewtype.screen.s3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toong.vn.firebaserecycleradaptermutipleviewtype.R;
import toong.vn.firebaserecycleradaptermutipleviewtype.fragment.ChildContainerFragment;

public class Fragment3c extends ChildContainerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_3c, container, false);
        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}