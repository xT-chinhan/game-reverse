package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 8})
public class s {
    public Map<String, qg> n;
    public Map<String, ConcurrentHashMap<String, com.byazt.bf.n>> qg;

    private s() {
        this.qg = new ConcurrentHashMap();
    }

    public static s n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 546})
    private static class n {
        public static s n = new s();
    }

    public void n(ConcurrentHashMap<String, qg> concurrentHashMap) {
        this.n = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void n(String str, String str2, String str3) {
        boolean z;
        com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, qg> map = this.n;
        qg qgVar = map != null ? map.get(str) : null;
        if (qgVar == null) {
            z = false;
            break;
        }
        Iterator<String> it = qgVar.qg().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String next = it.next();
            if (TextUtils.equals(next, str3)) {
                com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(next)));
                z = true;
                break;
            }
        }
        if (z) {
            long time = new Date().getTime() + qgVar.n();
            com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + w.qg(time));
            com.byazt.bf.n nVar = new com.byazt.bf.n(str, str2, time);
            if (this.qg != null) {
                ConcurrentHashMap<String, com.byazt.bf.n> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, nVar);
                this.qg.put(str, concurrentHashMap);
                com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.qg);
            }
        }
    }

    public com.byazt.mj.n n(String str, String str2) {
        com.byazt.bf.n nVar;
        ConcurrentHashMap<String, com.byazt.bf.n> concurrentHashMap;
        com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.byazt.bf.n>> map = this.qg;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            nVar = null;
        } else {
            nVar = concurrentHashMap.get(str2);
            com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(nVar)));
        }
        if (nVar != null && nVar.n() != 0) {
            long time = new Date().getTime();
            if (time <= nVar.n()) {
                com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + w.qg(time));
                com.byazt.rb.qg.n("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + w.qg(nVar.n()));
                return new com.byazt.pu.n(40044, com.byazt.mj.n.n(40044));
            }
        }
        return null;
    }
}
