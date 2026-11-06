package com.bytedance.sdk.component.adexpress.ka;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xr.ab;
import com.bytedance.sdk.component.adexpress.xr.hi;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.adexpress.xr.x;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements com.bytedance.sdk.component.adexpress.ms, com.bytedance.sdk.component.adexpress.theme.ms, com.bytedance.sdk.component.adexpress.xr.d<SSWebView>, hi {
    private String ab;
    protected SSWebView ah;
    private Context c;
    private boolean ch;
    private x hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected JSONObject f885ms;
    private volatile ab ny;
    private zb sl;
    private int u;
    private String x;
    protected boolean xr;
    private boolean zb;
    protected int d = 8;
    protected AtomicBoolean ka = new AtomicBoolean(false);
    private boolean ub = false;

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public int ah() {
        return 0;
    }

    public abstract void c();

    protected void ch() {
    }

    protected void ms(boolean z, int i) {
    }

    protected void ny() {
    }

    public abstract void xr(int i);

    public ms(Context context, zb zbVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.ch = false;
        this.c = context;
        this.sl = zbVar;
        this.ab = zbVar.c();
        themeStatusBroadcastReceiver.ms(this);
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            sl();
            return;
        }
        SSWebView sSWebViewZb = zb();
        this.ah = sSWebViewZb;
        if (sSWebViewZb == null) {
            if (com.bytedance.sdk.component.adexpress.d.getContext() != null) {
                this.ah = new SSWebView(com.bytedance.sdk.component.adexpress.d.getContext());
                return;
            }
            return;
        }
        this.ch = true;
    }

    private void sl() {
        if (this.c == null && com.bytedance.sdk.component.adexpress.d.getContext() != null) {
            this.c = com.bytedance.sdk.component.adexpress.d.getContext();
        }
        if (this.c != null) {
            SSWebView sSWebViewZb = zb();
            this.ah = sSWebViewZb;
            if (sSWebViewZb == null) {
                this.ah = new SSWebView(new MutableContextWrapper(this.c.getApplicationContext()));
            } else {
                this.ch = true;
            }
        }
    }

    private SSWebView zb() {
        if (this.sl.yu()) {
            return ka.ms().ms(this.c, this.ab);
        }
        return ka.ms().xr(this.c, this.ab);
    }

    private void u() {
        if (this.sl.yu()) {
            ka.ms().xr(this.ah);
        } else {
            ka.ms().ah(this.ah);
        }
    }

    public void ms(String str) {
        this.x = str;
    }

    public SSWebView ms() {
        return this.ah;
    }

    public void ms(x xVar) {
        this.hi = xVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public void ms(ab abVar) {
        this.ny = abVar;
        if (ms() == null || ms().getWebView() == null) {
            this.ny.ms(102, "SSWebview null is " + (ms() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.x)) {
            this.ny.ms(102, "url is empty");
            return;
        }
        if (!this.sl.yu()) {
            if (!this.ub && !com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(this.f885ms)) {
                this.ny.ms(103, "data null is " + (this.f885ms == null));
                return;
            } else if (this.ub && !com.bytedance.sdk.component.adexpress.ms.xr.xr.ah(this.f885ms)) {
                this.ny.ms(103, "choice ad data null is " + (this.f885ms == null));
                return;
            }
        } else if (ah() == 9 && !com.bytedance.sdk.component.adexpress.ms.xr.xr.xr(this.f885ms)) {
            this.ny.ms(103, "data null is " + (this.f885ms == null));
            return;
        }
        this.sl.ab().xr(this.ch);
        if (this.ch) {
            try {
                this.ah.clearView();
                this.sl.ab().ab();
                com.bytedance.sdk.component.utils.hi.ms(this.ah.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                ka.ms().ka(this.ah);
                this.ny.ms(102, "load exception is " + e.getMessage());
                return;
            }
        }
        SSWebView sSWebViewMs = ms();
        sSWebViewMs.clearView();
        this.sl.ab().ab();
        sSWebViewMs.loadUrl(this.x);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public SSWebView ab() {
        return ms();
    }

    public void d() {
        if (this.ka.get()) {
            return;
        }
        this.ka.set(true);
        c();
        if (this.ah.getParent() != null) {
            ((ViewGroup) this.ah.getParent()).removeView(this.ah);
        }
        if (this.xr) {
            u();
        } else {
            ka.ms().ka(this.ah);
        }
    }

    public void ka() {
        if (ms() == null) {
            return;
        }
        try {
            ms().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void ms(boolean z) {
        this.zb = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(final u uVar) {
        if (uVar == null) {
            if (this.ny != null) {
                this.ny.ms(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zAh = uVar.ah();
        final float fD = (float) uVar.d();
        final float fKa = (float) uVar.ka();
        if (ah() == 0 && (fD <= 0.0f || fKa <= 0.0f)) {
            if (this.ny != null) {
                this.ny.ms(105, "width is " + fD + "height is " + fKa);
            }
        } else {
            this.xr = zAh;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ms(uVar, fD, fKa);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ka.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.ms(uVar, fD, fKa);
                    }
                });
            }
        }
    }

    protected void ms(u uVar, float f, float f2) {
        ms(this.xr, uVar.hi());
        boolean z = this.xr;
        if (z && !this.zb) {
            ms(f, f2);
            xr(this.d);
            if (this.ny != null) {
                this.ny.ms(ms(), uVar);
                return;
            }
            return;
        }
        if (!z) {
            ka.ms().ka(this.ah);
        }
        ms(uVar.hi(), uVar.ch());
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
        x xVar = this.hi;
        if (xVar != null) {
            xVar.ms(view, i, ahVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.hi
    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
        x xVar = this.hi;
        if (xVar != null) {
            xVar.ms(view, i, ahVar, i2);
        }
    }

    protected void ms(float f, float f2) {
        this.sl.ab().x();
        if (com.bytedance.sdk.component.adexpress.d.ms() && ah() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ms().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            ms().setLayoutParams(layoutParams);
            return;
        }
        int iMs = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.c, f);
        int iMs2 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.c, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ms().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iMs, iMs2);
        }
        layoutParams2.width = iMs;
        layoutParams2.height = iMs2;
        ms().setLayoutParams(layoutParams2);
    }

    private void ms(int i, String str) {
        if (this.ny != null) {
            this.ny.ms(i, str);
        }
    }

    private int xr(Activity activity) {
        return activity.hashCode();
    }

    public void x() {
        ny();
        Activity activityMs = com.bytedance.sdk.component.utils.xr.ms(this.ah);
        if (activityMs != null) {
            this.u = xr(activityMs);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ms
    public void ms(Activity activity) {
        if (this.u == 0 || activity == null || activity.hashCode() != this.u) {
            return;
        }
        d();
        ch();
    }

    public zb hi() {
        return this.sl;
    }
}
