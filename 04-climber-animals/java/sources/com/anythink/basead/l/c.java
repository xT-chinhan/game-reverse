package com.anythink.basead.l;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.x;
import com.anythink.core.common.m.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int a = 5;
    private static final String b = "c";
    private x c;
    private final com.anythink.basead.l.a d;
    private final a e;
    private com.anythink.basead.l.b.b f;
    private com.anythink.basead.l.b.b g;
    private int h;
    private List<String> i;
    private JSONArray j;
    private boolean k;
    private final q l;

    public interface a {
        void a(int i, String str);

        void a(com.anythink.basead.l.b.a[] aVarArr, JSONArray jSONArray);
    }

    public c(x xVar, a aVar) {
        this(xVar, false, aVar);
    }

    public c(x xVar, boolean z, a aVar) {
        this.l = new q() { // from class: com.anythink.basead.l.c.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                if (obj != null && (obj instanceof String)) {
                    c.this.b(obj.toString());
                } else {
                    c.b(c.this, "onLoadFinish but empty result");
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                c.b(c.this, str + "," + adError.toString());
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                c.b(c.this, "onLoadCanceled");
            }
        };
        this.c = xVar;
        this.k = z;
        this.e = aVar;
        this.d = new com.anythink.basead.l.a(this.c);
        this.i = new ArrayList();
        this.j = new JSONArray();
    }

    private void b() {
        com.anythink.basead.l.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void a(String str) {
        b(str);
    }

    public final void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONArray.length();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    b(jSONArray.getString(i));
                } catch (Throwable unused) {
                    this.e.a(-3, "VAST extractByLocalData error with error.");
                    return;
                }
            }
            return;
        }
        this.e.a(-3, "VAST extractByLocalData error with empty data.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (!e.a(str)) {
            this.e.a(-3, "VAST schema validation error.");
            return;
        }
        try {
            this.j.put(str);
        } catch (Throwable unused) {
        }
        this.h++;
        try {
            com.anythink.basead.l.b.b bVar = new com.anythink.basead.l.b.b(str);
            if (this.f == null) {
                this.f = bVar;
            } else {
                this.g.g(bVar);
            }
            this.g = bVar;
            String strD = bVar.d();
            if (!TextUtils.isEmpty(strD)) {
                if (this.h >= 5) {
                    this.e.a(-2, "Wrapper limit reached, as defined by the video player. Too many Wrapper responses have been received with no InLine response.");
                    this.h = 0;
                    return;
                } else {
                    this.i.add(strD);
                    if (this.k) {
                        return;
                    }
                    this.d.a(strD, this.l);
                    return;
                }
            }
            this.e.a(new com.anythink.basead.l.b.a[]{this.f, this.g}, this.j);
        } catch (b e) {
            Log.getStackTraceString(e);
            this.e.a(-3, "AdResponseParserVast creation failed: " + e.getMessage());
        }
    }

    private void c(String str) {
        this.e.a(-1, "Invalid ad response: ".concat(String.valueOf(str)));
    }

    public final List<String> a() {
        return this.i;
    }

    static /* synthetic */ void b(c cVar, String str) {
        cVar.e.a(-1, "Invalid ad response: ".concat(String.valueOf(str)));
    }
}
