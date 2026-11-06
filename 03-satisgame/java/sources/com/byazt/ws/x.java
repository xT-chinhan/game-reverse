package com.byazt.ws;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 21})
public class x {
    public double cp;
    public JSONObject fs;
    public n l;
    public String n;
    public fs q;
    public String qg;
    public double rv;
    public String s;
    public int tj;
    public List<w> w;
    public List<fs> x;

    public double n() {
        return this.rv;
    }

    public void n(String str) {
        try {
            this.rv = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public int qg() {
        return this.tj;
    }

    public void n(int i) {
        this.tj = i;
    }

    public double s() {
        return this.cp;
    }

    public void qg(String str) {
        try {
            this.cp = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public List<fs> q() {
        return this.x;
    }

    public void n(List<fs> list) {
        this.x = list;
    }

    public List<w> l() {
        return this.w;
    }

    public void qg(List<w> list) {
        this.w = list;
    }

    public void s(String str) {
        this.n = str;
    }

    public void q(String str) {
        this.qg = str;
    }

    public String w() {
        return this.s;
    }

    public void l(String str) {
        this.s = str;
    }

    public void n(fs fsVar) {
        this.q = fsVar;
    }

    public void n(n nVar) {
        this.l = nVar;
    }

    public void n(JSONObject jSONObject) {
        this.fs = jSONObject;
    }

    public JSONObject x() {
        return this.fs;
    }

    public boolean fs() {
        n nVar = this.l;
        return (nVar == null || TextUtils.isEmpty(nVar.n)) ? false : true;
    }

    public List<tj> rv() {
        n nVar = this.l;
        if (nVar == null) {
            return null;
        }
        return nVar.qg;
    }

    @com.byazt.cp.n(n = {0, 1, 890, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static class n {
        public String n;
        public List<tj> qg = new ArrayList();

        public void n(String str) {
            this.n = str;
        }

        public void n(List<tj> list) {
            this.qg = list;
        }
    }
}
