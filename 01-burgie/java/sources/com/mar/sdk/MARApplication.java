package com.mar.sdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Process;
import android.util.Log;
import com.byazt.ol.TTDownloadField;
import com.mar.sdk.utils.GUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        MARSDK.getInstance().onAppCreateAll(this);
        MARSDK.getInstance().onAppCreate(this);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        String process = getProcessName(this);
        String name = GUtils.getPackageName(this);
        Log.d("MARSDK", "attachBaseContext========== :" + name + "===" + process);
        if (name.equals(process)) {
            MARSDK.getInstance().onAppAttachBaseContext(this, base);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MARSDK.getInstance().onAppConfigurationChanged(this, newConfig);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        MARSDK.getInstance().onTerminate();
    }

    public static String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        ActivityManager am = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
        if (processes == null) {
            return null;
        }
        int pid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processes) {
            if (info.pid == pid) {
                return info.processName;
            }
        }
        return null;
    }
}
