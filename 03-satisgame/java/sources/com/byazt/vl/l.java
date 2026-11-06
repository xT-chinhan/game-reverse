package com.byazt.vl;

import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.y.AdDownloadController;
import com.byazt.y.AdDownloadEventConfig;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 18})
public class l implements com.byazt.h.n {
    public com.byazt.h.qg l;
    public long n;
    public DownloadController q;
    public DownloadModel qg;
    public DownloadEventConfig s;

    @Override // com.byazt.h.n
    public int um() {
        return 0;
    }

    public l() {
    }

    public l(long j, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this.n = j;
        this.qg = downloadModel;
        this.s = downloadEventConfig;
        this.q = downloadController;
    }

    public boolean m() {
        DownloadModel downloadModel;
        if (this.n == 0 || (downloadModel = this.qg) == null || this.s == null || this.q == null) {
            return true;
        }
        return downloadModel.isAd() && this.n <= 0;
    }

    public boolean hu() {
        if (m()) {
            return false;
        }
        if (this.qg.isAd()) {
            DownloadModel downloadModel = this.qg;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.s instanceof AdDownloadEventConfig) && (this.q instanceof AdDownloadController);
        }
        return this.qg instanceof AdDownloadModel;
    }

    @Override // com.byazt.h.n
    public String n() {
        return this.qg.getDownloadUrl();
    }

    @Override // com.byazt.h.n
    public long qg() {
        return this.qg.getId();
    }

    @Override // com.byazt.h.n
    public boolean s() {
        return this.qg.isAd();
    }

    @Override // com.byazt.h.n
    public String q() {
        return this.qg.getLogExtra();
    }

    @Override // com.byazt.h.n
    public String l() {
        return this.qg.getPackageName();
    }

    @Override // com.byazt.h.n
    public String w() {
        if (this.qg.getDeepLink() != null) {
            return this.qg.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.byazt.h.n
    public JSONObject x() {
        return this.qg.getExtra();
    }

    @Override // com.byazt.h.n
    public int fs() {
        if (this.q.getDownloadMode() == 2) {
            return 2;
        }
        return this.qg.getFunnelType();
    }

    @Override // com.byazt.h.n
    public long d() {
        return this.qg.getExtraValue();
    }

    @Override // com.byazt.h.n
    public List<String> sz() {
        return this.qg.getClickTrackUrl();
    }

    @Override // com.byazt.h.n
    public String rv() {
        return this.s.getRefer();
    }

    @Override // com.byazt.h.n
    public String tj() {
        return this.s.getClickButtonTag();
    }

    @Override // com.byazt.h.n
    public JSONObject cp() {
        return this.s.getParamsJson();
    }

    @Override // com.byazt.h.n
    public boolean oa() {
        return this.s.isEnableV3Event();
    }

    @Override // com.byazt.h.n
    public Object k() {
        return this.s.getExtraEventObject();
    }

    @Override // com.byazt.h.n
    public JSONObject cy() {
        return this.s.getExtraJson();
    }

    @Override // com.byazt.h.n
    public boolean hd() {
        return this.q.enableNewActivity();
    }

    @Override // com.byazt.h.n
    public JSONObject cd() {
        return this.qg.getDownloadSettings();
    }

    @Override // com.byazt.h.n
    public DownloadModel py() {
        return this.qg;
    }

    @Override // com.byazt.h.n
    public DownloadEventConfig ou() {
        return this.s;
    }

    @Override // com.byazt.h.n
    public DownloadController wm() {
        return this.q;
    }

    @Override // com.byazt.h.n
    public int a() {
        return this.s.getDownloadScene();
    }
}
