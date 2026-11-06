package com.byazt.two;

import android.content.Context;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.tbt.cy;
import com.byazt.tbt.sz;
import com.byazt.vf.ae;
import com.byazt.vf.wo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 19})
public class n implements wo.n {
    public static n qg;
    public static boolean rv;
    public volatile Context cp;
    public volatile com.byazt.xl.s cy;
    public volatile q hd;
    public s k;
    public volatile Handler n;
    public volatile com.byazt.gwu.s oa;
    public volatile boolean s;
    public int sz;
    public volatile boolean q = false;
    public boolean l = true;
    public boolean w = false;
    public long x = 0;
    public long fs = 0;
    public AtomicBoolean tj = new AtomicBoolean(false);
    public volatile boolean d = false;

    public n(com.byazt.xl.s sVar) {
        this.cy = sVar;
        this.cp = this.cy.getContext();
        this.sz = sVar.n();
        qg = this;
    }

    public synchronized void n() {
        if (this.hd != null) {
            return;
        }
        if (this.cp == null) {
            this.cp = this.cy.getContext();
        }
        com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
        if (lVar != null) {
            this.s = lVar.n();
        }
        wo woVar = (wo) com.byazt.qp.q.n("thread_service");
        if (woVar != null) {
            this.n = woVar.q();
        }
        this.hd = new q(this, this.cp, this.sz);
        this.k = new s(this.s, this.cy, this.hd);
    }

    public qg qg() {
        s sVar = this.k;
        if (sVar != null) {
            return sVar.s();
        }
        return null;
    }

    public void s() {
        n(false);
    }

