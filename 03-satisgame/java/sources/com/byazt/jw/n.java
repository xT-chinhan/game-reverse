package com.byazt.jw;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 69, 19})
public class n {
    public static final SparseArray<Object> n(final IMediationConfig iMediationConfig) {
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        if (iMediationConfig == null) {
            return null;
        }
        sVarN.n(264101, new Supplier<String>() { // from class: com.byazt.jw.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        sVarN.n(264102, new Supplier<Boolean>() { // from class: com.byazt.jw.n.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        sVarN.n(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? s.n(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        sVarN.n(264104, new Supplier<Map<String, Object>>() { // from class: com.byazt.jw.n.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        sVarN.n(264105, new Supplier<Boolean>() { // from class: com.byazt.jw.n.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        sVarN.n(264106, new Supplier<JSONObject>() { // from class: com.byazt.jw.n.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        sVarN.n(264107, new Supplier<String>() { // from class: com.byazt.jw.n.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        sVarN.n(264108, new Supplier<Boolean>() { // from class: com.byazt.jw.n.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        sVarN.n(264109, new Supplier<Boolean>() { // from class: com.byazt.jw.n.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        sVarN.n(264110, new Supplier<Boolean>() { // from class: com.byazt.jw.n.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        sVarN.n(264111, new Supplier<String>() { // from class: com.byazt.jw.n.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return sVarN.qg().sparseArray();
    }
}
