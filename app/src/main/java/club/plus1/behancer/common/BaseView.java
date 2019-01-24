package club.plus1.behancer.common;

import com.arellomobile.mvp.MvpView;

/**
 * @author Sergey Lavrov
 */
public interface BaseView extends MvpView {
    void showRefresh();
    void hideRefresh();
    void showError();
}
