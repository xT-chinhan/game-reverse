package com.byazt.dx;

import android.graphics.Bitmap;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 61})
public class aj {
    public final List<hn> aj;
    public final String c;
    public final String fw;
    public final hw g;
    public final String hn;
    public final String ho;
    public final int hw;
    public final JSONArray k;
    public final pr m;
    public Bitmap nt;
    public final int pr;
    public final String uc;
    public final String vk;
    public final int[][] w;
    public final String x;
    public final String zo;

    @com.byazt.vzx.pr(pr = {0, 1, 229, 474})
    public static class hn {
        public int aj;
        public String c;
        public String fw;
        public int g;
        public String hn;
        public int hw;
        public pr k;
        public int m;
        public int pr;
        public int uc;
        public String vk;
        public pr w;
        public String x;
        public int zo;

        @com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER})
        public static class pr {
            public String hw;
            public int pr;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, 470})
    public static class hw {
        public int hn;
        public int hw;
        public int pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr {
        public boolean hw;
        public C0046pr pr = null;

        /* JADX INFO: renamed from: com.byazt.dx.aj$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 229, 796})
        public static class C0046pr {
            public float pr = 5.0f;
        }
    }

    public aj(int i, int i2, String str, String str2, String str3, String str4, List<hn> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, pr prVar, hw hwVar, String str8) {
        this.pr = i;
        this.hw = i2;
        this.hn = str;
        this.x = str2;
        this.c = str3;
        this.uc = str4;
        this.fw = str6;
        this.zo = str7;
        this.aj = list;
        this.vk = str5;
        this.w = iArr;
        this.k = jSONArray;
        this.m = prVar;
        this.g = hwVar;
        this.ho = str8;
    }

    public int pr() {
        return this.pr;
    }

    public int hw() {
        return this.hw;
    }

    public List<hn> hn() {
        return this.aj;
    }

    public String x() {
        return this.uc;
    }

    public String c() {
        return this.fw;
    }

    public String uc() {
        return this.zo;
    }

    public String fw() {
        return this.vk;
    }

    public int[][] zo() {
        return this.w;
    }

    public JSONArray aj() {
        return this.k;
    }

    public pr vk() {
        return this.m;
    }

    public hw w() {
        return this.g;
    }

    public String k() {
        return this.hn;
    }

    public String m() {
        return this.x;
    }

    public String g() {
        return this.c;
    }

    public Bitmap ho() {
        return this.nt;
    }

    public void pr(Bitmap bitmap) {
        this.nt = bitmap;
    }

    public String nt() {
        return this.ho;
    }
}
