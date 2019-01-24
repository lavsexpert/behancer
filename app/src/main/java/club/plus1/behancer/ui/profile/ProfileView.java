package club.plus1.behancer.ui.profile;

import club.plus1.behancer.common.BaseView;
import club.plus1.behancer.data.model.user.User;

/**
 * @author Sergey Lavrov
 */
public interface ProfileView extends BaseView {

    void getProfile(User user);
    void bind(User user);
}
