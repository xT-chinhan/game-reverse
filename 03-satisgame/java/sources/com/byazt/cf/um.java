package com.byazt.cf;

import android.net.Uri;
import com.anythink.core.common.d.i;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 33})
public class um {
    public cp.qg l;
    public final Set<String> n;
    public final a q;
    public final Set<String> qg;
    public final py s = cy.n;

    public um(a aVar, Set<String> set, Set<String> set2) {
        this.q = aVar;
        if (set == null || set.isEmpty()) {
            this.n = new LinkedHashSet();
        } else {
            this.n = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.qg = new LinkedHashSet();
        } else {
            this.qg = new LinkedHashSet(set2);
        }
    }

    public final synchronized ou n(boolean z, String str, qg qgVar) throws a.n {
        ou ouVarQg;
        cp.qg qgVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        ou ouVar = this.qg.contains(qgVar.n()) ? ou.PUBLIC : null;
        for (String str2 : this.n) {
            if (uri.getHost().equals(str2) || host.endsWith(i.E.concat(String.valueOf(str2)))) {
                ouVar = ou.PRIVATE;
                break;
            }
        }
        if (ouVar == null && (qgVar2 = this.l) != null && qgVar2.n(str)) {
            if (this.l.n(str, qgVar.n())) {
                return null;
            }
            ouVar = ou.PRIVATE;
        }
        if (z) {
            ouVarQg = n(str, qgVar);
        } else {
            ouVarQg = qg(str, qgVar);
        }
        return ouVarQg != null ? ouVarQg : ouVar;
    }

    public final synchronized ou n(String str, qg qgVar) throws a.n {
        return n(str, qgVar, true);
    }

    public final synchronized ou qg(String str, qg qgVar) {
        return n(str, qgVar, false);
    }

    public void n(cp.qg qgVar) {
        this.l = qgVar;
    }

    public void n(py.n nVar) {
        py pyVar = this.s;
        if (pyVar != null) {
            pyVar.n(nVar);
        }
    }

    public void qg(py.n nVar) {
        py pyVar = this.s;
        if (pyVar != null) {
            pyVar.qg(nVar);
        }
    }

    private ou n(String str, qg qgVar, boolean z) {
        a aVar;
        if (!z || (aVar = this.q) == null) {
            return null;
        }
        a.s sVarN = aVar.n(str, this.n);
        if (sVarN.s.contains(qgVar.n())) {
            return null;
        }
        if (sVarN.qg.contains(qgVar.n())) {
            return ou.PRIVATE;
        }
        if (sVarN.n.compareTo(qgVar.qg()) < 0) {
            return null;
        }
        return sVarN.n;
    }
}
