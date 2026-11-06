package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class j {
    private final HashMap<String, Integer> a;
    private final SparseArray<String> b;

    j() {
        this(new HashMap(), new SparseArray());
    }

    j(HashMap<String, Integer> map, SparseArray<String> sparseArray) {
        this.a = map;
        this.b = sparseArray;
    }

    String a(com.tapsdk.tapad.internal.download.f fVar) {
        return (fVar.w() == null ? "" : (String) fVar.w()) + fVar.a();
    }

    public void a(int i) {
        String str = this.b.get(i);
        if (str != null) {
            this.a.remove(str);
            this.b.remove(i);
        }
    }

    public void a(com.tapsdk.tapad.internal.download.f fVar, int i) {
        String strA = a(fVar);
        this.a.put(strA, Integer.valueOf(i));
        this.b.put(i, strA);
    }

    public Integer b(com.tapsdk.tapad.internal.download.f fVar) {
        Integer num = this.a.get(a(fVar));
        if (num != null) {
            return num;
        }
        return null;
    }
}
