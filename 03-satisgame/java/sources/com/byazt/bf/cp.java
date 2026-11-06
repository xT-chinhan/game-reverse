package com.byazt.bf;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 29})
public class cp {
    public static final String n = "TTMediationSDK_cp";
    public Map<String, Pair<String, String>> qg;

    private cp() {
        this.qg = new ConcurrentHashMap();
    }

    public static cp n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 570})
    private static class n {
        public static cp n = new cp();
    }

    public Pair<String, String> n(String str, String str2) {
        return this.qg.get(str + "_" + str2);
    }

    public void qg(final String str, final String str2) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.bf.cp.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rb.qg.n(cp.n, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                x xVarQ = cp.this.q(str, str2);
                if (xVarQ == null || !xVarQ.fs()) {
                    return;
                }
                for (l lVar : xVarQ.cp()) {
                    if (lVar.l() < lVar.n()) {
                        cp.this.n(xVarQ, lVar.s(), lVar.l() + 1);
                    }
                }
            }
        });
    }

    public boolean s(String str, String str2) {
        com.byazt.rb.qg.n(n, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        x xVarQ = q(str, str2);
        if (xVarQ == null || !xVarQ.fs()) {
            return true;
        }
        for (l lVar : xVarQ.cp()) {
            Date date = new Date();
            String str3 = n;
            com.byazt.rb.qg.n(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + lVar.q());
            if (date.getTime() <= lVar.q()) {
                if (lVar.l() < lVar.n()) {
                    com.byazt.rb.qg.n(str3, "adn checkFreqctl 未到上限可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + lVar.s() + " count = " + lVar.l() + " showFreq = " + lVar.n());
                } else {
                    com.byazt.rb.qg.n(str3, "adn checkFreqctl 到了上限不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + lVar.s() + " count = " + lVar.l() + " showFreq = " + lVar.n());
                    this.qg.put(str + "_" + str2, new Pair<>(lVar.s(), new StringBuilder().append(lVar.l()).toString()));
                    return false;
                }
            } else {
                n(xVarQ, lVar.s(), 0);
                n(xVarQ, lVar.s(), w.n(lVar.qg()));
                com.byazt.rb.qg.n(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + lVar.s());
            }
        }
        return true;
    }

    public boolean n(x xVar) {
        if (xVar == null) {
            return false;
        }
        x xVarQ = q(xVar.qg(), xVar.s());
        if (xVarQ == null) {
            com.byazt.rb.qg.n(n, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(xVar.w())) {
            com.byazt.rb.qg.n(n, "adn freqctl version 为空 清空本地数据 ");
            delete(xVarQ.qg(), xVarQ.s());
            return false;
        }
        if (TextUtils.equals(xVarQ.w(), xVar.w())) {
            com.byazt.rb.qg.n(n, "adn freqctl version 一致 version = " + xVarQ.w() + " 无需处理");
            return false;
        }
        com.byazt.rb.qg.n(n, "adn freqctl version不一致，缓存新规则 old version = " + xVarQ.w() + "  new version " + xVar.w());
        return true;
    }

    public void qg(x xVar) {
        oa.n().qg(xVar);
    }

    public void delete(String str, String str2) {
        fs.n().n(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x q(String str, String str2) {
        return fs.n().qg(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(x xVar, String str, int i) {
        fs.n().n(xVar, str, i);
    }

    private void n(x xVar, String str, long j) {
        fs.n().n(xVar, str, j);
    }
}
