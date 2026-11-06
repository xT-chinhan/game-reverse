package com.byazt.jd;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 788, 5})
public class q {
    public static final SparseArray<Object> n(final TTCustomController tTCustomController) {
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        sVarN.n(262101, new Supplier<Boolean>() { // from class: com.byazt.jd.q.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        sVarN.n(262102, new Supplier<SparseArray<Object>>() { // from class: com.byazt.jd.q.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return s.n(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        sVarN.n(262103, new Supplier<Boolean>() { // from class: com.byazt.jd.q.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        sVarN.n(262104, new Supplier<Boolean>() { // from class: com.byazt.jd.q.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        sVarN.n(262105, new Supplier<String>() { // from class: com.byazt.jd.q.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        sVarN.n(262106, new Supplier<Boolean>() { // from class: com.byazt.jd.q.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        sVarN.n(262107, new Supplier<String>() { // from class: com.byazt.jd.q.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        sVarN.n(262108, new Supplier<Boolean>() { // from class: com.byazt.jd.q.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        sVarN.n(262109, new Supplier<String>() { // from class: com.byazt.jd.q.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        sVarN.n(262110, new Supplier<Boolean>() { // from class: com.byazt.jd.q.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        sVarN.n(262113, (tTCustomController == null || tTCustomController.getMediationPrivacyConfig() == null) ? null : com.byazt.jw.qg.n(tTCustomController.getMediationPrivacyConfig()));
        sVarN.n(262112, new Supplier<String>() { // from class: com.byazt.jd.q.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        sVarN.n(262111, new Supplier<Boolean>() { // from class: com.byazt.jd.q.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        sVarN.n(262119, new Supplier<Map>() { // from class: com.byazt.jd.q.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        sVarN.n(262120, new Supplier<Boolean>() { // from class: com.byazt.jd.q.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        sVarN.n(262121, new Supplier<Boolean>() { // from class: com.byazt.jd.q.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController == null);
            }
        });
        return sVarN.qg().sparseArray();
    }
}
