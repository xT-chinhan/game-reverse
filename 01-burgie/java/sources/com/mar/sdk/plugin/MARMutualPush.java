package com.mar.sdk.plugin;

import com.mar.sdk.IMutualPush;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.gg.push.CrossPushStyle;
import com.mar.sdk.gg.push.PushStyle;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MARMutualPush {
    private static MARMutualPush instance;
    public IMutualPush iMutualPush;

    private MARMutualPush() {
    }

    public static MARMutualPush getInstance() {
        if (instance == null) {
            instance = new MARMutualPush();
        }
        return instance;
    }

    public void init() {
        this.iMutualPush = (IMutualPush) PluginFactory.getInstance().initPlugin(13);
    }

    public void showGame(PushStyle pushStyle) {
        if (this.iMutualPush == null) {
            Log.d("MARSDK", "mutual push plugin is null");
        } else {
            this.iMutualPush.showGame(pushStyle);
        }
    }

    public void showCrossPush(CrossPushStyle crossPushStyle) {
        if (this.iMutualPush == null) {
            Log.d("MARSDK", "mutual push plugin is null");
        } else {
            this.iMutualPush.showCrossPush(crossPushStyle);
        }
    }
}
