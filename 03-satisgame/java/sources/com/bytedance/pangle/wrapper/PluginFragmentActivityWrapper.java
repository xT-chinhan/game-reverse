package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.byazt.gx.rv;
import com.byazt.ry.n;
import com.byazt.vx.w;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class PluginFragmentActivityWrapper extends GenerateFragmentActivityWrapper {
    public boolean hasInit = true;

    public PluginFragmentActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = (FragmentActivity) activity;
        this.pluginContext = pluginContext;
        if (!this.mOriginActivity.isDestroyed()) {
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(new n() { // from class: com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper.1
                @Override // com.byazt.ry.n, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    super.onActivityDestroyed(activity2);
                    if (activity2 == PluginFragmentActivityWrapper.this.mOriginActivity) {
                        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!rv.n()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException e) {
            w.n(e);
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException e2) {
            w.n(e2);
        }
        com.byazt.gx.n.n(this, activity);
    }

    @Override // com.bytedance.pangle.wrapper.GenerateFragmentActivityWrapper, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        if (!this.hasInit) {
            try {
                LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
                try {
                    Field declaredField = lifecycleRegistry.getClass().getDeclaredField("mEnforceMainThread");
                    declaredField.setAccessible(true);
                    declaredField.set(lifecycleRegistry, Boolean.FALSE);
                } catch (Throwable unused) {
                }
                return lifecycleRegistry;
            } catch (Throwable unused2) {
            }
        }
        return super.getLifecycle();
    }

    public Activity getOriginActivity() {
        return this.mOriginActivity;
    }
}
