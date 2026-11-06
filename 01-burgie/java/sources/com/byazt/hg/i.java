package com.byazt.hg;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO})
public class i {
    public int c;
    public String hn;
    public long k;
    public String lb;
    public Bundle nt;
    public com.byazt.ra.hn.pr ny;
    public String qa;
    public long vk;
    public long w;
    public int x;
    public int yb;
    public String cz = com.byazt.wt.ls.fw();
    public int pr = -1;
    public int hw = -1;
    public JSONArray uc = null;
    public int fw = 1;
    public long zo = System.currentTimeMillis();
    public long aj = System.currentTimeMillis();
    public JSONObject m = null;
    public int g = -1;
    public com.byazt.sd.ny ho = com.byazt.sd.ny.pr("");
    public boolean a = false;

    public i pr() {
        i iVar = new i();
        iVar.pr = this.pr;
        iVar.hw = this.hw;
        iVar.uc = this.uc;
        iVar.fw = this.fw;
        iVar.zo = this.zo;
        iVar.vk = this.vk;
        iVar.w = this.w;
        iVar.k = this.k;
        iVar.g = this.g;
        iVar.qa = this.qa;
        return iVar;
    }

    public void pr(String str) {
        this.cz = str;
    }

    public String hw() {
        return this.cz;
    }

    public void pr(String str, boolean z) {
        com.byazt.sd.ny nyVar;
        if (z && (nyVar = this.ho) != null && str != null) {
            nyVar.hw("cst_".concat(String.valueOf(str)));
        }
    }

    public void pr(String str, long j, boolean z) {
        com.byazt.sd.ny nyVar;
        if (z && (nyVar = this.ho) != null && str != null) {
            nyVar.pr("cst_".concat(String.valueOf(str)), j);
        }
    }

    public void pr(int i, String str, int i2, com.byazt.qe.hw hwVar) {
        this.ny = new com.byazt.ra.hn.pr(i, str, i2, System.currentTimeMillis(), hwVar);
    }

    public void pr(Object obj, int i) {
        int size;
        if (obj == null) {
            size = 0;
        } else {
            size = 1;
        }
        try {
            if (obj instanceof List) {
                size = ((List) obj).size();
            }
        } catch (Exception e) {
        }
        com.byazt.ra.hn.pr prVar = this.ny;
        if (prVar != null) {
            prVar.pr(size);
            com.byazt.ra.hn.pr(this.ny, i);
            this.ny = null;
        }
    }
}
