package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private com.efs.sdk.base.core.c.a.a a;

    public abstract com.efs.sdk.base.core.c.a.a a();

    public final void a(LogDto logDto) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        com.efs.sdk.base.core.c.a.a aVarA = a();
                        this.a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(logDto);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
