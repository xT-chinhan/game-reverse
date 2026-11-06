package com.byazt.jy;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK, 121})
public class x {
    public boolean aj;
    public float c;
    public List<pr> fw;
    public String hn;
    public String hw;
    public String pr;
    public List<pr> uc;
    public uc x;
    public List<hw> zo;

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

    public uc x() {
        return this.x;
    }

    public void pr(uc ucVar) {
        this.x = ucVar;
    }

    public void pr(float f) {
        this.c = f;
    }

    public List<pr> c() {
        return this.uc;
    }

    public void pr(List<pr> list) {
        this.uc = list;
    }

    public List<pr> uc() {
        return this.fw;
    }

    public void hw(List<pr> list) {
        this.fw = list;
    }

    public List<hw> fw() {
        return this.zo;
    }

    public void hn(List<hw> list) {
        this.zo = list;
    }

    public boolean zo() {
        return this.aj;
    }

    public void pr(boolean z) {
        this.aj = z;
    }

    public boolean pr(JSONObject jSONObject) {
        String strHw = hw();
        if (TextUtils.isEmpty(strHw)) {
            return true;
        }
        try {
            Object objPr = com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strHw)).pr(jSONObject);
            return objPr != null && Boolean.TRUE.equals(objPr);
        } catch (Exception e) {
            ho.pr("TTFeatureRule", "匹配过滤器失败: ".concat(String.valueOf(strHw)), e);
            return false;
        }
    }
}
