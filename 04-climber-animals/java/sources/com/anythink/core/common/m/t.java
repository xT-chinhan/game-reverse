package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t extends a {
    bd a;

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
    protected final boolean b(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return new byte[0];
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

    public t(bd bdVar) {
        this.a = bdVar;
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
}
