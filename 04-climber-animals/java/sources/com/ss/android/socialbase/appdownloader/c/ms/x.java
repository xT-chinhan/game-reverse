package com.ss.android.socialbase.appdownloader.c.ms;

/* JADX INFO: loaded from: classes3.dex */
public class x extends Exception {
    protected int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Throwable f4568ms;
    protected int xr;

    public x(String str, ab abVar, Throwable th) {
        super((str == null ? "" : str + " ") + (abVar == null ? "" : "(position:" + abVar.d() + ") ") + (th != null ? "caused by: " + th : ""));
        this.xr = -1;
        this.ah = -1;
        if (abVar != null) {
            this.xr = abVar.ah();
            this.ah = abVar.c();
        }
        this.f4568ms = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f4568ms == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            com.bytedance.sdk.openadsdk.api.ab.ms(this.f4568ms);
        }
    }
}
