package com.byazt.vp;

import android.text.TextUtils;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1053, 19})
public class n {
    public static Map<String, C0375n> n = new ConcurrentHashMap();

    public static void n(com.byazt.qn.qg qgVar, tj tjVar, Map<String, Object> map) {
        C0375n c0375n;
        if (qgVar == null || tjVar == null || map == null || !tjVar.j() || !"baidu".equals(tjVar.k()) || (c0375n = n.get(qgVar.a())) == null) {
            return;
        }
        map.put(MediationConstant.BIDDING_WIN_ADN, c0375n.n);
        map.put(MediationConstant.BIDDING_WIN_PRICE, Double.valueOf(c0375n.s));
        Boolean boolValueOf = Boolean.valueOf(com.byazt.qt.qg.n().vb());
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, boolValueOf);
        if (boolValueOf.booleanValue()) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0375n.q);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0375n.qg);
        }
    }

    public static void n(com.byazt.qn.qg qgVar, com.byazt.ws.qg qgVar2, List<com.byazt.sg.s> list, List<com.byazt.sg.s> list2) {
        HashMap map;
        com.byazt.sg.s next;
        if (qgVar == null || qgVar2 == null || list == null || list.size() == 0 || !qgVar.j() || !n(qgVar2)) {
            return;
        }
        Iterator<com.byazt.sg.s> it = list.iterator();
        while (true) {
            map = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && "baidu".equals(next.lq())) {
                break;
            }
        }
        if (next == null) {
            next = list.get(0);
        }
        if (next != null) {
            if (com.byazt.qt.qg.n().vb() && (list2 != null || list2.size() != 0)) {
                map = new HashMap();
                for (com.byazt.sg.s sVar : list2) {
                    map.put(sVar.el(), sVar.di());
                }
            }
            n.put(qgVar2.f(), new C0375n(next.el(), next.lq(), next.ta(), map));
        }
    }

    private static boolean n(com.byazt.ws.qg qgVar) {
        if (qgVar == null) {
            return false;
        }
        for (tj tjVar : qgVar.y()) {
            if (TextUtils.equals(tjVar.k(), "baidu") && tjVar.j()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.byazt.vp.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1053, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    static class C0375n {
        public String n;
        public Map<String, String> q;
        public String qg;
        public double s;

        public C0375n(String str, String str2, double d, Map<String, String> map) {
            this.n = str2;
            this.s = d;
            this.q = map;
            this.qg = str;
        }
    }
}
