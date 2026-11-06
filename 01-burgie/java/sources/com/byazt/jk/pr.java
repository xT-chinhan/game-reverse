package com.byazt.jk;

import android.util.Pair;
import com.byazt.ld.ls;
import com.byazt.sd.AdSdkInitializerHolder;
import com.byazt.yn.c;
import com.byazt.zs.aj;
import com.byazt.zs.fw;
import com.byazt.zs.g;
import com.byazt.zs.ho;
import com.byazt.zs.k;
import com.byazt.zs.nt;
import com.byazt.zs.uc;
import com.byazt.zs.vk;
import com.byazt.zs.w;
import com.byazt.zs.zo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1123, 37})
public class pr {
    public k pr;

    private <T> T pr(String str, com.byazt.vkw.pr prVar) {
        switch (str.hashCode()) {
            case -1665897765:
                return (T) new zo();
            case -1562997167:
                return (T) new com.byazt.zs.hn(com.byazt.ub.pr.getContext());
            case -1535463234:
                return (T) new ho();
            case -1503411564:
                return (T) new com.byazt.yn.hw();
            case -1422650072:
                return (T) new com.byazt.yt.hn(prVar, com.byazt.ub.pr.getContext(), com.byazt.ub.pr.c());
            case -1083272647:
                return (T) new com.byazt.sl.hw(com.byazt.ub.pr.hw());
            case -1006435087:
                return (T) new com.byazt.qn.hn();
            case -691529373:
                return (T) new ls();
            case -428682880:
                return (T) new nt();
            case 107809:
                return (T) new w();
            case 108957:
                return (T) new c(com.byazt.zs.c.pr());
            case 93922211:
                return (T) new AdSdkInitializerHolder();
            case 103593094:
                return (T) new vk();
            case 620599127:
                return (T) new com.byazt.pm.pr();
            case 658907061:
                return (T) new com.byazt.zs.x(com.byazt.ub.pr.x());
            case 1209788376:
                return (T) new aj();
            case 1390272937:
                return (T) new com.byazt.zrg.hw(com.byazt.ub.pr.getContext(), com.byazt.ub.pr.hn());
            case 1407715928:
                return (T) new com.byazt.fg.pr(com.byazt.ub.pr.getContext(), com.byazt.ub.pr.pr());
            case 1572865224:
                return (T) new fw(prVar);
            default:
                return null;
        }
    }

    public com.byazt.vkw.pr pr(String str) {
        return new com.byazt.zs.hw(str);
    }

