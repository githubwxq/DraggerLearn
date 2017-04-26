package learn.draggerlearn;
//dragpresent 被注入需要对应的参数  user直接提供  直接new出来或者外部传入 需要注入的东西
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