package com.mcto.sspsdk;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ QySdk.InitCallBack b;
    public final /* synthetic */ Throwable c;

    public b(QySdk.InitCallBack initCallBack, boolean z, Throwable th) {
        this.a = z;
        this.b = initCallBack;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a) {
                this.b.success();
                return;
            }
            QySdk.InitCallBack initCallBack = this.b;
            Throwable th = this.c;
            initCallBack.fail(400, th != null ? th.getMessage() : "Unknown error");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