    public synchronized void n(boolean z) {
        if (this.s) {
            q(z);
            return;
        }
        if (this.x <= 0) {
            try {
                ExecutorService executorServiceD = d();
                if (executorServiceD == null) {
                    return;
                }
                executorServiceD.execute(new Runnable() { // from class: com.byazt.two.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.l();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void qg(boolean z) {
        rv = z;
    }

    public static void q() {
        n nVar;
        if (rv && (nVar = qg) != null) {
            com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
            if (lVar != null && lVar.n()) {
                nVar.n(true);
            } else {
                nVar.s();
            }
        }
    }

    public synchronized void l() {
        if (System.currentTimeMillis() - this.x > 3600000) {
            this.x = System.currentTimeMillis();
            try {
                s sVar = this.k;
                if (sVar != null) {
                    sVar.qg();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void q(boolean z) {
        if (this.w) {
            return;
        }
        if (this.l) {
            this.l = false;
            this.x = 0L;
            this.fs = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.x > j) {
            if (jCurrentTimeMillis - this.fs > i.l.c || !this.d) {
                w();
            }
        }
    }

    public boolean w() {
        this.tj.get();
        ExecutorService executorServiceD = d();
        if (executorServiceD == null) {
            return false;
        }
        executorServiceD.execute(new Runnable() { // from class: com.byazt.two.n.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zN = com.byazt.nx.s.n(n.this.cp);
                if (zN) {
                    n.this.fs = System.currentTimeMillis();
                    if (n.this.tj.compareAndSet(false, true)) {
                        n.this.s(zN);
                    }
                }
            }
        });
        return true;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        if (i == 101) {
            this.w = false;
            this.x = System.currentTimeMillis();
            if (this.l) {
                s();
            }
            this.tj.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.w = false;
        if (this.l) {
            s();
        }
        this.tj.set(false);
    }

    public synchronized void x() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.byazt.gwu.s sVarCp = cp();
        long jQg = sVarCp != null ? sVarCp.qg("last_refresh_time", 0L) : 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jQg > jCurrentTimeMillis) {
            jQg = jCurrentTimeMillis;
        }
        this.x = jQg;
        try {
            s sVar = this.k;
            if (sVar != null) {
                sVar.n();
            }
        } catch (Exception unused) {
        }
    }

    public void fs() {
        if (this.hd == null || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.s) {
                x();
            } else {
                l();
            }
        } catch (Throwable unused) {
        }
    }

    public String n(String str) {
        return this.hd != null ? this.hd.n(str) : str;
    }

    public void s(boolean z) {
        x();
        this.w = true;
        if (!z) {
            if (this.n != null) {
                this.n.sendEmptyMessage(102);
            }
        } else {
            try {
                tj();
            } catch (Exception unused) {
                this.tj.set(false);
            }
        }
    }

    public String[] rv() {
        String[] strArrW = this.cy != null ? this.cy.w() : null;
        return (strArrW == null || strArrW.length <= 0) ? new String[0] : strArrW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(f.R);
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.gwu.s sVarCp = cp();
            if (sVarCp != null) {
                sVarCp.n("last_refresh_time", jCurrentTimeMillis);
            }
        }
        s sVar = this.k;
        if (sVar == null) {
            return true;
        }
        sVar.n(jSONObject2);
        return true;
    }

    private com.byazt.gwu.s cp() {
        if (this.oa == null) {
            com.byazt.vf.n nVarQg = com.byazt.qp.q.qg(null);
            ae aeVar = (ae) com.byazt.qp.q.n("storage_service");
            if (aeVar != null) {
                this.oa = aeVar.qg(nVarQg, "ss_app_config", 0, com.byazt.p001if.n.n());
            }
        }
        return this.oa;
    }

    public boolean tj() {
        String[] strArrRv = rv();
        if (strArrRv != null && strArrRv.length != 0) {
            n(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final int i) {
        String[] strArrRv = rv();
        if (strArrRv == null || strArrRv.length <= i) {
            qg(102);
            return;
        }
        String str = strArrRv[i];
        if (TextUtils.isEmpty(str)) {
            qg(102);
            return;
        }
        try {
            String strQg = qg(str);
            if (TextUtils.isEmpty(strQg)) {
                qg(102);
                return;
            }
            rv rvVarQg = com.byazt.phf.s.qg(strQg);
            n(rvVarQg);
            rvVarQg.n(new com.byazt.qk.x() { // from class: com.byazt.two.n.3
                @Override // com.byazt.qk.x
                public void n(oa oaVar) {
                    JSONObject jSONObjectL;
                    if (oaVar == null || !oaVar.x()) {
                        n.this.n(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObjectL = oaVar.l();
                    } catch (Exception unused) {
                        jSONObjectL = null;
                    }
                    if (jSONObjectL == null) {
                        n.this.n(i + 1);
                        return;
                    }
                    try {
                        string = jSONObjectL.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        n.this.n(i + 1);
                        return;
                    }
                    try {
                        if (n.this.n(jSONObjectL)) {
                            n.this.qg(101);
                        } else {
                            n.this.n(i + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i2, String str2, Throwable th) {
                    n.this.n(i + 1);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        if (this.n != null) {
            this.n.sendEmptyMessage(i);
        }
    }

    private String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void n(rv rvVar) {
        if (rvVar == null) {
            return;
        }
        Address addressN = this.cy != null ? this.cy.n(this.cp) : null;
        if (addressN != null && addressN.hasLatitude() && addressN.hasLongitude()) {
            rvVar.qg("latitude", new StringBuilder().append(addressN.getLatitude()).toString());
            rvVar.qg("longitude", new StringBuilder().append(addressN.getLongitude()).toString());
            String locality = addressN.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                rvVar.qg("city", Uri.encode(locality));
            }
        }
        if (this.q) {
            rvVar.qg("force", "1");
        }
        try {
            rvVar.qg("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable unused) {
        }
        com.byazt.xl.s sVar = this.cy;
        if (sVar != null) {
            rvVar.qg("aid", new StringBuilder().append(sVar.n()).toString());
            rvVar.qg("device_platform", sVar.s());
            rvVar.qg("channel", sVar.qg());
            rvVar.qg("version_code", new StringBuilder().append(sVar.q()).toString());
            rvVar.qg("custom_info_1", sVar.l());
        }
    }

    private ExecutorService d() {
        wo woVar = (wo) com.byazt.qp.q.n("thread_service");
        if (woVar == null) {
            return null;
        }
        return woVar.qg();
    }

    public void n(sz szVar, Exception exc) {
        n();
        if (this.hd != null) {
            this.hd.n(szVar, exc);
        }
    }

    public void n(sz szVar, cy cyVar) {
        if (this.hd != null) {
            this.hd.n(szVar, cyVar);
        }
    }
}
