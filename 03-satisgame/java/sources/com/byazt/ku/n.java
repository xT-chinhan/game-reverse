package com.byazt.ku;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2433, 19})
public abstract class n implements Function<SparseArray<Object>, Object>, IntSupplier {
    public abstract <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls);

    public abstract SparseArray<Object> get();

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return 7000;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetQg = s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987, 0);
        Class cls = (Class) valueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return get();
        }
        return applyFunction(iIntValue, valueSetQg, cls);
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        } else if ((obj instanceof Supplier) && !(obj instanceof Function) && !(obj instanceof ValueSet)) {
            obj = (T) ((Supplier) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }
}
