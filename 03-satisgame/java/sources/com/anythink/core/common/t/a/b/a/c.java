package com.anythink.core.common.t.a.b.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f.j;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.o;
import com.anythink.core.e.d;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends b<o> {
    private static volatile long d = 0;
    private static final long e = 2000;
    private static final long f = 100;
    private final String a = "c";
    private boolean c = false;

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final /* synthetic */ boolean a(o oVar) {
        return d2(oVar);
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final /* synthetic */ boolean b(o oVar) {
        return c2(oVar);
    }

    private boolean d() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - d < e) {
                return false;
            }
            d = jElapsedRealtime;
            com.anythink.core.common.t.a.a.a();
            return com.anythink.core.common.t.a.a.b.a(j.a(this.b)).c() >= Math.max(f, com.anythink.core.common.t.a.a.i().a() * 2);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final boolean b() {
        return com.anythink.core.common.t.a.a.a().b();
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static boolean c2(o oVar) {
        bw bwVarA;
        bx bxVar = oVar.b;
        if (bxVar == null || !(bxVar instanceof n)) {
            return false;
        }
        int i = oVar.a;
        n nVar = (n) bxVar;
        int iZ = nVar.Z();
        if (iZ == 67) {
            return true;
        }
        String strAS = bxVar.aS();
        if (!TextUtils.isEmpty(nVar.az()) || !TextUtils.isEmpty(nVar.aA())) {
            return true;
        }
        com.anythink.core.e.b bVarA = d.a();
        if (bVarA == null || (bwVarA = bVarA.a(i)) == null) {
            return false;
        }
        List<String> listA = bwVarA.a();
        List<String> listB = bwVarA.b();
        boolean z = iZ > 0;
        boolean z2 = !TextUtils.isEmpty(strAS);
        if (z && z2) {
            if (listB == null) {
                return false;
            }
            if ((!listB.contains(String.valueOf(iZ)) && !listB.contains("0")) || listA == null || !listA.contains(strAS)) {
                return false;
            }
        } else if (z || z2) {
            if (z) {
                if (listB == null) {
                    return false;
                }
                if (!listB.contains(String.valueOf(iZ)) && !listB.contains("0")) {
                    return false;
                }
            } else if (listA == null || !listA.contains(strAS)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0045  */
    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method */
    private static boolean d2(o oVar) {
        com.anythink.core.e.b bVarA;
        Integer num;
        Map<String, Integer> map;
        if (s.b().A()) {
            return true;
        }
        bx bxVar = oVar.b;
        if (bxVar == null || (bVarA = d.a()) == null) {
            return false;
        }
        Map<String, Map<String, Integer>> mapAl = bVarA.al();
        if (mapAl == null || (map = mapAl.get(String.valueOf(oVar.a))) == null) {
            num = null;
        } else {
            String strAS = bxVar.aS();
            if (TextUtils.isEmpty(strAS)) {
                num = 0;
            } else {
                num = map.get(strAS);
                if (num == null) {
                    num = null;
                }
            }
        }
        if (num != null) {
            if (num.intValue() <= 0) {
                return true;
            }
            bxVar.b(oVar.a, num.intValue());
        }
        return false;
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    public final void c() {
        this.c = false;
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void d(o oVar) {
        if (com.anythink.core.common.t.a.a.a().b() || d2(oVar)) {
            return;
        }
        c(oVar);
        if (c2(oVar)) {
            this.c = true;
            a();
        } else if (d()) {
            com.anythink.core.common.t.a.a.a().e();
            new com.anythink.core.common.t.a.b.a.b.c().a(false);
        }
    }

    @Override // com.anythink.core.common.t.a.b.a.b
    protected final void a() {
        if (com.anythink.core.common.t.a.a.a().b()) {
            return;
        }
        new com.anythink.core.common.t.a.b.a.b.c().a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.core.common.t.a.b.a.b
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void c(o oVar) {
        if (com.anythink.core.common.t.a.a.a().b()) {
            return;
        }
        try {
            com.anythink.core.common.t.a.b.a.a.c cVar = new com.anythink.core.common.t.a.b.a.a.c();
            cVar.e = oVar.a().toString();
            if (TextUtils.isEmpty(cVar.e)) {
                return;
            }
            com.anythink.core.common.t.a.a.b.a(j.a(this.b)).a(cVar);
        } catch (Throwable unused) {
        }
    }
}
