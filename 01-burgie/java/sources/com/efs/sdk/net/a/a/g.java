package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements f {
    private static AtomicInteger a = new AtomicInteger(0);
    private static g c;
    private b b = new b();

    public static g c() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    private g() {
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.a aVar) {
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar = this.b;
        try {
            String strA = aVar.a();
            bVar.a.put(aVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.b bVarA = com.efs.sdk.net.a.a.a().a(strA);
            String strB = aVar.b();
            if (!TextUtils.isEmpty(strB)) {
                bVarA.d = strB;
            }
            bVarA.e = aVar.c();
            bVarA.f = b.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.c cVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.b;
        Log.i("NetTrace-Interceptor", "save response");
        String strA = cVar.a();
        if (bVar.a == null) {
            return;
        }
        com.efs.sdk.net.a.a.a().a(strA).g = cVar.b();
    }

    @Override // com.efs.sdk.net.a.a.f
    @Nullable
    public final InputStream a(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(a.getAndIncrement());
    }
}
