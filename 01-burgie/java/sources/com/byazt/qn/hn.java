package com.byazt.qn;

import android.os.Build;
import android.util.SparseArray;
import com.byazt.is.w;
import com.byazt.sd.a;
import com.byazt.vkw.s;
import com.byazt.zq.fw;
import com.byazt.zq.zo;
import com.byazt.zs.uc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 467, 20})
public final class hn implements s, Function {
    public static final Map<String, com.byazt.zq.c> pr = new ConcurrentHashMap();
    public static final Map<String, com.byazt.zq.hn> hw = new ConcurrentHashMap();
    public static final Map<String, fw> hn = new ConcurrentHashMap();

    @com.byazt.vzx.pr(pr = {0, 1, 467, 116})
    static class pr {
        public static final com.byazt.to.x.pr pr = hn.x();
        public static final com.byazt.to.x.pr hw = hn.hn();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object objHw = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (objHw != null) {
                    objHw = uc.hw((String) objHw);
                }
                com.byazt.zq.c cVarPr = pr((com.byazt.vkw.pr) objHw, (String) obj2);
                return cVarPr != null ? new com.byazt.zq.uc(cVarPr) : cVarPr;
            case 2:
                Object objHw2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (objHw2 != null) {
                    objHw2 = uc.hw((String) objHw2);
                }
                com.byazt.zq.hn hnVarHw = hw((com.byazt.vkw.pr) objHw2, (String) obj3);
                return hnVarHw != null ? new com.byazt.zq.x(hnVarHw) : hnVarHw;
            case 3:
                Object objHw3 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                if (objHw3 != null) {
                    objHw3 = uc.hw((String) objHw3);
                }
                fw fwVarHn = hn((com.byazt.vkw.pr) objHw3, (String) obj4);
                return fwVarHn != null ? new zo(fwVarHn) : fwVarHn;
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.s
    public com.byazt.zq.c pr(com.byazt.vkw.pr prVar, String str) {
        boolean z;
        com.byazt.zq.c hwVar;
        boolean z2 = true;
        if (str != null && str.startsWith("gm_") && str.length() > 3) {
            str = str.substring(3);
            z = true;
        } else {
            z = false;
        }
        String strPr = com.byazt.hm.pr.pr(prVar, str);
        Map<String, com.byazt.zq.c> map = pr;
        com.byazt.zq.c cVar = map.get(strPr);
        if (cVar != null) {
            return cVar;
        }
        synchronized (map) {
            hwVar = map.get(strPr);
            if (hwVar == null) {
                if (prVar == null || !prVar.hw()) {
                    z2 = false;
                }
                hwVar = new hw(pr(strPr, z2, z));
                map.put(strPr, hwVar);
            }
        }
        return hwVar;
    }

    @Override // com.byazt.vkw.s
    public com.byazt.zq.hn hw(com.byazt.vkw.pr prVar, String str) {
        boolean z;
        com.byazt.zq.hn prVar2;
        boolean z2 = true;
        if (str != null && str.startsWith("gm_") && str.length() > 3) {
            str = str.substring(3);
            z = true;
        } else {
            z = false;
        }
        String strHw = com.byazt.hm.pr.hw(prVar, str);
        Map<String, com.byazt.zq.hn> map = hw;
        com.byazt.zq.hn hnVar = map.get(strHw);
        if (hnVar != null) {
            return hnVar;
        }
        synchronized (map) {
            prVar2 = map.get(strHw);
            if (prVar2 == null) {
                if (prVar == null || !prVar.hw()) {
                    z2 = false;
                }
                prVar2 = new com.byazt.qn.pr(pr(strHw, z2, z));
                map.put(strHw, prVar2);
            }
        }
        return prVar2;
    }

    @Override // com.byazt.vkw.s
    public fw hn(com.byazt.vkw.pr prVar, String str) {
        fw cVar;
        String strHn = com.byazt.hm.pr.hn(prVar, str);
        Map<String, fw> map = hn;
        fw fwVar = map.get(strHn);
        if (fwVar != null) {
            return fwVar;
        }
        synchronized (map) {
            cVar = map.get(strHn);
            if (cVar == null) {
                cVar = new c(pr(strHn, prVar != null && prVar.hw(), false));
                map.put(strHn, cVar);
            }
        }
        return cVar;
    }

    private static com.byazt.cr.c pr(String str, boolean z, boolean z2) {
        if (z2) {
            return pr.hw.pr(z).pr(str).pr();
        }
        return pr.pr.pr(z).pr(str).pr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.to.x.pr hn() {
        return new com.byazt.to.x.pr().pr(a.getContext()).pr(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.to.x.pr x() {
        w wVarHw = a.hw();
        switch (wVarHw.lp()) {
            case 2:
                int i = Build.VERSION.SDK_INT;
                break;
        }
        return new com.byazt.to.x.pr().pr(a.getContext()).pr(1).hw(wVarHw.ig());
    }
}
