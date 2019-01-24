package club.plus1.behancer.ui.projects;

import android.view.View;

import club.plus1.behancer.BuildConfig;
import club.plus1.behancer.common.BasePresenter;
import club.plus1.behancer.data.Storage;
import club.plus1.behancer.utils.ApiUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProjectsPresenter extends BasePresenter {

    private ProjectsView mView;
    private Storage mStorage;

    public ProjectsPresenter(ProjectsView mView, Storage mStorage) {
        this.mView = mView;
        this.mStorage = mStorage;
    }

    public void getProjects(){
        mCompositeDisposable.add(ApiUtils.getApiService().getProjects(BuildConfig.API_QUERY)
                .doOnSuccess(response -> mStorage.insertProjects(response))
                .onErrorReturn(throwable ->
                        ApiUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass()) ? mStorage.getProjects() : null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mView.showRefresh())
                .doFinally(() -> mView.hideRefresh())
                .subscribe(
                        response -> mView.showProjects(response.getProjects()),
                        throwable -> mView.showError()));

    }

    public void openProfileFragment(String username){
        mView.openProfileFragment(username);
    }
}
