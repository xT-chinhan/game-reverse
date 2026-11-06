package com.bytedance.pangle.service;

import android.app.IntentService;
import android.content.ComponentName;
import com.byazt.qr.n;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PluginIntentService extends IntentService implements n {
    public static final String TAG = "PluginService";

    public PluginIntentService(String str) {
        super(str);
    }

    @Override // com.byazt.qr.n
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
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginIntentService.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                name.hashCode();
                if (name.equals("getForegroundServiceType")) {
                    return 0;
                }
                if (!name.equals("stopServiceToken")) {
                    return null;
                }
                com.byazt.p000do.n nVarQg = com.byazt.p000do.n.qg();
                PluginIntentService pluginIntentService = PluginIntentService.this;
                return Boolean.valueOf(nVarQg.n(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
            }
        });
    }
}
