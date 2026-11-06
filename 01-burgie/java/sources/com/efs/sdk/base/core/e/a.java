package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private com.efs.sdk.base.core.e.a.a a;

    public abstract com.efs.sdk.base.core.e.a.a a();

    public final void a(com.efs.sdk.base.core.d.b bVar) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = a();
                        if (this.a == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(bVar);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
