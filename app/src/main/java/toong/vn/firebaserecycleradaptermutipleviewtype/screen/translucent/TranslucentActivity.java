package toong.vn.firebaserecycleradaptermutipleviewtype.screen.translucent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import toong.vn.firebaserecycleradaptermutipleviewtype.R;

/**
 * When start translucent activity then back
 * The lifecycle methods (example onStart, onStop, ...) of started activity will not fired
 */
public class TranslucentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
    }
}
