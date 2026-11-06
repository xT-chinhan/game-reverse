package com.byazt.jy;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK, 37})
public class pr {
    public String c;
    public String fw;
    public String hn;
    public String hw;
    public String pr;
    public List<hn> uc;
    public c x;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public String hw() {
        return this.hw;
    }

    public void hw(String str) {
        this.hw = str;
    }

    public String hn() {
        return this.hn;
    }

    public void hn(String str) {
        this.hn = str;
    }

    public c x() {
        return this.x;
    }

    public void pr(c cVar) {
        this.x = cVar;
    }

    public String c() {
        return this.c;
    }

    public void x(String str) {
        this.c = str;
    }

    public List<hn> uc() {
        return this.uc;
    }

    public void pr(List<hn> list) {
        this.uc = list;
    }

    public String fw() {
        return this.fw;
    }

    public void c(String str) {
        this.fw = str;
    }

    public boolean pr(JSONObject jSONObject) {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return true;
        }
        try {
            Object objPr = com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strC)).pr(jSONObject);
            return objPr != null && Boolean.TRUE.equals(objPr);
        } catch (Exception e) {
            ho.pr("TTFeatureAggregate", "匹配filter失败: ".concat(String.valueOf(strC)), e);
            return false;
        }
    }
}
