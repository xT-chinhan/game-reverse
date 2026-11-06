package com.byazt.hi;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ej.k;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.z;
import com.byazt.tk.hd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 101})
public class fs {
    public static void n(long j, boolean z, boolean z2, pk pkVar, long j2, String str) {
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            str2 = z2 ? "load_video_success" : "load_video_error";
        } else {
            str2 = z2 ? "download_video_image_success" : "download_video_image_fail";
        }
        String str3 = str2;
        if (z) {
            Map<String, Object> mapN = com.byazt.vgx.w.n(z2, pkVar, jElapsedRealtime, j2, str);
            mapN.put("splash_show_type", 1);
            com.byazt.hm.n.l(pkVar, "splash_ad", str3, mapN);
        } else {
            Map<String, Object> mapQg = com.byazt.vgx.w.qg(z2, pkVar, jElapsedRealtime, j2, str);
            mapQg.put("splash_show_type", 2);
            com.byazt.hm.n.q(pkVar, "splash_ad", str3, mapQg);
        }
    }

    public static void n(com.byazt.gct.n nVar) {
        com.byazt.zsl.l lVarN;
        if (qg(nVar)) {
            pk pkVar = nVar.qg().get(0);
            int iCy = com.byazt.vgx.w.cy(pkVar);
            com.byazt.zsl.s sVarK = ta.k(pkVar);
            if (sVarK != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strD = sVarK.d();
                if (TextUtils.isEmpty(strD)) {
                    n(jElapsedRealtime, true, false, pkVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(sVarK.k())) {
                    com.byazt.tk.l.qg(strD);
                }
                if (pkVar.bi()) {
                    lVarN = ta.n(2, pkVar);
                } else {
                    lVarN = ta.n(3, pkVar);
                }
                lVarN.n("material_meta", pkVar);
                if (!com.byazt.nf.rv.qg().x(String.valueOf(iCy)) || hd.q(com.byazt.nf.rv.getContext())) {
                    sVarK.w(0);
                    com.byazt.lhs.n.n();
                    com.byazt.gks.s.n(lVarN, new com.byazt.pzg.n() { // from class: com.byazt.hi.fs.1
                        @Override // com.byazt.ej.tj.n
                        public void n(k kVar, int i, String str) {
                        }

                        @Override // com.byazt.ej.tj.n
                        public void qg(k kVar, int i) {
                        }
                    });
                }
            }
        }
    }

    public static boolean qg(com.byazt.gct.n nVar) {
        return (nVar == null || nVar.qg() == null || nVar.qg().isEmpty() || nVar.qg().get(0) == null) ? false : true;
    }

    public static int n(z zVar) {
        if (zVar == null) {
            return 0;
        }
        int iS = s(zVar.qg());
        return iS <= 0 ? n(zVar.n()) : iS;
    }

    public static int n(pk pkVar) {
        if (pkVar != null) {
            return com.byazt.vgx.w.cy(pkVar);
        }
        return 0;
    }

    public static int s(com.byazt.gct.n nVar) {
        if (nVar != null) {
            return nVar.n();
        }
        return 0;
    }

    public static boolean qg(pk pkVar) {
        if (pkVar == null || pkVar.ca() == 1 || ta.k(pkVar) == null || TextUtils.isEmpty(ta.n(pkVar))) {
            return true;
        }
        pkVar.sz(true);
        return false;
    }
}
