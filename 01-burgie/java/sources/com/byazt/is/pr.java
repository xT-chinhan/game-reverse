package com.byazt.is;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 37})
public class pr {
    public int cz;
    public List<String> g;
    public int ny;
    public String pr;
    public int hw = 1;
    public int hn = 2;
    public int x = 1;
    public int c = 0;
    public int uc = 1;
    public int fw = 3;
    public int zo = 0;
    public int aj = 0;
    public int vk = 0;
    public int w = TTAdConstant.STYLE_SIZE_RADIO_3_2;
    public int k = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
    public boolean m = false;
    public int ho = 2;
    public int nt = 100;
    public int yb = 0;
    public boolean lb = false;
    public boolean qa = false;
    public long a = 0;

    public static pr pr() {
        return new pr();
    }

    private pr() {
    }

    public int hw() {
        return this.ny;
    }

    public pr pr(int i) {
        this.ny = i;
        return this;
    }

    public int hn() {
        return this.cz;
    }

    public pr hw(int i) {
        this.cz = i;
        return this;
    }

    public pr pr(boolean z) {
        this.lb = z;
        return this;
    }

    public pr hw(boolean z) {
        this.qa = z;
        return this;
    }

    public pr pr(long j) {
        this.a = j;
        return this;
    }

    public pr hn(int i) {
        this.k = i;
        return this;
    }

    public pr x(int i) {
        this.vk = i;
        return this;
    }

    public pr c(int i) {
        this.w = i;
        return this;
    }

    public pr uc(int i) {
        this.zo = i;
        return this;
    }

    public pr fw(int i) {
        this.aj = i;
        return this;
    }

    public pr pr(String str) {
        this.pr = str;
        return this;
    }

    public pr zo(int i) {
        this.hw = i;
        return this;
    }

    public pr aj(int i) {
        this.hn = i;
        return this;
    }

    public pr vk(int i) {
        this.x = i;
        return this;
    }

    public pr w(int i) {
        this.c = i;
        return this;
    }

    public pr k(int i) {
        this.uc = i;
        return this;
    }

    public pr m(int i) {
        this.ho = i;
        return this;
    }

    public pr g(int i) {
        this.nt = i;
        return this;
    }

    public pr hn(boolean z) {
        this.m = z;
        return this;
    }

    public pr ho(int i) {
        this.yb = i;
        return this;
    }
}
