package com.anythink.core.common.l;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class r extends b {
    private String a;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        return null;
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
    protected final boolean m() {
        return true;
    }

    public r() {
    }

    public r(String str) {
        this.a = str;
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strC = com.anythink.core.common.u.n.c(String.valueOf(jCurrentTimeMillis));
        if (!TextUtils.isEmpty(this.a)) {
            String strC2 = com.anythink.core.common.u.n.c(jCurrentTimeMillis + "_" + this.a);
            StringBuilder sb = new StringBuilder();
            com.anythink.core.common.i.a();
            return sb.append(com.anythink.core.common.i.b()).append("?t=").append(jCurrentTimeMillis).append("&sign=").append(strC2).append("&app_id=").append(this.a).toString();
        }
        StringBuilder sb2 = new StringBuilder();
        com.anythink.core.common.i.a();
        return sb2.append(com.anythink.core.common.i.b()).append("?t=").append(jCurrentTimeMillis).append("&sign=").append(strC).toString();
    }

    @Override // com.anythink.core.common.l.b
    protected final com.anythink.core.common.l.c.d o() {
        return com.anythink.core.common.l.c.d.a(com.anythink.core.common.l.c.g.c);
    }
}
