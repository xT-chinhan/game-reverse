package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 574})
public class nl {
    public List<com.byazt.tm.hw> hn = new ArrayList();
    public String hw;
    public String pr;

    public nl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.pr = jSONObject.optString("id");
        this.hw = jSONObject.optString(BreakpointSQLiteKey.URL);
        hn();
    }

    public nl(String str, JSONArray jSONArray) {
        this.pr = str;
        pr(jSONArray);
    }

    public String pr() {
        return this.pr;
    }

    public List<com.byazt.tm.hw> hw() {
        return this.hn;
    }

    private void hn() {
        String strPr = pr(this.pr);
        if (!TextUtils.isEmpty(strPr)) {
            hw(strPr);
        } else {
            if (TextUtils.isEmpty(this.hw)) {
                return;
            }
            com.byazt.tf.hn.hw(this.hw).pr(new com.byazt.hcx.fw() { // from class: com.byazt.hg.nl.1
                @Override // com.byazt.hcx.fw
                public void pr(com.byazt.hcx.m mVar) {
                    if (mVar == null) {
                        return;
                    }
                    try {
                        if (mVar.fw() && mVar.zo() != null) {
                            com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
                            String strZo = mVar.zo();
                            hnVarPr.pr(nl.this.pr, strZo);
                            nl.this.hw(strZo);
                        }
                    } catch (Exception e) {
                    }
                }

                @Override // com.byazt.hcx.fw
                public void pr(int i, String str, Throwable th) {
                }
            });
        }
    }

    private String pr(String str) {
        com.byazt.zq.hn hnVarPr;
        if (TextUtils.isEmpty(str) || (hnVarPr = com.byazt.sd.hw.pr()) == null) {
            return null;
        }
        return hnVarPr.hw(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.hn.add(new com.byazt.tm.hw(jSONArray.getJSONObject(i)));
            }
        } catch (Exception e) {
        }
    }

    private void pr(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.hn.add(new com.byazt.tm.hw(jSONArray.getJSONObject(i)));
            } catch (Exception e) {
                return;
            }
        }
    }
}
