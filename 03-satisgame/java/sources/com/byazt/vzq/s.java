package com.byazt.vzq;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.nf.rv;
import com.byazt.qp.q;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.k;
import com.byazt.wl.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 987, 8})
public class s {
    public AtomicBoolean qg = new AtomicBoolean(false);
    public AtomicBoolean s = new AtomicBoolean(false);
    public static final s n = new s();
    public static int q = -1;
    public static String l = "ext_plugin";

    private s() {
    }

    public static s n() {
        return n;
    }

    public static int qg() {
        if (q == -1) {
            q = n().fs();
        }
        return q;
    }

    public static boolean s() {
        if (!rv.qg().oj()) {
            return false;
        }
        s sVarN = n();
        boolean z = sVarN.qg.get();
        if (z || !l.rv("com.byted.csj.ext")) {
            return z;
        }
        sVarN.qg.set(true);
        return true;
    }

    private int fs() {
        com.byazt.ek.s sVar;
        if (s() && (sVar = (com.byazt.ek.s) q.n("pitaya_new")) != null) {
            return sVar.qg();
        }
        return -1;
    }

    public static void q() {
        Bundle bundle = new Bundle();
        Bundle bundleN = n(com.byazt.vyf.s.cy().ou());
        if (bundleN != null) {
            bundle.putBundle("com.byted.csj.ext", bundleN);
        }
        com.byazt.vyf.s.cy().n(bundle);
    }

    private static Bundle n(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String strQ = l.q("com.byted.csj.ext");
            if (TextUtils.isEmpty(strQ)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strQ);
            bundle.putString("sdk_version", n(1160));
            return bundle;
        } catch (Throwable th) {
            k.qg(l, "error:" + th.getMessage());
            return null;
        }
    }

    public static String n(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(i.E);
            }
        }
        String string = sb.toString();
        return (i < 100 || i >= 1000) ? string : "0." + string;
    }

    public boolean l() {
        try {
            if (!rv.qg().oj()) {
                return false;
            }
            if (this.qg.get()) {
                return true;
            }
            if (this.s.compareAndSet(false, true)) {
                if (l.tj("com.byted.csj.ext")) {
                    if (l.rv("com.byted.csj.ext")) {
                        this.qg.set(true);
                        this.s.set(false);
                        return true;
                    }
                    com.byazt.tk.rv.n().post(new Runnable() { // from class: com.byazt.vzq.s.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s.this.n(true);
                        }
                    });
                } else {
                    this.s.set(false);
                }
            }
            return false;
        } catch (Throwable th) {
            k.qg(l, "pit_ext_error:" + th.getMessage());
        }
    }

    public com.byazt.ek.n w() {
        if (qg.n(rv.qg().rf()) && l()) {
            return (com.byazt.ek.n) q.n("alog");
        }
        return null;
    }

    public boolean n(boolean z) {
        try {
            if (this.qg.get()) {
                return true;
            }
            if (!z) {
                this.s.set(true);
            }
            boolean zX = l.x("com.byted.csj.ext");
            this.qg.set(zX);
            this.s.set(false);
            return zX;
        } catch (Throwable th) {
            k.qg(l, ":" + th.getMessage());
            return false;
        }
    }

    public void x() {
        int iDg = rv.qg().dg();
        if ((iDg & 1) != 0 && iDg > 1) {
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.vzq.s.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.gh.q.n();
                }
            }, iDg & 65534);
        }
    }
}
