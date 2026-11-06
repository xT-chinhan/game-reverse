package com.ss.android.downloadlib.ab;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
public class ah<P, R> implements Runnable {
    private int ah;
    private ah<R, ?> c;
    private SoftReference<ms<P, R>> d;
    private ah<?, P> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private P f4337ms;
    private R xr;

    public interface ms<PARAM, RESULT> {
        RESULT ms(PARAM param);
    }

    private ah(int i, ms<P, R> msVar, P p) {
        this.ah = i;
        this.d = new SoftReference<>(msVar);
        this.f4337ms = p;
    }

    public static <P, R> ah<P, R> ms(ms<P, R> msVar, P p) {
        return new ah<>(2, msVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> ah<R, NR> ms(int i, ms<R, NR> msVar) {
        ah ahVar = (ah<R, ?>) new ah(i, msVar, null);
        this.c = ahVar;
        ahVar.ka = this;
        return ahVar;
    }

    public <NR> ah<R, NR> ms(ms<R, NR> msVar) {
        return ms(0, msVar);
    }

    public void ms() {
        ah<?, P> ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ms();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ah<?, P> ahVar;
        if (this.ah == 0 && !zb.xr()) {
            com.ss.android.downloadlib.x.ms().xr().post(this);
            return;
        }
        if (this.ah == 1 && zb.xr()) {
            com.ss.android.downloadlib.ka.ms().ms(this);
            return;
        }
        if (this.ah == 2 && zb.xr()) {
            com.ss.android.downloadlib.ka.ms().xr(this);
            return;
        }
        if (this.f4337ms == null && (ahVar = this.ka) != null) {
            this.f4337ms = ahVar.xr();
        }
        ms<P, R> msVar = this.d.get();
        if (msVar == null) {
            return;
        }
        this.xr = msVar.ms(this.f4337ms);
        ah<R, ?> ahVar2 = this.c;
        if (ahVar2 != null) {
            ahVar2.run();
        }
    }

    private R xr() {
        return this.xr;
    }
}
