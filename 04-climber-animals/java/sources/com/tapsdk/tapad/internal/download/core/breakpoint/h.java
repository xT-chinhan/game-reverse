package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h implements i {
    public static final int g = 1;
    private final SparseArray<c> a;
    private final HashMap<String, String> b;
    private final j c;
    private final SparseArray<com.tapsdk.tapad.internal.download.m.a> d;
    private final List<Integer> e;
    private final List<Integer> f;

    public h() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    public h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> map) {
        this.d = new SparseArray<>();
        this.a = sparseArray;
        this.f = list;
        this.b = map;
        this.c = new j();
        int size = sparseArray.size();
        this.e = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.e.add(Integer.valueOf(sparseArray.valueAt(i).a));
        }
        Collections.sort(this.e);
    }

    h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> map, SparseArray<com.tapsdk.tapad.internal.download.m.a> sparseArray2, List<Integer> list2, j jVar) {
        this.d = sparseArray2;
        this.f = list;
        this.a = sparseArray;
        this.b = map;
        this.e = list2;
        this.c = jVar;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c a(com.tapsdk.tapad.internal.download.f fVar) {
        int iB = fVar.b();
        c cVar = new c(iB, fVar.e(), fVar.c(), fVar.a());
        synchronized (this) {
            this.a.put(iB, cVar);
            this.d.remove(iB);
        }
        return cVar;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c a(com.tapsdk.tapad.internal.download.f fVar, c cVar) {
        SparseArray<c> sparseArrayClone;
        synchronized (this) {
            sparseArrayClone = this.a.clone();
        }
        int size = sparseArrayClone.size();
        for (int i = 0; i < size; i++) {
            c cVarValueAt = sparseArrayClone.valueAt(i);
            if (cVarValueAt != cVar && cVarValueAt.a(fVar)) {
                return cVarValueAt;
            }
        }
        return null;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public String a(String str) {
        return this.b.get(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void a(int i, EndCause endCause, Exception exc) {
        if (endCause == EndCause.COMPLETED) {
            remove(i);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void a(c cVar, int i, long j) throws IOException {
        c cVar2 = this.a.get(cVar.a);
        if (cVar != cVar2) {
            throw new IOException("Info not on store!");
        }
        cVar2.b(i).a(j);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a() {
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a(int i) {
        return this.f.contains(Integer.valueOf(i));
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a(c cVar) {
        String strE = cVar.e();
        if (cVar.m() && strE != null) {
            this.b.put(cVar.j(), strE);
        }
        c cVar2 = this.a.get(cVar.a);
        if (cVar2 == null) {
            return false;
        }
        if (cVar2 == cVar) {
            return true;
        }
        synchronized (this) {
            this.a.put(cVar.a, cVar.a());
        }
        return true;
    }

    synchronized int b() {
        int iIntValue;
        int i = 0;
        int size = 0;
        int i2 = 0;
        while (true) {
            iIntValue = 1;
            if (size >= this.e.size()) {
                size = 0;
                break;
            }
            Integer num = this.e.get(size);
            if (num == null) {
                i = i2 + 1;
                break;
            }
            int iIntValue2 = num.intValue();
            if (i2 != 0) {
                int i3 = i2 + 1;
                if (iIntValue2 != i3) {
                    i = i3;
                    break;
                }
                size++;
                i2 = iIntValue2;
            } else {
                if (iIntValue2 != 1) {
                    size = 0;
                    i = 1;
                    break;
                }
                size++;
                i2 = iIntValue2;
            }
            throw th;
        }
        if (i != 0) {
            iIntValue = i;
        } else if (!this.e.isEmpty()) {
            List<Integer> list = this.e;
            iIntValue = 1 + list.get(list.size() - 1).intValue();
            size = this.e.size();
        }
        this.e.add(size, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public synchronized int b(com.tapsdk.tapad.internal.download.f fVar) {
        Integer numB = this.c.b(fVar);
        if (numB != null) {
            return numB.intValue();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            c cVarValueAt = this.a.valueAt(i);
            if (cVarValueAt != null && cVarValueAt.a(fVar)) {
                return cVarValueAt.a;
            }
        }
        int size2 = this.d.size();
        for (int i2 = 0; i2 < size2; i2++) {
            com.tapsdk.tapad.internal.download.m.a aVarValueAt = this.d.valueAt(i2);
            if (aVarValueAt != null && aVarValueAt.a(fVar)) {
                return aVarValueAt.b();
            }
        }
        int iB = b();
        this.d.put(iB, fVar.b(iB));
        this.c.a(fVar, iB);
        return iB;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void b(int i) {
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean c(int i) {
        if (this.f.contains(Integer.valueOf(i))) {
            return false;
        }
        synchronized (this.f) {
            if (this.f.contains(Integer.valueOf(i))) {
                return false;
            }
            this.f.add(Integer.valueOf(i));
            return true;
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean e(int i) {
        boolean zRemove;
        synchronized (this.f) {
            zRemove = this.f.remove(Integer.valueOf(i));
        }
        return zRemove;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public c g(int i) {
        return null;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c get(int i) {
        return this.a.get(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public synchronized void remove(int i) {
        this.a.remove(i);
        if (this.d.get(i) == null) {
            this.e.remove(Integer.valueOf(i));
        }
        this.c.a(i);
    }
}
