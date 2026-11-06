package com.byazt.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 101})
public class fs extends Exception {
    public Throwable n;
    public int qg;
    public int s;

    public fs(String str, x xVar, Throwable th) {
        super((str == null ? "" : str + " ") + (xVar == null ? "" : "(position:" + xVar.q() + ") ") + (th != null ? "caused by: " + th : ""));
        this.qg = -1;
        this.s = -1;
        if (xVar != null) {
            this.qg = xVar.s();
            this.s = xVar.w();
        }
        this.n = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.n == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
        }
    }
}
