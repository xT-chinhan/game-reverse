package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.openadsdk.ao.ms.ah.xr {
    public static AdSlot ms(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        if (valueSetXr != null) {
            builder.setAdId(valueSetXr.stringValue(260001)).setCodeId(valueSetXr.stringValue(260002)).setExt(valueSetXr.stringValue(260003)).setCodeId(valueSetXr.stringValue(260004)).setIsAutoPlay(valueSetXr.booleanValue(260005)).setImageAcceptedSize(valueSetXr.intValue(260006), valueSetXr.intValue(260007)).setExpressViewAcceptedSize(valueSetXr.floatValue(260008), valueSetXr.floatValue(260009)).setSupportDeepLink(valueSetXr.booleanValue(260010)).setAdCount(valueSetXr.intValue(2600012)).setMediaExtra(valueSetXr.stringValue(260013)).setUserID(valueSetXr.stringValue(260014)).setExternalABVid((int[]) valueSetXr.objectValue(260017, int[].class)).setAdloadSeq(valueSetXr.intValue(260018)).setPrimeRit(valueSetXr.stringValue(260019)).setAdType(valueSetXr.intValue(260020)).withBid(valueSetXr.stringValue(260021)).setUserData(valueSetXr.stringValue(260022)).setAdLoadType((TTAdLoadType) valueSetXr.objectValue(260023, TTAdLoadType.class)).setMediationAdSlot(new C0336ms(ao.ms(valueSetXr.objectValue(8260028, Object.class))).ms()).setOrientation(valueSetXr.intValue(260015)).setRewardName((String) valueSetXr.objectValue(260024, String.class)).setRewardAmount(valueSetXr.intValue(260025));
            if (valueSetXr.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.mediation.xr.ms.ms$ms, reason: collision with other inner class name */
    public static class C0336ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Function<SparseArray<Object>, Object> f4044ms;

        public C0336ms(Function<SparseArray<Object>, Object> function) {
            this.f4044ms = function;
        }

        public IMediationAdSlot ms() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260030);
            Object objApply = this.f4044ms.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }
}
