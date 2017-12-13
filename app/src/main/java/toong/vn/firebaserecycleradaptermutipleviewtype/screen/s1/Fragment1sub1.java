package toong.vn.firebaserecycleradaptermutipleviewtype.screen.s1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import toong.vn.firebaserecycleradaptermutipleviewtype.R;
import toong.vn.firebaserecycleradaptermutipleviewtype.fragment.ChildContainerFragment;

/**
 * Created by PhanVanLinh on 06/12/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class Fragment1sub1 extends ChildContainerFragment {

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onCreateViewCreated");
    }

    private void goToSub2AndAddToBackStack() {
        getParentFragment().getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new Fragment1sub2())
                .addToBackStack("")
                .commit();
    }

    @Override
    public boolean onBackPressed() {
        return getParentFragment().getChildFragmentManager().popBackStackImmediate();
    }
}
