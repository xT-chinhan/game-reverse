package com.byazt.eld;

import android.os.Looper;
import android.os.Message;
import com.byazt.auw.DownloadInfo;
import com.byazt.fi.BaseConstants;
import com.byazt.lhc.BaseException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 37})
public class pr implements com.byazt.uk.g.pr {
    public static pr hw;
    public static final String pr = pr.class.getSimpleName();
    public com.byazt.uk.g hn = new com.byazt.uk.g(Looper.getMainLooper(), this);
    public long x;

    public static pr pr() {
        if (hw == null) {
            synchronized (pr.class) {
                if (hw == null) {
                    hw = new pr();
                }
            }
        }
        return hw;
    }

    private pr() {
    }

    public void pr(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        com.byazt.shh.pr prVar = new com.byazt.shh.pr(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
        if (prVarPr.pr("back_miui_silent_install", 1) == 0 && ((com.byazt.now.c.m() || com.byazt.now.c.g()) && com.byazt.tuy.vk.pr(k.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.byazt.tuy.uc.pr(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.hn.obtainMessage(200, prVar);
                messageObtainMessage.arg1 = 2;
                this.hn.sendMessageDelayed(messageObtainMessage, prVarPr.pr("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(prVar.hw);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception e) {
            }
            k.uc().pr(null, new BaseException(i, jSONObject.toString()), i);
            com.byazt.mf.pr.pr().pr(com.byazt.pfl.hw.AD_TAG_FEED, "ah_result", jSONObject, hwVarX);
        }
        if (com.byazt.uk.c.hn()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.x;
            long jX = com.byazt.uk.c.x();
            if (jCurrentTimeMillis >= com.byazt.uk.c.c()) {
                this.x = System.currentTimeMillis();
            } else {
                long jC = com.byazt.uk.c.c() - jCurrentTimeMillis;
                jX += jC;
                this.x = System.currentTimeMillis() + jC;
            }
            com.byazt.uk.g gVar = this.hn;
            gVar.sendMessageDelayed(gVar.obtainMessage(200, prVar), jX);
        }
    }

    private void pr(com.byazt.shh.pr prVar, int i) {
        if (k.k() == null || k.k().pr() || prVar == null) {
            return;
        }
        if (2 == i) {
            com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(prVar.hw);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.byazt.uk.m.c(k.getContext(), prVar.x)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception e) {
            }
            k.uc().pr(null, new BaseException(i2, jSONObject.toString()), i2);
            com.byazt.mf.pr.pr().pr(com.byazt.pfl.hw.AD_TAG_FEED, "ah_result", jSONObject, hwVarX);
        }
        if (com.byazt.uk.m.c(k.getContext(), prVar.x)) {
            com.byazt.mf.pr.pr().hw("delayinstall_installed", prVar.hw);
            return;
        }
        if (!com.byazt.uk.m.pr(prVar.fw)) {
            com.byazt.mf.pr.pr().hw("delayinstall_file_lost", prVar.hw);
        } else if (com.byazt.wc.pr.pr().pr(prVar.x)) {
            com.byazt.mf.pr.pr().hw("delayinstall_conflict_with_back_dialog", prVar.hw);
        } else {
            com.byazt.mf.pr.pr().hw("delayinstall_install_start", prVar.hw);
            com.byazt.mdu.x.pr(k.getContext(), (int) prVar.pr);
        }
    }

    @Override // com.byazt.uk.g.pr
    public void pr(Message message) {
        switch (message.what) {
            case 200:
                pr((com.byazt.shh.pr) message.obj, message.arg1);
                break;
        }
    }
}
