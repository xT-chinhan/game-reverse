package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 110})
public class sz {
    public static volatile sz n;
    public Map<String, List<qg>> qg;
    public Map<String, ConcurrentHashMap<String, n>> s = new ConcurrentHashMap();

    private sz() {
    }

    public static sz n() {
        if (n == null) {
            synchronized (sz.class) {
                if (n == null) {
                    n = new sz();
                }
            }
        }
        return n;
    }

    public void n(ConcurrentHashMap<String, List<qg>> concurrentHashMap) {
        this.qg = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap = " + this.qg);
        } else {
            com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap is null ");
        }
    }

    public void n(String str, String str2, String str3, String str4) {
        List<qg> list;
        qg next;
        boolean z;
        com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level adnName = " + str2 + " slotId = " + str3 + " error = " + str4);
        Map<String, List<qg>> map = this.qg;
        if (map == null || (list = map.get(str2)) == null || list.size() == 0) {
            return;
        }
        Iterator<qg> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.s().contains(str));
        if (next == null) {
            z = false;
            break;
        }
        Iterator<String> it2 = next.qg().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            String next2 = it2.next();
            if (TextUtils.equals(next2, str4)) {
                com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "setAdnError rit_level 命中errorCode = ".concat(String.valueOf(next2)));
                z = true;
                break;
            }
        }
        if (z) {
            long time = new Date().getTime() + next.n();
            com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level 更新时间 = " + w.qg(time));
            n nVar = new n(str2, str3, time, str4);
            Map<String, ConcurrentHashMap<String, n>> map2 = this.s;
            if (map2 != null) {
                ConcurrentHashMap<String, n> concurrentHashMap = map2.get(str2);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
                concurrentHashMap.put(str + "_" + str3, nVar);
                this.s.put(str2, concurrentHashMap);
                com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level mAdnControlMap = " + this.s);
            }
        }
    }

    public com.byazt.mj.n n(String str, String str2, String str3) {
        n nVar;
        ConcurrentHashMap<String, n> concurrentHashMap;
        com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level adnName = " + str2 + " slotId = " + str3 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, ConcurrentHashMap<String, n>> map = this.s;
            if (map == null || (concurrentHashMap = map.get(str2)) == null) {
                nVar = null;
            } else {
                nVar = concurrentHashMap.get(str + "_" + str3);
                com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 取出的showBean = ".concat(String.valueOf(nVar)));
            }
            if (nVar != null && nVar.n() != 0) {
                long time = new Date().getTime();
                if (time <= nVar.n()) {
                    com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 当前时间 = " + w.qg(time));
                    com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 规则有效时间 = " + w.qg(nVar.n()));
                    return new com.byazt.pu.n(40064, com.byazt.mj.n.n(40064) + ", " + nVar.qg());
                }
            }
        }
        return null;
    }

    public boolean n(String str, String str2) {
        Map<String, List<qg>> map;
        List<qg> list;
        com.byazt.rb.qg.n("TTMediationSDK_RitAdnShowControl", "hasRitAdnConfig rit_level adnName = " + str2 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (map = this.qg) != null && map.size() != 0 && (list = this.qg.get(str2)) != null && list.size() != 0) {
            Iterator<qg> it = list.iterator();
            while (it.hasNext()) {
                List<String> listS = it.next().s();
                if (listS != null && listS.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
