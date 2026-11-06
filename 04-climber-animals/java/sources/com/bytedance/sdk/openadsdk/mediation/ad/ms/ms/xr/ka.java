package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationViewBinder f3963ms;

    public ka(IMediationViewBinder iMediationViewBinder) {
        this.f3963ms = iMediationViewBinder;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3963ms == null) {
            return null;
        }
        SparseArray<Object> sparseArray = valueSet != null ? valueSet.sparseArray() : new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, cls);
        T t = (T) apply(sparseArray);
        if (t != null) {
            return t;
        }
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f3963ms == null) {
            return null;
        }
        switch (com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.f3963ms.getShakeViewContainerId()));
            case 271034:
                return this.f3963ms.getExtras();
            default:
                return null;
        }
    }
}
