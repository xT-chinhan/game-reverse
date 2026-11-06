package com.bytedance.sdk.openadsdk.ao.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAppDownloadListener f1692ms;

    public xr(TTAppDownloadListener tTAppDownloadListener) {
        this.f1692ms = tTAppDownloadListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f1692ms == null) {
            return null;
        }
        SparseArray<Object> sparseArray = valueSet != null ? valueSet.sparseArray() : new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, cls);
        T t = (T) apply(sparseArray);
        if (t == null) {
            return null;
        }
        return t;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f1692ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 221101:
                this.f1692ms.onIdle();
                return null;
            case 221102:
                this.f1692ms.onDownloadActive(valueSetXr.longValue(0), valueSetXr.longValue(1), valueSetXr.stringValue(2), valueSetXr.stringValue(3));
                return null;
            case 221103:
                this.f1692ms.onDownloadPaused(valueSetXr.longValue(0), valueSetXr.longValue(1), valueSetXr.stringValue(2), valueSetXr.stringValue(3));
                return null;
            case 221104:
                this.f1692ms.onDownloadFailed(valueSetXr.longValue(0), valueSetXr.longValue(1), valueSetXr.stringValue(2), valueSetXr.stringValue(3));
                return null;
            case 221105:
                this.f1692ms.onDownloadFinished(valueSetXr.longValue(0), valueSetXr.stringValue(1), valueSetXr.stringValue(2));
                return null;
            case 221106:
                this.f1692ms.onInstalled(valueSetXr.stringValue(0), valueSetXr.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
