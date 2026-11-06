package com.byazt.mo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 113})
public class d implements TTNativeAd {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

    public d(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new cp((Function) this.qg.objectValue(140001, Function.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.qg.objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return this.qg.stringValue(140003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return this.qg.stringValue(140004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.qg.stringValue(140018);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.qg.intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.qg.intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.qg.intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.qg.stringValue(140008);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new cp(k.n(this.qg.objectValue(140009, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List arrayList = (List) this.qg.objectValue(140010, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new cp(k.n(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.qg.intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.qg.intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new q(k.n(this.qg.objectValue(140013, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new s(k.n(this.qg.objectValue(140014, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new l(k.n(this.qg.objectValue(140015, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.qg.objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.qg.objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140101);
        sparseArray.put(-99999985, Function.class);
        sparseArray.put(0, activity);
        return new x(k.n(this.n.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140102);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, k.n(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        return new x(k.n(this.n.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 140103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, view);
        sparseArray.put(2, new com.byazt.gj.n(adInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(-99999987, 140104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, new com.byazt.gj.n(adInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(7);
        sparseArray.put(-99999987, 140105);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, view);
        sparseArray.put(4, new com.byazt.gj.n(adInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(8);
        sparseArray.put(-99999987, 140106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, view);
        sparseArray.put(5, new com.byazt.gj.n(adInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(9);
        sparseArray.put(-99999987, 140107);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, list4);
        sparseArray.put(5, view);
        sparseArray.put(6, new com.byazt.gj.n(adInteractionListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.io.s(tTAppDownloadListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140110);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140111);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.gj.s(expressRenderListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140112);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.byazt.zp.n(dislikeInteractionCallback));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140113);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, k.n(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void uploadDislikeEvent(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140118);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140115);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setEasyPlayWidgetListener(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140119);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.gj.qg(easyPlayWidgetListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setIncentiveAdListener(TTNativeAd.IncentiveAdListener incentiveAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140120);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.gj.q(incentiveAdListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140114);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140116);
        sparseArray.put(-99999985, Object.class);
        return new com.byazt.oe.q(k.n(this.n.apply(sparseArray)));
    }
}
