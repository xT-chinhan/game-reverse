package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ah implements DownloadEventConfig {
    private String ab;
    private String ah;
    private String ao;
    private String c;
    private String ch;
    private String d;
    private String h;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4321ms;
    private String ny;
    private Object sl;
    private boolean u;
    private boolean ub;
    private String x;
    private boolean xr;
    private boolean zb;

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public ah() {
    }

    private ah(ms msVar) {
        this.f4321ms = msVar.f4322ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c;
        this.ab = msVar.ab;
        this.x = msVar.x;
        this.ny = msVar.ny;
        this.ch = msVar.ch;
        this.hi = msVar.hi;
        this.sl = msVar.sl;
        this.zb = msVar.zb;
        this.u = msVar.u;
        this.ub = msVar.ub;
        this.ao = msVar.ao;
        this.h = msVar.h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f4321ms;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.ah;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.ka;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.ab;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.ch;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.sl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.xr;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.zb;
    }

    public static final class ms {
        private String ab;
        private String ah;
        private String ao;
        private String c;
        private String ch;
        private String d;
        private String h;
        private String hi;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4322ms;
        private String ny;
        private Object sl;
        private boolean u;
        private boolean ub;
        private String x;
        private boolean xr;
        private boolean zb;

        public ah ms() {
            return new ah(this);
        }
    }
}
