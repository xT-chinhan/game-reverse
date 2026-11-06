package com.tapsdk.tapad.internal.download;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class StatusUtil {

    public enum Status {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN
    }

    public static com.tapsdk.tapad.internal.download.core.breakpoint.c a(f fVar) {
        com.tapsdk.tapad.internal.download.core.breakpoint.g gVarA = i.j().a();
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVar = gVarA.get(gVarA.b(fVar));
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    static f a(String str, String str2, String str3) {
        return new f.a(str, str2, str3).a();
    }

    public static Status b(f fVar) {
        Status statusD = d(fVar);
        Status status = Status.COMPLETED;
        if (statusD == status) {
            return status;
        }
        com.tapsdk.tapad.internal.download.m.d.b bVarE = i.j().e();
        if (bVarE.i(fVar)) {
            return Status.PENDING;
        }
        return bVarE.j(fVar) ? Status.RUNNING : statusD;
    }

    public static com.tapsdk.tapad.internal.download.core.breakpoint.c b(String str, String str2, String str3) {
        return a(a(str, str2, str3));
    }

    public static Status c(String str, String str2, String str3) {
        return b(a(str, str2, str3));
    }

    public static boolean c(f fVar) {
        return d(fVar) == Status.COMPLETED;
    }

    public static Status d(f fVar) {
        com.tapsdk.tapad.internal.download.core.breakpoint.g gVarA = i.j().a();
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVar = gVarA.get(fVar.b());
        String strA = fVar.a();
        File fileC = fVar.c();
        File fileH = fVar.h();
        if (cVar != null) {
            if (!cVar.k() && cVar.h() <= 0) {
                return Status.UNKNOWN;
            }
            if (fileH != null && fileH.equals(cVar.d()) && fileH.exists() && cVar.i() == cVar.h()) {
                return Status.COMPLETED;
            }
            if (strA == null && cVar.d() != null && cVar.d().exists()) {
                return Status.IDLE;
            }
            if (fileH != null && fileH.equals(cVar.d()) && fileH.exists()) {
                return Status.IDLE;
            }
        } else {
            if (gVarA.a() || gVarA.a(fVar.b())) {
                return Status.UNKNOWN;
            }
            if (fileH != null && fileH.exists()) {
                return Status.COMPLETED;
            }
            String strA2 = gVarA.a(fVar.e());
            if (strA2 != null && new File(fileC, strA2).exists()) {
                return Status.COMPLETED;
            }
        }
        return Status.UNKNOWN;
    }

    public static boolean d(String str, String str2, String str3) {
        return c(a(str, str2, str3));
    }

    public static boolean e(f fVar) {
        return i.j().e().e(fVar) != null;
    }
}
