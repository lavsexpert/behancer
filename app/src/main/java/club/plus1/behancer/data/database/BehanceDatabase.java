package club.plus1.behancer.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import club.plus1.behancer.data.model.project.Cover;
import club.plus1.behancer.data.model.project.Owner;
import club.plus1.behancer.data.model.project.Project;
import club.plus1.behancer.data.model.user.Image;
import club.plus1.behancer.data.model.user.User;

/**
 * Created by Vladislav Falzan.
 */

@Database(entities = {Project.class, Cover.class, Owner.class, User.class, Image.class}, version = 1)
public abstract class BehanceDatabase extends RoomDatabase {

    public abstract BehanceDao getBehanceDao();
}
