package com.anythink.core.common.t.a.b.a.a;

import com.anythink.core.common.u.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {
    private int k;

    public c() {
        this.f = System.currentTimeMillis();
        this.a = n.a(new StringBuilder().append(this.f).toString());
    }

    public final JSONObject a() {
        try {
            return new JSONObject(this.e);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final int b() {
        return this.k;
    }

    public final void a(int i) {
        this.k = i;
    }
}
