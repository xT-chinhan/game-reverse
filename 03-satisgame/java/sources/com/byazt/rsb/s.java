package com.byazt.rsb;

import android.text.TextUtils;
import com.byazt.vf.u;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 590, 8})
public class s implements u {
    public qg qg = new qg();
    public n s = new n();
    public boolean n = !this.qg.n();

    @Override // com.byazt.vf.u
    public String n(String str) {
        String strN = this.qg.n() ? this.qg.n(str) : "";
        return (this.n && TextUtils.isEmpty(strN)) ? this.s.n(str) : strN;
    }

    @Override // com.byazt.vf.u
    public int qg(String str) {
        int iQg = this.qg.n() ? this.qg.qg(str) : Integer.MAX_VALUE;
        return (this.n && iQg == Integer.MAX_VALUE) ? this.s.qg(str) : iQg;
    }

    @Override // com.byazt.vf.u
    public long s(String str) {
        long jS = this.qg.n() ? this.qg.s(str) : LongCompanionObject.MAX_VALUE;
        return (this.n && jS == 2147483647L) ? this.s.s(str) : jS;
    }

    @Override // com.byazt.vf.u
    public boolean q(String str) {
        boolean zQ = this.qg.n() ? this.qg.q(str) : false;
        return (!this.n || zQ) ? zQ : this.s.q(str);
    }

    @Override // com.byazt.vf.u
    public void n(String str, String str2) {
        if (this.qg.n()) {
            this.qg.n(str, str2);
        }
    }
}
