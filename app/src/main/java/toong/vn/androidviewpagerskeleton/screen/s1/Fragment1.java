package toong.vn.androidviewpagerskeleton.screen.s1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.ChildContainerFragment;

public class Fragment1 extends ChildContainerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        rootView.findViewById(R.id.button_go_to_sub_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goSub1AndAddToBackStack();
                    }
                });
        return rootView;
    }

    private void goSub1AndAddToBackStack() {
        getParentFragment().getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new Fragment1sub1())
                .addToBackStack("")
                .commit();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}