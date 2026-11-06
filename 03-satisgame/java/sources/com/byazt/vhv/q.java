package com.byazt.vhv;

import com.byazt.af.x;
import com.byazt.ehw.DeviceUtils;
import com.byazt.rr.rv;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 5})
public class q extends com.byazt.qg.s<qg> {
    public volatile int qg = 0;

    @Override // com.byazt.qg.s
    public String n() {
        return "ad_user_interact_pack";
    }

    @Override // com.byazt.qg.s
    public String qg() {
        return "ad_user_interact";
    }

    public static q x() {
        return (q) n(q.class);
    }

    @Override // com.byazt.qg.s
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public qg n(JSONObject jSONObject, rv rvVar) {
        return new qg(jSONObject);
    }

    public synchronized int fs() {
        if (this.qg >= 3) {
            return this.qg;
        }
        if (com.byazt.wl.l.tj("com.byted.csj.ext")) {
            this.qg = 1;
            if (com.byazt.wl.l.rv("com.byted.csj.ext")) {
                this.qg = 2;
            }
        }
        return this.qg;
    }

    private boolean cp() {
        return (this.qg == 7 || this.qg == 4) ? false : true;
    }

    public synchronized void rv() {
        if (cp()) {
            this.qg = 8;
        }
    }

    public synchronized void s(boolean z) {
        if (cp()) {
            if (z) {
                this.qg = 9;
                return;
            }
            this.qg = 10;
        }
    }

    @Override // com.byazt.qg.s
    public synchronized void w() {
        if (this.qg == 4) {
            return;
        }
        this.qg = 5;
    }

    @Override // com.byazt.qg.s
    public synchronized void n(boolean z) {
        super.n(z);
        if (z) {
            this.qg = 7;
            return;
        }
        if (this.qg < 4 || this.qg == 5) {
            this.qg = 6;
        }
    }

