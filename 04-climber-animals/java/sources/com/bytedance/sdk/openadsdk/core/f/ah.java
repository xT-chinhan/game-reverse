package com.bytedance.sdk.openadsdk.core.f;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f2496ms;
    private Bridge xr;

    public ah(Object obj) {
        if (obj instanceof Function) {
            this.f2496ms = (Function) obj;
        } else if (obj instanceof Bridge) {
            this.xr = (Bridge) obj;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        if (this.f2496ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -99999986);
            Object objApply = this.f2496ms.apply(sparseArray);
            if (objApply instanceof SparseArray) {
                return com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objApply).xr();
            }
            return null;
        }
        Bridge bridge = this.xr;
        if (bridge != null) {
            return bridge.values();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f2496ms != null && valueSet != null) {
            SparseArray<Object> sparseArray = valueSet.sparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            T t = (T) this.f2496ms.apply(sparseArray);
            if (t != null) {
                return t;
            }
            return null;
        }
        Bridge bridge = this.xr;
        if (bridge != null) {
            return (T) bridge.call(i, valueSet, cls);
        }
        return null;
    }
}
