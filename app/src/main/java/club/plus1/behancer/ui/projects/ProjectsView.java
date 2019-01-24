package club.plus1.behancer.ui.projects;

import java.util.List;

import club.plus1.behancer.common.BaseView;
import club.plus1.behancer.data.model.project.Project;

/**
 * @author Sergey Lavrov
 */
public interface ProjectsView extends BaseView {

    void showProjects(List<Project> projects);
    void openProfileFragment(String username);
}
