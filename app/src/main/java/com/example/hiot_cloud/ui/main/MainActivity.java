package com.example.hiot_cloud.ui.main;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hiot_cloud.R;
import com.example.hiot_cloud.ui.base.BaseActivity;
import com.example.hiot_cloud.ui.base.BasePresenter;
import com.example.hiot_cloud.utils.Constant;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager vpMain=findViewById(R.id.vp_main);
        vpMain.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        vpMain.setOffscreenPageLimit(Constant.MAIN_FRAGMENT_COUNT);

        RadioGroup rgMain=findViewById(R.id.rg_main);
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_massage:
                        vpMain.setCurrentItem(Constant.MAIN_VIEWPAGER_INDEX_MESSAGE);
                        break;
                    case R.id.rb_equipment:
                        vpMain.setCurrentItem(Constant.MAIN_VIEWPAGER_INDEX_EQUIPMENT);
                        break;
                    case R.id.rb_scene:
                        vpMain.setCurrentItem(Constant.MAIN_VIEWPAGER_INDEX_SCENE);
                        break;
                    case R.id.rb_mine:
                        vpMain.setCurrentItem(Constant.MAIN_VIEWPAGER_INDEX_MINE);
                        break;
                    default:;
                }
            }
        });
    }

    @Override
    public BasePresenter createPresenter() {
            return null;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }
}
