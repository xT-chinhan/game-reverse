package com.byazt.hi;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 26})
public class qg {
    public com.byazt.msp.w.n l;
    public int q;
    public com.byazt.gct.fs.l w;
    public int n = 0;
    public long qg = 0;
    public int s = -1;

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
    
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int n(com.byazt.zq.qg r11, int r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.hi.qg.n(com.byazt.zq.qg, int):int");
    }

    public boolean n() {
        return this.n == 4;
    }

    public boolean qg() {
        com.byazt.gct.fs.l lVar;
        if (this.qg <= 0 || this.n != 3) {
            return false;
        }
        com.byazt.msp.w.n nVar = this.l;
        n((nVar == null || (lVar = this.w) == null) ? -1 : nVar.n(lVar.l(), this.w));
        this.s = 2;
        return true;
    }

    private void n(int i) {
        if (i > 0) {
            this.qg = System.currentTimeMillis() - ((((long) i) * 60) * 1000);
        } else if (i == 0) {
            this.qg = 0L;
        } else {
            this.qg = System.currentTimeMillis();
        }
    }
}
