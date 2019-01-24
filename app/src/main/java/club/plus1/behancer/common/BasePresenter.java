package club.plus1.behancer.common;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Sergey Lavrov
 */
public abstract class BasePresenter
{
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void disposeAll() {
        mCompositeDisposable.clear();
    }
}
