package com.byazt.dw;

import android.text.TextUtils;
import com.byazt.mr.uc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1007, 13})
public class hw {
    public final String c;
    public String fw;
    public String hn;
    public final List<uc> hw = new ArrayList();
    public final int pr;
    public final String uc;
    public final boolean x;
    public boolean zo;

    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    public hw(JSONObject jSONObject, hn hnVar) {
        boolean z = false;
        this.pr = jSONObject.optInt("dislike_control", 0);
        this.x = jSONObject.optBoolean("close_on_dislike", false);
        String strPr = hnVar != null ? hnVar.pr() : "";
        this.zo = hnVar != null ? hnVar.c() : false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                hn hnVarPr = hn.pr(jSONArrayOptJSONArray.optJSONObject(i));
                hnVarPr.hw(this.zo);
                if (this.zo && hnVarPr != null) {
                    String strPr2 = hnVarPr.pr();
                    if (!"8:1".equals(strPr2) && !"99:1".equals(strPr2)) {
                        if (hnVarPr == null) {
                        }
                    }
                } else if (hnVarPr == null && hnVarPr.uc()) {
                    this.hw.add(hnVarPr);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(hnVarPr.pr(), strPr);
                    }
                }
            }
            z = zEquals;
        }
        if (hnVar != null && !z) {
            this.hw.add(hnVar);
        }
        this.c = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.uc = jSONObject.optString("ext");
    }

    public void pr(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.pr);
        jSONObject.put("filter_words", fw());
        jSONObject.put("close_on_dislike", aj());
    }

    public List<uc> pr() {
        return this.hw;
    }

    public boolean hw() {
        return this.zo;
    }

    public void pr(String str) {
        this.hn = str;
    }

    public String hn() {
        return this.hn;
    }

    public String x() {
        return this.c;
    }

    public String c() {
        return this.uc;
    }

    public boolean uc() {
        return this.pr == 1;
    }

    public JSONArray fw() {
        JSONObject jSONObjectZo;
        JSONArray jSONArray = new JSONArray();
        List<uc> list = this.hw;
        if (list != null) {
            for (uc ucVar : list) {
                if ((ucVar instanceof hn) && (jSONObjectZo = ((hn) ucVar).zo()) != null) {
                    jSONArray.put(jSONObjectZo);
                }
            }
        }
        return jSONArray;
    }

    public void hw(String str) {
        this.fw = str;
    }

    public String zo() {
        return this.fw;
    }

    public boolean aj() {
        return this.x;
    }
}
