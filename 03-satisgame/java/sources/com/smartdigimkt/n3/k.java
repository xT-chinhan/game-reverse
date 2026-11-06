package com.smartdigimkt.n3;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.format.SDMLossInfo;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static String a = "";

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public static boolean a(com.smartdigimkt.f3.c cVar, com.smartdigimkt.p4.a aVar) {
        Map map;
        String str;
        if (!SDKContext.getInstance().i()) {
            String str2 = aVar.F;
            if (TextUtils.isEmpty(str2)) {
                map = aVar.u;
                if (map == null) {
                    return false;
                }
                if (TextUtils.isEmpty(cVar.G)) {
                    return map.containsKey(cVar.a);
                }
                if (!map.containsKey(cVar.a)) {
                    return false;
                }
                str = (String) map.get(cVar.a);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return false;
            }
            String str3 = cVar.H;
            if (TextUtils.isEmpty(str3)) {
                map = aVar.u;
                if (map == null) {
                    return false;
                }
                if (TextUtils.isEmpty(cVar.G)) {
                    return map.containsKey(cVar.a);
                }
                if (!map.containsKey(cVar.a)) {
                    return false;
                }
                str = (String) map.get(cVar.a);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str2);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.equals(str3, jSONArray.optString(i))) {
                    }
                }
            } catch (Throwable unused) {
            }
            map = aVar.u;
            if (map == null) {
                return false;
            }
            if (TextUtils.isEmpty(cVar.G)) {
                return map.containsKey(cVar.a);
            }
            if (!map.containsKey(cVar.a)) {
                return false;
            }
            str = (String) map.get(cVar.a);
            if (TextUtils.isEmpty(str) || !str.contains(cVar.G)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(com.smartdigimkt.f3.c cVar, com.smartdigimkt.p4.a aVar) {
        if (!"3000008".equals(cVar.a)) {
            if (TextUtils.isEmpty(cVar.a) || TextUtils.isEmpty(cVar.H) || TextUtils.isEmpty(cVar.G)) {
                return false;
            }
            String str = cVar.a;
            Map map = aVar.w;
            Map map2 = map != null ? (Map) map.get(str) : null;
            if (map2 == null) {
                return false;
            }
            if (map2.containsKey("0")) {
                String str2 = (String) map2.get("0");
                if (TextUtils.isEmpty(str2) || !str2.contains(cVar.G)) {
                    return false;
                }
            } else {
                if (!map2.containsKey(cVar.H)) {
                    return false;
                }
                String str3 = (String) map2.get(cVar.H);
                if (TextUtils.isEmpty(str3) || !str3.contains(cVar.G)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void c(int i, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar) {
        try {
            com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
            cVar2.a = "1004679";
            cVar2.a(aVar);
            if (cVar instanceof com.smartdigimkt.b3.b) {
                cVar2.l = ((com.smartdigimkt.b3.b) cVar).c0;
            }
            cVar2.m = aVar.f;
            cVar2.n = cVar.a;
            cVar2.o = String.valueOf(cVar.e());
            cVar2.p = cVar.A;
            cVar2.q = cVar.B;
            cVar2.r = String.valueOf(i);
            a(cVar2);
        } catch (Throwable unused) {
        }
    }

    public static void a(com.smartdigimkt.u4.a aVar, SDMLossInfo sDMLossInfo) {
        String str;
        com.smartdigimkt.d3.c cVar = aVar.c;
        com.smartdigimkt.f3.a aVar2 = null;
        if (cVar == null) {
            com.smartdigimkt.e1.d dVar = aVar.a;
            cVar = dVar != null ? dVar.k : null;
        }
        com.smartdigimkt.f3.a aVar3 = aVar.d;
        if (aVar3 != null) {
            aVar2 = aVar3;
        } else {
            com.smartdigimkt.e1.d dVar2 = aVar.a;
            if (dVar2 != null) {
                aVar2 = dVar2.l;
            }
        }
        if (cVar == null || sDMLossInfo == null) {
            return;
        }
        int i = aVar2 != null ? aVar2.P : 0;
        if (i <= 0) {
            i = cVar.p;
        }
        if (i <= 0) {
            i = 66;
        }
        String str2 = aVar2 != null ? aVar2.d : "";
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(str2, String.valueOf(i));
        cVar2.a = "3000006";
        cVar2.a(aVar2);
        cVar2.G = str2;
        cVar2.H = String.valueOf(i);
        cVar2.l = String.valueOf(i);
        if (aVar2 != null && !TextUtils.isEmpty(aVar2.Q)) {
            str = aVar2.Q;
        } else if (!TextUtils.isEmpty(cVar.A)) {
            str = cVar.A;
        } else {
            str = cVar.o;
        }
        cVar2.m = str;
        cVar2.n = aVar.i;
        if (sDMLossInfo.getLossReason() != null) {
            cVar2.o = String.valueOf(sDMLossInfo.getLossReason().getCode());
        }
        cVar2.p = String.valueOf(cVar.c);
        cVar2.q = String.valueOf(sDMLossInfo.getWinPrice());
        cVar2.r = String.valueOf(sDMLossInfo.getCurrency());
        cVar2.s = "1";
        cVar2.t = String.valueOf(cVar.B);
        cVar2.u = String.valueOf(cVar.G);
        cVar2.v = aVar.k;
        cVar2.w = aVar.l;
        cVar2.y = "1";
        cVar2.A = cVar.s;
        a(cVar2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    public static void b(int i, int i2, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, boolean z) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.d dVar;
        int i3;
        String strA;
        String str2;
        if (aVar == null || cVar == null || (eVar = aVar.s) == null || (dVar = eVar.R1) == null) {
            return;
        }
        long j = dVar.a;
        if (j < 1001 || j > 1004) {
            return;
        }
        if ((com.smartdigimkt.b3.h.a(1, j) || com.smartdigimkt.b3.h.a(2, j)) && com.smartdigimkt.b3.h.a(j, cVar, aVar) == 0) {
            return;
        }
        if (!com.smartdigimkt.b3.h.a(j) || com.smartdigimkt.b3.h.a(dVar)) {
            com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
            cVar2.a = "3000017";
            cVar2.a(aVar);
            cVar2.V = true;
            cVar2.l = String.valueOf(j);
            cVar2.n = dVar.a();
            com.smartdigimkt.b3.e eVar2 = aVar.s;
            String str3 = "";
            cVar2.o = (eVar2 != null && (i3 = eVar2.e) >= 0 && i3 <= 2) ? String.valueOf(i3 + 1) : "";
            if (!z) {
                switch ((int) j) {
                    case 1001:
                        if (i == 10 && i2 == 14) {
                            strA = com.smartdigimkt.b3.g.a(3, 1001L);
                        } else if (i == 1 && i2 == 59) {
                            strA = com.smartdigimkt.b3.g.a(3, 1001L);
                        } else if (i == 1 && i2 == 52) {
                            strA = com.smartdigimkt.b3.g.a(2, 1001L);
                        } else if (i == 1 && i2 == 1) {
                            strA = com.smartdigimkt.b3.g.a(1, 1001L);
                        } else if (i != 4 || i2 == 5) {
                            strA = com.smartdigimkt.b3.g.a(4, 1001L);
                        }
                        break;
                    case 1002:
                        if (i == 10 && i2 == 14) {
                            strA = com.smartdigimkt.b3.g.a(3, 1002L);
                        } else if (i == 1 && i2 == 59) {
                            strA = com.smartdigimkt.b3.g.a(3, 1002L);
                        } else if (i == 1 && i2 == 1) {
                            strA = com.smartdigimkt.b3.g.a(1, 1002L);
                        } else if (i == 17 && i2 == 49) {
                            strA = com.smartdigimkt.b3.g.a(2, 1002L);
                        } else if (i != 1 || i2 == 3) {
                            strA = com.smartdigimkt.b3.g.a(4, 1002L);
                        }
                        break;
                    case 1003:
                        strA = com.smartdigimkt.b3.g.a(i, i2, 1003L);
                        break;
                    case 1004:
                        strA = com.smartdigimkt.b3.g.a(i, i2, 1004L);
                        break;
                    default:
                        strA = "";
                        break;
                }
            } else {
                strA = "";
            }
            cVar2.p = strA;
            cVar2.q = str != null ? str : "";
            if ((cVar instanceof com.smartdigimkt.b3.l) && (str2 = ((com.smartdigimkt.b3.l) cVar).c0) != null) {
                str3 = str2;
            }
            cVar2.r = str3;
            cVar2.s = String.valueOf(cVar.o);
            a(cVar2);
        }
    }

    public static JSONArray a(TreeSet treeSet) {
        JSONArray jSONArray = new JSONArray();
        TreeSet treeSet2 = new TreeSet();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num != null && num.intValue() >= 1 && num.intValue() <= 8) {
                treeSet2.add(num);
            }
        }
        Iterator it2 = treeSet2.iterator();
        while (it2.hasNext()) {
            jSONArray.put((Integer) it2.next());
        }
        return jSONArray;
    }

    public static void a(com.smartdigimkt.f3.c cVar) {
        if (SDKContext.getInstance().d() != null && SDKContext.getInstance().e) {
            com.smartdigimkt.q3.f.a().a(new f(cVar));
            return;
        }
        if (!com.smartdigimkt.r4.h.z() || TextUtils.isEmpty("dq|wklqn")) {
            return;
        }
        String strA = com.smartdigimkt.r4.a0.a("dq|wklqn");
        Context context = com.smartdigimkt.r3.c.a().j;
        if (context == null) {
            return;
        }
        String str = cVar.a;
        str.getClass();
        if (str.equals("3000012")) {
            cVar.s = "1";
            com.smartdigimkt.q3.f.a().a(new g(context, strA, cVar.a().toString()));
        }
    }

    public static void b(int i, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar) {
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004768";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
            cVar2.m = bVar.c0;
            cVar2.n = String.valueOf(bVar.g0);
        }
        cVar2.o = String.valueOf(i);
        a(cVar2);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004616";
        cVar.c = str5;
        cVar.l = str;
        cVar.m = str2;
        cVar.n = str3;
        cVar.o = str4;
        cVar.p = str6;
        cVar.q = str7;
        cVar.r = String.valueOf(com.smartdigimkt.r4.k.c(SDKContext.getInstance().d()) ? 1 : 0);
        com.smartdigimkt.b4.a aVar = com.smartdigimkt.o4.e.c().a().b0;
        cVar.s = String.valueOf(aVar != null ? aVar.a : 1);
        a(cVar);
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, int i, String str) {
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004706";
        cVar2.a(aVar);
        cVar2.l = String.valueOf(aVar.k);
        cVar2.m = aVar.f;
        cVar2.n = String.valueOf(aVar.c);
        if (cVar instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
            cVar2.o = bVar.c0;
            cVar2.p = bVar.a;
        }
        cVar2.q = String.valueOf(i);
        cVar2.r = str;
        a(cVar2);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, int i2) {
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004747";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.m = ((com.smartdigimkt.b3.b) cVar).c0;
        }
        cVar2.n = String.valueOf(i);
        if (i2 > 0) {
            cVar2.o = String.valueOf(i2);
        }
        cVar2.p = String.valueOf(cVar.o);
        cVar2.q = cVar.k;
        cVar2.r = cVar.l;
        a(cVar2);
    }

    public static void a(int i, int i2, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, boolean z) {
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004748";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.m = ((com.smartdigimkt.b3.b) cVar).c0;
        }
        if (TextUtils.isEmpty(str)) {
            cVar2.n = cVar.k;
        } else {
            cVar2.n = str;
        }
        cVar2.o = cVar.l;
        cVar2.p = String.valueOf(i);
        if (i != 1 && z) {
            cVar2.q = z ? "1" : "2";
        }
        if (i == 3 && i2 > 0) {
            cVar2.r = String.valueOf(i2);
        }
        a(cVar2);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, String str, String str2) {
        com.smartdigimkt.b3.e eVar;
        if (aVar != null) {
            try {
                com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
                cVar2.a = "3000015";
                cVar2.a(aVar);
                cVar2.l = cVar.a;
                cVar2.m = aVar.f;
                cVar2.n = str;
                if (str2 != null && !str2.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    cVar2.o = new JSONArray((Collection) arrayList).toString();
                }
                if (str == "3" && (eVar = cVar.w) != null) {
                    cVar2.p = String.valueOf(eVar.Y);
                }
                a(cVar2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, int i, ArrayList arrayList, ArrayList arrayList2, LinkedHashMap linkedHashMap) {
        int i2;
        if (aVar == null) {
            return;
        }
        if (i == 8 || i == 9 || i == 24 || i == 10 || i == 36) {
            try {
                if (!arrayList.isEmpty() && arrayList2 != null && !arrayList2.isEmpty()) {
                    if (i == 8) {
                        i2 = 1;
                    } else if (i == 9) {
                        i2 = 2;
                    } else if (i == 24) {
                        i2 = 3;
                    } else {
                        i2 = i == 10 ? 4 : 5;
                    }
                    com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
                    cVar.a = "3000016";
                    cVar.a(aVar);
                    cVar.l = lVar instanceof com.smartdigimkt.b3.b ? String.valueOf(((com.smartdigimkt.b3.b) lVar).c0) : "";
                    cVar.m = lVar.a;
                    cVar.n = String.valueOf(i2);
                    cVar.o = new JSONArray((Collection) arrayList).toString();
                    cVar.p = new JSONArray((Collection) arrayList2).toString();
                    String string = (linkedHashMap == null || linkedHashMap.isEmpty()) ? "{}" : new JSONObject(linkedHashMap).toString();
                    if (i2 == 1) {
                        cVar.q = string;
                    } else if (i2 == 2) {
                        cVar.r = string;
                    } else if (i2 == 3) {
                        cVar.s = string;
                    } else if (i2 == 4) {
                        cVar.t = string;
                    } else {
                        cVar.u = string;
                    }
                    a(cVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(int i, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar) {
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004749";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.m = ((com.smartdigimkt.b3.b) cVar).c0;
        }
        cVar2.n = cVar.k;
        cVar2.o = String.valueOf(i);
        a(cVar2);
    }

    public static void a(com.smartdigimkt.a3.a aVar, int i, String str, LinkedHashMap linkedHashMap, int i2, int i3, int i4, String str2, int i5, int i6, long j, String str3, int i7) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004675";
        cVar.a(aVar);
        cVar.l = str;
        cVar.m = String.valueOf(i);
        cVar.o = String.valueOf(i2);
        cVar.p = String.valueOf(i3);
        cVar.q = String.valueOf(i4);
        cVar.r = str2;
        cVar.s = String.valueOf(i5);
        if (i6 >= 0) {
            cVar.t = String.valueOf(i6);
        }
        if (j > 0) {
            cVar.u = String.valueOf(j);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.v = str3;
        }
        if (i7 > 0) {
            cVar.w = String.valueOf(i7);
        }
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), (JSONArray) entry.getValue());
                }
                cVar.x = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        a(cVar);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, boolean z, int i2, String str, int i3, int i4) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
        cVar2.a = "1004719";
        cVar2.a(aVar);
        if (cVar instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
            cVar2.l = bVar.c0;
            cVar2.m = bVar.a;
        }
        cVar2.n = z ? "2" : "1";
        if (i2 > 0) {
            cVar2.o = String.valueOf(i2);
            if (!TextUtils.isEmpty(str)) {
                cVar2.p = str;
            }
            if (i3 > 0) {
                cVar2.q = String.valueOf(i3);
            }
        } else {
            cVar2.o = "1";
        }
        cVar2.r = String.valueOf(aVar.c);
        if (cVar != null && (eVar = cVar.w) != null) {
            cVar2.s = eVar.w;
        }
        cVar2.t = String.valueOf(i);
        cVar2.u = String.valueOf(i4);
        a(cVar2);
    }

    public static void a(String str, String str2, String str3, int i, String str4, long j, long j2, com.smartdigimkt.b3.c cVar, int i2, long j3) {
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
        cVar2.a = "1004642";
        cVar2.b = str;
        if (cVar != null) {
            cVar2.Q = cVar.L;
            cVar2.R = cVar.M;
            cVar2.u = cVar.m;
            cVar2.w = cVar.k;
            if (cVar instanceof com.smartdigimkt.b3.b) {
                cVar2.v = ((com.smartdigimkt.b3.b) cVar).c0;
            }
        }
        cVar2.l = str2;
        cVar2.m = str3;
        cVar2.n = String.valueOf(i);
        if (i == 3 || i == 10) {
            cVar2.o = str4;
        } else if (i == 2) {
            cVar2.p = String.valueOf(j);
            cVar2.q = String.valueOf(j2 / 1024.0f);
        }
        if (i == 11) {
            cVar2.r = "" + i2;
        }
        if (i == 13) {
            if (cVar != null && TextUtils.isEmpty(cVar.m) && TextUtils.isEmpty(cVar.k)) {
                cVar2.s = "1";
            } else {
                cVar2.s = "0";
            }
        }
        if (i == 6 || i == 9 || i == 12) {
            cVar2.t = String.valueOf(System.currentTimeMillis() - j3);
        }
        a(cVar2);
    }

    public static void a(com.smartdigimkt.b3.l lVar, ArrayList arrayList, ArrayList arrayList2) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004771";
        cVar.b = lVar.x;
        cVar.Q = lVar.L;
        cVar.R = lVar.M;
        cVar.l = lVar.a;
        cVar.m = lVar.m;
        if (lVar instanceof com.smartdigimkt.b3.b) {
            cVar.n = ((com.smartdigimkt.b3.b) lVar).c0;
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray((Collection) arrayList);
                JSONArray jSONArray2 = new JSONArray((Collection) arrayList2);
                jSONObject.put("success", jSONArray);
                jSONObject.put("fail", jSONArray2);
                cVar.o = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        a(cVar);
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, String str2, String str3, String str4) {
        if (aVar == null || cVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
        cVar2.a = "1004648";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        cVar2.m = String.valueOf(cVar.e());
        cVar2.n = str;
        cVar2.o = str2;
        cVar2.p = str3;
        cVar2.q = str4;
        a(cVar2);
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, String str2, int i, int i2, String str3) {
        if (aVar == null || cVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004650";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        cVar2.m = String.valueOf(cVar.e());
        cVar2.n = str;
        cVar2.o = str2;
        cVar2.p = String.valueOf(i);
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.r = String.valueOf(((com.smartdigimkt.b3.b) cVar).c0);
        }
        cVar2.s = String.valueOf(aVar.c);
        if (i2 > 0) {
            cVar2.t = String.valueOf(i2);
        }
        cVar2.u = str3;
        a(cVar2);
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, String str2, int i) {
        if (aVar == null || cVar == null) {
            return;
        }
        boolean z = i == 0;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004728";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        cVar2.m = String.valueOf(aVar.s.e1);
        cVar2.n = String.valueOf(z ? 1 : 2);
        cVar2.o = str;
        cVar2.p = str2;
        if (!z) {
            cVar2.q = String.valueOf(i);
        }
        a(cVar2);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, String str, double d, double d2, long j, long j2, long j3, int i) {
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(null, null);
        cVar2.a = "1004764";
        cVar2.a(aVar);
        if (cVar != null) {
            cVar2.l = String.valueOf(cVar.e());
            if (cVar instanceof com.smartdigimkt.b3.b) {
                cVar2.n = ((com.smartdigimkt.b3.b) cVar).c0;
                cVar2.o = cVar.a;
            }
            cVar2.p = cVar.i;
        }
        if (aVar != null) {
            cVar2.m = String.valueOf(aVar.c);
            com.smartdigimkt.b3.e eVar = aVar.s;
            if (eVar != null) {
                cVar2.u = String.valueOf(eVar.S);
            }
        }
        cVar2.q = z ? "1" : "2";
        if (!TextUtils.isEmpty(str)) {
            cVar2.r = str;
        }
        if (d > 0.0d) {
            cVar2.s = String.valueOf(Math.round(d / 1024.0d));
        }
        if (d2 > 0.0d) {
            cVar2.t = String.valueOf(Math.round(d2 / 1024.0d));
        }
        if (j > 0) {
            cVar2.v = String.valueOf(j);
        }
        if (j2 > 0) {
            cVar2.w = String.valueOf(j2);
        }
        if (j3 > 0) {
            cVar2.x = String.valueOf(j3);
        }
        if (i > 0) {
            cVar2.y = String.valueOf(i);
        }
        a(cVar2);
    }

    public static void a(String str, String str2) {
        boolean z = !str.isEmpty();
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004729";
        cVar.l = Build.MANUFACTURER;
        cVar.m = z ? "1" : "2";
        if (z) {
            cVar.n = str;
        } else {
            cVar.o = str2;
        }
        a(cVar);
    }

    public static void a(int i, int i2, String str, long j) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004769";
        try {
            cVar.l = Build.MANUFACTURER;
        } catch (Throwable unused) {
        }
        cVar.m = String.valueOf(i);
        cVar.n = String.valueOf(i2);
        if (!TextUtils.isEmpty(str)) {
            cVar.o = str;
        }
        cVar.p = String.valueOf(j);
        a(cVar);
    }

    public static void a(boolean z, String str, com.smartdigimkt.e1.d dVar, long j, int i) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c("", null);
        cVar.a = "3000003";
        if (dVar != null) {
            com.smartdigimkt.f3.a aVar = dVar.l;
            if (aVar != null) {
                cVar.a(aVar);
            }
            com.smartdigimkt.b3.b bVar = dVar.e;
            if (bVar instanceof com.smartdigimkt.b3.b) {
                cVar.o = bVar.c0;
            }
            cVar.p = bVar != null ? bVar.a : "";
        }
        cVar.l = z ? "1" : "0";
        cVar.m = String.valueOf(i);
        cVar.n = String.valueOf(j);
        cVar.c = str;
        a(cVar);
    }

    public static void a(long j, long j2, String str, String str2) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "3000009";
        if (!TextUtils.isEmpty(str2)) {
            cVar.c = str2;
        }
        cVar.l = str;
        cVar.m = String.valueOf(j);
        cVar.n = String.valueOf(j2);
        cVar.o = String.valueOf(j2 - j);
        a(cVar);
    }

    public static void a(String str, String str2, String str3, String str4) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "3000010";
        cVar.d = str3;
        cVar.l = str2;
        cVar.m = str;
        cVar.n = str4;
        a(cVar);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, boolean z2) {
        String string;
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "3000011";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.m = ((com.smartdigimkt.b3.b) cVar).c0;
        }
        com.smartdigimkt.b3.e eVar = aVar.s;
        if (eVar != null) {
            cVar2.n = String.valueOf(eVar.o1);
            com.smartdigimkt.b3.e eVar2 = aVar.s;
            if (eVar2.P1) {
                com.smartdigimkt.b3.u uVar = eVar2.O1;
                if (uVar == null) {
                    uVar = com.smartdigimkt.b3.u.i;
                }
                cVar2.q = String.valueOf(uVar.a);
                cVar2.r = uVar.b;
            } else {
                cVar2.q = String.valueOf(eVar2.K1);
                if (eVar2.K1 == 2) {
                    string = String.valueOf(eVar2.N1);
                } else {
                    List list = eVar2.M1;
                    string = list == null ? "" : list.toString();
                }
                cVar2.r = string;
            }
            cVar2.s = "";
        }
        cVar2.o = z ? "1" : "2";
        cVar2.p = z2 ? "1" : "2";
        a(cVar2);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j) {
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "3000012";
        cVar.l = str;
        cVar.m = str2;
        cVar.n = str3;
        cVar.o = str4;
        cVar.p = str5;
        cVar.r = String.valueOf(SystemClock.elapsedRealtime() - j);
        a(cVar);
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, long j, int i, String str, long j2, String str2) {
        if (cVar == null || aVar == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004761";
        cVar2.a(aVar);
        cVar2.l = cVar.a;
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.m = ((com.smartdigimkt.b3.b) cVar).c0;
        }
        cVar2.n = z ? "1" : "2";
        cVar2.o = String.valueOf(j);
        com.smartdigimkt.b3.e eVar = cVar.w;
        cVar2.p = eVar != null ? eVar.t1 : "";
        cVar2.q = eVar != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.s1, "") : "";
        cVar2.r = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.w1, "") : "";
        cVar2.s = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.x1, "") : "";
        if (!z) {
            cVar2.t = String.valueOf(i);
            cVar2.u = str;
        }
        if (j2 > 0) {
            cVar2.v = String.valueOf(j2);
        }
        cVar2.w = str2;
        cVar2.x = cVar.w != null ? com.smartdigimkt.c0.j.a(new StringBuilder(), cVar.w.y1, "") : "";
        a(cVar2);
    }
}
