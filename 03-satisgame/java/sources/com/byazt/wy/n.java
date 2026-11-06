package com.byazt.wy;

import android.util.Pair;
import com.byazt.mf.l;
import com.byazt.nf.AdSdkInitializerHolder;
import com.byazt.qp.d;
import com.byazt.qp.fs;
import com.byazt.qp.k;
import com.byazt.qp.oa;
import com.byazt.qp.rv;
import com.byazt.qp.sz;
import com.byazt.qp.tj;
import com.byazt.qp.w;
import com.byazt.qp.x;
import com.byazt.si.f;
import com.byazt.zo.DispatchAdSdkInitializerHolder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1896, 19})
public class n {
    public tj n;

    private <T> T n(String str, com.byazt.vf.n nVar) {
        switch (str.hashCode()) {
            case -1665897765:
                return (T) new w();
            case -1562997167:
                return (T) new com.byazt.xc.n(com.byazt.imu.qg.getContext());
            case -1535463234:
                return (T) new sz();
            case -1503411564:
                return (T) new com.byazt.mf.qg();
            case -1422650072:
                return (T) new com.byazt.asa.s(nVar, com.byazt.imu.qg.getContext(), com.byazt.imu.qg.l());
            case -1271740834:
                return (T) new com.byazt.lk.n();
            case -1083272647:
                return (T) new com.byazt.gxb.qg(com.byazt.imu.qg.qg());
            case -1006435087:
                return (T) new com.byazt.lk.q();
            case -691529373:
                return (T) new f();
            case -428682880:
                return (T) new k();
            case 109:
                return (T) new DispatchAdSdkInitializerHolder();
            case 107809:
                return (T) new rv();
            case 108957:
                return (T) new l(com.byazt.qp.s.n());
            case 93922211:
                return (T) new AdSdkInitializerHolder();
            case 103593094:
                return (T) new fs();
            case 585701159:
                return (T) new com.byazt.mh.n();
            case 620599127:
                return (T) new com.byazt.jcx.n();
            case 658907061:
                return (T) new com.byazt.tka.w(com.byazt.imu.qg.q());
            case 788550538:
                return (T) new com.byazt.bl.n(nVar);
            case 1209788376:
                return (T) new x();
            case 1390272937:
                return (T) new com.byazt.wv.qg(com.byazt.imu.qg.getContext(), com.byazt.imu.qg.s());
            case 1407715928:
                return (T) new com.byazt.gwg.n(com.byazt.imu.qg.getContext(), com.byazt.imu.qg.n());
            case 1572865224:
                return (T) new com.byazt.qp.l(nVar);
            case 1717677983:
                return (T) new oa();
            case 1787798387:
                return (T) new com.byazt.aun.w();
            case 2144355422:
                return (T) new com.byazt.yl.n();
            default:
                return null;
        }
    }

    public com.byazt.vf.n n(String str) {
        return new com.byazt.qp.qg(str);
    }

