package learn.draggerlearn;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/13 0013.
 *改动的地方呢是添加了一个@ActivityScope然后，添加了一个dependencies = AppComponent.class。没错，Component之间也可以依赖的。
 解释一下这个ActivityScope，这里查询了网上的资料之后，据说是可以和Activity的生命周期绑定，没有声明这个注解的话编译会报异常。我暂时无法对这个Scope理解清晰，不做评论。
 * 需要修改一下ActivityComponent，
 * Error:(12, 1) 错误: learn.draggerlearn.ActivityComponent (unscoped) cannot depend on scoped components:
 @Singleton learn.draggerlearn.RetrofitAppComponent
  *DaggerActivityComponent   Component 依赖后会怎么样  依赖了就得给他配好以来的对象 dependencies
 */
@ActivityScope
@Component(modules=ActivityMoudle.class,dependencies =RetrofitAppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
