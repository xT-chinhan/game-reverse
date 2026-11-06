package com.byazt.zn;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public long aj;
    public boolean g;
    public com.byazt.mr.hw ho;
    public String k;
    public boolean m;
    public String nt;
    public long vk;
    public Map<String, String> w;
    public com.byazt.bd.hw x;
    public long yb;
    public long zo;
    public boolean c = false;
    public boolean uc = false;
    public boolean fw = false;
    public AtomicBoolean lb = new AtomicBoolean(false);

    @Override // com.byazt.zn.pr
    public int pr() {
        return this.pr;
    }

    @Override // com.byazt.zn.pr
    public void pr(int i) {
        this.pr = i;
    }

    @Override // com.byazt.zn.pr
    public of hw() {
        return this.hw;
    }

    @Override // com.byazt.zn.pr
    public void pr(of ofVar) {
        this.hw = ofVar;
    }

    public zo(of ofVar, boolean z) {
        this.hw = ofVar;
        this.m = z;
    }

    public zo(com.byazt.bd.hw hwVar, of ofVar, boolean z) {
        this.x = hwVar;
        this.hw = ofVar;
        this.m = z;
    }

    public com.byazt.bd.hw x() {
        return this.x;
    }

    public boolean c() {
        return this.c;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public boolean uc() {
        return this.uc;
    }

    public void hw(boolean z) {
        this.uc = z;
    }

    public long fw() {
        return this.zo;
    }

    public void hw(long j) {
        this.zo = j;
    }

    public void hn(long j) {
        this.aj = j;
    }

    public long zo() {
        return this.vk;
    }

    public void x(long j) {
        this.vk = j;
    }

    public Map<String, String> aj() {
        return this.w;
    }

    public void pr(Map<String, String> map) {
        this.w = map;
    }

    public boolean vk() {
        return this.fw;
    }

    public void hn(boolean z) {
        this.fw = z;
    }

    public void pr(String str) {
        this.k = str;
    }

    public boolean w() {
        return this.m;
    }

    public void x(boolean z) {
        this.g = z;
    }

    public com.byazt.mr.hw k() {
        return this.ho;
    }

    public void pr(com.byazt.mr.hw hwVar) {
        this.ho = hwVar;
    }

    public String m() {
        return this.nt;
    }

    public void hw(String str) {
        this.nt = str;
    }

    public long g() {
        return this.yb;
    }

    public void c(long j) {
        this.yb = j;
    }

    public boolean ho() {
        return this.lb.get();
    }

    public void c(boolean z) {
        this.lb.set(z);
    }
}
