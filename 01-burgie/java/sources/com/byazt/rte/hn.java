package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 20})
public class hn extends pr {
    public final JSONObject x;

    public hn(Context context, com.byazt.ew.pr prVar, String str, JSONObject jSONObject) {
        super(context, prVar, str);
        this.x = jSONObject;
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        String strOptString = this.x.optString("action");
        String strOptString2 = this.x.optString("category");
        int iOptInt = this.x.optInt("flags", 1342210048);
        String strOptString3 = this.x.optString("path_extra_key");
        String strOptString4 = this.x.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.x.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.x.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.hn)));
            } catch (Throwable th) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.hn);
        }
        pr(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void pr(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject != null && jSONObject2 != null && jSONObject.length() == jSONObject2.length() && intent != null && (itKeys = jSONObject.keys()) != null) {
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject2.optString(next);
                if (strOptString != null) {
                    pr(jSONObject, next, strOptString, intent);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    private static void pr(JSONObject jSONObject, String str, String str2, Intent intent) {
        switch (str2) {
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
        }
    }
}
