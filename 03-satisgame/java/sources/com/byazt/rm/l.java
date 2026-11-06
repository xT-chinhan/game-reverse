package com.byazt.rm;

import com.byazt.gdj.fs;
import com.byazt.gdj.rv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 18})
public class l {
    private static rv n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        rv rvVar = new rv();
        rvVar.n(jSONObject.optString("functionEL"));
        rvVar.qg(jSONObject.optString("as"));
        return rvVar;
    }

    private static fs qg(JSONObject jSONObject) {
        com.byazt.gdj.s sVarS;
        rv rvVarN;
        if (jSONObject == null) {
            return null;
        }
        fs fsVar = new fs();
        fsVar.n(jSONObject.optString("strategyId"));
        fsVar.n(jSONObject.optInt("version", 1));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dependStrategyIds");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (strOptString != null && strOptString.length() > 0) {
                    copyOnWriteArrayList.add(strOptString);
                }
            }
            if (!copyOnWriteArrayList.isEmpty()) {
                fsVar.n(copyOnWriteArrayList);
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("functions");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null && (rvVarN = n(jSONObjectOptJSONObject2)) != null) {
                        arrayList.add(rvVarN);
                    }
                }
                fsVar.qg(arrayList);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("outputs");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject3 != null && (sVarS = s.s(jSONObjectOptJSONObject3)) != null) {
                        arrayList2.add(sVarS);
                    }
                }
                fsVar.s(arrayList2);
            }
        }
        return fsVar;
    }

    public static List<fs> n(JSONArray jSONArray) {
        fs fsVarQg;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (fsVarQg = qg(jSONObjectOptJSONObject)) != null) {
                        arrayList.add(fsVarQg);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