    @Override // com.byazt.qg.s
    public synchronized void qg(boolean z) {
        try {
            if (z) {
                if (this.qg < 4 || this.qg == 6) {
                    this.qg = 4;
                }
            } else if (this.qg < 4) {
                this.qg = 3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void tj() {
        this.qg = 11;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n implements com.byazt.qg.n {
        public final C0371n n;

        private n(C0371n c0371n) {
            this.n = c0371n;
        }

        @Override // com.byazt.qg.n
        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("screen_light", this.n.n);
                jSONObject.put("close_pos", this.n.qg);
                jSONObject.put("x_rotation", this.n.s);
                jSONObject.put("y_rotation", this.n.q);
                jSONObject.put("z_rotation", this.n.l);
                jSONObject.put("slot_type", this.n.w);
                jSONObject.put("union_key", this.n.x);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("battery_ratio", DeviceUtils.n.qg(com.byazt.nf.rv.getContext()));
            } catch (Exception e) {
                k.qg("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }

        /* JADX INFO: renamed from: com.byazt.vhv.q$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP})
        public static class C0371n {
            public String l;
            public double n;
            public String q;
            public String qg;
            public String s;
            public int w;
            public String x;

            public C0371n n(double d) {
                this.n = d;
                return this;
            }

            public C0371n n(String str) {
                this.qg = str;
                return this;
            }

            public C0371n qg(String str) {
                this.s = str;
                return this;
            }

            public C0371n s(String str) {
                this.q = str;
                return this;
            }

            public C0371n q(String str) {
                this.l = str;
                return this;
            }

            public C0371n n(int i) {
                this.w = i;
                return this;
            }

            public C0371n l(String str) {
                this.x = str;
                return this;
            }

            public n n() {
                return new n(this);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 524})
    public static class qg {
        public String n;
        public JSONObject q;
        public int qg;
        public double s;

        public qg(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.n = jSONObject.optString("noise_module", "");
                this.qg = jSONObject.optInt("is_close", 0);
                this.s = jSONObject.optDouble("close_desire", 0.0d);
                this.q = jSONObject;
            } catch (Exception unused) {
            }
        }

        public int n() {
            return this.qg;
        }

        public boolean qg() {
            return this.qg == 1;
        }

        public double s() {
            return this.s;
        }

        public JSONObject q() {
            return this.q;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 1366})
    public static class s extends com.byazt.qg.q {
        public final long l;
        public final double n;
        public final String q;
        public final double qg;
        public final double s;

        @Override // com.byazt.qg.q
        public String n() {
            return "sensor_euler_angles";
        }

        private s(n nVar) {
            this.n = nVar.n;
            this.qg = nVar.qg;
            this.s = nVar.s;
            this.q = nVar.q;
            this.l = nVar.l;
        }

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME})
        public static class n {
            public long l;
            public double n;
            public String q;
            public double qg;
            public double s;

            public n n(double d) {
                this.n = d;
                return this;
            }

            public n qg(double d) {
                this.qg = d;
                return this;
            }

            public n s(double d) {
                this.s = d;
                return this;
            }

            public n n(String str) {
                this.q = str;
                return this;
            }

            public n n(long j) {
                this.l = j;
                return this;
            }

            public void n() {
                s.n(new s(this));
            }
        }

        @Override // com.byazt.qg.q
        public JSONObject qg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("yaw", this.n);
                jSONObject.put("pitch", this.qg);
                jSONObject.put("roll", this.s);
                jSONObject.put("union_key", this.q);
                jSONObject.put("ts", this.l);
            } catch (Exception e) {
                k.qg("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 1348})
    public static class l extends com.byazt.qg.q {
        public final long l;
        public final double n;
        public final String q;
        public final double qg;
        public final double s;

        @Override // com.byazt.qg.q
        public String n() {
            return "sensor_linear_acceleration";
        }

        private l(n nVar) {
            this.n = nVar.n;
            this.qg = nVar.qg;
            this.s = nVar.s;
            this.q = nVar.q;
            this.l = nVar.l;
        }

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 1803})
        public static class n {
            public long l;
            public double n;
            public String q;
            public double qg;
            public double s;

            public n n(double d) {
                this.n = d;
                return this;
            }

            public n qg(double d) {
                this.qg = d;
                return this;
            }

            public n s(double d) {
                this.s = d;
                return this;
            }

            public n n(String str) {
                this.q = str;
                return this;
            }

            public n n(long j) {
                this.l = j;
                return this;
            }

            public void n() {
                l.n(new l(this));
            }
        }

        @Override // com.byazt.qg.q
        public JSONObject qg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(x.n, this.n);
                jSONObject.put("y", this.qg);
                jSONObject.put("z", this.s);
                jSONObject.put("union_key", this.q);
                jSONObject.put("ts", this.l);
            } catch (Exception e) {
                k.qg("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: com.byazt.vhv.q$q, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 1365})
    public static class C0372q extends com.byazt.qg.q {
        public final long l;
        public final double n;
        public final String q;
        public final double qg;
        public final double s;

        @Override // com.byazt.qg.q
        public String n() {
            return "sensor_gyroscope";
        }

        private C0372q(n nVar) {
            this.n = nVar.n;
            this.qg = nVar.qg;
            this.s = nVar.s;
            this.q = nVar.q;
            this.l = nVar.l;
        }

        /* JADX INFO: renamed from: com.byazt.vhv.q$q$n */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME, 2419})
        public static class n {
            public long l;
            public double n;
            public String q;
            public double qg;
            public double s;

            public n n(double d) {
                this.n = d;
                return this;
            }

            public n qg(double d) {
                this.qg = d;
                return this;
            }

            public n s(double d) {
                this.s = d;
                return this;
            }

            public n n(String str) {
                this.q = str;
                return this;
            }

            public n n(long j) {
                this.l = j;
                return this;
            }

            public void n() {
                C0372q.n(new C0372q(this));
            }
        }

        @Override // com.byazt.qg.q
        public JSONObject qg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(x.n, this.n);
                jSONObject.put("y", this.qg);
                jSONObject.put("z", this.s);
                jSONObject.put("union_key", this.q);
                jSONObject.put("ts", this.l);
            } catch (Exception e) {
                k.qg("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }
}
