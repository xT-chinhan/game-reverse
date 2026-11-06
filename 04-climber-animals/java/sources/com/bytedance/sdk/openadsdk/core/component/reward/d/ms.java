package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends xr implements le.ms {
    protected int ah;
    protected boolean ao;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.d b;
    protected int c;
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.ka ch;
    protected float d;
    protected boolean h;
    protected AbstractEndCardFrameLayout hi;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.ka i;
    protected int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final TTBaseVideoActivity f2142ms;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.xr nw;
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ny;
    protected com.bytedance.sdk.openadsdk.core.component.reward.ka.ah p;
    protected boolean qv;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.c re;
    protected String sl;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.c t;
    protected boolean u;
    com.bytedance.sdk.openadsdk.core.component.reward.xr.ms w;
    protected com.bytedance.sdk.openadsdk.core.xr.ka x;
    protected lm xr;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.ka y;
    protected boolean zb;
    protected int ab = -1;
    protected AtomicBoolean ub = new AtomicBoolean(false);
    protected int yu = -5;
    protected boolean op = false;
    protected boolean le = false;
    protected final le cv = new le(Looper.getMainLooper(), this);
    protected int g = Integer.MIN_VALUE;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.hi pc = new com.bytedance.sdk.openadsdk.core.nativeexpress.hi() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ms(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ms(boolean z) {
            if (ms.this.zb != z) {
                ms.this.zb = z;
                ms.this.y.xr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ab() {
            u.ms().ah(ms.this.xr, "stats_reward_full_click_express_close");
            ms.this.y.ms();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void x() {
            u.ms().ah(ms.this.xr, "stats_reward_full_click_express_close");
            ms.this.f2142ms.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ms(int i) {
            if (i != 1) {
                if (i == 2) {
                    ms.this.t.yu();
                    return;
                }
                if (i == 3) {
                    ms.this.t.op();
                    return;
                } else if (i == 4) {
                    ms.this.t.ab();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (ms.this.t.xr() || ms.this.t.ah() || ms.this.t.lm()) {
                return;
            }
            ms.this.f2142ms.xr(0L, false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public long ms() {
            ms msVar = ms.this;
            msVar.xr(msVar.c(true));
            return ms.this.p.ms();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void setPauseFromExpressView(boolean z) {
            ms.this.f2142ms.ub(1);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public int xr() {
            if (ms.this.ch.xr()) {
                return 4;
            }
            if (ms.this.ch.ah()) {
                return 5;
            }
            if (ms.this.t.d()) {
                return 1;
            }
            if (ms.this.t.xr()) {
                return 2;
            }
            ms.this.t.ah();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public int ah() {
            return ms.this.w();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public long getActualPlayDuration() {
            return ms.this.t.p().k();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ch() {
            ms.this.y.ah();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void hi() {
            ms.this.f2142ms.x(3);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ms(float f, float f2, float f3, float f4, int i) {
            ms.this.f2142ms.ms(f, f2, f3, f4, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void d() {
            ms.this.op = true;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void xr(int i) {
            if (qf.ka(ms.this.xr)) {
                ms.this.f2142ms.d(1);
            } else {
                ms.this.f2142ms.ms(i, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ka() {
            ms.this.op = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ms(float f) {
            ms.this.ah((int) (1000.0f / f));
            ms.this.f2142ms.l().ms(f);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void c() {
            ms.this.le = true;
            ms.this.f2142ms.qk();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
        public void ny() {
            ms.this.f2142ms.v();
        }
    };
    public int of = 1000;

    public void ah(boolean z) {
    }

    public int cv() {
        return 0;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public void ms(int i) {
    }

    public void ms(int i, int i2, Intent intent) {
    }

    public void ms(View view) {
    }

    public void ms(Map<String, Object> map) {
    }

    public void ms(JSONObject jSONObject) {
    }

    public boolean of() {
        return true;
    }

    public void p() {
    }

    public com.bytedance.sdk.openadsdk.core.video.xr.xr pc() {
        return null;
    }

    public void u() {
    }

    public void xr(Map<String, Object> map) {
    }

    public ms(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        this.f2142ms = tTBaseVideoActivity;
        this.xr = lmVar;
        this.ah = lmVar.od();
        this.d = lmVar.ld();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.c cVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.d dVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ms msVar) {
        this.y = kaVar;
        this.t = cVar;
        this.nw = xrVar;
        this.b = dVar;
        this.w = msVar;
    }

    public void ms(String str, boolean z, boolean z2) {
        this.sl = str;
        this.zb = z;
        this.u = z2;
        this.p = new com.bytedance.sdk.openadsdk.core.component.reward.ka.ah(z2, this.xr, this.t, this);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.xr.ka ms() {
        return this.y;
    }

    public final void ms(com.bytedance.sdk.openadsdk.core.xr.ka kaVar) {
        this.x = kaVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.f2142ms;
        lm lmVar = this.xr;
        String str = this.sl;
        this.re = new com.bytedance.sdk.openadsdk.core.nativeexpress.c(tTBaseVideoActivity, lmVar, str, f.xr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c, com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
                if (lm.ka(this.f3795ms)) {
                    return;
                }
                super.ms(view, hiVar);
                ms.this.f2142ms.ms(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.f2142ms;
        lm lmVar2 = this.xr;
        String str2 = this.sl;
        this.i = new com.bytedance.sdk.openadsdk.core.nativeexpress.ka(tTBaseVideoActivity2, lmVar2, str2, f.xr(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ka, com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
                if (lm.ka(this.f3795ms)) {
                    return;
                }
                super.ms(view, hiVar);
                com.bytedance.sdk.openadsdk.core.xr.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.xr.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.class);
                if (xrVar == null || !xrVar.xr(view)) {
                    return;
                }
                ms.this.f2142ms.ms(2);
            }
        };
        this.hi.setClickListener(this.x);
    }

    private void zf() {
        this.y.ms(false);
        this.ny.c(8);
        this.ny.ka(8);
        this.ny.ah(8);
        qk();
    }

    public void xr() {
        zf();
        vm();
        if (s()) {
            qf.ms(this.xr, true);
        }
        if (l()) {
            this.nw.ms();
        }
        if (c()) {
            ka();
        } else {
            ah();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        d();
    }

    protected void d() {
        boolean zC = this.ch.c();
        if (!this.nw.pc() && !zC) {
            ao();
        }
        this.nw.ms(this.ch.hi());
        if (zC) {
            this.ch.ms().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.ny.ah(!zC);
        this.ch.ah(zC);
        this.y.ms(tz() || !zC);
        this.f2142ms.ka();
        if (qf.h(this.xr)) {
            yu();
        }
    }

    protected void ka() {
        this.f2142ms.ab(0);
        this.y.ms(tz());
        float f = this.ka;
        float f2 = this.c;
        float[] fArrY = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrY = y();
        }
        this.ch.ms(this.xr, op.ms(this.f2142ms.op() ? 7 : 8, String.valueOf(f.ny(this.xr)), fArrY[0], fArrY[1]), this.sl, this.zb);
        this.ny.ah(false);
        this.ch.ah(true);
        this.ch.ms(this.pc);
        this.ch.ms(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void xr(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, String str, int i) {
                if (ms.this.nw.pc()) {
                    return;
                }
                ms.this.nw.ms();
                ms.this.f2142ms.nw();
                ms.this.f2142ms.ab(8);
                ms.this.y.ms(true);
                ms.this.cv.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.f2142ms.t();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, float f3, float f4) {
                if (ms.this.nw.pc()) {
                    return;
                }
                ms.this.nw.ms();
                ms.this.f2142ms.nw();
                ms.this.f2142ms.ab(8);
                ms msVar = ms.this;
                msVar.ab = msVar.ch.ny();
                if (ms.this.ab == 0) {
                    qf.xr(ms.this.xr, true);
                }
                ms.this.ah();
            }
        });
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.f2142ms.eg());
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.f2142ms.eg());
        this.f2142ms.ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.f2142ms.ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.ch.ms(this.re, this.i);
        this.ch.x();
    }

    public boolean c() {
        return this.xr.fm() == 2;
    }

    public boolean ab() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar;
        return c() && (kaVar = this.ch) != null && kaVar.c();
    }

    public void x() {
        if ((this.u || !qf.re(this.xr)) && !(this instanceof hi)) {
            return;
        }
        k();
    }

    public View ny() {
        int iVm = this.xr.vm();
        if (iVm == 1) {
            return com.bytedance.sdk.openadsdk.res.ka.ah(this.f2142ms);
        }
        if (iVm == 3) {
            return com.bytedance.sdk.openadsdk.res.ka.d(this.f2142ms);
        }
        return com.bytedance.sdk.openadsdk.res.ka.ms(this.f2142ms);
    }

    public View ch() {
        if (this.hi == null) {
            this.hi = new CommonEndCardFrameLayout(this.f2142ms, this.xr);
        }
        return this.hi;
    }

    public View hi() {
        return com.bytedance.sdk.openadsdk.res.ka.ka(this.f2142ms);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ah ahVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ah(this.f2142ms, this.xr, z);
        this.ny = ahVar;
        return ahVar;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.ka sl() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ka(this.f2142ms);
        this.ch = kaVar;
        return kaVar;
    }

    public AbstractEndCardFrameLayout zb() {
        return this.hi;
    }

    public void ms(int i, int i2) {
        this.ka = i;
        this.c = i2;
    }

    public void xr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar = this.ch;
        if (kaVar != null) {
            kaVar.ka();
        }
    }

    public void ub() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.hi;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.xr();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar = this.ch;
        if (kaVar != null) {
            kaVar.d();
        }
        if (am() || this.nw.pc()) {
            return;
        }
        this.nw.b();
    }

    public void ao() {
        this.ny.ao();
    }

    public FrameLayout qv() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar;
        if (t.d(this.xr)) {
            return this.hi.getVideoArea();
        }
        if (c() && (kaVar = this.ch) != null && kaVar.c()) {
            return this.ch.ms();
        }
        return this.ny.sl();
    }

    public void d(boolean z) {
        if (z) {
            if (this.ah == 1) {
                this.ny.d(0);
            }
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
                this.ny.c(0);
                return;
            }
            return;
        }
        if (this.ah == 1) {
            this.ny.d(8);
        }
    }

    protected float[] y() {
        TTBaseVideoActivity tTBaseVideoActivity = this.f2142ms;
        int iD = ul.d(tTBaseVideoActivity, ul.hi((Context) tTBaseVideoActivity));
        float f = this.c;
        float f2 = this.ka;
        int i = this.ah;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iD;
        } else {
            f2 -= iD;
        }
        return new float[]{f2, f};
    }

    public void t() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar = this.ch;
        if (kaVar != null) {
            kaVar.ms(this.p);
        }
        if (this.u) {
            this.ny.xr((int) (this.t.g() / 1000));
        }
    }

    public void nw() {
        this.cv.removeMessages(11);
    }

    public void b() {
        if (!this.ub.get() || this.cv.hasMessages(11)) {
            return;
        }
        this.cv.sendEmptyMessageDelayed(11, this.of);
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 11) {
            if (!this.h) {
                this.p.xr();
            }
            e();
            this.cv.sendEmptyMessageDelayed(11, this.of);
        }
    }

    public void ka(boolean z) {
        this.zb = z;
        this.t.ah(z);
    }

    public final int re() {
        return this.ab;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.ah(this.f2142ms, this.xr);
        ahVar.ms(az());
        ahVar.xr(jw());
        ahVar.ah(this.f2142ms.p());
        ahVar.d(this.f2142ms.pc());
        ahVar.ah(this.op);
        ahVar.d(qf.yu(this.xr) && !this.f2142ms.x.get());
        this.f2142ms.e();
        return ahVar.xr(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ms.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                ms.this.f2142ms.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms(int i) {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ah() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ah();
                }
            }
        });
    }

    public void i() {
        if (qf.h(this.xr)) {
            b();
        }
        if (this.nw.az()) {
            yu();
        }
    }

    protected int w() {
        return this.p.ah() + this.p.d();
    }

    protected void yu() {
        if (this.ub.getAndSet(true)) {
            return;
        }
        this.cv.sendEmptyMessage(11);
    }

    protected void op() {
        if (this.yu < 0) {
            this.yu = this.nw.m();
        }
        int i = this.yu;
        if (i > 0) {
            this.yu = i - 1;
            this.y.ms(false, this.yu + "s", null, true, true);
        } else if (i == 0) {
            this.f2142ms.d(0);
            this.y.ms(false, "奖励已领取", null, true, true);
        }
    }

    public void le() {
        this.ao = true;
    }

    public int jw() {
        if (s() && qf.h(this.xr)) {
            return w();
        }
        return m() + xn();
    }

    public int c(boolean z) {
        if (ti() && this.nw.az()) {
            return this.yu;
        }
        if (s() && qf.h(this.xr)) {
            return Math.max(lm() - w(), 0);
        }
        return ab(z);
    }

    public int f() {
        if (ti() && this.nw.az()) {
            return this.yu;
        }
        if (s() && qf.h(this.xr)) {
            return (int) Math.max((lm() * (this.xr.cb() / 100.0f)) - w(), 0.0f);
        }
        return ul();
    }

    protected int ab(boolean z) {
        if (z) {
            return x(false);
        }
        return rt();
    }

    protected int ul() {
        return x(true);
    }

    private int x(boolean z) {
        long jG = this.t.g();
        if (z) {
            long jMax = Math.max(Math.min(qf.ms(), (long) ((this.t.le() * 1000.0d) * ((double) (this.xr.cb() / 100.0f)))) - (jG + (((long) xn()) * 1000)), 0L);
            return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long jMin = Math.min(qf.ms(), (long) (this.t.le() * 1000.0d));
        long jXn = ((long) xn()) * 1000;
        long jLe = (long) ((this.t.le() % 1.0d) * 1000.0d);
        if (jLe > 0) {
            jG -= 1000 - jLe;
        }
        return Math.round((jMin - (jG + jXn)) / 1000.0f);
    }

    private int rt() {
        long jMax = Math.max(((long) (this.t.le() * 1000.0d)) - this.t.g(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - xn(), 0);
    }

    public void xr(int i) {
        this.g = i;
    }

    public int az() {
        int i = this.g;
        return i == Integer.MIN_VALUE ? c(true) : i;
    }

    protected int m() {
        return (int) (this.t.g() / 1000);
    }

    protected int lm() {
        if (nw.ah(this.xr)) {
            return nw.ka(this.xr);
        }
        return qf.ub(this.xr);
    }

    protected void e() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ka kaVar = this.ch;
        if (kaVar != null) {
            kaVar.ms(this.p);
        }
        if (ti() && this.nw.az()) {
            op();
        } else {
            v();
        }
    }

    protected void k() {
        if (this.qv || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.f2142ms;
        tTBaseVideoActivity.setTheme(com.bytedance.sdk.component.utils.t.ab(tTBaseVideoActivity, "tt_full_screen_interaction"));
        ul.ab((Activity) this.f2142ms);
        this.qv = true;
    }

    public boolean eg() {
        return !this.u && qf.re(this.xr) && this.ah == 1;
    }

    public void ah(int i) {
        this.of = i;
    }

    public com.bytedance.sdk.openadsdk.core.nativeexpress.hi fm() {
        return this.pc;
    }

    public void d(int i) {
        this.p.ms(i);
    }

    public int xn() {
        return this.p.d();
    }

    public int il() {
        return this.p.ka();
    }

    public boolean qf() {
        return this.le;
    }
}
