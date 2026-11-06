package com.byazt.ug;

import android.os.Looper;
import android.os.Message;
import com.byazt.ho.BaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 19})
public class n implements com.byazt.rz.sz.n {
    public static final String n = "n";
    public static n qg;
    public long q;
    public com.byazt.rz.sz s = new com.byazt.rz.sz(Looper.getMainLooper(), this);

    public static n n() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    private n() {
    }

    public void n(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.byazt.vl.n nVar = new com.byazt.vl.n(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
        if (nVarN.n("back_miui_silent_install", 1) == 0 && ((com.byazt.bk.l.oa() || com.byazt.bk.l.sz()) && com.byazt.ta.tj.n(d.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.byazt.ta.w.n(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.s.obtainMessage(200, nVar);
                messageObtainMessage.arg1 = 2;
                this.s.sendMessageDelayed(messageObtainMessage, nVarN.n("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(nVar.qg);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            d.w().n(null, new BaseException(i, jSONObject.toString()), i);
            com.byazt.vj.n.n().n(com.byazt.wg.qg.AD_TAG_FEED, "ah_result", jSONObject, qgVarQ);
        }
        if (com.byazt.rz.l.s()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.q;
            long jQ = com.byazt.rz.l.q();
            if (jCurrentTimeMillis < com.byazt.rz.l.l()) {
                long jL = com.byazt.rz.l.l() - jCurrentTimeMillis;
                jQ += jL;
                this.q = System.currentTimeMillis() + jL;
            } else {
                this.q = System.currentTimeMillis();
            }
            com.byazt.rz.sz szVar = this.s;
            szVar.sendMessageDelayed(szVar.obtainMessage(200, nVar), jQ);
        }
    }

    private void n(com.byazt.vl.n nVar, int i) {
        int i2;
        if (d.d() == null || d.d().n() || nVar == null) {
            return;
        }
        if (2 == i) {
            com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(nVar.qg);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.byazt.rz.oa.l(d.getContext(), nVar.q)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            d.w().n(null, new BaseException(i2, jSONObject.toString()), i2);
            com.byazt.vj.n.n().n(com.byazt.wg.qg.AD_TAG_FEED, "ah_result", jSONObject, qgVarQ);
        }
        if (com.byazt.rz.oa.l(d.getContext(), nVar.q)) {
            com.byazt.vj.n.n().qg("delayinstall_installed", nVar.qg);
            return;
        }
        if (!com.byazt.rz.oa.n(nVar.x)) {
            com.byazt.vj.n.n().qg("delayinstall_file_lost", nVar.qg);
        } else if (com.byazt.bn.n.n().n(nVar.q)) {
            com.byazt.vj.n.n().qg("delayinstall_conflict_with_back_dialog", nVar.qg);
        } else {
            com.byazt.vj.n.n().qg("delayinstall_install_start", nVar.qg);
            com.byazt.e.q.n(d.getContext(), (int) nVar.n);
        }
    }

    @Override // com.byazt.rz.sz.n
    public void n(Message message) {
        if (message.what != 200) {
            return;
        }
        n((com.byazt.vl.n) message.obj, message.arg1);
    }
}
