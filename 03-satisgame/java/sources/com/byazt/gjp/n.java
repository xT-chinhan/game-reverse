package com.byazt.gjp;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.kfh.SSWebView;
import com.byazt.udb.cp;
import com.byazt.udb.fs;
import com.byazt.udb.oa;
import com.byazt.udb.sz;
import com.byazt.udb.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2040, 19})
public abstract class n implements com.byazt.twc.n, cp, com.byazt.udb.q<SSWebView>, com.byazt.hne.n {
    public fs cp;
    public oa d;
    public String fs;
    public JSONObject n;
    public boolean oa;
    public boolean qg;
    public volatile x rv;
    public SSWebView s;
    public int sz;
    public boolean tj;
    public Context w;
    public String x;
    public int q = 8;
    public AtomicBoolean l = new AtomicBoolean(false);
    public boolean k = false;

    public void fs() {
    }

    public abstract void l();

    public void n(boolean z, int i) {
    }

    @Override // com.byazt.udb.q
    public int qg() {
        return 0;
    }

    public abstract void qg(int i);

    public void rv() {
    }

    public n(Context context, oa oaVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.tj = false;
        this.w = context;
        this.d = oaVar;
        this.x = oaVar.w();
        themeStatusBroadcastReceiver.n(this);
        if (com.byazt.twc.q.n()) {
            cp();
            return;
        }
        SSWebView sSWebViewD = d();
        this.s = sSWebViewD;
        if (sSWebViewD == null) {
            if (com.byazt.twc.q.getContext() != null) {
                this.s = new SSWebView(com.byazt.twc.q.getContext());
                return;
            }
            return;
        }
        this.tj = true;
    }

    private void cp() {
        if (this.w == null && com.byazt.twc.q.getContext() != null) {
            this.w = com.byazt.twc.q.getContext();
        }
        if (this.w != null) {
            SSWebView sSWebViewD = d();
            this.s = sSWebViewD;
            if (sSWebViewD == null) {
                this.s = new SSWebView(new MutableContextWrapper(this.w.getApplicationContext()));
            } else {
                this.tj = true;
            }
        }
    }

    private SSWebView d() {
        if (this.d.hu()) {
            return l.n().n(this.w, this.x);
        }
        return l.n().qg(this.w, this.x);
    }

    private void oa() {
        if (this.d.hu()) {
            l.n().qg(this.s);
        } else {
            l.n().s(this.s);
        }
    }

    public void n(String str) {
        this.fs = str;
    }

    public SSWebView n() {
        return this.s;
    }

    public void n(fs fsVar) {
        this.cp = fsVar;
    }

    @Override // com.byazt.udb.q
    public void n(x xVar) {
        this.rv = xVar;
        if (n() == null || n().getWebView() == null) {
            this.rv.n(102, "SSWebview null is " + (n() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.fs)) {
            this.rv.n(102, "url is empty");
            return;
        }
        if (!this.d.hu()) {
            if (!this.k && !com.byazt.mzw.qg.n(this.n)) {
                this.rv.n(103, "data null is " + (this.n == null));
                return;
            } else if (this.k && !com.byazt.mzw.qg.s(this.n)) {
                this.rv.n(103, "choice ad data null is " + (this.n == null));
                return;
            }
        } else if (qg() == 9 && !com.byazt.mzw.qg.qg(this.n)) {
            this.rv.n(103, "data null is " + (this.n == null));
            return;
        }
        this.d.x().qg(this.tj);
        if (this.tj) {
            try {
                this.s.clearView();
                this.d.x().x();
                com.byazt.tk.oa.n(this.s.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                l.n().l(this.s);
                this.rv.n(102, "load exception is " + e.getMessage());
                return;
            }
        }
        SSWebView sSWebViewN = n();
        sSWebViewN.clearView();
        this.d.x().x();
        sSWebViewN.loadUrl(this.fs);
    }

    @Override // com.byazt.udb.q
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public SSWebView w() {
        return n();
    }

    @Override // com.byazt.udb.q
    public void n(boolean z) {
        if (this.l.get()) {
            return;
        }
        this.l.set(true);
        l();
        if (this.s.getParent() != null) {
            ((ViewGroup) this.s.getParent()).removeView(this.s);
        }
        if (this.qg) {
            oa();
        } else {
            l.n().l(this.s);
        }
    }

    public void q() {
        if (n() == null) {
            return;
        }
        try {
            n().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void qg(boolean z) {
        this.oa = z;
    }

    @Override // com.byazt.udb.cp
    public void n(final sz szVar) {
        if (szVar == null) {
            if (this.rv != null) {
                this.rv.n(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zS = szVar.s();
        final float fQ = (float) szVar.q();
        final float fL = (float) szVar.l();
        if (qg() == 0 && (fQ <= 0.0f || fL <= 0.0f)) {
            if (this.rv != null) {
                this.rv.n(105, "width is " + fQ + "height is " + fL);
            }
        } else {
            this.qg = zS;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(szVar, fQ, fL);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.gjp.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n(szVar, fQ, fL);
                    }
                });
            }
        }
    }

    public void n(sz szVar, float f, float f2) {
        n(this.qg, szVar.cp());
        boolean z = this.qg;
        if (z && !this.oa) {
            n(f, f2);
            qg(this.q);
            if (this.rv != null) {
                this.rv.n(n(), szVar);
                return;
            }
            return;
        }
        if (!z) {
            l.n().l(this.s);
        }
        n(szVar.cp(), szVar.tj());
    }

    @Override // com.byazt.udb.cp
    public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
        fs fsVar = this.cp;
        if (fsVar != null) {
            fsVar.n(view, i, sVar, i2);
        }
    }

    @Override // com.byazt.udb.cp
    public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
        fs fsVar = this.cp;
        if (fsVar != null) {
            fsVar.qg(view, i, sVar, i2);
        }
    }

    public void n(float f, float f2) {
        this.d.x().fs();
        if (com.byazt.twc.q.n() && qg() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) n().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            n().setLayoutParams(layoutParams);
            return;
        }
        int iN = (int) com.byazt.cq.fs.n(this.w, f);
        int iN2 = (int) com.byazt.cq.fs.n(this.w, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) n().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iN, iN2);
        }
        layoutParams2.width = iN;
        layoutParams2.height = iN2;
        n().setLayoutParams(layoutParams2);
    }

    private void n(int i, String str) {
        if (this.rv != null) {
            this.rv.n(i, str);
        }
    }

    private int qg(Activity activity) {
        return activity.hashCode();
    }

    public void x() {
        fs();
        Activity activityN = com.byazt.tk.n.n(this.s);
        if (activityN != null) {
            this.sz = qg(activityN);
        }
    }

    @Override // com.byazt.twc.n
    public void n(Activity activity) {
        if (this.sz == 0 || activity == null || activity.hashCode() != this.sz) {
            return;
        }
        n(true);
        rv();
    }

    public oa tj() {
        return this.d;
    }
}
