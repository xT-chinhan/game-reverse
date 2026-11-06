package com.byazt.re;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.ur;
import com.byazt.has.fs;
import com.byazt.nf.rv;
import com.byazt.udb.sz;
import com.byazt.wd.x;
import com.byazt.yyw.AbstractEndCardFrameLayout;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 796, 26})
public class qg {
    public com.byazt.ki.qg cp;
    public com.byazt.ki.s d;
    public l fs;
    public boolean k;
    public int l;
    public final TTBaseVideoActivity n;
    public final com.byazt.xk.n oa;
    public boolean ou;
    public boolean q;
    public pk qg;
    public com.byazt.re.n rv;
    public String s;
    public com.byazt.ki.n sz;
    public com.byazt.ys.qg tj;
    public int w;
    public AbstractEndCardFrameLayout x;
    public int cy = -1;
    public boolean hd = false;
    public final AtomicBoolean cd = new AtomicBoolean(false);
    public final AtomicBoolean um = new AtomicBoolean(false);
    public int py = 0;
    public boolean a = false;

    public interface n {
        void n();
    }

    /* JADX INFO: renamed from: com.byazt.re.qg$qg, reason: collision with other inner class name */
    public interface InterfaceC0323qg {
        void n();

        void qg();

        l s();
    }

    public qg(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
        this.oa = new com.byazt.xk.n(tTBaseVideoActivity);
    }

    public void n(l lVar, com.byazt.re.n nVar, boolean z, String str, int i, int i2) {
        this.q = z;
        this.fs = lVar;
        this.rv = nVar;
        this.s = str;
        this.l = i;
        this.w = i2;
    }

