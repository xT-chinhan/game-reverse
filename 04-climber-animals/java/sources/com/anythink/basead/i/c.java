package com.anythink.basead.i;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.v.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.anythink.core.common.m.a {
    String a;
    boolean b;

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

    public c(String str, String str2, boolean z) {
        this.b = z;
        this.a = str.replaceAll("\\{req_id\\}", str2 == null ? "" : str2);
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        if (!this.b) {
            return null;
        }
        HashMap map = new HashMap();
        String strI = m.i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("User-Agent", strI);
        }
        return map;
    }
}
