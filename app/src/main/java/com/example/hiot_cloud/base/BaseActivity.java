package com.example.hiot_cloud.base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiot_cloud.App;
import com.example.hiot_cloud.injection.component.ActivityComponent;
import com.example.hiot_cloud.injection.component.ApplicationComponent;
import com.example.hiot_cloud.injection.component.DaggerActivityComponent;
import com.example.hiot_cloud.injection.module.ActivityModule;

/**
 * MVP架构Acivity基类
 */
public abstract class BaseActivity<V extends BaseView,P extends BasePresenter> extends AppCompatActivity implements BaseView {

    private P presenter;

    /**
     * 活动注入器
     */
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.setView(this);
    }

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public ActivityComponent getActivityComponent() {
        if (null == mActivityComponent) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(getActivityModule())
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }

    public ApplicationComponent getApplicationComponent() {

        Application application = getApplication();
        App app = (App) application;
        return app.component();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
