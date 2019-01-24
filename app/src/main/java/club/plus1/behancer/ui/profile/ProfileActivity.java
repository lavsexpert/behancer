package club.plus1.behancer.ui.profile;

import android.support.v4.app.Fragment;

import club.plus1.behancer.common.SingleFragmentActivity;

/**
 * Created by Vladislav Falzan.
 */

public class ProfileActivity extends SingleFragmentActivity {

    public static final String USERNAME_KEY = "USERNAME_KEY";

    @Override
    protected Fragment getFragment() {
        if (getIntent() != null) {
            return ProfileFragment.newInstance(getIntent().getBundleExtra(USERNAME_KEY));
        }
        throw new IllegalStateException("getIntent cannot be null");
    }
}

