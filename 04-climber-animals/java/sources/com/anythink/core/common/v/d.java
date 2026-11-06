package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.h.bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "anythink_imp_check";
    public static int b = 999;
    public static int c = 888;
    public static int d = 5;
    private static volatile d e;
    private final List<Integer> f = Arrays.asList(50, 15, 8, 22, 28, 59, 6, 37, 3);
    private final Map<String, List<Integer>> g = new HashMap();
    private final Map<String, String> h = new HashMap();
    private final Map<String, List<Integer>> i = new HashMap();
    private final Map<String, String> j = new HashMap();

    public interface a {
        void a();

        void b();
    }

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    private d() {
    }

    public final boolean a(ATBaseAdAdapter aTBaseAdAdapter) {
        JSONArray jSONArrayBm;
        String[] strArrB;
        if (aTBaseAdAdapter != null) {
            try {
                bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.g())) || unitGroupInfo.bg() != 1 || (jSONArrayBm = unitGroupInfo.bm()) == null || jSONArrayBm.length() <= 0 || (strArrB = b()) == null || strArrB.length <= 0) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < strArrB.length; i++) {
                    sb.append(strArrB[i]);
                    if (i != strArrB.length - 1) {
                        sb.append("\n");
                    }
                }
                new StringBuilder("checkStack:sb:").append((Object) sb);
                String name = aTBaseAdAdapter.getClass().getName();
                int iLastIndexOf = name.lastIndexOf(com.anythink.core.common.d.j.z);
                boolean zA = a(strArrB, iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : "", jSONArrayBm);
                com.anythink.core.common.u.e.a(aTBaseAdAdapter.getTrackingInfo(), sb.toString(), zA);
                return zA;
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("check imp error", th.getMessage() + ", " + q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
            }
        }
        return true;
    }

    public final boolean b(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            try {
                bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.g())) || unitGroupInfo.bg() != 1) {
                    return true;
                }
                List<Integer> listA = a(unitGroupInfo, false);
                if (listA.isEmpty()) {
                    return true;
                }
                return a(aTBaseAdAdapter, listA, false);
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("check imp error", th.getMessage() + ", " + q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
            }
        }
        return true;
    }

    public final void a(final ATBaseAdAdapter aTBaseAdAdapter, final a aVar) {
        boolean z = false;
        if (aTBaseAdAdapter != null) {
            try {
                bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo != null && unitGroupInfo.g() == 50) {
                    if (!unitGroupInfo.o()) {
                        aVar.a();
                        return;
                    }
                    if (unitGroupInfo.bg() != 1) {
                        aVar.a();
                        return;
                    }
                    String strE = e(aTBaseAdAdapter);
                    if (!TextUtils.isEmpty(strE)) {
                        if (strE.equals("0")) {
                            aVar.a();
                            return;
                        }
                        return;
                    } else {
                        com.anythink.core.common.d.t.b();
                        com.anythink.core.common.d.t.b(new Runnable() { // from class: com.anythink.core.common.v.d.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a aVar2;
                                String strE2 = d.this.e(aTBaseAdAdapter);
                                if (!TextUtils.isEmpty(strE2)) {
                                    if (!strE2.equals("0") || (aVar2 = aVar) == null) {
                                        return;
                                    }
                                    aVar2.a();
                                    return;
                                }
                                a aVar3 = aVar;
                                if (aVar3 != null) {
                                    aVar3.a();
                                }
                            }
                        }, com.tapsdk.tapad.e.a.f);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("check checkWinResult error", th.getMessage() + ", " + q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
            }
        }
        if (z) {
            return;
        }
        aVar.a();
    }

    public final boolean c(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            try {
                bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.g())) || unitGroupInfo.bj() != 1) {
                    return true;
                }
                List<Integer> listA = a(unitGroupInfo, true);
                if (listA.isEmpty()) {
                    return true;
                }
                return a(aTBaseAdAdapter, listA, true);
            } catch (Throwable th) {
                com.anythink.core.common.u.e.b("check reward error", th.getMessage() + ", " + q.a(th.getStackTrace()), com.anythink.core.common.d.t.b().r());
            }
        }
        return true;
    }

    private static String[] b() {
        try {
            Class<?> cls = Class.forName(ah.a("mdyd1odqj1Wkuhdg"));
            Object[] objArr = (Object[]) cls.getMethod(ah.a("jhwVwdfnWudfh"), new Class[0]).invoke(cls.getMethod(ah.a("fxuuhqwWkuhdg"), new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (objArr == null || objArr.length <= 0) {
                return null;
            }
            String[] strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = objArr[i].toString();
            }
            return strArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static List<Integer> a(bv bvVar, boolean z) {
        JSONArray jSONArrayBi;
        JSONArray jSONArrayBh;
        ArrayList arrayList = new ArrayList();
        try {
            int i = 0;
            if (bvVar.o()) {
                if (z) {
                    jSONArrayBh = bvVar.bk();
                } else {
                    jSONArrayBh = bvVar.bh();
                }
                if (jSONArrayBh != null && jSONArrayBh.length() > 0) {
                    while (i < jSONArrayBh.length()) {
                        arrayList.add((Integer) jSONArrayBh.get(i));
                        i++;
                    }
                }
            } else {
                if (z) {
                    jSONArrayBi = bvVar.bl();
                } else {
                    jSONArrayBi = bvVar.bi();
                }
                if (jSONArrayBi != null && jSONArrayBi.length() > 0) {
                    while (i < jSONArrayBi.length()) {
                        arrayList.add((Integer) jSONArrayBi.get(i));
                        i++;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final boolean a(com.anythink.core.common.h.n nVar, bv bvVar) {
        if (nVar == null) {
            return true;
        }
        try {
            String strM = nVar.M();
            String strB = b(nVar, bvVar);
            String strAK = nVar.aK();
            if (!TextUtils.isEmpty(strAK) && (strAK.equals("0") || strAK.equals("2"))) {
                return false;
            }
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strM)) {
                return true;
            }
            String str = strM + "_" + strB;
            List<Integer> list = this.i.get(str);
            List<Integer> list2 = this.g.get(str);
            new StringBuilder("isNeedRetry:list:").append(list2).append(":").append(list2);
            if (list2 == null) {
                return false;
            }
            return list == null || !list.contains(Integer.valueOf(b));
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter == null) {
            return "";
        }
        try {
            com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            if (trackingInfo == null) {
                return "";
            }
            String strM = trackingInfo.M();
            String strB = b(trackingInfo, unitGroupInfo);
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strM)) {
                return "";
            }
            return this.j.get(strM + "_" + strB);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private boolean a(ATBaseAdAdapter aTBaseAdAdapter, List<Integer> list, boolean z) {
        if (aTBaseAdAdapter == null) {
            return true;
        }
        try {
            com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            if (trackingInfo == null || list == null) {
                return true;
            }
            String strM = trackingInfo.M();
            String strB = b(trackingInfo, unitGroupInfo);
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strM)) {
                return true;
            }
            String str = strM + "_" + strB;
            List<Integer> list2 = this.g.get(str);
            String str2 = this.h.get(str);
            new StringBuilder("checkEvent:list:").append(list2).append(":").append(list);
            if (list2 == null || new HashSet(list2).containsAll(list)) {
                return true;
            }
            if (z) {
                com.anythink.core.common.u.e.c(trackingInfo, list2.toString(), str2);
                return false;
            }
            com.anythink.core.common.u.e.b(trackingInfo, list2.toString(), str2);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static boolean a(String[] strArr, String str, JSONArray jSONArray) {
        int i;
        try {
            if (!TextUtils.isEmpty(str) && jSONArray != null) {
                int i2 = -1;
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str2 = strArr[i3];
                    if (str2 != null && str2.startsWith(str)) {
                        i2 = i3;
                    }
                }
                if (i2 != -1 && (i = i2 + 1) < strArr.length) {
                    String str3 = strArr[i];
                    if (!TextUtils.isEmpty(str3) && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            String str4 = (String) jSONArray.get(i4);
                            if (!TextUtils.isEmpty(str4) && str3.startsWith(str4)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return true;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(com.anythink.core.common.h.n nVar, bv bvVar, int i, String str) {
        if (nVar != null) {
            try {
                String strM = nVar.M();
                String strB = b(nVar, bvVar);
                if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strM)) {
                    return;
                }
                String str2 = strM + "_" + strB;
                if (i != c && i != b) {
                    List<Integer> arrayList = this.g.get(str2);
                    if (arrayList != null) {
                        if (!arrayList.contains(Integer.valueOf(i))) {
                            arrayList.add(Integer.valueOf(i));
                        }
                    } else {
                        arrayList = new ArrayList<>();
                        arrayList.add(Integer.valueOf(i));
                        this.g.put(str2, arrayList);
                    }
                    if (i == d && !TextUtils.isEmpty(str)) {
                        this.h.put(str2, str);
                    }
                    nVar.a(arrayList);
                    new StringBuilder("recordAdCheckEvent:list:").append(arrayList);
                    return;
                }
                try {
                    List<Integer> arrayList2 = this.i.get(str2);
                    if (arrayList2 != null) {
                        if (!arrayList2.contains(Integer.valueOf(i))) {
                            arrayList2.add(Integer.valueOf(i));
                        }
                    } else {
                        arrayList2 = new ArrayList<>();
                        arrayList2.add(Integer.valueOf(i));
                        this.i.put(str2, arrayList2);
                    }
                    if (i == c && !TextUtils.isEmpty(str)) {
                        this.j.put(str2, str);
                    }
                    new StringBuilder("recordAdCheckExtraEvent:list:").append(arrayList2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void a(com.anythink.core.common.h.n nVar, bv bvVar, int i) {
        try {
            a(nVar, bvVar, i, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(int i, String str, String str2) {
        try {
            List<Integer> arrayList = this.i.get(str);
            if (arrayList != null) {
                if (!arrayList.contains(Integer.valueOf(i))) {
                    arrayList.add(Integer.valueOf(i));
                }
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(i));
                this.i.put(str, arrayList);
            }
            if (i == c && !TextUtils.isEmpty(str2)) {
                this.j.put(str, str2);
            }
            new StringBuilder("recordAdCheckExtraEvent:list:").append(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            try {
                com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
                if (trackingInfo != null) {
                    String strM = trackingInfo.M();
                    String strB = b(trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                    if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strM)) {
                        return;
                    }
                    String str = strM + "_" + strB;
                    if (this.g.containsKey(str)) {
                        new StringBuilder("removeAdCheckEvent:remove:").append(this.g.remove(str));
                    }
                    if (this.h.containsKey(str)) {
                        this.h.remove(str);
                    }
                    if (this.i.containsKey(str)) {
                        new StringBuilder("removeAdCheckExtraEvent:remove:").append(this.i.remove(str));
                    }
                    if (this.j.containsKey(str)) {
                        this.j.remove(str);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String b(com.anythink.core.common.h.n nVar, bv bvVar) {
        com.anythink.core.common.h.ad adVarR;
        String strAJ = nVar.aJ();
        return (bvVar == null || !bvVar.o() || (adVarR = bvVar.R()) == null || TextUtils.isEmpty(adVarR.getOriginRequestId())) ? strAJ : adVarR.getOriginRequestId();
    }
}
