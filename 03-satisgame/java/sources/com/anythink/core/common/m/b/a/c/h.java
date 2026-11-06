package com.anythink.core.common.m.b.a.c;

import com.anythink.core.common.m.b.ag;
import com.anythink.core.common.m.b.x;

/* JADX INFO: loaded from: classes.dex */
public final class h extends ag {
    private final String a;
    private final long b;
    private final com.anythink.core.common.m.c.e c;

    public h(String str, long j, com.anythink.core.common.m.c.e eVar) {
        this.a = str;
        this.b = j;
        this.c = eVar;
    }

    @Override // com.anythink.core.common.m.b.ag
    public final x a() {
        String str = this.a;
        if (str != null) {
            return x.b(str);
        }
        return null;
    }

    @Override // com.anythink.core.common.m.b.ag
    public final long b() {
        return this.b;
    }

    @Override // com.anythink.core.common.m.b.ag
    public final com.anythink.core.common.m.c.e c() {
        return this.c;
    }
}
