package com.anythink.core.common.h;

import android.text.TextUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s {
    private List<a> a;

    private s() {
    }

    public static s a(JSONObject jSONObject) {
        a aVar;
        s sVar = new s();
        try {
            sVar.a = new ArrayList();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME);
                    if (TextUtils.isEmpty(strOptString)) {
                        aVar = null;
                    } else {
                        aVar = new a();
                        aVar.a = strOptString;
                    }
                    if (aVar != null) {
                        sVar.a.add(aVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return sVar;
    }

    private static a b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(TapEventParamConstants.PARAM_NAME);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        a aVar = new a();
        aVar.a = strOptString;
        return aVar;
    }

    public final List<a> a() {
        return this.a;
    }

    public static class a {
        private String a;

        public final String a() {
            return this.a;
        }

        private void a(String str) {
            this.a = str;
        }
    }
}
