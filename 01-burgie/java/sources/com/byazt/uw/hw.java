package com.byazt.uw;

import android.support.v4.app.NotificationCompat;
import com.byazt.jy.uc;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 99, 13})
public class hw {
    public static com.byazt.jy.c pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.jy.c cVar = new com.byazt.jy.c();
        cVar.pr(jSONObject.optString("type"));
        cVar.hw(jSONObject.optString(NotificationCompat.CATEGORY_EVENT));
        return cVar;
    }

    public static uc hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uc ucVar = new uc();
        ucVar.pr(jSONObject.optString("type"));
        ucVar.pr(jSONObject.optLong("time"));
        ucVar.hw(jSONObject.optLong("updateTime"));
        return ucVar;
    }

    private static com.byazt.jy.pr x(JSONObject jSONObject) {
        com.byazt.jy.hn hnVarC;
        if (jSONObject == null) {
            return null;
        }
        com.byazt.jy.pr prVar = new com.byazt.jy.pr();
        prVar.pr(jSONObject.optString("function"));
        prVar.hw(jSONObject.optString("functionEL"));
        prVar.hn(jSONObject.optString("as"));
        prVar.x(jSONObject.optString("filter"));
        prVar.c(jSONObject.optString("completeEvent"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trigger");
        if (jSONObjectOptJSONObject != null) {
            prVar.pr(pr(jSONObjectOptJSONObject));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("params");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null && (hnVarC = c(jSONObjectOptJSONObject2)) != null) {
                    arrayList.add(hnVarC);
                }
            }
            prVar.pr(arrayList);
        }
        return prVar;
    }

    private static com.byazt.jy.hn c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.jy.hn hnVar = new com.byazt.jy.hn();
        hnVar.pr(jSONObject.optString(NotificationCompat.CATEGORY_EVENT));
        hnVar.hw(jSONObject.optString("as"));
        hnVar.hn(jSONObject.optString("field"));
        return hnVar;
    }

    public static com.byazt.jy.hw hn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.jy.hw hwVar = new com.byazt.jy.hw();
        hwVar.pr(jSONObject.optString(Constants.VALUE_FIELD));
        hwVar.hw(jSONObject.optString("as"));
        return hwVar;
    }

    private static com.byazt.jy.x uc(JSONObject jSONObject) {
        com.byazt.jy.hw hwVarHn;
        com.byazt.jy.pr prVarX;
        com.byazt.jy.pr prVarX2;
        if (jSONObject == null) {
            return null;
        }
        com.byazt.jy.x xVar = new com.byazt.jy.x();
        xVar.pr(jSONObject.optString("ruleId"));
        xVar.pr(jSONObject.optBoolean("getAds"));
        xVar.pr((float) jSONObject.optDouble("rate"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject != null) {
            xVar.hw(jSONObjectOptJSONObject.optString("filter"));
            xVar.hn(jSONObjectOptJSONObject.optString("groupBy"));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("window");
            if (jSONObjectOptJSONObject2 != null) {
                xVar.pr(hw(jSONObjectOptJSONObject2));
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("aggregate");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject3 != null && (prVarX2 = x(jSONObjectOptJSONObject3)) != null) {
                        arrayList.add(prVarX2);
                    }
                }
                xVar.pr(arrayList);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("postAggregate");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject4 != null && (prVarX = x(jSONObjectOptJSONObject4)) != null) {
                        arrayList2.add(prVarX);
                    }
                }
                xVar.hw(arrayList2);
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("outputs");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i3);
                    if (jSONObjectOptJSONObject5 != null && (hwVarHn = hn(jSONObjectOptJSONObject5)) != null) {
                        arrayList3.add(hwVarHn);
                    }
                }
                xVar.hn(arrayList3);
            }
        }
        return xVar;
    }

    public static List<com.byazt.jy.x> pr(JSONArray jSONArray) {
        com.byazt.jy.x xVarUc;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (xVarUc = uc(jSONObjectOptJSONObject)) != null) {
                    arrayList.add(xVarUc);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }
}
