package com.byazt.kq;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.fj.SSWebView;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.mq.fw;
import com.byazt.mq.g;
import com.byazt.mq.m;
import com.byazt.mq.w;
import com.byazt.mq.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 37})
public abstract class pr implements w, com.byazt.mq.x<SSWebView>, com.byazt.dj.pr, com.byazt.mo.pr {
    public volatile fw aj;
    public String fw;
    public int g;
    public SSWebView hn;
    public boolean hw;
    public m k;
    public boolean m;
    public JSONObject pr;
    public Context uc;
    public boolean vk;
    public zo w;
    public String zo;
    public int x = 8;
    public AtomicBoolean c = new AtomicBoolean(false);
    public boolean ho = false;

    public abstract void c();

    public abstract void hw(int i);

    public pr(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.vk = false;
        this.uc = context;
        this.k = mVar;
        this.fw = mVar.uc();
        themeStatusBroadcastReceiver.pr(this);
        if (com.byazt.dj.x.pr()) {
            w();
            return;
        }
        SSWebView sSWebViewK = k();
        this.hn = sSWebViewK;
        if (sSWebViewK == null) {
            if (com.byazt.dj.x.getContext() != null) {
                this.hn = new SSWebView(com.byazt.dj.x.getContext());
                return;
            }
            return;
        }
        this.vk = true;
    }

    private void w() {
        if (this.uc == null && com.byazt.dj.x.getContext() != null) {
            this.uc = com.byazt.dj.x.getContext();
        }
        if (this.uc != null) {
            SSWebView sSWebViewK = k();
            this.hn = sSWebViewK;
            if (sSWebViewK == null) {
                this.hn = new SSWebView(new MutableContextWrapper(this.uc.getApplicationContext()));
            } else {
                this.vk = true;
            }
        }
    }

    private SSWebView k() {
        if (this.k.z()) {
            return c.pr().pr(this.uc, this.fw);
        }
        return c.pr().hw(this.uc, this.fw);
    }

    private void m() {
        if (this.k.z()) {
            c.pr().hw(this.hn);
        } else {
            c.pr().hn(this.hn);
        }
    }

    public void pr(String str) {
        this.zo = str;
    }

    public SSWebView pr() {
        return this.hn;
    }

    public void pr(zo zoVar) {
        this.w = zoVar;
    }

    @Override // com.byazt.mq.x
    public void pr(fw fwVar) {
        this.aj = fwVar;
        if (pr() == null || pr().getWebView() == null) {
            this.aj.pr(102, "SSWebview null is " + (pr() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.zo)) {
            this.aj.pr(102, "url is empty");
            return;
        }
        if (!this.k.z()) {
            if (!this.ho && !com.byazt.ce.hw.pr(this.pr)) {
                this.aj.pr(103, "data null is " + (this.pr == null));
                return;
            } else if (this.ho && !com.byazt.ce.hw.hn(this.pr)) {
                this.aj.pr(103, "choice ad data null is " + (this.pr == null));
                return;
            }
        } else if (hw() == 9 && !com.byazt.ce.hw.hw(this.pr)) {
            this.aj.pr(103, "data null is " + (this.pr == null));
            return;
        }
        this.k.fw().hw(this.vk);
        if (this.vk) {
            try {
                this.hn.clearView();
                this.k.fw().fw();
                com.byazt.ca.m.pr(this.hn.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                c.pr().c(this.hn);
                this.aj.pr(102, "load exception is " + e.getMessage());
                return;
            }
        }
        SSWebView sSWebViewPr = pr();
        sSWebViewPr.clearView();
        this.k.fw().fw();
        sSWebViewPr.loadUrl(this.zo);
    }

    @Override // com.byazt.mq.x
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public SSWebView uc() {
        return pr();
    }

    @Override // com.byazt.mq.x
    public void pr(boolean z) {
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        c();
        if (this.hn.getParent() != null) {
            ((ViewGroup) this.hn.getParent()).removeView(this.hn);
        }
        if (this.hw) {
            m();
        } else {
            c.pr().c(this.hn);
        }
    }

    @Override // com.byazt.mq.x
    public int hw() {
        return 0;
    }

    public void x() {
        if (pr() == null) {
            return;
        }
        try {
            pr().getWebView().resumeTimers();
        } catch (Exception e) {
        }
    }

    public void hw(boolean z) {
        this.m = z;
    }

    @Override // com.byazt.mq.w
    public void pr(final g gVar) {
        if (gVar == null) {
            if (this.aj != null) {
                this.aj.pr(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zHn = gVar.hn();
        final float fX = (float) gVar.x();
        final float fC = (float) gVar.c();
        if (hw() == 0 && (fX <= 0.0f || fC <= 0.0f)) {
            if (this.aj != null) {
                this.aj.pr(105, "width is " + fX + "height is " + fC);
            }
        } else {
            this.hw = zHn;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                pr(gVar, fX, fC);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.kq.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.pr(gVar, fX, fC);
                    }
                });
            }
        }
    }

    public void pr(g gVar, float f, float f2) {
        pr(this.hw, gVar.w());
        boolean z = this.hw;
        if (z && !this.m) {
            pr(f, f2);
            hw(this.x);
            if (this.aj != null) {
                this.aj.pr(pr(), gVar);
                return;
            }
            return;
        }
        if (!z) {
            c.pr().c(this.hn);
        }
        pr(gVar.w(), gVar.vk());
    }

    public void pr(boolean z, int i) {
    }

    @Override // com.byazt.mq.w
    public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        zo zoVar = this.w;
        if (zoVar != null) {
            zoVar.pr(view, i, hnVar, i2);
        }
    }

    @Override // com.byazt.mq.w
    public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
        zo zoVar = this.w;
        if (zoVar != null) {
            zoVar.hw(view, i, hnVar, i2);
        }
    }

    public void pr(float f, float f2) {
        this.k.fw().zo();
        if (com.byazt.dj.x.pr() && hw() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pr().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            pr().setLayoutParams(layoutParams);
            return;
        }
        int iPr = (int) com.byazt.js.zo.pr(this.uc, f);
        int iPr2 = (int) com.byazt.js.zo.pr(this.uc, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) pr().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iPr, iPr2);
        }
        layoutParams2.width = iPr;
        layoutParams2.height = iPr2;
        pr().setLayoutParams(layoutParams2);
    }

    private void pr(int i, String str) {
        if (this.aj != null) {
            this.aj.pr(i, str);
        }
    }

    private int hw(Activity activity) {
        return activity.hashCode();
    }

    public void fw() {
        zo();
        Activity activityPr = com.byazt.ca.pr.pr(this.hn);
        if (activityPr != null) {
            this.g = hw(activityPr);
        }
    }

    public void zo() {
    }

    public void aj() {
    }

    @Override // com.byazt.dj.pr
    public void pr(Activity activity) {
        if (this.g != 0 && activity != null && activity.hashCode() == this.g) {
            pr(true);
            aj();
        }
    }

    public m vk() {
        return this.k;
    }
}
