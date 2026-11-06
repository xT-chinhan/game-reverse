package com.bytedance.sdk.openadsdk.core.live.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr implements Bridge, Function<SparseArray<Object>, Object> {
    protected abstract void ms(Object obj);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 1 || valueSet == null) {
            return null;
        }
        ms(valueSet.objectValue(0, Object.class));
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || ((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        ms(sparseArray.get(0, Object.class));
        return null;
    }
}
