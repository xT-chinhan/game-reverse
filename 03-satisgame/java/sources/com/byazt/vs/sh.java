package com.byazt.vs;

import androidx.core.app.NotificationCompat;
import com.byazt.pmn.AppDownloadListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 1695})
public class sh extends com.byazt.cf.l<JSONObject, JSONObject> {
    public com.byazt.gcl.s n;

    public static void n(com.byazt.cf.cy cyVar, com.byazt.gcl.s sVar) {
        cyVar.n("sendMaterialMeta", (com.byazt.cf.l<?, ?>) new sh(sVar));
    }

    public sh(com.byazt.gcl.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        boolean zQg;
        com.byazt.gct.pk pkVarN = com.byazt.vgx.qg.n(jSONObject.optJSONObject("creative"));
        com.byazt.gcl.s sVar = this.n;
        if (sVar != null && pkVarN != null) {
            sVar.s(pkVarN);
        }
        com.byazt.gcl.s sVar2 = this.n;
        if (sVar2 != null) {
            zQg = sVar2.qg(pkVarN);
            if (pkVarN != null && pkVarN.rv() == 4) {
                final String strQ = pkVarN.q();
                if (this.n.x(strQ) == null) {
                    com.byazt.oh.n nVarN = com.byazt.iz.fs.n(com.byazt.nf.rv.getContext(), pkVarN, this.n.ur());
                    nVarN.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.vs.sh.1
                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onIdle() {
                            com.byazt.ll.n.n(strQ);
                        }

                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onDownloadActive(long j, long j2, String str, String str2) {
                            com.byazt.ll.n.n(strQ, j, j2);
                        }

                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onDownloadPaused(long j, long j2, String str, String str2) {
                            com.byazt.ll.n.qg(strQ, j, j2);
                        }

                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onDownloadFailed(long j, long j2, String str, String str2) {
                            com.byazt.ll.n.s(strQ, j, j2);
                        }

                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onDownloadFinished(long j, String str, String str2) {
                            com.byazt.ll.n.qg(strQ);
                        }

                        @Override // com.byazt.pmn.AppDownloadListener
                        public void onInstalled(String str, String str2) {
                            com.byazt.ll.n.s(strQ);
                        }
                    });
                    this.n.n(strQ, nVarN);
                }
            }
        } else {
            zQg = false;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (zQg) {
            jSONObject2.put("code", 0);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "success");
        } else {
            jSONObject2.put("code", 11);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "show 7 factors failed");
        }
        return jSONObject2;
    }
}
