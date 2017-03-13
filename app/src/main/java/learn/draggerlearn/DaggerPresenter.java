package learn.draggerlearn;

public class DaggerPresenter {
    MainActivity activity;
    User user;

    public DaggerPresenter(MainActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {

        activity.showUserName(user.name);

    }
}