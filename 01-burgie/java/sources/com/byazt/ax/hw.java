package com.byazt.ax;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.dt.fw;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.ve;
import com.byazt.lu.zo;
import com.byazt.mq.g;
import com.byazt.sd.a;
import com.byazt.sd.nl;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.xz.AbstractEndCardFrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 13})
public class hw {
    public com.byazt.ax.pr aj;
    public int c;
    public AbstractEndCardFrameLayout fw;
    public com.byazt.yr.pr g;
    public String hn;
    public boolean ho;
    public of hw;
    public com.byazt.yr.hn k;
    public final com.byazt.pg.pr m;
    public boolean ny;
    public final TTBaseVideoActivity pr;
    public int uc;
    public com.byazt.az.hw vk;
    public com.byazt.yr.hw w;
    public boolean x;
    public c zo;
    public int nt = -1;
    public boolean yb = false;
    public final AtomicBoolean lb = new AtomicBoolean(false);
    public final AtomicBoolean qa = new AtomicBoolean(false);
    public int cz = 0;
    public boolean a = false;

    /* JADX INFO: renamed from: com.byazt.ax.hw$hw, reason: collision with other inner class name */
    public interface InterfaceC0020hw {
        c hn();

        void hw();

        void pr();
    }

    public interface pr {
        void pr();
    }

    public hw(TTBaseVideoActivity tTBaseVideoActivity) {
        this.pr = tTBaseVideoActivity;
        this.m = new com.byazt.pg.pr(tTBaseVideoActivity);
    }

    public void pr(c cVar, com.byazt.ax.pr prVar, boolean z, String str, int i, int i2) {
        this.x = z;
        this.zo = cVar;
        this.aj = prVar;
        this.hn = str;
        this.c = i;
        this.uc = i2;
    }