    public void pr(k kVar) {
        this.pr = kVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0094 */
    /* JADX WARN: Code duplicated, block: B:17:0x0026  */
    /* JADX WARN: Code duplicated, block: B:20:0x002c A[Catch: all -> 0x0096, TryCatch #5 {all -> 0x0096, blocks: (B:10:0x0017, B:18:0x0028, B:20:0x002c, B:22:0x0030, B:24:0x003d, B:27:0x0044), top: B:75:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0030 A[Catch: all -> 0x0096, TryCatch #5 {all -> 0x0096, blocks: (B:10:0x0017, B:18:0x0028, B:20:0x002c, B:22:0x0030, B:24:0x003d, B:27:0x0044), top: B:75:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x003d A[Catch: all -> 0x0096, TryCatch #5 {all -> 0x0096, blocks: (B:10:0x0017, B:18:0x0028, B:20:0x002c, B:22:0x0030, B:24:0x003d, B:27:0x0044), top: B:75:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0044 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #5 {all -> 0x0096, blocks: (B:10:0x0017, B:18:0x0028, B:20:0x002c, B:22:0x0030, B:24:0x003d, B:27:0x0044), top: B:75:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x004b A[Catch: all -> 0x0090, DONT_GENERATE, TryCatch #1 {all -> 0x0090, blocks: (B:28:0x0045, B:30:0x004b, B:32:0x004d, B:34:0x0053, B:35:0x0058, B:37:0x005a), top: B:69:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x004d A[Catch: all -> 0x0090, TryCatch #1 {all -> 0x0090, blocks: (B:28:0x0045, B:30:0x004b, B:32:0x004d, B:34:0x0053, B:35:0x0058, B:37:0x005a), top: B:69:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0053 A[Catch: all -> 0x0090, TryCatch #1 {all -> 0x0090, blocks: (B:28:0x0045, B:30:0x004b, B:32:0x004d, B:34:0x0053, B:35:0x0058, B:37:0x005a), top: B:69:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x005a A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #1 {all -> 0x0090, blocks: (B:28:0x0045, B:30:0x004b, B:32:0x004d, B:34:0x0053, B:35:0x0058, B:37:0x005a), top: B:69:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0063 A[Catch: all -> 0x0086, TRY_ENTER, TryCatch #4 {all -> 0x0086, blocks: (B:40:0x0063, B:42:0x0067, B:44:0x0074), top: B:74:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0067 A[Catch: all -> 0x0086, TryCatch #4 {all -> 0x0086, blocks: (B:40:0x0063, B:42:0x0067, B:44:0x0074), top: B:74:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0074 A[Catch: all -> 0x0086, TRY_LEAVE, TryCatch #4 {all -> 0x0086, blocks: (B:40:0x0063, B:42:0x0067, B:44:0x0074), top: B:74:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x009c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0097: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:60:0x0097 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.util.function.Function, java.lang.Object> pr(com.byazt.zs.g r7, com.byazt.vkw.pr r8, boolean r9) {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L26
            boolean r9 = r7.uc()     // Catch: java.lang.Throwable -> L22
            if (r9 == 0) goto L26
            java.util.function.Function r9 = r7.hw()     // Catch: java.lang.Throwable -> L22
            if (r9 == 0) goto L20
            java.lang.Object r1 = com.byazt.vs.pr.pr(r9, r7, r8)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L28
            android.util.Pair r8 = new android.util.Pair     // Catch: java.lang.Throwable -> L96
            r8.<init>(r9, r1)     // Catch: java.lang.Throwable -> L96
            return r8
        L1d:
            r8 = move-exception
            goto L98
        L20:
            r1 = r0
            goto L28
        L22:
            r8 = move-exception
            r9 = r0
            goto L98
        L26:
            r9 = r0
            r1 = r9
        L28:
            int r2 = r7.hn     // Catch: java.lang.Throwable -> L96
            if (r2 >= 0) goto L3d
            com.byazt.zs.k r8 = r6.pr     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L3c
            java.lang.String r2 = r7.uc     // Catch: java.lang.Throwable -> L96
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = "version is not valid"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L96
            r8.pr(r2, r3)     // Catch: java.lang.Throwable -> L96
        L3c:
            return r0
        L3d:
            android.util.Pair r2 = r6.pr(r7, r8)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L44
            return r2
        L44:
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L96
            android.util.Pair r2 = r6.pr(r7, r8)     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L4d
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L90
            return r2
        L4d:
            java.lang.Object r2 = r7.pr(r8)     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L5a
            android.util.Pair r8 = new android.util.Pair     // Catch: java.lang.Throwable -> L90
            r8.<init>(r9, r2)     // Catch: java.lang.Throwable -> L90
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L90
            return r8
        L5a:
            java.lang.String r2 = r7.uc     // Catch: java.lang.Throwable -> L90
            java.lang.Object r8 = r6.pr(r2, r8)     // Catch: java.lang.Throwable -> L90
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L8b
            if (r8 != 0) goto L74
            com.byazt.zs.k r1 = r6.pr     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L73
            java.lang.String r2 = r7.uc     // Catch: java.lang.Throwable -> L86
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "service creation failed"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L86
            r1.pr(r2, r3)     // Catch: java.lang.Throwable -> L86
        L73:
            return r0
        L74:
            com.byazt.zs.uc r0 = com.byazt.zs.uc.pr()     // Catch: java.lang.Throwable -> L86
            int r9 = r7.c()     // Catch: java.lang.Throwable -> L80
            r7.pr(r9)     // Catch: java.lang.Throwable -> L80
            goto La3
        L80:
            r9 = move-exception
            r5 = r0
            r0 = r8
            r8 = r9
            r9 = r5
            goto L98
        L86:
            r0 = move-exception
            r5 = r0
            r0 = r8
            r8 = r5
            goto L98
        L8b:
            r0 = move-exception
            r5 = r0
            r0 = r8
            r8 = r5
            goto L92
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L94
            throw r8     // Catch: java.lang.Throwable -> L1d
        L94:
            r8 = move-exception
            goto L92
        L96:
            r8 = move-exception
            r0 = r1
        L98:
            com.byazt.zs.k r1 = r6.pr
            if (r1 == 0) goto La1
            java.lang.String r7 = r7.uc
            r1.pr(r7, r8)
        La1:
            r8 = r0
            r0 = r9
        La3:
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.jk.pr.pr(com.byazt.zs.g, com.byazt.vkw.pr, boolean):android.util.Pair");
    }

    private Pair pr(g gVar, com.byazt.vkw.pr prVar) {
        Object objPr = gVar.pr(prVar);
        if (objPr instanceof Function) {
            Function functionHw = com.byazt.vs.pr.hw((Function) objPr);
            Function functionHw2 = gVar.hw();
            if (functionHw2 == null) {
                functionHw2 = uc.pr();
            }
            return new Pair(functionHw2, functionHw);
        }
        return null;
    }
}
