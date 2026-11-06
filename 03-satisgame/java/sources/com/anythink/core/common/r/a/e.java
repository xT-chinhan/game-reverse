package com.anythink.core.common.r.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class e {
    private final Map<String, b> a = Collections.synchronizedMap(new HashMap());

    interface a {
        void a(AtomicBoolean atomicBoolean);
    }

    e() {
    }

    /* JADX INFO: renamed from: com.anythink.core.common.r.a.e$1, reason: invalid class name */
    final class AnonymousClass1 extends b {
        AnonymousClass1(String str, a aVar) {
            super(str, aVar);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.c.a(this.d);
            } finally {
                e.this.a.remove(this.b);
            }
        }
    }

    private b b(String str, a aVar) {
        return new AnonymousClass1(str, aVar);
    }

    final boolean a() {
        return !this.a.isEmpty();
    }

    final boolean a(String str) {
        b bVar = this.a.get(str);
        if (bVar == null) {
            return false;
        }
        bVar.d.set(true);
        return true;
    }

    private static abstract class b implements Runnable {
        final String b;
        final a c;
        AtomicBoolean d = new AtomicBoolean();

        b(String str, a aVar) {
            this.b = str;
            this.c = aVar;
        }
    }

    final void a(String str, a aVar) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, aVar);
        this.a.put(str, anonymousClass1);
        h.b().execute(anonymousClass1);
    }
}
