package com.anythink.basead.exoplayer.b;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    void a(int i);

    void a(int i, long j, long j2);

    void b(com.anythink.basead.exoplayer.m mVar);

    void b(String str, long j, long j2);

    void c(com.anythink.basead.exoplayer.c.d dVar);

    void d(com.anythink.basead.exoplayer.c.d dVar);

    public static final class a {
        private final Handler a;
        private final g b;

        public a(Handler handler, g gVar) {
            this.a = gVar != null ? (Handler) com.anythink.basead.exoplayer.k.a.a(handler) : null;
            this.b = gVar;
        }

        public final void a(final com.anythink.basead.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.c(dVar);
                    }
                });
            }
        }

        public final void a(final String str, final long j, final long j2) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(str, j, j2);
                    }
                });
            }
        }

        public final void a(final com.anythink.basead.exoplayer.m mVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(mVar);
                    }
                });
            }
        }

        public final void a(final int i, final long j, final long j2) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i, j, j2);
                    }
                });
            }
        }

        public final void b(final com.anythink.basead.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.d(dVar);
                    }
                });
            }
        }

        public final void a(final int i) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.basead.exoplayer.b.g.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i);
                    }
                });
            }
        }
    }
}
