package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.anythink.basead.exoplayer.i.a;
import com.anythink.basead.webtemplet.a.b;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.d.ny;
import com.bytedance.sdk.openadsdk.core.component.reward.d.x;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.ka;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.component.reward.xr.ah;
import com.bytedance.sdk.openadsdk.core.component.reward.xr.c;
import com.bytedance.sdk.openadsdk.core.component.reward.xr.d;
import com.bytedance.sdk.openadsdk.core.component.reward.xr.ms;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yu;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.of;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import com.bytedance.sdk.openadsdk.core.x.xr;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements le.ms, xr {
    protected final ConcurrentHashMap<Integer, Boolean> ab;
    protected final AtomicBoolean ah;
    protected int am;
    protected final AtomicBoolean ao;
    d az;
    protected final AtomicBoolean b;
    private com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms bz;
    protected final ConcurrentHashMap<Integer, Boolean> c;
    private int ce;
    protected final AtomicBoolean ch;
    RewardFullBaseLayout cv;
    protected final AtomicBoolean d;
    protected TTBaseVideoActivity e;
    protected String eg;
    ms f;
    protected String fm;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.xr g;
    private float gy;
    protected final AtomicBoolean h;
    protected final AtomicBoolean hi;
    protected boolean i;
    private com.bytedance.sdk.openadsdk.core.component.reward.ka.d ih;
    protected int il;
    private long j;
    private Double jm;
    com.bytedance.sdk.openadsdk.core.component.reward.xr.xr jw;
    private long jy;
    protected int k;
    protected int l;
    protected int le;
    protected com.bytedance.sdk.openadsdk.core.component.reward.d.ms lm;
    protected ah m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final String f2061ms;
    protected final AtomicBoolean nw;
    protected final AtomicBoolean ny;
    ka of;
    private com.bytedance.sdk.openadsdk.op.ms oh;
    protected boolean op;
    AbstractEndCardFrameLayout p;
    com.bytedance.sdk.openadsdk.core.component.reward.xr.ka pc;
    protected com.bytedance.sdk.openadsdk.core.xr.ka qf;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms qk;
    private int qr;
    protected final AtomicBoolean qv;
    protected boolean re;
    private com.bytedance.sdk.openadsdk.core.xr.xr rt;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms s;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d sa;
    private ms.InterfaceC0278ms sk;
    protected final AtomicBoolean sl;
    protected final AtomicBoolean t;
    protected com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms ti;
    protected com.bytedance.sdk.openadsdk.core.playable.xr.xr tz;
    protected final AtomicBoolean u;
    protected final AtomicBoolean ub;
    c ul;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms v;
    private int vl;
    private final AtomicBoolean vm;
    private ms.xr vy;
    protected boolean w;
    public final AtomicBoolean x;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.ms xn;
    protected final le xr;
    protected final AtomicBoolean y;
    protected long yu;
    private AtomicBoolean z;
    protected final AtomicBoolean zb;
    private final com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms zd;
    private boolean zf;

    public void ah(int i) {
    }

    protected abstract void ah(boolean z);

    public boolean cv() {
        return false;
    }

    public void d(int i) {
    }

    protected abstract void d(String str);

    public int g() {
        return 0;
    }

    protected abstract void le();

    public String of() {
        return "";
    }

    public abstract boolean op();

    public String p() {
        return "";
    }

    public String pc() {
        return "";
    }

    public void x(int i) {
    }

    public void xn() {
    }

    public TTBaseVideoActivity() {
        this.f2061ms = op() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.xr = new le(Looper.getMainLooper(), this);
        this.ah = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.c = new ConcurrentHashMap<>();
        this.ab = new ConcurrentHashMap<>();
        this.x = new AtomicBoolean(false);
        this.ny = new AtomicBoolean(false);
        this.ch = new AtomicBoolean(false);
        this.vm = new AtomicBoolean(false);
        this.hi = new AtomicBoolean(false);
        this.sl = new AtomicBoolean(false);
        this.zb = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.ub = new AtomicBoolean(false);
        this.ao = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.qv = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.nw = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.le = -1;
        this.vl = 1;
        this.jm = null;
        this.jy = 0L;
        this.l = 0;
        this.am = 0;
        this.ti = new com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms() {
                TTBaseVideoActivity.this.xr.removeMessages(300);
                TTBaseVideoActivity.this.h();
                if (!TTBaseVideoActivity.this.ul.sl()) {
                    if (TTBaseVideoActivity.this.jm()) {
                        TTBaseVideoActivity.this.ul.xr(TTBaseVideoActivity.this.ul.of());
                    } else {
                        TTBaseVideoActivity.this.ul.xr(TTBaseVideoActivity.this.ul.g() + 1000);
                    }
                }
                if (TTBaseVideoActivity.this.lm.c() && !TTBaseVideoActivity.this.ul.sl()) {
                    TTBaseVideoActivity.this.of.xr(true);
                }
                TTBaseVideoActivity.this.vm();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms(int i, String str) {
                if (TTBaseVideoActivity.this.i) {
                    TTBaseVideoActivity.this.xr.removeMessages(300);
                    TTBaseVideoActivity.this.u();
                    TTBaseVideoActivity.this.ul.ms(5);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.xr(tTBaseVideoActivity.ul.xr());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void xr() {
                TTBaseVideoActivity.this.xr.removeMessages(300);
                TTBaseVideoActivity.this.h();
                TTBaseVideoActivity.this.ms(false, false);
                TTBaseVideoActivity.this.ul.ms(6);
                TTBaseVideoActivity.this.ul.ny();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms(long j, long j2) {
                if (!TTBaseVideoActivity.this.i && TTBaseVideoActivity.this.ul.xr()) {
                    TTBaseVideoActivity.this.ul.ms((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.jw.pc()) {
                    TTBaseVideoActivity.this.ul.ah(true);
                    return;
                }
                TTBaseVideoActivity.this.xr.removeMessages(300);
                if (j != TTBaseVideoActivity.this.ul.g()) {
                    TTBaseVideoActivity.this.h();
                }
                if (TTBaseVideoActivity.this.ul.xr() || j2 == j) {
                    TTBaseVideoActivity.this.ul.xr(j);
                    if (TTBaseVideoActivity.this.tk()) {
                        ka kaVar = TTBaseVideoActivity.this.of;
                        String strValueOf = String.valueOf(TTBaseVideoActivity.this.ul.cv());
                        int iG = (int) (TTBaseVideoActivity.this.ul.g() / 1000);
                        if (j != j2 && !TTBaseVideoActivity.this.ul.pc()) {
                            z = false;
                        }
                        kaVar.ms(strValueOf, iG, 0, z);
                    }
                    TTBaseVideoActivity.this.ah(0);
                    TTBaseVideoActivity.this.xn();
                    TTBaseVideoActivity.this.lm.t();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ah() {
                if (TTBaseVideoActivity.this.sa == null || TTBaseVideoActivity.this.sa.ms() == null) {
                    return;
                }
                TTBaseVideoActivity.this.sa.ms().ms();
            }
        };
        this.s = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i) {
                TTBaseVideoActivity.this.lm.fm().ms(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long ms() {
                return TTBaseVideoActivity.this.lm.fm().ms();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int xr() {
                return TTBaseVideoActivity.this.lm.fm().xr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int ah() {
                return TTBaseVideoActivity.this.lm.fm().ah();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long getActualPlayDuration() {
                return TTBaseVideoActivity.this.lm.fm().getActualPlayDuration();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void d() {
                TTBaseVideoActivity.this.lm.fm().d();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void xr(int i) {
                TTBaseVideoActivity.this.lm.fm().xr(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ka() {
                TTBaseVideoActivity.this.lm.fm().ka();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i, String str) {
                TTBaseVideoActivity.this.lm.fm().ms(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.lm.fm().setPauseFromExpressView(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(float f) {
                TTBaseVideoActivity.this.lm.fm().ms(f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void c() {
                TTBaseVideoActivity.this.lm.fm().c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view) {
                TTBaseVideoActivity.this.ms(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                hi hiVar;
                if (TTBaseVideoActivity.this.qf != null) {
                    if (ahVar instanceof i) {
                        i iVar = (i) ahVar;
                        hiVar = new hi();
                        hiVar.ms(iVar.f3057ms);
                        hiVar.xr(iVar.xr);
                        hiVar.ah(iVar.ah);
                        hiVar.d(iVar.d);
                        hiVar.ms(iVar.ka);
                        hiVar.xr(iVar.c);
                        hiVar.ms(iVar.ub);
                    } else {
                        hiVar = null;
                    }
                    TTBaseVideoActivity.this.qf.ms(view, hiVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void xr(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                hi hiVar;
                if ((i == 1 || i == 2) && (ahVar instanceof i)) {
                    i iVar = (i) ahVar;
                    hiVar = new hi();
                    hiVar.ms(iVar.f3057ms);
                    hiVar.xr(iVar.xr);
                    hiVar.ah(iVar.ah);
                    hiVar.d(iVar.d);
                    hiVar.ms(iVar.ka);
                    hiVar.xr(iVar.c);
                    hiVar.ms(iVar.ub);
                } else {
                    hiVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.qf.ms(view, hiVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.qf.ms(view, hiVar);
                }
            }
        };
        this.zd = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
            public boolean m_() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
            public com.bytedance.sdk.openadsdk.core.multipro.xr.ms r_() {
                com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
                if (TTBaseVideoActivity.this.ul != null) {
                    msVar.ab = TTBaseVideoActivity.this.ul.ao();
                    msVar.f2932ms = TTBaseVideoActivity.this.ul.ms();
                    msVar.x = TTBaseVideoActivity.this.re;
                }
                return msVar;
            }
        };
        this.v = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xr(new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.e;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public RewardFullBaseLayout ms() {
                return TTBaseVideoActivity.this.cv;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public boolean xr() {
                return TTBaseVideoActivity.this.op();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public lm ah() {
                return TTBaseVideoActivity.this.ka;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public boolean d() {
                return TTBaseVideoActivity.this.zf;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public int ka() {
                return TTBaseVideoActivity.this.l;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public int c() {
                return TTBaseVideoActivity.this.am;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public int ab() {
                return TTBaseVideoActivity.this.lm.c(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public boolean x() {
                return TTBaseVideoActivity.this.nw.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public boolean ny() {
                return TTBaseVideoActivity.this.tz();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public boolean ch() {
                return TTBaseVideoActivity.this.lm.qf();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public void ms(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.zb(2);
                }
                TTBaseVideoActivity.this.v.xr(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ms.InterfaceC0269ms
            public void xr(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.u(2);
                }
            }
        });
        this.qk = new com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr(new com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public Activity getActivity() {
                return TTBaseVideoActivity.this.e;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public lm ms() {
                return TTBaseVideoActivity.this.ka;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public String xr() {
                return TTBaseVideoActivity.this.eg;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public void ah() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public void ms(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.cv.ms(i, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public void ms(boolean z, String str, String str2) {
                if (nw.ah(TTBaseVideoActivity.this.ka)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z);
                    jSONObject.put("entrance_text", k.ms(TTBaseVideoActivity.this.ka, str, str2));
                } catch (JSONException e) {
                    sl.ms(e);
                }
                TTBaseVideoActivity.this.of.ms("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.jw.ms(jSONObject);
                if (TTBaseVideoActivity.this.jw.pc()) {
                    return;
                }
                TTBaseVideoActivity.this.pc.ab(z);
                TTBaseVideoActivity.this.pc.ms(k.ms(TTBaseVideoActivity.this.ka, str, str2));
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public void d() {
                TTBaseVideoActivity.this.e();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.InterfaceC0272ms
            public void ka() {
                if (TTBaseVideoActivity.this.ul != null) {
                    TTBaseVideoActivity.this.ul.ab();
                }
            }
        });
        this.z = new AtomicBoolean(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = this;
        rt();
        ms(getIntent());
        xr(bundle);
        xr(getIntent());
        if (ms(bundle)) {
            gy();
            vy();
            qr();
            x();
            this.lm.ms(this.qr, this.ce);
            setContentView(this.cv);
            ah();
            this.lm.xr();
            ka kaVar = this.of;
            if (kaVar != null) {
                kaVar.ms(this.zd);
            }
            if (zf()) {
                this.ih = new com.bytedance.sdk.openadsdk.core.component.reward.ka.d();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                saasAuthRewardDialog.ms(this.ka, this.f2061ms, op() ? 7 : 5);
            }
            if (of.xr(op(), this.ka, true)) {
                jw().getSceneFrameContainer().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.jw().getSceneFrameContainer().getHeight(), 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        TTBaseVideoActivity.this.jw().getSceneFrameContainer().startAnimation(translateAnimation);
                    }
                });
            }
        }
    }

    private boolean zf() {
        if (this.ka != null && com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(this.ka)) {
            String strLi = this.ka.li();
            if (TextUtils.isEmpty(strLi)) {
                return false;
            }
            try {
                return new JSONObject(strLi).optInt("saas_play_time_type") == 1;
            } catch (JSONException e) {
                sl.xr("TTBaseVideoActivity", e);
            }
        }
        return false;
    }

    private void rt() {
        this.cv = new RewardFullBaseLayout(this.e);
        this.pc = new com.bytedance.sdk.openadsdk.core.component.reward.xr.ka(this.e);
        this.jw = new com.bytedance.sdk.openadsdk.core.component.reward.xr.xr(this.e);
        this.f = new ms(this.e);
        this.ul = new c(this.e);
        this.az = new d(this.e);
        this.m = new ah(this.e);
    }

    public void ms() {
        finish();
    }

    public void xr() {
        this.ul.m();
        this.ul.ms(2);
        this.ul.ny();
        ub();
        c(2);
    }

    public void onSkipBorderClick(View view) {
        this.lm.ms(view);
    }

    protected boolean ms(Bundle bundle) {
        this.f.ms(this.ka, this.f2061ms, this.eg);
        if (bundle != null) {
            this.f.ms();
        }
        com.bytedance.sdk.openadsdk.core.d.ms().xr(this.ka);
        if (this.ka != null) {
            return true;
        }
        sl.d("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        ms();
        return false;
    }

    private void vy() {
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVarMs = com.bytedance.sdk.openadsdk.core.component.reward.d.d.ms(this.e, this.ka);
        this.lm = msVarMs;
        if (msVarMs == null) {
            sl.d("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        msVarMs.getClass().getSimpleName();
        if (!of.xr(op(), this.ka, true)) {
            this.re = re.xr().ms(this.ka, this.k);
        }
        this.lm.ms(this.pc, this.ul, this.jw, this.az, this.f);
        this.lm.ms(this.f2061ms, this.re, op());
        this.lm.x();
    }

    private void sk() {
        if (this.ka == null || this.cv == null) {
            return;
        }
        String strLi = this.ka.li();
        if (TextUtils.isEmpty(strLi)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(strLi).optInt("auth_reward_gold");
            if (iOptInt > 0) {
                this.cv.addView(new RewardAuthToastLayout(this.e, iOptInt));
            }
        } catch (JSONException e) {
            sl.xr("TTBaseVideoActivity", e);
        }
    }

    protected void ah() {
        this.cv.ms(this.lm);
        sk();
        this.g = this.lm.ms(op());
        this.of = this.lm.sl();
        this.p = this.lm.zb();
        this.g.ms();
        c();
        this.g.ms(this.qf, this.rt);
        this.g.ms(this.f.ab());
        this.pc.ms(this.ka, this.jw, op(), this.qf);
        this.pc.d(this.re);
        if (this.f.ah()) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.qf.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.f.xr());
            this.f.ms(this.sk);
        }
        this.f.ms(this.vy);
        this.f.ms(this.zd);
        this.jw.ms(this.pc, this.f, op(), this.f2061ms, this.qr, this.ce);
        this.jw.ms(this.ka, this.qf, this.zd.r_(), this.p);
        this.az.ms(this.jw, this.ka, this.f2061ms, this.pc);
        this.m.ms(this.ka, this.f2061ms, this.g.zb());
        this.ul.ms(this.ka);
        this.oh = new com.bytedance.sdk.openadsdk.op.ms();
        this.sa = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d(this.ka, false, this.s);
        this.tz = new com.bytedance.sdk.openadsdk.core.playable.xr.xr(this.f2061ms);
    }

    protected void d() {
        com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar;
        u.ms().ah(this.ka, "stats_reward_full_show_endcard");
        if (isDestroyed() || isFinishing() || (xrVar = this.jw) == null || xrVar.pc()) {
            return;
        }
        if (!t.d(this.ka)) {
            this.jw.d(true);
        }
        this.lm.i();
        if (!(this.lm instanceof x) || !this.jw.y() || (this.lm instanceof ny)) {
            this.jw.nw();
        }
        this.pc.ms(true);
        this.az.ms(this.re);
        this.jw.hi();
        if ((this.lm instanceof x) && this.jw.le()) {
            this.jw.x();
            return;
        }
        this.pc.ms(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.xn;
        if (msVar != null) {
            msVar.xr();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms msVar2 = this.bz;
        if (msVar2 != null) {
            msVar2.ka();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xr xrVar2 = this.g;
        if (xrVar2 != null) {
            xrVar2.ka(8);
        }
        this.jw.ah(false);
        if (this.jw.ao()) {
            if (!qr.ch(this.ka) && !nw.xr(this.ka)) {
                this.jw.ms(true, 0, (String) null);
            }
            this.jw.zb();
            this.xr.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        if (!qr.ch(this.ka)) {
            this.jw.ms(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
        }
        this.jw.ka(true);
        this.ul.x();
    }

    public void ka() {
        if (!this.lm.sa()) {
            if (nw.ab(this.ka)) {
                return;
            }
            xr(true, true);
        } else {
            if (xr(this.ul.c(), false)) {
                return;
            }
            ms(true, true);
        }
    }

    protected boolean ms(long j, boolean z) {
        if (!this.ul.re()) {
            return false;
        }
        if (!z || !this.ul.i()) {
            ce();
        }
        boolean zMs = this.ul.ms(j, this.re, this.lm.re());
        if (zMs && !z) {
            if (nw.ab(this.ka)) {
                return true;
            }
            xr(true, true);
        }
        return zMs;
    }

    void c() {
        com.bytedance.sdk.openadsdk.core.xr.ka kaVar = new com.bytedance.sdk.openadsdk.core.xr.ka(this.e, this.ka, this.f2061ms, op() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.xr.ka
            public void xr(View view, hi hiVar) {
                TTBaseVideoActivity.this.ms(2);
                TTBaseVideoActivity.this.f.ms(view, TTBaseVideoActivity.this.sk, hiVar);
            }
        };
        this.qf = kaVar;
        if (this.lm instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.c) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.zd);
        }
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.qf.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.qf.ms(this.g.zb());
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.qf.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(eg());
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar = new com.bytedance.sdk.openadsdk.core.xr.xr(this.e, this.ka, this.f2061ms, op() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.20
            @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, hi hiVar) {
                TTBaseVideoActivity.this.m.ms(view, hiVar);
            }
        };
        this.rt = xrVar;
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.sk = new ms.InterfaceC0278ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.InterfaceC0278ms
            public void ms(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.m.ms(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.InterfaceC0278ms
            public void ms(View view, hi hiVar) {
                TTBaseVideoActivity.this.m.ms(view, hiVar);
            }
        };
        this.vy = new ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void ms(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(1, 0);
                }
                TTBaseVideoActivity.this.ms("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void ms(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(j2, j, 3);
                }
                if (j > 0) {
                    TTBaseVideoActivity.this.ms("已下载" + ((int) ((j2 * 100) / j)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void xr(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(j2, j, 2);
                }
                TTBaseVideoActivity.this.ms("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void ah(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(j2, j, 4);
                }
                TTBaseVideoActivity.this.ms("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void ms(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(5, 100);
                }
                TTBaseVideoActivity.this.ms("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xr.ms.xr
            public void ms(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.jw.ms(6, 100);
                }
                TTBaseVideoActivity.this.ms("点击打开");
            }
        };
        this.lm.ms(this.qf);
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar) {
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar.ms(TTBaseVideoActivity.this.ab());
                ahVar.ms(TTBaseVideoActivity.this.f2061ms);
                ahVar.ms(TTBaseVideoActivity.this.jm);
                return TTBaseVideoActivity.this.vm.get();
            }
        });
    }

    public Map<String, Object> ab() {
        Map<String, Object> mapEg = eg();
        if (this.yu > 0) {
            mapEg.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.yu) / 1000));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null && msVar.c() && this.of != null) {
            yu.ms(mapEg, this.ka, this.of.sl());
        }
        return mapEg;
    }

    public void ms(String str) {
        this.jw.ms(str);
    }

    private void gy() {
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, getClass().getName());
        this.k = f.ny(this.ka);
        this.gy = this.ka.ld();
        this.vl = this.ka.od();
        qf.ms(this.ka, false);
        qf.xr(this.ka, false);
        com.bytedance.sdk.openadsdk.core.x.d.ah = false;
        com.bytedance.sdk.openadsdk.core.x.d.xr = 0;
        com.bytedance.sdk.openadsdk.core.x.d.f3760ms = 0;
        com.bytedance.sdk.openadsdk.core.x.d.d = false;
    }

    protected void x() {
        float[] fArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.e.getApplicationContext(), this.gy, this.vl);
        float f = fArrMs[0];
        float f2 = fArrMs[1];
        if (this.gy == 100.0f) {
            this.qr = (int) f;
            this.ce = (int) f2;
            return;
        }
        int[] iArrMs = com.bytedance.sdk.openadsdk.core.component.reward.ka.xr.ms(this.e.getApplicationContext(), this.gy, this.ka.mp(), this.vl);
        int i = iArrMs[0];
        int i2 = iArrMs[1];
        int i3 = iArrMs[2];
        int i4 = iArrMs[3];
        float f3 = i;
        float f4 = i3;
        this.qr = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.ce = (int) ((f2 - f5) - f6);
        if (!com.bytedance.sdk.openadsdk.core.nw.le.ms(this.ka) || com.bytedance.sdk.openadsdk.core.u.d.ms(String.valueOf(this.k))) {
            try {
                this.cv.ms(ul.ah(this.e, f3), ul.ah(this.e, f5), ul.ah(this.e, f4), ul.ah(this.e, f6));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (op() && this.qk.xr()) {
            ms();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.jw.sl();
        com.bytedance.sdk.openadsdk.op.ms msVar = this.oh;
        if (msVar != null) {
            msVar.ms();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.v.ka()) {
            ms();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ka.d dVar = this.ih;
        if (dVar != null) {
            dVar.d();
            int iMs = (int) this.ih.ms(TimeUnit.SECONDS);
            ms(iMs, false);
            this.ih.ka();
            if (this.of != null && !qf.h(this.ka)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", iMs);
                } catch (JSONException e) {
                    sl.ms(e);
                }
                this.of.ms("reduceTime", jSONObject);
            }
        }
        this.i = true;
        this.jw.xr();
        this.f.d();
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null) {
            msVar.xr(this.c.containsKey(0));
            k();
            this.az.ms();
            jy();
            this.xr.sendEmptyMessageDelayed(1300, 1000L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d dVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d();
        dVar2.f2107ms = of.ms(op()) > 0;
        ms(1, dVar2);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        e();
        this.i = false;
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null) {
            msVar.u();
        }
        this.f.ka();
        this.jw.d();
        com.bytedance.sdk.openadsdk.core.component.reward.ka.d dVar = this.ih;
        if (dVar != null) {
            dVar.ah();
        }
        this.xr.removeMessages(1300);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null) {
            msVar.ah(this.x.get());
        }
        this.jw.ka();
        com.bytedance.sdk.openadsdk.op.ms msVar2 = this.oh;
        if (msVar2 != null) {
            msVar2.xr();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null) {
            msVar.ub();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar2 = this.xn;
        if (msVar2 != null) {
            msVar2.xr();
        }
        vl();
    }

    private void vl() {
        u.ms().ah(this.ka, "stats_reward_full_destroy");
        com.bytedance.sdk.openadsdk.core.x.d.ah = false;
        com.bytedance.sdk.openadsdk.core.x.d.xr = 0;
        com.bytedance.sdk.openadsdk.core.x.d.f3760ms = 0;
        com.bytedance.sdk.openadsdk.core.x.d.d = false;
        this.xr.removeCallbacksAndMessages(null);
        this.ul.w();
        this.f.c();
        this.jw.c();
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d dVar = this.sa;
        if (dVar != null) {
            dVar.xr();
        }
        ah(true);
        le();
        d("recycleRes");
        if (this.ka != null) {
            com.bytedance.sdk.openadsdk.core.i.ms(this.ka.da());
            pc.xr(this.ka.ka());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.eg);
            bundle.putBoolean(b.c.i, this.w);
            bundle.putLong("object_create_ts", this.yu);
            bundle.putBoolean("is_adm", this.op);
            bundle.putInt("key_video_cache_callback", this.le);
            bundle.putLong("video_current", this.ul.ao());
            bundle.putBoolean("is_mute", this.re);
            bundle.putString("rit_scene", this.fm);
            Double d = this.jm;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.bytedance.sdk.openadsdk.core.playable.xr.xr xrVar = this.tz;
        if (xrVar != null) {
            xrVar.ms(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ka == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ms.ah.ah.ms(this);
    }

    public boolean ny() {
        if (!t.hi(this.ka)) {
            return false;
        }
        hi();
        return true;
    }

    public boolean ch() {
        if ((lm.ah(this.ka) || this.ka.vv() == 1 || (this.lm instanceof ny)) && this.jw.u()) {
            this.jw.ub();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.playable.xr.xr xrVar = this.tz;
        return xrVar != null && xrVar.xr(this.e, this.ka);
    }

    public void hi() {
        if (this.jw.u()) {
            this.jw.ub();
            return;
        }
        if (!this.jw.w() && !ch.ka(this.ka) && !ch.d(this.ka)) {
            ms();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                if (t.hi(TTBaseVideoActivity.this.ka)) {
                    new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(TTBaseVideoActivity.this.ka.df()).ms("rewarded_video").xr("popup_play").d(TTBaseVideoActivity.this.ka.lx()).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
                    if (ch.ka(TTBaseVideoActivity.this.ka) || ch.d(TTBaseVideoActivity.this.ka)) {
                        return;
                    }
                    TTBaseVideoActivity.this.xr("onClickModalCallback");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                if (t.hi(TTBaseVideoActivity.this.ka)) {
                    new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(TTBaseVideoActivity.this.ka.df()).ms("rewarded_video").xr("popup_cancel").d(TTBaseVideoActivity.this.ka.lx()).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
                    TTBaseVideoActivity.this.ub();
                    TTBaseVideoActivity.this.ms();
                }
            }
        };
        if (ch.ka(this.ka) || ch.d(this.ka)) {
            xr(chVar);
        } else {
            ah(chVar);
        }
    }

    private void xr(com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        int iF = this.lm.f();
        TTBaseVideoActivity tTBaseVideoActivity = this.e;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.e.getIntent().putExtra("remainTime", iF);
        }
        if (iF > 0) {
            if (ms(chVar)) {
                return;
            }
            chVar.xr();
            return;
        }
        ms();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity$6] */
    private void ah(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.ny.ms.xr.ms(new com.bytedance.sdk.openadsdk.ny.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.ny.ms.xr.ms
            public void ms() {
                zArr[0] = true;
                chVar.xr();
            }

            @Override // com.bytedance.sdk.openadsdk.ny.ms.xr.ms
            public void ms(int i) {
                zArr[0] = true;
                if (TTBaseVideoActivity.this.e != null && TTBaseVideoActivity.this.e.getIntent() != null) {
                    TTBaseVideoActivity.this.e.getIntent().putExtra("remainTime", i);
                }
                if (i <= 0 || !TTBaseVideoActivity.this.ms(chVar)) {
                    chVar.xr();
                }
            }
        });
        xr("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.ms();
            }
        }.start();
    }

    public void xr(String str) {
        com.bytedance.sdk.openadsdk.core.pc pcVarYu = this.jw.yu();
        if (pcVarYu == null || isFinishing()) {
            ms();
            return;
        }
        try {
            pcVarYu.xr(str, (JSONObject) null);
        } catch (Exception e) {
            ms();
            sl.ms(e);
        }
    }

    public boolean ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        if (!op() || !re.xr().ab(String.valueOf(this.k)) || this.c.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.jy < 1000) {
            return true;
        }
        this.jy = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms msVarMs = this.lm.ms(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                TTBaseVideoActivity.this.m.ms("reward_retain_dialog_cancel", TTBaseVideoActivity.this.bz.ms(), TTBaseVideoActivity.this.bz.xr());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                TTBaseVideoActivity.this.ub.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
                TTBaseVideoActivity.this.m.ms("reward_retain_dialog_skip", TTBaseVideoActivity.this.bz.ms(), TTBaseVideoActivity.this.bz.xr());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms(int i) {
                TTBaseVideoActivity.this.ms(i, true);
                TTBaseVideoActivity.this.pc.xr("恭喜您，可提前" + i + "s获得奖励～");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ah() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ah();
                }
            }
        });
        this.bz = msVarMs;
        this.m.ms("reward_retain_dialog_show", msVarMs.ms(), this.bz.xr());
        return this.bz.ah();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ul.xr((Activity) this.e);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        if (TTBaseVideoActivity.this.tz != null) {
                            TTBaseVideoActivity.this.tz.ms();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.vl == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ul.ms((Activity) TTBaseVideoActivity.this.e);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ul.xr((Activity) TTBaseVideoActivity.this.e);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void qr() {
        final View decorView;
        if (this.ka == null || !this.ka.d()) {
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(128);
                re.ms(this.e);
                if (!this.lm.eg()) {
                    getWindow().addFlags(1024);
                }
            } catch (Throwable unused) {
            }
            try {
                decorView = getWindow().getDecorView();
            } catch (Throwable unused2) {
                decorView = null;
            }
            if (decorView == null) {
                return;
            }
            decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ul.xr() && TTBaseVideoActivity.this.vl == 1 && TTBaseVideoActivity.this.e.getResources().getConfiguration().orientation == 1) {
                            if (Math.abs(ul.ny((Context) TTBaseVideoActivity.this.e) - TTBaseVideoActivity.this.getWindow().getDecorView().getHeight()) == 0 && decorView.isAttachedToWindow()) {
                                View view = decorView;
                                view.setPadding(view.getPaddingLeft(), decorView.getPaddingTop() + ((int) ul.hi((Context) TTBaseVideoActivity.this.e)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Map<String, Object> mapEg = eg();
        com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar = this.jw;
        if (xrVar != null) {
            xrVar.ms(mapEg);
            this.jw.d();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (msVar != null) {
            msVar.xr(mapEg);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.c(this.ka, this.f2061ms, "click_close", mapEg);
        le();
        super.finish();
    }

    public void sl() {
        if (this.lm.sa()) {
            this.ul.ms(3);
            this.ul.y();
            this.ul.ah(true);
            ms(false, false);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        int i2 = message.what;
        if (i2 == 300) {
            sl();
            return;
        }
        if (i2 == 400) {
            this.ul.ny();
            if (this.lm.c()) {
                this.of.ms(true);
            }
            ms(false, true);
            return;
        }
        if (i2 == 500) {
            this.jw.ab();
            this.ul.x();
            this.g.ah(false);
            this.of.ah(false);
            this.of.d();
            return;
        }
        if (i2 == 600) {
            this.pc.ms(false, null, null, true, true);
            return;
        }
        if (i2 == 700) {
            this.jw.of();
            return;
        }
        if (i2 == 1200) {
            if (qf.h(this.ka)) {
                return;
            }
            if (this.jw.cv()) {
                ms(1, false);
                this.az.ms(m(), this.lm.f());
                ah(0);
            }
            this.xr.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
            return;
        }
        if (i2 != 1300) {
            return;
        }
        this.xr.sendEmptyMessageDelayed(1300, 1000L);
        if (w()) {
            return;
        }
        this.am++;
        if (!ti()) {
            this.l++;
            ms(2, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d) null);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d dVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d();
        dVar.f2107ms = true;
        ms(3, dVar);
        this.v.c();
    }

    public void xr(int i) {
        if (i <= 0) {
            this.pc.ms(false, null, null, true, true);
        } else {
            this.xr.sendEmptyMessageDelayed(600, i);
        }
    }

    public void zb() {
        u.ms().ms(this.ka, "stats_reward_full_completed", this.m.ms(new JSONObject()));
        if (this.sl.getAndSet(true)) {
            return;
        }
        d("onVideoComplete");
    }

    public void u() {
        if (this.hi.getAndSet(true)) {
            return;
        }
        d("onVideoError");
    }

    public void ub() {
        if (this.sl.get() || this.ch.getAndSet(true)) {
            return;
        }
        d("onSkippedVideo");
    }

    public void ao() {
        this.xr.removeMessages(700);
        this.xr.removeMessages(600);
    }

    public void ms(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        this.xr.sendMessageDelayed(messageObtain, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.xr
    public void ms(boolean z) {
        if (z) {
            if (this.of.c()) {
                return;
            }
            this.lm.d(true);
            return;
        }
        if (this.of.c() && this.ul.f() != null) {
            this.ul.f().ms(8);
        }
        this.lm.d(false);
        if (this.of.c() || this.vl == 2 || !com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.ka)) {
            return;
        }
        this.g.c(8);
    }

    protected void xr(boolean z) {
        Message message = new Message();
        message.what = 400;
        this.xr.sendMessageDelayed(message, z ? a.f : 0L);
    }

    protected void h() {
        this.xr.removeMessages(400);
    }

    private void ce() {
        if (this.jw.pc() || !this.i || ti() || !this.lm.sa() || this.ul.lm()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if ((msVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.ah) || (msVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.hi)) {
            return;
        }
        this.xr.removeMessages(300);
        this.xr.sendEmptyMessageDelayed(300, 5000L);
    }

    public int ka(int i) {
        boolean z = i == 2;
        boolean zAm = this.lm.am();
        int i2 = 4;
        switch (this.ka.qw()) {
            case 1:
                i2 = 1;
                break;
            case 2:
            default:
                i2 = 2;
                break;
            case 3:
                i2 = !z ? 2 : 1;
                break;
            case 4:
            case 5:
                i2 = !z ? 3 : 1;
                break;
            case 6:
                if (z) {
                    i2 = 1;
                }
                break;
            case 7:
                i2 = (!z || !this.ub.get()) ? 2 : 1;
                break;
            case 8:
            case 9:
                if (!jm()) {
                    i2 = !z ? 2 : 1;
                } else {
                    int iBz = bz();
                    if (z) {
                        i2 = 1;
                    } else if (iBz > 0) {
                        i2 = 2;
                    }
                }
                break;
        }
        if (i2 == 2 && !zAm) {
            i2 = 1;
        }
        if ((this.lm instanceof com.bytedance.sdk.openadsdk.core.component.reward.d.c) && com.bytedance.sdk.openadsdk.op.ch.ms(this.ka)) {
            return z ? 1 : 3;
        }
        return i2;
    }

    protected void c(int i) {
        int iKa = ka(i);
        if (i != 2) {
            if (this.az.d()) {
                return;
            }
            if (this.ul.sl()) {
                this.ul.ch();
                return;
            }
            if (qf.h(this.ka)) {
                if (this.zb.get() && !this.u.get()) {
                    if (iKa == 1 && !this.c.containsKey(0) && op()) {
                        this.pc.xr((this.ka.jr() == 3 && qf.qv(this.ka)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.ul.e();
                }
                if (!this.zb.get() && this.u.get() && (!jm() || i == 3)) {
                    return;
                }
                if (iKa == 1 && (!this.zb.get() || !this.u.get())) {
                    return;
                }
            }
        }
        if (iKa == 1) {
            ms();
            return;
        }
        if (iKa == 2) {
            if (this.ny.get()) {
                this.jw.nw();
            }
            d();
        } else if (iKa == 3) {
            this.ul.e();
        } else if (iKa == 4 && i != 3) {
            qv();
        }
    }

    protected void qv() {
        if (!jm()) {
            y();
        }
        this.ul.ch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jm() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVarAz = l().az();
        if (ahVarAz instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
            return ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVarAz).of();
        }
        return false;
    }

    public void y() {
        ka kaVar = this.of;
        if (kaVar != null) {
            kaVar.ms("videoLoopBegin", (JSONObject) null);
        }
    }

    private int bz() {
        com.bykv.vk.openvk.component.video.api.d.ah ahVarAz = l().az();
        if (ahVarAz instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms) {
            return ((com.bytedance.sdk.openadsdk.core.video.xr.ms) ahVarAz).fm();
        }
        return 0;
    }

    protected void ms(boolean z, boolean z2) {
        this.ul.xr(z2);
        u();
        if (z) {
            this.ao.set(true);
            if (qf.h(this.ka)) {
                this.lm.le();
            }
            this.pc.ms(false, null, null, true, true);
            d();
            return;
        }
        if (qf.nw(this.ka)) {
            this.jw.ul();
        } else {
            this.pc.ms(false, null, null, true, true);
            d(0);
        }
        if (this.ul.lm()) {
            return;
        }
        if (qf.h(this.ka)) {
            this.lm.le();
        }
        d();
    }

    public void t() {
        d();
    }

    public void nw() {
        ka kaVar;
        if (this.sa == null || (kaVar = this.of) == null || kaVar.sl() == null) {
            return;
        }
        this.of.sl().setEasyPlayableSender(this.sa.ms());
        this.sa.ms(jw().getEasyPlayableContainer(), null);
    }

    public void ab(int i) {
        this.cv.ms(i);
    }

    protected boolean b() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.xn;
        if (msVar != null) {
            return msVar.ah();
        }
        return false;
    }

    public void ah(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.xn == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(this.e, this.ka.ca(), this.f2061ms, true);
            this.xn = msVar;
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.e, msVar, this.ka);
            this.xn.ms(new com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void ms() {
                    TTBaseVideoActivity.this.e();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void ms(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.xr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.k();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void xr() {
                    TTBaseVideoActivity.this.k();
                }
            });
        }
        this.xn.ms(str);
        this.xn.ms();
    }

    public void re() {
        this.pc.ms(1);
        if (!qf.h(this.ka)) {
            this.pc.ms(false, null, null, true, true);
        }
        this.pc.ms(true);
        this.pc.ka(true);
        this.pc.c(false);
        this.pc.xr(this.ka.rk());
        this.az.ms(this.re, this.c.containsKey(0));
        this.xr.sendEmptyMessage(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.of.ms("playableStateChange", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void i() {
        this.az.ah();
        this.jw.jw();
        this.pc.ms(1);
        this.xr.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (op()) {
                jSONObject.put("reduce_duration", this.lm.xn());
            }
            this.of.ms("playableStateChange", jSONObject);
        } catch (Exception e) {
            sl.ms(e);
        }
        if (!this.v.ms(1)) {
            this.h.set(true);
        }
        ms(1, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d) null);
    }

    protected boolean w() {
        return j() || b() || this.lm.g();
    }

    public void ms(int i, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.d dVar) {
        if (nw.ah(this.ka) || this.ub.get() || this.hi.get()) {
            return;
        }
        int iCh = 0;
        if (i == 1) {
            if (!this.h.get()) {
                return;
            }
            if (dVar == null || !dVar.f2107ms) {
                this.h.set(false);
            }
        }
        int iMs = this.v.ms(i, (i == 1 || i == 3) && dVar != null && dVar.ah);
        if (iMs == 0) {
            return;
        }
        if (iMs == 3 && dVar != null && dVar.xr) {
            iCh = of.ch();
        }
        this.v.ms(new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah.ms().ms(this.eg).ms(this.lm.f()).xr(iCh).ms(this.sl.get()).xr(this.nw.get()).ms(this.c.keySet()).ah(this.re).ms(this.qk).ah(iMs).d(this.am).d(this.v.d() ? this.zf : lm.xr(this.ka)).ms(), iMs, dVar);
    }

    public boolean yu() {
        if (w() || this.ul.lm()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        return ((msVar != null && !msVar.sa()) || this.az.d() || this.jw.pc()) ? false : true;
    }

    private void jy() {
        final View decorView;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable unused) {
            decorView = null;
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.xr
    public void ms(int i) {
        this.nw.set(true);
        if (System.currentTimeMillis() - this.j > 50) {
            this.j = System.currentTimeMillis();
            d("onAdVideoBarClick");
        }
        if (!isFinishing()) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.x.ms(this.of.sl());
        }
        if (!this.x.get()) {
            this.x.set(true);
        }
        if (!this.v.ms(1)) {
            this.h.set(true);
        }
        ah(0);
        ny(i);
    }

    public void ny(int i) {
        com.bytedance.sdk.openadsdk.core.video.xr.xr xrVarPc;
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar = this.lm;
        if (!(msVar instanceof ny) || (xrVarPc = msVar.pc()) == null) {
            return;
        }
        if (xrVarPc.hi() == 1 && i == 1 && this.z.getAndSet(false)) {
            int iX = ul.x(re.getContext());
            float fC = ul.c(re.getContext());
            float fAb = ul.ab(re.getContext());
            Map<String, Object> mapEg = eg();
            mapEg.putAll(xrVarPc.ab());
            com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", this.ka, new com.bytedance.sdk.openadsdk.core.nw.ch.ms().c(-1.0f).ka(-1.0f).d(-1.0f).ah(-1.0f).xr(-1L).ms(-1L).ah(-1).d(-1).ka(-1024).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(iX).ms(fC).xr(fAb).ms(), this.f2061ms, true, mapEg, -1, false);
        }
    }

    public void xr(boolean z, boolean z2) {
        Integer numValueOf;
        int iValueOf = 1;
        if (z) {
            Map<String, Object> mapAb = ab();
            this.vm.set(true);
            try {
                String strEu = this.ka.eu();
                Integer numRemove = com.bytedance.sdk.openadsdk.core.x.d.ka.remove(strEu);
                if (numRemove == null) {
                    numValueOf = 1;
                } else {
                    numValueOf = Integer.valueOf(numRemove.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.x.d.ka.put(strEu, numValueOf);
                mapAb.put("meta_show_count", numValueOf);
                String strCh = f.ch(this.ka);
                Integer numRemove2 = com.bytedance.sdk.openadsdk.core.x.d.c.remove(strCh);
                if (numRemove2 != null) {
                    iValueOf = Integer.valueOf(numRemove2.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.x.d.c.put(strCh, iValueOf);
                mapAb.put("meta_origin_show_count", iValueOf);
            } catch (Throwable unused) {
            }
            mapAb.put("cache_strategy", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.ms.d.ms(op())));
            mapAb.put("is_adm", Boolean.valueOf(this.op));
            mapAb.put("is_play_again", Boolean.valueOf(cv()));
            mapAb.put("if_cache_callback", Integer.valueOf(this.le == 1 ? 1 : 0));
            mapAb.put("src_req_id", this.ka.wn());
            mapAb.put("is_map", Boolean.valueOf(this.ka.fg()));
            mapAb.put("is_repeat", Boolean.valueOf(this.t.getAndSet(true)));
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.f2061ms, mapAb, this.jm);
            com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
            pc.ms(this.ka.ka());
        }
        if (z2) {
            if (!of.xr(op(), this.ka, true)) {
                boolean zOy = re.xr().oy();
                if (!this.y.getAndSet(true) || zOy) {
                    d("onAdShow");
                } else {
                    u.ms().ah(this.ka, "stats_callback_repeat");
                }
            }
            if (this.lm.c()) {
                this.of.ab();
            }
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d dVar = this.sa;
            if (dVar != null && dVar.ms() != null) {
                this.sa.ms().d();
            }
        }
        ah(false);
    }

    private boolean j() {
        com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms msVar = this.bz;
        return msVar != null && msVar.d();
    }

    public boolean xr(long j, boolean z) {
        this.ul.ms(this.qf);
        this.ul.ms(this.lm.qv(), this.f2061ms, op());
        this.ul.xr(ab());
        if (this.lm.c()) {
            this.of.ms(this.ul.az());
        }
        this.ul.ms(this.ti);
        boolean zMs = ms(j, z);
        if (zMs && !z) {
            this.il = (int) (System.currentTimeMillis() / 1000);
        }
        return zMs;
    }

    public RewardFullBaseLayout jw() {
        return this.cv;
    }

    protected void ms(Intent intent) {
        if (intent != null) {
            this.fm = intent.getStringExtra("rit_scene");
            this.w = intent.getBooleanExtra(b.c.i, false);
            this.yu = intent.getLongExtra("object_create_ts", 0L);
            this.op = intent.getBooleanExtra("is_adm", false);
            this.eg = intent.getStringExtra("multi_process_key");
            this.le = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.jm = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
        }
    }

    protected void xr(Bundle bundle) {
        if (bundle != null) {
            this.eg = bundle.getString("multi_process_key");
            this.w = bundle.getBoolean(b.c.i);
            this.yu = bundle.getLong("object_create_ts");
            this.op = bundle.getBoolean("is_adm");
            this.le = bundle.getInt("key_video_cache_callback", -1);
            this.fm = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.jm = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.re = bundle.getBoolean("is_mute");
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.ul.ms(j);
            }
        }
    }

    protected void xr(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah ahVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah(intent.getStringExtra("insert_ad_bundle"));
        this.eg = ahVar.ms();
        this.am = ahVar.hi();
        this.zf = ahVar.sl();
        this.sl.set(ahVar.d());
        this.nw.set(ahVar.ka());
        this.c.putAll(ahVar.ny());
        this.v.ms(ahVar);
        this.re = ahVar.c();
        this.qk.ah(ahVar.ab());
    }

    public void f() {
        boolean z = !this.re;
        this.re = z;
        this.lm.ka(z);
    }

    public void ul() {
        this.az.xr();
    }

    public le az() {
        return this.xr;
    }

    public void ms(int i, boolean z) {
        hi(i);
        if (z) {
            ch(i);
        }
    }

    public void ch(int i) {
        if (this.of != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException e) {
                sl.ms(e);
            }
            this.of.ms("reduceTime", jSONObject);
        }
    }

    public void hi(int i) {
        this.lm.d(i);
        ah(0);
    }

    public int m() {
        return Math.max(this.lm.il() - (((int) (this.ul.g() / 1000)) + this.lm.xn()), 0);
    }

    public void sl(int i) {
        this.g.ka(i);
    }

    public void lm() {
        this.xr.removeMessages(600);
    }

    public void ms(float f, float f2, float f3, float f4, int i) {
        ka kaVar = this.of;
        if (kaVar == null || kaVar.ms() == null) {
            return;
        }
        int measuredWidth = this.of.ms().getMeasuredWidth();
        int measuredHeight = this.of.ms().getMeasuredHeight();
        if (this.ul.az() instanceof com.bytedance.sdk.openadsdk.core.video.xr.ms ? ((com.bytedance.sdk.openadsdk.core.video.xr.ms) this.ul.az()).qf() : false) {
            this.of.ms().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i);
        this.of.ms().startAnimation(scaleAnimation);
    }

    public void zb(int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar;
        if (this.ul.xr()) {
            HashMap map = new HashMap();
            map.put("pause_from", Integer.valueOf(i));
            this.ul.ms(map);
        }
        this.xr.removeMessages(300);
        this.xr.removeMessages(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        ub(i);
        if ((ti() && qf.h(this.ka) && this.az.d()) || (msVar = this.lm) == null) {
            return;
        }
        msVar.nw();
        this.jw.xr(ti());
    }

    public void e() {
        zb(0);
    }

    public void k() {
        u(0);
    }

    public void u(int i) {
        ao(i);
        if (this.lm instanceof ny) {
            this.xr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.ih();
                }
            }, 500L);
        } else {
            ih();
        }
        if (w()) {
            return;
        }
        if (this.jw.cv()) {
            this.xr.sendEmptyMessageDelayed(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, 1000L);
        }
        if (!ti() || this.jw.pc() || this.jw.cv()) {
            this.lm.b();
        }
        this.jw.ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih() {
        if (yu()) {
            ce();
            this.ul.ms(false, this, this.d.getAndSet(true));
        }
    }

    public Map<String, Object> eg() {
        HashMap map = new HashMap();
        String str = this.fm;
        if (str != null) {
            map.put("rit_scene", str);
        }
        map.put("insert_ad_control", Integer.valueOf(of.ms(this.ka)));
        map.put("carousel_pos", Integer.valueOf(of.d(this.ka)));
        map.put("refresh_ad_control", Integer.valueOf(of.xr(this.ka)));
        if (this.v.xr() != 0) {
            map.put("carousel_type", Integer.valueOf(this.v.xr()));
        }
        ah ahVar = this.m;
        if (ahVar != null) {
            ahVar.ms(map);
        }
        return map;
    }

    public Double fm() {
        return this.jm;
    }

    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.jw.ms(lmVar, xrVar);
        this.az.ms(lmVar);
    }

    private void oh() {
        this.zb.set(true);
    }

    public void il() {
        if (this.u.getAndSet(true)) {
            return;
        }
        c(3);
    }

    public boolean qf() {
        return this.az.d() || this.jw.pc();
    }

    public c l() {
        return this.ul;
    }

    public ah am() {
        return this.m;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.d.ms sa() {
        return this.lm;
    }

    public boolean tz() {
        return this.c.containsKey(0);
    }

    public boolean ti() {
        return !this.ab.isEmpty();
    }

    public void ub(int i) {
        if (i == 0) {
            return;
        }
        this.ab.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public void ao(int i) {
        if (i == 0) {
            return;
        }
        this.ab.remove(Integer.valueOf(i));
    }

    public void s() {
        this.pc.c();
    }

    public void v() {
        this.nw.set(true);
    }

    public void qk() {
        this.v.ah();
    }

    public void vm() {
        if (jm()) {
            zd();
            return;
        }
        if (!this.ul.jw() && !this.ul.sl()) {
            z();
        }
        c(1);
    }

    private void zd() {
        if (this.ul.p().l()) {
            if (this.ka.qw() == 9 && this.ul.jw()) {
                this.of.xr(true);
                this.ul.m();
            } else {
                this.of.xr(false);
            }
            c(1);
            return;
        }
        this.of.xr(true);
        if (this.ul.p().fm() < 2) {
            z();
        }
        if (this.ka.qw() == 8) {
            c(1);
        } else {
            y();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    private void z() {
        if (t.d(this.ka)) {
            this.ul.e();
            return;
        }
        zb();
        if (!qf.h(this.ka)) {
            com.bykv.vk.openvk.component.video.api.d.ah ahVarAz = l().az();
            if (!(ahVarAz instanceof com.bytedance.sdk.openadsdk.core.video.ms.ms) || !((com.bytedance.sdk.openadsdk.core.video.ms.ms) ahVarAz).of()) {
                ah(0);
                this.pc.ms(false, null, null, true, true);
            } else {
                oh();
            }
        } else {
            oh();
        }
        if (qf.ab(this.ka) && this.ul.nw() >= qf.ch(this.ka)) {
            ah(2);
        }
        this.lm.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tk() {
        return (this.ka.kz() == 180 && qf.h(this.ka) && com.bytedance.sdk.openadsdk.op.ch.ms(this.ka) && this.of.ny() == 7) ? false : true;
    }
}
