package com.tapsdk.tapad.internal.q.f;

import java.io.IOException;
import java.net.URL;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.q.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0630a {
        int a();

        URL b();

        String c();

        String d();

        long e();

        RequestBody f();
    }

    public interface b {
        int a();

        long b();

        ResponseBody c();

        int d();

        long e();

        long f();
    }

    void a(InterfaceC0630a interfaceC0630a, b bVar);

    void a(InterfaceC0630a interfaceC0630a, b bVar, Exception exc);

    void a(InterfaceC0630a interfaceC0630a, IOException iOException);
}
