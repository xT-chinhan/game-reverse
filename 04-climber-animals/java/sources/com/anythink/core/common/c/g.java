package com.anythink.core.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.u;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.m;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e {
    @Override // com.anythink.core.common.c.f
    public final int b() {
        return 1;
    }

    public g(Context context, String str, String str2, long j) {
        super(context, str, str2, j);
    }

    @Override // com.anythink.core.common.c.f
    public final c a() {
        String strC;
        boolean z;
        if (System.currentTimeMillis() - this.h > 86400000) {
            String strA = m.a(this.f, this.e);
            af.b(this.f, u.b.a, "det" + this.g, strA);
            af.a(this.f, u.b.a, "det_time_" + this.g, System.currentTimeMillis());
            strC = strA;
            z = true;
        } else {
            strC = af.c(this.f, u.b.a, "det" + this.g, "");
            z = false;
        }
        return new c(this.e, this.g, z, z ? System.currentTimeMillis() : this.h, !TextUtils.isEmpty(strC), strC);
    }
}
