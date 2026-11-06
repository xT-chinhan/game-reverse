package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Function<SparseArray<Object>, Object> f1777ms;
    protected EventListener xr;

    protected ValueSet ms(int i, Result result) {
        if (!ms()) {
            return this.xr.onEvent(i, result);
        }
        if (xr()) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        if (result != null) {
            sparseArray.put(-999900, Integer.valueOf(result.code()));
            sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
            sparseArray.put(-999901, result.message());
            sparseArray.put(-999902, result.values() != null ? result.values().sparseArray() : new SparseArray<>());
        }
        Object objApply = this.f1777ms.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objApply).xr();
        }
        return null;
    }

    protected ValueSet ms(int i) {
        return ms(i, null);
    }

    protected boolean ms() {
        return this.xr == null;
    }

    protected boolean xr() {
        return this.f1777ms == null;
    }

    protected boolean ah() {
        return this.xr == null && this.f1777ms == null;
    }
}
