package com.byazt.kfh;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.byazt.qza.BizWebView;
import com.byazt.tk.ou;
import com.byazt.uad.q;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 484, 2483})
public class SSWebView extends BizWebView {
    public static final AtomicInteger l = new AtomicInteger(0);
    public int a;
    public JSONObject bb;
    public float cd;
    public float cp;
    public boolean cy;
    public float d;
    public String fs;
    public AtomicBoolean h;
    public float hd;
    public AtomicBoolean hu;
    public long k;
    public s lh;
    public JSONObject ln;
    public AtomicBoolean m;
    public long oa;
    public qg ou;
    public int py;
    public JSONObject rv;
    public long sz;
    public AtomicInteger t;
    public boolean tj;
    public float um;
    public JSONObject ur;
    public final AtomicBoolean w;
    public ou wm;
    public com.byazt.wrp.n x;

    public interface qg {
        void n(int i);
    }

    public interface s {
        void n(MotionEvent motionEvent);

        void n(boolean z);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public static int getAliveCount() {
        int i = l.get();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public com.byazt.wrp.n getMaterialMeta() {
        return this.x;
    }

    public void setMaterialMeta(com.byazt.wrp.n nVar) {
        this.x = nVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.fs;
    }

    public void setTag(String str) {
        this.fs = str;
    }

    public void setLandingPage(boolean z) {
        this.tj = z;
    }

    public void setTouchStateListener(s sVar) {
        this.lh = sVar;
    }

    public SSWebView(Context context) {
        super(context);
        this.w = new AtomicBoolean(false);
        l.incrementAndGet();
        this.cp = 0.0f;
        this.d = 0.0f;
        this.oa = 0L;
        this.sz = 0L;
        this.k = 0L;
        this.cy = false;
        this.hd = 20.0f;
        this.um = 50.0f;
        this.m = new AtomicBoolean();
        this.hu = new AtomicBoolean();
        this.h = new AtomicBoolean(true);
        this.t = new AtomicInteger();
    }

    @Override // com.byazt.qza.BizWebView, com.byazt.qza.MultiWebview
    public void S_() {
        w();
        super.S_();
    }

    private void w() {
        this.wm = null;
        this.ou = null;
        setTouchStateListener(null);
        U_();
        this.x = null;
        this.rv = null;
        this.tj = false;
    }

    public boolean T_() {
        ou ouVar = this.wm;
        if (ouVar == null) {
            return false;
        }
        return ouVar.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.qza.BizWebView, com.byazt.uad.q
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof s) {
            setTouchStateListener((s) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new n();
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentN;
        try {
            n(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.cy && (viewParentN = n((View) this)) != null) {
                viewParentN.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.cy = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent n(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (qg(view2) || s(view2)) ? parent : n(view2);
    }

    private static boolean qg(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    private boolean s(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // com.byazt.qza.BizWebView, com.byazt.uad.q
    public void onPause() {
        super.onPause();
        s sVar = this.lh;
        if (sVar != null) {
            sVar.n(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        s sVar = this.lh;
        if (sVar != null) {
            sVar.n(true);
            this.lh.n(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.byazt.qza.BizWebView, com.byazt.qza.MultiWebview, com.byazt.uad.q
    public void destroy() {
        super.destroy();
        w();
        if (this.w.compareAndSet(false, true)) {
            l.decrementAndGet();
        }
    }

    public void n(int i, boolean z) {
        this.h.set(z);
        this.t.set(i);
        this.hu.set(true);
        if (this.m.get()) {
            qg(i, z);
        }
    }

    private void qg(int i, boolean z) {
        ou ouVar = this.wm;
        if (ouVar == null) {
            this.wm = new ou(getContext(), i, z);
        } else {
            ouVar.n(z);
        }
        this.wm.n(this.hd);
        this.wm.s(this.cd);
        this.wm.qg(this.um);
        this.wm.n(this.ur);
        this.wm.s(this.bb);
        this.wm.qg(this.ln);
        this.wm.l(this.a);
        this.wm.w(this.py);
        this.wm.n(new ou.n() { // from class: com.byazt.kfh.SSWebView.1
            @Override // com.byazt.tk.ou.n
            public void n(int i2) {
                if (i2 == 1) {
                    SSWebView.this.n(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.n(2);
                }
            }
        });
        ou ouVar2 = this.wm;
        com.byazt.wrp.n nVar = this.x;
        ouVar2.s(nVar != null ? nVar.n() : 0);
    }

    public void n(int i) {
        qg qgVar = this.ou;
        if (qgVar != null) {
            qgVar.n(i);
        }
    }

    public void U_() {
        this.hu.set(false);
        ou ouVar = this.wm;
        if (ouVar != null) {
            com.byazt.wrp.n nVar = this.x;
            ouVar.q(nVar != null ? nVar.n() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m.set(true);
        if (this.hu.get()) {
            qg(this.t.get(), this.h.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m.set(false);
        ou ouVar = this.wm;
        if (ouVar != null) {
            com.byazt.wrp.n nVar = this.x;
            ouVar.qg(nVar != null ? nVar.n() : 0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ou ouVar = this.wm;
        if (ouVar != null) {
            if (z) {
                com.byazt.wrp.n nVar = this.x;
                ouVar.n(nVar != null ? nVar.n() : 0);
            } else {
                com.byazt.wrp.n nVar2 = this.x;
                ouVar.qg(nVar2 != null ? nVar2.n() : 0);
            }
        }
    }

    private void n(MotionEvent motionEvent) {
        if (!this.tj || this.x == null) {
            return;
        }
        if ((this.fs == null && this.rv == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.cp = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.oa = System.currentTimeMillis();
                this.rv = new JSONObject();
                if (this.qg != null) {
                    this.qg.setTag(2064056319, Long.valueOf(this.oa));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.rv.put("start_x", String.valueOf(this.cp));
                this.rv.put("start_y", String.valueOf(this.d));
                this.rv.put("offset_x", String.valueOf(motionEvent.getRawX() - this.cp));
                this.rv.put("offset_y", String.valueOf(motionEvent.getRawY() - this.d));
                this.rv.put(ImagesContract.URL, String.valueOf(getUrl()));
                this.rv.put("tag", "");
                this.sz = System.currentTimeMillis();
                if (this.qg != null) {
                    this.qg.setTag(2064056318, Long.valueOf(this.sz));
                }
                this.rv.put("down_time", this.oa);
                this.rv.put("up_time", this.sz);
                if (com.byazt.xe.n.n().qg() != null) {
                    long j = this.k;
                    long j2 = this.oa;
                    if (j != j2) {
                        this.k = j2;
                        com.byazt.xe.n.n();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f) {
        this.hd = f;
    }

    public void setDeepShakeValue(float f) {
        this.cd = f;
    }

    public void setWriggleValue(float f) {
        this.um = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.ur = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.bb = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.ln = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.a = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.py = i;
    }

    public q getInnerIWebView() {
        return this.qg;
    }

    public void setOnShakeListener(qg qgVar) {
        this.ou = qgVar;
    }

    @com.byazt.cp.n(n = {0, 1, 484, 1331})
    public static class n extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }
}
