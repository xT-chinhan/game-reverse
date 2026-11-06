package com.smartdigimkt.y1;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public final Context a;
    public final com.smartdigimkt.b3.c b;
    public final com.smartdigimkt.a3.a c;
    public final RelativeLayout d;
    public final View e;
    public final int f;
    public final int g;
    public final b h;
    public BaseG2CV2View i;
    public long j;
    public long k;
    public final long l;
    public final String m;
    public final int n;
    public final com.smartdigimkt.b2.e o;
    public final z p;
    public boolean q = false;
    public final int r;
    public long s;
    public long t;

    public e0(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, d0 d0Var, RelativeLayout relativeLayout, View view, com.smartdigimkt.b2.e eVar, b bVar) {
        this.a = context;
        this.b = cVar;
        this.c = aVar;
        this.d = relativeLayout;
        this.e = view;
        this.f = i;
        this.o = eVar;
        this.h = bVar;
        this.g = d0Var.b;
        this.l = d0Var.c;
        this.k = d0Var.d;
        this.m = d0Var.e;
        this.n = d0Var.f;
        this.r = d0Var.a;
        this.p = new z(this, i);
    }

    public final void a() {
        if (this.q) {
            this.q = false;
            long j = this.k;
            if (j > 0) {
                this.k = Math.max(j - (SystemClock.elapsedRealtime() - this.j), 0L);
            }
            com.smartdigimkt.q3.f fVarA = com.smartdigimkt.q3.f.a();
            fVarA.b.removeCallbacks(this.p);
            BaseG2CV2View baseG2CV2View = this.i;
            if (baseG2CV2View != null) {
                baseG2CV2View.pauseAnimPlay();
            }
        }
    }

    public final RelativeLayout.LayoutParams a(int i) {
        if (i == 13) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            int i2 = this.f;
            if (i2 == 3) {
                layoutParams.addRule(12);
                return layoutParams;
            }
            if (i2 == 2) {
                layoutParams.addRule(12);
                return layoutParams;
            }
            if (i2 != 1) {
                return layoutParams;
            }
            layoutParams.addRule(12);
            return layoutParams;
        }
        switch (i) {
            case 1:
                return new RelativeLayout.LayoutParams(-1, -1);
            case 2:
                return new RelativeLayout.LayoutParams(-1, -1);
            case 3:
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                return layoutParams2;
            case 4:
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                if (this.f != 2 && this.n == 1) {
                    layoutParams3.setMargins(0, 0, 0, com.smartdigimkt.r4.k.a(this.d.getContext(), 290.0f));
                    layoutParams3.addRule(12);
                    return layoutParams3;
                }
                layoutParams3.addRule(13);
                return layoutParams3;
            case 5:
                if (this.f == 2) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, com.smartdigimkt.r4.k.a(this.d.getContext(), 48.0f));
                    layoutParams4.setMargins(com.smartdigimkt.r4.k.a(this.d.getContext(), 36.0f), 0, com.smartdigimkt.r4.k.a(this.d.getContext(), 36.0f), 0);
                    layoutParams4.addRule(13);
                    return layoutParams4;
                }
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.smartdigimkt.r4.k.a(this.d.getContext(), 300.0f), com.smartdigimkt.r4.k.a(this.d.getContext(), 48.0f));
                if (this.n == 2) {
                    layoutParams5.setMargins(0, 0, com.smartdigimkt.r4.k.a(this.d.getContext(), 24.0f), com.smartdigimkt.r4.k.a(this.d.getContext(), 96.0f));
                    layoutParams5.addRule(11);
                    layoutParams5.addRule(12);
                    return layoutParams5;
                }
                layoutParams5.setMargins(0, 0, 0, com.smartdigimkt.r4.k.a(this.d.getContext(), 290.0f));
                layoutParams5.addRule(14);
                layoutParams5.addRule(12);
                return layoutParams5;
            case 6:
                return new RelativeLayout.LayoutParams(-1, -1);
            case 7:
                return new RelativeLayout.LayoutParams(-1, -1);
            case 8:
            case 9:
            case 10:
                return new RelativeLayout.LayoutParams(-1, -1);
            default:
                return new RelativeLayout.LayoutParams(-2, -2);
        }
    }
}
