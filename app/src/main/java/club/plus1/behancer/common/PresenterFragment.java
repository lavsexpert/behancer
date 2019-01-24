package club.plus1.behancer.common;

import android.support.v4.app.Fragment;

/**
 * @author Sergey Lavrov
 */
public abstract class PresenterFragment<P extends BasePresenter> extends Fragment {

    protected abstract P getPresenter();

    @Override
    public void onDetach() {
        if (getPresenter() != null){
            getPresenter().disposeAll();
        }
        super.onDetach();
    }
}
