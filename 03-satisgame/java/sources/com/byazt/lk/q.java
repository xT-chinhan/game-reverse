package com.byazt.lk;

import android.util.SparseArray;
import com.byazt.gwu.fs;
import com.byazt.gwu.x;
import com.byazt.nf.rv;
import com.byazt.vf.ae;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1266, 5})
public final class q implements ae, Function {
    public static final Map<String, com.byazt.gwu.l> n = new ConcurrentHashMap();
    public static final Map<String, com.byazt.gwu.s> qg = new ConcurrentHashMap();
    public static final Map<String, x> s = new ConcurrentHashMap();
    public static final n<com.byazt.gwu.l> q = new n<com.byazt.gwu.l>() { // from class: com.byazt.lk.q.1
        @Override // com.byazt.lk.q.n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public com.byazt.gwu.l qg(com.byazt.eau.l lVar) {
            return new s(lVar);
        }
    };
    public static final n<com.byazt.gwu.s> l = new n<com.byazt.gwu.s>() { // from class: com.byazt.lk.q.2
        @Override // com.byazt.lk.q.n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public com.byazt.gwu.s qg(com.byazt.eau.l lVar) {
            return new qg(lVar);
        }
    };
    public static final n<x> w = new n<x>() { // from class: com.byazt.lk.q.3
        @Override // com.byazt.lk.q.n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public x qg(com.byazt.eau.l lVar) {
            return new w(lVar);
        }
    };

    private interface n<S> {
        S qg(com.byazt.eau.l lVar);
    }

    public static int n() {
        return 3;
    }

    private static int n(int i) {
        if (i == 2) {
            return 2;
        }
        return i == 1 ? 1 : 0;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object objQg = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (objQg != null) {
                    objQg = com.byazt.qp.q.qg((String) objQg);
                }
                com.byazt.gwu.l lVarN = n((com.byazt.vf.n) objQg, (String) obj2);
                return lVarN != null ? new com.byazt.gwu.w(lVarN) : lVarN;
            case 2:
                Object objQg2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (objQg2 != null) {
                    objQg2 = com.byazt.qp.q.qg((String) objQg2);
                }
                com.byazt.gwu.s sVarQg = qg((com.byazt.vf.n) objQg2, (String) obj3);
                return sVarQg != null ? new com.byazt.gwu.q(sVarQg) : sVarQg;
            case 3:
                Object objQg3 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                if (objQg3 != null) {
                    objQg3 = com.byazt.qp.q.qg((String) objQg3);
                }
                x xVarS = s((com.byazt.vf.n) objQg3, (String) obj4);
                return xVarS != null ? new fs(xVarS) : xVarS;
            case 4:
                Object objQg4 = sparseArray.get(1);
                Object obj5 = sparseArray.get(2);
                Object obj6 = sparseArray.get(3);
                Object obj7 = sparseArray.get(4);
                if (objQg4 != null) {
                    objQg4 = com.byazt.qp.q.qg((String) objQg4);
                }
                com.byazt.gwu.l lVarN2 = n((com.byazt.vf.n) objQg4, (String) obj5, ((Integer) obj6).intValue(), (Map) obj7);
                return lVarN2 != null ? new com.byazt.gwu.w(lVarN2) : lVarN2;
            case 5:
                Object objQg5 = sparseArray.get(1);
                Object obj8 = sparseArray.get(2);
                Object obj9 = sparseArray.get(3);
                Object obj10 = sparseArray.get(4);
                if (objQg5 != null) {
                    objQg5 = com.byazt.qp.q.qg((String) objQg5);
                }
                com.byazt.gwu.s sVarQg2 = qg((com.byazt.vf.n) objQg5, (String) obj8, ((Integer) obj9).intValue(), (Map) obj10);
                return sVarQg2 != null ? new com.byazt.gwu.q(sVarQg2) : sVarQg2;
            case 6:
                Object objQg6 = sparseArray.get(1);
                Object obj11 = sparseArray.get(2);
                Object obj12 = sparseArray.get(3);
                Object obj13 = sparseArray.get(4);
                if (objQg6 != null) {
                    objQg6 = com.byazt.qp.q.qg((String) objQg6);
                }
                x xVarS2 = s((com.byazt.vf.n) objQg6, (String) obj11, ((Integer) obj12).intValue(), (Map) obj13);
                return xVarS2 != null ? new fs(xVarS2) : xVarS2;
            default:
                return null;
        }
    }

    @Override // com.byazt.vf.ae
    public com.byazt.gwu.l n(com.byazt.vf.n nVar, String str) {
        boolean zQg = qg(str);
        if (zQg) {
            str = n(str);
        }
        String strN = com.byazt.sl.n.n(nVar, str);
        return (com.byazt.gwu.l) n(n, strN, nVar, zQg ? 1 : 0, q);
    }

    @Override // com.byazt.vf.ae
    public com.byazt.gwu.s qg(com.byazt.vf.n nVar, String str) {
        boolean zQg = qg(str);
        if (zQg) {
            str = n(str);
        }
        String strQg = com.byazt.sl.n.qg(nVar, str);
        return (com.byazt.gwu.s) n(qg, strQg, nVar, zQg ? 1 : 0, l);
    }

    @Override // com.byazt.vf.ae
    public x s(com.byazt.vf.n nVar, String str) {
        return (x) n(s, com.byazt.sl.n.s(nVar, str), nVar, 0, w);
    }

    @Override // com.byazt.vf.ae
    public com.byazt.gwu.l n(com.byazt.vf.n nVar, String str, int i, Map<String, Object> map) {
        return (com.byazt.gwu.l) n(n, com.byazt.sl.n.n(nVar, str, !n(map)), nVar, n(i), q);
    }

    @Override // com.byazt.vf.ae
    public com.byazt.gwu.s qg(com.byazt.vf.n nVar, String str, int i, Map<String, Object> map) {
        boolean z = !n(map);
        if (!qg(map)) {
            str = com.byazt.sl.n.qg(nVar, str, z);
        }
        return (com.byazt.gwu.s) n(qg, str, nVar, n(i), l);
    }

    @Override // com.byazt.vf.ae
    public x s(com.byazt.vf.n nVar, String str, int i, Map<String, Object> map) {
        return (x) n(s, com.byazt.sl.n.q(nVar, str), nVar, n(i), w);
    }

    private static <S> S n(Map<String, S> map, String str, com.byazt.vf.n nVar, int i, n<S> nVar2) {
        S s2 = map.get(str);
        if (s2 != null) {
            return s2;
        }
        S sQg = nVar2.qg(n(str, nVar != null && nVar.qg(), i));
        map.put(str, sQg);
        return sQg;
    }

    private static boolean qg(String str) {
        return str != null && str.startsWith("gm_") && str.length() > 3;
    }

    public static String n(String str) {
        return qg(str) ? str.substring(3) : str;
    }

    private static com.byazt.eau.l n(String str, boolean z, int i) {
        if (i == 1) {
            return qg().n(z).n(str).n();
        }
        return s().n(z).n(str).n();
    }

    private static boolean n(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("no_appid_prefix");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static boolean qg(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("keep_original_sp_name");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static com.byazt.uyg.q.n qg() {
        return new com.byazt.uyg.q.n().n(rv.getContext()).n(1);
    }

    private static com.byazt.uyg.q.n s() {
        com.byazt.tz.n.qg().l();
        return new com.byazt.uyg.q.n().n(rv.getContext()).n(1).qg(com.byazt.tz.n.qg().w());
    }
}
