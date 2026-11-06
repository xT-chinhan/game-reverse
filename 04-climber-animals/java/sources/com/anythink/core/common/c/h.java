package com.anythink.core.common.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.anythink.core.common.v.m;

/* JADX INFO: loaded from: classes.dex */
public final class h extends e {
    a i;

    public interface a {
        void a(PackageInfo packageInfo);
    }

    @Override // com.anythink.core.common.c.f
    public final int b() {
        return 3;
    }

    public h(Context context, String str, a aVar) {
        super(context, str, "", 0L);
        this.i = aVar;
    }

    private h(Context context, String str, String str2, long j) {
        super(context, str, str2, j);
    }

    @Override // com.anythink.core.common.c.f
    public final c a() {
        PackageInfo packageInfoB = !TextUtils.isEmpty(this.e) ? m.b(this.f, this.e) : null;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(packageInfoB);
        }
        return null;
    }
}
