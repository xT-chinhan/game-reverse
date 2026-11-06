package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public String l;
    public String q;

    public rv(Context context, com.byazt.f.n nVar, String str, String str2, String str3) {
        super(context, nVar, str);
        this.q = str2;
        this.l = str3;
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        String str;
        String strS = this.qg.s(com.anythink.core.common.s.a);
        String strN = com.byazt.bk.s.n(this.qg.s("ak"), strS);
        String strN2 = com.byazt.bk.s.n(this.qg.s("am"), strS);
        String strN3 = com.byazt.bk.s.n(this.qg.s("an"), strS);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strN3) && strN3.split(",").length == 2) {
            String[] strArrSplit = strN3.split(",");
            String strN4 = com.byazt.bk.s.n(this.qg.s("al"), strS);
            String strN5 = com.byazt.bk.s.n(this.qg.s(LiveConfigKey.AUDIO), strS);
            if (!TextUtils.isEmpty(strN5) && strN5.split(",").length == 2) {
                String[] strArrSplit2 = strN5.split(",");
                JSONObject jSONObjectQ = this.qg.q("download_dir");
                if (jSONObjectQ != null) {
                    String strOptString = jSONObjectQ.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.l;
                    } else {
                        try {
                            str = String.format(strOptString, this.l);
                        } catch (Throwable unused) {
                            str = this.l;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strN4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strN);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strN2, this.q);
                intent.putExtra(strN4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
