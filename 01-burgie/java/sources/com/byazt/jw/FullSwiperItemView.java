package com.byazt.jw;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.ax.uc;
import com.byazt.ca.iu;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.pg.FullRewardExpressView;
import com.byazt.qx.w;
import com.byazt.sdv.c;
import com.byazt.vkw.qi;
import com.byazt.wt.ls;
import com.byazt.wt.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 2045})
public class FullSwiperItemView extends FrameLayout implements qi.pr, w {
    public int a;
    public float aj;
    public FrameLayout c;
    public hw cz;
    public TTProgressBar fw;
    public int g;
    public FrameLayout hn;
    public boolean ho;
    public FrameLayout hw;
    public Context k;
    public pr lb;
    public com.byazt.ji.pr m;
    public boolean nt;
    public ViewGroup pr;
    public boolean qa;
    public FrameLayout uc;
    public com.byazt.jw.pr vk;
    public FullRewardExpressView w;
    public FrameLayout x;
    public final iu yb;
    public float zo;

    public interface hw {
        void pr(View view, float f, float f2);
    }

    public interface pr {
        void pr();
    }

    public FullSwiperItemView(Context context, com.byazt.jw.pr prVar, float f, float f2) {
        super(context);
        this.yb = new iu(Looper.getMainLooper(), this);
        this.vk = prVar;
        this.zo = f;
        this.aj = f2;
        this.k = context;
        setBackgroundColor(0);
        w();
        this.a = ls.m(prVar.pr());
        this.qa = prVar.pr().ax() == 1;
        k();
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.pr.getContext(), this.vk.pr(), ve.pr(8, String.valueOf(this.a), this.zo, this.aj, this.vk.pr()), this.vk.hw(), this.qa, null);
        this.w = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().pr(true);
    }

    public void w() {
        View viewK = c.k(this.k);
        addView(viewK);
        this.pr = (ViewGroup) viewK.findViewById(2114387892);
        this.hw = (FrameLayout) viewK.findViewById(2114387778);
        this.hn = (FrameLayout) viewK.findViewById(2114387812);
        this.x = (FrameLayout) viewK.findViewById(2114387670);
        this.c = (FrameLayout) viewK.findViewById(2114387821);
        this.uc = (FrameLayout) viewK.findViewById(2114387679);
        this.fw = (TTProgressBar) viewK.findViewById(2114387767);
    }

    public void k() {
        of ofVarPr = this.vk.pr();
        if (ofVarPr == null) {
            return;
        }
        float fOq = ofVarPr.oq();
        int iRf = ofVarPr.rf();
        float fUl = ofVarPr.ul();
        float[] fArrPr = com.byazt.hf.hw.pr(this.k.getApplicationContext(), ofVarPr.oq(), ofVarPr.rf());
        float f = fArrPr[0];
        float f2 = fArrPr[1];
        if (fOq == 100.0f) {
            this.zo = f;
            this.aj = f2;
            return;
        }
        int[] iArrPr = com.byazt.hf.hw.pr(this.k.getApplicationContext(), fOq, fUl, iRf);
        int i = iArrPr[0];
        int i2 = iArrPr[1];
        int i3 = iArrPr[2];
        int i4 = iArrPr[3];
        this.zo = (int) ((f - i) - i3);
        this.aj = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void m() {
        if (this.vk == null) {
            return;
        }
        this.fw.setVisibility(0);
        this.w.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.jw.FullSwiperItemView.1
            @Override // com.byazt.qx.pr
            public void pr(View view, float f, float f2) {
                if (FullSwiperItemView.this.cz != null) {
                    FullSwiperItemView.this.cz.pr(view, f, f2);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
                super.pr(view, i);
            }
        });
        this.w.setExpressVideoListenerProxy(this);
        this.w.setInteractListener(this.lb);
        this.w.setOnVideoSizeChangeListener(new FullRewardExpressView.pr() { // from class: com.byazt.jw.FullSwiperItemView.2
            @Override // com.byazt.pg.FullRewardExpressView.pr
            public void pr(int i) {
                FullSwiperItemView.this.g = i;
            }
        });
        if (this.w.getParent() != null) {
            ((ViewGroup) this.w.getParent()).removeView(this.w);
        }
        this.c.addView(this.w);
        this.m = new com.byazt.ji.pr(this.pr.getContext(), this.hn, this.vk.pr(), null);
        this.m.pr(new hn(this.vk.c(), o.hn(this.vk.pr()), new hn.pr() { // from class: com.byazt.jw.FullSwiperItemView.3
            @Override // com.byazt.jw.FullSwiperItemView.hn.pr
            public void pr() {
                if (FullSwiperItemView.this.k instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.k).vj();
                }
            }

            @Override // com.byazt.jw.FullSwiperItemView.hn.pr
            public void pr(long j, long j2) {
                uc ucVarO;
                if (FullSwiperItemView.this.w != null && (FullSwiperItemView.this.k instanceof TTBaseVideoActivity) && (ucVarO = ((TTBaseVideoActivity) FullSwiperItemView.this.k).o()) != null) {
                    ucVarO.hw(j);
                    FullSwiperItemView.this.w.pr(String.valueOf(ucVarO.ve()), (int) (ucVarO.gz() / 1000), 0, j == j2 || ucVarO.y());
                }
            }
        }, this.yb));
        this.m.hw(this.qa);
        this.w.setVideoController(this.m);
        this.vk.pr(this.hn, this.x, this.w);
        this.w.nt();
        this.w.yb();
    }

    public void hw(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.w;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.cz()) {
            Context context = this.k;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).qa();
            }
        } else {
            this.w.pr((ViewGroup) this.hw, false);
        }
        this.ho = true;
        this.vk.hn(z);
        g();
        this.fw.setVisibility(8);
    }

    public void g() {
        if (this.m != null && this.ho) {
            this.vk.aj();
            this.w.ho();
            this.nt = true;
            if (of.hn(this.vk.pr())) {
                this.yb.sendEmptyMessageDelayed(102, 5000L);
            }
            this.vk.pr(this.w);
            if (!this.w.cz()) {
                this.m.pr(this.vk.vk());
            }
        }
    }

    public void ho() {
        com.byazt.ji.pr prVar = this.m;
        if (prVar == null) {
            return;
        }
        prVar.uc();
    }

    public void nt() {
        com.byazt.ji.pr prVar = this.m;
        if (prVar != null) {
            prVar.zo();
        }
    }

    public void yb() {
        iu iuVar = this.yb;
        if (iuVar != null) {
            iuVar.removeMessages(102);
        }
    }

    @Override // com.byazt.qx.w
    public void pr(boolean z) {
        if (this.qa != z) {
            this.qa = z;
            com.byazt.ji.pr prVar = this.m;
            if (prVar != null) {
                prVar.hw(z);
            }
            Context context = this.k;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).bm().pr().hw();
            }
            pr prVar2 = this.lb;
            if (prVar2 != null) {
                prVar2.pr();
            }
        }
    }

    @Override // com.byazt.qx.w
    public void uc() {
        com.byazt.xk.hw.pr().x(this.vk.pr(), "stats_reward_full_click_express_close");
        Context context = this.k;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).bm().pr().pr();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            of ofVarPr = this.vk.pr();
            if (ofVarPr != null && ofVarPr.sb() != null) {
                jSONObject.put("refresh_num", this.vk.pr().sb().hn());
            }
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr(this.vk.pr(), "stats_reward_full_click_native_close", jSONObject);
        pr prVar = this.lb;
        if (prVar != null) {
            prVar.pr();
        }
    }

    @Override // com.byazt.qx.w
    public void fw() {
        pr prVar = this.lb;
        if (prVar != null) {
            prVar.pr();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            of ofVarPr = this.vk.pr();
            if (ofVarPr != null && ofVarPr.sb() != null) {
                jSONObject.put("refresh_num", this.vk.pr().sb().hn());
            }
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr(this.vk.pr(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.k;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.byazt.qx.w
    public void pr(int i) {
    }

    @Override // com.byazt.qx.w
    public long pr() {
        return this.m.w();
    }

    @Override // com.byazt.qx.w
    public int hw() {
        com.byazt.ji.pr prVar = this.m;
        if (prVar == null || !this.nt) {
            return 2;
        }
        if (prVar.i()) {
            return 5;
        }
        if (this.m.ny()) {
            return 1;
        }
        if (this.m.r()) {
            return 2;
        }
        this.m.rc();
        return 3;
    }

    @Override // com.byazt.qx.w
    public int hn() {
        com.byazt.ji.pr prVar = this.m;
        if (prVar == null) {
            return 0;
        }
        return (int) (prVar.w() / 1000);
    }

    @Override // com.byazt.qx.w
    public void aj() {
        com.byazt.lu.pr prVarBm;
        pr prVar = this.lb;
        if (prVar != null) {
            prVar.pr();
        }
        Context context = this.k;
        if ((context instanceof TTBaseVideoActivity) && (prVarBm = ((TTBaseVideoActivity) context).bm()) != null && prVarBm.pr() != null) {
            prVarBm.pr().hn();
        }
    }

    @Override // com.byazt.qx.w
    public void zo() {
    }

    @Override // com.byazt.qx.w
    public void vk() {
    }

    @Override // com.byazt.qx.w
    public void x(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.qx.w
    public void x() {
    }

    @Override // com.byazt.qx.w
    public void hw(int i) {
    }

    @Override // com.byazt.qx.w
    public void c() {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, String str) {
    }

    @Override // com.byazt.qx.w
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.qx.w
    public void pr(float f) {
    }

    @Override // com.byazt.qx.w
    public void pr(int i, int i2) {
    }

    @Override // com.byazt.qx.w
    public void hn(int i) {
    }

    @Override // com.byazt.qx.w
    public void pr(of ofVar) {
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 102:
                com.byazt.jw.pr prVar = this.vk;
                if (prVar != null) {
                    prVar.fw();
                }
                Context context = this.k;
                if (context instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) context).k();
                }
                pr prVar2 = this.lb;
                if (prVar2 != null) {
                    prVar2.pr();
                }
                break;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 972})
    private static class hn implements com.byazt.ga.pr.InterfaceC0074pr {
        public final iu c;
        public boolean hn = false;
        public final pr hw;
        public final com.byazt.ga.pr.InterfaceC0074pr pr;
        public final int x;

        interface pr {
            void pr();

            void pr(long j, long j2);
        }

        public hn(com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr, int i, pr prVar, iu iuVar) {
            this.pr = interfaceC0074pr;
            this.hw = prVar;
            this.x = i;
            this.c = iuVar;
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr() {
            this.hn = false;
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr();
            }
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.pr();
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr(int i, String str) {
            this.hn = false;
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr(i, str);
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void hw() {
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.hw();
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void pr(long j, long j2) {
            this.c.removeMessages(102);
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.pr(j, j2);
            }
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.pr(j, j2);
            }
        }

        @Override // com.byazt.ga.pr.InterfaceC0074pr
        public void hn() {
            com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr = this.pr;
            if (interfaceC0074pr != null) {
                interfaceC0074pr.hn();
            }
        }
    }

    public void setOnSwiperItemInteractListener(pr prVar) {
        this.lb = prVar;
    }

    public void setOnSwiperItemRenderResultListener(hw hwVar) {
        this.cz = hwVar;
    }

    public void lb() {
        FullRewardExpressView fullRewardExpressView = this.w;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        com.byazt.ji.pr prVar = this.m;
        if (prVar != null) {
            prVar.aj();
        }
    }
}
