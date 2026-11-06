package com.bytedance.sdk.openadsdk.core.f;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final EventListener f2499ms;

    public xr(EventListener eventListener) {
        this.f2499ms = eventListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || this.f2499ms == null) {
            return null;
        }
        com.bykv.ms.ms.ms.ms.ms msVarMs = com.bykv.ms.ms.ms.ms.ms.ms();
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        Object obj = sparseArray.get(-999900);
        if (obj instanceof Integer) {
            msVarMs.ms(((Integer) obj).intValue());
        }
        Object obj2 = sparseArray.get(-999901);
        if (obj2 instanceof String) {
            msVarMs.ms((String) obj2);
        }
        Object obj3 = sparseArray.get(-999903);
        if (obj3 instanceof Boolean) {
            msVarMs.ms(((Boolean) obj3).booleanValue());
        }
        msVarMs.ms(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) sparseArray.get(-999902)).xr());
        this.f2499ms.onEvent(iIntValue, msVarMs.xr());
        return null;
    }
}
