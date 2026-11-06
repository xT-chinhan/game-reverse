package com.bytedance.sdk.component.adexpress.ka;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.ms.w;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static int ab = 10;
    private static int c = 10;
    private static final byte[] ka = new byte[0];
    private static volatile ka ny;
    private final AtomicBoolean x = new AtomicBoolean(false);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<SSWebView> f882ms = new ArrayList();
    private final List<SSWebView> xr = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.zb.ah, ah> ah = new WeakHashMap<>();
    private final WeakHashMap<com.bytedance.sdk.component.zb.ah, d> d = new WeakHashMap<>();

    private ka() {
        com.bytedance.sdk.component.adexpress.ms.ms.ah ahVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah();
        if (ahVarAh != null) {
            c = ahVarAh.x();
            ab = ahVarAh.ny();
        }
    }

    public static ka ms() {
        if (ny == null) {
            synchronized (ka.class) {
                if (ny == null) {
                    ny = new ka();
                }
            }
        }
        return ny;
    }

    public SSWebView ms(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (d() <= 0 || (sSWebViewRemove = this.xr.remove(0)) == null) {
            return null;
        }
        this.xr.size();
        return sSWebViewRemove;
    }

    public void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.xr.size() >= ab) {
            sSWebView.destroy();
        } else {
            if (this.xr.contains(sSWebView)) {
                return;
            }
            this.xr.add(sSWebView);
            this.xr.size();
        }
    }

    public void xr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.H_();
        c(sSWebView);
        ms(sSWebView);
    }

    public SSWebView xr(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (ah() <= 0 || (sSWebViewRemove = this.f882ms.remove(0)) == null) {
            return null;
        }
        ah();
        return sSWebViewRemove;
    }

    public void ah(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.H_();
        c(sSWebView);
        d(sSWebView);
    }

    public void d(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.f882ms.size() >= c) {
            sSWebView.destroy();
        } else {
            if (this.f882ms.contains(sSWebView)) {
                return;
            }
            this.f882ms.add(sSWebView);
            ah();
        }
    }

    public boolean ka(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void xr() {
        for (SSWebView sSWebView : this.f882ms) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.f882ms.clear();
        for (SSWebView sSWebView2 : this.xr) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.xr.clear();
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public int ah() {
        return this.f882ms.size();
    }

    public int d() {
        return this.xr.size();
    }

    public int ka() {
        return this.f882ms.size() + d();
    }

    public void ms(SSWebView sSWebView, xr xrVar) {
        if (sSWebView == null || xrVar == null) {
            return;
        }
        ah ahVar = this.ah.get(sSWebView);
        if (ahVar != null) {
            ahVar.ms(xrVar);
        } else {
            ahVar = new ah(xrVar);
            this.ah.put(sSWebView, ahVar);
        }
        sSWebView.addJavascriptInterface(ahVar, "SDK_INJECT_GLOBAL");
    }

    public void c(SSWebView sSWebView) {
        ah ahVar;
        if (sSWebView == null || (ahVar = this.ah.get(sSWebView)) == null) {
            return;
        }
        ahVar.ms(null);
    }

    private static void ms(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            x.xr().post(runnable);
        }
    }

    public void ms(final com.bytedance.sdk.component.zb.ah ahVar, w wVar, final String str) {
        final d dVar;
        if (ahVar == null || wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            dVar = this.d.get(ahVar);
            if (dVar != null) {
                dVar.ms(wVar);
            } else {
                dVar = new d(wVar);
                this.d.put(ahVar, dVar);
            }
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ka.ka.1
            @Override // java.lang.Runnable
            public void run() {
                ahVar.addJavascriptInterface(dVar, str);
            }
        });
    }

    public void ms(final com.bytedance.sdk.component.zb.ah ahVar, final String str) {
        if (ahVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            d dVar = this.d.get(ahVar);
            if (dVar != null) {
                dVar.ms(null);
            }
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ka.ka.2
            @Override // java.lang.Runnable
            public void run() {
                ahVar.removeJavascriptInterface(str);
            }
        });
    }
}
