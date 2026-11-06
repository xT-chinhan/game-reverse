package com.anythink.core.common.t.a.b.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.f.j;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.u;
import com.anythink.core.e.d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<u> {
    public static final String a = "a";
    private static volatile long d = 0;
    private static final long e = 2000;
    private static final long f = 100;
    private boolean c = false;

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final /* synthetic */ boolean a(u uVar) {
        return d2(uVar);
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final /* synthetic */ boolean b(u uVar) {
        return c2(uVar);
    }

    private boolean d() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - d < e) {
                return false;
            }
            d = jElapsedRealtime;
            com.anythink.core.common.t.a.a.a();
            return com.anythink.core.common.t.a.a.a.a(j.a(this.b)).c() >= Math.max(f, com.anythink.core.common.t.a.a.i().b() * 2);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final boolean b() {
        return com.anythink.core.common.t.a.a.a().c();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static boolean c2(u uVar) {
        int i;
        bw bwVarF;
        boolean z = true;
        if ("1004742".equals(uVar.c)) {
            return true;
        }
        if (TextUtils.isEmpty(uVar.c)) {
            return false;
        }
        try {
            i = TextUtils.isEmpty(uVar.T) ? 0 : Integer.parseInt(uVar.T);
        } catch (Throwable unused) {
        }
        String str = uVar.S;
        com.anythink.core.e.b bVarA = d.a();
        if (bVarA == null || (bwVarF = bVarA.f(uVar.c)) == null) {
            return false;
        }
        List<String> listA = bwVarF.a();
        List<String> listB = bwVarF.b();
        boolean z2 = i > 0;
        boolean z3 = !TextUtils.isEmpty(str);
        if (z2 && z3) {
            if (listB == null) {
                return false;
            }
            if (!listB.contains(String.valueOf(i)) && !listB.contains("0")) {
                return false;
            }
            if (listA == null || !listA.contains(str)) {
                z = false;
            }
        } else if ((z2 || z3) && (!z2 ? listA == null || !listA.contains(str) : listB == null || (!listB.contains(String.valueOf(i)) && !listB.contains("0")))) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method */
    private static boolean d2(u uVar) {
        com.anythink.core.e.b bVarA = d.a();
        if (bVarA == null) {
            return false;
        }
        return com.anythink.core.common.t.c.a.a(bVarA, uVar);
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    public final void c() {
        this.c = false;
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void d(u uVar) {
        if (com.anythink.core.common.t.a.a.a().c()) {
            return;
        }
        uVar.j = String.valueOf(System.currentTimeMillis());
        if (d2(uVar)) {
            return;
        }
        c(uVar);
        if (c2(uVar)) {
            this.c = true;
            a();
        } else if (d()) {
            com.anythink.core.common.t.a.a.a().e();
            new com.anythink.core.common.t.a.b.a.b.b().a(false);
        }
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final void a() {
        if (com.anythink.core.common.t.a.a.a().c()) {
            return;
        }
        new com.anythink.core.common.t.a.b.a.b.b().a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.core.common.t.a.b.a.b
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void c(u uVar) {
        if (com.anythink.core.common.t.a.a.a().c()) {
            return;
        }
        try {
            com.anythink.core.common.t.a.b.a.a.a aVar = new com.anythink.core.common.t.a.b.a.a.a();
            aVar.e = uVar.a().toString();
            if (TextUtils.isEmpty(aVar.e)) {
                return;
            }
            com.anythink.core.common.t.a.a.a.a(j.a(this.b)).a(aVar);
        } catch (Throwable unused) {
        }
    }
}
