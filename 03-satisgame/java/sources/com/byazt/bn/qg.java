package com.byazt.bn;

import android.text.TextUtils;
import com.byazt.qp.x;
import com.byazt.ug.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1240, 26})
public class qg {
    public CopyOnWriteArrayList<com.byazt.vl.n> n(String str, String str2) {
        CopyOnWriteArrayList<com.byazt.vl.n> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = x.n(d.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.byazt.vl.n nVarN = com.byazt.vl.n.n(jSONObject.optJSONObject(itKeys.next()));
                    if (nVarN != null) {
                        copyOnWriteArrayList.add(nVarN);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return copyOnWriteArrayList;
    }

    public void n(String str, String str2, CopyOnWriteArrayList<com.byazt.vl.n> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.byazt.vl.n nVar : copyOnWriteArrayList) {
                if (nVar != null) {
                    jSONObject.put(String.valueOf(nVar.qg), nVar.n());
                }
            }
        } catch (Exception unused) {
        }
        x.n(d.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void qg(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        x.n(d.getContext(), str, 0).edit().putString(str2, "").apply();
    }
}
