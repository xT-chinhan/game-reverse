package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class v extends b {
    bf a;

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return new byte[0];
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

    public v(bf bfVar) {
        this.a = bfVar;
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
}
