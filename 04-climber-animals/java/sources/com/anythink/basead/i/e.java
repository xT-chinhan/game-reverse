package com.anythink.basead.i;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.y;
import com.anythink.core.common.s;
import com.anythink.core.common.v.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.anythink.core.common.m.a {
    private static String f = "e";
    int a;
    String b;
    bj c;
    Map<String, Object> d;
    boolean e = false;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 2;
    }

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
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        return "";
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

    public e(int i, String str, bj bjVar, Map<String, Object> map) {
        this.a = i;
        this.b = str;
        this.c = bjVar;
        this.d = map;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        if (this.d != null && !TextUtils.isEmpty(this.b)) {
            try {
                for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                    this.b = this.b.replaceAll("\\{" + entry.getKey() + "\\}", (String) entry.getValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        if (this.c == null) {
            return null;
        }
        HashMap map = new HashMap();
        y yVarR = this.c.r();
        if (yVarR != null && com.anythink.basead.b.b.a(this.a, yVarR)) {
            String strI = m.i();
            if (!TextUtils.isEmpty(strI)) {
                map.put("User-Agent", strI);
            }
        }
        return map;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(int i) {
        String string;
        if (this.e) {
            s.a();
            if (s.a(i)) {
                try {
                    string = new JSONObject(c()).toString();
                } catch (Throwable unused) {
                    string = new JSONObject().toString();
                }
                s.a().a(this.t, string, this.c.ay());
            }
        }
    }

    private void s() {
        String string;
        try {
            string = new JSONObject(c()).toString();
        } catch (Throwable unused) {
            string = new JSONObject().toString();
        }
        s.a().a(this.t, string, this.c.ay());
    }
}
