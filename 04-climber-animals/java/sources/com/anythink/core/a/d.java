package com.anythink.core.a;

import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.af;
import com.anythink.core.d.l;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static d a;
    private final String b = "pacing_";

    private static void b() {
    }

    private static void c() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public static int a(String str, l lVar) {
        if (lVar == null) {
            return 3;
        }
        int iA = b.a(t.b().g()).a(str, String.valueOf(lVar.aq()), lVar.ax());
        if (iA != b.n) {
            return iA;
        }
        if (!t.b().v()) {
            if (lVar.ax() == -1) {
                return b.n;
            }
            long jB = af.b(t.b().g(), u.b.a, "pacing_".concat(String.valueOf(str)), 0L);
            if (System.currentTimeMillis() - jB < 0) {
                return b.n;
            }
            if (System.currentTimeMillis() - jB < lVar.ax()) {
                return 3;
            }
        }
        return b.n;
    }

    public static int a(String str, bv bvVar) {
        if (bvVar == null) {
            return 3;
        }
        int iA = b.a(t.b().g()).a(String.valueOf(bvVar.g()), bvVar.z(), String.valueOf(bvVar.bf()), bvVar.y());
        if (iA != b.n) {
            return iA;
        }
        if (!t.b().v()) {
            if (bvVar.y() == -1) {
                return b.n;
            }
            long jB = af.b(t.b().g(), u.b.a, "pacing_" + str + "_" + bvVar.z(), 0L);
            if (System.currentTimeMillis() - jB < 0) {
                bvVar.z();
                return b.n;
            }
            if (System.currentTimeMillis() - jB < bvVar.y()) {
                return 3;
            }
        }
        return b.n;
    }
}
