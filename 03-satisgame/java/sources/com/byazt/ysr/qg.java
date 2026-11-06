package com.byazt.ysr;

import android.text.TextUtils;
import com.byazt.gct.su;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.tk.k;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 68, 26})
public class qg {
    public static volatile qg n;

    public interface n {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public void n(su suVar, String str, String str2) {
        if (suVar == null) {
            return;
        }
        if (TextUtils.isEmpty(suVar.n())) {
            k.qg("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + suVar.n();
        final String strS = suVar.s();
        final String strQg = suVar.qg();
        final String strQ = suVar.q();
        if (TextUtils.isEmpty(str) && str2.equals("ad")) {
            str = com.byazt.vyf.s.cy().ou();
        }
        final String str4 = str;
        l.n(new x("saveUGenTemplate") { // from class: com.byazt.ysr.qg.1
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n(str3, strS, strQg, strQ, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3, String str4, String str5) {
        if (n(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            qg(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            n(str2, str, str3, str5, (n) null);
        } else {
            qg(str2, str3, str5, str4, str);
        }
    }

    private void n(final String str, final String str2, final String str3, final String str4, final n nVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.phf.s.qg(str).n(new com.byazt.qk.x() { // from class: com.byazt.ysr.qg.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar == null) {
                    return;
                }
                if (oaVar.x()) {
                    String strFs = oaVar.fs();
                    if (TextUtils.isEmpty(strFs)) {
                        return;
                    }
                    s.n().n(new com.byazt.ysr.n().n(str2).qg(str3).s(str).l(str4).q(strFs).n(Long.valueOf(System.currentTimeMillis())), false);
                    qg.this.qg();
                    if (nVar != null) {
                        try {
                            new JSONObject(strFs);
                            return;
                        } catch (JSONException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (nVar != null) {
                    oaVar.n();
                    oaVar.qg();
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str5, Throwable th) {
                if (nVar != null) {
                    th.getMessage();
                }
            }
        });
    }

    public Set<com.byazt.ysr.n> n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return s.n().n(str);
    }

    public String n(String str, String str2, String str3) {
        com.byazt.ysr.n nVarN = n(str + "_" + str2, str3);
        if (nVarN == null) {
            return null;
        }
        n(nVarN);
        return nVarN.l();
    }

    private com.byazt.ysr.n n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return s.n().n(str, str2);
    }

    private void qg(String str, String str2, String str3, String str4, String str5) {
        com.byazt.ysr.n nVar = new com.byazt.ysr.n();
        nVar.s(str).l(str3).q(str4).qg(str2).n(str5).n(Long.valueOf(System.currentTimeMillis()));
        s.n().n(nVar, false);
        qg();
    }

    private void n(final com.byazt.ysr.n nVar) {
        nVar.n(Long.valueOf(System.currentTimeMillis()));
        l.n(new x("updateTmplTime") { // from class: com.byazt.ysr.qg.3
            @Override // java.lang.Runnable
            public void run() {
                s.n().n(nVar, true);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        int iXu = rv.qg().xu();
        if (iXu <= 0) {
            iXu = 100;
        }
        List<com.byazt.ysr.n> listS = s.n().s();
        if (listS == null || listS.isEmpty() || iXu >= listS.size()) {
            if (listS != null) {
                listS.size();
                return;
            }
            return;
        }
        int size = (int) (listS.size() - (iXu * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.byazt.ysr.n nVar : listS) {
            treeMap.put(nVar.q(), nVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.byazt.ysr.n nVar2 = (com.byazt.ysr.n) entry.getValue();
                if (nVar2 != null) {
                    hashSet.add(nVar2.n());
                }
            }
        }
        n(hashSet);
    }

    public void n(Set<String> set) {
        try {
            s.n().n(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
