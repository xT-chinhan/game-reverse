package com.byazt.tp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.qa.x;
import com.byazt.qn.qg;
import com.byazt.sg.s;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2154, 19})
public class n {
    public static final List<String> s;
    public final Map<String, Integer> n = new ConcurrentHashMap();
    public final Map<String, Integer> qg = new HashMap();

    static {
        ArrayList arrayList = new ArrayList();
        s = arrayList;
        arrayList.add(MediationConstant.ADN_GDT);
        arrayList.add("baidu");
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add(MediationConstant.ADN_SIGMOB);
    }

    public void n(String str, String str2, int i) {
        this.n.put(str + "_" + str2, Integer.valueOf(i));
    }

    public int n(String str, String str2) {
        Integer num = this.n.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public void qg(String str, String str2, int i) {
        this.qg.put(str + "_" + str2, Integer.valueOf(i));
    }

    public int qg(String str, String str2) {
        Integer num = this.qg.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public int n(x xVar, qg qgVar, qg qgVar2, String str) {
        if (xVar == null || xVar.n == null) {
            return 4;
        }
        String strA = qgVar2 != null ? qgVar2.a() : "";
        String strLq = xVar.n.lq();
        String strEl = xVar.n.el();
        Integer numW = xVar.n.w();
        if (numW.intValue() == 1) {
            if (xVar.n.nf()) {
                com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + strLq + ", adSlotId: " + strEl);
                return 7;
            }
            if (n(strA, xVar.n)) {
                com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":广告过期了(M配置) ---: " + strLq + ", adSlotId: " + strEl);
                return 2;
            }
            if (!n(qgVar, qgVar2, xVar.n)) {
                com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + strLq + ", adSlotId: " + strEl);
                return 6;
            }
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + strLq + ", adSlotId: " + strEl);
            return -1;
        }
        if (xVar.n.nf()) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + strLq + ", adSlotId: " + strEl);
            return 7;
        }
        if (numW.intValue() == 3) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":广告过期了(adn api) ---: " + strLq + ", adSlotId: " + strEl);
            return 1;
        }
        if (numW.intValue() == 4) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":isReady是false ---: " + strLq + ", adSlotId: " + strEl);
            return 5;
        }
        if (!n(qgVar, qgVar2, xVar.n)) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + strLq + ", adSlotId: " + strEl);
            return 6;
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + strLq + ", adSlotId: " + strEl);
        return -1;
    }

    public final boolean n(String str, s sVar) {
        if (sVar == null || sVar.l()) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 广告已经destroy了，视为过期 ------");
            return true;
        }
        boolean z = SystemClock.elapsedRealtime() > sVar.e() + ((long) n(str, sVar.el()));
        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 使用了配置的过期时间进行判断 ------");
        return z;
    }

    public static boolean n(qg qgVar, qg qgVar2, s sVar) {
        if (qgVar == null || qgVar2 == null) {
            com.byazt.rb.qg.n("TMe", "--==-- adSlot = null, a1: " + qgVar + ", a2: " + qgVar2);
            return false;
        }
        if (qgVar.ln() != qgVar2.ln()) {
            com.byazt.rb.qg.n("TMe", "--==-- orientation, a1: " + qgVar.ln() + ", a2: " + qgVar2.ln());
            return false;
        }
        if (qgVar.lh() != qgVar2.lh()) {
            com.byazt.rb.qg.n("TMe", "--==-- isMuted, a1: " + qgVar.lh() + ", a2: " + qgVar2.lh());
            return false;
        }
        if (qgVar.ou() != qgVar2.ou()) {
            com.byazt.rb.qg.n("TMe", "--==-- ImgWidth, a1: " + qgVar.ou() + ", a2: " + qgVar2.ou());
            return false;
        }
        if (qgVar.wm() != qgVar2.wm()) {
            com.byazt.rb.qg.n("TMe", "--==-- ImgHeight, a1: " + qgVar.wm() + ", a2: " + qgVar2.wm());
            return false;
        }
        if (qgVar.h() != null && qgVar2.h() != null) {
            if (!qgVar.h().equals(qgVar2.h())) {
                com.byazt.rb.qg.n("TMe", "--==-- rewardName, a1: " + qgVar.h() + ", a2: " + qgVar2.h());
                return false;
            }
        } else if (qgVar.h() != null || qgVar2.h() != null) {
            com.byazt.rb.qg.n("TMe", "--==-- rewardName=null, a1: " + qgVar.h() + ", a2: " + qgVar2.h());
            return false;
        }
        if (qgVar.t() != qgVar2.t()) {
            com.byazt.rb.qg.n("TMe", "--==-- rewardAmount, a1: " + qgVar.t() + ", a2: " + qgVar2.t());
            return false;
        }
        if (qgVar.bb() != null && qgVar2.bb() != null) {
            if (!qgVar.bb().equals(qgVar2.bb())) {
                com.byazt.rb.qg.n("TMe", "--==-- reward, userId, a1: " + qgVar.bb() + ", a2: " + qgVar2.bb());
                return false;
            }
        } else if (qgVar.bb() != null || qgVar2.bb() != null) {
            com.byazt.rb.qg.n("TMe", "--==-- reward, userId=null, a1: " + qgVar.bb() + ", a2: " + qgVar2.bb());
            return false;
        }
        if (qgVar.an() != null && qgVar2.an() != null) {
            if (n(qgVar.an(), qgVar2.an())) {
                return true;
            }
            com.byazt.rb.qg.n("TMe", "--==-- customData, a1: " + qgVar.an().toString() + ", a2: " + qgVar2.an().toString());
            return false;
        }
        if (qgVar.an() == null && qgVar2.an() == null) {
            return true;
        }
        com.byazt.rb.qg.n("TMe", "--==-- customData=null, a1: " + qgVar.an() + ", a2: " + qgVar2.an());
        return false;
    }

    public static boolean n(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null) {
            return false;
        }
        for (String str : s) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = map.get(str);
                String str2 = obj instanceof String ? (String) obj : null;
                Object obj2 = map2.get(str);
                String str3 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 != null || str3 != null) {
                    if (!TextUtils.equals(str2, str3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
