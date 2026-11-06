package com.byazt.fk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 62})
public class fw {
    public String c;
    public final JSONObject hn;
    public final String hw;
    public final Map<String, List<String>> pr;
    public String uc;
    public final String x;

    public fw(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.hw = str;
        this.x = str2;
        this.pr = map;
        this.hn = jSONObject;
    }

    public void pr(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<String> list = this.pr.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                this.pr.put(str, arrayList);
                return;
            }
            list.add(str2);
        }
    }

    public Map<String, List<String>> pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public void pr(String str) {
        this.c = str;
    }

    public void hw(String str) {
        this.uc = str;
    }

    public String hn() {
        try {
            String strOptString = this.hn.optString("expandParams");
            String str = "apppackage=" + this.c + "|appsign=" + this.uc;
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString + "|" + str;
            }
            this.hn.put("expandParams", str);
        } catch (Exception e) {
        }
        JSONObject jSONObject = this.hn;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String x() {
        return this.x;
    }
}
