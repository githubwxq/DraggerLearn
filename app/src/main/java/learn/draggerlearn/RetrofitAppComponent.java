package learn.draggerlearn;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/3/13 0013.
 * 分别用来提供这三个对象的，这样就可以解释清楚了，他们存在依赖关系，就像我们对象之间的继承一样，值得注意的是这三个方法也是根据返回值类型来识别的，他们会分别找到AppComponent中的module(ApiModule)中的provide方法来获取对象。
 这里我们发现一个有趣的现象，首先我们提供这三个方法可以被Activity的成员变量注入(可以看到，我们成功的注入的OkHttpClient和Retrofit)，同时也可以让被依赖的Component(ActivityComponent)所使用.
 如果我们不把这三个对象声明在AppComponent中,在编译的过程中就会报异常。在专业术语好像叫做:暴露给子图
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface RetrofitAppComponent {

    OkHttpClient getClient();  //、、都不需要参数

    Retrofit getRetrofit();   //、、都不需要参数

    User getUser();
    //这里的AppComponent提供了3个方法，分别用来暴露OkHttpClient、Retrofit和User对象的，这里暂且不提为什么要暴露，大家别急，继续往下看。
}
