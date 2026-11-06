package com.bytedance.pangle.c;

import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements c.ms {
    @Override // com.bytedance.pangle.c.c.ms
    public boolean ms(String str, int i) {
        String strMs = ab.ms(str, i);
        String strAh = com.bytedance.pangle.ka.ah.ah(str, i);
        String[] strArrSplit = strMs.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(String.valueOf(strMs)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = strArrSplit.length;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            String str2 = strArrSplit[i2];
            if (ms(str2, strAh + File.separator + xr.ms(str2))) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
                i2++;
                z2 = true;
            } else {
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result:" + z);
                return z;
            }
        }
        z = z2;
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " result:" + z);
        return z;
    }

    private boolean ms(String str, String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
