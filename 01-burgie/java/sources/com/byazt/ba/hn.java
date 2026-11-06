package com.byazt.ba;

import android.text.TextUtils;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wt.ls;
import com.byazt.wt.nt;
import com.byazt.zs.uc;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 667, 20})
public class hn implements com.byazt.la.c {
    @Override // com.byazt.la.c
    public void pr(boolean z, com.byazt.la.hn hnVar) {
    }

    @Override // com.byazt.la.c
    public void pr(boolean z, com.byazt.la.hn hnVar, JSONObject jSONObject) {
        if (hnVar == null) {
            return;
        }
        hnVar.hw();
        hnVar.pr();
        hnVar.hn();
        hnVar.x();
        hnVar.c();
    }

    @Override // com.byazt.la.c
    public String pr() {
        return "1371";
    }

    @Override // com.byazt.la.c
    public boolean hw() {
        return true;
    }

    @Override // com.byazt.la.c
    public int hn() {
        return 2;
    }

    @Override // com.byazt.la.c
    public String x() {
        com.byazt.fu.hn hnVar = (com.byazt.fu.hn) uc.pr("ad_log", com.byazt.zb.pr.c());
        return hnVar != null ? hnVar.hw() : "";
    }

    @Override // com.byazt.la.c
    public boolean c() {
        return true;
    }

    @Override // com.byazt.la.c
    public String uc() {
        return iu.zo;
    }

    @Override // com.byazt.la.c
    public void pr(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (TextUtils.equals(str, "pitaya_feature_engineering")) {
            com.byazt.lg.pr.pr(zo.nt().ny()).pr(str, (byte) 0, new com.byazt.ttf.pr() { // from class: com.byazt.ba.hn.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                    com.byazt.pr.hn.pr(str, jSONObject2);
                    return null;
                }
            });
        } else {
            com.byazt.xk.hw.pr().hw(str, jSONObject);
        }
    }

    @Override // com.byazt.la.c
    public String fw() {
        String strPr = nt.pr();
        if (strPr == null) {
            return "";
        }
        return strPr;
    }

    @Override // com.byazt.la.c
    public String zo() {
        return String.valueOf(ls.c());
    }

    @Override // com.byazt.la.c
    public void aj() {
    }

    @Override // com.byazt.la.c
    public com.byazt.vkw.pr vk() {
        return com.byazt.zb.pr.c();
    }
}
