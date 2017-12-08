package toong.vn.androidviewpagerskeleton.fragment;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

/**
 * Created by PhanVanLinh on 12/7/2017.
 * phanvanlinh.94vn@gmail.com
 */

public abstract class ChildContainerFragment extends Fragment {
    protected String TAG = getClass().getSimpleName();
    protected boolean isOnStart;
    private boolean isCreateAnimation;

    @Override
    public Animation onCreateAnimation(int transit, final boolean enter, int nextAnim) {
        Log.i(TAG, "onCreateAnimation");
        Animation anim = super.onCreateAnimation(transit, enter, nextAnim);
        if (anim == null && nextAnim != 0) {
            anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }
        if (anim == null) {
            if (enter) {
                isCreateAnimation = true;
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
                        isCreateAnimation = true;
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
    public void onStart() {
        super.onStart();
        isOnStart = true;
        Log.i(TAG, "onStart");
        handleVisible();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop");
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
        if (!isCreateAnimation || !isOnStart) {
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
        Toast.makeText(getActivity(), "" + TAG + "visible", Toast.LENGTH_SHORT).show();
    }

    public void onInVisible() {
        Log.i(TAG, "-----");
        Log.i(TAG, "INVISIBLE");
        Log.i(TAG, "-----");
    }

    public abstract boolean onBackPressed();
}
