package com.byazt.mzw;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.qk.oa;
import com.byazt.tk.k;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 21})
public class x {
    public static volatile x n;
    public AtomicBoolean qg = new AtomicBoolean(false);

    public interface n {
        void n();

        void qg();
    }

    public static x n() {
        if (n == null) {
            synchronized (x.class) {
                if (n == null) {
                    n = new x();
                }
            }
        }
        return n;
    }

    private x() {
    }

    public com.byazt.px.qg n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return w.n().n(str);
    }

    public Set<com.byazt.px.qg> qg(String str) {
        return w.n().qg(str);
    }

    private void qg() {
        if (com.byazt.gkj.n.n().s() == null) {
            return;
        }
        int iN = com.byazt.gkj.n.n().s().n();
        if (iN <= 0) {
            iN = 100;
        }
        List<com.byazt.px.qg> listQg = w.n().qg();
        if (listQg == null || listQg.isEmpty() || iN >= listQg.size()) {
            if (listQg != null) {
                listQg.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.byazt.px.qg qgVar : listQg) {
            treeMap.put(qgVar.x(), qgVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listQg.size() - (iN * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.byazt.px.qg qgVar2 = (com.byazt.px.qg) entry.getValue();
                if (qgVar2 != null) {
                    hashSet.add(qgVar2.qg());
                }
            }
        }
        n(hashSet);
        this.qg.set(false);
    }

    public JSONObject n(String str, n nVar) {
        JSONObject jSONObjectL;
        oa oaVarL = com.byazt.phf.s.l(str);
        if (oaVarL != null) {
            try {
                if (oaVarL.x() && (jSONObjectL = oaVarL.l()) != null) {
                    return jSONObjectL;
                }
            } catch (Exception unused) {
            }
        }
        if (nVar == null) {
            return null;
        }
        nVar.qg();
        return null;
    }

    public void n(com.byazt.px.q qVar, String str) {
        if (qVar == null) {
            k.qg("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = qVar.n;
        final String str3 = qVar.s;
        final String str4 = qVar.qg;
        final String str5 = qVar.q;
        final String str6 = qVar.l;
        final String strQ = TextUtils.isEmpty(str) ? com.byazt.gkj.n.n().s() != null ? com.byazt.gkj.n.n().s().q() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            k.qg("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.byazt.cq.l.n(new com.byazt.qit.x("saveTemplate") { // from class: com.byazt.mzw.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.n(str2, str3, str4, str5, str6, strQ);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(String str, String str2, String str3, String str4, String str5, String str6) {
        if (n(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                qg(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            n(str2, str6, str);
        } else {
            qg(str6, str, str3, str2, str4, str5);
        }
        boolean zN = fs.n(str5);
        if (!qg.l() || zN) {
            l.qg().n(true);
        }
    }

    private void n(String str, String str2, String str3) {
        n(str, str2, str3, null);
    }

    public void n(com.byazt.px.q qVar, n nVar) {
        n(qVar, qVar.qg(), nVar);
    }

    public void n(com.byazt.px.q qVar, String str, final n nVar) {
        if (nVar == null) {
            return;
        }
        if (qVar == null) {
            k.qg("TmplDiffManager", "saveTemplate error: tplInfo == null");
            nVar.qg();
            return;
        }
        final String str2 = qVar.n;
        final String str3 = qVar.s;
        final String str4 = qVar.qg;
        final String str5 = qVar.q;
        final String str6 = qVar.l;
        final String strQ = TextUtils.isEmpty(str) ? com.byazt.gkj.n.n().s() != null ? com.byazt.gkj.n.n().s().q() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            k.qg("TmplDiffManager", "saveTemplate error:tmpId is empty");
            nVar.qg();
        } else {
            com.byazt.cq.l.n(new com.byazt.qit.x("saveTemplate") { // from class: com.byazt.mzw.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.this.n(str2, str3, str4, str5, str6, strQ, nVar);
                }
            }, 10);
        }
    }

    public synchronized void n(String str, String str2, String str3, String str4, String str5, String str6, n nVar) {
        if (n(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                qg(str6, str, str3, str2, str4, str5);
                nVar.n();
            }
            nVar.n();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            n(str2, str6, str, nVar);
        } else {
            qg(str6, str, str3, str2, str4, str5);
            nVar.n();
        }
        boolean zN = fs.n(str5);
        if (!qg.l() || zN) {
            l.qg().n(true);
        }
    }

    private void qg(String str, String str2, String str3, String str4, String str5, String str6) {
        w.n().n(new com.byazt.px.qg().n(str).qg(str2).s(str3).q(str4).l(str5).w(str6).n(Long.valueOf(System.currentTimeMillis())), false);
        qg();
    }

    private void n(String str, String str2, String str3, n nVar) {
        if (TextUtils.isEmpty(str) && nVar != null) {
            nVar.qg();
            return;
        }
        JSONObject jSONObjectN = n(str, nVar);
        if (jSONObjectN != null) {
            String strOptString = jSONObjectN.optString("md5");
            String strOptString2 = jSONObjectN.optString("version");
            String strOptString3 = jSONObjectN.optString(f.R);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                if (nVar != null) {
                    nVar.qg();
                    return;
                }
                return;
            }
            com.byazt.px.qg qgVarN = new com.byazt.px.qg().n(str2).qg(str3).s(strOptString).q(str).l(strOptString3).w(strOptString2).n(Long.valueOf(System.currentTimeMillis()));
            if (qgVarN == null || com.byazt.gkj.n.n().qg() == null) {
                if (nVar != null) {
                    nVar.qg();
                }
            } else {
                if (TextUtils.isEmpty(qgVarN.qg())) {
                    if (nVar != null) {
                        nVar.qg();
                        return;
                    }
                    return;
                }
                w.n().n(qgVarN, false);
                qg();
                if (fs.n(strOptString2)) {
                    qgVarN.w(strOptString2);
                    l.qg().n(true);
                }
                if (nVar != null) {
                    nVar.n();
                }
            }
        }
    }

    public void n(Set<String> set) {
        try {
            w.n().n(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
