package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 21})
public class x {
    public String n;
    public List<String> qg;

    public x(Map<String, Object> map) {
        this.n = "";
        this.qg = new ArrayList();
        try {
            this.n = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.qg = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.qg.add(jSONArray.optString(i));
            }
        } catch (Exception unused) {
        }
    }

    public String n() {
        return this.n;
    }

    public List<String> qg() {
        return this.qg;
    }
}
