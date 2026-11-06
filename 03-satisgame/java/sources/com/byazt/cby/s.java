package com.byazt.cby;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 8})
public class s {
    public static List<tj> n(com.byazt.ws.qg qgVar, String str) {
        return n(qgVar, str, 0.0d, 0.0d);
    }

    public static List<tj> n(com.byazt.ws.qg qgVar, String str, double d, double d2) {
        int i;
        double dN;
        if (qgVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.byazt.ws.q qVarL = com.byazt.qt.qg.n().l(str);
        if (qVarL != null) {
            double dN2 = qVarL.n();
            double dQg = qVarL.qg();
            int iS = qVarL.s();
            if (qgVar.rv() == 3 || qgVar.rv() == 4) {
                i = 1;
                double[] dArrN = qg.q().n(qgVar.rv(), d, d2, qgVar.an(), str);
                double d3 = dArrN[0];
                qgVar.fs().put("price_from", Integer.valueOf((int) dArrN[1]));
                dN = d3;
            } else if (qgVar.rv() == 2) {
                dN = qg.q().n(3, str, iS);
                i = 1;
            } else {
                i = 1;
                dN = 0.0d;
            }
            if (!qVarL.l() && dN > 0.0d) {
                if (qVarL.getType() == i) {
                    qg(dN, dN2, dQg, qgVar, copyOnWriteArrayList);
                } else if (qVarL.getType() == 2) {
                    n(dN, dN2, dQg, qgVar, copyOnWriteArrayList);
                }
                List<com.byazt.ws.s> listW = com.byazt.qt.qg.n().w(String.valueOf(qgVar.fi()));
                if (listW != null) {
                    for (com.byazt.ws.s sVar : listW) {
                        if (dN > sVar.w() && dN <= sVar.l()) {
                            qgVar.fs().put("user_label_value", sVar);
                            break;
                        }
                    }
                }
            }
            qgVar.fs().put(a.C0017a.o, qVarL.q());
            qgVar.fs().put("ecpm", Double.valueOf(dN));
            qgVar.fs().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : i));
            qgVar.fs().put("group_type", Integer.valueOf(qgVar.rv()));
        }
        if (com.byazt.rb.qg.qg()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.byazt.rb.qg.n("DynamicRuleCalculate", "rit：" + ((tj) copyOnWriteArrayList.get(i2)).cd() + ",level：" + ((tj) copyOnWriteArrayList.get(i2)).h());
                }
            } else {
                com.byazt.rb.qg.n("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : qgVar.y();
    }

    private static void n(double d, double d2, double d3, com.byazt.ws.qg qgVar, List<tj> list) {
        if (qgVar == null || d2 == 0.0d || d < qgVar.t()) {
            return;
        }
        if (d > qgVar.h() && d3 <= 0.0d) {
            list.addAll(qgVar.y());
        } else {
            n(qgVar, d, d2, d3, list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a3 A[PHI: r5
      0x00a3: PHI (r5v10 int) = (r5v7 int), (r5v11 int) binds: [B:36:0x00a1, B:45:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    public static void n(com.byazt.ws.qg qgVar, double d, double d2, double d3, List<tj> list) {
        Map<Integer, List<tj>> mapSh = qgVar.sh();
        if (mapSh != null) {
            ArrayList arrayList = new ArrayList(mapSh.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i2));
                } else {
                    List<tj> list2 = mapSh.get(arrayList.get(i2));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.byazt.sq.qg.n(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int iMax = -1;
            int iMin = size;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                double d4 = i3;
                List<tj> list3 = mapSh.get(arrayList2.get(i3));
                if (list3 != null) {
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        tj tjVar = list3.get(i4);
                        if (tjVar != null && tjVar.um() == 0) {
                            double dDoubleValue = BigDecimal.valueOf(tjVar.m()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d == dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) (d4 - d2), 0);
                                }
                                if (iMin != size && d != dDoubleValue) {
                                    break;
                                }
                                if (d3 <= 0.0d) {
                                    iMin = size - 1;
                                    break;
                                } else {
                                    iMin = Math.min((int) (d4 + d3), size - 1);
                                    break;
                                }
                            }
                            if (d > dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) Math.ceil(((d4 + (d4 - 1.0d)) / 2.0d) - d2), 0);
                                }
                                if (iMin == size) {
                                    if (d3 <= 0.0d) {
                                        iMin = size - 1;
                                        break;
                                        break;
                                    } else {
                                        iMin = Math.min((int) Math.floor(((d4 + (d4 - 1.0d)) / 2.0d) + d3), size - 1);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
            if (iMax < 0) {
                iMax = 0;
            }
            if (iMin >= size) {
                iMin = size - 1;
            }
            int i5 = iMax;
            double d5 = -1.0d;
            double dM = -1.0d;
            double dM2 = -1.0d;
            while (i5 <= iMin) {
                List<tj> list4 = mapSh.get(arrayList2.get(i5));
                if (list4 != null && list4.size() != 0) {
                    while (i < list4.size()) {
                        tj tjVar2 = list4.get(i);
                        if (tjVar2 != null) {
                            if (dM < tjVar2.m() || dM == -1.0d) {
                                dM = tjVar2.m();
                            }
                            if (dM2 > tjVar2.m() || dM2 == -1.0d) {
                                dM2 = tjVar2.m();
                            }
                            list.add(tjVar2);
                            if (i5 == iMax) {
                                d5 = dM;
                            }
                        }
                        i++;
                    }
                }
                i5++;
                i = 0;
            }
            qgVar.fs().put("upper_cpm_x", Double.valueOf(d5));
            qgVar.fs().put("max_ecpm", Double.valueOf(dM));
            qgVar.fs().put("min_ecpm", Double.valueOf(dM2));
        }
    }

    private static void qg(double d, double d2, double d3, com.byazt.ws.qg qgVar, List<tj> list) {
        if (d2 < d3 || d2 <= 0.0d || d < qgVar.t()) {
            return;
        }
        if (d > qgVar.h() && d3 <= 0.0d) {
            list.addAll(qgVar.y());
            return;
        }
        double dDoubleValue = BigDecimal.valueOf(d * d2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double dDoubleValue2 = BigDecimal.valueOf(d * d3).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<tj> listY = qgVar.y();
        double dM = -1.0d;
        double dM2 = -1.0d;
        for (int i = 0; i < listY.size(); i++) {
            tj tjVar = listY.get(i);
            if (tjVar.um() == 0) {
                double dDoubleValue3 = BigDecimal.valueOf(tjVar.m()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (dDoubleValue3 <= dDoubleValue && dDoubleValue3 >= dDoubleValue2) {
                    if (dM == -1.0d || dM < tjVar.m()) {
                        dM = tjVar.m();
                    }
                    if (dM2 == -1.0d || dM2 > tjVar.m()) {
                        dM2 = tjVar.m();
                    }
                    list.add(tjVar);
                }
            } else {
                list.add(tjVar);
            }
        }
        qgVar.fs().put("max_ecpm", Double.valueOf(dM));
        qgVar.fs().put("min_ecpm", Double.valueOf(dM2));
        qgVar.fs().put("upper_cpm_x", Double.valueOf(dDoubleValue));
    }
}
