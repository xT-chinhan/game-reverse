package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.byazt.ea.s;
import com.byazt.nf.rv;
import com.byazt.qyu.tj;
import com.byazt.vx.l;
import com.byazt.vx.w;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 55, 56, 57, 682})
public final class TTAdSdk {
    public static final String BRANCH = "";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "15a431ecc5";
    public static final int EXT_API_VERSION_CODE = 1000;
    public static final boolean INCLUDE_LIVE = true;
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final boolean PC_BOOST_ABI = true;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7814;
    public static final String SDK_VERSION_NAME = "7.8.1.4";
    public static final String S_C = "main";
    private static volatile TTAdConfig n;

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    @com.byazt.cp.n(n = {0, 55, 56, 57, 1311})
    private static final class n {
        private static final com.byazt.vx.n n = new tj();
    }

    @Deprecated
    public static boolean isInitSuccess() {
        return n.n.qg();
    }

    public static boolean isSdkReady() {
        return n.n.qg();
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        rv.n(context);
        if (tTAdConfig != null && (initExtra = tTAdConfig.getInitExtra()) != null) {
            initExtra.put("csj_c_i_ts", Long.valueOf(SystemClock.elapsedRealtime()));
        }
        n = tTAdConfig;
        n(context, n);
        return true;
    }

    public static void start(Callback callback) {
        n(n, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        n.n.n(TTAppContextHolder.getContext(), n, callback);
    }

    private static void n(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            w.n();
        }
        n(context, "Context is null, please check.");
        n(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        return n.n.s();
    }

    public static IMediationManager getMediationManager() {
        return MediationManagerVisitor.getInstance().getMediationManager();
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
        com.byazt.vx.n.s sVarS;
        if (l.n() || tTAdConfig == null || (sVarS = n.n.s()) == null) {
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
            sVarS.getExtra(SparseArray.class, bundle);
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
        if (l.n() || tTAdConfig == null || (initExtra = tTAdConfig.getInitExtra()) == null) {
            return;
        }
        Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
        if (obj instanceof Map) {
            s.n().n((Map<String, String>) obj);
        }
    }

    public static View getEcMallBackUpView() {
        com.byazt.vx.n.s sVarS = n.n.s();
        if (sVarS == null) {
            return null;
        }
        return (View) sVarS.getExtra(View.class, null);
    }

    public static void updatePaid(boolean z) {
        com.byazt.vx.n.s sVarS = n.n.s();
        if (sVarS == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        sVarS.getExtra(SparseArray.class, bundle);
    }

    private static void n(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
