package com.anythink.unitybridge.utils;

import android.text.TextUtils;
import com.anythink.core.api.ATCustomContentInfo;
import com.anythink.core.api.ATCustomContentResult;
import com.anythink.core.api.ATShowConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ScenarioShowConfigFactory {
    private ScenarioShowConfigFactory() {
    }

    public static ATShowConfig fromScenario(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new ATShowConfig.Builder().scenarioId(str).build();
    }

    public static ATShowConfig fromJsonMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return fromJsonObject(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static ATShowConfig fromJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strFirstNonEmpty = firstNonEmpty(jSONObject.optString(Const.SCENARIO), jSONObject.optString("scenarioId"));
        String strOptString = jSONObject.optString("showCustomExt");
        ATCustomContentResult atCustomContentResult = parseAtCustomContentResult(jSONObject.optJSONObject("atCustomContentResult"));
        boolean z = !TextUtils.isEmpty(strFirstNonEmpty);
        boolean z2 = !TextUtils.isEmpty(strOptString);
        boolean z3 = atCustomContentResult != null;
        if (!z && !z2 && !z3) {
            return null;
        }
        ATShowConfig.Builder builder = new ATShowConfig.Builder();
        if (z) {
            builder.scenarioId(strFirstNonEmpty);
        }
        if (z2) {
            builder.showCustomExt(strOptString);
        }
        if (z3) {
            builder.customContentResult(atCustomContentResult);
        }
        return builder.build();
    }

    private static String firstNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return !TextUtils.isEmpty(str2) ? str2 : "";
        }
        return str;
    }

    private static ATCustomContentResult parseAtCustomContentResult(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        ATCustomContentInfo aTCustomContentInfo;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("items")) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                try {
                    String strOptString = jSONObjectOptJSONObject.optString("payloadKind");
                    Object customContentObject = parseCustomContentObject(jSONObjectOptJSONObject.opt("customContentObject"));
                    if ("double".equalsIgnoreCase(strOptString)) {
                        aTCustomContentInfo = new ATCustomContentInfo(jSONObjectOptJSONObject.optDouble("customContentDouble", -1.0d), customContentObject);
                    } else {
                        aTCustomContentInfo = new ATCustomContentInfo(jSONObjectOptJSONObject.optString("customContentString"), customContentObject);
                    }
                    arrayList.add(aTCustomContentInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new ATCustomContentResult(arrayList);
    }

    private static Object parseCustomContentObject(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
