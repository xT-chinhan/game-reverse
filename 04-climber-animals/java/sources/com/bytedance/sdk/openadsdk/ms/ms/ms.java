package com.bytedance.sdk.openadsdk.ms.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.f.ka;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.ub.d;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSConfig;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblu;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static volatile String c = "";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f4059ms;
    private static volatile d ny;
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private volatile boolean ah;
    private final String d;
    private volatile String ka;
    private volatile int x;
    private PglMSManager xr;

    private static ms d(String str) {
        if (f4059ms == null) {
            synchronized (ms.class) {
                if (f4059ms == null) {
                    f4059ms = new ms(str);
                }
            }
        }
        return f4059ms;
    }

    public static ms ms() {
        return f4059ms;
    }

    private ms(String str) {
        this.x = pblu.COLLECT_MODE_DEFAULT;
        String strT = ch.ub().t();
        ka kaVarAo = ch.ub().ao();
        if (kaVarAo != null) {
            if (!kaVarAo.ah() || !kaVarAo.d() || !kaVarAo.ka()) {
                this.x = 290;
            } else if (!kaVarAo.xr()) {
                this.x = 810;
            }
            if (g.xr >= 4600 && !kaVarAo.c()) {
                this.x = 290;
            }
        }
        this.ka = null;
        this.d = strT;
        this.ah = ka(str);
    }

    private boolean ka(String str) {
        try {
            Context context = re.getContext();
            PglMSConfig.Builder builder = new PglMSConfig.Builder("1371", this.d, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.x);
            builder.addDataObserver(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.ms.ms.ms.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = ms.c = str2;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.ah.d.ms().ub(str2);
                }
            });
            if (!ch.ub().x()) {
                builder.addAdvanceInfo("kOA1", "1");
            } else if (!ch.ub().hi()) {
                builder.setOaid(str);
            }
            if (!ch.ub().ka()) {
                builder.addAdvanceInfo("kS1", "1");
            }
            PglMSManagerUtils.init(context, builder.setDeviceID(this.ka).setClientType(1).build());
            PglMSManagerUtils.initToken("1371");
            ah();
            return true;
        } catch (Throwable th) {
            sl.xr("MSSdkImpl", "appid 为空，初始化失败！", th);
            return false;
        }
    }

    private void ah() {
        if (this.xr == null) {
            this.xr = PglMSManagerUtils.get("1371");
        }
    }

    public void ms(String str) {
        if (this.ah) {
            ah();
            if (TextUtils.isEmpty(str) || str.equals(this.ka) || this.xr == null) {
                return;
            }
            this.ka = str;
            this.xr.setDeviceID(str);
        }
    }

    public void xr(String str) {
        if (this.ah) {
            ah();
            PglMSManager pglMSManager = this.xr;
            if (pglMSManager != null) {
                pglMSManager.report(str);
            }
        }
    }

    public static String xr() {
        if (TextUtils.isEmpty(c)) {
            c = com.bytedance.sdk.openadsdk.core.ah.d.ms().nw();
        }
        return c;
    }

    public Map<String, String> ms(String str, byte[] bArr) {
        if (!this.ah) {
            return new HashMap();
        }
        ah();
        PglMSManager pglMSManager = this.xr;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public static void ms(d dVar) {
        ny = dVar;
        ms(true);
    }

    public static ms ms(boolean z) {
        if (ch.ub().ch()) {
            if (ny != null) {
                if (f4059ms == null) {
                    return d(b.ah(ny));
                }
                return f4059ms;
            }
            if (z) {
                return d("error");
            }
            return null;
        }
        return d(null);
    }
}
