package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.ax;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m extends s {
    private static final String f = "m";
    JSONObject a;

    @Override // com.anythink.core.common.m.s, com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    public m(Context context, ax axVar) {
        super(context, axVar);
        this.a = axVar.a();
    }

    @Override // com.anythink.core.common.m.s, com.anythink.core.common.m.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.k();
    }

    @Override // com.anythink.core.common.m.s, com.anythink.core.common.m.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put(e.bf, this.a);
        } catch (JSONException unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.m.s, com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        try {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (this.c != null) {
                jSONObject.put(s.b, new JSONObject(this.c));
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
