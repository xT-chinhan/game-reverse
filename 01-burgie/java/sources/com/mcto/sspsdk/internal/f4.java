package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyAppComplianceInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f4 implements IQyAppComplianceInfo {
    public final String a;
    public final ArrayList b = new ArrayList();
    public final HashMap c = new HashMap();
    public final HashMap d;

    public f4(String str, JSONObject jSONObject) {
        this.a = str;
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (true) {
            if (!itKeys.hasNext()) {
                break;
            }
            Object objOpt = jSONObject.opt(itKeys.next());
            if (objOpt instanceof JSONObject) {
                a((JSONObject) objOpt, map);
            } else if (objOpt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) objOpt;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        a(jSONObjectOptJSONObject, map);
                    }
                }
            }
        }
        this.d = map;
        Iterator<String> itKeys2 = jSONObject.keys();
        while (itKeys2.hasNext()) {
            String next = itKeys2.next();
            if ("ext".equals(next)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ext");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject2.has(BreakpointSQLiteKey.URL)) {
                            this.c.put(jSONObjectOptJSONObject2.optString(BundleKey.TITLE), jSONObjectOptJSONObject2.optString(BreakpointSQLiteKey.URL));
                        } else {
                            this.b.add(jSONObjectOptJSONObject2.optString(BundleKey.TITLE));
                        }
                    }
                }
            } else {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject3 != null) {
                    if (jSONObjectOptJSONObject3.has(BreakpointSQLiteKey.URL)) {
                        this.c.put(jSONObjectOptJSONObject3.optString(BundleKey.TITLE), jSONObjectOptJSONObject3.optString(BreakpointSQLiteKey.URL));
                    } else if (!"appName".equals(next)) {
                        this.b.add(jSONObjectOptJSONObject3.optString(BundleKey.TITLE));
                    }
                }
            }
        }
    }

    public static void a(JSONObject jSONObject, HashMap map) {
        String strOptString = jSONObject.optString(BundleKey.TITLE);
        String strOptString2 = jSONObject.optString(BreakpointSQLiteKey.URL);
        if (strOptString.contains("：")) {
            String[] strArrSplit = strOptString.split("：", 2);
            String str = strArrSplit[0];
            if (strOptString2.isEmpty()) {
                strOptString2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            }
            strOptString = str;
        }
        if (strOptString.isEmpty()) {
            return;
        }
        map.put(strOptString, strOptString2);
    }

    @Override // com.mcto.sspsdk.IQyAppComplianceInfo
    public final Map getAllInfoKV() {
        return this.d;
    }

    @Override // com.mcto.sspsdk.IQyAppComplianceInfo
    public final String getAppName() {
        return this.a;
    }

    @Override // com.mcto.sspsdk.IQyAppComplianceInfo
    public final List getFixInfoList() {
        return this.b;
    }

    @Override // com.mcto.sspsdk.IQyAppComplianceInfo
    public final Map getLinkInfoMap() {
        return this.c;
    }
}
