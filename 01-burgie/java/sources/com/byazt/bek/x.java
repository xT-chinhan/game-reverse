package com.byazt.bek;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 121})
@Deprecated
public class x implements DownloadEventConfig {
    public String aj;
    public String c;
    public String fw;
    public boolean g;
    public String hn;
    public boolean ho;
    public boolean hw;
    public Object k;
    public boolean m;
    public String nt;
    public String pr;
    public String uc;
    public String vk;
    public String w;
    public String x;
    public String yb;
    public String zo;

    public x() {
    }

    private x(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
        this.fw = prVar.fw;
        this.zo = prVar.zo;
        this.aj = prVar.aj;
        this.vk = prVar.vk;
        this.w = prVar.w;
        this.k = prVar.k;
        this.m = prVar.m;
        this.g = prVar.g;
        this.ho = prVar.ho;
        this.nt = prVar.nt;
        this.yb = prVar.yb;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getRefer() {
        return this.yb;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickButtonTag() {
        return this.pr;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickLabel() {
        return this.hn;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickStartLabel() {
        return this.x;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.c;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.uc;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.fw;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.vk;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.k;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.hw;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.m;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.byazt.bek.DownloadEventConfig
    public void setRefer(String str) {
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static final class pr {
        public String aj;
        public String c;
        public String fw;
        public boolean g;
        public String hn;
        public boolean ho;
        public boolean hw;
        public Object k;
        public boolean m;
        public String nt;
        public String pr;
        public String uc;
        public String vk;
        public String w;
        public String x;
        public String yb;
        public String zo;

        public x pr() {
            return new x(this);
        }
    }
}
