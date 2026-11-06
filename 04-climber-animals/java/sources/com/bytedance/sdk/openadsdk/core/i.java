package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final SparseArray<HashMap> f2656ms = new SparseArray<>();

    public static <T> void ms(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        int iHashCode = cls.hashCode();
        SparseArray<HashMap> sparseArray = f2656ms;
        HashMap map = sparseArray.get(iHashCode);
        if (map == null) {
            map = new HashMap();
            sparseArray.put(iHashCode, map);
        }
        map.put(str, t);
    }

    public static <T> void ms(String str) {
        int size = f2656ms.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HashMap> sparseArray = f2656ms;
            HashMap map = sparseArray.get(sparseArray.keyAt(i));
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static <T> T ms(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = f2656ms.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.get(str);
    }

    public static <T> T xr(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = f2656ms.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.remove(str);
    }
}
