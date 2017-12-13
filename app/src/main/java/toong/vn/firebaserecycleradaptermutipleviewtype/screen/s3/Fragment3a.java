package toong.vn.firebaserecycleradaptermutipleviewtype.screen.s3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import toong.vn.firebaserecycleradaptermutipleviewtype.R;
import toong.vn.firebaserecycleradaptermutipleviewtype.fragment.SubChildContainerFragment;

public class Fragment3a extends SubChildContainerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_3a, container, false);
        rootView.findViewById(R.id.button_go_to_3a_sub_1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goSub1AndAddToBackStack();
                    }
                });
        return rootView;
    }

    private void goSub1AndAddToBackStack() {
        getParentFragment().getParentFragment()
                .getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new Fragment3aSub1())
                .addToBackStack("")
                .commit();
    }
}