package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 113})
public class d {
    public static final String n = "TTMediationSDK_d";
    public Map<String, Long> qg;

    private d() {
        this.qg = new ConcurrentHashMap();
    }

    public static d n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 89})
    private static class n {
        public static d n = new d();
    }

    public long n(String str, String str2) {
        Long l = this.qg.get(str + "_" + str2);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void qg(final String str, final String str2) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.bf.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rb.qg.n(d.n, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                rv rvVarQ = d.this.q(str, str2);
                if (rvVarQ == null || !rvVarQ.fs()) {
                    return;
                }
                Date date = new Date();
                com.byazt.rb.qg.n(d.n, "adn updateShowPacingTime save time = " + w.qg(date.getTime()));
                d.this.n(str, str2, date.getTime());
            }
        });
    }

    public boolean s(String str, String str2) {
        String str3 = n;
        com.byazt.rb.qg.n(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        rv rvVarQ = q(str, str2);
        if (rvVarQ != null && rvVarQ.fs() && rvVarQ.d()) {
            long time = new Date().getTime();
            long jCp = rvVarQ.cp();
            long jCp2 = rvVarQ.cp() + rvVarQ.rv();
            com.byazt.rb.qg.n(str3, "adn checkPacing currentTime = " + w.qg(time) + " showTime = " + w.qg(jCp) + " pacingBean.getPacing() = " + rvVarQ.rv() + " pacingTime = " + w.qg(jCp2));
            if (time <= jCp2) {
                this.qg.put(str + "_" + str2, Long.valueOf(time - jCp));
                return false;
            }
        }
        return true;
    }

    public boolean n(rv rvVar) {
        if (rvVar == null) {
            return false;
        }
        rv rvVarQ = q(rvVar.qg(), rvVar.s());
        if (rvVarQ == null) {
            com.byazt.rb.qg.n(n, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(rvVar.tj())) {
            com.byazt.rb.qg.n(n, "adn pacing ruleId 为空 清空本地数据 ");
            delete(rvVar.qg(), rvVar.s());
            return false;
        }
        if (TextUtils.equals(rvVarQ.tj(), rvVar.tj())) {
            com.byazt.rb.qg.n(n, "adn pacing ruleId 一致 ruleId = " + rvVarQ.tj() + " 无需处理");
            return false;
        }
        com.byazt.rb.qg.n(n, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + rvVarQ.tj() + "  new ruleId = " + rvVar.tj());
        delete(rvVar.qg(), rvVar.s());
        return true;
    }

    public void qg(rv rvVar) {
        tj.n().n(rvVar);
    }

    public void delete(String str, String str2) {
        tj.n().n(str, str2);
    }

    public rv q(String str, String str2) {
        return tj.n().qg(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, long j) {
        tj.n().n(str, str2, j);
    }
}
