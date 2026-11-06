package com.smartdigimkt.k;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends t {
    public final /* synthetic */ z a;

    public s(z zVar) {
        this.a = zVar;
    }

    @Override // com.smartdigimkt.k.t, java.lang.Runnable
    public final void run() {
        String string;
        Thread.currentThread().setName("sdm_download_apk");
        try {
            z zVar = this.a;
            if (zVar.i == 3) {
                return;
            }
            z.a(zVar);
        } catch (Throwable th) {
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            } catch (Throwable unused) {
                string = null;
            }
            this.a.a(3, "DownloadLoader#start() >>> download failed: msg = " + th.getMessage() + ", stackTrace = " + string);
        }
    }
}
