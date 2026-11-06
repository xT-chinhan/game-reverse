package com.smartdigimkt.a1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends HandlerThread implements Handler.Callback {
    public com.smartdigimkt.z0.g a;
    public Handler b;
    public Error c;
    public RuntimeException d;
    public d e;

    public c() {
        super("dummySurface");
    }

    public final d a(int i) {
        boolean z;
        start();
        Handler handler = new Handler(getLooper(), this);
        this.b = handler;
        this.a = new com.smartdigimkt.z0.g(handler);
        synchronized (this) {
            z = false;
            this.b.obtainMessage(1, i, 0).sendToTarget();
            while (this.e == null && this.d == null && this.c == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.d;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.c;
        if (error != null) {
            throw error;
        }
        d dVar = this.e;
        dVar.getClass();
        return dVar;
    }

    public final void b(int i) {
        this.a.getClass();
        this.a.a(i);
        this.e = new d(this, this.a.b());
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    this.a.getClass();
                    this.a.c();
                } catch (Throwable unused) {
                }
                quit();
                return true;
            }
            try {
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e) {
                    this.d = e;
                    synchronized (this) {
                        notify();
                    }
                }
            } catch (Error e2) {
                this.c = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
