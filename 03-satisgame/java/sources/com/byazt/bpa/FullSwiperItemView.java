package com.byazt.bpa;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.kfh.TTProgressBar;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.vgx.q;
import com.byazt.vgx.w;
import com.byazt.xk.FullRewardExpressView;
import com.byazt.za.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 405, 2270})
public class FullSwiperItemView extends FrameLayout implements wo.n, d {
    public int a;
    public n cd;
    public FullRewardExpressView cp;
    public boolean cy;
    public Context d;
    public float fs;
    public final t hd;
    public boolean k;
    public FrameLayout l;
    public ViewGroup n;
    public com.byazt.qs.n oa;
    public qg py;
    public FrameLayout q;
    public FrameLayout qg;
    public float rv;
    public FrameLayout s;
    public int sz;
    public com.byazt.bpa.n tj;
    public boolean um;
    public FrameLayout w;
    public TTProgressBar x;

    public interface n {
        void n();
    }

    public interface qg {
        void n(View view, float f, float f2);
    }

    @Override // com.byazt.za.d
    public void fs() {
    }

    @Override // com.byazt.za.d
    public void l() {
    }

    @Override // com.byazt.za.d
    public void n(float f) {
    }

    @Override // com.byazt.za.d
    public void n(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.za.d
    public void n(int i) {
    }

    @Override // com.byazt.za.d
    public void n(int i, int i2) {
    }

    @Override // com.byazt.za.d
    public void n(int i, String str) {
    }

    @Override // com.byazt.za.d
    public void n(pk pkVar) {
    }

    @Override // com.byazt.za.d
    public void q() {
    }

    @Override // com.byazt.za.d
    public void q(int i) {
    }

    @Override // com.byazt.za.d
    public void qg(int i) {
    }

    @Override // com.byazt.za.d
    public void s(int i) {
    }

    @Override // com.byazt.za.d
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.za.d
    public void tj() {
    }

    public FullSwiperItemView(Context context, com.byazt.bpa.n nVar, float f, float f2) {
        super(context);
        this.hd = new t(Looper.getMainLooper(), this);
        this.tj = nVar;
        this.fs = f;
        this.rv = f2;
        this.d = context;
        setBackgroundColor(0);
        cp();
        this.a = w.cy(nVar.n());
        this.um = nVar.n().kj() == 1;
        d();
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.n.getContext(), this.tj.n(), q.n(8, String.valueOf(this.a), this.fs, this.rv, this.tj.n()), this.tj.qg(), this.um, null);
        this.cp = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().n(true);
    }

    public void cp() {
        View viewD = com.byazt.cb.qg.d(this.d);
        addView(viewD);
        this.n = (ViewGroup) viewD.findViewById(2114387892);
        this.qg = (FrameLayout) viewD.findViewById(2114387778);
        this.s = (FrameLayout) viewD.findViewById(2114387812);
        this.q = (FrameLayout) viewD.findViewById(2114387670);
        this.l = (FrameLayout) viewD.findViewById(2114387821);
        this.w = (FrameLayout) viewD.findViewById(2114387679);
        this.x = (TTProgressBar) viewD.findViewById(2114387767);
    }

