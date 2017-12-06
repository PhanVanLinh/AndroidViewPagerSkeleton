package toong.vn.androidviewpagerskeleton.screen.s1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.BaseFragment;

/**
 * Created by PhanVanLinh on 06/12/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class Fragment1sub1 extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_1_sub1, container, false);
        rootView.findViewById(R.id.button_go_to_sub_2)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToSub2AndAddToBackStack();
                    }
                });

        rootView.findViewById(R.id.button_go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragment().getChildFragmentManager().popBackStackImmediate();
            }
        });
        return rootView;
    }

    private void goToSub2AndAddToBackStack() {
        getParentFragment().getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new Fragment1sub2())
                .addToBackStack("")
                .commit();
    }
}
