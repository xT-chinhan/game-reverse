package com.byazt.qt;

import com.byazt.sd.cz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1684, 37})
public class pr {
    public final List<String> hw = new ArrayList();
    public final String pr;

    public pr(String str) {
        this.pr = str;
    }

    public static void pr(String str, String str2) {
        pr prVar = (pr) cz.pr(str, pr.class);
        if (prVar == null) {
            pr prVar2 = new pr(str);
            prVar2.pr(str2);
            cz.pr(str, prVar2, pr.class);
            return;
        }
        prVar.pr(str2);
    }

    public void pr(String str) {
        this.hw.add(str);
    }
}
