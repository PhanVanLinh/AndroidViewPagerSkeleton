package toong.vn.androidviewpagerskeleton.screen.s2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import toong.vn.androidviewpagerskeleton.R;
import toong.vn.androidviewpagerskeleton.fragment.BaseFragment;
import toong.vn.androidviewpagerskeleton.screen.second.SecondActivity;

public class Fragment2 extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        rootView.findViewById(R.id.button_open_second_activity)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openSecondActivity();
                    }
                });

        return rootView;
    }

    private void openSecondActivity() {
        startActivity(new Intent(getActivity(), SecondActivity.class));
    }
}