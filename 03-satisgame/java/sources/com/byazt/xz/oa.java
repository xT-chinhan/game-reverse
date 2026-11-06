package com.byazt.xz;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static x.n n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        x.n nVar = new x.n();
        nVar.s(str);
        String strN = com.byazt.mcb.qg.n(str, jSONObject);
        if (strN.contains("#")) {
            strN = strN.replace("#", "%23");
        }
        Uri uri = Uri.parse(strN);
        if (uri == null) {
            return null;
        }
        if (!TextUtils.isEmpty(uri.getScheme())) {
            nVar.n(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        nVar.qg(authority);
        nVar.q(nVar.n() + "://" + nVar.qg());
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                String queryParameter = uri.getQueryParameter(str2);
                map2.put(str2, queryParameter);
                map.put(str2, com.byazt.mcb.qg.n(queryParameter, jSONObject));
            }
        }
        nVar.n(map);
        nVar.qg(map2);
        return nVar;
    }

    public static x.n n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        x.n nVar = new x.n();
        String strN = com.byazt.mcb.qg.n(jSONObject.optString("protocol"), jSONObject2);
        nVar.qg(com.byazt.mcb.qg.n(jSONObject.optString(TapEventParamConstants.PARAM_NAME), jSONObject2));
        if (TextUtils.isEmpty(strN)) {
            nVar.n("global");
        } else {
            nVar.n(strN);
        }
        nVar.q(nVar.n() + "://" + nVar.qg());
        nVar.s(String.valueOf(jSONObject.hashCode()));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObjectOptJSONObject.opt(next);
                map2.put(next, objOpt);
                map.put(next, com.byazt.mcb.qg.n(objOpt, jSONObject2));
            }
        }
        nVar.n(map);
        nVar.qg(map2);
        return nVar;
    }
}
