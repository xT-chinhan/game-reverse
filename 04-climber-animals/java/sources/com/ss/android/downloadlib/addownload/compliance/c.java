package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import com.ss.android.download.api.config.qv;
import com.ss.android.downloadlib.addownload.hi;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicInteger f4371ms;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static c f4375ms = new c();
    }

    public static c ms() {
        return ms.f4375ms;
    }

    private c() {
        this.f4371ms = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xr() {
        return (this.f4371ms.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com").concat("/customer/api/app/deep_link");
    }

    public void ms(final com.ss.android.downloadlib.addownload.xr.ka kaVar, final x xVar) {
        if (hi.d() == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("getDownloadNetworkFactory == NULL");
            ms(401, kaVar);
        } else {
            com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    cVar.xr(kaVar, cVar.xr(), c.this.ms(kaVar, true, 4), xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, String str, byte[] bArr, x xVar) {
        if (this.f4371ms.get() < 6) {
            this.f4371ms.incrementAndGet();
            xr(kaVar, str, bArr, xVar);
        } else {
            ms("当前网络不佳，请稍后再试");
            this.f4371ms.set(0);
            ms(402, kaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final com.ss.android.downloadlib.addownload.xr.ka kaVar, final String str, final byte[] bArr, final x xVar) {
        hi.d().ms(str, bArr, "application/json; charset=utf-8", 0, new qv() { // from class: com.ss.android.downloadlib.addownload.compliance.c.2
            @Override // com.ss.android.download.api.config.qv
            public void ms(String str2) {
                c.this.ms(kaVar, str2, xVar);
            }

            @Override // com.ss.android.download.api.config.qv
            public void ms(Throwable th) {
                c.this.ms(kaVar, str, bArr, xVar);
            }
        });
    }

    private void ms(final String str) {
        com.ss.android.downloadlib.x.ms().xr().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.c.3
            @Override // java.lang.Runnable
            public void run() {
                hi.ah().ms(6, hi.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", kaVar.ms());
            jSONObject.put("package_name", kaVar.ka());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", hi.getContext().getPackageName());
                jSONObject.put("sender_version", hi.ch().ka);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(kaVar.xr()));
                if (kaVar.nw().getDeepLink() != null) {
                    if (TextUtils.isEmpty(kaVar.nw().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.ka.ah.ms().ms("web_url is null");
                    }
                    jSONObject.put("web_url", kaVar.nw().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.ka.ah.ms().ms("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.ka.ah.ms().ms("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, String str, x xVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.ka.ah.ms().ms("response content is null");
                ms(404, kaVar);
                xVar.ms();
                return;
            }
            this.f4371ms.set(0);
            ka kaVarAb = ka.ab(str);
            if (kaVarAb.ms() != 0) {
                ms(403, kaVar);
                xVar.ms();
            } else if (TextUtils.isEmpty(kaVarAb.xr())) {
                ms(405, kaVar);
                xVar.ms();
            } else {
                xVar.ms(kaVarAb.xr());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void ms(int i, com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("get_miui_market_compliance_error", jSONObject, kaVar);
    }

    public void ms(int i, com.ss.android.downloadlib.addownload.xr.ka kaVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("get_miui_market_compliance_success", jSONObject, kaVar);
    }
}
