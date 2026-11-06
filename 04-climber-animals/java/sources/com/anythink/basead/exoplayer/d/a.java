package com.anythink.basead.exoplayer.d;

import android.util.Log;
import com.anythink.basead.exoplayer.k.af;
import com.kuaishou.weapon.p0.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class a {
    private static final String a = "ClearKeyUtil";

    private a() {
    }

    private static byte[] b(byte[] bArr) {
        return af.a >= 27 ? bArr : af.c(af.a(bArr).replace('+', '-').replace('/', '_'));
    }

    public static byte[] a(byte[] bArr) {
        if (af.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(af.a(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(b(jSONObject2.getString(t.a)));
                sb.append("\",\"kid\":\"");
                sb.append(b(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return af.c(sb.toString());
        } catch (JSONException e) {
            Log.e(a, "Failed to adjust response data: " + af.a(bArr), e);
            return bArr;
        }
    }

    private static String a(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
