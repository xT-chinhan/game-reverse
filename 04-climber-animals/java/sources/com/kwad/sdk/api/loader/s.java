package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class s {

    public interface c<T> {
        void j(T t);
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    static f<Boolean> Ds() {
        return new e(new g(new d(new h(new b()))));
    }

    static abstract class a<T> implements c<T> {
        c<T> auD;

        a(c<T> cVar) {
            this.auD = cVar;
        }
    }

    static class e implements f<Boolean> {
        f<com.kwad.sdk.api.loader.a.C0478a> auH;

        e(f<com.kwad.sdk.api.loader.a.C0478a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.auH.a(abVar, new c<com.kwad.sdk.api.loader.a.C0478a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(com.kwad.sdk.api.loader.a.C0478a c0478a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0478a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), getClass().getClassLoader(), c0478a.atD.getPath(), c0478a.sdkVersion)) {
                            a(c0478a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.q(abVar.getContext(), c0478a.sdkVersion);
                        j.j(c0478a.atD);
                        l.b(c0478a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.j(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0478a, 2, th);
                    }
                }

                private void a(com.kwad.sdk.api.loader.a.C0478a c0478a, int i, Throwable th) {
                    j.j(c0478a.atD);
                    l.b(c0478a, i, Log.getStackTraceString(th));
                }
            });
        }
    }

    static class g implements f<com.kwad.sdk.api.loader.a.C0478a> {
        f<com.kwad.sdk.api.loader.a.C0478a> auH;

        g(f<com.kwad.sdk.api.loader.a.C0478a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<com.kwad.sdk.api.loader.a.C0478a> cVar) {
            this.auH.a(abVar, new a<com.kwad.sdk.api.loader.a.C0478a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(com.kwad.sdk.api.loader.a.C0478a c0478a) {
                    try {
                        File file = c0478a.atD;
                        if (!x.k(file)) {
                            a(c0478a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!x.a(file, c0478a.md5)) {
                            a(c0478a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.j(c0478a);
                        }
                    } catch (Throwable th) {
                        a(c0478a, 3, th);
                    }
                }

                private void a(com.kwad.sdk.api.loader.a.C0478a c0478a, int i, Throwable th) {
                    j.j(c0478a.atD);
                    l.a(c0478a, i, th.getMessage());
                }
            });
        }
    }

    static class d implements f<com.kwad.sdk.api.loader.a.C0478a> {
        f<com.kwad.sdk.api.loader.a.C0478a> auH;

        d(f<com.kwad.sdk.api.loader.a.C0478a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0478a> cVar) {
            this.auH.a(abVar, new a<com.kwad.sdk.api.loader.a.C0478a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(com.kwad.sdk.api.loader.a.C0478a c0478a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileS = null;
                    try {
                        l.a(c0478a);
                        fileS = j.s(abVar.getContext(), c0478a.sdkVersion);
                        k.c(c0478a.atC, fileS);
                        l.a(c0478a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0478a.atD = fileS;
                        cVar.j(c0478a);
                    } catch (Throwable th) {
                        l.a(c0478a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileS);
                    }
                }
            });
        }
    }

    static class h implements f<com.kwad.sdk.api.loader.a.C0478a> {
        f<com.kwad.sdk.api.loader.a.C0478a> auH;

        h(f<com.kwad.sdk.api.loader.a.C0478a> fVar) {
            this.auH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0478a> cVar) {
            this.auH.a(abVar, new c<com.kwad.sdk.api.loader.a.C0478a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void j(com.kwad.sdk.api.loader.a.C0478a c0478a) {
                    String strAX = i.aX(abVar.getContext());
                    if (TextUtils.isEmpty(strAX)) {
                        strAX = com.kwad.sdk.api.c.Dd().getSDKVersion();
                    }
                    String str = c0478a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "interval", c0478a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0478a.Dj()) {
                        aa.be(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strAX);
                    } else if (i.L(c0478a.sdkVersion, strAX) && c0478a.Di()) {
                        cVar.j(c0478a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0478a.sdkVersion + " currentDynamicVersion:" + strAX + " dynamicType:" + c0478a.atB);
                    }
                }
            });
        }
    }

    static class b implements f<com.kwad.sdk.api.loader.a.C0478a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0478a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new com.kwad.sdk.api.loader.h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    public final void a(com.kwad.sdk.api.loader.a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.isLegal()) {
                            cVar.j(bVar.atE);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.aW(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
