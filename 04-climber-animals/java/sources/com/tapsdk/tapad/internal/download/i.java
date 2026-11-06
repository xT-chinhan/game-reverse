package com.tapsdk.tapad.internal.download;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    static volatile i j;
    private final com.tapsdk.tapad.internal.download.m.d.b a;
    private final com.tapsdk.tapad.internal.download.m.d.a b;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.g c;
    private final com.tapsdk.tapad.internal.download.core.connection.a.b d;
    private final com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a e;
    private final com.tapsdk.tapad.internal.download.m.g.e f;
    private final com.tapsdk.tapad.internal.download.m.e.g g;
    private final Context h;
    d i;

    public static class a {
        private com.tapsdk.tapad.internal.download.m.d.b a;
        private com.tapsdk.tapad.internal.download.m.d.a b;
        private com.tapsdk.tapad.internal.download.core.breakpoint.i c;
        private com.tapsdk.tapad.internal.download.core.connection.a.b d;
        private com.tapsdk.tapad.internal.download.m.g.e e;
        private com.tapsdk.tapad.internal.download.m.e.g f;
        private com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a g;
        private d h;
        private final Context i;

        public a(Context context) {
            this.i = context.getApplicationContext();
        }

        public a a(com.tapsdk.tapad.internal.download.core.breakpoint.i iVar) {
            this.c = iVar;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.core.connection.a.b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.m.d.a aVar) {
            this.b = aVar;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.m.d.b bVar) {
            this.a = bVar;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.m.e.g gVar) {
            this.f = gVar;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a interfaceC0611a) {
            this.g = interfaceC0611a;
            return this;
        }

        public a a(com.tapsdk.tapad.internal.download.m.g.e eVar) {
            this.e = eVar;
            return this;
        }

        public i a() {
            if (this.a == null) {
                this.a = new com.tapsdk.tapad.internal.download.m.d.b();
            }
            if (this.b == null) {
                this.b = new com.tapsdk.tapad.internal.download.m.d.a();
            }
            if (this.c == null) {
                this.c = com.tapsdk.tapad.internal.download.m.c.a(this.i);
            }
            if (this.d == null) {
                this.d = com.tapsdk.tapad.internal.download.m.c.a();
            }
            if (this.g == null) {
                this.g = new com.tapsdk.tapad.internal.download.m.g.b.a();
            }
            if (this.e == null) {
                this.e = new com.tapsdk.tapad.internal.download.m.g.e();
            }
            if (this.f == null) {
                this.f = new com.tapsdk.tapad.internal.download.m.e.g();
            }
            i iVar = new i(this.i, this.a, this.b, this.c, this.d, this.g, this.e, this.f);
            iVar.a(this.h);
            com.tapsdk.tapad.internal.download.m.c.a("OkDownload", "downloadStore[" + this.c + "] connectionFactory[" + this.d);
            return iVar;
        }
    }

    i(Context context, com.tapsdk.tapad.internal.download.m.d.b bVar, com.tapsdk.tapad.internal.download.m.d.a aVar, com.tapsdk.tapad.internal.download.core.breakpoint.i iVar, com.tapsdk.tapad.internal.download.core.connection.a.b bVar2, com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a interfaceC0611a, com.tapsdk.tapad.internal.download.m.g.e eVar, com.tapsdk.tapad.internal.download.m.e.g gVar) {
        this.h = context;
        this.a = bVar;
        this.b = aVar;
        this.c = iVar;
        this.d = bVar2;
        this.e = interfaceC0611a;
        this.f = eVar;
        this.g = gVar;
        bVar.a(com.tapsdk.tapad.internal.download.m.c.a(iVar));
    }

    public static void a(i iVar) {
        if (j != null) {
            throw new IllegalArgumentException("OkDownload must be null.");
        }
        synchronized (i.class) {
            if (j != null) {
                throw new IllegalArgumentException("OkDownload must be null.");
            }
            j = iVar;
        }
    }

    public static i j() {
        if (j == null) {
            synchronized (i.class) {
                if (j == null) {
                    if (OkDownloadProvider.a == null) {
                        Context context = com.tapsdk.tapad.c.a;
                        OkDownloadProvider.a = context;
                        if (context == null) {
                            throw new IllegalStateException("context == null");
                        }
                    }
                    j = new a(OkDownloadProvider.a).a();
                }
            }
        }
        return j;
    }

    public com.tapsdk.tapad.internal.download.core.breakpoint.g a() {
        return this.c;
    }

    public void a(d dVar) {
        this.i = dVar;
    }

    public com.tapsdk.tapad.internal.download.m.d.a b() {
        return this.b;
    }

    public com.tapsdk.tapad.internal.download.core.connection.a.b c() {
        return this.d;
    }

    public Context d() {
        return this.h;
    }

    public com.tapsdk.tapad.internal.download.m.d.b e() {
        return this.a;
    }

    public com.tapsdk.tapad.internal.download.m.e.g f() {
        return this.g;
    }

    public d g() {
        return this.i;
    }

    public com.tapsdk.tapad.internal.download.m.g.a.InterfaceC0611a h() {
        return this.e;
    }

    public com.tapsdk.tapad.internal.download.m.g.e i() {
        return this.f;
    }
}
