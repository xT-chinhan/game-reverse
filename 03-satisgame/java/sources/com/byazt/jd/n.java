package com.byazt.jd;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 788, 19})
public class n {
    public static SparseArray<Object> n(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        sVarN.n(261001, adConfig.getAppId());
        sVarN.n(261002, adConfig.getAppName());
        sVarN.n(261003, adConfig.isPaid());
        sVarN.n(261004, adConfig.getKeywords());
        sVarN.n(261005, adConfig.getData());
        sVarN.n(261006, adConfig.getTitleBarTheme());
        sVarN.n(261007, adConfig.isAllowShowNotify());
        sVarN.n(261008, adConfig.isDebug());
        sVarN.n(261009, adConfig.getDirectDownloadNetworkType());
        sVarN.n(261011, adConfig.isSupportMultiProcess());
        sVarN.n(261012, q.n(adConfig.getCustomController()));
        sVarN.n(261013, new Supplier<Integer>() { // from class: com.byazt.jd.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        sVarN.n(261014, new Supplier<Integer>() { // from class: com.byazt.jd.n.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        sVarN.n(261015, new Supplier<Integer>() { // from class: com.byazt.jd.n.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        sVarN.n(261016, adConfig.getMediationConfig() != null ? com.byazt.jw.n.n(adConfig.getMediationConfig()) : null);
        sVarN.n(261017, adConfig.isUseMediation());
        sVarN.n(261018, new Supplier<Map<String, Object>>() { // from class: com.byazt.jd.n.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return adConfig.getInitExtra();
            }
        });
        return sVarN.qg().sparseArray();
    }
}
