package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1475})
public class lh {
    public String n;
    public String qg;
    public List<com.byazt.bz.qg> s = new ArrayList();

    public lh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optString("id");
        this.qg = jSONObject.optString(ImagesContract.URL);
        s();
    }

    public lh(String str, JSONArray jSONArray) {
        this.n = str;
        n(jSONArray);
    }

    public String n() {
        return this.n;
    }

    public List<com.byazt.bz.qg> qg() {
        return this.s;
    }

    private void s() {
        String strN = n(this.n);
        if (!TextUtils.isEmpty(strN)) {
            qg(strN);
        } else {
            if (TextUtils.isEmpty(this.qg)) {
                return;
            }
            com.byazt.phf.s.qg(this.qg).n(new com.byazt.qk.x() { // from class: com.byazt.gct.lh.1
                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    if (oaVar != null) {
                        try {
                            if (!oaVar.x() || oaVar.fs() == null) {
                                return;
                            }
                            com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
                            String strFs = oaVar.fs();
                            sVarN.n(lh.this.n, strFs);
                            lh.this.qg(strFs);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    private String n(String str) {
        com.byazt.gwu.s sVarN;
        if (TextUtils.isEmpty(str) || (sVarN = com.byazt.ikv.n.n()) == null) {
            return null;
        }
        return sVarN.qg(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.s.add(new com.byazt.bz.qg(jSONArray.getJSONObject(i)));
            }
        } catch (Exception unused) {
        }
    }

    private void n(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.s.add(new com.byazt.bz.qg(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }
}
