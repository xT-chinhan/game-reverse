package com.anythink.core.common.u;

import android.os.CountDownTimer;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    private static final String a = "CountDownTimerExt";
    private CountDownTimer b;
    private long c;
    private boolean d = true;
    private long e;
    private long f;

    public abstract void b();

    public abstract void c();

    private r(long j, long j2) {
        this.c = j2;
        this.e = j;
        this.f = j;
    }

    private boolean d() {
        return this.d;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private long e() {
        return this.e;
    }

    private void b(long j) {
        this.e = j;
    }

    private long f() {
        return this.f;
    }

    public final void a(long j) {
        this.f = j;
    }

    private void g() {
        a(this.f, this.c);
    }

    private void a(long j, long j2, long j3) {
        this.e = j;
        this.f = j2;
        this.c = j3;
        a(j2, j3);
    }

    private synchronized void a(long j, long j2) {
        this.f = j;
        this.c = j2;
        if (this.e > 0 && j2 > 0) {
            if (!this.d) {
                a();
            }
            if (this.d) {
                CountDownTimer countDownTimer = new CountDownTimer(this.f, this.c) { // from class: com.anythink.core.common.u.r.1
                    @Override // android.os.CountDownTimer
                    public final void onFinish() {
                        r.this.a();
                    }

                    @Override // android.os.CountDownTimer
                    public final void onTick(long j3) {
                        r.this.a(j3);
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

    public final void a() {
        try {
            this.b.cancel();
        } catch (Throwable unused) {
        }
        this.d = true;
        this.f = this.e;
    }

    private void h() {
        if (this.d) {
            return;
        }
        try {
            this.b.cancel();
        } catch (Throwable unused) {
        }
        this.d = true;
    }

    private boolean j() {
        return !this.d;
    }

    private void i() {
        if (!this.d) {
            return;
        }
        a(this.f, this.c);
    }
}
