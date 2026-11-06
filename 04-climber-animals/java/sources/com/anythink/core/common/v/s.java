package com.anythink.core.common.v;

import android.os.CountDownTimer;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    private static final String a = "CountDownTimerExt";
    private CountDownTimer b;
    private long c = 500;
    private boolean d = true;
    private long e;
    private long f;

    public abstract void a();

    public abstract void a(long j);

    public s(long j) {
        this.e = j;
        this.f = j;
    }

    private boolean f() {
        return this.d;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private long g() {
        return this.e;
    }

    private void c(long j) {
        this.e = j;
    }

    private long h() {
        return this.f;
    }

    public final void b(long j) {
        this.f = j;
    }

    public final void b() {
        a(this.f, this.c);
    }

    private void a(long j, long j2, long j3) {
        this.e = j;
        this.f = j2;
        this.c = j3;
        b();
    }

    private synchronized void a(long j, long j2) {
        this.f = j;
        this.c = j2;
        if (this.e > 0 && j2 > 0) {
            if (!this.d) {
                c();
            }
            if (this.d) {
                CountDownTimer countDownTimer = new CountDownTimer(this.f, this.c) { // from class: com.anythink.core.common.v.s.1
                    @Override // android.os.CountDownTimer
                    public final void onFinish() {
                        s.this.a();
                        s.this.c();
                    }

                    @Override // android.os.CountDownTimer
                    public final void onTick(long j3) {
                        s.this.b(j3);
                        s.this.a(j3);
                    }
                };
                this.b = countDownTimer;
                try {
                    countDownTimer.start();
                } catch (Throwable unused) {
                }
                this.d = false;
                return;
            }
            Log.d(a, "ignore start");
            return;
        }
        Log.d(a, "invalid parameter");
    }

    public final void c() {
        try {
            this.b.cancel();
        } catch (Throwable unused) {
        }
        this.d = true;
        this.f = this.e;
    }

    public final void d() {
        if (this.d) {
            return;
        }
        try {
            this.b.cancel();
        } catch (Throwable unused) {
        }
        this.d = true;
    }

    private boolean i() {
        return !this.d;
    }

    public final void e() {
        if (!this.d) {
            return;
        }
        a(this.f, this.c);
    }
}
