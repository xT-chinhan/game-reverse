package com.efs.sdk.net.a.a;

import java.io.InputStream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public interface a extends b {
        String b();

        String c();

        @Nullable
        byte[] d();
    }

    public interface b {
        String a();
    }

    public interface c extends d {
    }

    public interface d {
        String a();

        int b();
    }

    @Nullable
    InputStream a(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream);

    void a();

    void a(a aVar);

    void a(c cVar);

    String b();
}
