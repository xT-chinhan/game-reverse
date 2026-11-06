package com.byazt.tka;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 29})
public class cp {
    public com.byazt.xl.n l;
    public Context n;
    public boolean q;
    public String qg;
    public String s;

    public Context n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public long s() {
        com.byazt.xl.n nVar = this.l;
        if (nVar != null) {
            return nVar.n();
        }
        return 0L;
    }

    public static cp n(Context context, String str, String str2, boolean z, com.byazt.xl.n nVar) {
        return new n(context, str, str2).n(z).n(nVar).n();
    }

    @com.byazt.cp.n(n = {0, 1, 689, 570})
    public static class n {
        public final Context n;
        public final String qg;
        public final String s;
        public boolean q = false;
        public com.byazt.xl.n l = null;

        public n(Context context, String str, String str2) {
            this.n = context;
            this.s = str2;
            this.qg = str;
        }

        public n n(com.byazt.xl.n nVar) {
            this.l = nVar;
            return this;
        }

        public n n(boolean z) {
            this.q = z;
            return this;
        }

        public cp n() {
            cp cpVar = new cp();
            cpVar.n = this.n;
            cpVar.qg = this.qg;
            cpVar.s = this.s;
            cpVar.q = this.q;
            cpVar.l = this.l;
            return cpVar;
        }
    }
}