    public void d() {
        pk pkVarN = this.tj.n();
        if (pkVarN == null) {
            return;
        }
        float fSl = pkVarN.sl();
        int iYs = pkVarN.ys();
        float fZb = pkVarN.zb();
        float[] fArrN = com.byazt.ce.qg.n(this.d.getApplicationContext(), pkVarN.sl(), pkVarN.ys());
        float f = fArrN[0];
        float f2 = fArrN[1];
        if (fSl == 100.0f) {
            this.fs = f;
            this.rv = f2;
            return;
        }
        int[] iArrN = com.byazt.ce.qg.n(this.d.getApplicationContext(), fSl, fZb, iYs);
        int i = iArrN[0];
        int i2 = iArrN[1];
        int i3 = iArrN[2];
        int i4 = iArrN[3];
        this.fs = (int) ((f - i) - i3);
        this.rv = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void oa() {
        if (this.tj == null) {
            return;
        }
        this.x.setVisibility(0);
        this.cp.setExpressInteractionListener(new com.byazt.za.n() { // from class: com.byazt.bpa.FullSwiperItemView.1
            @Override // com.byazt.za.n
            public void n(View view, float f, float f2) {
                if (FullSwiperItemView.this.py != null) {
                    FullSwiperItemView.this.py.n(view, f, f2);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, int i) {
                super.n(view, i);
            }
        });
        this.cp.setExpressVideoListenerProxy(this);
        this.cp.setInteractListener(this.cd);
        this.cp.setOnVideoSizeChangeListener(new FullRewardExpressView.n() { // from class: com.byazt.bpa.FullSwiperItemView.2
            @Override // com.byazt.xk.FullRewardExpressView.n
            public void n(int i) {
                FullSwiperItemView.this.sz = i;
            }
        });
        if (this.cp.getParent() != null) {
            ((ViewGroup) this.cp.getParent()).removeView(this.cp);
        }
        this.l.addView(this.cp);
        this.oa = new com.byazt.qs.n(this.n.getContext(), this.s, this.tj.n(), null);
        this.oa.n(new s(this.tj.l(), pe.s(this.tj.n()), new s.n() { // from class: com.byazt.bpa.FullSwiperItemView.3
            @Override // com.byazt.bpa.FullSwiperItemView.s.n
            public void n() {
                if (FullSwiperItemView.this.d instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.d).lq();
                }
            }

            @Override // com.byazt.bpa.FullSwiperItemView.s.n
            public void n(long j, long j2) {
                com.byazt.re.w wVarB;
                if (FullSwiperItemView.this.cp == null || !(FullSwiperItemView.this.d instanceof TTBaseVideoActivity) || (wVarB = ((TTBaseVideoActivity) FullSwiperItemView.this.d).b()) == null) {
                    return;
                }
                wVarB.qg(j);
                FullSwiperItemView.this.cp.n(String.valueOf(wVarB.ur()), (int) (wVarB.bb() / 1000), 0, j == j2 || wVarB.lh());
            }
        }, this.hd));
        this.oa.qg(this.um);
        this.cp.setVideoController(this.oa);
        this.tj.n(this.s, this.q, this.cp);
        this.cp.cy();
        this.cp.hd();
    }

    public void qg(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.cp;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.py()) {
            Context context = this.d;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).um();
            }
        } else {
            this.cp.n((ViewGroup) this.qg, false);
        }
        this.k = true;
        this.tj.s(z);
        sz();
        this.x.setVisibility(8);
    }

    public void sz() {
        if (this.oa != null && this.k) {
            this.tj.rv();
            this.cp.k();
            this.cy = true;
            if (pk.s(this.tj.n())) {
                this.hd.sendEmptyMessageDelayed(102, 5000L);
            }
            this.tj.n(this.cp);
            if (this.cp.py()) {
                return;
            }
            this.oa.n(this.tj.tj());
        }
    }

    public void k() {
        com.byazt.qs.n nVar = this.oa;
        if (nVar == null) {
            return;
        }
        nVar.w();
    }

    public void cy() {
        com.byazt.qs.n nVar = this.oa;
        if (nVar != null) {
            nVar.fs();
        }
    }

    public void hd() {
        t tVar = this.hd;
        if (tVar != null) {
            tVar.removeMessages(102);
        }
    }

    @Override // com.byazt.za.d
    public void n(boolean z) {
        if (this.um != z) {
            this.um = z;
            com.byazt.qs.n nVar = this.oa;
            if (nVar != null) {
                nVar.qg(z);
            }
            Context context = this.d;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).nf().n().qg();
            }
            n nVar2 = this.cd;
            if (nVar2 != null) {
                nVar2.n();
            }
        }
    }

    @Override // com.byazt.za.d
    public void w() {
        com.byazt.eji.s.n().q(this.tj.n(), "stats_reward_full_click_express_close");
        Context context = this.d;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).nf().n().n();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            pk pkVarN = this.tj.n();
            if (pkVarN != null && pkVarN.nq() != null) {
                jSONObject.put("refresh_num", this.tj.n().nq().s());
            }
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n(this.tj.n(), "stats_reward_full_click_native_close", jSONObject);
        n nVar = this.cd;
        if (nVar != null) {
            nVar.n();
        }
    }

    @Override // com.byazt.za.d
    public void x() {
        n nVar = this.cd;
        if (nVar != null) {
            nVar.n();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            pk pkVarN = this.tj.n();
            if (pkVarN != null && pkVarN.nq() != null) {
                jSONObject.put("refresh_num", this.tj.n().nq().s());
            }
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n(this.tj.n(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.d;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.byazt.za.d
    public long n() {
        return this.oa.cp();
    }

    @Override // com.byazt.za.d
    public int qg() {
        com.byazt.qs.n nVar = this.oa;
        if (nVar == null || !this.cy) {
            return 2;
        }
        if (nVar.b()) {
            return 5;
        }
        if (this.oa.ou()) {
            return 1;
        }
        if (this.oa.ri()) {
            return 2;
        }
        this.oa.hu();
        return 3;
    }

    @Override // com.byazt.za.d
    public int s() {
        com.byazt.qs.n nVar = this.oa;
        if (nVar == null) {
            return 0;
        }
        return (int) (nVar.cp() / 1000);
    }

    @Override // com.byazt.za.d
    public void rv() {
        com.byazt.has.n nVarNf;
        n nVar = this.cd;
        if (nVar != null) {
            nVar.n();
        }
        Context context = this.d;
        if (!(context instanceof TTBaseVideoActivity) || (nVarNf = ((TTBaseVideoActivity) context).nf()) == null || nVarNf.n() == null) {
            return;
        }
        nVarNf.n().s();
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 102) {
            return;
        }
        com.byazt.bpa.n nVar = this.tj;
        if (nVar != null) {
            nVar.x();
        }
        Context context = this.d;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).d();
        }
        n nVar2 = this.cd;
        if (nVar2 != null) {
            nVar2.n();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 405, 2271})
    private static class s implements com.byazt.zx.n.InterfaceC0421n {
        public final t l;
        public final com.byazt.zx.n.InterfaceC0421n n;
        public final int q;
        public final n qg;
        public boolean s = false;

        interface n {
            void n();

            void n(long j, long j2);
        }

        public s(com.byazt.zx.n.InterfaceC0421n interfaceC0421n, int i, n nVar, t tVar) {
            this.n = interfaceC0421n;
            this.qg = nVar;
            this.q = i;
            this.l = tVar;
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n() {
            this.s = false;
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n();
            }
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n();
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n(int i, String str) {
            this.s = false;
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n(i, str);
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void qg() {
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.qg();
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void n(long j, long j2) {
            this.l.removeMessages(102);
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.n(j, j2);
            }
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n(j, j2);
            }
        }

        @Override // com.byazt.zx.n.InterfaceC0421n
        public void s() {
            com.byazt.zx.n.InterfaceC0421n interfaceC0421n = this.n;
            if (interfaceC0421n != null) {
                interfaceC0421n.s();
            }
        }
    }

    public void setOnSwiperItemInteractListener(n nVar) {
        this.cd = nVar;
    }

    public void setOnSwiperItemRenderResultListener(qg qgVar) {
        this.py = qgVar;
    }

    public void cd() {
        FullRewardExpressView fullRewardExpressView = this.cp;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.oa();
        }
        com.byazt.qs.n nVar = this.oa;
        if (nVar != null) {
            nVar.rv();
        }
    }
}
