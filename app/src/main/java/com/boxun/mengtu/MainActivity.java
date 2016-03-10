package com.boxun.mengtu;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.boxun.mengtu.activity.TujieActivity;
import com.boxun.mengtu.base.MyApplication;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends TabActivity {

    @InjectView(R.id.mTab_tujie)
    RadioButton mTab_tujie;

    @InjectView(R.id.mTab_tuqun)
    RadioButton mTab_tuqun;

    /** 自定义application */
    protected MyApplication app;

    private TabHost mTabHost;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        app = (MyApplication) getApplication();

        initWidget();
    }

    private void initWidget() {
        mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("tujie").setIndicator("tujie").setContent(new Intent(this, TujieActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("tuqun").setIndicator("tuqun").setContent(new Intent(this, TujieActivity.class)));

        checkItem();
    }

    /**
     * 恢复原样
     *
     * @param
     */
    private void checkItem() {
        if (index == 0) {
            mTab_tujie.setChecked(true);
        } else {
            mTab_tujie.setChecked(false);
        }

        if (index == 1) {
            mTab_tuqun.setChecked(true);
        } else {
            mTab_tuqun.setChecked(false);
        }

        if(index == 3 && !app.getUserLoginState()){
//            startActivity(new Intent(this, WXEntryActivity.class));
        }
        mTabHost.setCurrentTab(index);

    }
}
