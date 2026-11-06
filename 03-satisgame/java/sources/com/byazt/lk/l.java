package com.byazt.lk;

import com.byazt.gwu.x;
import com.byazt.vf.ae;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1266, 18})
public class l {
    public static boolean n() {
        return (com.byazt.tz.n.qg().s() & 2) == 2;
    }

    public static boolean qg() {
        return (com.byazt.tz.n.qg().s() & 4) == 4;
    }

    private static com.byazt.vf.n n(String str) {
        return com.byazt.vgx.s.n().n(str);
    }

    public static com.byazt.gwu.s n(String str, String str2) {
        return ((ae) com.byazt.qp.q.n("storage_service")).qg(n(str), str2);
    }

    public static com.byazt.gwu.l qg(String str, String str2) {
        return ((ae) com.byazt.qp.q.n("storage_service")).n(n(str), str2);
    }

    public static x s(String str, String str2) {
        return ((ae) com.byazt.qp.q.n("storage_service")).s(n(str), str2);
    }

    public static com.byazt.gwu.l n(String str, String str2, int i, Map<String, Object> map) {
        return ((ae) com.byazt.qp.q.n("storage_service")).n(n(str), str2, i, map);
    }

    public static com.byazt.gwu.s qg(String str, String str2, int i, Map<String, Object> map) {
        return ((ae) com.byazt.qp.q.n("storage_service")).qg(n(str), str2, i, map);
    }
}
