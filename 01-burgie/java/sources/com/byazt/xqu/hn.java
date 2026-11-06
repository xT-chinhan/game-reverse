package com.byazt.xqu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 20})
public class hn extends com.byazt.tuy.zo<Long, com.byazt.shh.hw> {

    @com.byazt.vzx.pr(pr = {0, 1, 432, 116})
    private static class pr {
        public static hn pr = new hn();
    }

    public static hn pr() {
        return pr.pr;
    }

    private hn() {
        super(16, 16);
    }

    public void pr(com.byazt.shh.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        put(Long.valueOf(hwVar.pr()), hwVar);
    }

    public com.byazt.shh.hw pr(long j, long j2) {
        return (com.byazt.shh.hw) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }
}
