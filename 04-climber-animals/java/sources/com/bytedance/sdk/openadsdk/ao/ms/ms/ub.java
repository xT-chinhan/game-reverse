package com.bytedance.sdk.openadsdk.ao.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub extends TTWidgetManager {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1686ms;

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i, JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 264001);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, jSONObject);
        return ((Boolean) this.f1686ms.apply(sparseArray)).booleanValue();
    }
}
