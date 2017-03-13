package learn.draggerlearn;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
@Module
public class ActivityMoudle {
    private MainActivity activity;

    public ActivityMoudle(MainActivity activity){
        this.activity=activity;
    }
    @Provides
    public MainActivity provideActivity(){

        return  activity;
    }

//    @Provides
//    public  User provideUser(){
//
//        return  new User("我是王晓清");
//
//    }
    @Provides
    public  DaggerPresenter provideDaggerPresenter(MainActivity activity,User user){

     return  new DaggerPresenter(activity,user);
    }



}
