package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.byazt.ae.pr;
import com.byazt.gs.aj;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PluginActivityWrapper extends GenerateActivityWrapper {
    public static final int OBJECT_TAG = Integer.MAX_VALUE;

    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!this.mOriginActivity.isDestroyed()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new pr() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.1
                    });
                } else if (Build.VERSION.SDK_INT >= 24) {
                    setTag();
                } else {
                    registerApplicationLifecycleCallbacks();
                }
            }
        } catch (Exception e) {
            registerApplicationLifecycleCallbacks();
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!aj.pr()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException e2) {
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException e3) {
        }
        com.byazt.gs.pr.pr(this, activity);
    }

    private void registerApplicationLifecycleCallbacks() {
        final Application appApplication = Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new pr() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2
            @Override // com.byazt.ae.pr, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity == PluginActivityWrapper.this.mOriginActivity) {
                    appApplication.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new pr() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }
}
