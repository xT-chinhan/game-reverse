package com.byazt.lbp;

import android.content.Context;
import com.anythink.core.common.l.f;
import com.byazt.gct.pk;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "is_click_button", qg = "ALL")
    public volatile boolean cp;

    @com.byazt.phr.n(n = "download_adapter", qg = "ALL")
    public ITTInnerDownloadAdapter fs;

    @com.byazt.phr.n(n = f.bI, qg = "ALL")
    public JSONObject l;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "deep_link", qg = "ALL")
    public JSONObject q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "convert_tag", qg = "ALL")
    public String rv;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String s;

    @com.byazt.phr.n(n = "pip_controller", qg = "ALL")
    public com.byazt.zx.qg tj;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "ALL")
    public boolean w;

    @com.byazt.phr.n(n = "convert_from_downloader", qg = "ALL")
    public boolean x;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.rcj.x xVar = new com.byazt.rcj.x(com.byazt.vgx.qg.qg(this.l), this.qg, this.n, map2);
        xVar.n(this.s);
        com.byazt.rcj.s sVar = new com.byazt.rcj.s(xVar, this.n, this.s, new com.byazt.gct.hd(this.q), this.qg, map2, false, false);
        sVar.qg(this.x);
        sVar.n(this.w);
        sVar.n(this.fs);
        sVar.n(this.rv);
        sVar.n(this.tj);
        sVar.s(this.cp);
        if (sVar.n(map2)) {
            nVar.n(map2);
            return true;
        }
        nVar.n(map2, (com.byazt.bds.n) null);
        return true;
    }
}
