package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 113})
public class d {
    public Map<String, String> fs;
    public int[] l;
    public boolean n;
    public boolean q;
    public int qg;
    public String rv;
    public boolean s;
    public String[] w;
    public String x;

    private d(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.rv = nVar.rv;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 89})
    public static class n {
        public boolean n = false;
        public int qg = 0;
        public boolean s = true;
        public boolean q = false;
        public int[] l = {4, 3, 5};
        public String[] w = new String[0];
        public String x = "";
        public final Map<String, String> fs = new HashMap();
        public String rv = "";

        public n n(boolean z) {
            this.n = z;
            return this;
        }

        public n n(int i) {
            this.qg = i;
            return this;
        }

        public n qg(boolean z) {
            this.s = z;
            return this;
        }

        public n n(int... iArr) {
            this.l = iArr;
            return this;
        }

        public n n(String str) {
            this.x = str;
            return this;
        }

        public n n(Map<String, String> map) {
            this.fs.putAll(map);
            return this;
        }

        public n qg(String str) {
            this.rv = str;
            return this;
        }

        public d n() {
            return new d(this);
        }
    }

    public boolean n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }

    public int[] l() {
        return this.l;
    }

    public String[] w() {
        return this.w;
    }

    public String x() {
        return this.x;
    }

    public Map<String, String> fs() {
        return this.fs;
    }

    public String rv() {
        return this.rv;
    }
}
