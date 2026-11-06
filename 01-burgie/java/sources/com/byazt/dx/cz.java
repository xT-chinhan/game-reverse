package com.byazt.dx;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 213})
public class cz {
    public final zo hn;
    public final LottieAnimationView hw;
    public final Map<String, String> pr;
    public boolean x;

    public cz() {
        this.pr = new HashMap();
        this.x = true;
        this.hw = null;
        this.hn = null;
    }

    public cz(LottieAnimationView lottieAnimationView) {
        this.pr = new HashMap();
        this.x = true;
        this.hw = lottieAnimationView;
        this.hn = null;
    }

    public String pr(String str, String str2) {
        return pr(str2);
    }

    public String pr(String str) {
        return str;
    }

    public void hw(String str, String str2) {
        this.pr.put(str, str2);
        pr();
    }

    public final String hn(String str, String str2) {
        if (this.x && this.pr.containsKey(str2)) {
            return this.pr.get(str2);
        }
        String strPr = pr(str, str2);
        if (this.x) {
            this.pr.put(str2, strPr);
        }
        return strPr;
    }

    private void pr() {
        LottieAnimationView lottieAnimationView = this.hw;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.invalidateSelf();
        }
    }
}
