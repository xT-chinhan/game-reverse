package com.efs.sdk.base.core.c;

import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {
    private com.efs.sdk.base.core.d.b a;
    private c b;
    private String c;

    public e(com.efs.sdk.base.core.d.b bVar, c cVar, String str) {
        this.a = bVar;
        this.b = cVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpResponse httpResponse;
        if (this.a != null && this.b != null) {
            httpResponse = this.b.a(this.a, true);
        } else {
            httpResponse = new HttpResponse();
        }
        d.a().a(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
