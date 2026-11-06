package com.smartdigimkt.k;

import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ r b;
    public final /* synthetic */ n c;
    public final /* synthetic */ o d;

    public i(o oVar, String str, r rVar, com.smartdigimkt.j.p pVar) {
        this.d = oVar;
        this.a = str;
        this.b = rVar;
        this.c = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            int contentLength = httpURLConnection.getContentLength();
            this.b.h = contentLength;
            String headerField = httpURLConnection.getHeaderField("Accept-Ranges");
            if (headerField == null || !headerField.equals("bytes")) {
                this.b.z = false;
            } else {
                this.b.z = true;
            }
            this.d.a(this.a, contentLength, this.b.b());
        } catch (Throwable th) {
            th.getMessage();
        }
        this.c.onCallback(this.b);
    }
}
