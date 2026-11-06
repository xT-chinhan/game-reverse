package com.byazt.uw;

import com.byazt.jy.fw;
import com.byazt.jy.zo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 99, 121})
public class x {
    private static zo pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        zo zoVar = new zo();
        zoVar.pr(jSONObject.optString("functionEL"));
        zoVar.hw(jSONObject.optString("as"));
        return zoVar;
    }

    private static fw hw(JSONObject jSONObject) {
        com.byazt.jy.hw hwVarHn;
        zo zoVarPr;
        if (jSONObject == null) {
            return null;
        }
        fw fwVar = new fw();
        fwVar.pr(jSONObject.optString("strategyId"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("functions");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null && (zoVarPr = pr(jSONObjectOptJSONObject2)) != null) {
                        arrayList.add(zoVarPr);
                    }
                }
                fwVar.pr(arrayList);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("outputs");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject3 != null && (hwVarHn = hw.hn(jSONObjectOptJSONObject3)) != null) {
                        arrayList2.add(hwVarHn);
                    }
                }
                fwVar.hw(arrayList2);
            }
        }
        return fwVar;
    }

    public static List<fw> pr(JSONArray jSONArray) {
        fw fwVarHw;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (fwVarHw = hw(jSONObjectOptJSONObject)) != null) {
                    arrayList.add(fwVarHw);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }
}
