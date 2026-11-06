package com.byazt.wc;

import android.text.TextUtils;
import com.byazt.eld.k;
import com.byazt.zs.aj;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1487, 13})
public class hw {
    public CopyOnWriteArrayList<com.byazt.shh.pr> pr(String str, String str2) {
        CopyOnWriteArrayList<com.byazt.shh.pr> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = aj.pr(k.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.byazt.shh.pr prVarPr = com.byazt.shh.pr.pr(jSONObject.optJSONObject(itKeys.next()));
                    if (prVarPr != null) {
                        copyOnWriteArrayList.add(prVarPr);
                    }
                }
            }
        } catch (Exception e) {
        }
        return copyOnWriteArrayList;
    }

    public void pr(String str, String str2, CopyOnWriteArrayList<com.byazt.shh.pr> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.byazt.shh.pr prVar : copyOnWriteArrayList) {
                if (prVar != null) {
                    jSONObject.put(String.valueOf(prVar.hw), prVar.pr());
                }
            }
        } catch (Exception e) {
        }
        aj.pr(k.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void hw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        aj.pr(k.getContext(), str, 0).edit().putString(str2, "").apply();
    }
}
