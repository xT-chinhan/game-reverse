package com.byazt.le;

import com.byazt.dg.qg;
import com.byazt.xx.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2313, 19})
public class n {
    public String fs;
    public final qg n;
    public final InterfaceC0236n qg;
    public qg.C0152qg s;
    public double q = 0.0d;
    public boolean l = false;
    public final List<String> w = new ArrayList();
    public final Random x = new Random();

    /* JADX INFO: renamed from: com.byazt.le.n$n, reason: collision with other inner class name */
    public interface InterfaceC0236n {
        void n(l lVar);
    }

    public void n(l lVar, qg.q qVar, double d) {
    }

    public n(qg qgVar, InterfaceC0236n interfaceC0236n) {
        this.n = qgVar;
        this.qg = interfaceC0236n;
    }

    public void n(qg.C0152qg c0152qg) {
        this.s = c0152qg;
        this.l = true;
        this.q = 0.0d;
        this.w.clear();
        this.fs = null;
    }

    public void n() {
        this.l = false;
    }

    public void update(double d, double d2) {
        qg.C0152qg c0152qg;
        qg.q qVar;
        if (!this.l || (c0152qg = this.s) == null || d - this.q < c0152qg.l) {
            return;
        }
        this.q = d;
        String strN = n(this.s.w);
        if (strN == null || (qVar = this.n.w.get(strN)) == null) {
            return;
        }
        l lVar = new l();
        lVar.n = strN;
        lVar.qg = qVar.w;
        lVar.q = qVar.x;
        lVar.x = qVar.q;
        lVar.fs = qVar.l;
        lVar.s = qVar.s;
        lVar.sz = d;
        n(lVar, qVar, d2);
        this.qg.n(lVar);
    }

    private String n(List<qg.s> list) {
        if (this.w.isEmpty()) {
            qg(list);
        }
        if (this.w.isEmpty()) {
            return null;
        }
        List<String> list2 = this.w;
        String strRemove = list2.remove(list2.size() - 1);
        this.fs = strRemove;
        return strRemove;
    }

    private void qg(List<qg.s> list) {
        Iterator<qg.s> it = list.iterator();
        int iN = 0;
        while (it.hasNext()) {
            int iMax = Math.max(0, it.next().qg);
            if (iMax > 0) {
                iN = n(iN, iMax);
            }
        }
        if (iN <= 0) {
            return;
        }
        for (qg.s sVar : list) {
            int iMax2 = Math.max(0, sVar.qg);
            if (sVar.n != null && iMax2 != 0) {
                for (int i = 0; i < iMax2 / iN; i++) {
                    this.w.add(sVar.n);
                }
            }
        }
        Collections.shuffle(this.w, this.x);
        if (this.fs == null || this.w.size() <= 1) {
            return;
        }
        List<String> list2 = this.w;
        if (list2.get(list2.size() - 1).equals(this.fs)) {
            for (int size = this.w.size() - 2; size >= 0; size--) {
                if (!this.w.get(size).equals(this.fs)) {
                    List<String> list3 = this.w;
                    Collections.swap(list3, size, list3.size() - 1);
                    return;
                }
            }
        }
    }

    private static int n(int i, int i2) {
        return i2 == 0 ? i : n(i2, i % i2);
    }
}
