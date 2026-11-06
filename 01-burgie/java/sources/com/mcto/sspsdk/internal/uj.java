package com.mcto.sspsdk.internal;

import android.support.v4.app.NotificationCompat;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class uj implements s7 {
    public final HashMap a;

    public uj(JSONObject jSONObject) {
        ArrayList arrayList;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        HashMap map = new HashMap();
        this.a = map;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("impressionTracking");
        ArrayList arrayList2 = null;
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("thirdPartyTracking")) == null || jSONArrayOptJSONArray2.length() == 0) {
            arrayList = null;
        } else {
            int length = jSONArrayOptJSONArray2.length();
            arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArrayOptJSONArray2.optString(i));
            }
        }
        if (arrayList != null) {
            map.put("impression", arrayList);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickTracking");
        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("thirdPartyTracking")) != null && jSONArrayOptJSONArray.length() != 0) {
            int length2 = jSONArrayOptJSONArray.length();
            arrayList2 = new ArrayList(length2);
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.add(jSONArrayOptJSONArray.optString(i2));
            }
        }
        if (arrayList2 != null) {
            map.put("click", arrayList2);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("eventTracking");
        if (jSONArrayOptJSONArray3 == null) {
            return;
        }
        int length3 = jSONArrayOptJSONArray3.length();
        for (int i3 = 0; i3 < length3; i3++) {
            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i3);
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("tracking");
            if (jSONArrayOptJSONArray4 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                    arrayList3.add(jSONArrayOptJSONArray4.optString(i4));
                }
                String strOptString = jSONObjectOptJSONObject3.optString(NotificationCompat.CATEGORY_EVENT);
                List list = (List) this.a.get(strOptString);
                if (list == null) {
                    this.a.put(strOptString, arrayList3);
                } else {
                    list.addAll(arrayList3);
                }
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.s7
    public final List a(int i, p pVar) {
        List list = (List) this.a.get(ak.a(i));
        if (list == null || list.isEmpty()) {
            return null;
        }
        mh mhVarC = pVar.c();
        if (mhVarC != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String strReplace = (String) list.get(i2);
                if ("qxt".equals(mhVarC.a(strReplace, an.ax))) {
                    if (pVar.f() > 0.0f) {
                        strReplace = strReplace.replace("SETTLEMENT_WATERFALL", gj.f(gj.b("" + pVar.f())));
                    }
                    int i3 = pVar.F0;
                    if (i3 != 1 && i3 != 2) {
                        String str = "eti=" + gj.f(pVar.z0) + "__CUPID_ETI__";
                        strReplace = strReplace == null ? str : strReplace.contains("?") ? strReplace + "&" + str : strReplace + "?" + str;
                    }
                    list.set(i2, strReplace);
                }
            }
        }
        return list;
    }

    @Override // com.mcto.sspsdk.internal.s7
    public final ArrayList b(int i, p pVar) {
        int i2;
        List<String> list = (List) this.a.get(ak.a(i));
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            mh mhVarC = pVar.c();
            boolean z = mhVarC != null && "qxt".equals(mhVarC.a(str, an.ax));
            if (!z && 2 == i && (i2 = pVar.n) > 0 && i2 < pVar.p) {
                break;
            }
            String strA = bk.a(i, str, pVar, mhVarC);
            if (z) {
                strA = bk.a(i, pVar, strA);
            }
            arrayList.add(bk.c(strA));
        }
        return arrayList;
    }
}
