package com.byazt.dd;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 108})
public class m {
    public static fw.pr pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        fw.pr prVar = new fw.pr();
        String strPr = com.byazt.tn.hw.pr(str, jSONObject);
        if (strPr.contains("#")) {
            strPr = strPr.replace("#", "%23");
        }
        Uri uri = Uri.parse(strPr);
        if (uri == null) {
            return null;
        }
        prVar.hn(strPr);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            prVar.pr(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        prVar.hw(authority);
        prVar.x(prVar.pr() + "://" + prVar.hw());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.byazt.tn.hw.pr(uri.getQueryParameter(str2), jSONObject));
            }
        }
        prVar.pr(map);
        return prVar;
    }

    public static fw.pr pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        fw.pr prVar = new fw.pr();
        String strPr = com.byazt.tn.hw.pr(jSONObject.optString("protocol"), jSONObject2);
        prVar.hw(com.byazt.tn.hw.pr(jSONObject.optString(Common.System.NAME), jSONObject2));
        if (TextUtils.isEmpty(strPr)) {
            prVar.pr("global");
        } else {
            prVar.pr(strPr);
        }
        prVar.x(prVar.pr() + "://" + prVar.hw());
        prVar.hn(String.valueOf(jSONObject.hashCode()));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, com.byazt.tn.hw.pr(jSONObjectOptJSONObject.opt(next), jSONObject2));
            }
        }
        prVar.pr(map);
        return prVar;
    }
}
