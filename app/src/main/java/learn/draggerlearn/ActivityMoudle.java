package learn.draggerlearn;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/13 0013.
 * 个Module的作用就是需要生成一个DaggerPresenter的对象，
 * 就是Module的作用是用来提供生成依赖对象的，比如我要注入DaggerPresenter
 *
 * provideDaggerPresenter  只要是provide的都可以依赖注入 提供给我们使用 我们使用就比较方便
 */
@Module
public class ActivityMoudle {
    private MainActivity activity;
//我们需要调用它，并传入参数，这里我们直接new了一个ActivityModule进去。
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
