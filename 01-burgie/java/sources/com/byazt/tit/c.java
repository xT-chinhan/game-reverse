package com.byazt.tit;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.tn.pr {
    @Override // com.byazt.tn.pr
    public com.byazt.tn.pr.InterfaceC0198pr pr(String str) {
        return pr.pr(str);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 169})
    static class pr implements com.byazt.tn.pr.InterfaceC0198pr {
        public String hw;
        public com.byazt.oze.pr pr;

        private pr(String str) {
            this.hw = str;
            this.pr = com.byazt.oze.pr.pr(str);
        }

        public static pr pr(String str) {
            return new pr(str);
        }

        @Override // com.byazt.tn.pr.InterfaceC0198pr
        public Object pr(JSONObject jSONObject) {
            com.byazt.oze.pr prVar = this.pr;
            if (prVar == null) {
                return this.hw;
            }
            Object objPr = prVar.pr(jSONObject);
            if (objPr instanceof String) {
                return objPr;
            }
            if (objPr instanceof com.byazt.dg.pr) {
                return String.valueOf(rc.pr((com.byazt.dg.pr) objPr));
            }
            if (Build.VERSION.SDK_INT >= 19 && objPr != null && objPr.getClass().isArray()) {
                try {
                    return new JSONArray(objPr).toString();
                } catch (JSONException e) {
                    return String.valueOf(objPr);
                }
            }
            return String.valueOf(objPr);
        }
    }
}
