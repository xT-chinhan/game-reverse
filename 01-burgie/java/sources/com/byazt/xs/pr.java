package com.byazt.xs;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 676, 37})
public class pr {
    public static final SparseArray<Object> pr(final IMediationConfig iMediationConfig) {
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        if (iMediationConfig == null) {
            return null;
        }
        hnVarPr.pr(264101, new Supplier<String>() { // from class: com.byazt.xs.pr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        hnVarPr.pr(264102, new Supplier<Boolean>() { // from class: com.byazt.xs.pr.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        hnVarPr.pr(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? hn.pr(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        hnVarPr.pr(264104, new Supplier<Map<String, Object>>() { // from class: com.byazt.xs.pr.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        hnVarPr.pr(264105, new Supplier<Boolean>() { // from class: com.byazt.xs.pr.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        hnVarPr.pr(264106, new Supplier<JSONObject>() { // from class: com.byazt.xs.pr.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        hnVarPr.pr(264107, new Supplier<String>() { // from class: com.byazt.xs.pr.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        hnVarPr.pr(264108, new Supplier<Boolean>() { // from class: com.byazt.xs.pr.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        hnVarPr.pr(264109, new Supplier<Boolean>() { // from class: com.byazt.xs.pr.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        hnVarPr.pr(264110, new Supplier<Boolean>() { // from class: com.byazt.xs.pr.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        hnVarPr.pr(264111, new Supplier<String>() { // from class: com.byazt.xs.pr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return hnVarPr.hw().sparseArray();
    }
}
