package com.byazt.gjp;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.cf.m;
import com.byazt.kfh.SSWebView;
import com.byazt.tk.rv;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2040, 18})
public class l {
    public static final byte[] l = new byte[0];
    public static volatile l rv = null;
    public static int w = 10;
    public static int x = 10;
    public final AtomicBoolean fs = new AtomicBoolean(false);
    public final List<SSWebView> n = new ArrayList();
    public final List<SSWebView> qg = new ArrayList();
    public final WeakHashMap<com.byazt.uad.q, s> s = new WeakHashMap<>();
    public final WeakHashMap<com.byazt.uad.q, q> q = new WeakHashMap<>();

    private l() {
        com.byazt.gkj.s sVarS = com.byazt.gkj.n.n().s();
        if (sVarS != null) {
            w = sVarS.w();
            x = sVarS.x();
        }
    }

    public static l n() {
        if (rv == null) {
            synchronized (l.class) {
                if (rv == null) {
                    rv = new l();
                }
            }
        }
        return rv;
    }

    public SSWebView n(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (q() <= 0 || (sSWebViewRemove = this.qg.remove(0)) == null) {
            return null;
        }
        this.qg.size();
        return sSWebViewRemove;
    }

    public void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.qg.size() >= x) {
            sSWebView.destroy();
        } else {
            if (this.qg.contains(sSWebView)) {
                return;
            }
            this.qg.add(sSWebView);
            this.qg.size();
        }
    }

    public void qg(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.S_();
        w(sSWebView);
        n(sSWebView);
    }

    public SSWebView qg(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (s() <= 0 || (sSWebViewRemove = this.n.remove(0)) == null) {
            return null;
        }
        s();
        return sSWebViewRemove;
    }

    public void s(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.S_();
        w(sSWebView);
        q(sSWebView);
    }

    public void q(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.n.size() >= w) {
            sSWebView.destroy();
        } else {
            if (this.n.contains(sSWebView)) {
                return;
            }
            this.n.add(sSWebView);
            s();
        }
    }

    public boolean l(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void qg() {
        for (SSWebView sSWebView : this.n) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.n.clear();
        for (SSWebView sSWebView2 : this.qg) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.qg.clear();
        synchronized (this.q) {
            this.q.clear();
        }
    }

    public int s() {
        return this.n.size();
    }

    public int q() {
        return this.qg.size();
    }

    public int l() {
        return this.n.size() + q();
    }

    public void n(SSWebView sSWebView, qg qgVar) {
        if (sSWebView == null || qgVar == null) {
            return;
        }
        s sVar = this.s.get(sSWebView);
        if (sVar != null) {
            sVar.n(qgVar);
        } else {
            sVar = new s(qgVar);
            this.s.put(sSWebView, sVar);
        }
        sSWebView.addJavascriptInterface(sVar, "SDK_INJECT_GLOBAL");
    }

    public void w(SSWebView sSWebView) {
        s sVar;
        if (sSWebView == null || (sVar = this.s.get(sSWebView)) == null) {
            return;
        }
        sVar.n(null);
    }

    private static void n(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            rv.qg().post(runnable);
        }
    }

    public void n(final com.byazt.uad.q qVar, m mVar, final String str) {
        final q qVar2;
        if (qVar == null || mVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.q) {
            qVar2 = this.q.get(qVar);
            if (qVar2 != null) {
                qVar2.n(mVar);
            } else {
                qVar2 = new q(mVar);
                this.q.put(qVar, qVar2);
            }
        }
        n(new Runnable() { // from class: com.byazt.gjp.l.1
            @Override // java.lang.Runnable
            public void run() {
                qVar.addJavascriptInterface(qVar2, str);
            }
        });
    }

    public void n(final com.byazt.uad.q qVar, final String str) {
        if (qVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.q) {
            q qVar2 = this.q.get(qVar);
            if (qVar2 != null) {
                qVar2.n(null);
            }
        }
        n(new Runnable() { // from class: com.byazt.gjp.l.2
            @Override // java.lang.Runnable
            public void run() {
                qVar.removeJavascriptInterface(str);
            }
        });
    }
}
