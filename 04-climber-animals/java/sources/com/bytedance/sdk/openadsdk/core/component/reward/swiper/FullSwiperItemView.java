package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.component.reward.xr.c;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.res.ka;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FullSwiperItemView extends FrameLayout implements le.ms, hi {
    public TTProgressBar ab;
    public FrameLayout ah;
    private boolean ao;
    public FrameLayout c;
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms ch;
    public FrameLayout d;
    private final le h;
    private FullRewardExpressView hi;
    public FrameLayout ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public ViewGroup f2232ms;
    private xr nw;
    private float ny;
    private ms qv;
    private Context sl;
    private int t;
    private int u;
    private boolean ub;
    private float x;
    public FrameLayout xr;
    private boolean y;
    private com.bytedance.sdk.openadsdk.core.component.reward.c.ms zb;

    public interface ms {
        void ms();
    }

    public interface xr {
        void ms(View view, float f, float f2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ka() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void xr(int i) {
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms msVar, float f, float f2) {
        super(context);
        this.h = new le(Looper.getMainLooper(), this);
        this.ch = msVar;
        this.x = f;
        this.ny = f2;
        this.sl = context;
        setBackgroundColor(0);
        sl();
        this.t = f.ny(msVar.ms());
        this.y = re.xr().ms(msVar.ms(), this.t);
        zb();
        this.hi = new FullRewardExpressView(this.f2232ms.getContext(), this.ch.ms(), op.ms(8, String.valueOf(this.t), this.x, this.ny), this.ch.xr(), this.y);
    }

    public void sl() {
        View viewHi = ka.hi(this.sl);
        addView(viewHi);
        this.f2232ms = (ViewGroup) viewHi.findViewById(2114387898);
        this.xr = (FrameLayout) viewHi.findViewById(2114387784);
        this.ah = (FrameLayout) viewHi.findViewById(2114387818);
        this.d = (FrameLayout) viewHi.findViewById(2114387676);
        this.ka = (FrameLayout) viewHi.findViewById(2114387827);
        this.c = (FrameLayout) viewHi.findViewById(2114387685);
        this.ab = (TTProgressBar) viewHi.findViewById(2114387773);
    }

    public void zb() {
        lm lmVarMs = this.ch.ms();
        if (lmVarMs == null) {
            return;
        }
        float fLd = lmVarMs.ld();
        int iOd = lmVarMs.od();
        float fMp = lmVarMs.mp();
        float[] fArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.sl.getApplicationContext(), lmVarMs.ld(), lmVarMs.od());
        float f = fArrMs[0];
        float f2 = fArrMs[1];
        if (fLd == 100.0f) {
            this.x = f;
            this.ny = f2;
            return;
        }
        int[] iArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.sl.getApplicationContext(), fLd, fMp, iOd);
        int i = iArrMs[0];
        int i2 = iArrMs[1];
        int i3 = iArrMs[2];
        int i4 = iArrMs[3];
        this.x = (int) ((f - i) - i3);
        this.ny = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void u() {
        if (this.ch == null) {
            return;
        }
        this.ab.setVisibility(0);
        this.hi.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, float f, float f2) {
                if (FullSwiperItemView.this.nw != null) {
                    FullSwiperItemView.this.nw.ms(view, f, f2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, int i) {
                super.ms(view, i);
            }
        });
        this.hi.setExpressVideoListenerProxy(this);
        this.hi.setInteractListener(this.qv);
        this.hi.setOnVideoSizeChangeListener(new FullRewardExpressView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.ms
            public void ms(int i) {
                FullSwiperItemView.this.u = i;
            }
        });
        if (this.hi.getParent() != null) {
            ((ViewGroup) this.hi.getParent()).removeView(this.hi);
        }
        this.ka.addView(this.hi);
        this.zb = new com.bytedance.sdk.openadsdk.core.component.reward.c.ms(this.f2232ms.getContext(), this.ah, this.ch.ms(), null);
        this.zb.ms(new ah(this.ch.ka(), fm.ah(this.ch.ms()), new ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.ah.ms
            public void ms() {
                if (FullSwiperItemView.this.sl instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.sl).vm();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.ah.ms
            public void ms(long j, long j2) {
                c cVarL;
                if (FullSwiperItemView.this.hi == null || !(FullSwiperItemView.this.sl instanceof TTBaseVideoActivity) || (cVarL = ((TTBaseVideoActivity) FullSwiperItemView.this.sl).l()) == null) {
                    return;
                }
                cVarL.xr(j);
                FullSwiperItemView.this.hi.ms(String.valueOf(cVarL.cv()), (int) (cVarL.g() / 1000), 0, j == j2 || cVarL.pc());
            }
        }, this.h));
        this.zb.xr(this.y);
        this.hi.setVideoController(this.zb);
        this.ch.ms(this.ah, this.d, this.hi);
        this.hi.h();
        this.hi.qv();
    }

    public void xr(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.hi;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.nw()) {
            Context context = this.sl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).t();
            }
        } else {
            this.hi.ms((ViewGroup) this.xr, false);
        }
        this.ub = true;
        this.ch.ah(z);
        ub();
        this.ab.setVisibility(8);
    }

    public void ub() {
        if (this.zb != null && this.ub) {
            this.ch.ch();
            this.hi.ao();
            this.ao = true;
            if (lm.xr(this.ch.ms())) {
                this.h.sendEmptyMessageDelayed(102, 5000L);
            }
            this.ch.ms(this.hi);
            if (this.hi.nw()) {
                return;
            }
            this.zb.ms(this.ch.hi());
        }
    }

    public void ao() {
        com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
        if (msVar == null) {
            return;
        }
        msVar.c();
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
        if (msVar != null) {
            msVar.x();
        }
    }

    public void qv() {
        le leVar = this.h;
        if (leVar != null) {
            leVar.removeMessages(102);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
        if (this.y != z) {
            this.y = z;
            com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
            if (msVar != null) {
                msVar.xr(z);
            }
            Context context = this.sl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).sa().ms().xr();
            }
            ms msVar2 = this.qv;
            if (msVar2 != null) {
                msVar2.ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
        u.ms().ah(this.ch.ms(), "stats_reward_full_click_express_close");
        Context context = this.sl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).sa().ms().ms();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            lm lmVarMs = this.ch.ms();
            if (lmVarMs != null && lmVarMs.fi() != null) {
                jSONObject.put("refresh_num", this.ch.ms().fi().ah());
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        u.ms().ms(this.ch.ms(), "stats_reward_full_click_native_close", jSONObject);
        ms msVar = this.qv;
        if (msVar != null) {
            msVar.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
        ms msVar = this.qv;
        if (msVar != null) {
            msVar.ms();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            lm lmVarMs = this.ch.ms();
            if (lmVarMs != null && lmVarMs.fi() != null) {
                jSONObject.put("refresh_num", this.ch.ms().fi().ah());
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        u.ms().ms(this.ch.ms(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.sl;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        return this.zb.hi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
        if (msVar == null || !this.ao) {
            return 2;
        }
        if (msVar.am()) {
            return 5;
        }
        if (this.zb.b()) {
            return 1;
        }
        if (this.zb.sa()) {
            return 2;
        }
        this.zb.i();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int ah() {
        com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
        if (msVar == null) {
            return 0;
        }
        return (int) (msVar.hi() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVarSa;
        ms msVar = this.qv;
        if (msVar != null) {
            msVar.ms();
        }
        Context context = this.sl;
        if (!(context instanceof TTBaseVideoActivity) || (msVarSa = ((TTBaseVideoActivity) context).sa()) == null || msVarSa.ms() == null) {
            return;
        }
        msVarSa.ms().ah();
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms msVar = this.ch;
        if (msVar != null) {
            msVar.x();
        }
        Context context = this.sl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).sl();
        }
        ms msVar2 = this.qv;
        if (msVar2 != null) {
            msVar2.ms();
        }
    }

    private static class ah implements com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms {
        private boolean ah = false;
        private final int d;
        private final le ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms f2236ms;
        private final ms xr;

        interface ms {
            void ms();

            void ms(long j, long j2);
        }

        ah(com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms, int i, ms msVar, le leVar) {
            this.f2236ms = interfaceC0325ms;
            this.xr = msVar;
            this.d = i;
            this.ka = leVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms() {
            this.ah = false;
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2236ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms();
            }
            ms msVar = this.xr;
            if (msVar != null) {
                msVar.ms();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms(int i, String str) {
            this.ah = false;
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2236ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void xr() {
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2236ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.xr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ms(long j, long j2) {
            this.ka.removeMessages(102);
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2236ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ms(j, j2);
            }
            ms msVar = this.xr;
            if (msVar != null) {
                msVar.ms(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
        public void ah() {
            com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms interfaceC0325ms = this.f2236ms;
            if (interfaceC0325ms != null) {
                interfaceC0325ms.ah();
            }
        }
    }

    public void setOnSwiperItemInteractListener(ms msVar) {
        this.qv = msVar;
    }

    public void setOnSwiperItemRenderResultListener(xr xrVar) {
        this.nw = xrVar;
    }

    public void y() {
        FullRewardExpressView fullRewardExpressView = this.hi;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.zb();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.c.ms msVar = this.zb;
        if (msVar != null) {
            msVar.ny();
        }
    }
}
