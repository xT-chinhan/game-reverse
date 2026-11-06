package com.byazt.bm;

import android.util.SparseArray;
import com.byazt.xjg.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 13})
public class hw {
    public static final SparseArray<Object> pr(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        hnVarPr.pr(260001, adSlot.getAdId());
        hnVarPr.pr(260002, adSlot.getCreativeId());
        hnVarPr.pr(260003, adSlot.getExt());
        hnVarPr.pr(260004, adSlot.getCodeId());
        hnVarPr.pr(260005, adSlot.isAutoPlay());
        hnVarPr.pr(260006, adSlot.getImgAcceptedWidth());
        hnVarPr.pr(260007, adSlot.getImgAcceptedHeight());
        hnVarPr.pr(260008, adSlot.getExpressViewAcceptedWidth());
        hnVarPr.pr(260009, adSlot.getExpressViewAcceptedHeight());
        hnVarPr.pr(260010, adSlot.isSupportDeepLink());
        hnVarPr.pr(260011, adSlot.isSupportRenderConrol());
        hnVarPr.pr(2600012, adSlot.getAdCount());
        hnVarPr.pr(260013, adSlot.getMediaExtra());
        hnVarPr.pr(260014, adSlot.getUserID());
        hnVarPr.pr(260015, adSlot.getOrientation());
        hnVarPr.pr(260016, adSlot.getNativeAdType());
        hnVarPr.pr(260017, adSlot.getExternalABVid());
        hnVarPr.pr(260018, adSlot.getAdloadSeq());
        hnVarPr.pr(260019, adSlot.getPrimeRit());
        hnVarPr.pr(260020, adSlot.getAdType());
        hnVarPr.pr(260021, adSlot.getBidAdm());
        hnVarPr.pr(260022, adSlot.getUserData());
        hnVarPr.pr(260023, pr(adSlot.getAdLoadType()));
        hnVarPr.pr(260024, new Supplier<String>() { // from class: com.byazt.bm.hw.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        hnVarPr.pr(260025, new Supplier<Integer>() { // from class: com.byazt.bm.hw.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        hnVarPr.pr(260026, new Supplier<Boolean>() { // from class: com.byazt.bm.hw.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            hnVarPr.pr(8260028, new com.byazt.x.pr(adSlot.getMediationAdSlot()));
        }
        return hnVarPr.hw().sparseArray();
    }

    public static AdSlot pr(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        if (valueSetHw != null) {
            builder.setAdId(valueSetHw.stringValue(260001)).setCreativeId(valueSetHw.stringValue(260002)).setExt(valueSetHw.stringValue(260003)).setCodeId(valueSetHw.stringValue(260004)).setIsAutoPlay(valueSetHw.booleanValue(260005)).setImageAcceptedSize(valueSetHw.intValue(260006), valueSetHw.intValue(260007)).setExpressViewAcceptedSize(valueSetHw.floatValue(260008), valueSetHw.floatValue(260009)).setSupportDeepLink(valueSetHw.booleanValue(260010)).setAdCount(valueSetHw.intValue(2600012)).setMediaExtra(valueSetHw.stringValue(260013)).setUserID(valueSetHw.stringValue(260014)).setExternalABVid((int[]) valueSetHw.objectValue(260017, int[].class)).setAdloadSeq(valueSetHw.intValue(260018)).setPrimeRit(valueSetHw.stringValue(260019)).setAdType(valueSetHw.intValue(260020)).withBid(valueSetHw.stringValue(260021)).setUserData(valueSetHw.stringValue(260022)).setAdLoadType(pr(valueSetHw.intValue(260023))).setMediationAdSlot(new pr(ho.pr(valueSetHw.objectValue(8260028, Object.class))).pr()).setOrientation(valueSetHw.intValue(260015)).setRewardName((String) valueSetHw.objectValue(260024, String.class)).setRewardAmount(valueSetHw.intValue(260025));
            if (valueSetHw.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer pr(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        if (tTAdLoadType != TTAdLoadType.PRELOAD) {
            return null;
        }
        return 1;
    }

    private static TTAdLoadType pr(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public Function<SparseArray<Object>, Object> pr;

        public pr(Function<SparseArray<Object>, Object> function) {
            this.pr = function;
        }

        public IMediationAdSlot pr() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260031);
            Object objApply = this.pr.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }
}
