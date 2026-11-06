package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p extends a {
    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.m.a
    protected final boolean d_() {
        return true;
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
    protected final String b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strC = com.anythink.core.common.v.o.c(String.valueOf(jCurrentTimeMillis));
        StringBuilder sb = new StringBuilder();
        com.anythink.core.common.i.a();
        return sb.append(com.anythink.core.common.i.l() ? com.anythink.core.common.d.j.e.C : com.anythink.core.common.d.j.e.k).append("?t=").append(jCurrentTimeMillis).append("&sign=").append(strC).toString();
    }

    @Override // com.anythink.core.common.m.a
    protected final com.anythink.core.common.m.b.d m() {
        return com.anythink.core.common.m.b.d.a(com.anythink.core.common.m.b.g.c);
    }
}
