package com.byazt.hg;

import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2121})
public class pq {
    public int c;
    public int fw;
    public pr g;
    public int ho;
    public String hw;
    public hw k;
    public int m;
    public int pr;
    public int uc;
    public hw w;
    public int x;
    public int zo;
    public boolean hn = false;
    public String aj = "#008DEA";
    public String vk = "点击查看";
    public float nt = 0.0f;
    public int yb = 0;
    public int lb = 0;
    public int qa = 55;
    public int a = 0;
    public float cz = 0.0f;
    public int ny = 100;
    public int fo = 0;
    public int rc = 0;
    public int z = 0;

    public int pr() {
        return this.pr;
    }

    public void pr(int i) {
        this.pr = i;
    }

    public String hw() {
        if (this.x == 4 && !com.byazt.sd.zo.nt().pr(com.byazt.sd.a.getContext())) {
            this.hw = "点击跳转至详情页或第三方应用";
        } else if (this.x == 7 && !com.byazt.sd.zo.nt().hw(com.byazt.sd.a.getContext())) {
            this.hw = "点击跳转至详情页或第三方应用";
        }
        return this.hw;
    }

    public boolean hn() {
        return this.hn;
    }

    public void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hn = true;
            switch (this.x) {
                case 3:
                    this.hw = "跳转至详情页或第三方应用";
                    break;
                case 4:
                    this.hw = "前往详情页或第三方应用";
                    break;
                case 5:
                case 7:
                    this.hw = "前往详情页或第三方应用";
                    break;
                case 6:
                default:
                    this.hw = "点击跳转至详情页或第三方应用";
                    break;
            }
            return;
        }
        this.hw = str;
    }

    public int x() {
        return this.c;
    }

    public void hw(int i) {
        this.c = i;
    }

    public int c() {
        return this.uc;
    }

    public void hn(int i) {
        this.uc = i;
    }

    public int uc() {
        return this.fw;
    }

    public void x(int i) {
        this.fw = i;
    }

    public int fw() {
        return this.zo;
    }

    public void c(int i) {
        this.zo = i;
    }

    public void uc(int i) {
        this.ho = i;
    }

    public int zo() {
        return this.ho;
    }

    public int aj() {
        if (this.x == 4 && !com.byazt.sd.zo.nt().pr(com.byazt.sd.a.getContext())) {
            this.x = 0;
        } else if (this.x == 7 && !com.byazt.sd.zo.nt().hw(com.byazt.sd.a.getContext())) {
            this.x = 0;
        }
        return this.x;
    }

    public void fw(int i) {
        this.x = i;
    }

    public String vk() {
        return this.aj;
    }

    public void hw(String str) {
        try {
            Color.parseColor(str);
            this.aj = str;
        } catch (Throwable th) {
            this.aj = "#008DEA";
        }
    }

    public String w() {
        return this.vk;
    }

    public void hn(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.x;
            if (i == 7) {
                this.vk = "扭动手机";
                return;
            } else if (i == 5) {
                this.vk = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.vk = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.vk = str;
    }

    public void pr(JSONObject jSONObject) {
        this.w = new hw(jSONObject, 14);
    }

    public void hw(JSONObject jSONObject) {
        this.k = new hw(jSONObject, 20);
    }

    public hw k() {
        return this.w;
    }

    public hw m() {
        return this.k;
    }

    public void pr(JSONObject jSONObject, int i) {
        this.g = new pr(jSONObject, i);
    }

    public pr g() {
        return this.g;
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 599})
    public class pr {
        public int hn;
        public int hw;
        public int pr;
        public int x;

        public int pr() {
            return this.pr;
        }

        public int hw() {
            return this.hw;
        }

        public int hn() {
            return this.hn;
        }

        public int x() {
            return this.x;
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception e) {
            }
            return jSONObject;
        }

        public pr(JSONObject jSONObject, int i) {
            this.pr = 30;
            this.hw = 30;
            this.hn = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
            this.x = 40;
            if (jSONObject != null) {
                int iOptInt = jSONObject.optInt("left_margin", 30);
                this.pr = iOptInt;
                if (iOptInt < 0 || iOptInt > pq.this.iu()) {
                    this.pr = 30;
                }
                int iOptInt2 = jSONObject.optInt("right_margin", 30);
                this.hw = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > pq.this.iu()) {
                    this.hw = 30;
                }
                if (i == 2) {
                    int iOptInt3 = jSONObject.optInt("top_margin", 40);
                    this.hn = iOptInt3;
                    if (iOptInt3 < 0 || iOptInt3 > pq.this.b()) {
                        this.hn = 40;
                    }
                    int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                    this.x = iOptInt4;
                    if (iOptInt4 < 0 || iOptInt4 > pq.this.b()) {
                        this.x = 20;
                        return;
                    }
                    return;
                }
                int iOptInt5 = jSONObject.optInt("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                this.hn = iOptInt5;
                if (iOptInt5 < 0 || iOptInt5 > pq.this.b()) {
                    this.hn = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                }
                int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
                this.x = iOptInt6;
                if (iOptInt6 < 0 || iOptInt6 > pq.this.b()) {
                    this.x = 40;
                    return;
                }
                return;
            }
            if (i == 2) {
                this.hn = 40;
                this.x = 20;
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 419})
    public class hw {
        public int pr;

        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.pr);
            } catch (Exception e) {
            }
            return jSONObject;
        }

        public hw(JSONObject jSONObject, int i) {
            this.pr = 14;
            if (jSONObject == null) {
                return;
            }
            this.pr = jSONObject.optInt("font_size", i);
        }

        public int hw() {
            return this.pr;
        }
    }

    public int ho() {
        return this.m;
    }

    public void zo(int i) {
        if (i <= 0 || i >= b()) {
            this.m = 5;
        } else {
            this.m = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        return com.byazt.wt.er.x(com.byazt.sd.a.getContext(), com.byazt.wt.er.uc(com.byazt.sd.a.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iu() {
        return com.byazt.wt.er.x(com.byazt.sd.a.getContext(), com.byazt.wt.er.c(com.byazt.sd.a.getContext()));
    }

    public void pr(float f) {
        this.nt = f;
    }

    public float nt() {
        return this.nt;
    }

    public void aj(int i) {
        this.yb = i;
    }

    public int yb() {
        return this.yb;
    }

    public void vk(int i) {
        this.lb = i;
    }

    public int lb() {
        return this.lb;
    }

    public void w(int i) {
        this.qa = i;
    }

    public int qa() {
        return this.qa;
    }

    public void k(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public void m(int i) {
        this.ny = i;
    }

    public int cz() {
        return this.ny;
    }

    public void g(int i) {
        this.fo = i;
    }

    public int ny() {
        return this.fo;
    }

    public void ho(int i) {
        this.rc = i;
    }

    public int fo() {
        return this.rc;
    }

    public void nt(int i) {
        this.z = i;
    }

    public int rc() {
        return this.z;
    }

    public void hw(float f) {
        this.cz = f;
    }

    public float z() {
        return this.cz;
    }
}
