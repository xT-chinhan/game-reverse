package com.byazt.xh;

import android.content.Context;
import com.byazt.qf.fs;
import com.byazt.yw.cy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 768, 19})
public class n {
    public static volatile n n;
    public volatile Context qg;

    public static n n() {
        if (n == null) {
            n = new n(fs.q());
        }
        return n;
    }

    private n(Context context) {
        this.qg = context;
    }

    public String n(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return com.byazt.yw.q.n(com.byazt.yw.fs.n(this.qg), com.byazt.yw.fs.n(), qg.n(fs.n().n()), jSONObject, qg.n());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void qg(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strN = qg.n(fs.n().n());
            String strN2 = com.byazt.yw.q.n(com.byazt.yw.fs.n(this.qg), com.byazt.yw.fs.qg(), strN, jSONObject, qg.qg());
            jSONObject.put("upload_scene", "direct");
            if (qg.n(strN, jSONObject.toString()).n()) {
                com.byazt.yw.q.n(strN2);
            }
        } catch (Throwable unused) {
        }
    }

    public void s(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        cy.n(new Runnable() { // from class: com.byazt.xh.n.1
            @Override // java.lang.Runnable
            public void run() {
                String strN = qg.n(fs.n().n());
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException unused) {
                }
                qg.n(strN, jSONObject.toString());
            }
        });
    }
}
