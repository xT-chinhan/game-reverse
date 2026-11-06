package com.byazt.oe;

import android.util.SparseArray;
import com.byazt.hr.x;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1218, 5})
public class q implements MediationNativeManager {
    private final Function<SparseArray<Object>, Object> n;
    private ValueSet qg;

    public q(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.n.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270002);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.n.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new qg(k.n(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270003);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.n.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new n(k.n(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270004);
        sparseArray.put(-99999985, Object.class);
        return new n(k.n(this.n.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270005);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.n.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new n(k.n(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270006);
        sparseArray.put(-99999985, Object.class);
        return new n(k.n(this.n.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean hasDislike() {
        return this.qg.booleanValue(270008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setUseCustomVideo(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270009);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270010);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new x(mediationShakeViewListener));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean isExpress() {
        return this.qg.booleanValue(270011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onResume() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271048);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onPause() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271049);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
