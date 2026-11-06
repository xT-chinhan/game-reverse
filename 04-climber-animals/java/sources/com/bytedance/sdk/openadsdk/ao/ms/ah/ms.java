package com.bytedance.sdk.openadsdk.ao.ms.ah;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static final SparseArray<Object> ms(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(261001, adConfig.getAppId());
        xrVarMs.ms(261002, adConfig.getAppName());
        xrVarMs.ms(261003, adConfig.isPaid());
        xrVarMs.ms(261004, adConfig.getKeywords());
        xrVarMs.ms(261005, adConfig.getData());
        xrVarMs.ms(261006, adConfig.getTitleBarTheme());
        xrVarMs.ms(261007, adConfig.isAllowShowNotify());
        xrVarMs.ms(261008, adConfig.isDebug());
        xrVarMs.ms(261009, adConfig.getDirectDownloadNetworkType());
        xrVarMs.ms(261011, adConfig.isSupportMultiProcess());
        xrVarMs.ms(261012, adConfig.getCustomController() != null ? d.ms(adConfig.getCustomController()) : null);
        xrVarMs.ms(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.ms.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        xrVarMs.ms(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.ms.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        xrVarMs.ms(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.ms.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        xrVarMs.ms(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.ms.ms(adConfig.getMediationConfig()) : null);
        xrVarMs.ms(261017, adConfig.isUseMediation());
        xrVarMs.ms(261018, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.ms.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map get() {
                return adConfig.getInitExtra();
            }
        });
        return xrVarMs.xr().sparseArray();
    }
}
