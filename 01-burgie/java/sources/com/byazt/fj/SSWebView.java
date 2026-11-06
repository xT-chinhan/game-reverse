package com.byazt.fj;

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
import com.byazt.ca.ny;
import com.byazt.son.x;
import com.byazt.su.BizWebView;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 102, 2297})
public class SSWebView extends BizWebView {
    public static final AtomicInteger c = new AtomicInteger(0);
    public int a;
    public JSONObject aj;
    public AtomicBoolean b;
    public int cz;
    public ny fo;
    public com.byazt.st.pr fw;
    public long g;
    public JSONObject gz;
    public long ho;
    public AtomicInteger iu;
    public float k;
    public float lb;
    public long m;
    public JSONObject nl;
    public boolean nt;
    public hw ny;
    public float qa;
    public AtomicBoolean rc;
    public final AtomicBoolean uc;
    public JSONObject ve;
    public boolean vk;
    public float w;
    public hn y;
    public float yb;
    public AtomicBoolean z;
    public String zo;

    public interface hn {
        void pr(MotionEvent motionEvent);

        void pr(boolean z);
    }

    public interface hw {
        void pr(int i);
    }

    public static int getAliveCount() {
        int i = c.get();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public com.byazt.st.pr getMaterialMeta() {
        return this.fw;
    }

    public void setMaterialMeta(com.byazt.st.pr prVar) {
        this.fw = prVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.zo;
    }

    public void setTag(String str) {
        this.zo = str;
    }

    public void setLandingPage(boolean z) {
        this.vk = z;
    }

    public void setTouchStateListener(hn hnVar) {
        this.y = hnVar;
    }

    public SSWebView(Context context) {
        super(context);
        this.uc = new AtomicBoolean(false);
        c.incrementAndGet();
        this.w = 0.0f;
        this.k = 0.0f;
        this.m = 0L;
        this.g = 0L;
        this.ho = 0L;
        this.nt = false;
        this.yb = 20.0f;
        this.qa = 50.0f;
        this.rc = new AtomicBoolean();
        this.z = new AtomicBoolean();
        this.b = new AtomicBoolean(true);
        this.iu = new AtomicInteger();
    }

    @Override // com.byazt.su.BizWebView, com.byazt.su.MultiWebview
    public void S_() {
        uc();
        super.S_();
    }

    private void uc() {
        this.fo = null;
        this.ny = null;
        setTouchStateListener(null);
        U_();
        this.fw = null;
        this.aj = null;
        this.vk = false;
    }

    public boolean T_() {
        ny nyVar = this.fo;
        if (nyVar == null) {
            return false;
        }
        return nyVar.pr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.su.BizWebView, com.byazt.son.x
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof hn) {
            setTouchStateListener((hn) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new pr();
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentPr;
        try {
            pr(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.nt && (viewParentPr = pr((View) this)) != null) {
                viewParentPr.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable th) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.nt = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent pr(View view) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof AbsListView) && !(parent instanceof ScrollView) && !(parent instanceof HorizontalScrollView) && (parent instanceof View)) {
            View view2 = (View) parent;
            if (hw(view2) || hn(view2)) {
                return parent;
            }
            return pr(view2);
        }
        return parent;
    }

    private static boolean hw(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null && clsLoadClass2.isInstance(view)) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    private boolean hn(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null && clsLoadClass2.isInstance(view)) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.byazt.su.BizWebView, com.byazt.son.x
    public void onPause() {
        super.onPause();
        hn hnVar = this.y;
        if (hnVar != null) {
            hnVar.pr(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        hn hnVar = this.y;
        if (hnVar != null) {
            hnVar.pr(true);
            this.y.pr(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.byazt.su.BizWebView, com.byazt.su.MultiWebview, com.byazt.son.x
    public void destroy() {
        super.destroy();
        uc();
        if (this.uc.compareAndSet(false, true)) {
            c.decrementAndGet();
        }
    }

    public void pr(int i, boolean z) {
        this.b.set(z);
        this.iu.set(i);
        this.z.set(true);
        if (!this.rc.get()) {
            return;
        }
        hw(i, z);
    }

    private void hw(int i, boolean z) {
        ny nyVar = this.fo;
        if (nyVar == null) {
            this.fo = new ny(getContext(), i, z);
        } else {
            nyVar.pr(z);
        }
        this.fo.pr(this.yb);
        this.fo.hn(this.lb);
        this.fo.hw(this.qa);
        this.fo.pr(this.ve);
        this.fo.hn(this.gz);
        this.fo.hw(this.nl);
        this.fo.c(this.a);
        this.fo.uc(this.cz);
        this.fo.pr(new ny.pr() { // from class: com.byazt.fj.SSWebView.1
            @Override // com.byazt.ca.ny.pr
            public void pr(int i2) {
                switch (i2) {
                    case 1:
                        SSWebView.this.pr(1);
                        break;
                    case 2:
                        SSWebView.this.pr(2);
                        break;
                }
            }
        });
        ny nyVar2 = this.fo;
        com.byazt.st.pr prVar = this.fw;
        nyVar2.hn(prVar != null ? prVar.pr() : 0);
    }

    public void pr(int i) {
        hw hwVar = this.ny;
        if (hwVar != null) {
            hwVar.pr(i);
        }
    }

    public void U_() {
        this.z.set(false);
        ny nyVar = this.fo;
        if (nyVar != null) {
            com.byazt.st.pr prVar = this.fw;
            nyVar.x(prVar != null ? prVar.pr() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.rc.set(true);
        if (this.z.get()) {
            hw(this.iu.get(), this.b.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.rc.set(false);
        ny nyVar = this.fo;
        if (nyVar != null) {
            com.byazt.st.pr prVar = this.fw;
            nyVar.hw(prVar != null ? prVar.pr() : 0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ny nyVar = this.fo;
        if (nyVar != null) {
            if (z) {
                com.byazt.st.pr prVar = this.fw;
                nyVar.pr(prVar != null ? prVar.pr() : 0);
            } else {
                com.byazt.st.pr prVar2 = this.fw;
                nyVar.hw(prVar2 != null ? prVar2.pr() : 0);
            }
        }
    }

    private void pr(MotionEvent motionEvent) {
        if (!this.vk || this.fw == null) {
            return;
        }
        if ((this.zo == null && this.aj == null) || motionEvent == null) {
            return;
        }
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    this.w = motionEvent.getRawX();
                    this.k = motionEvent.getRawY();
                    this.m = System.currentTimeMillis();
                    this.aj = new JSONObject();
                    if (this.hw != null) {
                        this.hw.setTag(2064056319, Long.valueOf(this.m));
                    }
                    break;
                case 1:
                case 3:
                    this.aj.put("start_x", String.valueOf(this.w));
                    this.aj.put("start_y", String.valueOf(this.k));
                    this.aj.put("offset_x", String.valueOf(motionEvent.getRawX() - this.w));
                    this.aj.put("offset_y", String.valueOf(motionEvent.getRawY() - this.k));
                    this.aj.put(BreakpointSQLiteKey.URL, String.valueOf(getUrl()));
                    this.aj.put("tag", "");
                    this.g = System.currentTimeMillis();
                    if (this.hw != null) {
                        this.hw.setTag(2064056318, Long.valueOf(this.g));
                    }
                    this.aj.put("down_time", this.m);
                    this.aj.put("up_time", this.g);
                    if (com.byazt.ag.pr.pr().hw() != null) {
                        long j = this.ho;
                        long j2 = this.m;
                        if (j != j2) {
                            this.ho = j2;
                            com.byazt.ag.pr.pr();
                        }
                    }
                    break;
            }
        } catch (Throwable th) {
        }
    }

    public void setShakeValue(float f) {
        this.yb = f;
    }

    public void setDeepShakeValue(float f) {
        this.lb = f;
    }

    public void setWriggleValue(float f) {
        this.qa = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.gz = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.nl = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.a = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.cz = i;
    }

    public x getInnerIWebView() {
        return this.hw;
    }

    public void setOnShakeListener(hw hwVar) {
        this.ny = hwVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 102, 1238})
    public static class pr extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                return true;
            }
            return true;
        }
    }
}
