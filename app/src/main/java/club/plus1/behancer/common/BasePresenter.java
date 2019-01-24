package club.plus1.behancer.common;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Sergey Lavrov
 */
public abstract class BasePresenter<V extends BaseView> extends MvpPresenter<V> {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void disposeAll() {
        mCompositeDisposable.clear();
    }
}
