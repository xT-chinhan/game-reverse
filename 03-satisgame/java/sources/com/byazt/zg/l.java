package com.byazt.zg;

import com.byazt.qp.x;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 732, 18})
public final class l {
    public static String n(String str, String str2) {
        return str + str2;
    }

    public static boolean qg(String str, String str2) {
        File fileQ = q(str, str2);
        return fileQ != null && fileQ.exists();
    }

    public static boolean s(String str, String str2) {
        try {
            return n(l(str, str2)) || n(q(str, str2));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static com.byazt.vf.n n(String str) {
        return com.byazt.vgx.s.n().n(str);
    }

    private static File q(String str, String str2) {
        try {
            return x.s(com.byazt.sl.n.qg(n(str), com.byazt.lk.q.n(str2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static File l(String str, String str2) {
        File fileQ = q(str, str2);
        if (fileQ == null) {
            return null;
        }
        return new File(fileQ.getPath() + ".bak");
    }

    private static boolean n(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
