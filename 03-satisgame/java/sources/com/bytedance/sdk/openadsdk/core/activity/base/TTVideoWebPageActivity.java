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
import com.byazt.cs.n;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.hsi.q;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.iag.s;
import com.byazt.kfh.SSWebView;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lk.l;
import com.byazt.lz.TTViewStub;
import com.byazt.ndr.RoundImageView;
import com.byazt.pt.BaseLandingPageActivity;
import com.byazt.tk.h;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import com.byazt.vf.oa;
import com.byazt.vgx.qg;
import com.byazt.vgx.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity {
    private TextView b;
    private RelativeLayout df;
    private long dg;
    private RoundImageView dh;
    protected NativeVideoTsView f;
    protected s fi;
    private n lq;
    private FrameLayout oj;
    private TextView rf;
    private RelativeLayout y;
    private int yw;
    private int u = 0;
    private int pk = 0;
    private int wo = 0;
    private int sh = 0;
    private boolean ri = false;
    private final s.qg nf = new s.qg() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
        @Override // com.byazt.iag.s.qg
        public void n(boolean z) {
            TTVideoWebPageActivity.this.ri = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                com.byazt.okk.s.n((View) TTVideoWebPageActivity.this.ou, 8);
                com.byazt.okk.s.n((View) TTVideoWebPageActivity.this.df, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.oj.getLayoutParams();
                TTVideoWebPageActivity.this.pk = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.u = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.wo = marginLayoutParams.width;
                TTVideoWebPageActivity.this.sh = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.oj.setLayoutParams(marginLayoutParams);
                return;
            }
            com.byazt.okk.s.n((View) TTVideoWebPageActivity.this.ou, 0);
            com.byazt.okk.s.n((View) TTVideoWebPageActivity.this.df, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.oj.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.wo;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.sh;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.pk;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.u;
            TTVideoWebPageActivity.this.oj.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean pe = false;
    private boolean e = true;
    private final com.byazt.hsi.s cx = new com.byazt.hsi.s() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
        public final long qg = q.n();

        @Override // com.byazt.hsi.s
        public void n(Context context, Intent intent, boolean z, int i) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.yw == 0 && i != 0 && TTVideoWebPageActivity.this.ou != null && TTVideoWebPageActivity.this.tj != null) {
                    rv.qg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.ou != null) {
                                TTVideoWebPageActivity.this.ou.loadUrl(TTVideoWebPageActivity.this.tj);
                            }
                        }
                    });
                }
                if (TTVideoWebPageActivity.this.f != null && TTVideoWebPageActivity.this.f.getNativeVideoController() != null && !TTVideoWebPageActivity.this.a() && TTVideoWebPageActivity.this.yw != i) {
                    ((com.byazt.ia.q) TTVideoWebPageActivity.this.f.getNativeVideoController()).n(context, i);
                }
                TTVideoWebPageActivity.this.yw = i;
            }
        }

        @Override // com.byazt.hsi.s
        public long n() {
            return this.qg;
        }
    };

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void n(Bundle bundle) {
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        this.yw = hd.s(getApplicationContext());
        Intent intent = getIntent();
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.dg = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra = intent.getStringExtra("multi_process_data");
        if (stringExtra != null) {
            try {
                this.lq = n.n(new JSONObject(stringExtra));
            } catch (Exception unused2) {
            }
            n nVar = this.lq;
            if (nVar != null) {
                this.dg = nVar.x;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.ae == null) {
                try {
                    this.ae = qg.n(new JSONObject(string));
                } catch (Throwable unused3) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.dg = j;
            }
        }
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public View x() {
        return com.byazt.cb.qg.n(this.l, this.ae);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void w() {
        super.w();
        d();
        cy();
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void l() {
        this.m = (TTProgressBar) findViewById(2114387922);
        this.ou = (SSWebView) findViewById(2114387733);
        this.rv = (TTViewStub) findViewById(2114387956);
        n(new com.byazt.wg.qg.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
            @Override // com.byazt.wg.qg.n
            public void n() {
                if (TTVideoWebPageActivity.this.sz()) {
                    TTVideoWebPageActivity.this.fi.w();
                }
            }

            @Override // com.byazt.wg.qg.n
            public void n(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.k()) {
                    TTVideoWebPageActivity.this.fi.fs();
                }
            }

            @Override // com.byazt.wg.qg.n
            public void qg() {
                if (TTVideoWebPageActivity.this.k()) {
                    TTVideoWebPageActivity.this.fi.fs();
                }
            }
        }, true);
        this.oj = (FrameLayout) findViewById(2114387708);
        this.df = (RelativeLayout) findViewById(2114387943);
        this.y = (RelativeLayout) findViewById(2114387655);
        this.rf = (TextView) findViewById(2114387957);
        this.b = (TextView) findViewById(2114387764);
        this.lh = (TextView) findViewById(2114387686);
        this.dh = (RoundImageView) findViewById(2114387664);
        um();
        qg();
        if (this.ae != null && this.df != null && this.ae.df()) {
            this.df.setVisibility(8);
        }
        n(true);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void n(String str) {
        NativeVideoTsView nativeVideoTsView = this.f;
        com.byazt.hm.n.n(this.ae, com.byazt.wg.qg.AD_TAG_FEED, str, hd(), cd(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : w.n(this.ae, this.f.getNativeVideoController().d(), this.f.getNativeVideoController().hd()));
    }

    private void cy() {
        if (pk.s(this.ae)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f = new NativeVideoTsView(this.l != null ? this.l.getApplicationContext() : com.byazt.nf.rv.getContext(), this.ae, true, true);
                } else {
                    this.f = new NativeVideoTsView(this.l != null ? this.l.getApplicationContext() : com.byazt.nf.rv.getContext(), this.ae, true, false);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().n(false);
                    if (this.lq != null) {
                        this.f.getNativeVideoController().s(this.lq.n);
                    }
                }
                this.f.setVideoAdInteractionListener(new com.byazt.po.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                    @Override // com.byazt.po.n, com.byazt.iag.s.InterfaceC0200s
                    public void n(long j, long j2) {
                        if (TTVideoWebPageActivity.this.ou()) {
                            com.byazt.vyf.s.cy().n(j);
                        }
                    }
                });
                if (!this.a) {
                    this.dg = 0L;
                }
                if (this.lq != null && this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().s(this.lq.x);
                    this.f.getNativeVideoController().q(this.lq.l);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().n(false);
                    this.f.getNativeVideoController().n(this.nf);
                    this.f.setIsQuiet(this.ae.kj() == 1);
                }
                if (this.f.n(this.dg, this.e, a())) {
                    this.oj.setVisibility(0);
                    this.oj.removeAllViews();
                    this.oj.addView(this.f);
                }
                if (a()) {
                    this.f.q(true);
                }
                this.fi = this.f.getNativeVideoController();
            } catch (Exception unused) {
            }
            if (hd.s(this.l.getApplicationContext()) == 0) {
                try {
                    h.n(this.l, "\"无网络，请稍后再试\"", 0);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private long hd() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.f.getNativeVideoController().sz();
    }

    private int cd() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f.getNativeVideoController().k();
    }

    private void um() {
        String strYr;
        if (this.ae == null || this.ae.rv() != 4) {
            return;
        }
        com.byazt.okk.s.n((View) this.y, 0);
        if (!TextUtils.isEmpty(this.ae.E_())) {
            strYr = this.ae.E_();
        } else if (!TextUtils.isEmpty(this.ae.m19if())) {
            strYr = this.ae.m19if();
        } else {
            strYr = !TextUtils.isEmpty(this.ae.yr()) ? this.ae.yr() : "";
        }
        v vVarXu = this.ae.xu();
        if (vVarXu != null && vVarXu.n() != null) {
            com.byazt.okk.s.n((View) this.dh, 0);
            com.byazt.okk.s.n((View) this.rf, 4);
            com.byazt.imu.s.n(vVarXu).n(this.dh);
        } else if (!TextUtils.isEmpty(strYr)) {
            com.byazt.okk.s.n((View) this.dh, 4);
            com.byazt.okk.s.n((View) this.rf, 0);
            this.rf.setText(strYr.substring(0, 1));
        }
        if (this.b != null && !TextUtils.isEmpty(strYr)) {
            this.b.setText(strYr);
        }
        if (!TextUtils.isEmpty(this.ae.jb())) {
            this.lh.setText(this.ae.jb());
        }
        com.byazt.okk.s.n((View) this.b, 0);
        if (ou()) {
            com.byazt.okk.s.n((View) this.lh, 8);
        } else {
            com.byazt.okk.s.n((View) this.lh, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public boolean fs() {
        NativeVideoTsView nativeVideoTsView;
        if (super.fs()) {
            return true;
        }
        if (this.ri && (nativeVideoTsView = this.f) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.byazt.iag.n) this.f.getNativeVideoController()).l(null, null);
            this.ri = false;
            return true;
        }
        n("detail_back");
        return false;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.ae != null ? this.ae.pv().toString() : null);
        bundle.putLong("video_play_position", this.dg);
        bundle.putBoolean("is_complete", a());
        long jCp = this.dg;
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jCp = this.f.getNativeVideoController().cp();
        }
        bundle.putLong("video_play_position", jCp);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e = false;
        if (this.pe && k() && py()) {
            this.pe = false;
            this.fi.fs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.pe && py()) {
                this.pe = true;
                this.fi.w();
            }
        } catch (Throwable th) {
            k.qg("BaseLandingPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        if (a() || ((nativeVideoTsView2 = this.f) != null && nativeVideoTsView2.getNativeVideoController() != null && this.f.getNativeVideoController().a())) {
            com.byazt.gwu.s sVarN = l.n(this.ae == null ? null : this.ae.mk(), "sp_multi_native_video_data");
            sVarN.n("key_video_is_update_flag", true);
            sVarN.n("key_native_video_complete", true);
            sVarN.n("key_video_isfromvideodetailpage", true);
        }
        if (a() || (nativeVideoTsView = this.f) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        n(this.f.getNativeVideoController());
    }

    private void n(s sVar) {
        k.qg("mutilproces", "initFeedNaitiveControllerData-isComplete=" + sVar.a() + ",position=" + sVar.cp() + ",totalPlayDuration=" + (sVar.sz() + sVar.d()) + ",duration=" + sVar.sz());
        com.byazt.gwu.s sVarN = l.n(this.ae == null ? null : this.ae.mk(), "sp_multi_native_video_data");
        sVarN.n("key_video_is_update_flag", true);
        sVarN.n("key_video_isfromvideodetailpage", true);
        sVarN.n("key_native_video_complete", sVar.a());
        sVarN.n("key_video_current_play_position", sVar.cp());
        sVarN.n("key_video_total_play_duration", sVar.sz() + sVar.d());
        sVarN.n("key_video_duration", sVar.sz());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        oa();
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.f.getNativeVideoController().tj();
        }
        NativeVideoTsView nativeVideoTsView2 = this.f;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.ou();
            this.f = null;
        }
        this.ae = null;
    }

    protected void d() {
        ((oa) com.byazt.qp.q.n("device_info_new")).n(this.cx);
    }

    protected void oa() {
        try {
            ((oa) com.byazt.qp.q.n("device_info_new")).qg(this.cx);
        } catch (Exception unused) {
        }
    }

    boolean sz() {
        s sVar = this.fi;
        return (sVar == null || sVar.hd() == null || !this.fi.hd().tj()) ? false : true;
    }

    protected boolean k() {
        s sVar = this.fi;
        return (sVar == null || sVar.hd() == null || !this.fi.hd().d()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.f.getNativeVideoController().a();
    }

    private boolean py() {
        return this.hu == null || !this.hu.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ou() {
        if (this.ae == null) {
            return false;
        }
        int iLa = this.ae.la();
        return this.q == 1 && "embeded_ad_landingpage".equals(this.s) && (iLa == 1 || iLa == 2);
    }
}
