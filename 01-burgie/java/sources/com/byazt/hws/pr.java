package com.byazt.hws;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.kr.c;
import com.byazt.kr.uc;
import com.byazt.kr.x;
import com.byazt.tl.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 37})
public class pr {
    public Map<String, Object> aj;
    public String c;
    public x fw;
    public com.byazt.re.pr hn;
    public Map<String, Object> hw;
    public com.byazt.kr.hw k;
    public JSONObject pr;
    public x uc;
    public boolean vk;
    public int w;
    public String x;
    public String zo;

    public pr(com.byazt.re.pr prVar, JSONObject jSONObject, Map<String, Object> map) {
        this.w = 1;
        this.hn = prVar;
        this.pr = jSONObject;
        this.hw = map;
    }

    public pr(String str, int i, JSONObject jSONObject, Map<String, Object> map) {
        this.w = 1;
        if (i == 2) {
            this.zo = str;
        } else if (i == 3) {
            this.x = str;
        }
        this.w = i;
        this.pr = jSONObject;
        this.hw = map;
    }

    public Map<String, Object> pr() {
        return this.hw;
    }

    public Map<String, Object> hw() {
        return this.aj;
    }

    public JSONObject hn() {
        return this.pr;
    }

    public void pr(String str) {
        this.c = str;
    }

    public String x() {
        return this.c;
    }

    public x c() {
        return this.uc;
    }

    public void pr(x xVar) {
        if (xVar instanceof hw) {
            this.uc = xVar;
        } else {
            this.fw = xVar;
        }
    }

    public boolean uc() {
        return this.vk;
    }

    public void pr(boolean z) {
        this.vk = z;
    }

    private void aj() {
        switch (this.w) {
            case 2:
                break;
            default:
                com.byazt.re.pr prVar = this.hn;
                if (prVar == null) {
                    return;
                }
                this.zo = prVar.hw();
                break;
                break;
        }
        if (!TextUtils.isEmpty(this.zo)) {
            this.x = Uri.parse(this.zo).getHost();
        }
        if (!TextUtils.isEmpty(this.x)) {
            String str = this.x.split("/")[0];
            this.x = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.x.length();
            }
            this.x = this.x.substring(0, iIndexOf);
        }
        hw(this.zo);
    }

    private void hw(String str) {
        hn(str);
        JSONObject jSONObjectPr = hn.pr(str);
        if (jSONObjectPr == null) {
            return;
        }
        vk();
        Iterator<String> itKeys = jSONObjectPr.keys();
        this.aj = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectPr.opt(next);
                if (objOpt instanceof String) {
                    objOpt = pr((String) objOpt, this.pr);
                }
                this.aj.put(next, objOpt);
            }
        }
    }

    private static Object pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            if (str.startsWith("${") && str.endsWith("}")) {
                return com.byazt.oze.pr.pr(str.substring(2, str.length() - 1)).pr(jSONObject);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    public void pr(com.byazt.kr.hw hwVar) {
        this.k = hwVar;
    }

    public void fw() {
        aj();
        w();
        com.byazt.kr.hw hwVar = this.k;
        if (hwVar != null) {
            hwVar.pr();
        } else {
            com.byazt.kp.pr.pr().pr(this.x, this, new com.byazt.kr.pr() { // from class: com.byazt.hws.pr.1
            });
        }
    }

    public void pr(Map<String, Object> map) {
        c cVarHn;
        c cVarHn2;
        vk();
        x xVar = this.uc;
        if (xVar != null && (cVarHn2 = xVar.hn()) != null) {
            cVarHn2.pr(this, map);
        }
        x xVar2 = this.fw;
        if (xVar2 != null && (cVarHn = xVar2.hn()) != null) {
            cVarHn.pr(this, map);
        }
    }

    public void pr(Map<String, Object> map, com.byazt.rs.pr prVar) {
        c cVarHn;
        c cVarHn2;
        vk();
        x xVar = this.uc;
        if (xVar != null && (cVarHn2 = xVar.hn()) != null) {
            cVarHn2.pr(this, this.hw, prVar);
        }
        x xVar2 = this.fw;
        if (xVar2 != null && (cVarHn = xVar2.hn()) != null) {
            cVarHn.pr(this, map, prVar);
        }
    }

    public void hw(Map<String, Object> map) {
        c cVarHn;
        c cVarHn2;
        vk();
        x xVar = this.fw;
        if (xVar != null && (cVarHn2 = xVar.hn()) != null) {
            cVarHn2.pr(this, map);
        }
        x xVar2 = this.uc;
        if (xVar2 != null && (cVarHn = xVar2.hn()) != null) {
            cVarHn.pr(this, map);
        }
    }

    public void hw(Map<String, Object> map, com.byazt.rs.pr prVar) {
        c cVarHn;
        c cVarHn2;
        vk();
        x xVar = this.fw;
        if (xVar != null && (cVarHn2 = xVar.hn()) != null) {
            cVarHn2.pr(this, map, prVar);
        }
        x xVar2 = this.uc;
        if (xVar2 != null && (cVarHn = xVar2.hn()) != null) {
            cVarHn.pr(this, map, prVar);
        }
    }

    private void hn(String str) {
        uc ucVarHw;
        uc ucVarHw2;
        x xVar = this.uc;
        if (xVar != null && (ucVarHw2 = xVar.hw()) != null) {
            ucVarHw2.pr(str, this);
        }
        x xVar2 = this.fw;
        if (xVar2 != null && (ucVarHw = xVar2.hw()) != null) {
            ucVarHw.pr(str, this);
        }
    }

    private void vk() {
        uc ucVarHw;
        uc ucVarHw2;
        x xVar = this.uc;
        if (xVar != null && (ucVarHw2 = xVar.hw()) != null) {
            ucVarHw2.pr(this.pr, this);
        }
        x xVar2 = this.fw;
        if (xVar2 != null && (ucVarHw = xVar2.hw()) != null) {
            ucVarHw.pr(this.pr, this);
        }
    }

    private void w() {
        uc ucVarHw;
        uc ucVarHw2;
        x xVar = this.uc;
        if (xVar != null && (ucVarHw2 = xVar.hw()) != null) {
            ucVarHw2.pr(this.hw, this);
        }
        x xVar2 = this.fw;
        if (xVar2 != null && (ucVarHw = xVar2.hw()) != null) {
            ucVarHw.pr(this.hw, this);
        }
    }

    public com.byazt.re.pr zo() {
        return this.hn;
    }
}
