package com.byazt.su;

import android.text.TextUtils;
import com.byazt.ky.um;
import com.byazt.ug.d;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 13})
public class w {
    public final AtomicInteger n;

    @com.byazt.cp.n(n = {0, 1, 726, 108})
    private static class n {
        public static w n = new w();
    }

    public static w n() {
        return n.n;
    }

    private w() {
        this.n = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qg() {
        return (this.n.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com").concat("/customer/api/app/deep_link");
    }

    public void n(final com.byazt.vl.l lVar, final fs fsVar) {
        if (d.q() == null) {
            com.byazt.ch.s.n().n("getDownloadNetworkFactory == NULL");
            n(401, lVar);
        } else {
            com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.su.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w wVar = w.this;
                    wVar.qg(lVar, wVar.qg(), w.this.n(lVar, true, 4), fsVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.vl.l lVar, String str, byte[] bArr, fs fsVar) {
        if (this.n.get() < 6) {
            this.n.incrementAndGet();
            qg(lVar, str, bArr, fsVar);
        } else {
            n("当前网络不佳，请稍后再试");
            this.n.set(0);
            n(402, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final com.byazt.vl.l lVar, final String str, final byte[] bArr, final fs fsVar) {
        d.q().n(str, bArr, "application/json; charset=utf-8", 0, new um() { // from class: com.byazt.su.w.2
            @Override // com.byazt.ky.um
            public void n(String str2) {
                w.this.n(lVar, str2, fsVar);
            }

            @Override // com.byazt.ky.um
            public void n(Throwable th) {
                w.this.n(lVar, str, bArr, fsVar);
            }
        });
    }

    private void n(final String str) {
        com.byazt.s.fs.n().qg().post(new Runnable() { // from class: com.byazt.su.w.3
            @Override // java.lang.Runnable
            public void run() {
                d.s().n(6, d.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] n(com.byazt.vl.l lVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, lVar.n());
            jSONObject.put("package_name", lVar.l());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", d.getContext().getPackageName());
                jSONObject.put("sender_version", d.tj().l);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(lVar.qg()));
                if (lVar.py().getDeepLink() != null) {
                    if (TextUtils.isEmpty(lVar.py().getDeepLink().getWebUrl())) {
                        com.byazt.ch.s.n().n("web_url is null");
                    }
                    jSONObject.put("web_url", lVar.py().getDeepLink().getWebUrl());
                } else {
                    com.byazt.ch.s.n().n("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.byazt.ch.s.n().n("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.vl.l lVar, String str, fs fsVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.byazt.ch.s.n().n("response content is null");
                n(404, lVar);
                fsVar.n();
                return;
            }
            this.n.set(0);
            l lVarX = l.x(str);
            if (lVarX.n() != 0) {
                n(403, lVar);
                fsVar.n();
            } else if (TextUtils.isEmpty(lVarX.qg())) {
                n(405, lVar);
                fsVar.n();
            } else {
                fsVar.n(lVarX.qg());
            }
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void n(int i, com.byazt.vl.l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.byazt.vj.n.n().n("get_miui_market_compliance_error", jSONObject, lVar);
    }

    public void n(int i, com.byazt.vl.l lVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.byazt.vj.n.n().n("get_miui_market_compliance_success", jSONObject, lVar);
    }
}
