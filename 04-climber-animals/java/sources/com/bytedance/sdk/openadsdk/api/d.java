package com.bytedance.sdk.openadsdk.api;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Initializer {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Function<SparseArray<Object>, Object> f1776ms;

    public d(Function<SparseArray<Object>, Object> function) {
        this.f1776ms = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.f1776ms == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        this.f1776ms.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.f1776ms;
        if (function == null) {
            return false;
        }
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.f1776ms == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999000);
        return new ah((Function) this.f1776ms.apply(sparseArray));
    }
}
