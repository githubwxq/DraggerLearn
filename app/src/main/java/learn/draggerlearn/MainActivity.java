package learn.draggerlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView text;
    private static final String TAG = "DaggerActivity";
    //注入对象 不再是控件 控件butterkniife
    @Inject
    DaggerPresenter presenter;

    @Inject
    OkHttpClient client;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.text);
        inject();
//        DaggerActivityComponent.builder().activityMoudle(new ActivityMoudle(this)).build().inject(this);
        presenter.showUserName();
        Log.i(TAG, "client = " + (client == null ? "null" : client));  //
        Log.i(TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
        Toast.makeText(this, retrofit == null ? "null" : "feinull", Toast.LENGTH_SHORT).show();

    }

    private void inject() {
        //retrofit在application中已经初始化   初始化必要的东西然后以后就直接用
        RetrofitAppComponent appComponent = ((MyApplication) getApplication()).getAppComponent(); //application中初始化好的一个
        DaggerActivityComponent.builder().retrofitAppComponent(appComponent).activityMoudle(new ActivityMoudle(this)).build().inject(this);
    }


    public void showUserName(String name){

    text.setText(name);


}



}
