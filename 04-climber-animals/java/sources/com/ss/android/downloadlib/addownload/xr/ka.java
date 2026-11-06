package com.ss.android.downloadlib.addownload.xr;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements com.ss.android.downloadad.api.ms.ms {
    public DownloadEventConfig ah;
    public DownloadController d;
    public com.ss.android.downloadad.api.ms.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public long f4454ms;
    public DownloadModel xr;

    @Override // com.ss.android.downloadad.api.ms.ms
    public int y() {
        return 0;
    }

    public ka() {
    }

    public ka(long j, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this.f4454ms = j;
        this.xr = downloadModel;
        this.ah = downloadEventConfig;
        this.d = downloadController;
    }

    public boolean i() {
        DownloadModel downloadModel;
        if (this.f4454ms == 0 || (downloadModel = this.xr) == null || this.ah == null || this.d == null) {
            return true;
        }
        return downloadModel.isAd() && this.f4454ms <= 0;
    }

    public boolean w() {
        if (i()) {
            return false;
        }
        if (this.xr.isAd()) {
            DownloadModel downloadModel = this.xr;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.ah instanceof AdDownloadEventConfig) && (this.d instanceof AdDownloadController);
        }
        return this.xr instanceof AdDownloadModel;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ms() {
        return this.xr.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public long xr() {
        return this.xr.getId();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean ah() {
        return this.xr.isAd();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String d() {
        return this.xr.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ka() {
        return this.xr.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String c() {
        if (this.xr.getDeepLink() != null) {
            return this.xr.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject ab() {
        return this.xr.getExtra();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public int x() {
        if (this.d.getDownloadMode() == 2) {
            return 2;
        }
        return this.xr.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public long sl() {
        return this.xr.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public List<String> u() {
        return this.xr.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ny() {
        return this.ah.getRefer();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public String ch() {
        return this.ah.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject hi() {
        return this.ah.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean zb() {
        return this.ah.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public Object ub() {
        return this.ah.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject ao() {
        return this.ah.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public boolean h() {
        return this.d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public JSONObject qv() {
        return this.xr.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadModel nw() {
        return this.xr;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadEventConfig b() {
        return this.ah;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public DownloadController re() {
        return this.d;
    }

    @Override // com.ss.android.downloadad.api.ms.ms
    public int t() {
        return this.ah.getDownloadScene();
    }
}
