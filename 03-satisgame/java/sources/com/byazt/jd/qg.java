package com.byazt.jd;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 788, 26})
public class qg {
    public static final SparseArray<Object> n(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        sVarN.n(260001, adSlot.getAdId());
        sVarN.n(260002, adSlot.getCreativeId());
        sVarN.n(260003, adSlot.getExt());
        sVarN.n(260004, adSlot.getCodeId());
        sVarN.n(260005, adSlot.isAutoPlay());
        sVarN.n(260006, adSlot.getImgAcceptedWidth());
        sVarN.n(260007, adSlot.getImgAcceptedHeight());
        sVarN.n(260008, adSlot.getExpressViewAcceptedWidth());
        sVarN.n(260009, adSlot.getExpressViewAcceptedHeight());
        sVarN.n(260010, adSlot.isSupportDeepLink());
        sVarN.n(260011, adSlot.isSupportRenderConrol());
        sVarN.n(2600012, adSlot.getAdCount());
        sVarN.n(260013, adSlot.getMediaExtra());
        sVarN.n(260014, adSlot.getUserID());
        sVarN.n(260015, adSlot.getOrientation());
        sVarN.n(260016, adSlot.getNativeAdType());
        sVarN.n(260017, adSlot.getExternalABVid());
        sVarN.n(260018, adSlot.getAdloadSeq());
        sVarN.n(260019, adSlot.getPrimeRit());
        sVarN.n(260020, adSlot.getAdType());
        sVarN.n(260021, adSlot.getBidAdm());
        sVarN.n(260022, adSlot.getUserData());
        sVarN.n(260023, n(adSlot.getAdLoadType()));
        sVarN.n(260024, new Supplier<String>() { // from class: com.byazt.jd.qg.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        sVarN.n(260025, new Supplier<Integer>() { // from class: com.byazt.jd.qg.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        sVarN.n(260026, new Supplier<Boolean>() { // from class: com.byazt.jd.qg.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            sVarN.n(8260028, new com.byazt.hr.n(adSlot.getMediationAdSlot()));
        }
        return sVarN.qg().sparseArray();
    }

    public static AdSlot n(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        if (valueSetQg != null) {
            builder.setAdId(valueSetQg.stringValue(260001)).setCreativeId(valueSetQg.stringValue(260002)).setExt(valueSetQg.stringValue(260003)).setCodeId(valueSetQg.stringValue(260004)).setIsAutoPlay(valueSetQg.booleanValue(260005)).setImageAcceptedSize(valueSetQg.intValue(260006), valueSetQg.intValue(260007)).setExpressViewAcceptedSize(valueSetQg.floatValue(260008), valueSetQg.floatValue(260009)).setSupportDeepLink(valueSetQg.booleanValue(260010)).setAdCount(valueSetQg.intValue(2600012)).setMediaExtra(valueSetQg.stringValue(260013)).setUserID(valueSetQg.stringValue(260014)).setExternalABVid((int[]) valueSetQg.objectValue(260017, int[].class)).setAdloadSeq(valueSetQg.intValue(260018)).setPrimeRit(valueSetQg.stringValue(260019)).setAdType(valueSetQg.intValue(260020)).withBid(valueSetQg.stringValue(260021)).setUserData(valueSetQg.stringValue(260022)).setAdLoadType(n(valueSetQg.intValue(260023))).setMediationAdSlot(new n(k.n(valueSetQg.objectValue(8260028, Object.class))).n()).setOrientation(valueSetQg.intValue(260015)).setRewardName((String) valueSetQg.objectValue(260024, String.class)).setRewardAmount(valueSetQg.intValue(260025));
            if (valueSetQg.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer n(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType n(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }

    @com.byazt.cp.n(n = {0, 1, 788, 48})
    public static class n {
        public Function<SparseArray<Object>, Object> n;

        public n(Function<SparseArray<Object>, Object> function) {
            this.n = function;
        }

        public IMediationAdSlot n() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260031);
            Object objApply = this.n.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }
}
