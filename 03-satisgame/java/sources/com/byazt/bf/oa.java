package com.byazt.bf;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public Map<String, Long> n;
    public Map<String, Pair<String, String>> qg;

    private oa() {
        qg();
    }

    public static oa n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, TTAdConstant.IMAGE_URL_CODE})
    private static class n {
        public static oa n = new oa();
    }

    public void qg() {
        this.qg = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
    }

    public long n(String str) {
        Long l = this.n.get(str);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void qg(final String str) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.bf.oa.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + str);
                rv rvVarL = oa.this.l(str);
                if (rvVarL == null || !rvVarL.fs()) {
                    return;
                }
                Date date = new Date();
                com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + w.qg(date.getTime()));
                oa.this.n(str, date.getTime());
            }
        });
    }

    public boolean s(String str) {
        rv rvVarL = l(str);
        if (rvVarL != null && rvVarL.fs() && rvVarL.d()) {
            long time = new Date().getTime();
            long jCp = rvVarL.cp();
            long jCp2 = rvVarL.cp() + rvVarL.rv();
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + w.qg(time) + " showTime = " + w.qg(jCp) + " pacingBean.getPacing() = " + rvVarL.rv() + " pacingTime = " + w.qg(jCp2));
            if (time <= jCp2) {
                this.n.put(str, Long.valueOf(time - jCp));
                return false;
            }
        }
        return true;
    }

    public boolean n(rv rvVar) {
        if (rvVar == null) {
            return false;
        }
        rv rvVarL = l(rvVar.qg());
        if (rvVarL == null) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(rvVar.tj())) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            q(rvVar.q());
            return false;
        }
        if (TextUtils.equals(rvVarL.tj(), rvVar.tj())) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + rvVarL.tj() + " 无需处理");
            return false;
        }
        com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + rvVarL.tj() + "  new ruleId = " + rvVar.tj());
        com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "pacing 删除 ritId = " + rvVar.q());
        q(rvVar.q());
        return true;
    }

    public void n(String str, long j) {
        tj.n().n(str, j);
    }

    public void q(String str) {
        tj.n().n(str);
    }

    public void qg(rv rvVar) {
        tj.n().n(rvVar);
    }

    public rv l(String str) {
        return tj.n().qg(str);
    }

    public Pair<String, String> w(String str) {
        return this.qg.get(str);
    }

    public void x(final String str) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.bf.oa.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + str);
                x xVarTj = oa.this.tj(str);
                if (xVarTj == null || !xVarTj.fs()) {
                    return;
                }
                for (l lVar : xVarTj.cp()) {
                    if (lVar.l() < lVar.n()) {
                        oa.this.n(xVarTj, lVar.s(), lVar.l() + 1);
                    }
                }
            }
        });
    }

    public boolean fs(String str) {
        x xVarTj = tj(str);
        if (xVarTj == null || !xVarTj.fs()) {
            return true;
        }
        for (l lVar : xVarTj.cp()) {
            Date date = new Date();
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + lVar.q());
            if (date.getTime() <= lVar.q()) {
                if (lVar.l() < lVar.n()) {
                    com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + lVar.s() + " count = " + lVar.l());
                } else {
                    com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + lVar.s() + " count = " + lVar.l());
                    this.qg.put(str, new Pair<>(lVar.s(), new StringBuilder().append(lVar.l()).toString()));
                    return false;
                }
            } else {
                n(xVarTj, lVar.s(), 0);
                n(xVarTj, lVar.s(), w.n(lVar.qg()));
                com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + lVar.s());
            }
        }
        return true;
    }

    public boolean n(x xVar) {
        if (xVar == null) {
            return false;
        }
        x xVarTj = tj(xVar.qg());
        if (xVarTj == null) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(xVar.l())) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            rv(xVarTj.qg());
            return false;
        }
        if (TextUtils.equals(xVarTj.l(), xVar.l())) {
            com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + xVarTj.l() + "无需处理");
            return false;
        }
        com.byazt.rb.qg.n("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + xVarTj.l() + "  new version " + xVar.l());
        return true;
    }

    public void rv(String str) {
        fs.n().n(str);
    }

    public void qg(x xVar) {
        fs.n().n(xVar);
    }

    public x tj(String str) {
        return fs.n().qg(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(x xVar, String str, int i) {
        fs.n().n(xVar, str, i);
    }

    private void n(x xVar, String str, long j) {
        fs.n().n(xVar, str, j);
    }
}
