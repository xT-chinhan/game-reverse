package com.byazt.lt;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.byazt.avv.l;
import com.byazt.avv.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1377, 26})
public class qg implements IMediationManager {
    private Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        qg(function);
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        qg(function);
    }

    private void qg(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            function = com.byazt.qvu.s.qg;
        }
        this.n = function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, activity);
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator<IMediationPreloadRequestInfo> it = list.iterator();
            while (it.hasNext()) {
                linkedList.add(new q(it.next()));
            }
            sparseArray.put(1, linkedList);
        }
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270013);
        sparseArray.put(-99999985, Void.class);
        this.n.apply((SparseArray<Object>) sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270014);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, com.byazt.jw.s.n(mediationConfigUserInfoForSegment));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270015);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270016);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, com.byazt.jd.q.n(tTCustomController));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updateLocalExtra(Map<String, Object> map) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 271050);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, map);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270017);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270018);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        sparseArray.put(1, iArr);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270019);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270020);
        sparseArray.put(-99999985, Integer.TYPE);
        sparseArray.put(0, new l(mediationAppDialogClickListener));
        return ((Integer) this.n.apply(sparseArray)).intValue();
    }

    private SparseArray<Object> n(AdSlot adSlot) {
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n(com.byazt.jd.qg.n(adSlot));
        sVarN.n(8302, MediationAdClassLoader.getInstance());
        return sVarN.qg().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, context);
        sparseArray.put(1, n(adSlot));
        sparseArray.put(2, new com.byazt.avv.s(iMediationNativeAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270021);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, context);
        sparseArray.put(1, n(adSlot));
        sparseArray.put(2, new com.byazt.avv.n(iMediationDrawAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270022);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270024);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArray2 = new SparseArray<>(3);
        sparseArray2.put(-99999987, 271043);
        sparseArray2.put(-99999985, Object.class);
        sparseArray2.put(0, Integer.valueOf(i));
        if (sparseArray != null) {
            sparseArray2.put(1, sparseArray);
        } else {
            sparseArray2.put(1, new SparseArray());
        }
        return this.n.apply(sparseArray2);
    }
}
