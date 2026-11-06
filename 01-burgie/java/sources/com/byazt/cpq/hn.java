package com.byazt.cpq;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 20})
public final class hn {
    public final int aj;
    public final com.byazt.du.uc fw;
    public final com.byazt.du.uc zo;
    public static final com.byazt.du.uc pr = com.byazt.du.uc.pr(":");
    public static final com.byazt.du.uc hw = com.byazt.du.uc.pr(":status");
    public static final com.byazt.du.uc hn = com.byazt.du.uc.pr(":method");
    public static final com.byazt.du.uc x = com.byazt.du.uc.pr(":path");
    public static final com.byazt.du.uc c = com.byazt.du.uc.pr(":scheme");
    public static final com.byazt.du.uc uc = com.byazt.du.uc.pr(":authority");

    public hn(String str, String str2) {
        this(com.byazt.du.uc.pr(str), com.byazt.du.uc.pr(str2));
    }

    public hn(com.byazt.du.uc ucVar, String str) {
        this(ucVar, com.byazt.du.uc.pr(str));
    }

    public hn(com.byazt.du.uc ucVar, com.byazt.du.uc ucVar2) {
        this.fw = ucVar;
        this.zo = ucVar2;
        this.aj = ucVar.fw() + 32 + ucVar2.fw();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hn)) {
            return false;
        }
        hn hnVar = (hn) obj;
        return this.fw.equals(hnVar.fw) && this.zo.equals(hnVar.zo);
    }

    public int hashCode() {
        return ((this.fw.hashCode() + 527) * 31) + this.zo.hashCode();
    }

    public String toString() {
        return com.byazt.xx.hn.pr("%s: %s", this.fw.pr(), this.zo.pr());
    }
}
