package com.example.hiot_cloud.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hiot_cloud.ui.mine.MineFragment;
import com.example.hiot_cloud.utils.Constants;

/**
 * viewpager适配器
 */
class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    /**
     * Fragment界面块
     * 当返回position时要返回fragment
     */
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Constants.MAIN_VIEWPAGER_INDEX_MESSAGE:
                // 创建消息的fragment
                fragment = MassageFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建设备的fragment   todo 加这个可以很方便的知道哪里要加代码
                fragment = EquipmentFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建场景的fragment
                fragment = SceneFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_MINE:
                // 创建我的fragment
                fragment = MineFragment.newInstance();
                break;
            default:
                ;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constants.MAIN_FRAGMENT_COUNT;
    }
}
