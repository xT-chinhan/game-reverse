package com.byazt.xqu;

import android.text.TextUtils;
import com.byazt.eld.k;
import com.byazt.zv.qa;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 5})
public class uc {
    public final AtomicInteger pr;

    @com.byazt.vzx.pr(pr = {0, 1, 432, 129})
    private static class pr {
        public static uc pr = new uc();
    }

    public static uc pr() {
        return pr.pr;
    }

    private uc() {
        this.pr = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hw() {
        return (this.pr.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com") + "/customer/api/app/deep_link";
    }

    public void pr(final com.byazt.shh.c cVar, final zo zoVar) {
        if (k.x() == null) {
            com.byazt.vi.hn.pr().pr("getDownloadNetworkFactory == NULL");
            pr(401, cVar);
        } else {
            com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.xqu.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    uc ucVar = uc.this;
                    ucVar.hw(cVar, ucVar.hw(), uc.this.pr(cVar, true, 4), zoVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.shh.c cVar, String str, byte[] bArr, zo zoVar) {
        if (this.pr.get() < 6) {
            this.pr.incrementAndGet();
            hw(cVar, str, bArr, zoVar);
        } else {
            pr("当前网络不佳，请稍后再试");
            this.pr.set(0);
            pr(402, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final com.byazt.shh.c cVar, final String str, final byte[] bArr, final zo zoVar) {
        k.x().pr(str, bArr, "application/json; charset=utf-8", 0, new qa() { // from class: com.byazt.xqu.uc.2
            @Override // com.byazt.zv.qa
            public void pr(String str2) {
                uc.this.pr(cVar, str2, zoVar);
            }

            @Override // com.byazt.zv.qa
            public void pr(Throwable th) {
                uc.this.pr(cVar, str, bArr, zoVar);
            }
        });
    }

    private void pr(final String str) {
        com.byazt.cvl.zo.pr().hw().post(new Runnable() { // from class: com.byazt.xqu.uc.3
            @Override // java.lang.Runnable
            public void run() {
                k.hn().pr(6, k.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] pr(com.byazt.shh.c cVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", cVar.pr());
            jSONObject.put("package_name", cVar.c());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", k.getContext().getPackageName());
                jSONObject.put("sender_version", k.vk().c);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(cVar.hw()));
                if (cVar.cz().getDeepLink() != null) {
                    if (TextUtils.isEmpty(cVar.cz().getDeepLink().getWebUrl())) {
                        com.byazt.vi.hn.pr().pr("web_url is null");
                    }
                    jSONObject.put("web_url", cVar.cz().getDeepLink().getWebUrl());
                } else {
                    com.byazt.vi.hn.pr().pr("deeplink is null");
                }
            }
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.shh.c cVar, String str, zo zoVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.byazt.vi.hn.pr().pr("response content is null");
                pr(404, cVar);
                zoVar.pr();
                return;
            }
            this.pr.set(0);
            c cVarFw = c.fw(str);
            if (cVarFw.pr() != 0) {
                pr(403, cVar);
                zoVar.pr();
            } else if (TextUtils.isEmpty(cVarFw.hw())) {
                pr(405, cVar);
                zoVar.pr();
            } else {
                zoVar.pr(cVarFw.hw());
            }
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void pr(int i, com.byazt.shh.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
        }
        com.byazt.mf.pr.pr().pr("get_miui_market_compliance_error", jSONObject, cVar);
    }

    public void pr(int i, com.byazt.shh.c cVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
        }
        com.byazt.mf.pr.pr().pr("get_miui_market_compliance_success", jSONObject, cVar);
    }
}
