package toong.vn.firebaserecycleradaptermutipleviewtype.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayDeque;
import java.util.Queue;

import toong.vn.firebaserecycleradaptermutipleviewtype.R;
import toong.vn.firebaserecycleradaptermutipleviewtype.screen.s1.Fragment1;
import toong.vn.firebaserecycleradaptermutipleviewtype.screen.s2.Fragment2;
import toong.vn.firebaserecycleradaptermutipleviewtype.screen.s3.Fragment3;
import toong.vn.firebaserecycleradaptermutipleviewtype.screen.s4.Fragment4;
import toong.vn.firebaserecycleradaptermutipleviewtype.screen.s5.Fragment5;

/**
 * Created by PhanVanLinh on 06/12/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class ContainerFragment extends BaseFragment {
    private int mTabPosition;
    public static String ARGUMENT_CHILD_FRAGMENT = "child_fragment";
    private Queue<Boolean> pendingVisible = new ArrayDeque<>();

    public static ContainerFragment newInstance(int tabPosition) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_CHILD_FRAGMENT, tabPosition);
        ContainerFragment baseFrag = new ContainerFragment();
        baseFrag.setArguments(bundle);
        baseFrag.TAG += "" + tabPosition;
        return baseFrag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTabPosition = getArguments().getInt(ARGUMENT_CHILD_FRAGMENT);

        switch (mTabPosition) {
            case 1:
                goNextChildFragmentWithoutAddToBackStack(new Fragment1());
                break;
            case 2:
                goNextChildFragmentWithoutAddToBackStack(new Fragment2());
                break;
            case 3:
                goNextChildFragmentWithoutAddToBackStack(new Fragment3());
                break;
            case 4:
                goNextChildFragmentWithoutAddToBackStack(new Fragment4());
                break;
            case 5:
                goNextChildFragmentWithoutAddToBackStack(new Fragment5());
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_container, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.frame_container);
        Log.i(TAG, "pendingVisible size" + pendingVisible.size());
        while (!pendingVisible.isEmpty()) {
            fragment.setUserVisibleHint(pendingVisible.poll());
        }
    }

    private void goNextChildFragmentWithoutAddToBackStack(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isAdded()) {
            pendingVisible.add(isVisibleToUser);
            return;
        }
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.frame_container);
        fragment.setUserVisibleHint(isVisibleToUser);
    }

    public boolean onBackPressed() {
        ChildContainerFragment fragment =
                (ChildContainerFragment) getChildFragmentManager().findFragmentById(
                        R.id.frame_container);
        return fragment.onBackPressed();
    }
}
