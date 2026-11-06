package com.byazt.gct;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public final String a;
    public int bb;
    public final String cd;
    public final int cp;
    public final float cy;
    public final int d;
    public final float fs;
    public int h;
    public final int hd;
    public String hu;
    public final int k;
    public final float l;
    public final boolean lh;
    public final int ln;
    public int m;
    public final int[] n;
    public final int oa;
    public SparseArray<com.byazt.ys.l.n> ou;
    public final String py;
    public final int[] q;
    public final int[] qg;
    public final long rv;
    public final int[] s;
    public final float sz;
    public byte t;
    public final long tj;
    public final String um;
    public byte ur;
    public final float w;
    public int wm;
    public final float x;

    private rv(n nVar) {
        this.m = -1;
        this.h = -1;
        this.ur = (byte) -1;
        this.bb = Integer.MIN_VALUE;
        this.n = nVar.cp;
        this.qg = nVar.d;
        this.q = nVar.oa;
        this.s = nVar.tj;
        this.l = nVar.rv;
        this.w = nVar.fs;
        this.x = nVar.x;
        this.fs = nVar.w;
        this.rv = nVar.l;
        this.tj = nVar.q;
        this.cp = nVar.sz;
        this.d = nVar.k;
        this.oa = nVar.cy;
        this.sz = nVar.n;
        this.cd = nVar.um;
        this.um = nVar.a;
        this.py = nVar.ou;
        this.a = nVar.py;
        this.k = nVar.qg;
        this.cy = nVar.s;
        this.hd = nVar.cd;
        this.ou = nVar.hd;
        this.wm = nVar.wm;
        this.m = nVar.m;
        this.hu = nVar.hu;
        this.h = nVar.h;
        this.lh = nVar.t;
        this.t = nVar.ur;
        this.ur = nVar.bb;
        this.bb = nVar.ln;
        this.ln = nVar.lh;
    }

    @JProtect
    public JSONObject n(pk pkVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.n;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.n[1]));
            }
            int[] iArr2 = this.qg;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.qg[1]));
            }
            int[] iArr3 = this.s;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.s[1]));
            }
            int[] iArr4 = this.q;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.q[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.ou != null) {
                for (int i = 0; i < this.ou.size(); i++) {
                    com.byazt.ys.l.n nVarValueAt = this.ou.valueAt(i);
                    if (nVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(nVarValueAt.s)).putOpt("mr", Double.valueOf(nVarValueAt.qg)).putOpt("phase", Integer.valueOf(nVarValueAt.n)).putOpt("ts", Long.valueOf(nVarValueAt.q));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.hd)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.l)).putOpt("down_y", Float.toString(this.w)).putOpt("up_x", Float.toString(this.x)).putOpt("up_y", Float.toString(this.fs)).putOpt("down_time", Long.valueOf(this.rv)).putOpt("up_time", Long.valueOf(this.tj)).putOpt("toolType", Integer.valueOf(this.cp)).putOpt("deviceId", Integer.valueOf(this.d)).putOpt("source", Integer.valueOf(this.oa)).putOpt("density", Float.valueOf(this.sz)).putOpt("densityDpi", Integer.valueOf(this.k)).putOpt("scaleDensity", Float.valueOf(this.cy)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.cd).putOpt("areaType", this.um).putOpt("rectInfo", this.py).putOpt("click_area_id", this.a);
            int i2 = this.wm;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.m;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.h;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.hu);
            }
            if (this.lh) {
                jSONObject.put("referer", "directDownload");
            }
            jSONObject.putOpt("convert_type", Byte.valueOf(this.t));
            jSONObject.putOpt("click_creative_type", Integer.valueOf(this.ln));
            byte b = this.ur;
            if (b != -1) {
                jSONObject.putOpt("biz_type", Byte.valueOf(b));
            }
            int i5 = this.bb;
            if (i5 != Integer.MIN_VALUE) {
                jSONObject.putOpt("fail_status", Integer.valueOf(i5));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 160})
    public static class n {
        public String a;
        public int cd;
        public int[] cp;
        public int[] d;
        public SparseArray<com.byazt.ys.l.n> hd;
        public String hu;
        public float n;
        public int[] oa;
        public String ou;
        public String py;
        public int qg;
        public float s;
        public int[] tj;
        public String um;
        public long q = -1;
        public long l = -1;
        public float w = -1.0f;
        public float x = -1.0f;
        public float fs = -1.0f;
        public float rv = -1.0f;
        public int sz = -1;
        public int k = -1;
        public int cy = -1024;
        public int wm = -1;
        public int m = -1;
        public int h = -1;
        public boolean t = false;
        public byte ur = 0;
        public byte bb = -1;
        public int ln = Integer.MIN_VALUE;
        public int lh = -1;

        public n n(int i) {
            this.ln = i;
            return this;
        }

        public n n(byte b) {
            this.bb = b;
            return this;
        }

        public n qg(byte b) {
            this.ur = b;
            return this;
        }

        public n n(float f) {
            this.n = f;
            return this;
        }

        public n qg(int i) {
            this.qg = i;
            return this;
        }

        public n qg(float f) {
            this.s = f;
            return this;
        }

        public n s(int i) {
            this.cd = i;
            return this;
        }

        public n n(SparseArray<com.byazt.ys.l.n> sparseArray) {
            this.hd = sparseArray;
            return this;
        }

        public n n(long j) {
            this.q = j;
            return this;
        }

        public n qg(long j) {
            this.l = j;
            return this;
        }

        public n s(float f) {
            this.w = f;
            return this;
        }

        public n q(float f) {
            this.x = f;
            return this;
        }

        public n l(float f) {
            this.fs = f;
            return this;
        }

        public n w(float f) {
            this.rv = f;
            return this;
        }

        public n n(int[] iArr) {
            this.tj = iArr;
            return this;
        }

        public n qg(int[] iArr) {
            this.cp = iArr;
            return this;
        }

        public n s(int[] iArr) {
            this.d = iArr;
            return this;
        }

        public n q(int[] iArr) {
            this.oa = iArr;
            return this;
        }

        public n q(int i) {
            this.sz = i;
            return this;
        }

        public n l(int i) {
            this.k = i;
            return this;
        }

        public n w(int i) {
            this.cy = i;
            return this;
        }

        public n n(String str) {
            this.um = str;
            return this;
        }

        public n qg(String str) {
            this.a = str;
            return this;
        }

        public n s(String str) {
            this.py = str;
            return this;
        }

        public n q(String str) {
            this.ou = str;
            return this;
        }

        public n x(int i) {
            this.wm = i;
            return this;
        }

        public n fs(int i) {
            this.m = i;
            return this;
        }

        public n l(String str) {
            this.hu = str;
            return this;
        }

        public n rv(int i) {
            this.h = i;
            return this;
        }

        public n n(boolean z) {
            this.t = z;
            return this;
        }

        public n tj(int i) {
            this.lh = i;
            return this;
        }

        public rv n() {
            return new rv(this);
        }
    }
}
