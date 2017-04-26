package learn.draggerlearn;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
@Module
public class ApiModule {

    public static final String END_POINT = "http://www.baidu.com";


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS).build();
        return client;

    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
    Retrofit retrofit=new Retrofit.Builder().client(client).baseUrl(END_POINT).build();
    return retrofit;
}


//提供的最后都得暴露出去给他人使用或者就是已经被注解自动生成的对象
    @Provides
    @Singleton
    User provideUser(){
        return new User("retrofit_test");
    }




}
