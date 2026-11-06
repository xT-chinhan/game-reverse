package com.byazt.pnm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 19})
public class n {
    public String n;
    public int ou;
    public int py;
    public List<String> sz;
    public int qg = 1;
    public int s = 2;
    public int q = 1;
    public int l = 0;
    public int w = 1;
    public int x = 3;
    public int fs = 0;
    public int rv = 0;
    public int tj = 0;
    public int cp = 1500;
    public int d = 2000;
    public boolean oa = false;
    public int k = 2;
    public int cy = 100;
    public int hd = 0;
    public boolean cd = false;
    public boolean um = false;
    public long a = 0;

    public static n n() {
        return new n();
    }

    private n() {
    }

    public int qg() {
        return this.ou;
    }

    public n n(int i) {
        this.ou = i;
        return this;
    }

    public int s() {
        return this.py;
    }

    public n qg(int i) {
        this.py = i;
        return this;
    }

    public n n(boolean z) {
        this.cd = z;
        return this;
    }

    public n qg(boolean z) {
        this.um = z;
        return this;
    }

    public n n(long j) {
        this.a = j;
        return this;
    }

    public n s(int i) {
        this.d = i;
        return this;
    }

    public n q(int i) {
        this.tj = i;
        return this;
    }

    public n l(int i) {
        this.cp = i;
        return this;
    }

    public n w(int i) {
        this.fs = i;
        return this;
    }

    public n x(int i) {
        this.rv = i;
        return this;
    }

    public n n(String str) {
        this.n = str;
        return this;
    }

    public n fs(int i) {
        this.qg = i;
        return this;
    }

    public n rv(int i) {
        this.s = i;
        return this;
    }

    public n tj(int i) {
        this.q = i;
        return this;
    }

    public n cp(int i) {
        this.l = i;
        return this;
    }

    public n d(int i) {
        this.w = i;
        return this;
    }

    public n oa(int i) {
        this.k = i;
        return this;
    }

    public n sz(int i) {
        this.cy = i;
        return this;
    }

    public n s(boolean z) {
        this.oa = z;
        return this;
    }

    public n k(int i) {
        this.hd = i;
        return this;
    }
}
