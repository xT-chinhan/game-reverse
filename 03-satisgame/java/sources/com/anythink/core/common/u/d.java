package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.h.by;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "anythink_imp_check";
    public static int b = 999;
    public static int c = 888;
    public static int d = 5;
    private static volatile d e;
    private final List<Integer> f = Arrays.asList(50, 15, 8, 22, 28, 59, 6, 37, 3);
    private final Map<String, List<Integer>> g = new ConcurrentHashMap();
    private final Map<String, String> h = new ConcurrentHashMap();
    private final Map<String, List<Integer>> i = new ConcurrentHashMap();
    private final Map<String, String> j = new ConcurrentHashMap();

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
        JSONArray jSONArrayBu;
        String[] strArrB;
        if (aTBaseAdAdapter != null) {
            try {
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.n())) || unitGroupInfo.bo() != 1 || (jSONArrayBu = unitGroupInfo.bu()) == null || jSONArrayBu.length() <= 0 || (strArrB = b()) == null || strArrB.length <= 0) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < strArrB.length; i++) {
                    sb.append(strArrB[i]);
                    if (i != strArrB.length - 1) {
                        sb.append("\n");
                    }
                }
                String name = aTBaseAdAdapter.getClass().getName();
                int iLastIndexOf = name.lastIndexOf(com.anythink.core.common.d.i.E);
                boolean zA = a(strArrB, iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : "", jSONArrayBu);
                com.anythink.core.common.t.f.a(aTBaseAdAdapter.getTrackingInfo(), sb.toString(), zA);
                return zA;
            } catch (Throwable th) {
                com.anythink.core.common.t.f.b("check imp error", th.getMessage() + ", " + p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
            }
        }
        return true;
    }

    public final boolean b(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            try {
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.n())) || unitGroupInfo.bo() != 1) {
                    return true;
                }
                List<Integer> listA = a(unitGroupInfo, false);
                if (listA.isEmpty()) {
                    return true;
                }
                return a(aTBaseAdAdapter, listA, false);
            } catch (Throwable th) {
                com.anythink.core.common.t.f.b("check imp error", th.getMessage() + ", " + p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
            }
        }
        return true;
    }

    public final void a(final ATBaseAdAdapter aTBaseAdAdapter, final a aVar) {
        boolean z = false;
        if (aTBaseAdAdapter != null) {
            try {
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo != null && unitGroupInfo.n() == 50) {
                    if (!unitGroupInfo.w()) {
                        aVar.a();
                        return;
                    }
                    if (unitGroupInfo.bo() != 1) {
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
                        com.anythink.core.common.d.s.b();
                        com.anythink.core.common.d.s.b(new Runnable() { // from class: com.anythink.core.common.u.d.1
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
                        }, 3000L);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                com.anythink.core.common.t.f.b("check checkWinResult error", th.getMessage() + ", " + p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
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
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo == null || !this.f.contains(Integer.valueOf(unitGroupInfo.n())) || unitGroupInfo.br() != 1) {
                    return true;
                }
                List<Integer> listA = a(unitGroupInfo, true);
                if (listA.isEmpty()) {
                    return true;
                }
                return a(aTBaseAdAdapter, listA, true);
            } catch (Throwable th) {
                com.anythink.core.common.t.f.b("check reward error", th.getMessage() + ", " + p.a(th.getStackTrace()), com.anythink.core.common.d.s.b().r());
            }
        }
        return true;
    }

    private static String[] b() {
        try {
            Class<?> cls = Class.forName(af.b("mdyd1odqj1Wkuhdg"));
            Object[] objArr = (Object[]) cls.getMethod(af.b("jhwVwdfnWudfh"), new Class[0]).invoke(cls.getMethod(af.b("fxuuhqwWkuhdg"), new Class[0]).invoke(null, new Object[0]), new Object[0]);
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

    private static List<Integer> a(by byVar, boolean z) {
        JSONArray jSONArrayBq;
        JSONArray jSONArrayBp;
        ArrayList arrayList = new ArrayList();
        try {
            int i = 0;
            if (byVar.w()) {
                if (z) {
                    jSONArrayBp = byVar.bs();
                } else {
                    jSONArrayBp = byVar.bp();
                }
                if (jSONArrayBp != null && jSONArrayBp.length() > 0) {
                    while (i < jSONArrayBp.length()) {
                        arrayList.add((Integer) jSONArrayBp.get(i));
                        i++;
                    }
                }
            } else {
                if (z) {
                    jSONArrayBq = byVar.bt();
                } else {
                    jSONArrayBq = byVar.bq();
                }
                if (jSONArrayBq != null && jSONArrayBq.length() > 0) {
                    while (i < jSONArrayBq.length()) {
                        arrayList.add((Integer) jSONArrayBq.get(i));
                        i++;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final boolean a(com.anythink.core.common.h.n nVar, by byVar) {
        if (nVar == null) {
            return true;
        }
        try {
            String strN = nVar.N();
            String strB = b(nVar, byVar);
            String strAS = nVar.aS();
            if (!TextUtils.isEmpty(strAS) && (strAS.equals("0") || strAS.equals("2"))) {
                return false;
            }
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strN)) {
                return true;
            }
            String str = strN + "_" + strB;
            List<Integer> list = this.i.get(str);
            if (this.g.get(str) == null) {
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
            by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            if (trackingInfo == null) {
                return "";
            }
            String strN = trackingInfo.N();
            String strB = b(trackingInfo, unitGroupInfo);
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strN)) {
                return "";
            }
            return this.j.get(strN + "_" + strB);
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
            by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            if (trackingInfo == null || list == null) {
                return true;
            }
            String strN = trackingInfo.N();
            String strB = b(trackingInfo, unitGroupInfo);
            if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strN)) {
                return true;
            }
            String str = strN + "_" + strB;
            List<Integer> list2 = this.g.get(str);
            String str2 = this.h.get(str);
            if (list2 == null || new HashSet(list2).containsAll(list)) {
                return true;
            }
            if (z) {
                com.anythink.core.common.t.f.c(trackingInfo, list2.toString(), str2);
                return false;
            }
            com.anythink.core.common.t.f.b(trackingInfo, list2.toString(), str2);
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

    public final void a(com.anythink.core.common.h.n nVar, by byVar, int i, String str) {
        if (nVar != null) {
            try {
                String strN = nVar.N();
                String strB = b(nVar, byVar);
                if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strN)) {
                    return;
                }
                String str2 = strN + "_" + strB;
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
                    return;
                }
                try {
                    List<Integer> list = this.i.get(str2);
                    if (list != null) {
                        if (!list.contains(Integer.valueOf(i))) {
                            list.add(Integer.valueOf(i));
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(Integer.valueOf(i));
                        this.i.put(str2, arrayList2);
                    }
                    if (i != c || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.j.put(str2, str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void a(com.anythink.core.common.h.n nVar, by byVar, int i) {
        try {
            a(nVar, byVar, i, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(int i, String str, String str2) {
        try {
            List<Integer> list = this.i.get(str);
            if (list != null) {
                if (!list.contains(Integer.valueOf(i))) {
                    list.add(Integer.valueOf(i));
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                this.i.put(str, arrayList);
            }
            if (i != c || TextUtils.isEmpty(str2)) {
                return;
            }
            this.j.put(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            try {
                com.anythink.core.common.h.n trackingInfo = aTBaseAdAdapter.getTrackingInfo();
                if (trackingInfo != null) {
                    String strN = trackingInfo.N();
                    String strB = b(trackingInfo, aTBaseAdAdapter.getUnitGroupInfo());
                    if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(strN)) {
                        return;
                    }
                    String str = strN + "_" + strB;
                    if (this.g.containsKey(str)) {
                        this.g.remove(str);
                    }
                    if (this.h.containsKey(str)) {
                        this.h.remove(str);
                    }
                    if (this.i.containsKey(str)) {
                        this.i.remove(str);
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

    private static String b(com.anythink.core.common.h.n nVar, by byVar) {
        com.anythink.core.common.h.ad adVarY;
        String strAR = nVar.aR();
        return (byVar == null || !byVar.w() || (adVarY = byVar.Y()) == null || TextUtils.isEmpty(adVarY.getOriginRequestId())) ? strAR : adVarY.getOriginRequestId();
    }
}
