package com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static final SparseArray<Object> ms(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        xrVarMs.ms(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public List get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        xrVarMs.ms(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public List get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        xrVarMs.ms(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        xrVarMs.ms(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        xrVarMs.ms(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return xrVarMs.xr().sparseArray();
    }
}
