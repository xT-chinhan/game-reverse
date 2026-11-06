package com.byazt.sa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 158, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {

    public interface pr {
        void pr(JSONObject jSONObject);
    }

    public static void pr(com.byazt.qk.pr prVar, pr prVar2) {
        if (prVar == null) {
            if (prVar2 != null) {
                prVar2.pr(null);
            }
        } else {
            pr(prVar.hn(), prVar.pr(), prVar.hw(), prVar2);
        }
    }

    public static void pr(String str, String str2, String str3, final pr prVar) {
        JSONObject jSONObjectPr = com.byazt.ea.zo.pr().pr(str2, str3);
        if (jSONObjectPr == null) {
            com.byazt.pk.hn.pr(str, str2, str3, new com.byazt.pk.hn.hw() { // from class: com.byazt.sa.c.1
                @Override // com.byazt.pk.hn.hw
                public void pr(JSONObject jSONObject) {
                    pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr(jSONObject);
                    }
                }

                @Override // com.byazt.pk.hn.hw
                public void pr() {
                    pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr(null);
                    }
                }
            });
        } else if (prVar != null) {
            prVar.pr(jSONObjectPr);
        }
    }
}
