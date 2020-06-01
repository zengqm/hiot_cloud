package com.example.hiot_cloud.ui.mine;

import com.example.hiot_cloud.test.networktest.UserBean;
import com.example.hiot_cloud.ui.base.BaseView;

/**
 * 用户中心View层接口
 */
public interface MineView extends BaseView {

    /**
     * 刷新用户信息
     *
     * @param userBean
     */
    void refreshUserInfo(UserBean userBean);

    void refreshUserHead(String url);
}