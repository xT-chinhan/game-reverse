package com.anythink.basead.exoplayer.d;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a(Exception exc);

    void d();

    void e();

    void f();

    public static final class a {
        private final CopyOnWriteArrayList<C0021a> a = new CopyOnWriteArrayList<>();

        public final void a(Handler handler, c cVar) {
            com.anythink.basead.exoplayer.k.a.a((handler == null || cVar == null) ? false : true);
            this.a.add(new C0021a(handler, cVar));
        }

        public final void a(c cVar) {
            for (C0021a c0021a : this.a) {
                if (c0021a.b == cVar) {
                    this.a.remove(c0021a);
                }
            }
        }

        public final void a() {
            for (C0021a c0021a : this.a) {
                final c cVar = c0021a.b;
                c0021a.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.d.c.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.d();
                    }
                });
            }
        }

        public final void a(final Exception exc) {
            for (C0021a c0021a : this.a) {
                final c cVar = c0021a.b;
                c0021a.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.d.c.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(exc);
                    }
                });
            }
        }

        public final void b() {
            for (C0021a c0021a : this.a) {
                final c cVar = c0021a.b;
                c0021a.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.d.c.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.e();
                    }
                });
            }
        }

        public final void c() {
            for (C0021a c0021a : this.a) {
                final c cVar = c0021a.b;
                c0021a.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.d.c.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.f();
                    }
                });
            }
        }

        /* JADX INFO: renamed from: com.anythink.basead.exoplayer.d.c$a$a, reason: collision with other inner class name */
        private static final class C0021a {
            public final Handler a;
            public final c b;

            public C0021a(Handler handler, c cVar) {
                this.a = handler;
                this.b = cVar;
            }
        }
    }
}