    public void pr(of ofVar, com.byazt.az.hw hwVar, com.byazt.mm.pr prVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.a) {
            return;
        }
        this.a = true;
        this.hw = ofVar;
        this.vk = hwVar;
        this.m.pr(ofVar);
        this.fw = abstractEndCardFrameLayout;
        pr();
        pr(prVar);
        this.ny = fw.pr(String.valueOf(ls.m(this.hw)));
    }

    public void pr() {
        if (this.hw.vj() == 1) {
            return;
        }
        if (ny.hw(this.hw)) {
            this.k = new com.byazt.yr.hn(this.pr, this.hw, this.hn, this.c, this.uc, this.x, this.fw);
        }
        if (!TextUtils.isEmpty(qv.aj(this.hw)) && !a.hw().li()) {
            this.w = new com.byazt.yr.hw(this.pr, this.hw, this.hn, this.c, this.uc, this.x, this.fw);
        }
        com.byazt.yr.pr prVar = this.k;
        if (prVar == null) {
            prVar = this.w;
        }
        this.g = prVar;
    }

    public void pr(long j, long j2, int i) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(j, j2, i);
        }
    }

    public void pr(int i, int i2) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(i, i2);
        }
    }

    public void pr(boolean z) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.hw(z);
        }
    }

    public void pr(com.byazt.mm.pr prVar) {
        Map<String, Object> mapIi = this.pr.ii();
        this.m.pr(this.vk);
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.pr(prVar);
            this.k.pr(this.x, mapIi, this.zo.x());
            this.k.pr(this.aj.fw(), this.vk);
            this.k.pr(new pr() { // from class: com.byazt.ax.hw.1
                @Override // com.byazt.ax.hw.pr
                public void pr() {
                    hw.this.c(false);
                }
            });
            this.k.pr(new InterfaceC0020hw() { // from class: com.byazt.ax.hw.2
                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public void pr() {
                    hw.this.pr.hw(true, true);
                }

                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public void hw() {
                    hw.this.pr.m();
                }

                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public c hn() {
                    return hw.this.zo;
                }
            });
        }
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            hwVar.pr(this.x, mapIi, this.zo.x());
            this.w.pr(this.aj.fw(), this.vk);
        }
    }

    public void hw() {
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.iu();
        }
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            hwVar.ve();
        }
    }

    public void hn() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.k();
        }
    }

    public void x() {
        if (v()) {
            return;
        }
        int i = this.nt;
        if (i >= 0) {
            this.pr.hw(i);
            pr(0L);
        }
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.z();
        }
    }

    public void c() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.m();
        }
    }

    public void hw(boolean z) {
        if (this.nt >= 0) {
            this.pr.nt();
        }
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.x(z);
        }
    }

    public void uc() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.lb();
        }
        com.byazt.yr.pr prVar2 = this.g;
        if (prVar2 != null) {
            prVar2.g();
        }
    }

    public void fw() {
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            hwVar.ho();
        }
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.ho();
        }
    }

    public void zo() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.nt();
        }
    }

    public void aj() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.b();
        }
    }

    public int vk() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.vk();
        }
        return 0;
    }

    public String w() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.w();
        }
        return "";
    }

    public void pr(Map<String, Object> map) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(map);
        }
    }

    public void k() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.yb();
        }
    }

    public void m() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.qa();
        }
    }

    public void pr(boolean z, int i, String str) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(z, i, str);
        }
    }

    public void g() {
        if (!this.pr.bm().f()) {
            rc();
        }
        this.zo.hn(false);
        this.zo.uc(false);
        this.zo.hw(this.hw.zz());
        this.zo.fw(false);
        of();
        if (this.g == null && a.hw().li() && !TextUtils.isEmpty(qv.aj(this.hw))) {
            com.byazt.yr.hw hwVar = new com.byazt.yr.hw(this.pr, this.hw, this.hn, this.c, this.uc, this.x, this.fw);
            this.w = hwVar;
            hwVar.pr(this.x, this.pr.ii(), this.zo.x());
            this.w.pr(this.aj.fw(), this.vk);
            hw();
            this.g = this.w;
        }
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.c();
            this.g.pr(1);
            this.zo.c(true ^ (this.g instanceof com.byazt.yr.hw));
            return;
        }
        this.zo.c(false);
    }

    public void hn(boolean z) {
        this.ho = z;
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.uc(z);
        }
    }

    public boolean ho() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.fw();
        }
        return false;
    }

    public void nt() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.zo();
        }
    }

    public boolean yb() {
        boolean zQa;
        if (qv.w(this.hw)) {
            zQa = lb();
        } else {
            zQa = qa();
        }
        if (this.g == null && !TextUtils.isEmpty(qv.aj(this.hw)) && a.hw().li()) {
            return true;
        }
        if (a()) {
            return zQa || ny.hw(this.hw);
        }
        return false;
    }

    public boolean lb() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.hw();
        }
        return false;
    }

    public boolean qa() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.hn();
        }
        return false;
    }

    public boolean a() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.x();
        }
        return false;
    }

    public boolean cz() {
        if (this.yb) {
            return true;
        }
        com.byazt.yr.pr prVar = this.g;
        if (prVar instanceof com.byazt.yr.hn) {
            return this.k.nl();
        }
        return prVar instanceof com.byazt.yr.hw;
    }

    public void ny() {
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            this.g = hwVar;
        }
    }

    public void fo() {
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            hwVar.aj();
        }
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.aj();
        }
    }

    public void rc() {
        if (ny.hn(this.hw) || v()) {
            return;
        }
        this.nt = Math.max(pr(this.hw), 0);
        pr(0L);
    }

    private int pr(of ofVar) {
        return ofVar.lp();
    }

    public void z() {
        hn(true);
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null && hnVar.hn()) {
            this.k.pr(this.pr.bm() instanceof zo ? 2 : 0);
        } else {
            c(false);
        }
        if (this.w != null) {
            this.g = this.k;
        }
    }

    public boolean b() {
        com.byazt.yr.hn hnVar = this.k;
        return hnVar != null && hnVar.hn();
    }

    public nl iu() {
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            return hnVar.y();
        }
        return null;
    }

    public void ve() {
        hn(false);
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.uc();
        }
        if (this.yb) {
            s();
        }
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar != null) {
            this.g = hwVar;
        }
    }

    public boolean gz() {
        return this.g instanceof com.byazt.yr.hn;
    }

    public boolean nl() {
        return this.ho;
    }

    private void pr(long j) {
        int i = this.nt / 1000;
        if (!jn.yb(this.hw)) {
            if (i > 0) {
                this.zo.pr(false, i + an.aB, null, false, false);
            } else {
                this.zo.pr(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.nt = (int) (((long) this.nt) - j);
            this.pr.pr(j);
        }
    }

    public boolean y() {
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar == null) {
            return false;
        }
        return hwVar.cz();
    }

    public void ww() {
        pr(1000L);
    }

    public boolean n() {
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            return hnVar.ww();
        }
        return false;
    }

    public void x(boolean z) {
        this.lb.set(z);
    }

    public boolean e() {
        return this.lb.get();
    }

    public void c(boolean z) {
        if (e() || nl()) {
            this.yb = true;
            com.byazt.yr.pr prVar = this.g;
            if (prVar != null) {
                prVar.a();
                this.g.uc();
            }
            com.byazt.yr.hn hnVar = this.k;
            if (hnVar != null) {
                hnVar.fo();
            }
            c cVar = this.zo;
            if (cVar != null) {
                cVar.fw();
            }
            if (this.zo != null && this.hw.v()) {
                er.pr(this.zo.x(), 0);
            }
            int iM = ls.m(this.hw);
            com.byazt.xk.hw.pr().pr("show_backup_endcard", String.valueOf(iM), this.hw.x(), ls.yb(this.hw), this.x ? 7 : 8, null, this.hw.B_(), null, w(), vk(), null);
            this.m.pr();
            if (lb.pr(this.hw)) {
                this.pr.m(8);
            }
            this.zo.pr(true);
            this.zo.fw(false);
            this.pr.er().postDelayed(new Runnable() { // from class: com.byazt.ax.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.zo.pr(true);
                    if (!hw.this.zo.c()) {
                        hw.this.zo.pr(false, null, null, true, true);
                        if (hw.this.n() && hw.this.x) {
                            hw.this.qn();
                        }
                    }
                }
            }, 500L);
            if (z) {
                if (!jn.yb(this.hw)) {
                    this.zo.pr(false, null, null, true, true);
                }
                this.zo.c(false);
                this.zo.hw(this.hw.zz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn() {
        if (this.pr.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.pr);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.pr);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(er.hn(this.pr, 20.0f), er.hn(this.pr, 12.0f), er.hn(this.pr, 20.0f), er.hn(this.pr, 12.0f));
        TextView textView = new TextView(this.pr);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.pr.er().postDelayed(new Runnable() { // from class: com.byazt.ax.hw.4
            @Override // java.lang.Runnable
            public void run() {
                hw.this.qn();
            }
        }, 6000L);
    }

    public void s() {
        this.m.hn();
    }

    public void pr(of ofVar, com.byazt.az.hw hwVar) {
        this.hw = ofVar;
        this.vk = hwVar;
        this.m.pr(ofVar);
        this.m.pr(this.vk);
        if (ny.hw(ofVar)) {
            if (this.k == null) {
                this.k = new com.byazt.yr.hn(this.pr, ofVar, this.hn, this.c, this.uc, this.x, this.fw);
            }
            com.byazt.yr.hn hnVar = this.k;
            this.g = hnVar;
            hnVar.pr(new pr() { // from class: com.byazt.ax.hw.5
                @Override // com.byazt.ax.hw.pr
                public void pr() {
                    hw.this.c(false);
                }
            });
            this.k.pr(new InterfaceC0020hw() { // from class: com.byazt.ax.hw.6
                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public void pr() {
                    hw.this.pr.hw(true, true);
                }

                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public void hw() {
                    hw.this.pr.m();
                }

                @Override // com.byazt.ax.hw.InterfaceC0020hw
                public c hn() {
                    return hw.this.zo;
                }
            });
        } else {
            this.g = this.w;
        }
        try {
            com.byazt.yr.pr prVar = this.g;
            if (prVar != null) {
                prVar.pr(this.hw);
                this.g.pr(this.x, this.pr.ii(), this.zo.x());
                this.g.pr(this.aj.fw(), this.vk);
                hw();
            }
        } catch (Throwable th) {
        }
    }

    public void pr(final String str) {
        this.pr.er().post(new Runnable() { // from class: com.byazt.ax.hw.7
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    hw.this.m.pr(str);
                }
            }
        });
    }

    public String ls() {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            return prVar.rc();
        }
        return "endcard";
    }

    public void uc(boolean z) {
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.c(z);
        }
    }

    public void hw(int i, int i2) {
        com.byazt.yr.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.hw(i, i2);
        }
    }

    public void pr(JSONObject jSONObject) {
        com.byazt.yr.pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(jSONObject);
        }
    }

    public void er() {
        this.cz = jn.hw(this.hw, this.pr.bm().er());
        this.qa.set(jn.cz(this.hw));
        com.byazt.hb.uc.hn = true;
    }

    public boolean v() {
        return e() && this.qa.get();
    }

    public int qi() {
        return this.cz;
    }

    public void pr(g gVar) {
        com.byazt.yr.hw hwVar = this.w;
        if (hwVar == null) {
            return;
        }
        hwVar.pr(gVar);
    }

    private void of() {
        try {
            if (ve.pr(this.hw) && !this.ny) {
                float[] fArrPr = com.byazt.hf.hw.pr(this.pr.getApplicationContext(), this.hw.oq(), this.hw.rf());
                float f = fArrPr[0];
                float f2 = fArrPr[1];
                if (this.hw.oq() == 100.0f) {
                    this.c = (int) f;
                    this.uc = (int) f2;
                    return;
                }
                int[] iArrPr = com.byazt.hf.hw.pr(this.pr.getApplicationContext(), this.hw.oq(), this.hw.ul(), this.hw.rf());
                int i = iArrPr[0];
                int i2 = iArrPr[1];
                int i3 = iArrPr[2];
                int i4 = iArrPr[3];
                float f3 = i;
                float f4 = i3;
                this.c = (int) ((f - f3) - f4);
                float f5 = i2;
                float f6 = i4;
                this.uc = (int) ((f2 - f5) - f6);
                this.pr.getWindow().getDecorView().setPadding(er.hn(this.pr, f3), er.hn(this.pr, f5), er.hn(this.pr, f4), er.hn(this.pr, f6));
            }
        } catch (Throwable th) {
        }
    }
}
