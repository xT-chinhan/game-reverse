package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.byazt.ep.cp;
import com.byazt.fj.n;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.hm.q;
import com.byazt.ho.BaseConstants;
import com.byazt.lz.TTViewStub;
import com.byazt.oh.s;
import com.byazt.pt.BaseLandingPageActivity;
import com.byazt.tk.sz;
import com.byazt.tk.t;
import com.byazt.ul.qg;
import com.byazt.vf.wo;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements wo.n {
    private static WeakReference<s> f;
    private boolean b;
    private TTViewStub df;
    private ImageView dg;
    private FrameLayout dh;
    private TTViewStub fi;
    private int nf;
    private TTViewStub oj;
    private int pe;
    private FrameLayout pk;
    private boolean rf;
    private boolean ri;
    private qg sh;
    private q u;
    private com.byazt.ul.q wo;
    private n y;
    private long yw;
    private boolean e = true;
    private final t cx = new t(Looper.getMainLooper(), this);

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void n(Bundle bundle) {
        setRequestedOrientation(1);
        getWindow().addFlags(1024);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public View x() {
        return com.byazt.cb.qg.f(this.l);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void l() {
        TTViewStub tTViewStub;
        this.dh = (FrameLayout) findViewById(2114387634);
        this.pk = (FrameLayout) findViewById(2114387720);
        this.rv = (TTViewStub) findViewById(2114387956);
        this.fi = (TTViewStub) findViewById(2114387770);
        this.df = (TTViewStub) findViewById(2114387792);
        this.oj = (TTViewStub) findViewById(2114387933);
        k();
        if (this.ae != null && this.ae.pt() != null) {
            this.ae.pt().n("landing_page");
        }
        if (this.b || this.ri) {
            TTViewStub tTViewStub2 = this.oj;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.dg = (ImageView) findViewById(2114387843);
        } else {
            int iBb = com.byazt.vyf.s.cy().bb();
            if (iBb == 0) {
                TTViewStub tTViewStub3 = this.fi;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (iBb == 1 && (tTViewStub = this.df) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        this.sz = (ImageView) findViewById(2114387705);
        if (this.sz != null) {
            this.sz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.k = (ImageView) findViewById(2114387704);
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.cy = (TextView) findViewById(2114387952);
        this.hd = (TextView) findViewById(2114387627);
        if (this.cy != null && !this.b && !this.ri) {
            this.cy.setText(TextUtils.isEmpty(this.oa) ? "广告" : this.oa);
        }
        if (this.hd != null) {
            this.hd.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.n(new com.byazt.wg.qg.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3.1
                        @Override // com.byazt.wg.qg.n
                        public void n() {
                            TTNativePageActivity.this.d();
                        }

                        @Override // com.byazt.wg.qg.n
                        public void n(int i, String str, boolean z) {
                            TTNativePageActivity.this.oa();
                        }

                        @Override // com.byazt.wg.qg.n
                        public void qg() {
                            TTNativePageActivity.this.oa();
                        }
                    });
                }
            });
        }
        cy();
        n(4);
        if (this.b || this.ri) {
            py();
        }
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void w() {
        com.byazt.hm.n.n(this.ae, getClass().getName());
        sz();
    }

    private void sz() {
        if (this.ae == null || this.ae.vb() == null || this.ae.vb().q() != 3) {
            return;
        }
        com.byazt.ltk.n.n().n(this.ae);
    }

    private void k() {
        this.ri = cx.um(this.ae);
        this.b = cx.cd(this.ae);
        if (this.ri) {
            if (com.byazt.rv.s.q) {
                if (this.b) {
                    this.ri = false;
                    return;
                }
                return;
            }
            this.b = false;
        }
    }

    private void cy() {
        this.yw = System.currentTimeMillis();
        q qVar = new q(this.ae);
        this.u = qVar;
        qVar.n(true);
        this.u.n();
        if (cp.fs(this.ae)) {
            n nVar = new n(this, this.pk, this.u, this.ae, this.s, this.q, hd());
            this.y = nVar;
            nVar.n(new com.byazt.au.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // com.byazt.au.n
                public void n(View view) {
                }

                @Override // com.byazt.au.n
                public void n(int i) {
                    TTNativePageActivity.this.qg(i);
                }
            });
            this.y.n();
            return;
        }
        cd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        Intent intent;
        WeakReference<s> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = f) != null && weakReference.get() != null) {
            f.get().setCheckReplaceDialogWithLp(false);
            f.get().changeDownloadStatus(w.h(this.ae), false);
            f = null;
        } else {
            if (pk.s(this.ae) && w.fs(this.ae)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.byazt.tk.n.n(this.l, intent, null);
            } catch (Throwable unused) {
            }
        }
        finish();
    }

    private com.byazt.cs.n hd() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.byazt.cs.n.n(new JSONObject(stringExtra));
        } catch (JSONException unused) {
            return null;
        }
    }

    private void cd() {
        com.byazt.ai.n nVarVb = this.ae.vb();
        if (nVarVb == null) {
            return;
        }
        int iQ = nVarVb.q();
        if (iQ == 2) {
            com.byazt.ul.q qVar = new com.byazt.ul.q(this.l, this.pk, this.u, this.ae, this.s, this.q);
            this.wo = qVar;
            qVar.d();
            return;
        }
        if (iQ == 3) {
            qg qgVar = new qg(this.l, this.pk, this.u, this.ae, this.s, this.q);
            this.sh = qgVar;
            qgVar.qg(false);
            this.sh.d();
            if (TextUtils.equals(nVarVb.n(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.l);
            float fS = com.byazt.okk.s.s(this.l, 18.0f);
            float fS2 = com.byazt.okk.s.s(this.l, 18.0f);
            int i = (int) fS;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) fS2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.dh.addView(imageView, layoutParams);
            sz.n((Context) this.l, "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity tTNativePageActivity = TTNativePageActivity.this;
                    tTNativePageActivity.rf = !tTNativePageActivity.rf;
                    sz.n((Context) TTNativePageActivity.this.l, TTNativePageActivity.this.rf ? "tt_mute" : "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                    TTNativePageActivity.this.sh.s(TTNativePageActivity.this.rf);
                }
            });
        }
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private boolean um() {
        return this.b || this.ri;
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q qVar = this.u;
        if (qVar != null) {
            qVar.s();
        }
        oa();
        n nVar = this.y;
        if (nVar != null) {
            nVar.s();
        }
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        q qVar = this.u;
        if (qVar != null) {
            qVar.n(0);
        }
        if (this.e) {
            this.e = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.yw);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.aci.n.n(jSONObject, this.ae);
            } catch (JSONException unused) {
            }
            com.byazt.hm.n.n(this.ae, "landingpage", "agg_stay_page", new com.byazt.rs.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        n nVar = this.y;
        if (nVar != null) {
            nVar.qg();
        }
        d();
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean a() {
        return pk.q(this.ae);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public void n(int i) {
        if (a()) {
            com.byazt.okk.s.n((View) this.k, 4);
        } else {
            if (this.k == null || !a()) {
                return;
            }
            com.byazt.okk.s.n((View) this.k, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        n nVar = this.y;
        if (nVar != null) {
            nVar.q();
        }
        qg qgVar = this.sh;
        if (qgVar != null) {
            qgVar.k();
        }
        q qVar = this.u;
        if (qVar != null) {
            qVar.q();
        }
    }

    private void py() {
        this.nf = 0;
        if (this.b) {
            this.nf = com.byazt.rv.s.n;
        } else if (this.ri && !com.byazt.rv.s.q) {
            this.nf = cx.sz(this.ae);
        }
        s(this.nf);
        if (this.nf > 0 && !this.cx.hasMessages(10)) {
            if (this.b) {
                this.cx.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.ri) {
                this.cx.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void s(int i) {
        if (i > 0) {
            if (this.b) {
                com.byazt.okk.s.n(this.cy, i + "s后可领取奖励");
                return;
            } else {
                if (this.ri) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    com.byazt.okk.s.n(this.cy, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.b) {
            com.byazt.okk.s.n(this.cy, "领取成功");
        } else if (this.ri) {
            com.byazt.okk.s.n((View) this.dg, 8);
            com.byazt.okk.s.n(this.cy, "恭喜你！福利已领取");
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 10 && um()) {
            int i = this.pe + 1;
            this.pe = i;
            if (this.b) {
                com.byazt.rv.s.qg = i;
            }
            int iMax = Math.max(0, this.nf - this.pe);
            s(iMax);
            if (iMax <= 0 && this.ri) {
                com.byazt.rv.s.q = true;
            }
            this.cx.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public void d() {
        if (um()) {
            this.cx.removeMessages(10);
        }
    }

    public void oa() {
        if (!um() || this.cx.hasMessages(10)) {
            return;
        }
        this.cx.sendEmptyMessageDelayed(10, 1000L);
    }

    public static void n(s sVar) {
        f = new WeakReference<>(sVar);
    }
}
