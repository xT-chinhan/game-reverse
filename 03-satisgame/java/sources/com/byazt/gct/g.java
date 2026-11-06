package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1306})
public class g extends oa {
    public Map<String, g> cd;
    public int cp;
    public int cy;
    public int d;
    public int fs;
    public int hd;
    public int k;
    public String l;
    public int oa;
    public String q;
    public int qg;
    public int rv;
    public int s;
    public double sz;
    public int tj;
    public String w;
    public int x;

    public g(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        this.qg = jSONObject.optInt("render_sequence");
        this.s = jSONObject.optInt("displayAreaAndroid");
        this.q = jSONObject.optString("ugen_md5");
        this.l = jSONObject.optString("ugen_id");
        this.w = jSONObject.optString("ugen_url");
        this.cp = jSONObject.optInt("if_stay_top", 0);
        this.x = jSONObject.optInt("need_backup_convert_area", 0);
        this.fs = jSONObject.optInt("min_height", 0);
        this.rv = jSONObject.optInt("min_width", 0);
        this.tj = jSONObject.optInt("min_ratio", 0);
        this.k = jSONObject.optInt("mode");
        this.cy = jSONObject.optInt("render_control", 0);
        this.hd = jSONObject.optInt("creative_type", 0);
        this.d = com.byazt.rg.q.n(jSONObject.optString("preferred_size_width"));
        this.oa = com.byazt.rg.q.n(jSONObject.optString("preferred_size_height"));
        this.sz = com.byazt.rg.q.qg(jSONObject.optString("preferred_aspect_ratio"));
        this.n = i;
        n(jSONObject.optJSONObject("config"));
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.cd = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                this.cd.put(next, new g(jSONObjectOptJSONObject, 5));
            }
        }
    }

    @Override // com.byazt.gct.oa
    public int s() {
        return this.qg;
    }

    @Override // com.byazt.gct.oa
    public int q() {
        return this.s;
    }

    public int rv() {
        return this.cp;
    }

    public int tj() {
        return this.k;
    }

    public int cp() {
        return this.cy;
    }

    public String d() {
        return this.q;
    }

    @Override // com.byazt.gct.oa
    public String l() {
        return this.l;
    }

    public String oa() {
        return this.w;
    }

    public boolean sz() {
        return this.x == 1;
    }

    @Override // com.byazt.gct.oa
    public int w() {
        return this.d;
    }

    @Override // com.byazt.gct.oa
    public int x() {
        return this.oa;
    }

    @Override // com.byazt.gct.oa
    public double fs() {
        return this.sz;
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.w);
    }

    public boolean n(int i, int i2) {
        int iQ = com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), i);
        int iQ2 = com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), i2);
        int i3 = this.rv;
        if (i3 != 0 && iQ < i3) {
            return false;
        }
        int i4 = this.fs;
        if (i4 == 0 || iQ2 >= i4) {
            return iQ == 0 || iQ2 == 0 || ((float) iQ2) / ((float) iQ) >= ((float) this.tj);
        }
        return false;
    }
}
