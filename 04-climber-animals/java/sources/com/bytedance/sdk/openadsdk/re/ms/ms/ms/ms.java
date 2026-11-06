package com.bytedance.sdk.openadsdk.re.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4083ms = xr.f12ms;
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener xr;

    public ms(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.xr = fullScreenVideoAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f4083ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.xr == null) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xr == null) {
            return null;
        }
        switch (xr.ms(sparseArray).xr().intValue(-99999987)) {
            case 131101:
                this.xr.onAdShow();
                return null;
            case 131102:
                this.xr.onAdVideoBarClick();
                return null;
            case 131103:
                this.xr.onAdClose();
                return null;
            case 131104:
                this.xr.onVideoComplete();
                return null;
            case 131105:
                this.xr.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
