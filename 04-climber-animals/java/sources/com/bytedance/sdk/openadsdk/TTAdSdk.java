package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.api.c;
import com.bytedance.sdk.openadsdk.api.ms;
import com.bytedance.sdk.openadsdk.api.plugin.x;
import com.bytedance.sdk.openadsdk.live.ah;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import com.umeng.analytics.pro.r;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TTAdSdk {
    public static final String BRANCH = "v6900";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "53624fc";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 6923;
    public static final String SDK_VERSION_NAME = "6.9.2.3";
    public static final String S_C = "main";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ms f1639ms = new x();
    private static volatile TTAdConfig xr;

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    @Deprecated
    public static boolean isInitSuccess() {
        ms msVar = f1639ms;
        if (msVar != null) {
            return msVar.ms();
        }
        return false;
    }

    public static boolean isSdkReady() {
        ms msVar = f1639ms;
        if (msVar != null) {
            return msVar.ms();
        }
        return false;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        xr = tTAdConfig;
        ms(context, xr);
        return true;
    }

    public static void start(Callback callback) {
        ms(xr, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        ms msVar = f1639ms;
        if (msVar == null) {
            callback.fail(r.a.d, "Load initializer failed");
        } else {
            msVar.ms(TTAppContextHolder.getContext(), xr, callback);
        }
    }

    private static void ms(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            ab.ms();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            ab.ms("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        ms(context, "Context is null, please check.");
        ms(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        ms msVar = f1639ms;
        if (msVar != null) {
            return msVar.xr();
        }
        return null;
    }

    public static IMediationManager getMediationManager() {
        if (f1639ms != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_name", "use_mediation_map");
        Map map = (Map) adManager.getExtra(Map.class, bundle);
        if (map == null || !(map.get("use_mediation_map") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) map.get("use_mediation_map")).booleanValue();
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        ms.ah ahVarXr;
        if (c.ms() || tTAdConfig == null || (ahVarXr = f1639ms.xr()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (!bundle.keySet().isEmpty()) {
            ahVarXr.getExtra(ValueSet.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra == null || initExtra.isEmpty()) {
                return;
            }
            mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (c.ms() || tTAdConfig == null || (initExtra = tTAdConfig.getInitExtra()) == null) {
            return;
        }
        Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
        if (obj instanceof Map) {
            ah.ms().ms((Map<String, String>) obj);
        }
    }

    public static View getEcMallBackUpView() {
        ms.ah ahVarXr = f1639ms.xr();
        if (ahVarXr == null) {
            return null;
        }
        return (View) ahVarXr.getExtra(View.class, null);
    }

    public static void updatePaid(boolean z) {
        ms.ah ahVarXr = f1639ms.xr();
        if (ahVarXr == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        ahVarXr.getExtra(ValueSet.class, bundle);
    }

    private static void ms(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
