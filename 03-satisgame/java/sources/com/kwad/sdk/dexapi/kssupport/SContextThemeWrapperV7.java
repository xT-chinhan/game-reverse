package com.kwad.sdk.dexapi.kssupport;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes3.dex */
public class SContextThemeWrapperV7 extends ContextThemeWrapper {
    public SContextThemeWrapperV7() {
    }

    public SContextThemeWrapperV7(Context context, int i) {
        super(context, i);
    }

    public SContextThemeWrapperV7(Context context, Resources.Theme theme) {
        super(context, theme);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper
    public int getThemeResId() {
        return super.getThemeResId();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return super.getAssets();
    }
}
