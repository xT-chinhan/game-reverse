package com.anythink.core.a;

import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.f;
import com.anythink.core.common.h.k;
import com.anythink.core.common.h.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final String a = "AdSourceFltRuleHandler";
    private final com.anythink.core.common.f.a b;
    private final Map<String, Long> c = new ConcurrentHashMap();
    private final Map<String, Pair<Integer, Long>> e = new ConcurrentHashMap();
    private final Set<String> d = new CopyOnWriteArraySet();

    public e(com.anythink.core.common.f.a aVar) {
        this.b = aVar;
    }

    public final void a(by byVar) {
        try {
            l lVarBH = byVar.bH();
            int iA = lVarBH.a();
            if (iA != 3) {
                return;
            }
            String strG = byVar.G();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            f fVarA = a("3", strG, iA);
            int i = 1;
            boolean z = fVarA != null;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                long jI = fVarA.i();
                if (jCurrentTimeMillis < lVarBH.d() + jI) {
                    i = 1 + fVarA.a;
                    jCurrentTimeMillis = jI;
                }
            } else {
                fVarA = new f("3");
                fVarA.a(strG);
                fVarA.a(iA);
            }
            fVarA.a(jCurrentTimeMillis);
            fVarA.a = i;
            this.e.put(strG, new Pair<>(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis)));
            this.b.a(fVarA, z);
        } catch (Throwable unused) {
        }
    }

    public final k b(by byVar) {
        f fVarA;
        k kVar;
        try {
            String strG = byVar.G();
            int iA = byVar.bH().a();
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            Long l = this.c.get(strG);
            boolean z = false;
            if (l == null ? !((fVarA = a("4", strG, iA)) == null || fVarA.n() <= System.currentTimeMillis()) : l.longValue() > System.currentTimeMillis()) {
                z = true;
            }
            if (!z) {
                return null;
            }
            if (iA == 1) {
                kVar = new k(32, ErrorCode.getErrorCode("2036", "", ""));
            } else if (iA == 2) {
                kVar = new k(33, ErrorCode.getErrorCode(ErrorCode.noFillSError, "", ""));
            } else {
                if (iA != 3) {
                    return null;
                }
                kVar = new k(34, ErrorCode.getErrorCode(ErrorCode.noFillSrError, "", ""));
            }
            return kVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void c(by byVar) {
        try {
            l lVarBH = byVar.bH();
            if (lVarBH == null) {
                return;
            }
            int iA = lVarBH.a();
            String strG = byVar.G();
            if (iA == 1 && !TextUtils.isEmpty(strG)) {
                List<Pair<String, String>> listB = b("4", strG, iA);
                if (this.d.contains(strG)) {
                    return;
                }
                this.d.add(strG);
                this.c.remove(strG);
                this.b.a(listB);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(by byVar) {
        f fVarA;
        long jF;
        long j;
        try {
            l lVarBH = byVar.bH();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iA = lVarBH.a();
            String strG = byVar.G();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            f fVar = new f("4");
            f fVar2 = null;
            if (iA == 3) {
                boolean zContainsKey = this.e.containsKey(strG);
                Pair<Integer, Long> pair = this.e.get(strG);
                if (zContainsKey && pair != null) {
                    int iIntValue = ((Integer) pair.first).intValue();
                    long jLongValue = ((Long) pair.second).longValue();
                    fVar2 = new f("3");
                    fVar2.a = iIntValue;
                    fVar2.a(jLongValue);
                    fVar2.a(3);
                    fVarA = a("4", strG, iA);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.h, "="), strG));
                    arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.o, "="), String.valueOf(iA)));
                    fVarA = null;
                    for (f fVar3 : this.b.a(arrayList, 2)) {
                        if ("4".equals(fVar3.a())) {
                            fVarA = fVar3;
                        } else if ("3".equals(fVar3.a())) {
                            fVar2 = fVar3;
                        }
                    }
                }
            } else {
                fVarA = a("4", strG, iA);
            }
            boolean z = fVarA != null;
            if (!z) {
                fVar.a(strG);
                fVar.a(iA);
                fVar.a(jCurrentTimeMillis);
                fVar.b(1);
                fVar.b(0L);
            } else {
                fVarA.e();
                int iM = fVarA.m() + 1;
                long jI = fVarA.i();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                int iA2 = lVarBH.a();
                if (iA2 != 1) {
                    if (iA2 != 2) {
                        if (iA2 == 3) {
                            if (jCurrentTimeMillis2 >= jI + lVarBH.d()) {
                                fVarA.a(jCurrentTimeMillis2);
                                iM = 1;
                            } else {
                                int i = fVar2 != null ? fVar2.a : 0;
                                if (i > 0 && i >= lVarBH.g()) {
                                    if ((iM * 100) / i >= lVarBH.e()) {
                                        jF = lVarBH.f();
                                        j = jCurrentTimeMillis2 + jF;
                                    }
                                }
                            }
                        }
                        j = 0;
                    } else {
                        if (jCurrentTimeMillis2 >= jI + lVarBH.d()) {
                            fVarA.a(jCurrentTimeMillis2);
                            iM = 1;
                        } else if (iM >= lVarBH.c()) {
                            jF = lVarBH.f();
                            j = jCurrentTimeMillis2 + jF;
                        }
                        j = 0;
                    }
                } else if (iM >= lVarBH.b()) {
                    jF = lVarBH.f();
                    j = jCurrentTimeMillis2 + jF;
                } else {
                    j = 0;
                }
                fVarA.b(j);
                fVarA.b(iM);
                fVar = fVarA;
            }
            if (iA == 1) {
                this.d.remove(strG);
            }
            if (iA == 3 && fVar2 != null) {
                fVar.a(fVar2.i());
            }
            this.c.put(strG, Long.valueOf(fVar.n()));
            this.b.a(fVar, z);
        } catch (Throwable unused) {
        }
    }

    private static f a(l lVar, f fVar, f fVar2) {
        long jF;
        fVar2.e();
        int i = 1;
        int iM = fVar2.m() + 1;
        long jI = fVar2.i();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA = lVar.a();
        long j = 0;
        if (iA == 1) {
            if (iM >= lVar.b()) {
                jF = lVar.f();
                j = jCurrentTimeMillis + jF;
            }
            i = iM;
        } else if (iA != 2) {
            if (iA != 3) {
                i = iM;
            } else if (jCurrentTimeMillis >= jI + lVar.d()) {
                fVar2.a(jCurrentTimeMillis);
            } else {
                int i2 = fVar != null ? fVar.a : 0;
                if (i2 > 0 && i2 >= lVar.g()) {
                    if (((iM * 100) / i2 < lVar.e() ? 0 : 1) != 0) {
                        jF = lVar.f();
                        j = jCurrentTimeMillis + jF;
                    }
                }
                i = iM;
            }
        } else if (jCurrentTimeMillis >= jI + lVar.d()) {
            fVar2.a(jCurrentTimeMillis);
        } else {
            if (iM >= lVar.c()) {
                jF = lVar.f();
                j = jCurrentTimeMillis + jF;
            }
            i = iM;
        }
        fVar2.b(j);
        fVar2.b(i);
        return fVar2;
    }

    private static k a(int i) {
        if (i == 1) {
            return new k(32, ErrorCode.getErrorCode("2036", "", ""));
        }
        if (i == 2) {
            return new k(33, ErrorCode.getErrorCode(ErrorCode.noFillSError, "", ""));
        }
        if (i != 3) {
            return null;
        }
        return new k(34, ErrorCode.getErrorCode(ErrorCode.noFillSrError, "", ""));
    }

    private static String a(String str) {
        return a(str, "=");
    }

    private static String a(String str, String str2) {
        return String.format("%s %s ?", str, str2);
    }

    private f a(String str, String str2, int i) {
        List<f> listA = this.b.a(b(str, str2, i), 1);
        if (listA.isEmpty()) {
            return null;
        }
        return listA.get(0);
    }

    private List<f> a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.h, "="), str));
        arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.o, "="), String.valueOf(i)));
        return this.b.a(arrayList, 2);
    }

    private static List<Pair<String, String>> b(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(a("event_type", "="), str));
        arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.h, "="), str2));
        arrayList.add(new Pair(a(com.anythink.core.common.f.a.C0017a.o, "="), String.valueOf(i)));
        return arrayList;
    }
}
