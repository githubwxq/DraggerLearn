package learn.draggerlearn;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/3/13 0013.
 */

public class MyApplication extends Application {

    RetrofitAppComponent appComponent;  //关于retrofit 的
//    OkHttpClient getClient();
//
//    Retrofit getRetrofit();
//
//    User getUser();
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerRetrofitAppComponent.builder()
                .apiModule(new ApiModule())    // 可以传递参数
                .build();
    }

    public RetrofitAppComponent getAppComponent() {
        return appComponent;
    }
}
