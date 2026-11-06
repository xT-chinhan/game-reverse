package com.byazt.orb;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.af.rv;
import com.byazt.ehw.x;
import com.byazt.hnb.q;
import com.byazt.vyf.s;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSConfig;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1853, 19})
public class n {
    public static volatile n n = null;
    public static volatile q rv = null;
    public static volatile String w = "";
    public volatile int fs;
    public volatile String l;
    public final String q;
    public PglMSManager qg;
    public volatile boolean s;
    public final AtomicBoolean x = new AtomicBoolean(false);

    private static n q(String str) {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n(str);
                }
            }
        }
        return n;
    }

    public static n n() {
        return n;
    }

    private n(String str) {
        this.fs = pblo.COLLECT_MODE_DEFAULT;
        String strOu = s.cy().ou();
        rv rvVarHd = s.cy().hd();
        if (rvVarHd != null) {
            if (!rvVarHd.q() || !rvVarHd.w() || !rvVarHd.fs()) {
                this.fs = 290;
            }
            if (!rvVarHd.tj()) {
                this.fs = 290;
            }
        }
        this.l = null;
        this.q = strOu;
        this.s = l(str);
    }

    private boolean l(String str) {
        try {
            Context context = com.byazt.nf.rv.getContext();
            PglMSConfig.Builder builder = new PglMSConfig.Builder("1371", this.q, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.fs);
            builder.addDataObserver(new PglITokenObserver() { // from class: com.byazt.orb.n.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = n.w = str2;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.byazt.ed.s.n().cp(str2);
                }
            });
            if (!s.cy().x()) {
                builder.addAdvanceInfo("kOA1", "1");
            } else if (!s.cy().tj()) {
                builder.setOaid(str);
            }
            if (!s.cy().q()) {
                builder.addAdvanceInfo("kS1", "1");
            }
            if (!s.cy().cp()) {
                builder.addAdvanceInfo("kDisableBlueToothCollection", "1");
            }
            if (!s.cy().oa()) {
                builder.addAdvanceInfo("kDisableIpCollection", "1");
            }
            rv rvVarHd = s.cy().hd();
            if (rvVarHd != null && !rvVarHd.s()) {
                builder.addAdvanceInfo("kDisableAppListCollection", "1");
                builder.addAdvanceInfo("kDisableImeListCollection", "1");
            }
            PglMSManagerUtils.init(context, builder.setDeviceID(this.l).setClientType(1).build());
            PglMSManagerUtils.initToken("1371");
            s();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void s() {
        if (this.qg == null) {
            this.qg = PglMSManagerUtils.get("1371");
        }
    }

    public void n(String str) {
        if (this.s) {
            s();
            if (TextUtils.isEmpty(str) || str.equals(this.l) || this.qg == null) {
                return;
            }
            this.l = str;
            this.qg.setDeviceID(str);
        }
    }

    public void qg(String str) {
        if (this.s) {
            s();
            PglMSManager pglMSManager = this.qg;
            if (pglMSManager != null) {
                pglMSManager.report(str);
            }
        }
    }

    public static String qg() {
        if (TextUtils.isEmpty(w)) {
            w = com.byazt.ed.s.n().cy();
        }
        return w;
    }

    public Map<String, String> n(String str, byte[] bArr) {
        if (!this.s) {
            return new HashMap();
        }
        s();
        PglMSManager pglMSManager = this.qg;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public static void n(q qVar) {
        rv = qVar;
        n(true);
    }

    public static n n(boolean z) {
        if (s.cy().rv()) {
            if (rv != null) {
                if (n == null) {
                    return q(x.s(rv));
                }
                return n;
            }
            if (z) {
                return q("error");
            }
            return null;
        }
        return q(null);
    }
}
