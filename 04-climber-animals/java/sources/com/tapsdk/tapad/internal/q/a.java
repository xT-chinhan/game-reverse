package com.tapsdk.tapad.internal.q;

import com.tapsdk.tapad.internal.q.h.d;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {
    private final com.tapsdk.tapad.internal.q.d.b a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final boolean c;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.q.a$a, reason: collision with other inner class name */
    public static class C0627a {
        boolean a = true;
        boolean b = false;
        com.tapsdk.tapad.internal.q.d.b c;

        public C0627a a(com.tapsdk.tapad.internal.q.d.b bVar) {
            this.c = bVar;
            return this;
        }

        public C0627a a(boolean z) {
            this.a = z;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public C0627a b(boolean z) {
            this.b = z;
            return this;
        }
    }

    public static class b {
        public long a;
        public long b;
    }

    a(C0627a c0627a) {
        this.c = c0627a.a;
        com.tapsdk.tapad.internal.q.d.b bVar = c0627a.c;
        if (bVar == null) {
            throw new IllegalStateException("NetworkInterpreter cannot be null");
        }
        this.a = bVar;
        d.a = c0627a.b;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        int andIncrement = this.b.getAndIncrement();
        Request request = chain.request();
        b bVar = new b();
        try {
            bVar.a = System.currentTimeMillis();
            Response responseProceed = chain.proceed(request);
            bVar.b = System.currentTimeMillis();
            return this.c ? this.a.a(andIncrement, bVar, request, responseProceed) : responseProceed;
        } catch (IOException e) {
            if (this.c) {
                this.a.a(andIncrement, bVar, request, e);
            }
            throw e;
        }
    }
}
