package com.anythink.core.common.m.b.a.c;

import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.m;
import com.anythink.core.common.m.b.n;
import com.anythink.core.common.m.b.u;
import com.anythink.core.common.m.b.v;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final com.anythink.core.common.m.c.f a = com.anythink.core.common.m.c.f.a("\"\\");
    private static final com.anythink.core.common.m.c.f b = com.anythink.core.common.m.c.f.a("\t ,=");

    private e() {
    }

    public static long a(af afVar) {
        return a(afVar.g().a("Content-Length"));
    }

    private static long a(u uVar) {
        return a(uVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(af afVar) {
        return c(afVar.g()).contains("*");
    }

    private static boolean b(u uVar) {
        return c(uVar).contains("*");
    }

    private static Set<String> e(af afVar) {
        return c(afVar.g());
    }

    private static Set<String> c(u uVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iA = uVar.a();
        for (int i = 0; i < iA; i++) {
            if ("Vary".equalsIgnoreCase(uVar.a(i))) {
                String strB = uVar.b(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strB.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static u c(af afVar) {
        u uVarC = afVar.j().a().c();
        Set<String> setC = c(afVar.g());
        if (setC.isEmpty()) {
            return com.anythink.core.common.m.b.a.c.c;
        }
        u.a aVar = new u.a();
        int iA = uVarC.a();
        for (int i = 0; i < iA; i++) {
            String strA = uVarC.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, uVarC.b(i));
            }
        }
        return aVar.a();
    }

    private static u a(u uVar, u uVar2) {
        Set<String> setC = c(uVar2);
        if (setC.isEmpty()) {
            return com.anythink.core.common.m.b.a.c.c;
        }
        u.a aVar = new u.a();
        int iA = uVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = uVar.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, uVar.b(i));
            }
        }
        return aVar.a();
    }

    public static List<com.anythink.core.common.m.b.h> a(u uVar, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uVar.a(); i++) {
            if (str.equalsIgnoreCase(uVar.a(i))) {
                a(arrayList, new com.anythink.core.common.m.c.c().b(uVar.b(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0084  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c3 A[EDGE_INSN: B:61:0x00c3->B:50:0x00c3 BREAK  A[LOOP:2: B:22:0x0072->B:49:0x00c1], SYNTHETIC] */
    private static void a(List<com.anythink.core.common.m.b.h> list, com.anythink.core.common.m.c.c cVar) {
        String strD;
        while (true) {
            String strD2 = null;
            while (true) {
                if (strD2 == null) {
                    a(cVar);
                    strD2 = d(cVar);
                    if (strD2 == null) {
                        return;
                    }
                }
                boolean zA = a(cVar);
                String strD3 = d(cVar);
                if (strD3 == null) {
                    if (cVar.g()) {
                        list.add(new com.anythink.core.common.m.b.h(strD2, (Map<String, String>) Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                int iB = b(cVar);
                boolean zA2 = a(cVar);
                if (zA || (!zA2 && !cVar.g())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iB2 = iB + b(cVar);
                    while (true) {
                        if (strD3 != null) {
                            if (iB2 != 0) {
                                break;
                                break;
                            }
                            if (iB2 <= 1) {
                                return;
                            }
                            if (cVar.g()) {
                                strD = d(cVar);
                            } else {
                                strD = d(cVar);
                            }
                            if (strD != null) {
                                return;
                            }
                            if (a(cVar)) {
                            }
                            strD3 = null;
                        } else {
                            strD3 = d(cVar);
                            if (!a(cVar)) {
                                iB2 = b(cVar);
                                if (iB2 != 0) {
                                    break;
                                }
                                if (iB2 <= 1 || a(cVar)) {
                                    return;
                                }
                                if (cVar.g() && cVar.c(0L) == 34) {
                                    strD = c(cVar);
                                } else {
                                    strD = d(cVar);
                                }
                                if (strD != null || ((String) linkedHashMap.put(strD3, strD)) != null) {
                                    return;
                                }
                                if (a(cVar) && !cVar.g()) {
                                    return;
                                } else {
                                    strD3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new com.anythink.core.common.m.b.h(strD2, linkedHashMap));
                    strD2 = strD3;
                } else {
                    StringBuilder sbAppend = new StringBuilder().append(strD3);
                    char[] cArr = new char[iB];
                    Arrays.fill(cArr, '=');
                    list.add(new com.anythink.core.common.m.b.h(strD2, (Map<String, String>) Collections.singletonMap(null, sbAppend.append(new String(cArr)).toString())));
                }
            }
        }
    }

    private static boolean a(com.anythink.core.common.m.c.c cVar) {
        boolean z = false;
        while (!cVar.g()) {
            byte bC = cVar.c(0L);
            if (bC != 44) {
                if (bC != 32 && bC != 9) {
                    break;
                }
                cVar.k();
            } else {
                cVar.k();
                z = true;
            }
        }
        return z;
    }

    private static int b(com.anythink.core.common.m.c.c cVar) {
        int i = 0;
        while (!cVar.g() && cVar.c(0L) == 61) {
            i++;
            cVar.k();
        }
        return i;
    }

    private static String c(com.anythink.core.common.m.c.c cVar) {
        if (cVar.k() != 34) {
            throw new IllegalArgumentException();
        }
        com.anythink.core.common.m.c.c cVar2 = new com.anythink.core.common.m.c.c();
        while (true) {
            long jC = cVar.c(a);
            if (jC == -1) {
                return null;
            }
            if (cVar.c(jC) == 34) {
                cVar2.a(cVar, jC);
                cVar.k();
                return cVar2.u();
            }
            if (cVar.b() == jC + 1) {
                return null;
            }
            cVar2.a(cVar, jC);
            cVar.k();
            cVar2.a(cVar, 1L);
        }
    }

    private static String d(com.anythink.core.common.m.c.c cVar) {
        try {
            long jC = cVar.c(b);
            if (jC == -1) {
                jC = cVar.b();
            }
            if (jC != 0) {
                return cVar.e(jC);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    private static String a(int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, '=');
        return new String(cArr);
    }

    public static void a(n nVar, v vVar, u uVar) {
        if (nVar == n.a) {
            return;
        }
        m.a(vVar, uVar).isEmpty();
    }

    public static boolean d(af afVar) {
        if (afVar.a().b().equals("HEAD")) {
            return false;
        }
        int iC = afVar.c();
        return (((iC >= 100 && iC < 200) || iC == 204 || iC == 304) && a(afVar) == -1 && !"chunked".equalsIgnoreCase(afVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static boolean a(af afVar, u uVar, ad adVar) {
        for (String str : c(afVar.g())) {
            if (!Objects.equals(uVar.b(str), adVar.b(str))) {
                return false;
            }
        }
        return true;
    }
}
