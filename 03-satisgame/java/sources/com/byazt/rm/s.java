package com.byazt.rm;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.f.e;
import com.byazt.gdj.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 8})
public class s {
    public static com.byazt.gdj.w n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gdj.w wVar = new com.byazt.gdj.w();
        wVar.n(jSONObject.optString("type"));
        wVar.qg(jSONObject.optString(NotificationCompat.CATEGORY_EVENT));
        return wVar;
    }

    public static x qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        x xVar = new x();
        xVar.n(jSONObject.optString("type"));
        xVar.n(jSONObject.optLong("time"));
        xVar.qg(jSONObject.optLong("bucketSize"));
        xVar.s(jSONObject.optLong(com.anythink.core.e.l.a.ac));
        return xVar;
    }

    private static com.byazt.gdj.n q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gdj.n nVar = new com.byazt.gdj.n();
        nVar.n(jSONObject.optString("function"));
        nVar.qg(jSONObject.optString("functionEL"));
        nVar.s(jSONObject.optString("as"));
        nVar.q(jSONObject.optString("filter"));
        nVar.l(jSONObject.optString("completeEvent"));
        nVar.w(jSONObject.optString("field"));
        nVar.x(jSONObject.optString("pattern"));
        nVar.n(jSONObject.optDouble("quantile", 0.0d));
        nVar.fs(jSONObject.optString("orderValue"));
        nVar.n(jSONObject.optBoolean("orderAsc", true));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trigger");
        if (jSONObjectOptJSONObject != null) {
            nVar.n(n(jSONObjectOptJSONObject));
        }
        com.byazt.gdj.q qVarL = l(jSONObject.optJSONObject("param"));
        if (qVarL != null && !qVarL.s()) {
            nVar.n(qVarL);
        }
        return nVar;
    }

    private static com.byazt.gdj.q l(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        com.byazt.gdj.q qVar = new com.byazt.gdj.q();
        qVar.n(jSONObject.optString("start"));
        qVar.qg(jSONObject.optString("end"));
        return qVar;
    }

    public static com.byazt.gdj.s s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gdj.s sVar = new com.byazt.gdj.s();
        sVar.n(jSONObject.optString(e.a.d));
        sVar.qg(jSONObject.optString("as"));
        return sVar;
    }

    private static com.byazt.gdj.l w(JSONObject jSONObject) {
        com.byazt.gdj.s sVarS;
        com.byazt.gdj.n nVarQ;
        com.byazt.gdj.n nVarQ2;
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gdj.l lVar = new com.byazt.gdj.l();
        lVar.n(jSONObject.optString("ruleId"));
        lVar.n(jSONObject.optBoolean("getAds"));
        lVar.n((float) jSONObject.optDouble("rate"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            lVar.s(jSONObjectOptJSONObject.optString("filter"));
            lVar.q(jSONObjectOptJSONObject.optString("groupBy"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("window");
            if (jSONObjectOptJSONObject2 != null) {
                lVar.n(qg(jSONObjectOptJSONObject2));
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("aggregate");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject3 != null && (nVarQ2 = q(jSONObjectOptJSONObject3)) != null) {
                        arrayList.add(nVarQ2);
                    }
                }
                lVar.n(arrayList);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("postAggregate");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject4 != null && (nVarQ = q(jSONObjectOptJSONObject4)) != null) {
                        arrayList2.add(nVarQ);
                    }
                }
                lVar.qg(arrayList2);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("outputs");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject5 != null && (sVarS = s(jSONObjectOptJSONObject5)) != null) {
                        arrayList3.add(sVarS);
                    }
                }
                lVar.s(arrayList3);
            }
        }
        return lVar;
    }

    public static List<com.byazt.gdj.l> n(JSONArray jSONArray) {
        com.byazt.gdj.l lVarW;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (lVarW = w(jSONObjectOptJSONObject)) != null) {
                        arrayList.add(lVarW);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static com.byazt.gdj.qg x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.gdj.qg qgVar = new com.byazt.gdj.qg();
        qgVar.n(jSONObject.optString("function"));
        qgVar.qg(jSONObject.optString("as"));
        qgVar.n(s(jSONObject.optJSONArray("fields")));
        qgVar.qg(s(jSONObject.optJSONArray("ruleIds")));
        qgVar.n(jSONObject.optBoolean("getAds", false));
        qgVar.s(jSONObject.optString("separator", ","));
        return qgVar;
    }

    public static List<com.byazt.gdj.qg> qg(JSONArray jSONArray) {
        com.byazt.gdj.qg qgVarX;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (qgVarX = x(jSONObjectOptJSONObject)) != null) {
                        arrayList.add(qgVarX);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static List<String> s(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i, null);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
