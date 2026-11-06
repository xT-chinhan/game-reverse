package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.ca.aj;
import com.byazt.ca.b;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.fj.SSWebView;
import com.byazt.fj.TTProgressBar;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.gz.x;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.mm.pr;
import com.byazt.pfl.hw;
import com.byazt.pi.RoundImageView;
import com.byazt.rg.BaseLandingPageActivity;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.sdv.c;
import com.byazt.vkw.g;
import com.byazt.w.hn;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zs.uc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity {
    protected hn er;
    private RelativeLayout hs;
    private RoundImageView ie;
    protected NativeVideoTsView ls;
    private int lv;
    private TextView nw;
    private TextView o;
    private FrameLayout qi;
    private long qn;
    private RelativeLayout v;
    private pr vj;
    private int of = 0;
    private int ii = 0;
    private int i = 0;
    private int r = 0;
    private boolean f = false;
    private final hn.hw bm = new hn.hw() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
        @Override // com.byazt.w.hn.hw
        public void pr(boolean z) {
            TTVideoWebPageActivity.this.f = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (!z) {
                er.pr((View) TTVideoWebPageActivity.this.ny, 0);
                er.pr((View) TTVideoWebPageActivity.this.v, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.qi.getLayoutParams();
                marginLayoutParams.width = TTVideoWebPageActivity.this.i;
                marginLayoutParams.height = TTVideoWebPageActivity.this.r;
                marginLayoutParams.leftMargin = TTVideoWebPageActivity.this.ii;
                marginLayoutParams.topMargin = TTVideoWebPageActivity.this.of;
                TTVideoWebPageActivity.this.qi.setLayoutParams(marginLayoutParams);
                return;
            }
            er.pr((View) TTVideoWebPageActivity.this.ny, 8);
            er.pr((View) TTVideoWebPageActivity.this.v, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.qi.getLayoutParams();
            TTVideoWebPageActivity.this.ii = marginLayoutParams2.leftMargin;
            TTVideoWebPageActivity.this.of = marginLayoutParams2.topMargin;
            TTVideoWebPageActivity.this.i = marginLayoutParams2.width;
            TTVideoWebPageActivity.this.r = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoWebPageActivity.this.qi.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean jn = false;
    private boolean l = true;
    private final com.byazt.apo.hn od = new com.byazt.apo.hn() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
        @Override // com.byazt.apo.hn
        public void pr(Context context, Intent intent, boolean z, int i) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.lv == 0 && i != 0 && TTVideoWebPageActivity.this.ny != null && TTVideoWebPageActivity.this.vk != null) {
                    aj.hw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.ny != null) {
                                TTVideoWebPageActivity.this.ny.loadUrl(TTVideoWebPageActivity.this.vk);
                            }
                        }
                    });
                }
                if (TTVideoWebPageActivity.this.ls != null && TTVideoWebPageActivity.this.ls.getNativeVideoController() != null && !TTVideoWebPageActivity.this.a() && TTVideoWebPageActivity.this.lv != i) {
                    ((x) TTVideoWebPageActivity.this.ls.getNativeVideoController()).pr(context, i);
                }
                TTVideoWebPageActivity.this.lv = i;
            }
        }
    };

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void pr(Bundle bundle) {
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable th) {
        }
        this.lv = yb.hn(getApplicationContext());
        Intent intent = getIntent();
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.qn = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra = intent.getStringExtra("multi_process_data");
        if (stringExtra != null) {
            try {
                this.vj = pr.pr(new JSONObject(stringExtra));
            } catch (Exception e) {
            }
            pr prVar = this.vj;
            if (prVar != null) {
                this.qn = prVar.fw;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.s == null) {
                try {
                    this.s = com.byazt.sd.pr.pr(new JSONObject(string));
                } catch (Throwable th2) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.qn = j;
            }
        }
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public View fw() {
        return c.pr(this.c, this.s);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void uc() {
        super.uc();
        k();
        nt();
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void c() {
        this.rc = (TTProgressBar) findViewById(2114387922);
        this.ny = (SSWebView) findViewById(2114387733);
        this.aj = (TTViewStub) findViewById(2114387956);
        pr(new hw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
            @Override // com.byazt.pfl.hw.pr
            public void pr() {
                if (TTVideoWebPageActivity.this.g()) {
                    TTVideoWebPageActivity.this.er.uc();
                }
            }

            @Override // com.byazt.pfl.hw.pr
            public void pr(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.ho()) {
                    TTVideoWebPageActivity.this.er.zo();
                }
            }

            @Override // com.byazt.pfl.hw.pr
            public void hw() {
                if (TTVideoWebPageActivity.this.ho()) {
                    TTVideoWebPageActivity.this.er.zo();
                }
            }
        }, true);
        this.qi = (FrameLayout) findViewById(2114387708);
        this.v = (RelativeLayout) findViewById(2114387943);
        this.hs = (RelativeLayout) findViewById(2114387655);
        this.nw = (TextView) findViewById(2114387957);
        this.o = (TextView) findViewById(2114387764);
        this.y = (TextView) findViewById(2114387686);
        this.ie = (RoundImageView) findViewById(2114387664);
        qa();
        hw();
        if (this.s != null && this.v != null && this.s.ls()) {
            this.v.setVisibility(8);
        }
        pr(true);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void pr(String str) {
        Map<String, Object> mapPr;
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            mapPr = ls.pr(this.s, this.ls.getNativeVideoController().k(), this.ls.getNativeVideoController().yb());
        } else {
            mapPr = null;
        }
        com.byazt.pj.pr.pr(this.s, hw.AD_TAG_FEED, str, yb(), lb(), mapPr);
    }

    private void nt() {
        if (of.hn(this.s)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.ls = new NativeVideoTsView(this.c != null ? this.c.getApplicationContext() : a.getContext(), this.s, true, true);
                } else {
                    this.ls = new NativeVideoTsView(this.c != null ? this.c.getApplicationContext() : a.getContext(), this.s, true, false);
                }
                if (this.ls.getNativeVideoController() != null) {
                    this.ls.getNativeVideoController().pr(false);
                    if (this.vj != null) {
                        this.ls.getNativeVideoController().hn(this.vj.pr);
                    }
                }
                this.ls.setVideoAdInteractionListener(new com.byazt.hp.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                    @Override // com.byazt.hp.pr, com.byazt.w.hn.InterfaceC0220hn
                    public void pr(long j, long j2) {
                        if (TTVideoWebPageActivity.this.ny()) {
                            zo.nt().pr(j);
                        }
                    }
                });
                if (!this.a) {
                    this.qn = 0L;
                }
                if (this.vj != null && this.ls.getNativeVideoController() != null) {
                    this.ls.getNativeVideoController().hn(this.vj.fw);
                    this.ls.getNativeVideoController().x(this.vj.c);
                }
                if (this.ls.getNativeVideoController() != null) {
                    this.ls.getNativeVideoController().pr(false);
                    this.ls.getNativeVideoController().pr(this.bm);
                    this.ls.setIsQuiet(this.s.ax() == 1);
                }
                if (this.ls.pr(this.qn, this.l, a())) {
                    this.qi.setVisibility(0);
                    this.qi.removeAllViews();
                    this.qi.addView(this.ls);
                }
                if (a()) {
                    this.ls.x(true);
                }
                this.er = this.ls.getNativeVideoController();
            } catch (Exception e) {
            }
            if (yb.hn(this.c.getApplicationContext()) == 0) {
                try {
                    b.pr(this.c, "\"无网络，请稍后再试\"", 0);
                } catch (Exception e2) {
                }
            }
        }
    }

    private long yb() {
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            return this.ls.getNativeVideoController().g();
        }
        return 0L;
    }

    private int lb() {
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            return this.ls.getNativeVideoController().ho();
        }
        return 0;
    }

    private void qa() {
        String strZj;
        if (this.s == null || this.s.aj() != 4) {
            return;
        }
        er.pr((View) this.hs, 0);
        if (!TextUtils.isEmpty(this.s.A_())) {
            strZj = this.s.A_();
        } else if (!TextUtils.isEmpty(this.s.jv())) {
            strZj = this.s.jv();
        } else if (TextUtils.isEmpty(this.s.zj())) {
            strZj = "";
        } else {
            strZj = this.s.zj();
        }
        y yVarMo = this.s.mo();
        if (yVarMo != null && yVarMo.pr() != null) {
            er.pr((View) this.ie, 0);
            er.pr((View) this.nw, 4);
            com.byazt.ub.hw.pr(yVarMo).pr(this.ie);
        } else if (!TextUtils.isEmpty(strZj)) {
            er.pr((View) this.ie, 4);
            er.pr((View) this.nw, 0);
            this.nw.setText(strZj.substring(0, 1));
        }
        if (this.o != null && !TextUtils.isEmpty(strZj)) {
            this.o.setText(strZj);
        }
        if (!TextUtils.isEmpty(this.s.se())) {
            this.y.setText(this.s.se());
        }
        er.pr((View) this.o, 0);
        if (ny()) {
            er.pr((View) this.y, 8);
        } else {
            er.pr((View) this.y, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public boolean zo() {
        NativeVideoTsView nativeVideoTsView;
        if (super.zo()) {
            return true;
        }
        if (this.f && (nativeVideoTsView = this.ls) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.byazt.w.pr) this.ls.getNativeVideoController()).c(null, null);
            this.f = false;
            return true;
        }
        pr("detail_back");
        return false;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.s != null ? this.s.to().toString() : null);
        bundle.putLong("video_play_position", this.qn);
        bundle.putBoolean("is_complete", a());
        long jW = this.qn;
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jW = this.ls.getNativeVideoController().w();
        }
        bundle.putLong("video_play_position", jW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.l = false;
        if (this.jn && ho() && cz()) {
            this.jn = false;
            this.er.zo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.jn && cz()) {
                this.jn = true;
                this.er.uc();
            }
        } catch (Throwable th) {
            ho.hw("BaseLandingPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        if (a() || ((nativeVideoTsView2 = this.ls) != null && nativeVideoTsView2.getNativeVideoController() != null && this.ls.getNativeVideoController().a())) {
            com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(this.s == null ? null : this.s.yn(), "sp_multi_native_video_data");
            hnVarPr.pr("key_video_is_update_flag", true);
            hnVarPr.pr("key_native_video_complete", true);
            hnVarPr.pr("key_video_isfromvideodetailpage", true);
        }
        if (!a() && (nativeVideoTsView = this.ls) != null && nativeVideoTsView.getNativeVideoController() != null) {
            pr(this.ls.getNativeVideoController());
        }
    }

    private void pr(hn hnVar) {
        ho.hw("mutilproces", "initFeedNaitiveControllerData-isComplete=" + hnVar.a() + ",position=" + hnVar.w() + ",totalPlayDuration=" + (hnVar.g() + hnVar.k()) + ",duration=" + hnVar.g());
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(this.s == null ? null : this.s.yn(), "sp_multi_native_video_data");
        hnVarPr.pr("key_video_is_update_flag", true);
        hnVarPr.pr("key_video_isfromvideodetailpage", true);
        hnVarPr.pr("key_native_video_complete", hnVar.a());
        hnVarPr.pr("key_video_current_play_position", hnVar.w());
        hnVarPr.pr("key_video_total_play_duration", hnVar.g() + hnVar.k());
        hnVarPr.pr("key_video_duration", hnVar.g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m();
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.ls.getNativeVideoController().vk();
        }
        NativeVideoTsView nativeVideoTsView2 = this.ls;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.a();
            this.ls = null;
        }
        this.s = null;
    }

    protected void k() {
        ((g) uc.pr("device_info_new")).pr(this.od);
    }

    protected void m() {
        try {
            ((g) uc.pr("device_info_new")).hw(this.od);
        } catch (Exception e) {
        }
    }

    boolean g() {
        hn hnVar = this.er;
        return (hnVar == null || hnVar.yb() == null || !this.er.yb().vk()) ? false : true;
    }

    protected boolean ho() {
        hn hnVar = this.er;
        return (hnVar == null || hnVar.yb() == null || !this.er.yb().k()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        NativeVideoTsView nativeVideoTsView = this.ls;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.ls.getNativeVideoController().a();
    }

    private boolean cz() {
        return this.z == null || !this.z.hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ny() {
        if (this.s == null) {
            return false;
        }
        int iKs = this.s.ks();
        return this.x == 1 && "embeded_ad_landingpage".equals(this.hn) && (iKs == 1 || iKs == 2);
    }
}
