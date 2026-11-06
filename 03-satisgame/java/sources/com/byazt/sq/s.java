package com.byazt.sq;

import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.byazt.mh.l;
import com.byazt.vy.wm;
import com.byazt.ws.tj;
import com.byazt.ya.q;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1265, 8})
public class s {
    public static Comparator<com.byazt.sg.s> n = null;
    public static String q = "KEY_LOAD_SEQ_TIME";
    public static Comparator<com.byazt.sg.s> qg = null;
    public static String s = "KEY_LOAD_SEQ";

    public static boolean qg(String str) {
        return true;
    }

    public static Comparator<com.byazt.sg.s> n() {
        Comparator<com.byazt.sg.s> comparator = n;
        return comparator != null ? comparator : s();
    }

    public static Comparator<com.byazt.sg.s> qg() {
        Comparator<com.byazt.sg.s> comparator = qg;
        return comparator != null ? comparator : q();
    }

    public static Comparator<com.byazt.sg.s> s() {
        Comparator<com.byazt.sg.s> comparator = new Comparator<com.byazt.sg.s>() { // from class: com.byazt.sq.s.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.sg.s sVar, com.byazt.sg.s sVar2) {
                if (sVar.ta() > sVar2.ta()) {
                    return -1;
                }
                if (sVar.ta() < sVar2.ta()) {
                    return 1;
                }
                return (sVar.ta() == sVar2.ta() && sVar.he() == 1) ? -1 : 0;
            }
        };
        n = comparator;
        return comparator;
    }

    public static Comparator<com.byazt.sg.s> q() {
        Comparator<com.byazt.sg.s> comparator = new Comparator<com.byazt.sg.s>() { // from class: com.byazt.sq.s.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.sg.s sVar, com.byazt.sg.s sVar2) {
                if (sVar.xi() > sVar2.xi()) {
                    return -1;
                }
                if (sVar.xi() < sVar2.xi()) {
                    return 1;
                }
                return (sVar.xi() == sVar2.xi() && sVar.he() == 1) ? -1 : 0;
            }
        };
        qg = comparator;
        return comparator;
    }

    public static void n(List<com.byazt.sg.s> list, Comparator<com.byazt.sg.s> comparator) {
        if (comparator == null) {
            wm.n(list);
        } else {
            wm.n(list, comparator);
        }
    }

    public static String n(String str, String str2, String str3) {
        return "com.bytedance.msdk.adapter." + com.byazt.sg.n.n(str2) + i.E + String.format(str, str2, str3);
    }

    public static boolean n(tj tjVar) {
        if (tjVar != null && TextUtils.equals(tjVar.k(), MediationConstant.ADN_PANGLE)) {
            return true;
        }
        if (tjVar != null && l.n(tjVar.k())) {
            return true;
        }
        if (tjVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionL = com.byazt.zs.n.n().l();
        if (functionL != null) {
            String strQg = qg(tjVar);
            String strQg2 = q.qg(tjVar.k());
            if (TextUtils.isEmpty(strQg)) {
                return false;
            }
            com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
            nVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, strQg);
            nVarN.n(8560, strQg2);
            nVarN.n(-99999987, 8229);
            nVarN.n(-99999985, Boolean.class);
            return ((Boolean) functionL.apply(nVarN.qg().sparseArray())).booleanValue();
        }
        com.byazt.rb.qg.qg(MediationConstant.TAG, "load ad check class loader is null ");
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    private static String qg(tj tjVar) {
        String str;
        String str2 = "";
        if (tjVar == null) {
            return "";
        }
        String strK = tjVar.k();
        strK.hashCode();
        switch (strK) {
            case "klevin":
                str = "com.bytedance.msdk.adapter.klevin.Klevin";
                break;
            case "pangle":
                str = "com.bytedance.msdk.adapter.pangle_csjm.Pangle";
                break;
            case "sigmob":
                str = "com.bytedance.msdk.adapter.sigmob.Sigmob";
                break;
            case "xiaomi":
                str = "com.bytedance.msdk.adapter.xiaomi.Xiaomi";
                break;
            case "ks":
                str = "com.bytedance.msdk.adapter.ks.Ks";
                break;
            case "gdt":
                str = "com.bytedance.msdk.adapter.gdt.Gdt";
                break;
            case "baidu":
                str = "com.bytedance.msdk.adapter.baidu.Baidu";
                break;
            case "unity":
                str = "com.bytedance.msdk.adapter.unity.Unity";
                break;
            case "mintegral":
                str = "com.bytedance.msdk.adapter.mintegral.Mintegral";
                break;
            default:
                str = "";
                break;
        }
        int iW = tjVar.w();
        switch (tjVar.oa()) {
            case 1:
                str2 = "BannerLoader";
                break;
            case 2:
                str2 = "InterstitialLoader";
                break;
            case 3:
                str2 = "SplashLoader";
                break;
            case 5:
                str2 = "NativeLoader";
                if (iW != 4) {
                    if (iW == 5) {
                        str2 = "DrawLoader";
                    } else if (iW == 3) {
                        str2 = "BannerLoader";
                    }
                }
                break;
            case 7:
                str2 = "RewardLoader";
                if (iW != 6) {
                    if (iW == 7) {
                        str2 = "FullVideoLoader";
                    } else if (iW == 8) {
                        str2 = "InterstitialLoader";
                    }
                }
                break;
            case 8:
                str2 = "FullVideoLoader";
                break;
            case 9:
                str2 = "DrawLoader";
                break;
            case 10:
                if (iW == 1) {
                    str2 = "InterstitialLoader";
                } else if (iW == 2) {
                    str2 = "FullVideoLoader";
                }
                break;
        }
        return str.concat(str2);
    }

    public static String n(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static String l() {
        return UUID.randomUUID().toString();
    }

    public static tj n(String str, String str2, int i, int i2) {
        tj tjVar = new tj();
        tjVar.s(str2);
        tjVar.l(str);
        tjVar.tj(0);
        tjVar.x("0");
        tjVar.qg("1");
        tjVar.cp(i);
        tjVar.d(i2);
        tjVar.rv(3);
        tjVar.n("%1$s%2$sAdapter");
        return tjVar;
    }

    private static boolean n(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static int w() {
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(com.byazt.qt.n.d().oa(), "gm_tt_ad_mediation_sdk_sp");
        long j = sVarN.getLong(q, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zN = n(new Date(j), new Date(jCurrentTimeMillis));
        sVarN.n(q, jCurrentTimeMillis);
        int i = (zN ? sVarN.getInt(s, 0) : 0) + 1;
        sVarN.n(s, i);
        return i;
    }

    public static void n(com.byazt.mj.n nVar, tj tjVar) {
        if (!com.byazt.qt.qg.n().e() || nVar == null || tjVar == null) {
            return;
        }
        if (820001 == nVar.n) {
            com.byazt.mj.q.n(com.byazt.qt.qg.getContext(), String.format("error_adn:%1$s no ads，please check ad network", tjVar.hd()));
        } else {
            com.byazt.mj.q.n(com.byazt.qt.qg.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", tjVar.hd(), tjVar.cd(), Integer.valueOf(nVar.s), nVar.q));
        }
    }

    public static void n(String str, tj tjVar, com.byazt.sg.s sVar) {
        if (com.byazt.qt.qg.n().e() && tjVar != null && qg(str, sVar)) {
            com.byazt.mj.q.n(com.byazt.qt.qg.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", tjVar.k(), Integer.valueOf(tjVar.um())));
        }
    }

    public static void n(String str, com.byazt.sg.s sVar) {
        if (com.byazt.qt.qg.n().e() && sVar != null && qg(str, sVar)) {
            com.byazt.mj.q.n(com.byazt.qt.qg.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.byazt.sg.n.n(sVar.he()), sVar.el()));
        }
    }

    private static boolean qg(String str, com.byazt.sg.s sVar) {
        if (sVar == null) {
            return false;
        }
        com.byazt.ws.qg qgVarN = com.byazt.qt.qg.n().n(str, sVar.ct(), 101);
        return com.byazt.qt.qg.n().qg(str, sVar.ct()) && qgVarN != null && qgVarN.ae() != null && qgVarN.ae().size() > 0 && qgVarN.ur() != null && qgVarN.ur().size() > 0;
    }
}
