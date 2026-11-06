package com.byazt.zr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.af.w;
import com.byazt.hg.cz;
import com.byazt.hg.of;
import com.byazt.hg.yb;
import com.byazt.wt.ls;
import com.byazt.wt.v;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 37})
public abstract class pr implements x {
    public JSONObject hn;
    public volatile String hw;
    public volatile Function<SparseArray<Object>, Object> pr = null;

    public abstract boolean w_();

    @Override // com.byazt.zr.x
    public void pr(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.pr = function;
    }

    public boolean pr(w wVar) {
        if (wVar == null) {
            return false;
        }
        return pr(wVar.vk(), wVar.c());
    }

    @Override // com.byazt.zr.x
    public boolean pr(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.byazt.zr.x
    public void pr() {
    }

    public long pr(of ofVar) {
        if (ofVar == null) {
            return 0L;
        }
        String strVk = ofVar.vk();
        if (TextUtils.isEmpty(strVk)) {
            strVk = pr(ofVar.g());
        }
        try {
            return Long.parseLong(strVk);
        } catch (Exception e) {
            return 0L;
        }
    }

    public String pr(yb ybVar) {
        Map<String, String> mapPr;
        if (ybVar != null) {
            String strHw = ybVar.hw();
            if (!TextUtils.isEmpty(strHw)) {
                if ((strHw.startsWith("snssdk2329") || strHw.startsWith("snssdk1128")) && (mapPr = v.pr(strHw)) != null) {
                    return mapPr.get("room_id");
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public String pr(w wVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strC = cz.c(wVar.m(), str2);
            if (TextUtils.isEmpty(strC)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strC);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            com.byazt.xk.hw.pr().pr("getEcomLiveParams", e);
            return str;
        }
    }

    @Override // com.byazt.zr.x
    public void pr(String str, of ofVar, long j) {
    }

    public void a_(String str) {
    }

    public void pr(of ofVar, String str, int i, int i2, int i3) {
        com.byazt.pj.pr.pr(ofVar, str, i, i2, i3, w_());
    }

    public boolean pr(w wVar, int i) {
        return wVar.c() == 7 || i == 103;
    }

    public int hw(w wVar) {
        yb ybVarG;
        if (1 != com.byazt.eg.hw.pr().c()) {
            return 2;
        }
        if (!com.byazt.dz.pr.pr(wVar)) {
            return 3;
        }
        if (ls.b() && (ybVarG = wVar.g()) != null) {
            String strHw = ybVarG.hw();
            if (!TextUtils.isEmpty(strHw)) {
                Uri uri = Uri.parse(strHw);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return ls.hw(intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.byazt.zr.x
    public void hn(w wVar) {
    }

    @Override // com.byazt.zr.x
    public int pr(Context context, long j) {
        if (context == null || j <= 0) {
            return 5;
        }
        if (this.pr == null) {
            return 4;
        }
        if (!uc()) {
            return 1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("room_id", j);
            HashMap map = new HashMap();
            map.put(d.R, context);
            map.put("bundle", bundle);
            Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(0).pr(Integer.class).pr(0, map).hw());
            if (!(objApply instanceof Integer)) {
                return 2;
            }
            return ((Integer) objApply).intValue();
        } catch (Throwable th) {
            return 2;
        }
    }

    @Override // com.byazt.zr.x
    public long hn() {
        return -1L;
    }
}
