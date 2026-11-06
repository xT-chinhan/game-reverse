package com.byazt.um;

import com.byazt.ikv.qg;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 33, 19})
public class n {
    public final String n;
    public final List<String> qg = new ArrayList();

    public n(String str) {
        this.n = str;
    }

    public static void n(String str, String str2) {
        n nVar = (n) qg.n(str, n.class);
        if (nVar == null) {
            n nVar2 = new n(str);
            nVar2.n(str2);
            qg.n(str, nVar2, n.class);
            return;
        }
        nVar.n(str2);
    }

    public void n(String str) {
        this.qg.add(str);
    }
}
