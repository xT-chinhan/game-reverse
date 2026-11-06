package com.bytedance.sdk.openadsdk.ao.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f1676ms;

    public ao(Bridge bridge) {
        this.f1676ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue == -99999986) {
            ValueSet valueSetValues = this.f1676ms.values();
            if (valueSetValues != null) {
                return valueSetValues.sparseArray();
            }
            return null;
        }
        Object objCall = this.f1676ms.call(iIntValue, com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr(), Object.class);
        return objCall instanceof Bridge ? new ao((Bridge) objCall) : objCall;
    }

    public static Function<SparseArray<Object>, Object> ms(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        if (obj instanceof Bridge) {
            return new ao((Bridge) obj);
        }
        return com.bykv.ms.ms.ms.ms.xr.ah;
    }
}
