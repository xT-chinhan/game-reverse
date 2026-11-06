package com.tapsdk.tapad.group;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.lib_tapadadapter.TapTapADNManagerHolder;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class DirichletAdManager {
    private final WeakHashMap<Context, DirichletAdNative> adNativeMap;

    public static final class DirichletAdManagerHolder {
        private static final DirichletAdManager HOLDER = new DirichletAdManager();

        private DirichletAdManagerHolder() {
        }
    }

    public static DirichletAdManager get() {
        return DirichletAdManagerHolder.HOLDER;
    }

    public boolean checkArgs(Context context, DirichletAdConfig dirichletAdConfig, DirichletSdk.InitListener initListener) {
        if (!(context instanceof Application)) {
            if (initListener != null) {
                initListener.onInitFail(-1, "context 不合法，请输入 Application");
            }
            return false;
        }
        if (dirichletAdConfig == null) {
            if (initListener != null) {
                initListener.onInitFail(-1, "config 不能为空");
            }
            return false;
        }
        if (!TextUtils.isEmpty(dirichletAdConfig.mMediaKey) && dirichletAdConfig.mMediaKey.length() == 64) {
            return true;
        }
        if (initListener != null) {
            initListener.onInitFail(-1, "mediaKey 不合法");
        }
        return false;
    }

    public synchronized DirichletAdNative createAdNative(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("请传入合法的 context");
            }
            if (this.adNativeMap.containsKey(context)) {
                return this.adNativeMap.get(context);
            }
            DirichletAdNativeImpl dirichletAdNativeImpl = new DirichletAdNativeImpl(context);
            this.adNativeMap.put(context, dirichletAdNativeImpl);
            return dirichletAdNativeImpl;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void requestPermissionIfNecessary(Context context) {
        try {
            WeakHashMap<Context, TapAdNative> weakHashMap = TapTapADNManagerHolder.tapAdNativeMap;
            TapTapADNManagerHolder.class.getMethod("requestPermissionIfNecessary", Context.class).invoke(null, context);
        } catch (Throwable th) {
        }
    }

    private DirichletAdManager() {
        this.adNativeMap = new WeakHashMap<>();
    }
}
