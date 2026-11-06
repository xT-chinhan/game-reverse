package com.byazt.mo;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements TTFullScreenVideoAd {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

    public tj(Function<SparseArray<Object>, Object> function) {
        this.qg = com.byazt.qvu.s.n;
        function = function == null ? com.byazt.qvu.s.qg : function;
        this.n = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.qg = com.byazt.qvu.s.n((SparseArray<Object>) objApply).qg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.io.qg(tTAdInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 130101);
        sparseArray.put(-99999985, Void.class);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            sparseArray.put(0, new com.byazt.avv.qg((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.byazt.hg.n(fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 0);
        }
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130102);
        sparseArray.put(0, new com.byazt.io.s(tTAppDownloadListener));
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.qg.intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 130104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, ritScenes == null ? null : ritScenes.getScenesName());
        sparseArray.put(2, str);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.qg.objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.qg.intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.qg.longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130106);
        sparseArray.put(-99999985, Object.class);
        return new com.byazt.oe.s(k.n(this.n.apply(sparseArray)));
    }
}
