package com.byazt.jw;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 69, 26})
public class qg {
    public static final SparseArray<Object> n(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        sVarN.n(262114, new Supplier<List<String>>() { // from class: com.byazt.jw.qg.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        sVarN.n(262115, new Supplier<List<String>>() { // from class: com.byazt.jw.qg.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        sVarN.n(262116, new Supplier<Boolean>() { // from class: com.byazt.jw.qg.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        sVarN.n(262117, new Supplier<Boolean>() { // from class: com.byazt.jw.qg.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        sVarN.n(262118, new Supplier<Boolean>() { // from class: com.byazt.jw.qg.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return sVarN.qg().sparseArray();
    }
}
