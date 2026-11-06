package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {
    private LogDto a;
    private d b;
    private String c;

    public g(LogDto logDto, d dVar, String str) {
        this.a = logDto;
        this.b = dVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpResponse httpResponse;
        d dVar;
        LogDto logDto = this.a;
        if (logDto != null && (dVar = this.b) != null) {
            httpResponse = dVar.a(logDto, true);
        } else {
            httpResponse = new HttpResponse();
        }
        e.a().b(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
