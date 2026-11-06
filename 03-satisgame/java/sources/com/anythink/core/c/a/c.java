package com.anythink.core.c.a;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.l.e.j;
import com.anythink.core.common.l.s;
import com.anythink.core.common.u.b.e;
import com.anythink.core.e.d;
import com.anythink.core.e.l;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";
    private final a b;
    private final String c;
    private final String d;

    public c(String str, String str2, String str3, List<JSONObject> list, int i, l lVar) {
        this.b = new a(str, str2, str3, list, i, lVar);
        this.c = str;
        this.d = str2;
    }

    public final void a(b bVar) {
        this.b.a(bVar);
    }

    private static boolean a() {
        if (ATSDK.isCnSDK()) {
            return false;
        }
        com.anythink.core.e.b bVarA = d.a();
        return bVarA == null || bVarA.aG();
    }

    private void a(int i, s sVar) {
        long jB;
        String strT = this.b.t();
        if (TextUtils.isEmpty(strT)) {
            this.b.a(i, sVar);
            return;
        }
        j jVar = new j();
        com.anythink.core.e.b bVarA = d.a();
        if (bVarA != null) {
            jB = bVarA.aH();
        } else {
            jB = com.anythink.core.e.b.b(0L);
        }
        new com.anythink.core.common.l.e.d(strT, this.c).a(new AnonymousClass1(jVar, sVar, i), jB);
        try {
            jVar.a(com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.a, new AnonymousClass2(jVar, i, sVar)), jB));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a.c$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.l.c {
        final /* synthetic */ j a;
        final /* synthetic */ s b;
        final /* synthetic */ int c;

        AnonymousClass1(j jVar, s sVar, int i) {
            this.a = jVar;
            this.b = sVar;
            this.c = i;
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            if (obj instanceof JSONObject) {
                if (this.a.a()) {
                    this.b.onLoadFinish(i, obj);
                }
            } else if (this.a.a()) {
                c.this.b.u();
                c.this.b.a(this.c, this.b);
            }
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
            if (this.a.a()) {
                c.this.b.u();
                c.this.b.a(this.c, this.b);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a.c$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ j a;
        final /* synthetic */ int b;
        final /* synthetic */ s c;

        AnonymousClass2(j jVar, int i, s sVar) {
            this.a = jVar;
            this.b = i;
            this.c = sVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.a()) {
                c.this.b.u();
                c.this.b.a(this.b, this.c);
            }
        }
    }

    public final void a(s sVar) {
        long jB;
        com.anythink.core.e.b bVarA;
        if (!(!ATSDK.isCnSDK() && ((bVarA = d.a()) == null || bVarA.aG()))) {
            this.b.a(0, sVar);
            return;
        }
        String strT = this.b.t();
        if (TextUtils.isEmpty(strT)) {
            this.b.a(0, sVar);
            return;
        }
        j jVar = new j();
        com.anythink.core.e.b bVarA2 = d.a();
        if (bVarA2 != null) {
            jB = bVarA2.aH();
        } else {
            jB = com.anythink.core.e.b.b(0L);
        }
        new com.anythink.core.common.l.e.d(strT, this.c).a(new AnonymousClass1(jVar, sVar, 0), jB);
        try {
            jVar.a(com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.a, new AnonymousClass2(jVar, 0, sVar)), jB));
        } catch (Throwable unused) {
        }
    }
}
