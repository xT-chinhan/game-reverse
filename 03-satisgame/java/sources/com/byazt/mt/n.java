package com.byazt.mt;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.jp.sz;
import com.byazt.nf.rv;
import com.byazt.rb.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 19})
public class n implements com.byazt.ju.q {
    @Override // com.byazt.ju.q
    public long l() {
        return 0L;
    }

    @Override // com.byazt.ju.q
    public int n(com.byazt.jp.s sVar) {
        return 0;
    }

    @Override // com.byazt.ju.q
    public void q() {
    }

    @Override // com.byazt.ju.q
    public Map<String, Object> qg(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.byazt.ju.q
    public int w() {
        return 0;
    }

    @Override // com.byazt.ju.q
    public void x() {
    }

    @Override // com.byazt.ju.q
    public String n() {
        return qg() + ".0";
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    @Override // com.byazt.ju.q
    public String n(Context context, Map<String, Object> map) {
        if (!com.byazt.zo.qg.l()) {
            return "";
        }
        if (map != null) {
            Object obj = map.get(com.byazt.ju.n.n);
            Object obj2 = map.get(com.byazt.ju.n.q);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map.get(com.byazt.ju.n.w);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            Object obj4 = map.get(com.byazt.ju.n.s);
            int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
            if (obj instanceof com.byazt.qn.qg) {
                com.byazt.qn.qg qgVar = (com.byazt.qn.qg) obj;
                int iUm = qgVar.um();
                if (iUm == 10) {
                    if (iIntValue == 1) {
                        iUm = 2;
                    } else if (iIntValue == 2) {
                        iUm = 8;
                    }
                } else if (iUm == 1) {
                    if (iIntValue == 3) {
                        iUm = 1;
                    } else if (iIntValue == 4) {
                        iUm = 5;
                    }
                } else if (iUm == 7) {
                    if (iIntValue == 6) {
                        iUm = 7;
                    } else if (iIntValue == 7 || iIntValue == 8) {
                        iUm = 8;
                    }
                } else if (iUm == 5) {
                    if (iIntValue == 4) {
                        iUm = 5;
                    } else if (iIntValue == 5) {
                        iUm = 9;
                    } else if (iIntValue == 3) {
                        iUm = 1;
                    }
                }
                com.byazt.zq.qg.n nVarN = qg.n(qgVar, qgVar.a(), str, str2, (String) null, true);
                nVarN.x(iUm).q(qgVar.ln()).w(qgVar.bb()).l(qgVar.ur());
                Integer num = (Integer) map.get(com.byazt.ju.n.qg);
                int iIntValue2 = num == null ? 0 : num.intValue();
                if (iUm == 3 || iUm == 7 || iUm == 8) {
                    if (qgVar.oa() <= 0.0f || qgVar.sz() <= 0.0f) {
                        nVarN.n(w.n(context, 1080.0f)).qg(w.n(context, 1920.0f));
                    } else {
                        nVarN.n(qgVar.oa()).qg(qgVar.sz());
                    }
                    if (qgVar.ou() <= 0 || qgVar.wm() <= 0) {
                        nVarN.n(1080).qg(1920);
                    } else {
                        nVarN.n(qgVar.ou()).qg(qgVar.wm());
                    }
                } else if (iUm == 1 || iUm == 2) {
                    if (qgVar.oa() > 0.0f && qgVar.sz() <= 0.0f) {
                        nVarN.n(qgVar.oa()).qg(0.0f);
                    } else if (qgVar.oa() > 0.0f && qgVar.sz() > 0.0f) {
                        nVarN.n(qgVar.oa()).qg(qgVar.sz());
                    } else {
                        nVarN.n(w.n(context, 1080.0f)).qg(w.n(context, 600.0f));
                    }
                    if (qgVar.ou() <= 0 || qgVar.wm() <= 0) {
                        nVarN.n(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).qg(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
                    } else {
                        nVarN.n(qgVar.ou()).qg(qgVar.wm());
                    }
                } else if (iUm == 5 || iUm == 9) {
                    nVarN.s(qgVar.m());
                    if (qgVar.oa() > 0.0f && qgVar.sz() <= 0.0f) {
                        nVarN.n(qgVar.oa()).qg(0.0f);
                    } else if (qgVar.oa() > 0.0f && qgVar.sz() > 0.0f) {
                        nVarN.n(qgVar.oa()).qg(qgVar.sz());
                    } else {
                        nVarN.n(w.n(context, 1080.0f)).qg(w.n(context, 750.0f));
                    }
                    if (qgVar.wm() <= 0 || qgVar.ou() <= 0) {
                        nVarN.n(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).qg(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
                    } else {
                        nVarN.n(qgVar.ou()).qg(qgVar.wm());
                    }
                } else {
                    nVarN.n(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO).qg(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                    nVarN.n(340.0f).qg(640.0f);
                }
                if (iIntValue2 != 0 && iIntValue2 == 1 && iUm == 5) {
                    nVarN.l(iUm);
                }
                if (iUm == 1 || iUm == 2) {
                    nVarN.l(iUm);
                }
                return rv.n().n(nVarN.n(), false, -1);
            }
        }
        return null;
    }

    private void fs() {
        rv();
    }

    @Override // com.byazt.ju.q
    public String qg() {
        return com.byazt.zo.qg.s();
    }

    @Override // com.byazt.ju.q
    public String s() {
        return com.byazt.zo.qg.q();
    }

    private void rv() {
        qg.qg(qg.n(qg.n(), "personal_ads_type", com.byazt.qt.n.d().qg().x() ? "0" : "1"));
    }

    @Override // com.byazt.ju.q
    public void n(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.byazt.ju.n.l);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            com.byazt.zo.qg.n(iIntValue);
        }
    }

    @Override // com.byazt.ju.q
    public void n(sz szVar, SparseArray<Object> sparseArray) {
        fs();
    }

    @Override // com.byazt.ju.qg
    public void n(Context context, Map<String, Object> map, com.byazt.ju.s sVar) {
        rv();
        sVar.n();
    }
}
