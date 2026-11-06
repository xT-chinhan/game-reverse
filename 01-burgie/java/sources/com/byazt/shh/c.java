package com.byazt.shh;

import android.text.TextUtils;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.km.AdDownloadController;
import com.byazt.km.AdDownloadEventConfig;
import com.byazt.km.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.tia.pr {
    public com.byazt.tia.hw c;
    public DownloadEventConfig hn;
    public DownloadModel hw;
    public long pr;
    public DownloadController x;

    public c() {
    }

    public c(long j, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this.pr = j;
        this.hw = downloadModel;
        this.hn = downloadEventConfig;
        this.x = downloadController;
    }

    public boolean rc() {
        DownloadModel downloadModel;
        if (this.pr == 0 || (downloadModel = this.hw) == null || this.hn == null || this.x == null) {
            return true;
        }
        return downloadModel.isAd() && this.pr <= 0;
    }

    public boolean z() {
        if (rc()) {
            return false;
        }
        if (this.hw.isAd()) {
            DownloadModel downloadModel = this.hw;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.hn instanceof AdDownloadEventConfig) && (this.x instanceof AdDownloadController);
        }
        return this.hw instanceof AdDownloadModel;
    }

    @Override // com.byazt.tia.pr
    public String pr() {
        return this.hw.getDownloadUrl();
    }

    @Override // com.byazt.tia.pr
    public long hw() {
        return this.hw.getId();
    }

    @Override // com.byazt.tia.pr
    public boolean hn() {
        return this.hw.isAd();
    }

    @Override // com.byazt.tia.pr
    public String x() {
        return this.hw.getLogExtra();
    }

    @Override // com.byazt.tia.pr
    public String c() {
        return this.hw.getPackageName();
    }

    @Override // com.byazt.tia.pr
    public String uc() {
        if (this.hw.getDeepLink() != null) {
            return this.hw.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.byazt.tia.pr
    public JSONObject fw() {
        return this.hw.getExtra();
    }

    @Override // com.byazt.tia.pr
    public int zo() {
        if (this.x.getDownloadMode() == 2) {
            return 2;
        }
        return this.hw.getFunnelType();
    }

    @Override // com.byazt.tia.pr
    public long k() {
        return this.hw.getExtraValue();
    }

    @Override // com.byazt.tia.pr
    public List<String> g() {
        return this.hw.getClickTrackUrl();
    }

    @Override // com.byazt.tia.pr
    public String aj() {
        return this.hn.getRefer();
    }

    @Override // com.byazt.tia.pr
    public String vk() {
        return this.hn.getClickButtonTag();
    }

    @Override // com.byazt.tia.pr
    public JSONObject w() {
        return this.hn.getParamsJson();
    }

    @Override // com.byazt.tia.pr
    public boolean m() {
        return this.hn.isEnableV3Event();
    }

    @Override // com.byazt.tia.pr
    public Object ho() {
        return this.hn.getExtraEventObject();
    }

    @Override // com.byazt.tia.pr
    public JSONObject nt() {
        return this.hn.getExtraJson();
    }

    @Override // com.byazt.tia.pr
    public boolean yb() {
        return this.x.enableNewActivity();
    }

    @Override // com.byazt.tia.pr
    public JSONObject lb() {
        return this.hw.getDownloadSettings();
    }

    @Override // com.byazt.tia.pr
    public int qa() {
        return 0;
    }

    @Override // com.byazt.tia.pr
    public DownloadModel cz() {
        return this.hw;
    }

    @Override // com.byazt.tia.pr
    public DownloadEventConfig ny() {
        return this.hn;
    }

    @Override // com.byazt.tia.pr
    public DownloadController fo() {
        return this.x;
    }

    @Override // com.byazt.tia.pr
    public int a() {
        return this.hn.getDownloadScene();
    }
}
