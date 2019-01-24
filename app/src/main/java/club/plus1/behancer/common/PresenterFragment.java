package club.plus1.behancer.common;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * @author Sergey Lavrov
 */
public abstract class PresenterFragment extends MvpAppCompatFragment {

    protected abstract BasePresenter getPresenter();

    @Override
    public void onDetach() {
        if (getPresenter() != null){
            getPresenter().disposeAll();
        }
        super.onDetach();
    }
}
