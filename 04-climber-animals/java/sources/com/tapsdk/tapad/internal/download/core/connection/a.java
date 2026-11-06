package com.tapsdk.tapad.internal.download.core.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    public static final int a = 0;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.core.connection.a$a, reason: collision with other inner class name */
    public interface InterfaceC0605a {
        String a();

        InputStream b() throws IOException;

        String c(String str);

        Map<String, List<String>> e();

        int f() throws IOException;
    }

    public interface b {
        a a(String str) throws IOException;
    }

    void a(String str, String str2);

    boolean a(String str) throws ProtocolException;

    String b(String str);

    Map<String, List<String>> c();

    void d();

    InterfaceC0605a g() throws IOException;
}
