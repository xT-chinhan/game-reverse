package com.anythink.core.basead.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.basead.adx.api.ATAdxAPI;
import com.anythink.core.basead.adx.api.ATAdxAdapterConfig;
import com.anythink.core.basead.adx.api.ATAdxAdapterConfigListener;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ax;
import com.anythink.core.d.i;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static String a = "anythink_adx_context";
    private static volatile a b;

    public static a a() {
        if (b == null) {
            synchronized (t.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final void a(Context context, String str, Map<String, Object> map, final ATAdxAdapterConfigListener aTAdxAdapterConfigListener) {
        if (context == null) {
            if (aTAdxAdapterConfigListener != null) {
                aTAdxAdapterConfigListener.onLoadFailed("context = null");
                return;
            }
            return;
        }
        String strP = t.b().p();
        String strQ = t.b().q();
        if (t.b().g() == null || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ)) {
            Log.e(a, "SDK init error!");
            if (aTAdxAdapterConfigListener != null) {
                aTAdxAdapterConfigListener.onLoadFailed("SDK init error!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (aTAdxAdapterConfigListener != null) {
                aTAdxAdapterConfigListener.onLoadFailed("placementId is empty");
            }
        } else {
            if (map == null) {
                if (aTAdxAdapterConfigListener != null) {
                    aTAdxAdapterConfigListener.onLoadFailed("requestMap = null");
                    return;
                }
                return;
            }
            Object obj = map.get(ATAdxAPI.KEY_A_WF_INFO);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                new StringBuilder("adapter waterfall info: ").append(jSONObject);
                i.a(context).a(new ax(strP, strQ, str, t.b().d(str), jSONObject), new i.a() { // from class: com.anythink.core.basead.a.a.1
                    @Override // com.anythink.core.d.i.a
                    public final void a(JSONObject jSONObject2) {
                        ATAdxAdapterConfigListener aTAdxAdapterConfigListener2 = aTAdxAdapterConfigListener;
                        if (aTAdxAdapterConfigListener2 != null) {
                            aTAdxAdapterConfigListener2.onLoadSuccess(ATAdxAdapterConfig.parse(jSONObject2));
                        }
                    }

                    @Override // com.anythink.core.d.i.a
                    public final void a(String str2) {
                        ATAdxAdapterConfigListener aTAdxAdapterConfigListener2 = aTAdxAdapterConfigListener;
                        if (aTAdxAdapterConfigListener2 != null) {
                            aTAdxAdapterConfigListener2.onLoadFailed(str2);
                        }
                    }
                });
            } else if (aTAdxAdapterConfigListener != null) {
                aTAdxAdapterConfigListener.onLoadFailed("waterfall info = null");
            }
        }
    }
}
