package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class w extends b {
    ar a;
    boolean b = true;

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean p() {
        return true;
    }

    private w(ar arVar) {
        this.a = arVar;
    }

    private void a(boolean z) {
        this.b = z;
    }

    private ar t() {
        return this.a;
    }

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return this.a.b;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        return this.a.d;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        String str = this.a.c;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
        }
        return map;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        JSONObject jSONObject;
        boolean z = this.a.c != null && this.a.c.contains("gzip");
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(this.a.e);
            try {
                if (this.b) {
                    jSONObject.put(f.T, 1);
                }
            } catch (Exception e) {
                e = e;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (z) {
            return jSONObject != null ? a(jSONObject.toString()) : new byte[0];
        }
        return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
    }
}
