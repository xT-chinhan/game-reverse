package com.byazt.et;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.xz.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 26})
public abstract class qg {
    public String fs;
    public Map<String, Object> l;
    public d n;
    public com.byazt.xz.x.n q;
    public com.byazt.ih.s qg;
    public String rv;
    public com.byazt.xz.x s;
    public Context tj;
    public String w;
    public String x;

    public abstract boolean n(Object... objArr);

    public qg(Context context) {
        this.tj = context;
    }

    public void w() {
        this.q = this.s.n();
        com.byazt.xz.x xVar = this.s;
        if (xVar == null) {
            return;
        }
        com.byazt.xz.x.n nVarN = xVar.n();
        this.q = nVarN;
        if (nVarN == null) {
            return;
        }
        this.l = nVarN.s();
        this.w = this.q.qg();
        this.x = this.q.n();
        this.fs = this.q.l();
        this.rv = this.q.w();
    }

    public String x() {
        return this.w;
    }

    public Map<String, Object> fs() {
        return this.l;
    }

    public String rv() {
        return this.fs;
    }

    public String tj() {
        return this.rv;
    }

    public void n(com.byazt.ih.s sVar) {
        this.qg = sVar;
    }

    public void n(com.byazt.xz.x xVar) {
        this.s = xVar;
    }

    public com.byazt.xz.x cp() {
        return this.s;
    }

    public void n(d dVar) {
        this.n = dVar;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 48})
    public static class n {
        public static qg n(Context context, com.byazt.ih.s sVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.byazt.xz.x xVarN;
            com.byazt.xz.x.n nVarN;
            com.byazt.xz.fs fsVarN;
            if (sVar == null || jSONObject == null || (xVarN = com.byazt.xz.x.n(jSONObject, jSONObject2)) == null || (nVarN = xVarN.n()) == null) {
                return null;
            }
            String strN = nVarN.n();
            if (TextUtils.equals(strN, "custom")) {
                s sVar2 = new s(context);
                sVar2.n(sVar);
                sVar2.n(xVarN);
                sVar2.w();
                return sVar2;
            }
            if (TextUtils.isEmpty(strN) || TextUtils.equals(strN, "global")) {
                fsVarN = com.byazt.xz.cp.n(nVarN.qg());
            } else {
                fsVarN = com.byazt.xz.cp.n(nVarN.w());
            }
            if (fsVarN == null) {
                q qVar = new q(context);
                qVar.n(sVar);
                qVar.n(xVarN);
                qVar.w();
                return qVar;
            }
            qg qgVarN = fsVarN.n(context);
            qgVarN.n(sVar);
            qgVarN.n(xVarN);
            qgVarN.w();
            return qgVarN;
        }
    }
}
