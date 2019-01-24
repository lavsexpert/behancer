package club.plus1.behancer.ui.projects;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import club.plus1.behancer.R;
import club.plus1.behancer.data.model.project.Project;
import club.plus1.behancer.utils.DateUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by Vladislav Falzan.
 */

public class ProjectsHolder extends RecyclerView.ViewHolder {

    private static final int FIRST_OWNER_INDEX = 0;

    private ImageView mImage;
    private TextView mName;
    private TextView mUsername;
    private TextView mPublishedOn;

    public ProjectsHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.image);
        mName = itemView.findViewById(R.id.tv_name);
        mUsername = itemView.findViewById(R.id.tv_username);
        mPublishedOn = itemView.findViewById(R.id.tv_published);
    }

    public void bind(Project item, ProjectsAdapter.OnItemClickListener onItemClickListener) {
        Picasso.with(mImage.getContext()).load(item.getCover().getPhotoUrl())
                .fit()
                .into(mImage);

        mName.setText(item.getName());
        mUsername.setText(item.getOwners().get(FIRST_OWNER_INDEX).getUsername());
        mPublishedOn.setText(DateUtils.format(item.getPublishedOn()));

        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(
                    item.getOwners()
                            .get(FIRST_OWNER_INDEX)
                            .getUsername()
            ));
        }
    }
}
