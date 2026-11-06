package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4038ms;

    public ab(Function<SparseArray<Object>, Object> function) {
        super(function != null ? function : com.bykv.ms.ms.ms.ms.xr.ah);
        this.f4038ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 270014);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.ah.ms(mediationConfigUserInfoForSegment));
        this.f4038ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 270016);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, com.bytedance.sdk.openadsdk.ao.ms.ah.d.ms(tTCustomController));
        this.f4038ms.apply(sparseArray);
    }

    private SparseArray<Object> ms(AdSlot adSlot) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(com.bytedance.sdk.openadsdk.ao.ms.ah.xr.ms(adSlot));
        xrVarMs.ms(8302, MediationAdClassLoader.getInstance());
        return xrVarMs.xr().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, context);
        sparseArray.put(1, ms(adSlot));
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.ah(iMediationNativeAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270021);
        sparseArray.put(-99999985, Void.class);
        this.f4038ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, context);
        sparseArray.put(1, ms(adSlot));
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.ms(iMediationDrawAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270022);
        sparseArray.put(-99999985, Void.class);
        this.f4038ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.xr, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, activity);
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator<IMediationPreloadRequestInfo> it = list.iterator();
            while (it.hasNext()) {
                linkedList.add(new x(it.next()));
            }
            sparseArray.put(1, linkedList);
        }
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270013);
        sparseArray.put(-99999985, Void.class);
        this.f4038ms.apply((SparseArray<Object>) sparseArray);
    }
}
