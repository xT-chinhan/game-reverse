package com.anythink.core.common.h;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class af {
    private String b;
    private final List<a> a = new ArrayList();
    private boolean c = true;

    public final void a(int i, String str, int i2, String str2, boolean z, int i3) {
        this.a.add(new a(i, str, i2, str2, z, i3));
        this.c = true;
    }

    public final String toString() {
        if (this.c) {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            this.b = jSONArray.toString();
            this.c = false;
        }
        String str = this.b;
        return str != null ? str : "[]";
    }

    private static final class a {
        final int a;
        final String b;
        final int c;
        final String d;
        final int e;
        final int f;

        a(int i, String str, int i2, String str2, boolean z, int i3) {
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = str2 == null ? "" : str2;
            this.e = z ? 1 : 0;
            this.f = i3;
        }

        final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("priority", this.a);
                jSONObject.put("unit_id", this.b);
                jSONObject.put("nw_firm_id", this.c);
                jSONObject.put("nw_ver", this.d);
                jSONObject.put("result", this.e);
                int i = this.f;
                if (i != -1) {
                    jSONObject.put(MediationConstant.KEY_REASON, i);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }
}
