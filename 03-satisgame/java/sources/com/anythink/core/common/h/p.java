package com.anythink.core.common.h;

import android.text.TextUtils;
import com.anythink.core.api.bridge.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public ATBaseAdAdapter a;
    private Throwable b;
    private String c;

    public p(ATBaseAdAdapter aTBaseAdAdapter) {
        this.a = aTBaseAdAdapter;
    }

    public p(Throwable th) {
        this.b = th;
    }

    public final String a() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b(String str) {
        Throwable th = this.b;
        if (th != null && !(th instanceof ClassNotFoundException)) {
            String message = th.getMessage();
            if (!TextUtils.isEmpty(message)) {
                return message;
            }
            String message2 = this.b.getCause() != null ? this.b.getCause().getMessage() : "";
            if (!TextUtils.isEmpty(message2)) {
                return message2;
            }
        }
        return str;
    }
}
