package com.byazt.msp;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 18})
public class l {
    public static boolean n(com.byazt.zq.qg qgVar, pk pkVar, boolean z) {
        boolean z2;
        if (!rv.qg().qg(qgVar.q())) {
            return true;
        }
        if (pkVar == null) {
            com.byazt.eji.s.n().qg(3);
            return false;
        }
        String strPy = qgVar.py();
        long jKc = pkVar.kc();
        String strHa = pkVar.ha();
        try {
            if (TextUtils.isEmpty(strPy)) {
                com.byazt.eji.s.n().qg(1);
                return false;
            }
            JSONObject jSONObjectN = com.byazt.cl.q.n(new JSONObject(strPy), false, true);
            if (jSONObjectN == null) {
                com.byazt.eji.s.n().qg(1);
                return false;
            }
            com.byazt.mw.qg.n nVarN = com.byazt.mw.qg.n.n(jSONObjectN, qgVar, null);
            if (nVarN.fs == null) {
                com.byazt.eji.s.n().qg(1);
                return false;
            }
            nVarN.fs.n(jSONObjectN);
            List<pk> listQg = nVarN.fs.qg();
            if (listQg == null) {
                com.byazt.eji.s.n().qg(1);
                return false;
            }
            Iterator<pk> it = listQg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                pk next = it.next();
                if (TextUtils.isEmpty(next.ha())) {
                    com.byazt.eji.s.n().qg(2);
                    return false;
                }
                if (!next.dw()) {
                    com.byazt.eji.s.n().qg(5);
                    return false;
                }
                if (TextUtils.equals(next.ha(), strHa)) {
                    pkVar.an(next.fb());
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                com.byazt.eji.s.n().qg(3);
                return false;
            }
            if (pkVar.ju() + jKc >= System.currentTimeMillis()) {
                return true;
            }
            com.byazt.ci.l.n(z ? 7 : 8).n(qgVar.q());
            com.byazt.eji.s.n().qg(4);
            return false;
        } catch (Exception unused) {
            com.byazt.eji.s.n().qg(1000);
            return false;
        }
    }
}
