package com.anythink.core.d;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.ax;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static final String a = "i";
    private static volatile i b;
    private Context c;

    public interface a {
        void a(String str);

        void a(JSONObject jSONObject);
    }

    private i(Context context) {
        this.c = context.getApplicationContext();
    }

    public static i a(Context context) {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i(context);
                }
            }
        }
        return b;
    }

    private static h a(JSONObject jSONObject) {
        try {
            jSONObject.put(h.b.b, System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        return h.a(jSONObject);
    }

    public final synchronized void a(ax axVar, final a aVar) {
        new com.anythink.core.common.m.m(this.c, axVar).a(0, new com.anythink.core.common.m.q() { // from class: com.anythink.core.d.i.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                Context unused = i.this.c;
                i.a(obj, aVar);
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                String str2 = i.a;
                a aVar2 = aVar;
                if (aVar2 != null) {
                    if (str == null) {
                        str = "Request Strategy error.";
                    }
                    aVar2.a(str);
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a("Request cancel");
                }
            }
        });
    }

    private static void b(Object obj, a aVar) {
        if (!(obj instanceof JSONObject)) {
            if (aVar != null) {
                aVar.a("get mediation adapter Strategy error");
            }
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            a(jSONObject);
            if (aVar != null) {
                aVar.a(jSONObject);
            }
        }
    }

    static /* synthetic */ void a(Object obj, a aVar) {
        if (!(obj instanceof JSONObject)) {
            if (aVar != null) {
                aVar.a("get mediation adapter Strategy error");
            }
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            a(jSONObject);
            if (aVar != null) {
                aVar.a(jSONObject);
            }
        }
    }
}
