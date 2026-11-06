package com.anythink.basead.f;

import android.content.Context;
import android.view.View;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    private final String i;

    public b(Context context, c.b bVar, x xVar) {
        super(context, bVar, xVar);
        this.i = getClass().getSimpleName();
    }

    public final View a() {
        if (this.h != null) {
            return this.h.a(this.a);
        }
        return null;
    }

    @Override // com.anythink.basead.f.c
    public final void b() {
        super.b();
        this.e = null;
    }
}
