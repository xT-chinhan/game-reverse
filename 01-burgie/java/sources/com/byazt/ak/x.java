package com.byazt.ak;

import android.support.v4.view.PointerIconCompat;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.byazt.wt.DeviceUtils;
import com.byazt.zp.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 121})
public class x extends com.byazt.ep.hn<hw> {
    public volatile int hw = 0;

    public static x fw() {
        return (x) pr(x.class);
    }

    @Override // com.byazt.ep.hn
    public String pr() {
        return "ad_user_interact_pack";
    }

    @Override // com.byazt.ep.hn
    public String hw() {
        return "ad_user_interact";
    }

    @Override // com.byazt.ep.hn
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public hw pr(JSONObject jSONObject) {
        return new hw(jSONObject);
    }

    public synchronized int zo() {
        if (this.hw >= 3) {
            return this.hw;
        }
        if (m.aj("com.byted.csj.ext")) {
            this.hw = 1;
            if (m.zo("com.byted.csj.ext")) {
                this.hw = 2;
                aj.pr().post(new Runnable() { // from class: com.byazt.ak.x.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.ba.x.pr();
                    }
                });
            }
        }
        return this.hw;
    }

    private boolean w() {
        return (this.hw == 7 || this.hw == 4) ? false : true;
    }

    public synchronized void aj() {
        if (w()) {
            this.hw = 8;
        }
    }

    public synchronized void hn(boolean z) {
        if (w()) {
            if (z) {
                this.hw = 9;
                return;
            }
            this.hw = 10;
        }
    }

    @Override // com.byazt.ep.hn
    public synchronized void uc() {
        if (this.hw == 4) {
            return;
        }
        this.hw = 5;
    }

    @Override // com.byazt.ep.hn
    public synchronized void pr(boolean z) {
        super.pr(z);
        if (z) {
            this.hw = 7;
            return;
        }
        if (this.hw < 4 || this.hw == 5) {
            this.hw = 6;
        }
    }

    @Override // com.byazt.ep.hn
    public synchronized void hw(boolean z) {
        try {
            if (z) {
                if (this.hw < 4 || this.hw == 6) {
                    this.hw = 4;
                }
            } else if (this.hw < 4) {
                this.hw = 3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void vk() {
        this.hw = 11;
    }

    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr implements com.byazt.ep.pr {
        public final C0014pr pr;

        private pr(C0014pr c0014pr) {
            this.pr = c0014pr;
        }

        @Override // com.byazt.ep.pr
        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("screen_light", this.pr.pr);
                jSONObject.put("close_pos", this.pr.hw);
                jSONObject.put("x_rotation", this.pr.hn);
                jSONObject.put("y_rotation", this.pr.x);
                jSONObject.put("z_rotation", this.pr.c);
                jSONObject.put("slot_type", this.pr.uc);
                jSONObject.put("union_key", this.pr.fw);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("battery_ratio", DeviceUtils.pr.hw(a.getContext()));
            } catch (Exception e) {
                ho.hw("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }

        /* JADX INFO: renamed from: com.byazt.ak.x$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1355})
        public static class C0014pr {
            public String c;
            public String fw;
            public String hn;
            public String hw;
            public double pr;
            public int uc;
            public String x;

            public C0014pr pr(double d) {
                this.pr = d;
                return this;
            }

            public C0014pr pr(String str) {
                this.hw = str;
                return this;
            }

            public C0014pr hw(String str) {
                this.hn = str;
                return this;
            }

            public C0014pr hn(String str) {
                this.x = str;
                return this;
            }

            public C0014pr x(String str) {
                this.c = str;
                return this;
            }

            public C0014pr pr(int i) {
                this.uc = i;
                return this;
            }

            public C0014pr c(String str) {
                this.fw = str;
                return this;
            }

            public pr pr() {
                return new pr(this);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 759})
    public static class hw {
        public double hn;
        public int hw;
        public String pr;
        public JSONObject x;

        public hw(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.pr = jSONObject.optString("noise_module", "");
                this.hw = jSONObject.optInt("is_close", 0);
                this.hn = jSONObject.optDouble("close_desire", 0.0d);
                this.x = jSONObject;
            } catch (Exception e) {
            }
        }

        public int pr() {
            return this.hw;
        }

        public boolean hw() {
            return this.hw == 1;
        }

        public double hn() {
            return this.hn;
        }

        public JSONObject x() {
            return this.x;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW})
    public static class hn extends com.byazt.ep.x {
        public final long c;
        public final double hn;
        public final double hw;
        public final double pr;
        public final String x;

        private hn(pr prVar) {
            this.pr = prVar.pr;
            this.hw = prVar.hw;
            this.hn = prVar.hn;
            this.x = prVar.x;
            this.c = prVar.c;
        }

        @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1282})
        public static class pr {
            public long c;
            public double hn;
            public double hw;
            public double pr;
            public String x;

            public pr pr(double d) {
                this.pr = d;
                return this;
            }

            public pr hw(double d) {
                this.hw = d;
                return this;
            }

            public pr hn(double d) {
                this.hn = d;
                return this;
            }

            public pr pr(String str) {
                this.x = str;
                return this;
            }

            public pr pr(long j) {
                this.c = j;
                return this;
            }

            public void pr() {
                hn.pr(new hn(this));
            }
        }

        @Override // com.byazt.ep.x
        public String pr() {
            return "sensor_euler_angles";
        }

        @Override // com.byazt.ep.x
        public JSONObject hw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("yaw", this.pr);
                jSONObject.put("pitch", this.hw);
                jSONObject.put("roll", this.hn);
                jSONObject.put("union_key", this.x);
                jSONObject.put("ts", this.c);
            } catch (Exception e) {
                ho.hw("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1605})
    public static class c extends com.byazt.ep.x {
        public final long c;
        public final double hn;
        public final double hw;
        public final double pr;
        public final String x;

        private c(pr prVar) {
            this.pr = prVar.pr;
            this.hw = prVar.hw;
            this.hn = prVar.hn;
            this.x = prVar.x;
            this.c = prVar.c;
        }

        @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1677})
        public static class pr {
            public long c;
            public double hn;
            public double hw;
            public double pr;
            public String x;

            public pr pr(double d) {
                this.pr = d;
                return this;
            }

            public pr hw(double d) {
                this.hw = d;
                return this;
            }

            public pr hn(double d) {
                this.hn = d;
                return this;
            }

            public pr pr(String str) {
                this.x = str;
                return this;
            }

            public pr pr(long j) {
                this.c = j;
                return this;
            }

            public void pr() {
                c.pr(new c(this));
            }
        }

        @Override // com.byazt.ep.x
        public String pr() {
            return "sensor_linear_acceleration";
        }

        @Override // com.byazt.ep.x
        public JSONObject hw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", this.pr);
                jSONObject.put("y", this.hw);
                jSONObject.put(an.aD, this.hn);
                jSONObject.put("union_key", this.x);
                jSONObject.put("ts", this.c);
            } catch (Exception e) {
                ho.hw("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ak.x$x, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1593})
    public static class C0015x extends com.byazt.ep.x {
        public final long c;
        public final double hn;
        public final double hw;
        public final double pr;
        public final String x;

        private C0015x(pr prVar) {
            this.pr = prVar.pr;
            this.hw = prVar.hw;
            this.hn = prVar.hn;
            this.x = prVar.x;
            this.c = prVar.c;
        }

        /* JADX INFO: renamed from: com.byazt.ak.x$x$pr */
        @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 1376})
        public static class pr {
            public long c;
            public double hn;
            public double hw;
            public double pr;
            public String x;

            public pr pr(double d) {
                this.pr = d;
                return this;
            }

            public pr hw(double d) {
                this.hw = d;
                return this;
            }

            public pr hn(double d) {
                this.hn = d;
                return this;
            }

            public pr pr(String str) {
                this.x = str;
                return this;
            }

            public pr pr(long j) {
                this.c = j;
                return this;
            }

            public void pr() {
                C0015x.pr(new C0015x(this));
            }
        }

        @Override // com.byazt.ep.x
        public String pr() {
            return "sensor_gyroscope";
        }

        @Override // com.byazt.ep.x
        public JSONObject hw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", this.pr);
                jSONObject.put("y", this.hw);
                jSONObject.put(an.aD, this.hn);
                jSONObject.put("union_key", this.x);
                jSONObject.put("ts", this.c);
            } catch (Exception e) {
                ho.hw("PitayaAdUserInteractBusiness", e.getMessage());
            }
            return jSONObject;
        }
    }
}
