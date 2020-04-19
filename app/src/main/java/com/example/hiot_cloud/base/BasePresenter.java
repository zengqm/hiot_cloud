package com.example.hiot_cloud.base;

/**
 * MVP架构presenter基类
 */
public class BasePresenter<V extends BaseView> {
    private V view;

    public BasePresenter(){

    }

    public void setView(V view){
        this.view = view;
    }

    public V getView(){
        return view;
    }

    public void destory(){
        if(viewAttached()){
            view = null;
        }
    }

    public boolean viewAttached(){
        return view != null;
    }
}
