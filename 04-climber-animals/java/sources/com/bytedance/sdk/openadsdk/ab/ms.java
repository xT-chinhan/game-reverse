package com.bytedance.sdk.openadsdk.ab;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SparseArray<Method> f1645ms = new SparseArray<>();
    private Object xr;

    public abstract String ms();

    @Override // com.bytedance.sdk.openadsdk.ab.ah
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.f1645ms.get(i);
        if (method == null || (obj = this.xr) == null) {
            sl.xr(ms(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            if (obj instanceof Class) {
                return (T) method.invoke(null, objArr);
            }
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            sl.xr(ms(), "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ab.ah
    public void ms(int i, Method method) {
        this.f1645ms.put(i, method);
    }

    @Override // com.bytedance.sdk.openadsdk.ab.ah
    public void ms(Object obj) {
        this.xr = obj;
    }
}
