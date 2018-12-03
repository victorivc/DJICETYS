package com.dji.GSDemo.GoogleMap;

import android.app.Application;
import android.content.Context;

import com.secneo.sdk.Helper;

import dji.midware.aoabridge.DJIBaseCommData;

public class MApplication extends Application {

    private DJIDemoApplication djiDemoApplication;//Era fpvDemoApplication
    private FPVDemoApplication fpvDemoApplication;//Era djiDemoApplication
    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        Helper.install(MApplication.this);
        if (fpvDemoApplication == null) {
            fpvDemoApplication = new FPVDemoApplication();
            fpvDemoApplication.setContext(this);
        }
        if(djiDemoApplication==null){
            djiDemoApplication=new DJIDemoApplication();
            djiDemoApplication.setContext(this);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        fpvDemoApplication.onCreate();
        djiDemoApplication.onCreate();
    }

}
