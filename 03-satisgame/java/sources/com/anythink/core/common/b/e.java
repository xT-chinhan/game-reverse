package com.anythink.core.common.b;

import android.util.Pair;
import com.anythink.core.e.l;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final String a = "e";

    public static int a(l lVar, int i) {
        int iA;
        c cVarA = a(lVar);
        return (cVarA == null || (iA = cVarA.a()) <= 0) ? i : iA;
    }

    public static Pair<Boolean, Long> a(l lVar, boolean z) {
        long jB;
        c cVarA = f.a().a(lVar);
        if (cVarA != null) {
            jB = cVarA.b();
            if (jB == -1) {
                z = false;
            }
        } else {
            jB = 0;
        }
        return new Pair<>(Boolean.valueOf(z), Long.valueOf(jB));
    }

    public static boolean b(l lVar, boolean z) {
        c cVarA = a(lVar);
        if (cVarA == null || cVarA.c() != 2) {
            return z;
        }
        return false;
    }

    public static boolean c(l lVar, boolean z) {
        c cVarA = a(lVar);
        if (cVarA == null || cVarA.h() != 2) {
            return z;
        }
        return false;
    }

    public static h a(h hVar) {
        f.a();
        if (!f.b()) {
            return hVar;
        }
        a aVarD = f.d();
        h hVarC = aVarD != null ? aVarD.c() : null;
        return hVarC != null ? hVarC : hVar;
    }

    public static boolean a() {
        if (f.a().e()) {
            return true;
        }
        if (!f.b()) {
            return false;
        }
        a aVarD = f.d();
        return (aVarD != null ? aVarD.b() : 1) == 2;
    }

    private static c a(l lVar) {
        d dVarB;
        f fVarA = f.a();
        if (f.b() && (dVarB = fVarA.b(lVar)) != null) {
            return dVarB.b();
        }
        return null;
    }
}
