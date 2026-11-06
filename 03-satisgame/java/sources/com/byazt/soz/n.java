package com.byazt.soz;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 19})
public class n extends qg {
    public com.byazt.za.s l;
    public int w;

    public n() {
    }

    public n(pk pkVar, Context context) {
        this.n = pkVar;
        this.qg = context;
    }

    public void n(com.byazt.za.s sVar) {
        this.l = sVar;
    }

    public void n(int i) {
        this.w = i;
    }

    @Override // com.byazt.dj.n
    public void n(View view) {
        this.q = view;
    }

    @Override // com.byazt.dj.n
    public int n(Map<String, Object> map, com.byazt.dj.s sVar) {
        if (this.l == null) {
            return 0;
        }
        if (this.s == null) {
            this.s = new tj();
        }
        View viewTj = this.s.tj();
        int[] iArrN = new int[2];
        int[] iArrS = new int[2];
        if (viewTj != null) {
            iArrN = com.byazt.okk.s.n(viewTj);
            iArrS = com.byazt.okk.s.s(viewTj);
        }
        this.l.n(this.q, this.w, new wm.n().q(this.s.cd()).s(this.s.um()).qg(this.s.a()).n(this.s.py()).qg(this.s.cy()).n(this.s.hd()).n(iArrN[0]).qg(iArrN[1]).s(iArrS[0]).q(iArrS[1]).n(this.s.rv()).n(this.s.sz()).n());
        return 1;
    }
}
