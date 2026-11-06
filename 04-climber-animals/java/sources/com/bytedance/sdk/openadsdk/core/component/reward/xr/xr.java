package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ny;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private AbstractEndCardFrameLayout ab;
    private String ah;
    private boolean b;
    private int c;
    private com.bytedance.sdk.openadsdk.core.xr.xr ch;
    private boolean d;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTBaseVideoActivity f2310ms;
    private com.bytedance.sdk.openadsdk.core.component.reward.xr.ms ny;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah sl;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms u;
    private boolean ub;
    private ka x;
    private lm xr;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.ms zb;
    private int ao = -1;
    private boolean h = false;
    private final AtomicBoolean qv = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);
    private int nw = 0;
    private boolean t = false;

    public interface ms {
        void ms();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr$xr, reason: collision with other inner class name */
    public interface InterfaceC0279xr {
        ka ah();

        void ms();

        void xr();
    }

    public xr(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f2310ms = tTBaseVideoActivity;
        this.zb = new com.bytedance.sdk.openadsdk.core.component.reward.view.ms(tTBaseVideoActivity);
    }

    public void ms(ka kaVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ms msVar, boolean z, String str, int i, int i2) {
        this.d = z;
        this.x = kaVar;
        this.ny = msVar;
        this.ah = str;
        this.ka = i;
        this.c = i2;
    }

    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.t) {
            return;
        }
        this.t = true;
        this.xr = lmVar;
        this.ch = xrVar;
        this.zb.ms(lmVar);
        this.ab = abstractEndCardFrameLayout;
        ms(abstractEndCardFrameLayout);
        ms(msVar);
        this.b = com.bytedance.sdk.openadsdk.core.u.d.ms(String.valueOf(f.ny(this.xr)));
    }

    void ms(AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.xr.yu() == 1) {
            return;
        }
        if (nw.xr(this.xr)) {
            this.sl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah(this.f2310ms, this.xr, this.ah, this.ka, this.c, this.d, this.ab);
        }
        if (!TextUtils.isEmpty(qr.ms(this.xr))) {
            this.hi = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr(this.f2310ms, this.xr, this.ah, this.ka, this.c, this.d, this.ab);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.sl;
        if (msVar == null) {
            msVar = this.hi;
        }
        this.u = msVar;
    }

    public void ms(long j, long j2, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ms(j, j2, i);
        }
    }

    public void ms(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ms(i, i2);
        }
    }

    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.xr(z);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar) {
        Map<String, Object> mapEg = this.f2310ms.eg();
        this.zb.ms(this.ch);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.ms(msVar);
            this.sl.ms(this.d, mapEg, this.x.d());
            this.sl.ms(this.ny.ab(), this.ch);
            this.sl.ms(new ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms
                public void ms() {
                    xr.this.ka(false);
                }
            });
            this.sl.ms(new InterfaceC0279xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public void ms() {
                    xr.this.f2310ms.xr(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public void xr() {
                    xr.this.f2310ms.zb();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public ka ah() {
                    return xr.this.x;
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            xrVar.ms(this.d, mapEg, this.x.d());
            this.hi.ms(this.ny.ab(), this.ch);
        }
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.op();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            xrVar.le();
        }
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.sl();
        }
    }

    public void ah() {
        if (az()) {
            return;
        }
        int i = this.ao;
        if (i >= 0) {
            this.f2310ms.xr(i);
            ms(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.w();
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.zb();
        }
    }

    public void xr(boolean z) {
        if (this.ao >= 0) {
            this.f2310ms.ao();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.d(z);
        }
    }

    public void ka() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.qv();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar2 = this.u;
        if (msVar2 != null) {
            msVar2.u();
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            xrVar.ub();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.ub();
        }
    }

    public void ab() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ao();
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.yu();
        }
    }

    public int ny() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            return msVar.ch();
        }
        return 0;
    }

    public String ch() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        return msVar != null ? msVar.hi() : "";
    }

    public void ms(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ms(map);
        }
    }

    public void hi() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.h();
        }
    }

    public void sl() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.y();
        }
    }

    public void ms(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ms(z, i, str);
        }
    }

    public void zb() {
        if (!qf.h(this.xr)) {
            re();
        }
        this.x.ah(false);
        this.x.c(false);
        this.x.xr(this.xr.rk());
        this.x.ab(false);
        this.x.ka(!(this.u instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr));
        e();
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ka();
            this.u.ms(1);
        }
    }

    public void ah(boolean z) {
        this.ub = z;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.c(z);
        }
    }

    public boolean u() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            return msVar.ab();
        }
        return false;
    }

    public void ub() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.x();
        }
    }

    public boolean ao() {
        boolean zQv;
        if (qr.ch(this.xr)) {
            zQv = h();
        } else {
            zQv = qv();
        }
        if (y()) {
            return zQv || nw.xr(this.xr);
        }
        return false;
    }

    public boolean h() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            return msVar.xr();
        }
        return false;
    }

    public boolean qv() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            return msVar.ah();
        }
        return false;
    }

    public boolean y() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            return msVar.d();
        }
        return false;
    }

    public boolean t() {
        if (this.h) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah) {
            return this.sl.g();
        }
        return msVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr;
    }

    public void nw() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            this.u = xrVar;
        }
    }

    public void b() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            xrVar.ny();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.ny();
        }
    }

    public void re() {
        if (nw.ah(this.xr) || az()) {
            return;
        }
        this.ao = Math.max(ms(this.xr), 0);
        ms(0L);
    }

    private int ms(lm lmVar) {
        return lmVar.hg();
    }

    public void i() {
        ah(true);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null && ahVar.ah()) {
            this.sl.ms(this.f2310ms.sa() instanceof ny ? 2 : 0);
        } else {
            ka(false);
        }
        if (this.hi != null) {
            this.u = this.sl;
        }
    }

    public boolean w() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        return ahVar != null && ahVar.ah();
    }

    public pc yu() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            return ahVar.of();
        }
        return null;
    }

    public void op() {
        ah(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.c();
        }
        if (this.h) {
            jw();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar != null) {
            this.u = xrVar;
        }
    }

    public boolean le() {
        return this.u instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah;
    }

    public boolean cv() {
        return this.ub;
    }

    private void ms(long j) {
        int i = this.ao / 1000;
        if (!qf.h(this.xr)) {
            if (i > 0) {
                this.x.ms(false, i + "s", null, false, false);
            } else {
                this.x.ms(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.ao = (int) (((long) this.ao) - j);
            this.f2310ms.ms(j);
        }
    }

    public boolean g() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar == null) {
            return false;
        }
        return xrVar.nw();
    }

    public void of() {
        ms(1000L);
    }

    public boolean p() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            return ahVar.p();
        }
        return false;
    }

    public void d(boolean z) {
        this.qv.set(z);
    }

    public boolean pc() {
        return this.qv.get();
    }

    public void ka(boolean z) {
        if (pc() || cv()) {
            this.h = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
            if (msVar != null) {
                msVar.t();
                this.u.c();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
            if (ahVar != null) {
                ahVar.re();
            }
            ka kaVar = this.x;
            if (kaVar != null) {
                kaVar.ab();
            }
            u.ms().c(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.3
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarC = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(xr.this.d ? 7 : 8).ah(String.valueOf(f.ny(xr.this.xr))).c(f.zb(xr.this.xr));
                    xrVarC.xr(xr.this.ny()).ab(xr.this.ch());
                    xrVarC.x(xr.this.xr.lx()).d(xr.this.xr.df());
                    return xrVarC;
                }
            });
            this.zb.ms();
            if (t.ms(this.xr)) {
                this.f2310ms.sl(8);
            }
            this.x.ms(true);
            this.x.ab(false);
            this.f2310ms.az().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.4
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.x.ms(true);
                    if (xr.this.x.ka()) {
                        return;
                    }
                    xr.this.x.ms(false, null, null, true, true);
                    if (xr.this.p() && xr.this.d) {
                        xr.this.lm();
                    }
                }
            }, 500L);
            if (z) {
                if (!qf.h(this.xr)) {
                    this.x.ms(false, null, null, true, true);
                }
                this.x.ka(false);
                this.x.xr(this.xr.rk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.f2310ms.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.f2310ms);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.f2310ms);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ul.ah(this.f2310ms, 20.0f), ul.ah(this.f2310ms, 12.0f), ul.ah(this.f2310ms, 20.0f), ul.ah(this.f2310ms, 12.0f));
        TextView textView = new TextView(this.f2310ms);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.f2310ms.az().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.5
            @Override // java.lang.Runnable
            public void run() {
                xr.this.lm();
            }
        }, 6000L);
    }

    public void jw() {
        this.zb.ah();
    }

    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.xr = lmVar;
        this.ch = xrVar;
        this.zb.ms(lmVar);
        this.zb.ms(this.ch);
        if (nw.xr(lmVar)) {
            if (this.sl == null) {
                this.sl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah(this.f2310ms, lmVar, this.ah, this.ka, this.c, this.d, this.ab);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
            this.u = ahVar;
            ahVar.ms(new ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.ms
                public void ms() {
                    xr.this.ka(false);
                }
            });
            this.sl.ms(new InterfaceC0279xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public void ms() {
                    xr.this.f2310ms.xr(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public void xr() {
                    xr.this.f2310ms.zb();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.InterfaceC0279xr
                public ka ah() {
                    return xr.this.x;
                }
            });
        } else {
            this.u = this.hi;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
            if (msVar != null) {
                msVar.ms(this.xr);
                this.u.ms(this.d, this.f2310ms.eg(), this.x.d());
                this.u.ms(this.ny.ab(), this.ch);
                ms();
            }
        } catch (Throwable unused) {
        }
    }

    public void ms(final String str) {
        this.f2310ms.az().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.xr.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                xr.this.zb.ms(str);
            }
        });
    }

    public String f() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        return msVar != null ? msVar.i() : "endcard";
    }

    public void c(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.ka(z);
        }
    }

    public void xr(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ah ahVar = this.sl;
        if (ahVar != null) {
            ahVar.xr(i, i2);
        }
    }

    public void ms(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.ms msVar = this.u;
        if (msVar != null) {
            msVar.ms(jSONObject);
        }
    }

    public void ul() {
        this.nw = qf.xr(this.xr, this.f2310ms.sa().f());
        this.y.set(qf.nw(this.xr));
        com.bytedance.sdk.openadsdk.core.x.d.ah = true;
    }

    public boolean az() {
        return pc() && this.y.get();
    }

    public int m() {
        return this.nw;
    }

    public void ms(com.bytedance.sdk.component.adexpress.xr.u uVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xr xrVar = this.hi;
        if (xrVar == null) {
            return;
        }
        xrVar.ms(uVar);
    }

    private void e() {
        try {
            if (!le.ms(this.xr) || this.b) {
                return;
            }
            float[] fArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.f2310ms.getApplicationContext(), this.xr.ld(), this.xr.od());
            float f = fArrMs[0];
            float f2 = fArrMs[1];
            if (this.xr.ld() == 100.0f) {
                this.ka = (int) f;
                this.c = (int) f2;
                return;
            }
            int[] iArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.f2310ms.getApplicationContext(), this.xr.ld(), this.xr.mp(), this.xr.od());
            int i = iArrMs[0];
            int i2 = iArrMs[1];
            int i3 = iArrMs[2];
            int i4 = iArrMs[3];
            float f3 = i;
            float f4 = i3;
            this.ka = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.c = (int) ((f2 - f5) - f6);
            this.f2310ms.getWindow().getDecorView().setPadding(ul.ah(this.f2310ms, f3), ul.ah(this.f2310ms, f5), ul.ah(this.f2310ms, f4), ul.ah(this.f2310ms, f6));
        } catch (Throwable unused) {
        }
    }
}
