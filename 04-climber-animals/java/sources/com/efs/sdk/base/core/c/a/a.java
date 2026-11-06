package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public a a;

    public abstract void a(LogDto logDto);

    final void b(LogDto logDto) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(logDto);
        }
    }
}
