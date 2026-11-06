package com.byazt.kw;

import android.content.Context;
import com.byazt.ee.CSJSpriteView;
import com.varbto.utils.api.UtilConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2128, 26})
public final class qg {
    public static n n(Context context, CSJSpriteView cSJSpriteView, com.byazt.dg.qg qgVar, JSONObject jSONObject, String str) {
        if ("H".equals(qgVar != null ? qgVar.n : UtilConst.CRASH_CAT_A)) {
            return new com.byazt.fc.n(context, cSJSpriteView, qgVar, jSONObject, str);
        }
        return new com.byazt.nm.n(context, cSJSpriteView, qgVar, jSONObject, str);
    }
}
