package com.bytedance.sdk.component.ny.ah;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ch;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements le.ms {
    private static ThreadPoolExecutor ny;
    private static boolean x;
    private final Context hi;
    private int u;
    private final boolean xr;
    private com.bytedance.sdk.component.ny.ms zb;
    private volatile boolean ah = false;
    private boolean d = true;
    private boolean ka = false;
    private long c = 0;
    private long ab = 0;
    private AtomicBoolean ch = new AtomicBoolean(false);
    private volatile boolean sl = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final le f1280ms = com.bytedance.sdk.component.ch.xr.ms.ms().ms(this, "tt-net");

    public ms(Context context, int i) {
        this.hi = context;
        this.xr = h.ms(context);
        this.u = i;
    }

    public void ms() {
        ms(false);
    }

    public synchronized void ms(boolean z) {
        if (this.xr) {
            d(z);
            return;
        }
        if (this.c <= 0) {
            try {
                ab().execute(new Runnable() { // from class: com.bytedance.sdk.component.ny.ah.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void xr(boolean z) {
        x = z;
    }

    public Context getContext() {
        return this.hi;
    }

    public static void ms(Context context, int i) {
        ms msVarMs;
        if (x && (msVarMs = ab.ms().ms(i, context)) != null) {
            if (h.ms(context)) {
                msVarMs.ms(true);
            } else {
                msVarMs.ms();
            }
        }
    }

    synchronized void xr() {
        if (System.currentTimeMillis() - this.c > 3600000) {
            this.c = System.currentTimeMillis();
            try {
                if (ab.ms().ms(this.u).x() != null) {
                    ab.ms().ms(this.u).x().xr();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void d(boolean z) {
        if (this.ka) {
            return;
        }
        if (this.d) {
            this.d = false;
            this.c = 0L;
            this.ab = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.c > j) {
            if (jCurrentTimeMillis - this.ab > 120000 || !this.sl) {
                ah();
            }
        }
    }

    public boolean ah() {
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doRefresh: updating state " + this.ch.get());
        ab().execute(new Runnable() { // from class: com.bytedance.sdk.component.ny.ah.ms.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zMs = com.bytedance.sdk.component.ny.d.c.ms(ms.this.hi);
                if (zMs) {
                    ms.this.ab = System.currentTimeMillis();
                    if (!ms.this.ch.compareAndSet(false, true)) {
                        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doRefresh, already running");
                    } else {
                        ms.this.ah(zMs);
                    }
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        if (i == 101) {
            this.ka = false;
            this.c = System.currentTimeMillis();
            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doRefresh, succ");
            if (this.d) {
                ms();
            }
            this.ch.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.ka = false;
        if (this.d) {
            ms();
        }
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doRefresh, error");
        this.ch.set(false);
    }

    public synchronized void d() {
        if (this.sl) {
            return;
        }
        this.sl = true;
        long j = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.hi, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.c = j;
        try {
            if (ab.ms().ms(this.u).x() != null) {
                ab.ms().ms(this.u).x().ms();
            }
        } catch (Exception unused) {
        }
    }

    public void ka() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.xr) {
                d();
            } else {
                xr();
            }
        } catch (Throwable unused) {
        }
    }

    void ah(boolean z) {
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doRefresh, actual request");
        d();
        this.ka = true;
        if (!z) {
            this.f1280ms.sendEmptyMessage(102);
            return;
        }
        try {
            x();
        } catch (Exception unused) {
            this.ch.set(false);
        }
    }

    public String[] c() {
        String[] strArrC = ab.ms().ms(this.u).d() != null ? ab.ms().ms(this.u).d().c() : null;
        return (strArrC == null || strArrC.length <= 0) ? new String[0] : strArrC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.hi, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (ab.ms().ms(this.u).x() == null) {
            return true;
        }
        ab.ms().ms(this.u).x().ms(jSONObject2);
        return true;
    }

    private boolean x() {
        String[] strArrC = c();
        if (strArrC != null && strArrC.length != 0) {
            ms(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final int i) {
        String[] strArrC = c();
        if (strArrC == null || strArrC.length <= i) {
            xr(102);
            return;
        }
        String str = strArrC[i];
        if (TextUtils.isEmpty(str)) {
            xr(102);
            return;
        }
        try {
            String strMs = ms(str);
            if (TextUtils.isEmpty(strMs)) {
                xr(102);
                return;
            }
            com.bytedance.sdk.component.ny.xr.ah ahVarAh = ny().ah();
            ahVarAh.ms(strMs);
            ms(ahVarAh);
            ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.component.ny.ah.ms.3
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    JSONObject jSONObject;
                    if (xrVar == null || !xrVar.x()) {
                        ms.this.ms(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObject = new JSONObject(xrVar.d());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        ms.this.ms(i + 1);
                        return;
                    }
                    try {
                        string = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        ms.this.ms(i + 1);
                        return;
                    }
                    try {
                        if (ms.this.ms(jSONObject)) {
                            ms.this.xr(101);
                        } else {
                            ms.this.ms(i + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    ms.this.ms(i + 1);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.ny.d.ah.xr("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
        }
    }

    private com.bytedance.sdk.component.ny.ms ny() {
        if (this.zb == null) {
            this.zb = new com.bytedance.sdk.component.ny.ms.C0249ms().ms(10L, TimeUnit.SECONDS).xr(10L, TimeUnit.SECONDS).ah(10L, TimeUnit.SECONDS).ms();
        }
        return this.zb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        le leVar = this.f1280ms;
        if (leVar != null) {
            leVar.sendEmptyMessage(i);
        }
    }

    private String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void ms(com.bytedance.sdk.component.ny.xr.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        Address addressMs = ab.ms().ms(this.u).d() != null ? ab.ms().ms(this.u).d().ms(this.hi) : null;
        if (addressMs != null && addressMs.hasLatitude() && addressMs.hasLongitude()) {
            ahVar.ms("latitude", new StringBuilder().append(addressMs.getLatitude()).toString());
            ahVar.ms("longitude", new StringBuilder().append(addressMs.getLongitude()).toString());
            String locality = addressMs.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                ahVar.ms("city", Uri.encode(locality));
            }
        }
        if (this.ah) {
            ahVar.ms(TTDownloadField.TT_FORCE, "1");
        }
        try {
            ahVar.ms("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            sl.ms(th);
        }
        if (ab.ms().ms(this.u).d() != null) {
            ahVar.ms("aid", new StringBuilder().append(ab.ms().ms(this.u).d().ms()).toString());
            ahVar.ms("device_platform", ab.ms().ms(this.u).d().ah());
            ahVar.ms("channel", ab.ms().ms(this.u).d().xr());
            ahVar.ms("version_code", new StringBuilder().append(ab.ms().ms(this.u).d().d()).toString());
            ahVar.ms("custom_info_1", ab.ms().ms(this.u).d().ka());
        }
    }

    public static ThreadPoolExecutor ab() {
        if (ny == null) {
            synchronized (ms.class) {
                if (ny == null) {
                    com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ch("tnc/AppConfig"));
                    ny = dVar;
                    dVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return ny;
    }

    public static void ms(ThreadPoolExecutor threadPoolExecutor) {
        ny = threadPoolExecutor;
    }
}
