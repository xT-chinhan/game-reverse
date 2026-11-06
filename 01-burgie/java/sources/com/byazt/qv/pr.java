package com.byazt.qv;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.igw.x;
import com.byazt.qam.fw;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.wt.fo;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSConfig;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1082, 37})
public class pr {
    public static volatile x aj;
    public static volatile pr pr;
    public static volatile String uc = "";
    public volatile String c;
    public final AtomicBoolean fw = new AtomicBoolean(false);
    public volatile boolean hn;
    public PglMSManager hw;
    public final String x;
    public volatile int zo;

    private static pr x(String str) {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr(str);
                }
            }
        }
        return pr;
    }

    public static pr pr() {
        return pr;
    }

    private pr(String str) {
        this.zo = pblo.COLLECT_MODE_DEFAULT;
        String strNy = zo.nt().ny();
        fw fwVarYb = zo.nt().yb();
        if (fwVarYb != null) {
            if (!fwVarYb.hn() || !fwVarYb.x() || !fwVarYb.c()) {
                this.zo = 290;
            }
            if (!fwVarYb.uc()) {
                this.zo = 290;
            }
        }
        this.c = null;
        this.x = strNy;
        this.hn = c(str);
    }

    private boolean c(String str) {
        try {
            Context context = a.getContext();
            PglMSConfig.Builder builder = new PglMSConfig.Builder("1371", this.x, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.zo);
            builder.addDataObserver(new PglITokenObserver() { // from class: com.byazt.qv.pr.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = pr.uc = str2;
                    if (!TextUtils.isEmpty(str2)) {
                        com.byazt.mp.x.pr().w(str2);
                    }
                }
            });
            if (!zo.nt().fw()) {
                builder.addAdvanceInfo("kOA1", "1");
            } else if (!zo.nt().vk()) {
                builder.setOaid(str);
            }
            if (!zo.nt().x()) {
                builder.addAdvanceInfo("kS1", "1");
            }
            if (!zo.nt().w()) {
                builder.addAdvanceInfo("kDisableBlueToothCollection", "1");
            }
            if (!zo.nt().m()) {
                builder.addAdvanceInfo("kDisableIpCollection", "1");
            }
            fw fwVarYb = zo.nt().yb();
            if (fwVarYb != null && !fwVarYb.hw()) {
                builder.addAdvanceInfo("kDisableAppListCollection", "1");
                builder.addAdvanceInfo("kDisableImeListCollection", "1");
            }
            PglMSManagerUtils.init(context, builder.setDeviceID(this.c).setClientType(1).build());
            PglMSManagerUtils.initToken("1371");
            hn();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private void hn() {
        if (this.hw == null) {
            this.hw = PglMSManagerUtils.get("1371");
        }
    }

    public void pr(String str) {
        if (!this.hn) {
            return;
        }
        hn();
        if (!TextUtils.isEmpty(str) && !str.equals(this.c) && this.hw != null) {
            this.c = str;
            this.hw.setDeviceID(str);
        }
    }

    public void hw(String str) {
        if (!this.hn) {
            return;
        }
        hn();
        PglMSManager pglMSManager = this.hw;
        if (pglMSManager != null) {
            pglMSManager.report(str);
        }
    }

    public static String hw() {
        if (TextUtils.isEmpty(uc)) {
            uc = com.byazt.mp.x.pr().yb();
        }
        return uc;
    }

    public Map<String, String> pr(String str, byte[] bArr) {
        if (!this.hn) {
            return new HashMap();
        }
        hn();
        PglMSManager pglMSManager = this.hw;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public static void pr(x xVar) {
        aj = xVar;
        pr(true);
    }

    public static pr pr(boolean z) {
        if (zo.nt().aj()) {
            if (aj != null) {
                if (pr == null) {
                    return x(fo.hn(aj));
                }
                return pr;
            }
            if (z) {
                return x("error");
            }
            return null;
        }
        return x(null);
    }
}
