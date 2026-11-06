package com.smartdigimkt.t4;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {
    public com.smartdigimkt.e1.d a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    public static void a(g gVar, String str, String str2, AdError adError) {
        byte b;
        if (gVar == null) {
            return;
        }
        try {
            switch (str) {
                case "request_result":
                    b = 0;
                    break;
                case "rewarded":
                    b = 4;
                    break;
                case "click":
                    b = 2;
                    break;
                case "close":
                    b = 3;
                    break;
                case "impression":
                    b = 5;
                    break;
                case "show_failed":
                    b = 1;
                    break;
                case "deeplink":
                    b = 9;
                    break;
                case "play_end":
                    b = 7;
                    break;
                case "play_error":
                    b = 8;
                    break;
                case "play_start":
                    b = 6;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                if (b == 1) {
                    ((a) gVar).a(adError);
                    return;
                } else {
                    if (b != 9) {
                        return;
                    }
                    "success".equals(str2);
                    return;
                }
            }
            if ("success".equals(str2)) {
                return;
            }
            if (!"fail".equals(str2)) {
                "timeout".equals(str2);
            } else if (adError instanceof com.smartdigimkt.z3.a) {
                com.smartdigimkt.r4.w.a(((com.smartdigimkt.z3.a) adError).a, "request_result", "fail", adError.getErrorInfo());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(AdError adError) {
        com.smartdigimkt.e1.d dVar = this.a;
        if (dVar == null) {
            return;
        }
        try {
            com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c("", null);
            cVar.a = "3000002";
            com.smartdigimkt.f3.a aVar = dVar.l;
            if (aVar != null) {
                cVar.a(aVar);
                com.smartdigimkt.p4.e eVarB = com.smartdigimkt.o4.o.a().b(aVar.b);
                cVar.i = eVarB != null ? eVarB.C : "";
            }
            cVar.l = adError != null ? adError.getCode() : "";
            cVar.m = adError != null ? adError.getMessage() : "";
            com.smartdigimkt.b3.b bVar = dVar.e;
            cVar.n = bVar != null ? bVar.a : "";
            if (bVar instanceof com.smartdigimkt.b3.b) {
                cVar.o = bVar.c0;
            }
            com.smartdigimkt.n3.k.a(cVar);
        } catch (Throwable unused) {
        }
    }
}
