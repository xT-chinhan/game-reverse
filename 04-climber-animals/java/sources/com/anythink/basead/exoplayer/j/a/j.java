package com.anythink.basead.exoplayer.j.a;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class j {
    private static final String a = "exo_";
    private static final String b = "exo_redir";
    private static final String c = "exo_len";

    public static long a(i iVar) {
        return iVar.a(c);
    }

    public static void a(k kVar, long j) {
        kVar.a(c, j);
    }

    private static void a(k kVar) {
        kVar.a(c);
    }

    private static Uri b(i iVar) {
        String strA = iVar.a(b, (String) null);
        if (strA == null) {
            return null;
        }
        return Uri.parse(strA);
    }

    public static void a(k kVar, Uri uri) {
        kVar.a(b, uri.toString());
    }

    private static void b(k kVar) {
        kVar.a(b);
    }

    private j() {
    }
}
