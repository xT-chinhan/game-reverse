package com.byazt.hj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 581, 5})
@Deprecated
public class q implements DownloadEventConfig {
    public String cp;
    public String cy;
    public Object d;
    public String fs;
    public String hd;
    public boolean k;
    public String l;
    public String n;
    public boolean oa;
    public String q;
    public boolean qg;
    public String rv;
    public String s;
    public boolean sz;
    public String tj;
    public String w;
    public String x;

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public void setRefer(String str) {
    }

    public q() {
    }

    private q(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.rv = nVar.rv;
        this.tj = nVar.tj;
        this.cp = nVar.cp;
        this.d = nVar.d;
        this.oa = nVar.oa;
        this.sz = nVar.sz;
        this.k = nVar.k;
        this.cy = nVar.cy;
        this.hd = nVar.hd;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getRefer() {
        return this.hd;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickButtonTag() {
        return this.n;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickLabel() {
        return this.s;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickStartLabel() {
        return this.q;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.l;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.w;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.x;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.tj;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.d;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.qg;
    }

    @Override // com.byazt.hj.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.oa;
    }

    @com.byazt.cp.n(n = {0, 1, 581, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static final class n {
        public String cp;
        public String cy;
        public Object d;
        public String fs;
        public String hd;
        public boolean k;
        public String l;
        public String n;
        public boolean oa;
        public String q;
        public boolean qg;
        public String rv;
        public String s;
        public boolean sz;
        public String tj;
        public String w;
        public String x;

        public q n() {
            return new q(this);
        }
    }
}
