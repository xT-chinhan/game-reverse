package com.byazt.ir;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.byazt.hg.cr;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.umeng.analytics.pro.an;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1250, 13})
public class hw {
    public static volatile hw pr;

    public interface pr {
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(cr crVar, String str, String str2) {
        final String strNy;
        if (crVar == null) {
            return;
        }
        if (TextUtils.isEmpty(crVar.pr())) {
            ho.hw("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + crVar.pr();
        final String strHn = crVar.hn();
        final String strHw = crVar.hw();
        final String strX = crVar.x();
        if (TextUtils.isEmpty(str) && str2.equals(an.aw)) {
            strNy = zo.nt().ny();
        } else {
            strNy = str;
        }
        c.pr(new fw("saveUGenTemplate") { // from class: com.byazt.ir.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr(str3, strHn, strHw, strX, strNy);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, String str2, String str3, String str4, String str5) {
        if (pr(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            hw(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            pr(str2, str, str3, str5, (pr) null);
        } else {
            hw(str2, str3, str5, str4, str);
        }
    }

    private void pr(final String str, final String str2, final String str3, final String str4, final pr prVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.tf.hn.hw(str).pr(new com.byazt.hcx.fw() { // from class: com.byazt.ir.hw.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar == null) {
                    return;
                }
                if (mVar.fw()) {
                    String strZo = mVar.zo();
                    if (TextUtils.isEmpty(strZo)) {
                        return;
                    }
                    hn.pr().pr(new com.byazt.ir.pr().pr(str2).hw(str3).hn(str).c(str4).x(strZo).pr(Long.valueOf(System.currentTimeMillis())), false);
                    hw.this.hw();
                    if (prVar != null) {
                        try {
                            new JSONObject(strZo);
                            return;
                        } catch (JSONException e) {
                            return;
                        }
                    }
                    return;
                }
                if (prVar != null) {
                    mVar.pr();
                    mVar.hw();
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str5, Throwable th) {
                if (prVar != null) {
                    th.getMessage();
                }
            }
        });
    }

    public Set<com.byazt.ir.pr> pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return hn.pr().pr(str);
    }

    public String pr(String str, String str2, String str3) {
        com.byazt.ir.pr prVarPr = pr(str + "_" + str2, str3);
        if (prVarPr == null) {
            return null;
        }
        pr(prVarPr);
        return prVarPr.c();
    }

    private com.byazt.ir.pr pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return hn.pr().pr(str, str2);
    }

    private void hw(String str, String str2, String str3, String str4, String str5) {
        com.byazt.ir.pr prVar = new com.byazt.ir.pr();
        prVar.hn(str).c(str3).x(str4).hw(str2).pr(str5).pr(Long.valueOf(System.currentTimeMillis()));
        hn.pr().pr(prVar, false);
        hw();
    }

    private void pr(final com.byazt.ir.pr prVar) {
        prVar.pr(Long.valueOf(System.currentTimeMillis()));
        c.pr(new fw("updateTmplTime") { // from class: com.byazt.ir.hw.3
            @Override // java.lang.Runnable
            public void run() {
                hn.pr().pr(prVar, true);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        int iTn = a.hw().tn();
        if (iTn <= 0) {
            iTn = 100;
        }
        List<com.byazt.ir.pr> listHn = hn.pr().hn();
        if (listHn == null || listHn.isEmpty() || iTn >= listHn.size()) {
            if (listHn != null) {
                listHn.size();
                return;
            }
            return;
        }
        int size = (int) (listHn.size() - (iTn * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.byazt.ir.pr prVar : listHn) {
            treeMap.put(prVar.x(), prVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.byazt.ir.pr prVar2 = (com.byazt.ir.pr) entry.getValue();
                if (prVar2 != null) {
                    hashSet.add(prVar2.pr());
                }
            }
        }
        pr(hashSet);
    }

    public void pr(Set<String> set) {
        try {
            hn.pr().pr(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
