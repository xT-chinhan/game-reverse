package com.anythink.core.common.c;

import android.content.Context;
import com.anythink.core.common.e.l;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class d extends e {
    private boolean i;

    @Override // com.anythink.core.common.c.f
    public final int b() {
        return 2;
    }

    public d(Context context, String str, String str2, long j) {
        super(context, str, str2, j);
    }

    public d(Context context, String str, String str2, long j, boolean z) {
        this(context, str, str2, j);
        this.i = z;
    }

    @Override // com.anythink.core.common.c.f
    public final c a() {
        boolean z;
        boolean zA = this.i;
        if (System.currentTimeMillis() - this.h > 86400000) {
            String str = this.e;
            zA = q.a(this.f, this.e);
            l.a(com.anythink.core.common.e.e.a(this.f)).a(this.g, zA);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        return new c(this.e, this.g, z2, z2 ? System.currentTimeMillis() : this.h, zA);
    }
}
