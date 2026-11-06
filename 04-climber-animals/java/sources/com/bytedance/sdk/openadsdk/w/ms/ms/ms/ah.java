package com.bytedance.sdk.openadsdk.w.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f4283ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTNativeExpressAd.ExpressVideoAdListener xr;

    public ah(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.xr = expressVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f4283ms;
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
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 152101:
                this.xr.onVideoLoad();
                return null;
            case 152102:
                this.xr.onVideoError(valueSetXr.intValue(0), valueSetXr.intValue(1));
                return null;
            case 152103:
                this.xr.onVideoAdStartPlay();
                return null;
            case 152104:
                this.xr.onVideoAdPaused();
                return null;
            case 152105:
                this.xr.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.xr.onProgressUpdate(valueSetXr.longValue(0), valueSetXr.longValue(1));
                return null;
            case 152107:
                this.xr.onVideoAdComplete();
                return null;
            case 152108:
                this.xr.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
