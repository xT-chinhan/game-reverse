package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Loader {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Void> f1826ms;

    public xr(Function<SparseArray<Object>, Void> function) {
        this.f1826ms = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (this.f1826ms != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (valueSet != null) {
                sparseArray = valueSet.sparseArray();
            }
            sparseArray.put(-99999982, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            this.f1826ms.apply(sparseArray);
        }
    }
}
