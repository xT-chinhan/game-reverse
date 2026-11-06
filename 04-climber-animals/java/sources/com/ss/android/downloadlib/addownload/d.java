package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private AtomicBoolean ah = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f4396ms;
    private com.ss.android.downloadlib.addownload.xr.ka xr;

    d(Handler handler) {
        this.f4396ms = handler;
    }

    public void ms(com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        this.xr = kaVar;
    }

    public boolean ms() {
        return this.d.get();
    }

    public void ms(boolean z) {
        this.d.set(z);
    }

    void ms(final int i, final long j, long j2, final ka.ms msVar) {
        this.d.set(false);
        if (msVar == null) {
            return;
        }
        if (!com.ss.android.downloadlib.ab.ka.c(i) || !com.ss.android.downloadlib.ab.ka.ka(i)) {
            msVar.ms();
            return;
        }
        long jAh = com.ss.android.downloadlib.ab.ka.ah(i);
        this.ah.set(false);
        final String downloadUrl = this.xr.xr.getDownloadUrl();
        com.ss.android.downloadad.api.ms.xr xrVarXr = com.ss.android.downloadlib.addownload.xr.c.ms().xr(downloadUrl);
        if (xrVarXr == null) {
            xrVarXr = new com.ss.android.downloadad.api.ms.xr(this.xr.xr, this.xr.ah, this.xr.d, 0);
            com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVarXr);
        }
        final com.ss.android.downloadad.api.ms.xr xrVar = xrVarXr;
        xrVar.ka(false);
        if (hi.zb() != null) {
            hi.zb();
            xrVar.xr();
        }
        com.ss.android.downloadlib.addownload.ah.d.ms().ms(xrVar.ms());
        boolean zD = com.ss.android.downloadlib.ab.ka.d(i);
        if (j2 > 0) {
            ms(i, downloadUrl, j2, xrVar, j, msVar);
        } else if (zD) {
            ms(downloadUrl, xrVar, new ka.xr() { // from class: com.ss.android.downloadlib.addownload.d.1
                @Override // com.ss.android.downloadlib.addownload.ka.xr
                public void ms(long j3) throws Throwable {
                    d.this.ms(i, downloadUrl, j3, xrVar, j, msVar);
                }
            });
        } else {
            jAh = 0;
        }
        this.f4396ms.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ah.get()) {
                    return;
                }
                d.this.ah.set(true);
                msVar.ms();
            }
        }, jAh);
    }

    private void ms(String str, com.ss.android.downloadad.api.ms.xr xrVar, final ka.xr xrVar2) {
        if (xrVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ms.xr.ms(str, new com.ss.android.socialbase.downloader.network.ch() { // from class: com.ss.android.downloadlib.addownload.d.3
            @Override // com.ss.android.socialbase.downloader.network.ch
            public void ms(Map<String, String> map) {
                if (d.this.ah.get()) {
                    return;
                }
                d.this.ah.set(true);
                long jMs = d.this.ms(map);
                if (jMs > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jMs));
                        jSONObject.putOpt("available_space", Long.valueOf(d.d()));
                    } catch (JSONException e) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    }
                }
                xrVar2.ms(jMs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ms(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str, long j, final com.ss.android.downloadad.api.ms.xr xrVar, long j2, final ka.ms msVar) throws Throwable {
        this.ah.set(true);
        boolean zMs = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            long jLongValue = (Double.valueOf((com.ss.android.downloadlib.ab.ka.ms(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.ab.ka.xr(i)) - j2;
            long jD = d();
            if (jD < jLongValue) {
                ms(xrVar, jSONObject, jLongValue, jD);
                ms(xrVar);
                long jD2 = d();
                if (jD2 < jLongValue) {
                    xrVar.d(true);
                    final String strMs = xrVar.ms();
                    com.ss.android.downloadlib.addownload.ah.d.ms().ms(strMs, new com.ss.android.downloadlib.addownload.ah.ka() { // from class: com.ss.android.downloadlib.addownload.d.4
                    });
                    zMs = ms(i, xrVar, str, jLongValue);
                    if (zMs) {
                        xrVar.ka(true);
                    }
                } else {
                    xr(xrVar, jSONObject, jD, jD2);
                }
            }
        }
        if (zMs) {
            return;
        }
        this.f4396ms.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.5
            @Override // java.lang.Runnable
            public void run() {
                msVar.ms();
            }
        });
    }

    private boolean ms(int i, com.ss.android.downloadad.api.ms.xr xrVar, String str, long j) {
        if (!com.ss.android.downloadlib.ab.ka.c(i)) {
            return false;
        }
        if (hi.zb() != null) {
            return hi.zb().ms(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("cleanspace_window_show", jSONObject, xrVar);
        return false;
    }

    public static boolean ms(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean zMs = false;
        if (!com.ss.android.downloadlib.ab.ka.c(id)) {
            return false;
        }
        if (hi.zb() != null && (zMs = hi.zb().ms(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.ah.d.ms().ms(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.ah.ka() { // from class: com.ss.android.downloadlib.addownload.d.6
            });
        }
        return zMs;
    }

    public static JSONObject ms(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return jSONObject;
    }

    public static void ms(int i) {
        if (com.ss.android.downloadlib.ab.ka.c(i) && hi.zb() != null && hi.zb().xr()) {
            hi.zb();
        }
    }

    public static long xr() {
        if (hi.zb() != null) {
            return hi.zb().ms();
        }
        return 0L;
    }

    private static void ms(com.ss.android.downloadad.api.ms.xr xrVar) throws Throwable {
        long jD = d();
        if (hi.zb() != null) {
            hi.zb();
        }
        com.ss.android.downloadlib.addownload.ah.ah.ms();
        com.ss.android.downloadlib.addownload.ah.ah.xr();
        if (com.ss.android.downloadlib.ab.ka.ab(xrVar.y())) {
            com.ss.android.downloadlib.addownload.ah.ah.ms(hi.getContext());
        }
        long jD2 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jD2 - jD));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("clean_quite_finish", jSONObject, xrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d() {
        return com.ss.android.downloadlib.ab.zb.xr(0L);
    }

    private void ms(com.ss.android.downloadad.api.ms.xr xrVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("clean_space_no_enough_for_download", jSONObject, xrVar);
    }

    private void xr(com.ss.android.downloadad.api.ms.xr xrVar, JSONObject jSONObject, long j, long j2) {
        xrVar.sl("1");
        com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("cleanspace_download_after_quite_clean", jSONObject, xrVar);
    }
}
