package com.byazt.dq;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.qp.d;
import com.byazt.qp.tj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 752, 19})
public class n {
    public static final List<Runnable> qg = new ArrayList();
    public static volatile boolean s = false;
    public final tj n;

    public n(tj tjVar) {
        this.n = tjVar;
    }

    public boolean n(d dVar, Function function) {
        int iN = com.byazt.lx.n.n(function, dVar.w);
        if (iN <= dVar.s) {
            return false;
        }
        dVar.qg(iN);
        dVar.n(function);
        tj tjVar = this.n;
        if (tjVar == null) {
            return true;
        }
        tjVar.n(dVar.w, function, dVar.s, iN);
        return true;
    }

    public void n(d dVar, com.byazt.qp.n nVar, Function function) {
        if (dVar.w()) {
            if (!dVar.x) {
                Object objQ = dVar.q();
                if (objQ != null) {
                    n(dVar, null, objQ, nVar);
                    return;
                }
                return;
            }
            for (Map.Entry<com.byazt.vf.n, Object> entry : dVar.s().entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    n(dVar, entry.getKey(), value, nVar);
                }
            }
        }
    }

    private void n(final d dVar, com.byazt.vf.n nVar, final Object obj, com.byazt.qp.n nVar2) {
        int iN;
        final int iN2;
        boolean z;
        Pair<Function, Object> pairN = nVar2.l().n(dVar, nVar);
        if (pairN != null && (iN = com.byazt.lx.n.n((Function) pairN.first, dVar.w)) > (iN2 = dVar.n()) && dVar.s(iN) && pairN.second != null && (obj instanceof Function) && (pairN.second instanceof Function)) {
            final Function function = (Function) obj;
            final Function function2 = (Function) pairN.second;
            if (function.getClass().getClassLoader() == function2.getClass().getClassLoader()) {
                if (this.n != null) {
                    StringBuilder sb = new StringBuilder("source:");
                    sb.append(obj);
                    sb.append(" target:").append(function2);
                    sb.append(" classloader:").append(function.getClass().getClassLoader());
                    sb.append(" target classloader:").append(function2.getClass().getClassLoader());
                    this.n.n(dVar, 3, sb.toString(), (Throwable) null);
                    return;
                }
                return;
            }
            dVar.n(iN);
            Runnable runnable = new Runnable() { // from class: com.byazt.dq.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n(function, function2, iN2, dVar, obj);
                }
            };
            List<Runnable> list = qg;
            synchronized (list) {
                if (s) {
                    z = true;
                } else {
                    list.add(runnable);
                    z = false;
                }
            }
            if (z) {
                runnable.run();
            }
            tj tjVar = this.n;
            if (tjVar != null) {
                tjVar.n(dVar.w, obj, pairN.second, dVar.s, dVar.l());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Function function, Function function2, int i, d dVar, Object obj) {
        tj tjVar;
        Function functionQg = com.byazt.lx.n.qg(function);
        n(function, function2);
        if (!n(functionQg, dVar) || (tjVar = this.n) == null) {
            return;
        }
        tjVar.qg(dVar.w, obj, i);
    }

    private boolean n(Function function, d dVar) {
        if (function == null) {
            tj tjVar = this.n;
            if (tjVar != null) {
                tjVar.n(2, "get origin service impl failed:" + dVar.w, (Throwable) null);
            }
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -1);
        function.apply(sparseArray);
        return true;
    }

    public static void n() {
        List<Runnable> list = qg;
        synchronized (list) {
            s = true;
            if (list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(list);
            list.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }

    private void n(Function function, Function function2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -4);
        sparseArray.put(1, function2);
        function.apply(sparseArray);
    }
}
