package com.byazt.iz;

import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 19})
public class n {
    public static final LruCache<String, com.byazt.gct.q> n = new LruCache<>(10);

    public static void n(String str, com.byazt.gct.q qVar) {
        if (TextUtils.isEmpty(str) || qVar == null || !qVar.x()) {
            return;
        }
        n.put(str, qVar);
    }

    public static com.byazt.gct.q n(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        String strCq = pkVar.cq();
        String strLn = com.byazt.vgx.w.ln(pkVar);
        com.byazt.gct.l lVarK = pkVar.k();
        return n(strCq + "_" + strLn + "_" + (lVarK != null ? lVarK.qg() : null));
    }

    public static com.byazt.gct.q n(String str) {
        com.byazt.gct.q qVar = n.get(str);
        if (qVar == null || !qVar.x()) {
            return null;
        }
        return qVar;
    }

    public static void n(com.byazt.gct.n nVar) {
        List<pk> listQg;
        if (nVar == null || (listQg = nVar.qg()) == null || listQg.isEmpty()) {
            return;
        }
        Iterator<pk> it = listQg.iterator();
        while (it.hasNext()) {
            qg(it.next());
        }
    }

    public static void qg(final pk pkVar) {
        if (s(pkVar)) {
            boolean zL = com.byazt.oh.l.l(pkVar);
            boolean zL2 = l(pkVar);
            if (zL || zL2) {
                final String strQg = pkVar.k() != null ? pkVar.k().qg() : "";
                com.byazt.ag.qg.n(new com.byazt.qit.x("preloadAppInfo") { // from class: com.byazt.iz.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.nf.rv.n().n(pkVar, strQg);
                    }
                });
            }
        }
    }

    public static boolean s(pk pkVar) {
        return q(pkVar) && com.byazt.oh.l.n(pkVar) == 2;
    }

    private static boolean l(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iS = nf.s(pkVar);
        return iS == 7 || iS == 10 || nf.n(pkVar) == 1;
    }

    public static boolean q(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(pkVar.k() != null ? pkVar.k().qg() : "") && pkVar.rv() == 4 && TextUtils.isEmpty(pkVar.m())) {
            return (pkVar.D_() == null || pkVar.D_().qg() == 0) && !com.byazt.vgx.w.qg(com.byazt.vgx.w.ln(pkVar));
        }
        return false;
    }
}
