package com.mar.sdk.manager;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.mar.sdk.IApplicationListener;
import com.mar.sdk.IFullApplicationListener;
import com.mar.sdk.SDKTools;
import com.mar.sdk.log.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARPluginAppManager {
    private static final String APP_GAME_NAME = "MAR_Game_Application";
    private static final String APP_PROXY_NAME = "MAR_APPLICATION_PROXY_NAME";
    private static final String DEFAULT_PKG_NAME = "com.mar.sdk";
    private static final String TAG = "MARSDK";
    private final List<IApplicationListener> applicationListeners = new ArrayList(10);

    public void onAppCreate(Application application) {
        for (IApplicationListener lis : this.applicationListeners) {
            lis.onProxyCreate();
        }
    }

    public void onAppCreateAll(Application application) {
        for (IApplicationListener lis : this.applicationListeners) {
            if (lis instanceof IFullApplicationListener) {
                ((IFullApplicationListener) lis).onProxyCreateAll();
            }
        }
    }

    public void onAppAttachBaseContext(Application application, Context context, Bundle metaData) {
        String gameAppName;
        IApplicationListener listener;
        this.applicationListeners.clear();
        try {
            if (metaData.containsKey(APP_PROXY_NAME)) {
                String proxyAppNames = metaData.getString(APP_PROXY_NAME);
                String[] proxyApps = proxyAppNames.split(",");
                for (String proxy : proxyApps) {
                    if (!TextUtils.isEmpty(proxy)) {
                        Log.d(TAG, "add a new application listener:" + proxy);
                        IApplicationListener listener2 = newApplicationInstance(application, proxy);
                        if (listener2 != null) {
                            this.applicationListeners.add(listener2);
                        }
                    }
                }
            }
            if (metaData.containsKey(APP_GAME_NAME) && (listener = newApplicationInstance(application, (gameAppName = metaData.getString(APP_GAME_NAME)))) != null) {
                Log.e(TAG, "add a game application listener:" + gameAppName);
                this.applicationListeners.add(listener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (IApplicationListener lis : this.applicationListeners) {
            lis.onProxyAttachBaseContext(context);
        }
    }

    public void onAppConfigurationChanged(Application application, Configuration newConfig) {
        for (IApplicationListener lis : this.applicationListeners) {
            lis.onProxyConfigurationChanged(newConfig);
        }
    }

    public void onTerminate() {
        for (IApplicationListener lis : this.applicationListeners) {
            lis.onProxyTerminate();
        }
        Log.destory();
    }

    private static IApplicationListener newApplicationInstance(Application application, String proxyAppName) {
        if (proxyAppName == null || SDKTools.isNullOrEmpty(proxyAppName)) {
            return null;
        }
        if (proxyAppName.startsWith(".")) {
            proxyAppName = "com.mar.sdk" + proxyAppName;
        }
        try {
            return (IApplicationListener) Class.forName(proxyAppName).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
