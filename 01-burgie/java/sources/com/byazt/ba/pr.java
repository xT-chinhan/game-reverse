package com.byazt.ba;

import android.text.TextUtils;
import com.byazt.wt.y;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 667, 37})
public class pr {
    public static volatile pr pr;
    public Map<String, hw> hw = new HashMap();

    private pr() {
        pr(com.byazt.no.pr.hw());
        pr(com.byazt.zg.pr.hw());
        pr(com.byazt.ak.pr.hw());
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    private void pr(hw hwVar) {
        this.hw.put(hwVar.pr(), hwVar);
    }

    public String pr(String str, String str2, String str3) {
        if (this.hw.containsKey(str)) {
            String strPr = this.hw.get(str).pr(str2, str3);
            return TextUtils.isEmpty(strPr) ? "-1" : strPr;
        }
        return y.pr(str).hw(str2, "-1");
    }

    public void pr(String str, String str2, String str3, String str4) {
        if (this.hw.containsKey(str)) {
            this.hw.get(str).pr(str2, str3, str4);
        } else {
            y.pr(str).pr(str2, str3);
        }
    }
}
