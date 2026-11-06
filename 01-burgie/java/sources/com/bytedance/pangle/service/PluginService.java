package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import com.byazt.zbu.pr;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PluginService extends Service implements pr {
    public static final String TAG = "PluginService";

    @Override // com.byazt.zbu.pr
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    public Object createActivityManagerProxy() throws ClassNotFoundException {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:14:0x002b  */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                byte b;
                String name = method.getName();
                switch (name.hashCode()) {
                    case 39551382:
                        if (!name.equals("setServiceForeground")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 690954390:
                        if (!name.equals("getForegroundServiceType")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 1930712422:
                        if (!name.equals("stopServiceToken")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        com.byazt.wee.pr prVarHw = com.byazt.wee.pr.hw();
                        PluginService pluginService = PluginService.this;
                        return Boolean.valueOf(prVarHw.pr(new ComponentName(pluginService, pluginService.getClass().getName())));
                    case 1:
                    default:
                        return null;
                    case 2:
                        return 0;
                }
            }
        });
    }
}
