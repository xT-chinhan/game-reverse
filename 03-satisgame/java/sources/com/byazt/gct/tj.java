package com.byazt.gct;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public boolean k;
    public String m;
    public View oa;
    public String py;
    public View sz;
    public String um;
    public float n = -1.0f;
    public float qg = -1.0f;
    public float s = -1.0f;
    public float q = -1.0f;
    public long l = -1;
    public long w = -1;
    public int x = -1;
    public int fs = -1;
    public int rv = -1024;
    public boolean tj = true;
    public int cp = 0;
    public int d = 0;
    public byte cy = 0;
    public byte hd = -1;
    public boolean cd = false;
    public int a = -1;
    public SparseArray<com.byazt.ys.l.n> ou = new SparseArray<>();
    public List<Integer> wm = new ArrayList();
    public int hu = -1;
    public boolean h = false;

    public void n(boolean z) {
        this.h = z;
    }

    public boolean n() {
        return this.h;
    }

    public void n(byte b) {
        this.cy = b;
    }

    public byte qg() {
        return this.cy;
    }

    public byte s() {
        return this.hd;
    }

    public void qg(byte b) {
        this.hd = b;
    }

    public boolean q() {
        return this.hu == 2;
    }

    public void n(int i) {
        this.hu = i;
    }

    public int l() {
        return this.hu;
    }

    public int w() {
        return this.x;
    }

    public void qg(int i) {
        this.x = i;
    }

    public int x() {
        return this.fs;
    }

    public void s(int i) {
        this.fs = i;
    }

    public int fs() {
        return this.rv;
    }

    public void q(int i) {
        this.rv = i;
    }

    public boolean rv() {
        return this.tj;
    }

    public void qg(boolean z) {
        this.tj = z;
    }

    public View tj() {
        return this.oa;
    }

    public void n(View view) {
        this.oa = (View) new WeakReference(view).get();
    }

    public View cp() {
        return this.sz;
    }

    public void qg(View view) {
        this.sz = (View) new WeakReference(view).get();
    }

    public int d() {
        return this.cp;
    }

    public void l(int i) {
        this.cp = i;
    }

    public int oa() {
        return this.d;
    }

    public void w(int i) {
        this.d = i;
    }

    public SparseArray<com.byazt.ys.l.n> sz() {
        return this.ou;
    }

    public void n(SparseArray<com.byazt.ys.l.n> sparseArray) {
        this.ou = sparseArray;
    }

    public List<Integer> k() {
        return this.wm;
    }

    public long cy() {
        return this.l;
    }

    public void n(long j) {
        this.l = j;
    }

    public long hd() {
        return this.w;
    }

    public void qg(long j) {
        this.w = j;
    }

    public float cd() {
        return this.n;
    }

    public void n(float f) {
        this.n = f;
    }

    public float um() {
        return this.qg;
    }

    public void qg(float f) {
        this.qg = f;
    }

    public float a() {
        return this.s;
    }

    public void s(float f) {
        this.s = f;
    }

    public float py() {
        return this.q;
    }

    public void q(float f) {
        this.q = f;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public void n(String str) {
        this.um = str;
    }

    public String ou() {
        return this.um;
    }

    public void x(int i) {
        this.a = i;
    }

    public int wm() {
        return this.a;
    }

    public String m() {
        return this.py;
    }

    public void qg(String str) {
        this.py = str;
    }

    public void q(boolean z) {
        this.cd = z;
    }

    public String hu() {
        return this.m;
    }

    public void s(String str) {
        this.m = str;
    }
}
