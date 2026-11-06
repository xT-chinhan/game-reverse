package com.anythink.core.common.u;

import android.text.TextUtils;
import com.anythink.core.common.h.by;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = "f";

    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    /* JADX WARN: Code duplicated, block: B:75:0x0128  */
    /* JADX WARN: Code duplicated, block: B:76:0x012a  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(com.anythink.core.e.l lVar, Map<String, Object> map, by byVar, com.anythink.core.common.h.n nVar, com.anythink.core.common.h.ac acVar) {
        int i;
        Object[] objArr;
        Map<String, Object> mapBf;
        int iIntValue;
        if (acVar == null) {
            return;
        }
        double dJ = acVar.j();
        if (dJ < 0.0d) {
            return;
        }
        int iK = acVar.k();
        boolean zL = acVar.l();
        List<Integer> listN = lVar.n();
        if (listN == null) {
            return;
        }
        boolean zW = byVar.w();
        int i2 = 4;
        if (iK == 22) {
            if (!(zW && listN.contains(3)) && (zW || !listN.contains(1))) {
                objArr = false;
                i = 2;
            } else {
                i = 2;
                objArr = true;
            }
        } else if (!(zW && listN.contains(4)) && (zW || !listN.contains(2))) {
            i = 5;
            objArr = false;
        } else {
            i = 5;
            objArr = true;
        }
        if (objArr == true) {
            int iM = (int) ((dJ / lVar.M()) * 100.0d);
            int i3 = zL ? 3 : 1;
            boolean zG = acVar.g();
            map.put("bd_a", Integer.valueOf(i));
            map.put("bd_b", Integer.valueOf(iM));
            map.put("bd_c", Integer.valueOf(i3));
            map.put("bd_s", Integer.valueOf(zG ? 1 : 0));
            if (iK == 22 || byVar == null || nVar == null) {
                return;
            }
            try {
                int iBL = byVar.bL();
                int iV = nVar.V();
                if (iBL == 1 && iV == 9) {
                    by byVarB = acVar.b();
                    if (byVarB != null && (mapBf = byVarB.bf()) != null) {
                        String str = (String) mapBf.get("native_material_publisher_name");
                        if (!TextUtils.isEmpty(str)) {
                            map.put("bd_e", str);
                        }
                        String str2 = (String) mapBf.get("native_material_tittle");
                        if (!TextUtils.isEmpty(str2)) {
                            map.put("bd_f", str2);
                        }
                        Object obj = mapBf.get("native_material_interaction_type");
                        if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue()) != 0) {
                            int iK2 = acVar.k();
                            if (iK2 == 15) {
                                map.put("bd_a", 1);
                                if (iIntValue != 1) {
                                    if (iIntValue == 2) {
                                        i2 = 2;
                                    } else if (iIntValue != 3) {
                                        i2 = -1;
                                    } else {
                                        i2 = 3;
                                    }
                                }
                            } else if (iK2 == 8) {
                                map.put("bd_a", 3);
                                if (iIntValue == 1) {
                                    i2 = 1;
                                } else if (iIntValue == 2) {
                                    i2 = 3;
                                } else if (iIntValue != 3) {
                                    i2 = -1;
                                } else {
                                    i2 = 2;
                                }
                            } else if (iK2 == 28) {
                                map.put("bd_a", 4);
                                if (iIntValue == 1) {
                                    i2 = 1;
                                } else if (iIntValue != 2) {
                                    i2 = 0;
                                } else {
                                    i2 = 2;
                                }
                            } else {
                                map.put("bd_a", 5);
                                if (iIntValue == 1) {
                                    i2 = 0;
                                } else if (iIntValue == 2) {
                                    i2 = 2;
                                } else if (iIntValue != 3) {
                                    i2 = -1;
                                } else {
                                    i2 = 1;
                                }
                            }
                            if (i2 != -1) {
                                map.put("bd_o", Integer.valueOf(i2));
                            }
                        }
                    }
                    map.put("bd_n", 1);
                    Map<String, Object> mapA = acVar.a(byVar.G());
                    if (mapA != null) {
                        Object obj2 = mapA.get("nw_extra_info");
                        if (obj2 instanceof JSONObject) {
                            String strOptString = ((JSONObject) obj2).optString("request_id");
                            if (TextUtils.isEmpty(strOptString)) {
                                return;
                            }
                            map.put("bd_r", strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    private static void a(Map<String, Object> map, by byVar, com.anythink.core.common.h.n nVar, com.anythink.core.common.h.ac acVar) {
        Map<String, Object> mapBf;
        int iIntValue;
        if (byVar == null || nVar == null) {
            return;
        }
        try {
            int iBL = byVar.bL();
            int iV = nVar.V();
            if (iBL == 1 && iV == 9) {
                by byVarB = acVar.b();
                if (byVarB != null && (mapBf = byVarB.bf()) != null) {
                    String str = (String) mapBf.get("native_material_publisher_name");
                    if (!TextUtils.isEmpty(str)) {
                        map.put("bd_e", str);
                    }
                    String str2 = (String) mapBf.get("native_material_tittle");
                    if (!TextUtils.isEmpty(str2)) {
                        map.put("bd_f", str2);
                    }
                    Object obj = mapBf.get("native_material_interaction_type");
                    if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue()) != 0) {
                        int iK = acVar.k();
                        int i = 4;
                        if (iK == 15) {
                            map.put("bd_a", 1);
                            if (iIntValue != 1) {
                                if (iIntValue == 2) {
                                    i = 2;
                                } else if (iIntValue != 3) {
                                    i = -1;
                                } else {
                                    i = 3;
                                }
                            }
                        } else if (iK == 8) {
                            map.put("bd_a", 3);
                            if (iIntValue == 1) {
                                i = 1;
                            } else if (iIntValue == 2) {
                                i = 3;
                            } else if (iIntValue != 3) {
                                i = -1;
                            } else {
                                i = 2;
                            }
                        } else if (iK == 28) {
                            map.put("bd_a", 4);
                            if (iIntValue == 1) {
                                i = 1;
                            } else if (iIntValue != 2) {
                                i = 0;
                            } else {
                                i = 2;
                            }
                        } else {
                            map.put("bd_a", 5);
                            if (iIntValue == 1) {
                                i = 0;
                            } else if (iIntValue == 2) {
                                i = 2;
                            } else if (iIntValue != 3) {
                                i = -1;
                            } else {
                                i = 1;
                            }
                        }
                        if (i != -1) {
                            map.put("bd_o", Integer.valueOf(i));
                        }
                    }
                }
                map.put("bd_n", 1);
                Map<String, Object> mapA = acVar.a(byVar.G());
                if (mapA != null) {
                    Object obj2 = mapA.get("nw_extra_info");
                    if (obj2 instanceof JSONObject) {
                        String strOptString = ((JSONObject) obj2).optString("request_id");
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        map.put("bd_r", strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r10 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r10 != 2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        if (r10 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (r10 != 3) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.Map<java.lang.String, java.lang.Object> r8, com.anythink.core.common.h.ac r9, int r10) {
        /*
            int r9 = r9.k()
            r0 = 15
            r1 = 4
            java.lang.String r2 = "bd_a"
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = -1
            if (r9 != r0) goto L1f
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r8.put(r2, r9)
            if (r10 == r5) goto L57
            if (r10 == r4) goto L1d
            if (r10 == r3) goto L31
            goto L54
        L1d:
            r1 = r4
            goto L57
        L1f:
            r0 = 8
            if (r9 != r0) goto L35
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            r8.put(r2, r9)
            if (r10 == r5) goto L33
            if (r10 == r4) goto L31
            if (r10 == r3) goto L1d
            goto L54
        L31:
            r1 = r3
            goto L57
        L33:
            r1 = r5
            goto L57
        L35:
            r0 = 28
            r7 = 0
            if (r9 != r0) goto L46
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)
            r8.put(r2, r9)
            if (r10 == r5) goto L33
            if (r10 == r4) goto L1d
            goto L56
        L46:
            r9 = 5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.put(r2, r9)
            if (r10 == r5) goto L56
            if (r10 == r4) goto L1d
            if (r10 == r3) goto L33
        L54:
            r1 = r6
            goto L57
        L56:
            r1 = r7
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.u.f.a(java.util.Map, com.anythink.core.common.h.ac, int):int");
    }
}
