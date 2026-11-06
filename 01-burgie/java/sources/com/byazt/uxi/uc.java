package com.byazt.uxi;

import com.byazt.dx.ho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 5})
public class uc {
    public static final uc pr = new uc();
    public final ho<String, com.byazt.dx.uc> hw = new ho<>(20);

    public static uc pr() {
        return pr;
    }

    public com.byazt.dx.uc pr(String str) {
        if (str == null) {
            return null;
        }
        return this.hw.pr(str);
    }

    public void pr(String str, com.byazt.dx.uc ucVar) {
        if (str == null) {
            return;
        }
        this.hw.pr(str, ucVar);
    }

    public void pr(int i) {
        this.hw.pr(i);
    }
}
