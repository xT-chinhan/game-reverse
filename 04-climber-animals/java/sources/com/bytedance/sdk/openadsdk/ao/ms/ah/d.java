package com.bytedance.sdk.openadsdk.ao.ms.ah;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final SparseArray<Object> ms(final TTCustomController tTCustomController) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        if (tTCustomController == null) {
            return null;
        }
        xrVarMs.ms(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseLocation());
            }
        });
        xrVarMs.ms(262102, new ValueSet.ValueGetter<SparseArray<Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                return ah.ms(tTCustomController.getTTLocation());
            }
        });
        xrVarMs.ms(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.alist());
            }
        });
        xrVarMs.ms(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUsePhoneState());
            }
        });
        xrVarMs.ms(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getDevImei();
            }
        });
        xrVarMs.ms(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseWifiState());
            }
        });
        xrVarMs.ms(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getMacAddress();
            }
        });
        xrVarMs.ms(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseWriteExternal());
            }
        });
        xrVarMs.ms(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.13
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getDevOaid();
            }
        });
        xrVarMs.ms(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseAndroidId());
            }
        });
        xrVarMs.ms(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.xr.ms(tTCustomController.getMediationPrivacyConfig()) : null);
        xrVarMs.ms(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getAndroidId();
            }
        });
        xrVarMs.ms(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUsePermissionRecordAudio());
            }
        });
        xrVarMs.ms(262119, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.d.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map get() {
                return tTCustomController.userPrivacyConfig();
            }
        });
        return xrVarMs.xr().sparseArray();
    }
}
