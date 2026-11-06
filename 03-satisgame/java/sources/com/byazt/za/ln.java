package com.byazt.za;

import android.view.ViewGroup;
import androidx.core.view.PointerIconCompat;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, PointerIconCompat.TYPE_ZOOM_IN})
public class ln implements SSWebView.qg {
    public SSWebView n;
    public pk qg;
    public com.byazt.gcl.s s;

    public ln(SSWebView sSWebView, com.byazt.gcl.s sVar, pk pkVar) {
        this.n = sSWebView;
        this.qg = pkVar;
        this.s = sVar;
    }

    private boolean n() {
        SSWebView sSWebView = this.n;
        if (sSWebView == null) {
            return false;
        }
        return com.byazt.okk.q.qg(sSWebView, 50, com.byazt.vgx.w.d(this.qg));
    }

    @Override // com.byazt.kfh.SSWebView.qg
    public void n(final int i) {
        if (n()) {
            if (com.byazt.nf.rv.qg().um()) {
                SSWebView sSWebView = this.n;
                if (sSWebView != null) {
                    com.byazt.cd.qg.n((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.byazt.ys.q() { // from class: com.byazt.za.ln.1
                        @Override // com.byazt.ys.q
                        public void n() {
                            if (ln.this.s != null) {
                                ln.this.s.n(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            com.byazt.gcl.s sVar = this.s;
            if (sVar != null) {
                sVar.n(i);
            }
        }
    }
}
