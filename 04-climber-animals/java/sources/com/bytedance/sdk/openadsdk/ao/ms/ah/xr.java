package com.bytedance.sdk.openadsdk.ao.ms.ah;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static final SparseArray<Object> ms(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(260001, adSlot.getAdId());
        xrVarMs.ms(260002, adSlot.getCreativeId());
        xrVarMs.ms(260003, adSlot.getExt());
        xrVarMs.ms(260004, adSlot.getCodeId());
        xrVarMs.ms(260005, adSlot.isAutoPlay());
        xrVarMs.ms(260006, adSlot.getImgAcceptedWidth());
        xrVarMs.ms(260007, adSlot.getImgAcceptedHeight());
        xrVarMs.ms(260008, adSlot.getExpressViewAcceptedWidth());
        xrVarMs.ms(260009, adSlot.getExpressViewAcceptedHeight());
        xrVarMs.ms(260010, adSlot.isSupportDeepLink());
        xrVarMs.ms(260011, adSlot.isSupportRenderConrol());
        xrVarMs.ms(2600012, adSlot.getAdCount());
        xrVarMs.ms(260013, adSlot.getMediaExtra());
        xrVarMs.ms(260014, adSlot.getUserID());
        xrVarMs.ms(260015, adSlot.getOrientation());
        xrVarMs.ms(260016, adSlot.getNativeAdType());
        xrVarMs.ms(260017, adSlot.getExternalABVid());
        xrVarMs.ms(260018, adSlot.getAdloadSeq());
        xrVarMs.ms(260019, adSlot.getPrimeRit());
        xrVarMs.ms(260020, adSlot.getAdType());
        xrVarMs.ms(260021, adSlot.getBidAdm());
        xrVarMs.ms(260022, adSlot.getUserData());
        xrVarMs.ms(260023, adSlot.getAdLoadType());
        xrVarMs.ms(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.xr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        xrVarMs.ms(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.xr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        xrVarMs.ms(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ah.xr.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            xrVarMs.ms(8260028, new ka(adSlot.getMediationAdSlot()));
        }
        return xrVarMs.xr().sparseArray();
    }
}
