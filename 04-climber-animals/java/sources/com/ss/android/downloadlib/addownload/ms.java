package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements com.ss.android.downloadlib.ab.u.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4426ms = "ms";
    private static ms xr;
    private com.ss.android.downloadlib.ab.u ah = new com.ss.android.downloadlib.ab.u(Looper.getMainLooper(), this);
    private long d;

    public static ms ms() {
        if (xr == null) {
            synchronized (ms.class) {
                if (xr == null) {
                    xr = new ms();
                }
            }
        }
        return xr;
    }

    private ms() {
    }

    public void ms(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.ss.android.downloadlib.addownload.xr.ms msVar = new com.ss.android.downloadlib.addownload.xr.ms(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
        if (msVarMs.ms("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.c.ka.zb() || com.ss.android.socialbase.appdownloader.c.ka.u()) && com.ss.android.socialbase.downloader.ny.ch.ms(hi.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.ah.obtainMessage(200, msVar);
                messageObtainMessage.arg1 = 2;
                this.ah.sendMessageDelayed(messageObtainMessage, msVarMs.ms("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(msVar.xr);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            hi.c().ms(null, new BaseException(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.d.ms.ms().ms("embeded_ad", "ah_result", jSONObject, xrVarD);
        }
        if (com.ss.android.downloadlib.ab.ka.ah()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
            long jD = com.ss.android.downloadlib.ab.ka.d();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.ab.ka.ka()) {
                long jKa = com.ss.android.downloadlib.ab.ka.ka() - jCurrentTimeMillis;
                jD += jKa;
                this.d = System.currentTimeMillis() + jKa;
            } else {
                this.d = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.ab.u uVar = this.ah;
            uVar.sendMessageDelayed(uVar.obtainMessage(200, msVar), jD);
        }
    }

    private void ms(com.ss.android.downloadlib.addownload.xr.ms msVar, int i) {
        int i2;
        if (hi.sl() == null || hi.sl().ms() || msVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(msVar.xr);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.ab.zb.ka(hi.getContext(), msVar.d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            hi.c().ms(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.d.ms.ms().ms("embeded_ad", "ah_result", jSONObject, xrVarD);
        }
        if (com.ss.android.downloadlib.ab.zb.ka(hi.getContext(), msVar.d)) {
            com.ss.android.downloadlib.d.ms.ms().ms("delayinstall_installed", msVar.xr);
            return;
        }
        if (!com.ss.android.downloadlib.ab.zb.ms(msVar.ab)) {
            com.ss.android.downloadlib.d.ms.ms().ms("delayinstall_file_lost", msVar.xr);
        } else if (com.ss.android.downloadlib.addownload.ms.ms.ms().ms(msVar.d)) {
            com.ss.android.downloadlib.d.ms.ms().ms("delayinstall_conflict_with_back_dialog", msVar.xr);
        } else {
            com.ss.android.downloadlib.d.ms.ms().ms("delayinstall_install_start", msVar.xr);
            com.ss.android.socialbase.appdownloader.d.ms(hi.getContext(), (int) msVar.f4455ms);
        }
    }

    @Override // com.ss.android.downloadlib.ab.u.ms
    public void ms(Message message) {
        if (message.what != 200) {
            return;
        }
        ms((com.ss.android.downloadlib.addownload.xr.ms) message.obj, message.arg1);
    }
}
