package com.meta.android.mpg.cm.core;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
final class b {
    private static boolean a = false;
    private static String b;

    static String a() {
        return (!b() || TextUtils.isEmpty(b)) ? "" : b;
    }

    private static String a(String str, String str2) {
        String strReplace = str.replace(str2, "");
        c1m.m2a.m1g.b.a().a("MetaAdEnv", "path", strReplace);
        return strReplace.split("/")[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004c, code lost:
    
        if (r0.startsWith("/data/user/0/") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(android.content.Context r7) {
        /*
            java.io.File r0 = r7.getCacheDir()
            java.lang.String r0 = r0.getAbsolutePath()
            c1m.m2a.m1g.a r1 = c1m.m2a.m1g.b.a()
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "check path"
            r5 = 0
            r3[r5] = r4
            r4 = 1
            r3[r4] = r0
            java.lang.String r6 = "MetaAdEnv"
            r1.a(r6, r3)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L4f
            java.lang.String r1 = "l/d"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L4f
            c1m.m2a.m1g.a r7 = c1m.m2a.m1g.b.a()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r3 = "inside"
            r1[r5] = r3
            r7.a(r6, r1)
            com.meta.android.mpg.cm.core.b.a = r4
            java.lang.String r7 = "/data/data/"
            boolean r1 = r0.startsWith(r7)
            if (r1 == 0) goto L46
        L41:
            java.lang.String r7 = a(r0, r7)
            goto L55
        L46:
            java.lang.String r7 = "/data/user/0/"
            boolean r1 = r0.startsWith(r7)
            if (r1 == 0) goto L57
            goto L41
        L4f:
            com.meta.android.mpg.cm.core.b.a = r5
            java.lang.String r7 = r7.getPackageName()
        L55:
            com.meta.android.mpg.cm.core.b.b = r7
        L57:
            c1m.m2a.m1g.a r7 = c1m.m2a.m1g.b.a()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "channelPackage"
            r0[r5] = r1
            java.lang.String r1 = com.meta.android.mpg.cm.core.b.b
            r0[r4] = r1
            r7.a(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meta.android.mpg.cm.core.b.a(android.content.Context):void");
    }

    static boolean b() {
        return a;
    }
}