    public void n(pk pkVar, com.byazt.ys.qg qgVar, com.byazt.cs.n nVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.a) {
            return;
        }
        this.a = true;
        this.qg = pkVar;
        this.tj = qgVar;
        this.oa.n(pkVar);
        this.x = abstractEndCardFrameLayout;
        n();
        n(nVar);
        this.ou = x.n(String.valueOf(com.byazt.vgx.w.cy(this.qg)));
    }

    public void n() {
        if (this.qg.el() == 1) {
            return;
        }
        if (com.byazt.qq.qg.qg(this.qg)) {
            this.d = new com.byazt.ki.s(this.n, this.qg, this.s, this.l, this.w, this.q, this.x);
        }
        if (!TextUtils.isEmpty(ta.rv(this.qg)) && !rv.qg().vu()) {
            this.cp = new com.byazt.ki.qg(this.n, this.qg, this.s, this.l, this.w, this.q, this.x);
        }
        com.byazt.ki.n nVar = this.d;
        if (nVar == null) {
            nVar = this.cp;
        }
        this.sz = nVar;
    }

    public void n(long j, long j2, int i) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.n(j, j2, i);
        }
    }

    public void n(int i, int i2) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.n(i, i2);
        }
    }

    public void n(boolean z) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.qg(z);
        }
    }

    public void n(com.byazt.cs.n nVar) {
        Map<String, Object> mapPk = this.n.pk();
        this.oa.n(this.tj);
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.n(nVar);
            this.d.n(this.q, mapPk, this.fs.q());
            this.d.n(this.rv.x(), this.tj);
            this.d.n(new n() { // from class: com.byazt.re.qg.1
                @Override // com.byazt.re.qg.n
                public void n() {
                    qg.this.l(false);
                }
            });
            this.d.n(new InterfaceC0323qg() { // from class: com.byazt.re.qg.2
                @Override // com.byazt.re.qg.InterfaceC0323qg
                public void n() {
                    qg.this.n.qg(true, true);
                }

                @Override // com.byazt.re.qg.InterfaceC0323qg
                public void qg() {
                    qg.this.n.oa();
                }

                @Override // com.byazt.re.qg.InterfaceC0323qg
                public l s() {
                    return qg.this.fs;
                }
            });
        }
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            qgVar.n(this.q, mapPk, this.fs.q());
            this.cp.n(this.rv.x(), this.tj);
        }
    }

    public void qg() {
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.t();
        }
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            qgVar.ur();
        }
    }

    public void s() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.d();
        }
    }

    public void q() {
        if (df()) {
            return;
        }
        int i = this.cy;
        if (i >= 0) {
            this.n.qg(i);
            n(0L);
        }
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.hu();
        }
    }

    public void l() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.oa();
        }
    }

    public void qg(boolean z) {
        if (this.cy >= 0) {
            this.n.cy();
        }
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.q(z);
        }
    }

    public void w() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.cd();
        }
        com.byazt.ki.n nVar2 = this.sz;
        if (nVar2 != null) {
            nVar2.sz();
        }
    }

    public void x() {
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            qgVar.k();
        }
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.k();
        }
    }

    public void fs() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.cy();
        }
    }

    public void rv() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.h();
        }
    }

    public int tj() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            return nVar.tj();
        }
        return 0;
    }

    public String cp() {
        com.byazt.ki.n nVar = this.sz;
        return nVar != null ? nVar.cp() : "";
    }

    public void n(Map<String, Object> map) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.n(map);
        }
    }

    public void d() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.hd();
        }
    }

    public void oa() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.um();
        }
    }

    public void n(boolean z, int i, String str) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.n(z, i, str);
        }
    }

    public void sz() {
        if (!this.n.nf().nf()) {
            m();
        }
        this.fs.s(false);
        this.fs.w(false);
        this.fs.qg(this.qg.yv());
        this.fs.x(false);
        u();
        if (this.sz == null && rv.qg().vu() && !TextUtils.isEmpty(ta.rv(this.qg))) {
            com.byazt.ki.qg qgVar = new com.byazt.ki.qg(this.n, this.qg, this.s, this.l, this.w, this.q, this.x);
            this.cp = qgVar;
            qgVar.n(this.q, this.n.pk(), this.fs.q());
            this.cp.n(this.rv.x(), this.tj);
            qg();
            this.sz = this.cp;
        }
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.l();
            this.sz.n(1);
            this.fs.l(true ^ (this.sz instanceof com.byazt.ki.qg));
            return;
        }
        this.fs.l(false);
    }

    public void s(boolean z) {
        this.k = z;
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.w(z);
        }
    }

    public boolean k() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            return nVar.x();
        }
        return false;
    }

    public void cy() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.fs();
        }
    }

    public boolean hd() {
        boolean zUm;
        if (ta.cp(this.qg)) {
            zUm = cd();
        } else {
            zUm = um();
        }
        if (this.sz == null && !TextUtils.isEmpty(ta.rv(this.qg)) && rv.qg().vu()) {
            return true;
        }
        if (a()) {
            return zUm || com.byazt.qq.qg.qg(this.qg);
        }
        return false;
    }

    public boolean cd() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            return nVar.qg();
        }
        return false;
    }

    public boolean um() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            return nVar.s();
        }
        return false;
    }

    public boolean a() {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            return nVar.q();
        }
        return false;
    }

    public boolean py() {
        if (this.hd) {
            return true;
        }
        com.byazt.ki.n nVar = this.sz;
        if (nVar instanceof com.byazt.ki.s) {
            return this.d.ln();
        }
        return nVar instanceof com.byazt.ki.qg;
    }

    public void ou() {
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            this.sz = qgVar;
        }
    }

    public void wm() {
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            qgVar.rv();
        }
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.rv();
        }
    }

    public void m() {
        if (com.byazt.qq.qg.s(this.qg) || df()) {
            return;
        }
        this.cy = Math.max(n(this.qg), 0);
        n(0L);
    }

    private int n(pk pkVar) {
        return pkVar.ma();
    }

    public void hu() {
        s(true);
        com.byazt.ki.s sVar = this.d;
        if (sVar != null && sVar.s()) {
            this.d.n(this.n.nf() instanceof fs ? 2 : 0);
        } else {
            l(false);
        }
        if (this.cp != null) {
            this.sz = this.d;
        }
    }

    public boolean h() {
        com.byazt.ki.s sVar = this.d;
        return sVar != null && sVar.s();
    }

    public com.byazt.gcl.s t() {
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            return sVar.lh();
        }
        return null;
    }

    public void ur() {
        s(false);
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.w();
        }
        if (this.hd) {
            ae();
        }
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar != null) {
            this.sz = qgVar;
        }
    }

    public boolean bb() {
        return this.sz instanceof com.byazt.ki.s;
    }

    public boolean ln() {
        return this.k;
    }

    private void n(long j) {
        int i = this.cy / 1000;
        if (!cx.hd(this.qg)) {
            if (i > 0) {
                this.fs.n(false, i + com.anythink.core.common.s.a, null, false, false);
            } else {
                this.fs.n(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.cy = (int) (((long) this.cy) - j);
            this.n.n(j);
        }
    }

    public boolean lh() {
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar == null) {
            return false;
        }
        return qgVar.py();
    }

    public void v() {
        n(1000L);
    }

    public boolean j() {
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            return sVar.v();
        }
        return false;
    }

    public void q(boolean z) {
        this.cd.set(z);
    }

    public boolean an() {
        return this.cd.get();
    }

    public void l(boolean z) {
        if (an() || ln()) {
            this.hd = true;
            com.byazt.ki.n nVar = this.sz;
            if (nVar != null) {
                nVar.a();
                this.sz.w();
            }
            com.byazt.ki.s sVar = this.d;
            if (sVar != null) {
                sVar.wm();
            }
            l lVar = this.fs;
            if (lVar != null) {
                lVar.x();
            }
            if (this.fs != null && this.qg.dg()) {
                com.byazt.okk.s.n(this.fs.q(), 0);
            }
            int iCy = com.byazt.vgx.w.cy(this.qg);
            com.byazt.eji.s.n().n("show_backup_endcard", String.valueOf(iCy), this.qg.q(), com.byazt.vgx.w.a(this.qg), this.q ? 7 : 8, null, this.qg.F_(), null, cp(), tj(), null);
            this.oa.n();
            if (cd.n(this.qg)) {
                this.n.oa(8);
            }
            this.fs.n(true);
            this.fs.x(false);
            this.n.fi().postDelayed(new Runnable() { // from class: com.byazt.re.qg.3
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.fs.n(true);
                    if (qg.this.fs.l()) {
                        return;
                    }
                    qg.this.fs.n(false, null, null, true, true);
                    if (qg.this.j() && qg.this.q) {
                        qg.this.dg();
                    }
                }
            }, 500L);
            if (z) {
                if (!cx.hd(this.qg)) {
                    this.fs.n(false, null, null, true, true);
                }
                this.fs.l(false);
                this.fs.qg(this.qg.yv());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg() {
        if (this.n.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.n);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.n);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(com.byazt.okk.s.s(this.n, 20.0f), com.byazt.okk.s.s(this.n, 12.0f), com.byazt.okk.s.s(this.n, 20.0f), com.byazt.okk.s.s(this.n, 12.0f));
        TextView textView = new TextView(this.n);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.n.fi().postDelayed(new Runnable() { // from class: com.byazt.re.qg.4
            @Override // java.lang.Runnable
            public void run() {
                qg.this.dg();
            }
        }, 6000L);
    }

    public void ae() {
        this.oa.s();
    }

    public void n(pk pkVar, com.byazt.ys.qg qgVar) {
        this.qg = pkVar;
        this.tj = qgVar;
        this.oa.n(pkVar);
        this.oa.n(this.tj);
        if (com.byazt.qq.qg.qg(pkVar)) {
            if (this.d == null) {
                this.d = new com.byazt.ki.s(this.n, pkVar, this.s, this.l, this.w, this.q, this.x);
            }
            com.byazt.ki.s sVar = this.d;
            this.sz = sVar;
            sVar.n(new n() { // from class: com.byazt.re.qg.5
                @Override // com.byazt.re.qg.n
                public void n() {
                    qg.this.l(false);
                }
            });
            this.d.n(new InterfaceC0323qg() { // from class: com.byazt.re.qg.6
                @Override // com.byazt.re.qg.InterfaceC0323qg
                public void n() {
                    qg.this.n.qg(true, true);
                }

                @Override // com.byazt.re.qg.InterfaceC0323qg
                public void qg() {
                    qg.this.n.oa();
                }

                @Override // com.byazt.re.qg.InterfaceC0323qg
                public l s() {
                    return qg.this.fs;
                }
            });
        } else {
            this.sz = this.cp;
        }
        try {
            com.byazt.ki.n nVar = this.sz;
            if (nVar != null) {
                nVar.n(this.qg);
                this.sz.n(this.q, this.n.pk(), this.fs.q());
                this.sz.n(this.rv.x(), this.tj);
                qg();
            }
        } catch (Throwable unused) {
        }
    }

    public void n(final String str) {
        this.n.fi().post(new Runnable() { // from class: com.byazt.re.qg.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                qg.this.oa.n(str);
            }
        });
    }

    public String f() {
        com.byazt.ki.n nVar = this.sz;
        return nVar != null ? nVar.m() : "endcard";
    }

    public void w(boolean z) {
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.l(z);
        }
    }

    public void qg(int i, int i2) {
        com.byazt.ki.s sVar = this.d;
        if (sVar != null) {
            sVar.qg(i, i2);
        }
    }

    public void n(JSONObject jSONObject) {
        com.byazt.ki.n nVar = this.sz;
        if (nVar != null) {
            nVar.n(jSONObject);
        }
    }

    public void fi() {
        this.py = cx.qg(this.qg, this.n.nf().oj());
        this.um.set(cx.py(this.qg));
        com.byazt.rv.s.s = true;
    }

    public boolean df() {
        return an() && this.um.get();
    }

    public int oj() {
        return this.py;
    }

    public void n(sz szVar) {
        com.byazt.ki.qg qgVar = this.cp;
        if (qgVar == null) {
            return;
        }
        qgVar.n(szVar);
    }

    private void u() {
        try {
            if (!ur.n(this.qg) || this.ou) {
                return;
            }
            float[] fArrN = com.byazt.ce.qg.n(this.n.getApplicationContext(), this.qg.sl(), this.qg.ys());
            float f = fArrN[0];
            float f2 = fArrN[1];
            if (this.qg.sl() == 100.0f) {
                this.l = (int) f;
                this.w = (int) f2;
                return;
            }
            int[] iArrN = com.byazt.ce.qg.n(this.n.getApplicationContext(), this.qg.sl(), this.qg.zb(), this.qg.ys());
            int i = iArrN[0];
            int i2 = iArrN[1];
            int i3 = iArrN[2];
            int i4 = iArrN[3];
            float f3 = i;
            float f4 = i3;
            this.l = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.w = (int) ((f2 - f5) - f6);
            this.n.getWindow().getDecorView().setPadding(com.byazt.okk.s.s(this.n, f3), com.byazt.okk.s.s(this.n, f5), com.byazt.okk.s.s(this.n, f4), com.byazt.okk.s.s(this.n, f6));
        } catch (Throwable unused) {
        }
    }
}
