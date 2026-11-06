package com.byazt.pp;

import android.graphics.Bitmap;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public final int[][] cp;
    public Bitmap cy;
    public final JSONArray d;
    public final String fs;
    public final String k;
    public final String l;
    public final int n;
    public final n oa;
    public final String q;
    public final int qg;
    public final List<s> rv;
    public final String s;
    public final qg sz;
    public final String tj;
    public final String w;
    public final String x;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 160})
    public static class n {
        public C0302n n = null;
        public boolean qg;

        /* JADX INFO: renamed from: com.byazt.pp.rv$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX})
        public static class C0302n {
            public float n = 5.0f;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 529})
    public static class qg {
        public int n;
        public int qg;
        public int s;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME})
    public static class s {
        public n cp;
        public n d;
        public int fs;
        public String l;
        public int n;
        public int oa;
        public String q;
        public int qg;
        public int rv;
        public String s;
        public int sz;
        public String tj;
        public int w;
        public String x;

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 957})
        public static class n {
            public int n;
            public String qg;
        }
    }

    public rv(int i, int i2, String str, String str2, String str3, String str4, List<s> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, n nVar, qg qgVar, String str8) {
        this.n = i;
        this.qg = i2;
        this.s = str;
        this.q = str2;
        this.l = str3;
        this.w = str4;
        this.x = str6;
        this.fs = str7;
        this.rv = list;
        this.tj = str5;
        this.cp = iArr;
        this.d = jSONArray;
        this.oa = nVar;
        this.sz = qgVar;
        this.k = str8;
    }

    public int n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public List<s> s() {
        return this.rv;
    }

    public String q() {
        return this.w;
    }

    public String l() {
        return this.x;
    }

    public String w() {
        return this.fs;
    }

    public String x() {
        return this.tj;
    }

    public int[][] fs() {
        return this.cp;
    }

    public JSONArray rv() {
        return this.d;
    }

    public n tj() {
        return this.oa;
    }

    public qg cp() {
        return this.sz;
    }

    public String d() {
        return this.s;
    }

    public String oa() {
        return this.q;
    }

    public String sz() {
        return this.l;
    }

    public Bitmap k() {
        return this.cy;
    }

    public void n(Bitmap bitmap) {
        this.cy = bitmap;
    }

    public String cy() {
        return this.k;
    }
}
