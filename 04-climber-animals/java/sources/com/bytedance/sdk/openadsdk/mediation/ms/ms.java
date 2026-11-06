package com.bytedance.sdk.openadsdk.mediation.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Function<SparseArray<Object>, Object>, Supplier<SparseArray<Object>> {
    public abstract <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        return applyFunction(((Integer) objectValue(sparseArray.get(-99999987), Integer.class, 0)).intValue(), sparseArray, (Class) sparseArray.get(-99999985));
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }

    public static boolean isProto2ForAdapter(Object obj) {
        if (!(obj instanceof Supplier)) {
            return false;
        }
        Supplier supplier = (Supplier) obj;
        if (supplier.get() instanceof SparseArray) {
            return ((Boolean) objectValue(((SparseArray) supplier.get()).get(-99999984), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    @Override // java.util.function.Supplier
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        appendProto2Params(sparseArray);
        return sparseArray;
    }

    public void appendProto2Params(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            sparseArray.put(-99999983, Boolean.TRUE);
        }
    }
}
