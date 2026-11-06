package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.vzx.pr;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 233, 1412, 2380})
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    public final boolean isNativeAd() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8223);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isExpressRender() {
        if (this.mGmAdLoader == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8222);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGmAdLoader.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8303, list);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }
}
