package com.byazt.hg;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 61})
public class aj {
    public final String a;
    public final long aj;
    public int b;
    public final float c;
    public final String cz;
    public int fo;
    public final float fw;
    public final float g;
    public int gz;
    public final int[] hn;
    public final int ho;
    public final int[] hw;
    public byte iu;
    public final int k;
    public final String lb;
    public final int m;
    public final int nl;
    public final float nt;
    public SparseArray<com.byazt.az.x.pr> ny;
    public final int[] pr;
    public final String qa;
    public int rc;
    public final float uc;
    public byte ve;
    public final long vk;
    public final int w;
    public final int[] x;
    public final boolean y;
    public final int yb;
    public String z;
    public final float zo;

    private aj(pr prVar) {
        this.rc = -1;
        this.b = -1;
        this.ve = (byte) -1;
        this.gz = Integer.MIN_VALUE;
        this.pr = prVar.w;
        this.hw = prVar.k;
        this.x = prVar.m;
        this.hn = prVar.vk;
        this.c = prVar.aj;
        this.uc = prVar.zo;
        this.fw = prVar.fw;
        this.zo = prVar.uc;
        this.aj = prVar.c;
        this.vk = prVar.x;
        this.w = prVar.g;
        this.k = prVar.ho;
        this.m = prVar.nt;
        this.g = prVar.pr;
        this.lb = prVar.qa;
        this.qa = prVar.a;
        this.cz = prVar.ny;
        this.a = prVar.cz;
        this.ho = prVar.hw;
        this.nt = prVar.hn;
        this.yb = prVar.lb;
        this.ny = prVar.yb;
        this.fo = prVar.fo;
        this.rc = prVar.rc;
        this.z = prVar.z;
        this.b = prVar.b;
        this.y = prVar.iu;
        this.iu = prVar.ve;
        this.ve = prVar.gz;
        this.gz = prVar.nl;
        this.nl = prVar.y;
    }

    @JProtect
    public JSONObject pr(of ofVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.pr;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.pr[1]));
            }
            int[] iArr2 = this.hw;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.hw[1]));
            }
            int[] iArr3 = this.hn;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.hn[1]));
            }
            int[] iArr4 = this.x;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.x[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.ny != null) {
                for (int i = 0; i < this.ny.size(); i++) {
                    com.byazt.az.x.pr prVarValueAt = this.ny.valueAt(i);
                    if (prVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(prVarValueAt.hn)).putOpt("mr", Double.valueOf(prVarValueAt.hw)).putOpt("phase", Integer.valueOf(prVarValueAt.pr)).putOpt("ts", Long.valueOf(prVarValueAt.x));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.yb)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.c)).putOpt("down_y", Float.toString(this.uc)).putOpt("up_x", Float.toString(this.fw)).putOpt("up_y", Float.toString(this.zo)).putOpt("down_time", Long.valueOf(this.aj)).putOpt("up_time", Long.valueOf(this.vk)).putOpt("toolType", Integer.valueOf(this.w)).putOpt("deviceId", Integer.valueOf(this.k)).putOpt("source", Integer.valueOf(this.m)).putOpt("density", Float.valueOf(this.g)).putOpt("densityDpi", Integer.valueOf(this.ho)).putOpt("scaleDensity", Float.valueOf(this.nt)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.lb).putOpt("areaType", this.qa).putOpt("rectInfo", this.cz).putOpt("click_area_id", this.a);
            int i2 = this.fo;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.rc;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.b;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.z);
            }
            if (this.y) {
                jSONObject.put("referer", "directDownload");
            }
            jSONObject.putOpt("convert_type", Byte.valueOf(this.iu));
            jSONObject.putOpt("click_creative_type", Integer.valueOf(this.nl));
            byte b = this.ve;
            if (b != -1) {
                jSONObject.putOpt("biz_type", Byte.valueOf(b));
            }
            int i5 = this.gz;
            if (i5 != Integer.MIN_VALUE) {
                jSONObject.putOpt("fail_status", Integer.valueOf(i5));
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr {
        public String a;
        public String cz;
        public float hn;
        public int hw;
        public int[] k;
        public int lb;
        public int[] m;
        public String ny;
        public float pr;
        public String qa;
        public int[] vk;
        public int[] w;
        public SparseArray<com.byazt.az.x.pr> yb;
        public String z;
        public long x = -1;
        public long c = -1;
        public float uc = -1.0f;
        public float fw = -1.0f;
        public float zo = -1.0f;
        public float aj = -1.0f;
        public int g = -1;
        public int ho = -1;
        public int nt = -1024;
        public int fo = -1;
        public int rc = -1;
        public int b = -1;
        public boolean iu = false;
        public byte ve = 0;
        public byte gz = -1;
        public int nl = Integer.MIN_VALUE;
        public int y = -1;

        public pr pr(int i) {
            this.nl = i;
            return this;
        }

        public pr pr(byte b) {
            this.gz = b;
            return this;
        }

        public pr hw(byte b) {
            this.ve = b;
            return this;
        }

        public pr pr(float f) {
            this.pr = f;
            return this;
        }

        public pr hw(int i) {
            this.hw = i;
            return this;
        }

        public pr hw(float f) {
            this.hn = f;
            return this;
        }

        public pr hn(int i) {
            this.lb = i;
            return this;
        }

        public pr pr(SparseArray<com.byazt.az.x.pr> sparseArray) {
            this.yb = sparseArray;
            return this;
        }

        public pr pr(long j) {
            this.x = j;
            return this;
        }

        public pr hw(long j) {
            this.c = j;
            return this;
        }

        public pr hn(float f) {
            this.uc = f;
            return this;
        }

        public pr x(float f) {
            this.fw = f;
            return this;
        }

        public pr c(float f) {
            this.zo = f;
            return this;
        }

        public pr uc(float f) {
            this.aj = f;
            return this;
        }

        public pr pr(int[] iArr) {
            this.vk = iArr;
            return this;
        }

        public pr hw(int[] iArr) {
            this.w = iArr;
            return this;
        }

        public pr hn(int[] iArr) {
            this.k = iArr;
            return this;
        }

        public pr x(int[] iArr) {
            this.m = iArr;
            return this;
        }

        public pr x(int i) {
            this.g = i;
            return this;
        }

        public pr c(int i) {
            this.ho = i;
            return this;
        }

        public pr uc(int i) {
            this.nt = i;
            return this;
        }

        public pr pr(String str) {
            this.qa = str;
            return this;
        }

        public pr hw(String str) {
            this.a = str;
            return this;
        }

        public pr hn(String str) {
            this.cz = str;
            return this;
        }

        public pr x(String str) {
            this.ny = str;
            return this;
        }

        public pr fw(int i) {
            this.fo = i;
            return this;
        }

        public pr zo(int i) {
            this.rc = i;
            return this;
        }

        public pr c(String str) {
            this.z = str;
            return this;
        }

        public pr aj(int i) {
            this.b = i;
            return this;
        }

        public pr pr(boolean z) {
            this.iu = z;
            return this;
        }

        public pr vk(int i) {
            this.y = i;
            return this;
        }

        public aj pr() {
            return new aj(this);
        }
    }
}
