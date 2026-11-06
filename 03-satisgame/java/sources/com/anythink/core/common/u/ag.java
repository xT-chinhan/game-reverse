package com.anythink.core.common.u;

import com.anythink.core.api.ATAdConst;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ag {
    public static JSONObject a(Map<String, Object> map) {
        Object obj = map.get(ATAdConst.KEY.M_S);
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).optJSONObject(com.anythink.core.e.i.b.a);
        }
        return null;
    }
}
