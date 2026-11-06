package com.bytedance.sdk.openadsdk.core.f;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class d implements EventListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f2497ms;
    private EventListener xr;

    public d(Object obj) {
        if (obj instanceof EventListener) {
            this.xr = (EventListener) obj;
        } else if (obj instanceof Function) {
            this.f2497ms = (Function) obj;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        EventListener eventListener = this.xr;
        if (eventListener != null) {
            return eventListener.onEvent(i, result);
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        if (result != null) {
            sparseArray.put(-999900, Integer.valueOf(result.code()));
            sparseArray.put(-999901, result.message());
            sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
            ValueSet valueSetValues = result.values();
            if (valueSetValues != null) {
                sparseArray.put(-999902, valueSetValues.sparseArray());
            }
        }
        Function<SparseArray<Object>, Object> function = this.f2497ms;
        if (function == null) {
            return null;
        }
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objApply).xr();
        }
        return null;
    }
}
