package com.byazt.xid;

import android.os.Build;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 582, 20})
public class hn implements c.pr {
    @Override // com.byazt.xid.c.pr
    public boolean pr(String str, int i) {
        String strHw = com.byazt.wo.hn.hw(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strHw)));
        String strHn = com.byazt.wo.hn.hn(str, i);
        String str2 = strHn + File.separator + "compFully" + hw.hw(strHw);
        String str3 = strHn + File.separator + hw.pr(strHw);
        if (!hw(strHw, str2)) {
            return false;
        }
        pr(str2, str3);
        boolean zPr = hw.pr(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zPr)));
        return zPr;
    }

    private void pr(String str, String str2) {
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

    private static boolean hw(String str, String str2) {
        try {
            return pr.pr(hw.pr(str, str2, hw.hw));
        } catch (Exception e) {
            return false;
        }
    }
}
