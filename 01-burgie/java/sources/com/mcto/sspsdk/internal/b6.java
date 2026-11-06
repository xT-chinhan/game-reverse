package com.mcto.sspsdk.internal;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class b6 implements Runnable {
    public final /* synthetic */ a6 a;
    public final /* synthetic */ o0 b;

    public b6(a6 a6Var, o0 o0Var) {
        this.a = a6Var;
        this.b = o0Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strSubstring;
        a6 a6Var = this.a;
        o0 o0Var = this.b;
        String str = a6Var.a;
        String strD = gj.d(str);
        if (a6Var.c == null) {
            StringBuilder sbAppend = new StringBuilder().append(strD);
            if (lj.b(str)) {
                strSubstring = "";
            } else {
                int iIndexOf = str.indexOf(63);
                String strSubstring2 = iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
                int iLastIndexOf = strSubstring2.lastIndexOf(46);
                strSubstring = iLastIndexOf > 0 ? strSubstring2.substring(iLastIndexOf) : str;
            }
            a6Var.c = sbAppend.append(strSubstring).toString();
        }
        File file = new File(a6Var.b, a6Var.c);
        if (file.exists()) {
            a6Var.e = file.length();
            if (a6Var.a() == null) {
                return;
            }
            if ("html".equals(o0Var.a)) {
                zg.a.a(new o4(a6Var.a()));
                return;
            } else {
                n4.a().a(new File(a6Var.a()), o0Var.a);
                return;
            }
        }
        for (int i = 0; i < a6Var.f; i++) {
            try {
                int iA = c6.a(a6Var, str, strD);
                if (iA == 200 || iA == 206) {
                    File file2 = new File(a6Var.b, strD + ".cdf");
                    if (file2.exists()) {
                        file2.renameTo(file);
                    }
                    if (a6Var.a() == null) {
                        return;
                    }
                    if ("html".equals(o0Var.a)) {
                        zg.a.a(new o4(a6Var.a()));
                        return;
                    } else {
                        n4.a().a(new File(a6Var.a()), o0Var.a);
                        return;
                    }
                }
            } catch (Exception e) {
                r9.a("ssp_file_download", "downloadFile: ", e);
            }
        }
    }
}