    public void n(tj tjVar) {
        this.n = tjVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x009d */
    /* JADX WARN: Code duplicated, block: B:17:0x0024  */
    /* JADX WARN: Code duplicated, block: B:20:0x002a A[Catch: all -> 0x009f, TryCatch #7 {all -> 0x009f, blocks: (B:10:0x0015, B:18:0x0026, B:20:0x002a, B:22:0x002e, B:24:0x003b, B:27:0x0042), top: B:82:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x002e A[Catch: all -> 0x009f, TryCatch #7 {all -> 0x009f, blocks: (B:10:0x0015, B:18:0x0026, B:20:0x002a, B:22:0x002e, B:24:0x003b, B:27:0x0042), top: B:82:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x003b A[Catch: all -> 0x009f, TryCatch #7 {all -> 0x009f, blocks: (B:10:0x0015, B:18:0x0026, B:20:0x002a, B:22:0x002e, B:24:0x003b, B:27:0x0042), top: B:82:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0041 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0042 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #7 {all -> 0x009f, blocks: (B:10:0x0015, B:18:0x0026, B:20:0x002a, B:22:0x002e, B:24:0x003b, B:27:0x0042), top: B:82:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0049 A[Catch: all -> 0x0099, DONT_GENERATE, TryCatch #3 {all -> 0x0099, blocks: (B:28:0x0043, B:30:0x0049, B:32:0x004b, B:34:0x0051, B:35:0x0056, B:37:0x0058), top: B:76:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x004b A[Catch: all -> 0x0099, TryCatch #3 {all -> 0x0099, blocks: (B:28:0x0043, B:30:0x0049, B:32:0x004b, B:34:0x0051, B:35:0x0056, B:37:0x0058), top: B:76:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0051 A[Catch: all -> 0x0099, TryCatch #3 {all -> 0x0099, blocks: (B:28:0x0043, B:30:0x0049, B:32:0x004b, B:34:0x0051, B:35:0x0056, B:37:0x0058), top: B:76:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0058 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #3 {all -> 0x0099, blocks: (B:28:0x0043, B:30:0x0049, B:32:0x004b, B:34:0x0051, B:35:0x0056, B:37:0x0058), top: B:76:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0061 A[Catch: all -> 0x008f, TRY_ENTER, TryCatch #6 {all -> 0x008f, blocks: (B:40:0x0061, B:42:0x0065, B:44:0x0072), top: B:81:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0065 A[Catch: all -> 0x008f, TryCatch #6 {all -> 0x008f, blocks: (B:40:0x0061, B:42:0x0065, B:44:0x0072), top: B:81:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0072 A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #6 {all -> 0x008f, blocks: (B:40:0x0061, B:42:0x0065, B:44:0x0072), top: B:81:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:47:0x007a A[Catch: all -> 0x0089, TryCatch #2 {all -> 0x0089, blocks: (B:45:0x0076, B:47:0x007a, B:48:0x0081), top: B:74:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:76:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a0: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:63:0x00a0 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.util.function.Function, java.lang.Object> n(com.byazt.qp.d r7, com.byazt.vf.n r8, boolean r9) {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L24
            boolean r9 = r7.w()     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L24
            java.util.function.Function r9 = r7.qg()     // Catch: java.lang.Throwable -> L20
            if (r9 == 0) goto L1e
            java.lang.Object r1 = com.byazt.lx.n.n(r9, r7, r8)     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L26
            android.util.Pair r8 = new android.util.Pair     // Catch: java.lang.Throwable -> L9f
            r8.<init>(r9, r1)     // Catch: java.lang.Throwable -> L9f
            return r8
        L1b:
            r8 = move-exception
            goto La1
        L1e:
            r1 = r0
            goto L26
        L20:
            r8 = move-exception
            r9 = r0
            goto La1
        L24:
            r9 = r0
            r1 = r9
        L26:
            int r2 = r7.s     // Catch: java.lang.Throwable -> L9f
            if (r2 >= 0) goto L3b
            com.byazt.qp.tj r8 = r6.n     // Catch: java.lang.Throwable -> L9f
            if (r8 == 0) goto L3a
            java.lang.String r2 = r7.w     // Catch: java.lang.Throwable -> L9f
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L9f
            java.lang.String r4 = "version is not valid"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L9f
            r8.n(r2, r3)     // Catch: java.lang.Throwable -> L9f
        L3a:
            return r0
        L3b:
            android.util.Pair r2 = r6.n(r7, r8)     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L42
            return r2
        L42:
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L9f
            android.util.Pair r2 = r6.n(r7, r8)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L4b
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L99
            return r2
        L4b:
            java.lang.Object r2 = r7.n(r8)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L58
            android.util.Pair r8 = new android.util.Pair     // Catch: java.lang.Throwable -> L99
            r8.<init>(r9, r2)     // Catch: java.lang.Throwable -> L99
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L99
            return r8
        L58:
            java.lang.String r2 = r7.w     // Catch: java.lang.Throwable -> L99
            java.lang.Object r8 = r6.n(r2, r8)     // Catch: java.lang.Throwable -> L99
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L94
            if (r8 != 0) goto L72
            com.byazt.qp.tj r1 = r6.n     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L71
            java.lang.String r2 = r7.w     // Catch: java.lang.Throwable -> L8f
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8f
            java.lang.String r4 = "service creation failed"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8f
            r1.n(r2, r3)     // Catch: java.lang.Throwable -> L8f
        L71:
            return r0
        L72:
            com.byazt.qp.q r0 = com.byazt.qp.q.n()     // Catch: java.lang.Throwable -> L8f
            com.byazt.qp.tj r9 = r6.n     // Catch: java.lang.Throwable -> L89
            if (r9 == 0) goto L81
            java.lang.String r1 = r7.w     // Catch: java.lang.Throwable -> L89
            int r2 = r7.s     // Catch: java.lang.Throwable -> L89
            r9.n(r1, r8, r2)     // Catch: java.lang.Throwable -> L89
        L81:
            int r9 = r7.l()     // Catch: java.lang.Throwable -> L89
            r7.n(r9)     // Catch: java.lang.Throwable -> L89
            goto Lac
        L89:
            r9 = move-exception
            r5 = r0
            r0 = r8
            r8 = r9
            r9 = r5
            goto La1
        L8f:
            r0 = move-exception
            r5 = r0
            r0 = r8
            r8 = r5
            goto La1
        L94:
            r0 = move-exception
            r5 = r0
            r0 = r8
            r8 = r5
            goto L9b
        L99:
            r8 = move-exception
            r0 = r1
        L9b:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L9d
            throw r8     // Catch: java.lang.Throwable -> L1b
        L9d:
            r8 = move-exception
            goto L9b
        L9f:
            r8 = move-exception
            r0 = r1
        La1:
            com.byazt.qp.tj r1 = r6.n
            if (r1 == 0) goto Laa
            java.lang.String r7 = r7.w
            r1.n(r7, r8)
        Laa:
            r8 = r0
            r0 = r9
        Lac:
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.wy.n.n(com.byazt.qp.d, com.byazt.vf.n, boolean):android.util.Pair");
    }

    private Pair n(d dVar, com.byazt.vf.n nVar) {
        Object objN = dVar.n(nVar);
        if (!(objN instanceof Function)) {
            return null;
        }
        Function functionQg = com.byazt.lx.n.qg((Function) objN);
        Function functionQg2 = dVar.qg();
        if (functionQg2 == null) {
            functionQg2 = com.byazt.qp.q.n();
        }
        return new Pair(functionQg2, functionQg);
    }
}
