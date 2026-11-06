package com.bytedance.sdk.openadsdk.api;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Manager {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1775ms;

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        return null;
    }

    public ah(Function<SparseArray<Object>, Object> function) {
        this.f1775ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, Function.class);
        return new xr((Function) this.f1775ms.apply(sparseArray));
    }

    public Function<SparseArray<Object>, Object> ms(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        Object objApply = this.f1775ms.apply(sparseArray);
        if (objApply instanceof Function) {
            return (Function) objApply;
        }
        if (objApply instanceof Bridge) {
            return new ao((Bridge) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        Object objApply = this.f1775ms.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objApply).xr();
        }
        return null;
    }
}
