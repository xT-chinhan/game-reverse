package com.byazt.su;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 8})
public class s extends com.byazt.ta.fs<Long, com.byazt.vl.qg> {

    @com.byazt.cp.n(n = {0, 1, 726, 546})
    private static class n {
        public static s n = new s();
    }

    public static s n() {
        return n.n;
    }

    private s() {
        super(16, 16);
    }

    public void n(com.byazt.vl.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        put(Long.valueOf(qgVar.n()), qgVar);
    }

    public com.byazt.vl.qg n(long j, long j2) {
        return (com.byazt.vl.qg) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }
}
