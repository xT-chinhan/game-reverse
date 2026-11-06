package com.anythink.core.a;

import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bv;
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
    private final com.anythink.core.common.e.a b;
    private final Map<String, Long> c = new ConcurrentHashMap();
    private final Map<String, Pair<Integer, Long>> e = new ConcurrentHashMap();
    private final Set<String> d = new CopyOnWriteArraySet();

    public e(com.anythink.core.common.e.a aVar) {
        this.b = aVar;
    }

    public final void a(bv bvVar) {
        try {
            l lVarBv = bvVar.bv();
            int iA = lVarBv.a();
            int i = 1;
            if (iA != 3) {
                Object[] objArr = new Object[1];
                Integer.valueOf(iA);
                return;
            }
            String strZ = bvVar.z();
            if (TextUtils.isEmpty(strZ)) {
                return;
            }
            f fVarA = a("3", strZ, iA);
            boolean z = fVarA != null;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                long jI = fVarA.i();
                if (jCurrentTimeMillis < lVarBv.d() + jI) {
                    i = 1 + fVarA.a;
                    jCurrentTimeMillis = jI;
                }
            } else {
                fVarA = new f("3");
                fVarA.a(strZ);
                fVarA.a(iA);
            }
            fVarA.a(jCurrentTimeMillis);
            fVarA.a = i;
            this.e.put(strZ, new Pair<>(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis)));
            Object[] objArr2 = new Object[3];
            Integer.valueOf(i);
            Boolean.valueOf(z);
            this.b.a(fVarA, z);
        } catch (Throwable unused) {
        }
    }

    public final k b(bv bvVar) {
        k kVar;
        try {
            String strZ = bvVar.z();
            int iA = bvVar.bv().a();
            if (TextUtils.isEmpty(strZ)) {
                return null;
            }
            Long l = this.c.get(strZ);
            boolean z = false;
            if (l == null) {
                f fVarA = a("4", strZ, iA);
                if (fVarA != null && fVarA.n() > System.currentTimeMillis()) {
                    z = true;
                }
            } else if (l.longValue() > System.currentTimeMillis()) {
                z = true;
            }
            Object[] objArr = new Object[3];
            Boolean.valueOf(z);
            if (!z) {
                return null;
            }
            if (iA == 1) {
                kVar = new k(32, ErrorCode.getErrorCode(ErrorCode.noFillNcError, "", ""));
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

    public final void c(bv bvVar) {
        try {
            l lVarBv = bvVar.bv();
            if (lVarBv == null) {
                return;
            }
            int iA = lVarBv.a();
            String strZ = bvVar.z();
            if (iA != 1) {
                Object[] objArr = new Object[1];
                Integer.valueOf(iA);
            } else {
                if (TextUtils.isEmpty(strZ)) {
                    return;
                }
                Object[] objArr2 = new Object[2];
                List<Pair<String, String>> listB = b("4", strZ, iA);
                if (this.d.contains(strZ)) {
                    Object[] objArr3 = new Object[1];
                    return;
                }
                this.d.add(strZ);
                this.c.remove(strZ);
                this.b.a(listB);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(bv bvVar) {
        f fVarA;
        long jF;
        long j;
        try {
            l lVarBv = bvVar.bv();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iA = lVarBv.a();
            String strZ = bvVar.z();
            if (TextUtils.isEmpty(strZ)) {
                return;
            }
            Object[] objArr = new Object[2];
            bvVar.z();
            f fVar = new f("4");
            f fVar2 = null;
            if (iA == 3) {
                boolean zContainsKey = this.e.containsKey(strZ);
                Pair<Integer, Long> pair = this.e.get(strZ);
                if (zContainsKey && pair != null) {
                    int iIntValue = ((Integer) pair.first).intValue();
                    long jLongValue = ((Long) pair.second).longValue();
                    fVar2 = new f("3");
                    fVar2.a = iIntValue;
                    fVar2.a(jLongValue);
                    fVar2.a(3);
                    fVarA = a("4", strZ, iA);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.h, "="), strZ));
                    arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.o, "="), String.valueOf(iA)));
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
                fVarA = a("4", strZ, iA);
            }
            boolean z = fVarA != null;
            if (!z) {
                fVar.a(strZ);
                fVar.a(iA);
                fVar.a(jCurrentTimeMillis);
                fVar.b(1);
                fVar.b(0L);
            } else {
                fVarA.e();
                int iM = fVarA.m() + 1;
                long jI = fVarA.i();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                int iA2 = lVarBv.a();
                if (iA2 != 1) {
                    if (iA2 != 2) {
                        if (iA2 == 3) {
                            if (jCurrentTimeMillis2 >= jI + lVarBv.d()) {
                                fVarA.a(jCurrentTimeMillis2);
                                Object[] objArr2 = new Object[3];
                                Integer.valueOf(1);
                                Integer.valueOf(iA2);
                                iM = 1;
                            } else {
                                int i = fVar2 != null ? fVar2.a : 0;
                                if (i <= 0 || i < lVarBv.g()) {
                                    Object[] objArr3 = new Object[3];
                                    Integer.valueOf(i);
                                    Integer.valueOf(iA2);
                                } else if ((iM * 100) / i >= lVarBv.e()) {
                                    jF = lVarBv.f();
                                    j = jF + jCurrentTimeMillis2;
                                }
                            }
                        }
                        j = 0;
                    } else {
                        if (jCurrentTimeMillis2 >= jI + lVarBv.d()) {
                            fVarA.a(jCurrentTimeMillis2);
                            Object[] objArr4 = new Object[3];
                            Integer.valueOf(1);
                            Integer.valueOf(iA2);
                            iM = 1;
                        } else if (iM >= lVarBv.c()) {
                            jF = lVarBv.f();
                            j = jF + jCurrentTimeMillis2;
                        }
                        j = 0;
                    }
                } else if (iM >= lVarBv.b()) {
                    jF = lVarBv.f();
                    j = jF + jCurrentTimeMillis2;
                } else {
                    j = 0;
                }
                if (j > 0) {
                    Object[] objArr5 = new Object[3];
                    Integer.valueOf(lVarBv.a());
                    Long.valueOf(j);
                }
                fVarA.b(j);
                fVarA.b(iM);
                fVar = fVarA;
            }
            if (iA == 1) {
                this.d.remove(strZ);
            }
            if (iA == 3 && fVar2 != null) {
                fVar.a(fVar2.i());
            }
            this.c.put(strZ, Long.valueOf(fVar.n()));
            this.b.a(fVar, z);
        } catch (Throwable unused) {
        }
    }

    private static f a(l lVar, f fVar, f fVar2) {
        long jF;
        long j;
        fVar2.e();
        int i = 1;
        int iM = fVar2.m() + 1;
        long jI = fVar2.i();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA = lVar.a();
        if (iA == 1) {
            if (iM >= lVar.b()) {
                jF = lVar.f();
                j = jCurrentTimeMillis + jF;
                i = iM;
            }
            i = iM;
            j = 0;
        } else if (iA != 2) {
            if (iA != 3) {
                i = iM;
            } else if (jCurrentTimeMillis >= jI + lVar.d()) {
                fVar2.a(jCurrentTimeMillis);
                Object[] objArr = new Object[3];
                Integer.valueOf(1);
                Integer.valueOf(iA);
            } else {
                int i2 = fVar != null ? fVar.a : 0;
                if (i2 <= 0 || i2 < lVar.g()) {
                    Object[] objArr2 = new Object[3];
                    Integer.valueOf(i2);
                    Integer.valueOf(iA);
                } else {
                    if (((iM * 100) / i2 < lVar.e() ? 0 : 1) != 0) {
                        jF = lVar.f();
                        j = jCurrentTimeMillis + jF;
                        i = iM;
                    }
                }
                i = iM;
            }
            j = 0;
        } else {
            if (jCurrentTimeMillis >= jI + lVar.d()) {
                fVar2.a(jCurrentTimeMillis);
                Object[] objArr3 = new Object[3];
                Integer.valueOf(1);
                Integer.valueOf(iA);
            } else {
                if (iM >= lVar.c()) {
                    jF = lVar.f();
                    j = jCurrentTimeMillis + jF;
                    i = iM;
                }
                i = iM;
            }
            j = 0;
        }
        if (j > 0) {
            Object[] objArr4 = new Object[3];
            Integer.valueOf(lVar.a());
            Long.valueOf(j);
        }
        fVar2.b(j);
        fVar2.b(i);
        return fVar2;
    }

    private static k a(int i) {
        if (i == 1) {
            return new k(32, ErrorCode.getErrorCode(ErrorCode.noFillNcError, "", ""));
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
        arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.h, "="), str));
        arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.o, "="), String.valueOf(i)));
        return this.b.a(arrayList, 2);
    }

    private static List<Pair<String, String>> b(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.b, "="), str));
        arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.h, "="), str2));
        arrayList.add(new Pair(a(com.anythink.core.common.e.a.C0080a.o, "="), String.valueOf(i)));
        return arrayList;
    }
}
