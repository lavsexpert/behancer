package club.plus1.behancer.ui.profile;

import com.arellomobile.mvp.InjectViewState;

import club.plus1.behancer.common.BasePresenter;
import club.plus1.behancer.data.Storage;
import club.plus1.behancer.data.model.user.User;
import club.plus1.behancer.utils.ApiUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Sergey Lavrov
 */

@InjectViewState
public class ProfilePresenter extends BasePresenter<ProfileView> {

    private ProfileView mView;
    private String mUsername;
    private Storage mStorage;

    public ProfilePresenter(ProfileView mProfileView, Storage mStorage, String mUsername) {
        this.mView = mProfileView;
        this.mStorage = mStorage;
        this.mUsername = mUsername;
    }

    public void getProfile(String username) {
        this.mUsername = username;
        mCompositeDisposable.add(ApiUtils.getApiService().getUserInfo(mUsername)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(response -> mStorage.insertUser(response))
                .onErrorReturn(throwable ->
                        ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass()) ?
                                mStorage.getUser(mUsername) :
                                null)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.showRefresh())
                .doFinally(() -> mView.hideRefresh())
                .subscribe(
                        response -> mView.getProfile(response.getUser()),
                        throwable -> mView.showError()));
    }

    public void bind(User user) {
        mView.bind(user);
    }


}
