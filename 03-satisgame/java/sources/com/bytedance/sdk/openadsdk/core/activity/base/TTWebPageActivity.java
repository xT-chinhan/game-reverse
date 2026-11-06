package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.byazt.gct.cx;
import com.byazt.kfh.SSWebView;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lv.n;
import com.byazt.lv.q;
import com.byazt.lv.qg;
import com.byazt.lv.s;
import com.byazt.lz.TTViewStub;
import com.byazt.pt.BaseLandingPageActivity;
import com.byazt.tk.t;
import com.byazt.vf.wo;

/* JADX INFO: loaded from: classes2.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements wo.n {
    private static final String f = "TTWebPageActivity";
    private boolean df;
    private int dg;
    private ImageView fi;
    private boolean oj;
    private final t pk = new t(Looper.getMainLooper(), this);
    private int u;

    protected int d() {
        return -1;
    }

    protected LinearLayout oa() {
        return new LinearLayout(this.l);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public View x() {
        if (this.l == null) {
            return null;
        }
        Resources resources = this.l.getResources();
        LinearLayout linearLayoutOa = oa();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayoutOa.setOrientation(1);
        linearLayoutOa.setLayoutParams(layoutParams);
        this.w = new TTViewStub(this.l, new qg());
        this.w.setId(2114387770);
        linearLayoutOa.addView(this.w, new LinearLayout.LayoutParams(-1, -2));
        this.x = new TTViewStub(this.l, new s());
        this.x.setId(2114387792);
        linearLayoutOa.addView(this.x, new LinearLayout.LayoutParams(-1, -2));
        this.fs = new TTViewStub(this.l, new q());
        this.fs.setId(2114387933);
        linearLayoutOa.addView(this.fs, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.l);
        linearLayoutOa.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.ou = new SSWebView(this.l);
        this.ou.setMaterialMeta(com.byazt.cd.s.n(this.ae));
        this.ou.setId(2114387733);
        this.ou.setLayoutParams(new FrameLayout.LayoutParams(-1, d()));
        frameLayout.addView(this.ou);
        try {
            this.ou.setBackgroundColor(0);
            this.ou.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        this.rv = new TTViewStub(this.l, new n());
        this.rv.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.rv, layoutParams2);
        this.m = new TTProgressBar(this.l, null, R.style.Widget.ProgressBar.Horizontal);
        this.m.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.m.setLayoutParams(layoutParams3);
        this.m.setProgress(1);
        this.m.setProgressDrawable(com.byazt.cb.n.n());
        frameLayout.addView(this.m);
        return linearLayoutOa;
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void l() {
        sz();
        boolean zCy = cy();
        n(new com.byazt.wg.qg.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.byazt.wg.qg.n
            public void n() {
                TTWebPageActivity.this.hd();
            }

            @Override // com.byazt.wg.qg.n
            public void n(int i, String str, boolean z) {
                TTWebPageActivity.this.cd();
            }

            @Override // com.byazt.wg.qg.n
            public void qg() {
                TTWebPageActivity.this.cd();
            }
        }, !zCy);
        if (zCy) {
            k();
        }
        qg();
        n(false);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity
    public void w() {
        super.w();
        com.byazt.ltk.n.n().n(this.ae);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        cd();
        qg(true);
    }

    @Override // com.byazt.pt.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        hd();
        qg(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.byazt.ltk.n.n().qg(this.ae);
    }

    private void qg(boolean z) {
        if (this.ae == null || !this.ae.se() || this.h == null) {
            return;
        }
        this.h.cp(z);
    }

    private void sz() {
        this.oj = cx.um(this.ae);
        this.df = cx.cd(this.ae) && !com.byazt.rv.s.s;
        if (this.oj) {
            if (com.byazt.rv.s.q) {
                if (this.df) {
                    this.oj = false;
                }
            } else {
                this.df = false;
            }
        }
        if (this.df || this.oj) {
            if (this.fs != null) {
                this.fs.setVisibility(0);
            }
            this.fi = (ImageView) findViewById(2114387843);
            return;
        }
        if (this.ae != null && this.ae.df()) {
            if (this.w != null) {
                this.w.setVisibility(8);
            }
            if (this.x != null) {
                this.x.setVisibility(8);
                return;
            }
            return;
        }
        int iBb = com.byazt.vyf.s.cy().bb();
        if (iBb == 0) {
            if (this.w != null) {
                this.w.setVisibility(0);
            }
        } else if (iBb == 1 && this.x != null) {
            this.x.setVisibility(0);
        }
    }

    private void k() {
        this.dg = 0;
        if (this.df) {
            this.dg = com.byazt.rv.s.n;
        } else if (this.oj && !com.byazt.rv.s.q) {
            this.dg = cx.sz(this.ae);
        }
        qg(this.dg);
        if (this.dg > 0 && !this.pk.hasMessages(10)) {
            if (this.df) {
                this.pk.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.oj) {
                this.pk.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 10 && cy()) {
            int i = this.u + 1;
            this.u = i;
            if (this.df) {
                com.byazt.rv.s.qg = i;
            }
            int iMax = Math.max(0, this.dg - this.u);
            qg(iMax);
            if (iMax <= 0 && this.oj) {
                com.byazt.rv.s.q = true;
            }
            this.pk.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    private boolean cy() {
        return this.df || this.oj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        if (cy()) {
            this.pk.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        if (!cy() || this.pk.hasMessages(10)) {
            return;
        }
        this.pk.sendEmptyMessageDelayed(10, 1000L);
    }

    private void qg(int i) {
        if (i > 0) {
            if (this.df) {
                com.byazt.okk.s.n(this.cy, i + "s后可领取奖励");
                return;
            } else {
                if (this.oj) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    com.byazt.okk.s.n(this.cy, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.df) {
            com.byazt.okk.s.n(this.cy, "领取成功");
        } else if (this.oj) {
            com.byazt.okk.s.n((View) this.fi, 8);
            com.byazt.okk.s.n(this.cy, "恭喜你！福利已领取");
        }
    }
}
