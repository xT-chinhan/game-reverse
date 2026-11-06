package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.aq;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class u extends a {
    aq a;
    boolean b = true;

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean p() {
        return true;
    }

    public u(aq aqVar) {
        this.a = aqVar;
    }

    public final void s() {
        this.b = false;
    }

    public final aq t() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return this.a.b;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        return this.a.d;
    }

    @Override // com.anythink.core.common.m.a
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

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        JSONObject jSONObject;
        boolean z = this.a.c != null && this.a.c.contains(Constants.CP_GZIP);
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(this.a.e);
            try {
                if (this.b) {
                    jSONObject.put(e.T, 1);
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
            return jSONObject != null ? b(jSONObject.toString()) : new byte[0];
        }
        return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
    }
}
