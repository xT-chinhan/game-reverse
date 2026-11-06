package com.byazt.zct;

import android.content.Context;
import com.byazt.gct.pk;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, 26})
public class qg {
    public long cd;
    public n.InterfaceC0409n cp;
    public com.byazt.vd.n cy;
    public pk d;
    public ITTInnerDownloadAdapter hd;
    public int l;
    public boolean n;
    public Context oa;
    public com.byazt.zx.qg q;
    public Object rv;
    public boolean s;
    public Map<String, Object> w;
    public String x;
    public boolean fs = false;
    public int tj = Integer.MIN_VALUE;
    public boolean sz = false;
    public int k = -1;
    public boolean qg = true;

    public n.InterfaceC0409n n() {
        return this.cp;
    }

    public void n(n.InterfaceC0409n interfaceC0409n) {
        this.cp = interfaceC0409n;
    }

    public void n(pk pkVar) {
        this.d = pkVar;
    }

    public Context getContext() {
        return this.oa;
    }

    public void n(Context context) {
        this.oa = context;
    }

    public boolean qg() {
        return this.sz;
    }

    public void n(boolean z) {
        this.sz = z;
    }

    public int s() {
        return this.k;
    }

    public void n(int i) {
        this.k = i;
    }

    public boolean q() {
        return this.n;
    }

    public void qg(boolean z) {
        this.n = z;
    }

    public void s(boolean z) {
        this.qg = z;
    }

    public com.byazt.vd.n l() {
        return this.cy;
    }

    public void n(com.byazt.vd.n nVar) {
        this.cy = nVar;
    }

    public ITTInnerDownloadAdapter w() {
        return this.hd;
    }

    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        this.hd = iTTInnerDownloadAdapter;
    }

    public int x() {
        return this.l;
    }

    public void qg(int i) {
        this.l = i;
    }

    public Map<String, Object> fs() {
        return this.w;
    }

    public void n(Map<String, Object> map) {
        this.w = map;
    }

    public String rv() {
        return this.x;
    }

    public void n(String str) {
        this.x = str;
    }

    public boolean tj() {
        return this.fs;
    }

    public void q(boolean z) {
        this.fs = z;
    }

    public void n(Object obj) {
        this.rv = obj;
    }

    public void n(long j) {
        this.cd = j;
    }

    public boolean cp() {
        return this.s;
    }

    public void n(com.byazt.zx.qg qgVar) {
        this.q = qgVar;
    }

    public com.byazt.zx.qg d() {
        return this.q;
    }
}
