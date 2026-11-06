package com.byazt.n;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ihe.m;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements hw {
    public static final AtomicInteger ny = new AtomicInteger();
    public String a;
    public StringBuilder aj;
    public JSONObject b;
    public String c;
    public int cz;
    public int fo;
    public int fw;
    public long g;
    public String hn;
    public long ho;
    public JSONArray hw;
    public double k;
    public int lb;
    public long m;
    public int nt;
    public StringBuilder pr;
    public boolean qa;
    public String rc;
    public String uc;
    public String vk;
    public double w;
    public String x;
    public int yb;
    public int z;
    public String zo;

    private c() {
        this.pr = new StringBuilder();
        this.hw = new JSONArray();
        this.lb = -8888;
        this.qa = false;
        this.cz = -8888;
        this.fo = 0;
        this.z = -1;
        this.fo = ny.addAndGet(1);
    }

    private c(pr prVar) {
        this.pr = new StringBuilder();
        this.hw = new JSONArray();
        this.lb = -8888;
        this.qa = false;
        this.cz = -8888;
        this.fo = 0;
        this.z = -1;
        this.hn = prVar.hw;
        this.x = prVar.hn;
        this.c = prVar.x;
        this.uc = prVar.c;
        this.fw = prVar.uc;
        this.nt = prVar.aj;
        this.z = prVar.vk;
        this.ho = prVar.fw;
        this.yb = prVar.zo;
        this.w = prVar.w;
        this.rc = prVar.pr;
        this.b = prVar.m;
        String str = prVar.k;
        this.aj = new StringBuilder(TextUtils.isEmpty(str) ? "" : str);
        this.fo = ny.addAndGet(1);
    }

    @Override // com.byazt.n.hw
    public void hw(String str) {
        int iIndexOf = this.aj.indexOf(str);
        if (TextUtils.isEmpty(this.aj)) {
            this.aj.append(str);
        } else if (iIndexOf == -1) {
            this.aj.append(",").append(str);
        }
    }

    @Override // com.byazt.n.hw
    public void pr(int i, int i2, String str) {
        this.lb = i;
        this.cz = i2;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject hw() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("session_id", this.aj.toString());
            jSONObject.put("node_line", this.pr.toString());
            jSONObject.put("node_line_detail", this.hw.toString());
            jSONObject.put("video_url", this.vk);
            jSONObject.put(Constants.VIDEO_DURATION_FIELD, this.w);
            jSONObject.put("video_size", this.k);
            jSONObject.put("start_duration", this.g - this.m);
            jSONObject.put("play_duration", SystemClock.elapsedRealtime() - this.m);
            jSONObject.put("play_cache_size", this.ho);
            jSONObject.put("play_type", this.nt);
            jSONObject.put("player_type", this.yb);
            jSONObject.put("video_index", this.fo);
            jSONObject.put("is_audio", this.qa ? 1 : 0);
            jSONObject.put("dynamic_join_type", this.z);
            int i = this.lb;
            if (i != -8888) {
                jSONObject.put(Constants.ERROR_CODE_FIELD, i);
            }
            jSONObject.put(Constants.ERROR_MSG_FIELD, this.a);
            int i2 = this.cz;
            if (i2 != -8888) {
                jSONObject.put("extra_error_code", i2);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @Override // com.byazt.n.hw
    public void pr(String str) {
        this.pr.append(str);
        String strHn = hn(str);
        JSONObject jSONObject = new JSONObject();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.equals("0505", str)) {
            this.m = jElapsedRealtime;
        } else if (TextUtils.equals("0506", str)) {
            this.g = jElapsedRealtime;
        }
        try {
            jSONObject.putOpt("type", strHn);
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
        }
        this.hw.put(jSONObject);
    }

    @Override // com.byazt.n.hw
    public void pr(long j, m mVar) {
        com.byazt.fu.hn hnVar = (com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null));
        if (hnVar != null && mVar != null) {
            this.k = mVar.nt();
            this.qa = mVar.zo();
            this.zo = String.valueOf(j);
            this.vk = mVar.ny();
            hnVar.pr(this.rc, (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.n.c.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, c.this.uc);
                    jSONObject.put("rit", c.this.c);
                    jSONObject.put("cid", c.this.x);
                    jSONObject.put("adtype", c.this.fw);
                    jSONObject.put("req_id", c.this.hn);
                    jSONObject.put("duration", c.this.zo);
                    return c.this.hw();
                }
            });
        }
    }

    @Override // com.byazt.n.hw
    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", this.c);
            jSONObject.put("cid", this.x);
            jSONObject.put("adtype", this.fw);
            jSONObject.put("req_id", this.hn);
            jSONObject.put("duration", this.zo);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        switch (str) {
            case "0501":
                return "created";
            case "0502":
                return "bindview";
            case "0503":
                return "initialized";
            case "0504":
                return "prepared";
            case "0505":
                return "started";
            case "0506":
                return "played";
            case "0507":
                return "paused";
            case "0508":
                return "stopped";
            case "0509":
                return "completed";
            case "0510":
                return "error";
            default:
                return "unknown";
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 169})
    public static class pr {
        public int aj;
        public String c;
        public long fw;
        public String hn;
        public String hw;
        public JSONObject m;
        public String pr;
        public int uc;
        public double w;
        public String x;
        public int zo;
        public int vk = -1;
        public String k = "";

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr pr(double d) {
            this.w = d;
            return this;
        }

        public pr hw(String str) {
            this.hn = str;
            return this;
        }

        public pr hn(String str) {
            this.hw = str;
            return this;
        }

        public pr x(String str) {
            this.x = str;
            return this;
        }

        public pr pr(int i) {
            this.uc = i;
            return this;
        }

        public pr pr(long j) {
            this.fw = j;
            return this;
        }

        public pr hw(int i) {
            this.zo = i;
            return this;
        }

        public pr hn(int i) {
            this.aj = i;
            return this;
        }

        public pr x(int i) {
            this.vk = i;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            this.m = jSONObject;
            return this;
        }

        public pr c(String str) {
            this.c = str;
            return this;
        }

        public c pr() {
            return new c(this);
        }
    }
}
