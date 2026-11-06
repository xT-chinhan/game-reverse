package com.bytedance.sdk.openadsdk.mediation.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4037ms;

    public xr(Bridge bridge) {
        this.f4037ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        return (T) this.f4037ms.call(i, com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr(), cls);
    }

    public static Function<SparseArray<Object>, Object> ms(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        if (obj instanceof Bridge) {
            return new xr((Bridge) obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ms.ms, java.util.function.Supplier
    public SparseArray<Object> get() {
        if (this.f4037ms.values() != null) {
            SparseArray<Object> sparseArray = this.f4037ms.values().sparseArray();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            appendProto2Params(sparseArray);
            return sparseArray;
        }
        return super.get();
    }
}
