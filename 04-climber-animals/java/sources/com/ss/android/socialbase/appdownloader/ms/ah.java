package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.umeng.ccg.a;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah extends ms {
    private final JSONObject d;

    public ah(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str, JSONObject jSONObject) {
        super(context, msVar, str);
        this.d = jSONObject;
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        String strOptString = this.d.optString(a.z);
        String strOptString2 = this.d.optString("category");
        int iOptInt = this.d.optInt("flags", 1342210048);
        String strOptString3 = this.d.optString("path_extra_key");
        String strOptString4 = this.d.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.d.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.d.optJSONObject(ATAdxBidFloorInfo.EXTRA_TYPE);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.ah)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.ah);
        }
        ms(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void ms(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                ms(jSONObject, next, strOptString, intent);
            }
        }
    }

    private static void ms(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
