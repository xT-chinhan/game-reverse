package com.byazt.zct;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, 19})
public class n extends com.byazt.dj.n {
    public qg l = new qg();

    /* JADX INFO: renamed from: com.byazt.zct.n$n, reason: collision with other inner class name */
    public interface InterfaceC0409n {
        void n(View view, int i);
    }

    @Override // com.byazt.dj.n
    public int n(Map<String, Object> map, com.byazt.dj.s sVar) {
        return 0;
    }

    public void n(int i) {
        this.l.qg(i);
    }

    public void n(Map<String, Object> map) {
        this.l.n(map);
    }

    public void n(String str) {
        this.l.n(str);
    }

    public void n(boolean z) {
        this.l.n(z);
    }

    public void n(pk pkVar) {
        this.n = pkVar;
        this.l.n(pkVar);
    }

    public void n(Context context) {
        this.qg = context;
        this.l.n(context);
    }

    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        this.l.n(iTTInnerDownloadAdapter);
    }

    public ITTInnerDownloadAdapter n() {
        return this.l.w();
    }

    public void qg(boolean z) {
        this.l.q(z);
    }

    public void n(Object obj) {
        this.l.n(obj);
    }

    public void s(boolean z) {
        this.l.s(z);
    }

    public void n(com.byazt.vd.n nVar) {
        this.l.n(nVar);
    }

    public void q(boolean z) {
        this.l.qg(z);
    }

    public void n(InterfaceC0409n interfaceC0409n) {
        this.l.n(interfaceC0409n);
    }

    public void qg(int i) {
        if (this.l.q()) {
            this.l.n(i);
        }
    }

    public void n(long j) {
        this.l.n(j);
    }

    public void n(com.byazt.zx.qg qgVar) {
        this.l.n(qgVar);
    }

    public qg qg() {
        return this.l;
    }

    public void s() {
        if (this.l.qg() && this.l.q()) {
            ITTInnerDownloadAdapter iTTInnerDownloadAdapterW = this.l.w();
            if (iTTInnerDownloadAdapterW instanceof com.byazt.oh.n) {
                ((com.byazt.oh.n) iTTInnerDownloadAdapterW).n(true);
            }
        }
    }

    public void q() {
        if (this.l.q()) {
            com.byazt.vd.n nVarL = this.l.l();
            if (!w.q(this.n) || nVarL == null) {
                return;
            }
            nVarL.qg();
        }
    }
}
