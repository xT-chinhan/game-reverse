package com.byazt.ee;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public static ny pr;
    public final List<g> c;
    public final com.byazt.son.x hn;
    public final pr hw;
    public volatile boolean uc;
    public final vk x;

    public static vk pr(com.byazt.son.x xVar) {
        return new vk(xVar);
    }

    public <T> void pr(String str, T t) {
        hw();
        this.hw.pr(str, t);
    }

    public yb pr(String str, c<?, ?> cVar) {
        return pr(str, (String) null, cVar);
    }

    public yb pr(String str, String str2, c<?, ?> cVar) {
        hw();
        this.hw.uc.pr(str, cVar);
        return this;
    }

    public yb pr(String str, x.hw hwVar) {
        return pr(str, (String) null, hwVar);
    }

    public yb pr(String str, String str2, x.hw hwVar) {
        hw();
        this.hw.uc.pr(str, hwVar);
        return this;
    }

    public boolean pr(String str) {
        pr prVar = this.hw;
        if (prVar != null && prVar.uc != null) {
            return this.hw.uc.pr(str);
        }
        return false;
    }

    public void pr() {
        if (this.uc) {
            return;
        }
        this.hw.hn();
        this.uc = true;
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public yb(vk vkVar) {
        cz czVarPr;
        ny nyVar;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.uc = false;
        this.x = vkVar;
        if (vkVar.zo && (nyVar = pr) != null) {
            czVarPr = nyVar.pr(vkVar.w);
        } else {
            czVarPr = null;
        }
        if (vkVar.pr != null && vkVar.hw == null) {
            this.hw = new z();
        } else {
            this.hw = vkVar.hw;
        }
        this.hw.pr(vkVar.hn());
        this.hw.pr(vkVar, czVarPr);
        this.hn = vkVar.pr;
        arrayList.add(vkVar.vk);
        aj.pr(vkVar.uc);
        rc.pr(vkVar.fw);
    }

    private void hw() {
        if (this.uc) {
            aj.pr(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
