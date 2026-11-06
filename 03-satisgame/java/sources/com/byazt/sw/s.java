package com.byazt.sw;

import android.os.Build;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 96, 8})
public class s implements l.n {
    @Override // com.byazt.sw.l.n
    public boolean n(String str, int i) {
        String strQg = com.byazt.zi.s.qg(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strQg)));
        String strS = com.byazt.zi.s.s(str, i);
        String str2 = strS + File.separator + "compFully" + qg.qg(strQg);
        String str3 = strS + File.separator + qg.n(strQg);
        if (!qg(strQg, str2)) {
            return false;
        }
        n(str2, str3);
        boolean zN = qg.n(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zN)));
        return zN;
    }

    private void n(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        String str3 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(str.replace(str3, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(str3, ".vdex")));
        }
    }

    private static boolean qg(String str, String str2) {
        try {
            return n.n(qg.n(str, str2, qg.qg));
        } catch (Exception unused) {
            return false;
        }
    }
}
