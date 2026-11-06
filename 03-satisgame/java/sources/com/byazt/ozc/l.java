package com.byazt.ozc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 18})
public class l {

    public interface n {
        void n(JSONObject jSONObject);
    }

    public static void n(com.byazt.ai.n nVar, n nVar2) {
        if (nVar == null) {
            if (nVar2 != null) {
                nVar2.n(null);
            }
        } else {
            n(nVar.s(), nVar.n(), nVar.qg(), nVar2);
        }
    }

    public static void n(String str, String str2, String str3, final n nVar) {
        JSONObject jSONObjectN = com.byazt.ep.fs.n().n(str2, str3);
        if (jSONObjectN == null) {
            com.byazt.jc.q.n(str, str2, str3, new com.byazt.jc.q.qg() { // from class: com.byazt.ozc.l.1
                @Override // com.byazt.jc.q.qg
                public void n(JSONObject jSONObject) {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(jSONObject);
                    }
                }

                @Override // com.byazt.jc.q.qg
                public void n() {
                    n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(null);
                    }
                }
            });
        } else if (nVar != null) {
            nVar.n(jSONObjectN);
        }
    }
}
