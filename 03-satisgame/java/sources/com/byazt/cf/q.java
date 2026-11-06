package com.byazt.cf;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 5})
public abstract class q<P, R> extends com.byazt.cf.qg<P, R> {
    public boolean n = true;
    public n qg;
    public w s;

    interface n {
        void n(Object obj);

        void n(Throwable th);
    }

    public interface qg {
        q n();
    }

    public abstract void n(P p, w wVar) throws Exception;

    public abstract void q();

    @Override // com.byazt.cf.qg
    public /* bridge */ /* synthetic */ String n() {
        return super.n();
    }

    public final void n(R r) {
        if (x()) {
            this.qg.n(r);
            l();
        }
    }

    public final void n(Throwable th) {
        if (x()) {
            this.qg.n(th);
            l();
        }
    }

    public final void s() {
        n((Throwable) null);
    }

    public void l() {
        this.n = false;
        this.s = null;
    }

    public void n(P p, w wVar, n nVar) throws Exception {
        this.s = wVar;
        this.qg = nVar;
        n(p, wVar);
    }

    public void w() {
        q();
        l();
    }

    private boolean x() {
        if (this.n) {
            return true;
        }
        rv.n(new IllegalStateException("Jsb async call already finished: " + n() + ", hashcode: " + hashCode()));
        return false;
    }
}
