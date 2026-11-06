package com.byazt.xs;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 676, 13})
public class hw {
    public static final SparseArray<Object> pr(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        hnVarPr.pr(262114, new Supplier<List<String>>() { // from class: com.byazt.xs.hw.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        hnVarPr.pr(262115, new Supplier<List<String>>() { // from class: com.byazt.xs.hw.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        hnVarPr.pr(262116, new Supplier<Boolean>() { // from class: com.byazt.xs.hw.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        hnVarPr.pr(262117, new Supplier<Boolean>() { // from class: com.byazt.xs.hw.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        hnVarPr.pr(262118, new Supplier<Boolean>() { // from class: com.byazt.xs.hw.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return hnVarPr.hw().sparseArray();
    }
}
