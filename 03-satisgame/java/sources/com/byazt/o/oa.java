package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends n {
    public oa(Context context, com.byazt.f.n nVar, String str) {
        super(context, nVar, str);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        String strS = this.qg.s(com.anythink.core.common.s.a);
        String strN = com.byazt.bk.s.n(this.qg.s("bb"), strS);
        if (!TextUtils.isEmpty(strN) && strN.split(",").length == 2) {
            String strN2 = com.byazt.bk.s.n(this.qg.s("bc"), strS);
            if (!TextUtils.isEmpty(strN2) && strN2.split(",").length == 2) {
                String[] strArrSplit = strN.split(",");
                String[] strArrSplit2 = strN2.split(",");
                String strN3 = com.byazt.bk.s.n(this.qg.s("bd"), strS);
                String strN4 = com.byazt.bk.s.n(this.qg.s("be"), strS);
                String strN5 = com.byazt.bk.s.n(this.qg.s("bf"), strS);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strN3, this.s);
                Intent intent = new Intent();
                intent.setAction(strN5);
                intent.setData(Uri.parse(strN4 + n(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String n(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.length() - 1) : string;
    }
}
