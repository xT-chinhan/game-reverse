package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.az;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o extends u {
    private static final String n = "o";
    JSONObject a;

    @Override // com.anythink.core.common.l.u, com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    public o(Context context, az azVar) {
        super(context, azVar);
        this.a = azVar.a();
    }

    @Override // com.anythink.core.common.l.u, com.anythink.core.common.l.b
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.g();
    }

    @Override // com.anythink.core.common.l.u, com.anythink.core.common.l.b
    protected final JSONObject i() {
        JSONObject jSONObjectI = super.i();
        try {
            jSONObjectI.put(f.bi, this.a);
        } catch (JSONException unused) {
        }
        return jSONObjectI;
    }

    @Override // com.anythink.core.common.l.u, com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        try {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (this.c != null) {
                jSONObject.put(u.b, new JSONObject(this.c));
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
