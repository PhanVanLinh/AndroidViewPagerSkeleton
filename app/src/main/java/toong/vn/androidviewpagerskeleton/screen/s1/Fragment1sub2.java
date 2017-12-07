package toong.vn.androidviewpagerskeleton.screen.s1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.ChildContainerFragment;

/**
 * Created by PhanVanLinh on 06/12/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class Fragment1sub2 extends ChildContainerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_1_sub2, container, false);

        rootView.findViewById(R.id.button_go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragment().getChildFragmentManager().popBackStack();
            }
        });
        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        return getParentFragment().getChildFragmentManager().popBackStackImmediate();
    }
}
