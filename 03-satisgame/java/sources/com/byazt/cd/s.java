package com.byazt.cd;

import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.tk.ou;
import com.byazt.tk.wm;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 86, 8})
public class s {
    public static final Set<Integer> n = new CopyOnWriteArraySet();
    public static final wm qg = new wm() { // from class: com.byazt.cd.s.1
        @Override // com.byazt.tk.wm
        public boolean n(int i) {
            if (rv.qg().im()) {
                return s.n.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.byazt.wrp.n n(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        com.byazt.wrp.n nVar = new com.byazt.wrp.n();
        nVar.n(pkVar.v());
        nVar.n(pkVar.F_());
        nVar.qg(pkVar.q());
        return nVar;
    }

    public static void n() {
        if (rv.qg().im()) {
            ou.n(qg);
        } else {
            n.clear();
        }
    }

    public static void n(int i) {
        if (rv.qg().im()) {
            n.add(Integer.valueOf(i));
        }
        qg.s(i);
    }

    public static void qg(int i) {
        n.remove(Integer.valueOf(i));
        qg.qg(i);
    }
}
