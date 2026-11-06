package com.anythink.dlopt.common.a.a;

import com.anythink.core.common.v.b.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int a = 1;
    public static final int b = 2;
    private static b c;
    private ExecutorService d;

    protected b() {
        this.d = null;
        this.d = Executors.newSingleThreadExecutor();
    }

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private static void a(b bVar) {
        c = bVar;
    }

    public final void a(d dVar) {
        this.d.execute(dVar);
    }

    private void b(d dVar) {
        a(dVar);
    }

    /* JADX INFO: renamed from: com.anythink.dlopt.common.a.a.b$1, reason: invalid class name */
    final class AnonymousClass1 extends d {
        final /* synthetic */ long a = 0;
        final /* synthetic */ Runnable b;

        AnonymousClass1(Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.anythink.core.common.v.b.d
        public final void a() {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException unused) {
            }
            b();
            this.b.run();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((d) anonymousClass1);
        }
    }

    private void b() {
        this.d.shutdown();
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((d) anonymousClass1);
        }
    }
}
