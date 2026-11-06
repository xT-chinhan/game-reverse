package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 8})
public class s extends n {
    public final JSONObject q;

    public s(Context context, com.byazt.f.n nVar, String str, JSONObject jSONObject) {
        super(context, nVar, str);
        this.q = jSONObject;
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        String strOptString = this.q.optString("action");
        String strOptString2 = this.q.optString("category");
        int iOptInt = this.q.optInt("flags", 1342210048);
        String strOptString3 = this.q.optString("path_extra_key");
        String strOptString4 = this.q.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.q.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.q.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.s)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.s);
        }
        n(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void n(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                n(jSONObject, next, strOptString, intent);
            }
        }
    }

    private static void n(JSONObject jSONObject, String str, String str2, Intent intent) {
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
