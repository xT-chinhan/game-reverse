package com.smartdigimkt.x1;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final Context a;
    public final com.smartdigimkt.b3.c b;
    public final com.smartdigimkt.a3.a c;
    public final com.smartdigimkt.b2.e d;
    public final int f;
    public final ViewGroup g;
    public c1 h;
    public final b i;
    public Thread k;
    public long l;
    public long m;
    public CountDownView n;
    public final com.smartdigimkt.p3.l o;
    public boolean j = false;
    public final a e = new a(this);

    public d(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b2.e eVar, int i, ViewGroup viewGroup) {
        com.smartdigimkt.b3.e eVar2;
        this.a = context.getApplicationContext();
        this.b = cVar;
        this.c = aVar;
        this.d = eVar;
        this.f = i;
        this.g = viewGroup;
        this.o = new com.smartdigimkt.p3.l((cVar == null || (eVar2 = cVar.w) == null) ? 1 : eVar2.a());
        this.i = new b(this, Looper.getMainLooper());
    }

    public void a() {
    }

    public abstract void a(RelativeLayout relativeLayout);

    public final void a(boolean z) {
        String strValueOf;
        int i;
        String strValueOf2;
        int iA = c0.a(this.c, this.g.getContext());
        com.smartdigimkt.b3.e eVar = this.c.s;
        int i2 = eVar.K0;
        if (i2 != 3) {
            if (i2 != 4) {
                strValueOf2 = i2 != 5 ? "" : String.valueOf(eVar.T0);
            } else {
                strValueOf2 = String.valueOf(eVar.U0);
            }
            strValueOf = strValueOf2;
            i = 0;
        } else {
            strValueOf = String.valueOf(eVar.S0);
            i = eVar.R0;
        }
        com.smartdigimkt.b3.c cVar = this.b;
        com.smartdigimkt.a3.a aVar = this.c;
        int i3 = eVar.K0;
        com.smartdigimkt.n3.k.a(cVar, aVar, iA, z, i3, strValueOf, i, i3);
    }

    public final CloseImageView b() {
        c1 c1Var = this.h;
        if (c1Var != null) {
            return c1Var.a.getCloseView();
        }
        return null;
    }

    public View c() {
        return this.g;
    }

    public void d() {
    }

    public final void b(long j) {
        CloseImageView closeImageViewB = b();
        if (j > 0) {
            j = Math.min(j, 30L);
        } else if (j < 0) {
            j = Math.max(j, -30L);
        }
        long j2 = j * 1000;
        if (closeImageViewB != null) {
            CountDownView countDownView = new CountDownView(this.a);
            this.n = countDownView;
            Context context = this.a;
            countDownView.setCountDownEndDrawable(com.smartdigimkt.o3.d.a(context, com.smartdigimkt.r4.k.a(context, "myoffer_base_close_icon", "drawable")));
            this.n.setDuration(Math.abs(j2));
            if (Math.abs(j2) > 0) {
                long jAbs = Math.abs(j2);
                if (this.k == null) {
                    this.l = 0L;
                    this.m = jAbs;
                    this.j = true;
                    Thread thread = new Thread(new c(this));
                    this.k = thread;
                    thread.setName("sdm_type_endcard_improve_progress");
                    this.k.start();
                }
            } else {
                a(0L);
            }
            if (j2 >= 0) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            CloseImageView closeImageViewB2 = b();
            if (closeImageViewB2 == null || this.n == null) {
                return;
            }
            ViewParent parent = closeImageViewB2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.n, closeImageViewB2.getLayoutParams());
                if (b() != null) {
                    com.smartdigimkt.o3.d.a(b());
                }
            }
        }
    }

    public void a(long j) {
        CountDownView countDownView = this.n;
        if (countDownView != null) {
            countDownView.refresh(j);
            if (this.l >= this.m) {
                this.n.setVisibility(0);
            }
        }
    }
}
