package com.bytedance.sdk.openadsdk.mediation.xr.ms.ms;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.ao.ms.ah.d;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.ka;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements IMediationManager {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4047ms;

    public xr(Function<SparseArray<Object>, Object> function) {
        this.f4047ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 270013);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, list);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270014);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms.ah.ms(mediationConfigUserInfoForSegment));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270015);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270016);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d.ms(tTCustomController));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updateLocalExtra(Map<String, Object> map) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 271050);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, map);
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270017);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270018);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        sparseArray.put(1, iArr);
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270019);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270020);
        sparseArray.put(-99999985, Integer.TYPE);
        sparseArray.put(0, new ka(mediationAppDialogClickListener));
        return ((Integer) this.f4047ms.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 270021);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        sparseArray.put(1, adSlot);
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.ah(iMediationNativeAdTokenCallback));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 270022);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, context);
        sparseArray.put(1, adSlot);
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.ms(iMediationDrawAdTokenCallback));
        this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270024);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.f4047ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i, ValueSet valueSet) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 271043);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, Integer.valueOf(i));
        if (valueSet != null) {
            sparseArray.put(1, valueSet.sparseArray());
        } else {
            sparseArray.put(1, new SparseArray());
        }
        return this.f4047ms.apply(sparseArray);
    }
}
