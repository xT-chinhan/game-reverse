package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.ca.g;
import com.byazt.ca.iu;
import com.byazt.ea.w;
import com.byazt.fi.BaseConstants;
import com.byazt.hb.uc;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.le.pr;
import com.byazt.rg.BaseLandingPageActivity;
import com.byazt.ri.hn;
import com.byazt.sd.zo;
import com.byazt.sdv.c;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.ze.hw;
import com.byazt.ze.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements qi.pr {
    private static WeakReference<hn> ls;
    private int bm;
    private TTViewStub er;
    private boolean f;
    private pr hs;
    private x i;
    private FrameLayout ie;
    private FrameLayout ii;
    private int jn;
    private long lv;
    private boolean nw;
    private boolean o;
    private com.byazt.pj.x of;
    private TTViewStub qi;
    private ImageView qn;
    private hw r;
    private TTViewStub v;
    private boolean l = true;
    private final iu od = new iu(Looper.getMainLooper(), this);

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void pr(Bundle bundle) {
        setRequestedOrientation(1);
        getWindow().addFlags(1024);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public View fw() {
        return c.ls(this.c);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void c() {
        this.ie = (FrameLayout) findViewById(2114387634);
        this.ii = (FrameLayout) findViewById(2114387720);
        this.aj = (TTViewStub) findViewById(2114387956);
        this.er = (TTViewStub) findViewById(2114387770);
        this.v = (TTViewStub) findViewById(2114387792);
        this.qi = (TTViewStub) findViewById(2114387933);
        ho();
        if (this.s != null && this.s.ae() != null) {
            this.s.ae().pr("landing_page");
        }
        if (this.o || this.f) {
            TTViewStub tTViewStub = this.qi;
            if (tTViewStub != null) {
                tTViewStub.setVisibility(0);
            }
            this.qn = (ImageView) findViewById(2114387843);
        } else {
            switch (zo.nt().gz()) {
                case 0:
                    TTViewStub tTViewStub2 = this.er;
                    if (tTViewStub2 != null) {
                        tTViewStub2.setVisibility(0);
                    }
                    break;
                case 1:
                    TTViewStub tTViewStub3 = this.v;
                    if (tTViewStub3 != null) {
                        tTViewStub3.setVisibility(0);
                    }
                    break;
            }
        }
        this.g = (ImageView) findViewById(2114387705);
        if (this.g != null) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.ho = (ImageView) findViewById(2114387704);
        if (this.ho != null) {
            this.ho.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.nt = (TextView) findViewById(2114387952);
        this.yb = (TextView) findViewById(2114387627);
        if (this.nt != null && !this.o && !this.f) {
            this.nt.setText(TextUtils.isEmpty(this.m) ? "广告" : this.m);
        }
        if (this.yb != null) {
            this.yb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.pr(new com.byazt.pfl.hw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3.1
                        @Override // com.byazt.pfl.hw.pr
                        public void pr() {
                            TTNativePageActivity.this.k();
                        }

                        @Override // com.byazt.pfl.hw.pr
                        public void pr(int i, String str, boolean z) {
                            TTNativePageActivity.this.m();
                        }

                        @Override // com.byazt.pfl.hw.pr
                        public void hw() {
                            TTNativePageActivity.this.m();
                        }
                    });
                }
            });
        }
        nt();
        pr(4);
        if (this.o || this.f) {
            cz();
        }
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void uc() {
        com.byazt.pj.pr.pr(this.s, getClass().getName());
        g();
    }

    private void g() {
        if (this.s != null && this.s.mw() != null && this.s.mw().x() == 3) {
            com.byazt.sb.hw.pr().pr(this.s);
        }
    }

    private void ho() {
        this.f = jn.qa(this.s);
        this.o = jn.lb(this.s);
        if (this.f) {
            if (uc.x) {
                if (this.o) {
                    this.f = false;
                    return;
                }
                return;
            }
            this.o = false;
        }
    }

    private void nt() {
        this.lv = System.currentTimeMillis();
        com.byazt.pj.x xVar = new com.byazt.pj.x(this.s);
        this.of = xVar;
        xVar.pr(true);
        this.of.pr();
        if (w.zo(this.s)) {
            pr prVar = new pr(this, this.ii, this.of, this.s, this.hn, this.x, yb());
            this.hs = prVar;
            prVar.pr(new com.byazt.ql.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // com.byazt.ql.pr
                public void pr(View view) {
                }

                @Override // com.byazt.ql.pr
                public void pr(int i) {
                    TTNativePageActivity.this.hw(i);
                }
            });
            this.hs.pr();
            return;
        }
        lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i) {
        Intent intent;
        WeakReference<hn> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = ls) != null && weakReference.get() != null) {
            ls.get().pr(false);
            ls.get().pr(ls.fo(this.s), false);
            ls = null;
        } else {
            if (of.hn(this.s) && ls.zo(this.s)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.byazt.ca.pr.pr(this.c, intent, null);
            } catch (Throwable th) {
            }
        }
        finish();
    }

    private com.byazt.mm.pr yb() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                return com.byazt.mm.pr.pr(new JSONObject(stringExtra));
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    private void lb() {
        com.byazt.qk.pr prVarMw = this.s.mw();
        if (prVarMw == null) {
            return;
        }
        int iX = prVarMw.x();
        if (iX == 2) {
            x xVar = new x(this.c, this.ii, this.of, this.s, this.hn, this.x);
            this.i = xVar;
            xVar.k();
            return;
        }
        if (iX == 3) {
            hw hwVar = new hw(this.c, this.ii, this.of, this.s, this.hn, this.x);
            this.r = hwVar;
            hwVar.hw(false);
            this.r.k();
            if (!TextUtils.equals(prVarMw.pr(), GlobalSetting.SPLASH_AD)) {
                final ImageView imageView = new ImageView(this.c);
                float fHn = er.hn(this.c, 18.0f);
                float fHn2 = er.hn(this.c, 18.0f);
                int i = (int) fHn;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
                layoutParams.gravity = 53;
                int i2 = (int) fHn2;
                layoutParams.setMargins(i2, i2, i2, i2);
                this.ie.addView(imageView, layoutParams);
                g.pr((Context) this.c, "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TTNativePageActivity tTNativePageActivity = TTNativePageActivity.this;
                        tTNativePageActivity.nw = !tTNativePageActivity.nw;
                        g.pr((Context) TTNativePageActivity.this.c, TTNativePageActivity.this.nw ? "tt_mute" : "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                        TTNativePageActivity.this.r.hn(TTNativePageActivity.this.nw);
                    }
                });
            }
        }
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private boolean qa() {
        return this.o || this.f;
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.byazt.pj.x xVar = this.of;
        if (xVar != null) {
            xVar.hn();
        }
        m();
        pr prVar = this.hs;
        if (prVar != null) {
            prVar.hn();
        }
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.byazt.pj.x xVar = this.of;
        if (xVar != null) {
            xVar.pr(0);
        }
        if (this.l) {
            this.l = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackAction.START, this.lv);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.ja.pr.pr(jSONObject, this.s);
            } catch (JSONException e) {
            }
            com.byazt.pj.pr.pr(this.s, "landingpage", "agg_stay_page", new com.byazt.ttf.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pr prVar = this.hs;
        if (prVar != null) {
            prVar.hw();
        }
        k();
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean a() {
        return of.x(this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public void pr(int i) {
        if (a()) {
            er.pr((View) this.ho, 4);
        } else {
            if (this.ho == null || !a()) {
                return;
            }
            er.pr((View) this.ho, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
        }
        pr prVar = this.hs;
        if (prVar != null) {
            prVar.x();
        }
        hw hwVar = this.r;
        if (hwVar != null) {
            hwVar.ho();
        }
        com.byazt.pj.x xVar = this.of;
        if (xVar != null) {
            xVar.x();
        }
    }

    private void cz() {
        this.bm = 0;
        if (this.o) {
            this.bm = uc.pr;
        } else if (this.f && !uc.x) {
            this.bm = jn.g(this.s);
        }
        hn(this.bm);
        if (this.bm > 0 && !this.od.hasMessages(10)) {
            if (this.o) {
                this.od.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.f) {
                this.od.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void hn(int i) {
        if (i > 0) {
            if (this.o) {
                er.pr(this.nt, i + "s后可领取奖励");
                return;
            } else {
                if (this.f) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    er.pr(this.nt, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            er.pr(this.nt, "领取成功");
        } else if (this.f) {
            er.pr((View) this.qn, 8);
            er.pr(this.nt, "恭喜你！福利已领取");
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 10:
                if (qa()) {
                    int i = this.jn + 1;
                    this.jn = i;
                    if (this.o) {
                        uc.hw = i;
                    }
                    int iMax = Math.max(0, this.bm - this.jn);
                    hn(iMax);
                    if (iMax <= 0 && this.f) {
                        uc.x = true;
                    }
                    this.od.sendEmptyMessageDelayed(10, 1000L);
                    break;
                }
                break;
        }
    }

    public void k() {
        if (qa()) {
            this.od.removeMessages(10);
        }
    }

    public void m() {
        if (qa() && !this.od.hasMessages(10)) {
            this.od.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public static void pr(hn hnVar) {
        ls = new WeakReference<>(hnVar);
    }
}
