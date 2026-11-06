package com.tapsdk.tapad.internal.download;

import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    final List<Integer> b = new ArrayList();
    final c c = new a();
    final SparseArray<ArrayList<c>> a = new SparseArray<>();

    class a implements c {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, int i, int i2, Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar, i, i2, map);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar, i, j);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, int i, Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar, i, map);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar2 : cVarArrB) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar2 : cVarArrB) {
                if (cVar2 != null) {
                    cVar2.a(fVar, cVar, resumeFailedCause);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, EndCause endCause, Exception exc) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar, endCause, exc);
                }
            }
            if (l.this.b.contains(Integer.valueOf(fVar.b()))) {
                l.this.b(fVar.b());
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(f fVar, Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.a(fVar, map);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void b(f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.b(fVar, i, j);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void b(f fVar, int i, Map<String, List<String>> map) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.b(fVar, i, map);
                }
            }
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void c(f fVar, int i, long j) {
            c[] cVarArrB = l.b(fVar, l.this.a);
            if (cVarArrB == null) {
                return;
            }
            for (c cVar : cVarArrB) {
                if (cVar != null) {
                    cVar.c(fVar, i, j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c[] b(f fVar, SparseArray<ArrayList<c>> sparseArray) {
        ArrayList<c> arrayList = sparseArray.get(fVar.b());
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        c[] cVarArr = new c[arrayList.size()];
        arrayList.toArray(cVarArr);
        return cVarArr;
    }

    public c a() {
        return this.c;
    }

    public c a(f fVar, String str) {
        ArrayList<c> arrayList = this.a.get(fVar.b());
        c cVar = null;
        if (arrayList == null) {
            return null;
        }
        for (c cVar2 : arrayList) {
            if (cVar2.getClass().getName().equals(str)) {
                cVar = cVar2;
            }
        }
        return cVar;
    }

    public synchronized void a(int i) {
        if (this.b.contains(Integer.valueOf(i))) {
            return;
        }
        this.b.add(Integer.valueOf(i));
    }

    public synchronized void a(c cVar) {
        int size = this.a.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            ArrayList<c> arrayListValueAt = this.a.valueAt(i);
            if (arrayListValueAt != null) {
                arrayListValueAt.remove(cVar);
                if (arrayListValueAt.isEmpty()) {
                    arrayList.add(Integer.valueOf(this.a.keyAt(i)));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.a.remove(((Integer) it.next()).intValue());
        }
    }

    public synchronized void a(f fVar, c cVar) {
        b(fVar, cVar);
        if (!a(fVar)) {
            fVar.a(this.c);
        }
    }

    boolean a(f fVar) {
        return StatusUtil.e(fVar);
    }

    public synchronized void b(int i) {
        this.a.remove(i);
    }

    public synchronized void b(f fVar, c cVar) {
        int iB = fVar.b();
        ArrayList<c> arrayList = this.a.get(iB);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(iB, arrayList);
        }
        if (!arrayList.contains(cVar)) {
            arrayList.add(cVar);
            if (cVar instanceof com.tapsdk.tapad.internal.download.m.i.g.d) {
                ((com.tapsdk.tapad.internal.download.m.i.g.d) cVar).a(true);
            }
        }
    }

    public synchronized void c(int i) {
        this.b.remove(Integer.valueOf(i));
    }

    public synchronized boolean c(f fVar, c cVar) {
        int iB = fVar.b();
        ArrayList<c> arrayList = this.a.get(iB);
        if (arrayList == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(cVar);
        if (arrayList.isEmpty()) {
            this.a.remove(iB);
        }
        return zRemove;
    }

    public synchronized void d(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.a(this.c);
    }

    public synchronized void e(f fVar, c cVar) {
        b(fVar, cVar);
        fVar.b(this.c);
    }

    public synchronized boolean f(f fVar, c cVar) {
        ArrayList<c> arrayList = this.a.get(fVar.b());
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(cVar);
    }

    public synchronized void g(f fVar, c cVar) {
        int iB = fVar.b();
        ArrayList<c> arrayList = this.a.get(iB);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(iB, arrayList);
        }
        String name = cVar.getClass().getName();
        c cVar2 = null;
        for (c cVar3 : arrayList) {
            if (cVar3.getClass().getName().equals(name)) {
                cVar2 = cVar3;
            }
        }
        if (cVar2 != null) {
            arrayList.remove(cVar2);
        }
        if (!arrayList.contains(cVar)) {
            arrayList.add(cVar);
            if (cVar instanceof com.tapsdk.tapad.internal.download.m.i.g.d) {
                ((com.tapsdk.tapad.internal.download.m.i.g.d) cVar).a(true);
            }
        }
    }
}
