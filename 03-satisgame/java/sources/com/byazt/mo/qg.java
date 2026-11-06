package com.byazt.mo;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 26})
public class qg implements CSJSplashAd {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

    public qg(Function<SparseArray<Object>, Object> function) {
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
        SparseArray<Object> sparseArray = new SparseArray<>(4);
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
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.io.qg(tTAdInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.qg.objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.qg.objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.qg.intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.qg.objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 110101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 110102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.io.s(tTAppDownloadListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 110103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.aj.n(splashAdListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 110106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.aj.qg(splashCardListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 110108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 110109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, activity);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 110110);
        sparseArray.put(-99999985, Function.class);
        return new com.byazt.oe.w(k.n(this.n.apply(sparseArray)));
    }
}
