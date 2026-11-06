package com.anythink.core.common.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.anythink.core.common.u.l;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {
    a h;

    public interface a {
        void a(PackageInfo packageInfo);
    }

    @Override // com.anythink.core.common.c.e
    public final int c() {
        return 3;
    }

    public f(Context context, String str, a aVar) {
        super(context, str, "", 0L);
        this.h = aVar;
    }

    private f(Context context, String str, String str2, long j) {
        super(context, str, str2, j);
    }

    @Override // com.anythink.core.common.c.e
    public final c b() {
        PackageInfo packageInfoA = !TextUtils.isEmpty(this.d) ? l.a(this.e, this.d) : null;
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(packageInfoA);
        }
        return null;
    }
}
