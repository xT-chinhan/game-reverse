package com.byazt.dw;

import android.text.TextUtils;
import com.byazt.mr.uc;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1007, 20})
public class hn extends uc {
    public boolean c;
    public boolean hn;
    public String hw;
    public String pr;
    public List<uc> x;

    public hn(String str, String str2) {
        super(null);
        this.pr = str;
        this.hw = str2;
    }

    public hn() {
        super(null);
    }

    @Override // com.byazt.mr.uc
    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    @Override // com.byazt.mr.uc
    public String hw() {
        return this.hw;
    }

    public void hw(String str) {
        this.hw = str;
    }

    @Override // com.byazt.mr.uc
    public boolean hn() {
        return this.hn;
    }

    @Override // com.byazt.mr.uc
    public void pr(boolean z) {
        this.hn = z;
    }

    @Override // com.byazt.mr.uc
    public List<uc> x() {
        return this.x;
    }

    public boolean c() {
        return this.c;
    }

    public void hw(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.mr.uc
    public void pr(uc ucVar) {
        if (ucVar == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(ucVar);
    }

    @Override // com.byazt.mr.uc
    public boolean uc() {
        return (TextUtils.isEmpty(this.pr) || TextUtils.isEmpty(this.hw)) ? false : true;
    }

    @Override // com.byazt.mr.uc
    public boolean fw() {
        List<uc> list = this.x;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static hn pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            hn hnVar = new hn();
            hnVar.pr(jSONObject.optString("id"));
            hnVar.hw(jSONObject.optString(Common.System.NAME));
            hnVar.pr(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    hn hnVarPr = pr(jSONArrayOptJSONArray.optJSONObject(i));
                    if (hnVarPr != null && hnVarPr.uc()) {
                        hnVar.pr(hnVarPr);
                    }
                }
            }
            return hnVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONObject zo() {
        try {
            if (uc()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", pr());
                jSONObject.put(Common.System.NAME, hw());
                jSONObject.put("is_selected", hn());
                jSONObject.put("new_ui", this.c);
                if (fw()) {
                    JSONArray jSONArray = new JSONArray();
                    for (uc ucVar : x()) {
                        if (ucVar instanceof hn) {
                            jSONArray.put(((hn) ucVar).zo());
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
