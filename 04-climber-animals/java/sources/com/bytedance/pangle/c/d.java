package com.bytedance.pangle.c;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c.ms {
    @Override // com.bytedance.pangle.c.c.ms
    public boolean ms(String str, int i) {
        String strXr = com.bytedance.pangle.ka.ah.xr(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strXr)));
        String strAh = com.bytedance.pangle.ka.ah.ah(str, i);
        String str2 = strAh + File.separator + "compFully" + xr.xr(strXr);
        String str3 = strAh + File.separator + xr.ms(strXr);
        if (!xr(strXr, str2)) {
            return false;
        }
        ms(str2, str3);
        boolean zMs = xr.ms(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zMs)));
        return zMs;
    }

    private void ms(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        File file2 = new File(str.replace(".odex", ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(".odex", ".vdex")));
        }
    }

    private static boolean xr(String str, String str2) {
        try {
            return ms.ms(xr.ms(str, str2, xr.xr));
        } catch (Exception unused) {
            return false;
        }
    }
}
