package com.anythink.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";

    public final void a(Context context, v vVar, com.anythink.core.common.l.s sVar) {
        long jB;
        b bVarA;
        if (context == null) {
            return;
        }
        com.anythink.core.common.d.s.b().T();
        if (!(!ATSDK.isCnSDK() && ((bVarA = d.a()) == null || bVarA.aF()))) {
            a(context, vVar, sVar, false);
            return;
        }
        String strT = new com.anythink.core.common.l.g(context, vVar).t();
        if (TextUtils.isEmpty(strT)) {
            a(context, vVar, sVar, false);
            return;
        }
        com.anythink.core.common.l.e.j jVar = new com.anythink.core.common.l.e.j();
        b bVarA2 = d.a();
        if (bVarA2 != null) {
            jB = bVarA2.aH();
        } else {
            jB = b.b(0L);
        }
        long j = jB;
        new com.anythink.core.common.l.e.c(strT).a(new AnonymousClass2(jVar, sVar, context, vVar), j);
        try {
            jVar.a(com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new AnonymousClass3(jVar, context, vVar, sVar)), j));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, v vVar, com.anythink.core.common.l.s sVar, boolean z) {
        b bVarB = d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        com.anythink.core.common.i.a();
        final String strA = com.anythink.core.common.i.a(true);
        com.anythink.core.common.i.a();
        byte b = 0;
        final String strA2 = com.anythink.core.common.i.a(false);
        long jAM = bVarB != null ? bVarB.aM() : 10000L;
        long jAO = bVarB != null ? bVarB.aO() : 10000L;
        final a aVar = new a(b);
        aVar.a = context;
        aVar.b = vVar;
        aVar.c = strA;
        aVar.d = strA2;
        aVar.g = jAM;
        aVar.h = jAO;
        aVar.j = z;
        if (!ATSDK.isCnSDK()) {
            final com.anythink.core.common.l.p pVar = new com.anythink.core.common.l.p(sVar);
            a(false, aVar, (com.anythink.core.common.l.s) pVar);
            com.anythink.core.common.g.c.a().a(new com.anythink.core.common.g.d() { // from class: com.anythink.core.e.c.1
                @Override // com.anythink.core.common.g.d
                public final void a(String str, String str2) {
                    pVar.b();
                    String strE = com.anythink.core.common.u.p.e(strA);
                    String strE2 = com.anythink.core.common.u.p.e(strA2);
                    boolean z2 = (TextUtils.isEmpty(str) || str.equals(strE)) ? false : true;
                    boolean z3 = (TextUtils.isEmpty(str2) || str2.equals(strE2)) ? false : true;
                    if (z2 || z3) {
                        com.anythink.core.common.g.c.a().a(str, str2, strA, false, "");
                    }
                    com.anythink.core.common.g.c.a();
                    aVar.f = com.anythink.core.common.g.c.b(strA2, str2);
                    if (z2) {
                        com.anythink.core.common.g.c.a();
                        aVar.e = com.anythink.core.common.g.c.b(strA, str);
                        c.this.a(true, aVar, (com.anythink.core.common.l.s) pVar);
                        return;
                    }
                    pVar.a();
                }
            });
            return;
        }
        a(false, aVar, sVar);
    }

    private static boolean a() {
        if (ATSDK.isCnSDK()) {
            return false;
        }
        b bVarA = d.a();
        return bVarA == null || bVarA.aF();
    }

    private void c(Context context, v vVar, com.anythink.core.common.l.s sVar) {
        long jB;
        String strT = new com.anythink.core.common.l.g(context, vVar).t();
        if (TextUtils.isEmpty(strT)) {
            a(context, vVar, sVar, false);
            return;
        }
        com.anythink.core.common.l.e.j jVar = new com.anythink.core.common.l.e.j();
        b bVarA = d.a();
        if (bVarA != null) {
            jB = bVarA.aH();
        } else {
            jB = b.b(0L);
        }
        long j = jB;
        new com.anythink.core.common.l.e.c(strT).a(new AnonymousClass2(jVar, sVar, context, vVar), j);
        try {
            jVar.a(com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new AnonymousClass3(jVar, context, vVar, sVar)), j));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.e.c$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.core.common.l.c {
        final /* synthetic */ com.anythink.core.common.l.e.j a;
        final /* synthetic */ com.anythink.core.common.l.s b;
        final /* synthetic */ Context c;
        final /* synthetic */ v d;

        AnonymousClass2(com.anythink.core.common.l.e.j jVar, com.anythink.core.common.l.s sVar, Context context, v vVar) {
            this.a = jVar;
            this.b = sVar;
            this.c = context;
            this.d = vVar;
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            if (obj instanceof JSONObject) {
                if (this.a.a()) {
                    this.b.onLoadFinish(i, obj);
                }
            } else if (this.a.a()) {
                c.this.a(this.c, this.d, this.b, true);
            }
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
            if (this.a.a()) {
                c.this.a(this.c, this.d, this.b, true);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.e.c$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ com.anythink.core.common.l.e.j a;
        final /* synthetic */ Context b;
        final /* synthetic */ v c;
        final /* synthetic */ com.anythink.core.common.l.s d;

        AnonymousClass3(com.anythink.core.common.l.e.j jVar, Context context, v vVar, com.anythink.core.common.l.s sVar) {
            this.a = jVar;
            this.b = context;
            this.c = vVar;
            this.d = sVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.a()) {
                c.this.a(this.b, this.c, this.d, true);
            }
        }
    }

    public static void b(Context context, v vVar, com.anythink.core.common.l.s sVar) {
        if (context == null) {
            return;
        }
        new com.anythink.core.common.l.k(context, vVar).a(0, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final a aVar, final com.anythink.core.common.l.s sVar) {
        final String strF = aVar.b.f();
        final String strA = aVar.a(z);
        final String strB = aVar.b(z);
        new com.anythink.core.e.a.a(z, sVar) { // from class: com.anythink.core.e.c.4
            @Override // com.anythink.core.e.a.a
            protected final void a(int i, com.anythink.core.common.l.p pVar) {
                boolean z2 = i == 0;
                String str = z2 ? strA : strB;
                new com.anythink.core.common.l.g(aVar.a, aVar.b).b(str).b(z).a(aVar.j).a(i, (com.anythink.core.common.l.s) pVar);
                com.anythink.core.common.t.f.a(strF, z2 ? 1 : 2, str, 1, i(), j(), z, aVar.b.a());
            }

            @Override // com.anythink.core.e.a.a
            protected final boolean c() {
                if (TextUtils.equals(strB, aVar.i)) {
                    return false;
                }
                aVar.i = strB;
                return true;
            }

            @Override // com.anythink.core.e.a.a
            protected final long d() {
                return aVar.g;
            }

            @Override // com.anythink.core.e.a.a
            protected final long e() {
                return aVar.h;
            }

            @Override // com.anythink.core.e.a.a
            protected final void f() {
                com.anythink.core.common.t.f.a(strF, 0, "", 4, i(), j(), z, aVar.b.a());
                if (sVar != null) {
                    String str = "request timeout for main(backup) strategy (" + aVar.g + "/" + aVar.h + ")";
                    sVar.onLoadError(0, str, ErrorCode.getErrorCode(ErrorCode.exception, "", str));
                }
            }

            @Override // com.anythink.core.e.a.a
            protected final void b(int i, Object obj) {
                d.a(aVar.a).a(aVar.a, obj, com.anythink.core.common.d.s.b().p());
            }

            @Override // com.anythink.core.e.a.a
            protected final void a(boolean z2, int i) {
                boolean z3 = i == 0;
                com.anythink.core.common.t.f.a(strF, z3 ? 1 : 2, z3 ? strA : strB, z2 ? 2 : 3, i(), j(), z, aVar.b.a());
            }
        }.g();
    }

    private static class a {
        Context a;
        v b;
        String c;
        String d;
        String e;
        String f;
        long g;
        long h;
        String i;
        boolean j;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String a(boolean z) {
            if (z) {
                return this.e;
            }
            return this.c;
        }

        public final String b(boolean z) {
            if (z) {
                return this.f;
            }
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            return this.d;
        }
    }
}
