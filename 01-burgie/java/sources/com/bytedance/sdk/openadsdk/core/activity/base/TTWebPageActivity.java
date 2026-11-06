package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.bs.TTViewStub;
import com.byazt.ca.iu;
import com.byazt.fj.SSWebView;
import com.byazt.fj.TTProgressBar;
import com.byazt.hb.uc;
import com.byazt.hg.jn;
import com.byazt.rg.BaseLandingPageActivity;
import com.byazt.sd.zo;
import com.byazt.vkw.qi;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.xhr.hn;
import com.byazt.xhr.hw;
import com.byazt.xhr.pr;
import com.byazt.xhr.x;

/* JADX INFO: loaded from: classes2.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements qi.pr {
    private static final String ls = TTWebPageActivity.class.getSimpleName();
    private ImageView er;
    private final iu ii = new iu(Looper.getMainLooper(), this);
    private int of;
    private boolean qi;
    private int qn;
    private boolean v;

    protected LinearLayout m() {
        return new LinearLayout(this.c);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public View fw() {
        if (this.c == null) {
            return null;
        }
        Resources resources = this.c.getResources();
        LinearLayout linearLayoutM = m();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayoutM.setOrientation(1);
        linearLayoutM.setLayoutParams(layoutParams);
        this.uc = new TTViewStub(this.c, new hw());
        this.uc.setId(2114387770);
        linearLayoutM.addView(this.uc, new LinearLayout.LayoutParams(-1, -2));
        this.fw = new TTViewStub(this.c, new hn());
        this.fw.setId(2114387792);
        linearLayoutM.addView(this.fw, new LinearLayout.LayoutParams(-1, -2));
        this.zo = new TTViewStub(this.c, new x());
        this.zo.setId(2114387933);
        linearLayoutM.addView(this.zo, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.c);
        linearLayoutM.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.ny = new SSWebView(this.c);
        this.ny.setMaterialMeta(e.pr(this.s));
        this.ny.setId(2114387733);
        this.ny.setLayoutParams(new FrameLayout.LayoutParams(-1, k()));
        frameLayout.addView(this.ny);
        try {
            this.ny.setBackgroundColor(0);
            this.ny.setBackgroundResource(R.color.transparent);
        } catch (Exception e) {
        }
        this.aj = new TTViewStub(this.c, new pr());
        this.aj.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.aj, layoutParams2);
        this.rc = new TTProgressBar(this.c, null, R.style.Widget.ProgressBar.Horizontal);
        this.rc.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.rc.setLayoutParams(layoutParams3);
        this.rc.setProgress(1);
        this.rc.setProgressDrawable(com.byazt.sdv.x.pr());
        frameLayout.addView(this.rc);
        return linearLayoutM;
    }

    protected int k() {
        return -1;
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void c() {
        g();
        boolean zNt = nt();
        pr(new com.byazt.pfl.hw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.byazt.pfl.hw.pr
            public void pr() {
                TTWebPageActivity.this.yb();
            }

            @Override // com.byazt.pfl.hw.pr
            public void pr(int i, String str, boolean z) {
                TTWebPageActivity.this.lb();
            }

            @Override // com.byazt.pfl.hw.pr
            public void hw() {
                TTWebPageActivity.this.lb();
            }
        }, !zNt);
        if (zNt) {
            ho();
        }
        hw();
        pr(false);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity
    public void uc() {
        super.uc();
        com.byazt.sb.hw.pr().pr(this.s);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        lb();
        hw(true);
    }

    @Override // com.byazt.rg.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        yb();
        hw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.byazt.sb.hw.pr().hw(this.s);
    }

    private void hw(boolean z) {
        if (this.s != null && this.s.kx() && this.b != null) {
            this.b.w(z);
        }
    }

    private void g() {
        this.qi = jn.qa(this.s);
        this.v = jn.lb(this.s) && !uc.hn;
        if (this.qi) {
            if (uc.x) {
                if (this.v) {
                    this.qi = false;
                }
            } else {
                this.v = false;
            }
        }
        if (this.v || this.qi) {
            if (this.zo != null) {
                this.zo.setVisibility(0);
            }
            this.er = (ImageView) findViewById(2114387843);
            return;
        }
        if (this.s != null && this.s.ls()) {
            if (this.uc != null) {
                this.uc.setVisibility(8);
            }
            if (this.fw != null) {
                this.fw.setVisibility(8);
            }
            return;
        }
        switch (zo.nt().gz()) {
            case 0:
                if (this.uc != null) {
                    this.uc.setVisibility(0);
                }
                break;
            case 1:
                if (this.fw != null) {
                    this.fw.setVisibility(0);
                }
                break;
        }
    }

    private void ho() {
        this.qn = 0;
        if (this.v) {
            this.qn = uc.pr;
        } else if (this.qi && !uc.x) {
            this.qn = jn.g(this.s);
        }
        hw(this.qn);
        if (this.qn > 0 && !this.ii.hasMessages(10)) {
            if (this.v) {
                this.ii.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.qi) {
                this.ii.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 10:
                if (nt()) {
                    int i = this.of + 1;
                    this.of = i;
                    if (this.v) {
                        uc.hw = i;
                    }
                    int iMax = Math.max(0, this.qn - this.of);
                    hw(iMax);
                    if (iMax <= 0 && this.qi) {
                        uc.x = true;
                    }
                    this.ii.sendEmptyMessageDelayed(10, 1000L);
                    break;
                }
                break;
        }
    }

    private boolean nt() {
        return this.v || this.qi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        if (nt()) {
            this.ii.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        if (nt() && !this.ii.hasMessages(10)) {
            this.ii.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    private void hw(int i) {
        if (i > 0) {
            if (this.v) {
                er.pr(this.nt, i + "s后可领取奖励");
                return;
            } else {
                if (this.qi) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    er.pr(this.nt, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.v) {
            er.pr(this.nt, "领取成功");
        } else if (this.qi) {
            er.pr((View) this.er, 8);
            er.pr(this.nt, "恭喜你！福利已领取");
        }
    }
}
