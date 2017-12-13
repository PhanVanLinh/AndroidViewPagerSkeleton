package toong.vn.firebaserecycleradaptermutipleviewtype.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by PhanVanLinh on 12/7/2017.
 * phanvanlinh.94vn@gmail.com
 */

public abstract class ChildContainerFragment extends BaseFragment {
    protected String TAG = getClass().getSimpleName();
    protected boolean isStarted;
    private boolean isCreatedAnimation;

    @Override
    public Animation onCreateAnimation(int transit, final boolean enter, int nextAnim) {
        Log.i(TAG, "onCreateAnimation enter:" + enter);
        Animation anim = super.onCreateAnimation(transit, enter, nextAnim);
        if (anim == null && nextAnim != 0) {
            anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }
        if (anim == null) {
            if (enter) {
                isCreatedAnimation = true;
                handleVisible();
            }
            return null;
        }
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!enter) return;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isCreatedAnimation = true;
                        handleVisible();
                    }
                }, 100);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return anim;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated");
        isCreatedAnimation = false;
    }

    @Override
    public void onStart() {
        super.onStart();
        isStarted = true;
        handleVisible();
    }

    @Override
    public void onStop() {
        super.onStop();
        onInVisible();
    }

    @Override
    public boolean getUserVisibleHint() {
        return getParentFragment().getUserVisibleHint();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        handleVisible();
        if (isResumed() && !isVisibleToUser) {
            onInVisible();
        }
    }

    private void handleVisible() {
        if (!isCreatedAnimation || !isStarted) {
            return;
        }
        if (getUserVisibleHint()) {
            onVisible();
        }
    }

    public void onVisible() {
        Log.i(TAG, "-----");
        Log.i(TAG, "VISIBLE");
        Log.i(TAG, "-----");
    }

    public void onInVisible() {
        Log.i(TAG, "-----");
        Log.i(TAG, "INVISIBLE");
        Log.i(TAG, "-----");
    }

    public abstract boolean onBackPressed();
}
