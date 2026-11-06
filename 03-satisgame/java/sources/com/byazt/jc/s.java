package com.byazt.jc;

import android.os.SystemClock;
import com.anythink.core.common.d.i;
import com.byazt.tbt.cy;
import com.byazt.tbt.hd;
import com.byazt.tbt.rv;
import com.byazt.tbt.sz;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1447, 8})
public class s {
    public static volatile long n = 0;
    public static volatile String qg = "0";

    public static String n() {
        return System.currentTimeMillis() - n < i.l.a ? qg : "0";
    }

    @com.byazt.cp.n(n = {0, 1, 1447, 546})
    public static class n implements rv {
        @Override // com.byazt.tbt.rv
        public cy n(rv.n nVar) throws IOException {
            hd hdVarX;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sz szVarN = nVar.n();
            cy cyVarN = nVar.n(szVarN);
            if (!TapHttp.METHOD_GET.equalsIgnoreCase(szVarN.q()) || (hdVarX = cyVarN.x()) == null) {
                return cyVarN;
            }
            long jN = hdVarX.n();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 0 && jN > 10240) {
                String unused = s.qg = String.format("%.2f", Double.valueOf(((jN / 1024.0d) / jElapsedRealtime2) * 1000.0d));
                long unused2 = s.n = System.currentTimeMillis();
                String unused3 = s.qg;
            }
            return cyVarN;
        }
    }
}
