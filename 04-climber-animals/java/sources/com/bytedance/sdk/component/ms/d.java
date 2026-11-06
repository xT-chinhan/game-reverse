package com.bytedance.sdk.component.ms;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<P, R> extends com.bytedance.sdk.component.ms.xr<P, R> {
    private c ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f1256ms = true;
    private ms xr;

    interface ms {
        void ms(Object obj);

        void ms(Throwable th);
    }

    public interface xr {
        d ms();
    }

    protected abstract void d();

    protected abstract void ms(P p, c cVar) throws Exception;

    @Override // com.bytedance.sdk.component.ms.xr
    public /* bridge */ /* synthetic */ String ms() {
        return super.ms();
    }

    protected final void ms(R r) {
        if (ab()) {
            this.xr.ms(r);
            ka();
        }
    }

    protected final void ms(Throwable th) {
        if (ab()) {
            this.xr.ms(th);
            ka();
        }
    }

    protected final void ah() {
        ms((Throwable) null);
    }

    protected void ka() {
        this.f1256ms = false;
        this.ah = null;
    }

    void ms(P p, c cVar, ms msVar) throws Exception {
        this.ah = cVar;
        this.xr = msVar;
        ms(p, cVar);
    }

    void c() {
        d();
        ka();
    }

    private boolean ab() {
        if (this.f1256ms) {
            return true;
        }
        ny.ms(new IllegalStateException("Jsb async call already finished: " + ms() + ", hashcode: " + hashCode()));
        return false;
    }
}
