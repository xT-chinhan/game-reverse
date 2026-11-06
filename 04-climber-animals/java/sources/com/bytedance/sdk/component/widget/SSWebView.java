package com.bytedance.sdk.component.widget;

import android.content.Context;
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
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.web.BizWebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SSWebView extends BizWebView {
    private JSONObject ab;
    private float ao;
    private AtomicBoolean b;
    private String c;
    private float ch;
    private ah cv;
    private float h;
    private long hi;
    private AtomicBoolean i;
    private com.bytedance.sdk.component.widget.xr.ms ka;
    private JSONObject le;
    private b nw;
    private float ny;
    private JSONObject op;
    private int qv;
    private AtomicBoolean re;
    private long sl;
    private xr t;
    private boolean u;
    private float ub;
    private AtomicInteger w;
    private boolean x;
    private int y;
    private JSONObject yu;
    private long zb;

    public interface ah {
        void ms(boolean z);
    }

    public interface xr {
        void ms(int i);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public com.bytedance.sdk.component.widget.xr.ms getMaterialMeta() {
        return this.ka;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.xr.ms msVar) {
        this.ka = msVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.c;
    }

    public void setTag(String str) {
        this.c = str;
    }

    public void setLandingPage(boolean z) {
        this.x = z;
    }

    public void setTouchStateListener(ah ahVar) {
        this.cv = ahVar;
    }

    public SSWebView(Context context) {
        super(context);
        this.ny = 0.0f;
        this.ch = 0.0f;
        this.hi = 0L;
        this.sl = 0L;
        this.zb = 0L;
        this.u = false;
        this.ub = 20.0f;
        this.h = 50.0f;
        this.b = new AtomicBoolean();
        this.re = new AtomicBoolean();
        this.i = new AtomicBoolean(true);
        this.w = new AtomicInteger();
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void H_() {
        c();
        super.H_();
    }

    private void c() {
        this.nw = null;
        this.t = null;
        setTouchStateListener(null);
        J_();
        this.ka = null;
        this.ab = null;
        this.x = false;
    }

    public boolean I_() {
        b bVar = this.nw;
        if (bVar == null) {
            return false;
        }
        return bVar.ms();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.zb.ah
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof ah) {
            setTouchStateListener((ah) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new ms();
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentMs;
        try {
            ms(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.u && (viewParentMs = ms((View) this)) != null) {
                viewParentMs.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.u = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent ms(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (xr(view2) || ah(view2)) ? parent : ms(view2);
    }

    private static boolean xr(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            sl.ms(th2);
            return false;
        }
    }

    private boolean ah(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            sl.ms(th2);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.zb.ah
    public void onPause() {
        super.onPause();
        ah ahVar = this.cv;
        if (ahVar != null) {
            ahVar.ms(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ah ahVar = this.cv;
        if (ahVar != null) {
            ahVar.ms(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.zb.ah
    public void destroy() {
        super.destroy();
        c();
    }

    public void ms(int i, boolean z) {
        this.i.set(z);
        this.w.set(i);
        this.re.set(true);
        if (this.b.get()) {
            xr(i, z);
        }
    }

    private void xr(int i, boolean z) {
        b bVar = this.nw;
        if (bVar == null) {
            this.nw = new b(getContext(), i, z);
        } else {
            bVar.ms(z);
        }
        this.nw.ms(this.ub);
        this.nw.ah(this.ao);
        this.nw.xr(this.h);
        this.nw.ms(this.yu);
        this.nw.ah(this.op);
        this.nw.xr(this.le);
        this.nw.ka(this.qv);
        this.nw.c(this.y);
        this.nw.ms(new b.ms() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.b.ms
            public void ms(int i2) {
                if (i2 == 1) {
                    SSWebView.this.ms(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.ms(2);
                }
            }
        });
        b bVar2 = this.nw;
        com.bytedance.sdk.component.widget.xr.ms msVar = this.ka;
        bVar2.ah(msVar != null ? msVar.ms() : 0);
    }

    public void ms(int i) {
        xr xrVar = this.t;
        if (xrVar != null) {
            xrVar.ms(i);
        }
    }

    public void J_() {
        this.re.set(false);
        b bVar = this.nw;
        if (bVar != null) {
            com.bytedance.sdk.component.widget.xr.ms msVar = this.ka;
            bVar.d(msVar != null ? msVar.ms() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.set(true);
        if (this.re.get()) {
            xr(this.w.get(), this.i.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.set(false);
        b bVar = this.nw;
        if (bVar != null) {
            com.bytedance.sdk.component.widget.xr.ms msVar = this.ka;
            bVar.xr(msVar != null ? msVar.ms() : 0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        b bVar = this.nw;
        if (bVar != null) {
            if (z) {
                com.bytedance.sdk.component.widget.xr.ms msVar = this.ka;
                bVar.ms(msVar != null ? msVar.ms() : 0);
            } else {
                com.bytedance.sdk.component.widget.xr.ms msVar2 = this.ka;
                bVar.xr(msVar2 != null ? msVar2.ms() : 0);
            }
        }
    }

    private void ms(MotionEvent motionEvent) {
        if (!this.x || this.ka == null) {
            return;
        }
        if ((this.c == null && this.ab == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.ny = motionEvent.getRawX();
                this.ch = motionEvent.getRawY();
                this.hi = System.currentTimeMillis();
                this.ab = new JSONObject();
                if (this.xr != null) {
                    this.xr.setTag(2064056319, Long.valueOf(this.hi));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.ab.put("start_x", String.valueOf(this.ny));
                this.ab.put("start_y", String.valueOf(this.ch));
                this.ab.put("offset_x", String.valueOf(motionEvent.getRawX() - this.ny));
                this.ab.put("offset_y", String.valueOf(motionEvent.getRawY() - this.ch));
                this.ab.put("url", String.valueOf(getUrl()));
                this.ab.put(TTDownloadField.TT_TAG, "");
                this.sl = System.currentTimeMillis();
                if (this.xr != null) {
                    this.xr.setTag(2064056318, Long.valueOf(this.sl));
                }
                this.ab.put("down_time", this.hi);
                this.ab.put("up_time", this.sl);
                if (com.bytedance.sdk.component.widget.ms.ms.ms().xr() != null) {
                    long j = this.zb;
                    long j2 = this.hi;
                    if (j != j2) {
                        this.zb = j2;
                        com.bytedance.sdk.component.widget.ms.ms.ms();
                    }
                }
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public void setShakeValue(float f) {
        this.ub = f;
    }

    public void setDeepShakeValue(float f) {
        this.ao = f;
    }

    public void setWriggleValue(float f) {
        this.h = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.yu = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.op = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.le = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.qv = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.y = i;
    }

    public void setOnShakeListener(xr xrVar) {
        this.t = xrVar;
    }

    public static class ms extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
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
