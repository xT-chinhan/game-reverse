package com.anythink.core.e;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.az;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static final String a = "j";
    private static volatile j b;
    private Context c;

    public interface a {
        void a(String str);

        void a(JSONObject jSONObject);
    }

    private j(Context context) {
        this.c = context.getApplicationContext();
    }

    public static j a(Context context) {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new j(context);
                }
            }
        }
        return b;
    }

    private static i a(JSONObject jSONObject) {
        try {
            jSONObject.put(i.b.b, System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        return i.a(jSONObject);
    }

    public final synchronized void a(az azVar, final a aVar) {
        new com.anythink.core.common.l.o(this.c, azVar).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.e.j.1
            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                Context unused = j.this.c;
                j.a(obj, aVar);
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str, AdError adError) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    if (str == null) {
                        str = "Request Strategy error.";
                    }
                    aVar2.a(str);
                }
            }

            @Override // com.anythink.core.common.l.s
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
