package com.bytedance.pangle;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.byazt.ae.fw;
import com.byazt.dea.uc;
import com.byazt.gy.pr;
import com.byazt.zc.hw;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class PluginContext extends fw {
    public static Class<?> sContextThemeWrapperClass;
    public LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public Context mOriginContext;
    public Configuration mOverrideConfiguration;
    public Plugin mPlugin;

    static {
        try {
            sContextThemeWrapperClass = Class.forName("android.support.v7.view.ContextThemeWrapper");
        } catch (Throwable th) {
        }
    }

    public PluginContext() {
    }

    public PluginContext(Context context, Plugin plugin, boolean z) {
        super(getContextWithoutTheme(context), getThemeResourceId(context));
        this.mPlugin = plugin;
        this.mOriginContext = context;
        this.mIsHostApplicationContext = z;
    }

    public static int getThemeResourceId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            try {
                return ((Integer) FieldUtils.readField(context, "mThemeResource")).intValue();
            } catch (Throwable th) {
            }
        }
        Class<?> cls = sContextThemeWrapperClass;
        if (cls != null && cls.isInstance(context)) {
            return ((android.support.v7.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    @Override // com.byazt.ae.fw
    public String getPluginPkg() {
        return this.mPlugin.mPkgName;
    }

    public static Context getContextWithoutTheme(Context context) {
        if (context instanceof ContextThemeWrapper) {
            return getContextWithoutTheme(((ContextThemeWrapper) context).getBaseContext());
        }
        Class<?> cls = sContextThemeWrapperClass;
        if (cls != null && cls.isInstance(context)) {
            return getContextWithoutTheme(((android.support.v7.view.ContextThemeWrapper) context).getBaseContext());
        }
        return context;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mPlugin.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new Configuration(configuration);
    }

    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mPlugin.mResources.getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mPlugin.mResources;
    }

    private Resources getResourcesInternal() {
        return this.mPlugin.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        Context contextCreateConfigurationContext = super.createConfigurationContext(configuration);
        try {
            FieldUtils.writeField(contextCreateConfigurationContext, "mResources", this.mPlugin.mResources);
        } catch (Throwable th) {
            try {
                pr.pr(contextCreateConfigurationContext.getClass(), "mResources").set(contextCreateConfigurationContext, this.mPlugin.mResources);
            } catch (Throwable th2) {
                uc.pr(th2);
            }
        }
        return contextCreateConfigurationContext;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
                this.mInflater = layoutInflaterCloneInContext;
                hw.pr(layoutInflaterCloneInContext);
            }
            return this.mInflater;
        }
        Context context = this.mOriginContext;
        if (context != null) {
            return context.getSystemService(str);
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        if (baseContext instanceof ContextWrapper) {
            return ((ContextWrapper) baseContext).getBaseContext();
        }
        return baseContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPlugin.mClassLoader;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mPlugin.mHostApplicationInfoHookSomeField;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context context = this.mOriginContext;
        if (context instanceof PluginApplicationWrapper) {
            return context;
        }
        return ZeusTransformUtils.wrapperContext(context.getApplicationContext(), this.mPlugin.mPkgName);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.registerComponentCallbacks(componentCallbacks);
        } else {
            super.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.unregisterComponentCallbacks(componentCallbacks);
        } else {
            super.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    public String getPluginPackageName() {
        return this.mPlugin.mPkgName;
    }
}
