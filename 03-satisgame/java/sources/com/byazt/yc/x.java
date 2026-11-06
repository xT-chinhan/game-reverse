package com.byazt.yc;

import com.byazt.vy.py;
import com.byazt.ws.tj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 21})
public class x {
    public static boolean n(int i) {
        return i >= -299 && i < -100;
    }

    public static boolean qg(int i) {
        return i == 0;
    }

    public static boolean s(int i) {
        return i == -100;
    }

    public static boolean n(int i, List<Integer> list) {
        if (py.n(list) || i >= list.size() || list.get(i).intValue() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static int n(com.byazt.ws.qg qgVar, tj tjVar) {
        if (qgVar == null || tjVar == null) {
            return -999;
        }
        if (qgVar.sz() && tjVar.fi()) {
            return tjVar.t();
        }
        return tjVar.h();
    }

    public static int n(com.byazt.ws.qg qgVar, com.byazt.sg.s sVar) {
        if (qgVar == null || sVar == null) {
            return -999;
        }
        if (qgVar.sz() && sVar.ze()) {
            return sVar.il();
        }
        return sVar.la();
    }

    public static Map<Integer, List<tj>> n(List<tj> list, boolean z) {
        int iH;
        HashMap map = new HashMap();
        if (py.n(list)) {
            return map;
        }
        for (int i = 0; i < list.size(); i++) {
            tj tjVar = list.get(i);
            if (tjVar != null) {
                if (z && tjVar.fi()) {
                    iH = tjVar.t();
                } else {
                    iH = tjVar.h();
                }
                List arrayList = (List) map.get(Integer.valueOf(iH));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(tjVar);
                map.put(Integer.valueOf(iH), arrayList);
            }
        }
        return map;
    }

    public static List<tj> n(List<tj> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tj tjVar : list) {
            if (tjVar != null && tjVar.um() == 100) {
                arrayList.add(tjVar);
            }
        }
        return arrayList;
    }

    public static List<tj> qg(List<tj> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tj tjVar : list) {
            if (tjVar != null && tjVar.um() == 0) {
                arrayList.add(tjVar);
            }
        }
        return arrayList;
    }

    public static List<tj> s(List<tj> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tj tjVar : list) {
            if (tjVar != null && (tjVar.um() == 1 || tjVar.um() == 3)) {
                arrayList.add(tjVar);
            }
        }
        return arrayList;
    }
}
