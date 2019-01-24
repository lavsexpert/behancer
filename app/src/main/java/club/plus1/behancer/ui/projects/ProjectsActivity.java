package club.plus1.behancer.ui.projects;

import android.support.v4.app.Fragment;

import club.plus1.behancer.common.SingleFragmentActivity;

/**
 * Created by Vladislav Falzan.
 */

public class ProjectsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return ProjectsFragment.newInstance();
    }
}
