package com.byazt.gh;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 758, 19})
public class n {
    public static volatile n n;
    public Map<String, qg> qg = new HashMap();

    private n() {
        n(com.byazt.te.n.qg());
        n(com.byazt.rj.n.qg());
        n(com.byazt.vhv.n.qg());
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private void n(qg qgVar) {
        this.qg.put(qgVar.n(), qgVar);
    }

    public String n(String str, String str2, String str3) {
        if (this.qg.containsKey(str)) {
            String strN = this.qg.get(str).n(str2, str3);
            return TextUtils.isEmpty(strN) ? "-1" : strN;
        }
        return com.byazt.lk.l.qg(str3, str, 0, null).qg(str2, "-1");
    }

    public void n(String str, String str2, String str3, String str4) {
        if (this.qg.containsKey(str)) {
            this.qg.get(str).n(str2, str3, str4);
        } else {
            com.byazt.lk.l.qg(str4, str, 0, null).n(str2, str3);
        }
    }
}
