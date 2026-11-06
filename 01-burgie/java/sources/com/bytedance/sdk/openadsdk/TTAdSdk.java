package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.byazt.ay.hn;
import com.byazt.dea.c;
import com.byazt.dea.uc;
import com.byazt.mg.vk;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 78, 79, 80, MediaPlayer.MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT})
public final class TTAdSdk {
    public static final String BRANCH = "v7700";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "cf3afeb";
    public static final int EXT_API_VERSION_CODE = 1000;
    public static final boolean INCLUDE_LIVE = true;
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final boolean PC_BOOST_ABI = true;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7714;
    public static final String SDK_VERSION_NAME = "7.7.1.4";
    public static final String S_C = "main";
    private static volatile TTAdConfig pr;

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    @com.byazt.vzx.pr(pr = {0, 78, 79, 80, 1953})
    private static final class pr {
        private static final com.byazt.dea.pr pr = new vk();
    }

    @Deprecated
    public static boolean isInitSuccess() {
        return pr.pr.hw();
    }

    public static boolean isSdkReady() {
        return pr.pr.hw();
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        a.pr(context);
        if (tTAdConfig != null && (initExtra = tTAdConfig.getInitExtra()) != null) {
            initExtra.put("csj_c_i_ts", Long.valueOf(SystemClock.elapsedRealtime()));
        }
        pr = tTAdConfig;
        pr(context, pr);
        return true;
    }

    public static void start(Callback callback) {
        pr(pr, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        pr.pr.pr(TTAppContextHolder.getContext(), pr, callback);
    }

    private static void pr(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            uc.pr();
        }
        pr(context, "Context is null, please check.");
        pr(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        return pr.pr.hn();
    }

    public static IMediationManager getMediationManager() {
        return MediationManagerVisitor.getInstance().getMediationManager();
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager != null) {
            Bundle bundle = new Bundle();
            bundle.putString("extra_name", "use_mediation_map");
            Map map = (Map) adManager.getExtra(Map.class, bundle);
            if (map != null && (map.get("use_mediation_map") instanceof Boolean)) {
                return ((Boolean) map.get("use_mediation_map")).booleanValue();
            }
            return false;
        }
        return false;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        com.byazt.dea.pr.hn hnVarHn;
        if (c.pr() || tTAdConfig == null || (hnVarHn = pr.pr.hn()) == null) {
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
            hnVarHn.getExtra(SparseArray.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra != null && !initExtra.isEmpty()) {
                mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
            }
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (!c.pr() && tTAdConfig != null && (initExtra = tTAdConfig.getInitExtra()) != null) {
            Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
            if (obj instanceof Map) {
                hn.pr().pr((Map<String, String>) obj);
            }
        }
    }

    public static View getEcMallBackUpView() {
        com.byazt.dea.pr.hn hnVarHn = pr.pr.hn();
        if (hnVarHn == null) {
            return null;
        }
        return (View) hnVarHn.getExtra(View.class, null);
    }

    public static void updatePaid(boolean z) {
        com.byazt.dea.pr.hn hnVarHn = pr.pr.hn();
        if (hnVarHn == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (!bundle.keySet().isEmpty()) {
            hnVarHn.getExtra(SparseArray.class, bundle);
        }
    }

    private static void pr(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
