package com.kwad.sdk.api.loader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.api.core.ResContext;

/* JADX INFO: loaded from: classes3.dex */
class ResContextThemeWrapper extends ContextThemeWrapper implements ResContext {
    private final ContextThemeWrapper mContext;
    private Resources.Theme mTheme;
    private int mThemeResId;

    ResContextThemeWrapper(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.mContext = contextThemeWrapper;
        this.mThemeResId = ((Integer) ApiReflect.on(contextThemeWrapper).call("getThemeResId").get()).intValue();
    }

    @Override // com.kwad.sdk.api.core.ResContext
    public Context getDelegatedContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mContext.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return Wrapper.wrapContextIfNeed(super.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return Wrapper.wrapContextIfNeed(super.getBaseContext());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return Wrapper.replaceExternalResources(super.getResources());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mThemeResId = i;
        super.setTheme(i);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.mTheme;
        if (theme2 == null || theme2 == theme) {
            this.mTheme = Wrapper.replaceTheme(theme, theme2, this.mThemeResId);
        }
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return Wrapper.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return Wrapper.wrapSystemService(this.mContext.getSystemService(str), str, this);
    }
}
