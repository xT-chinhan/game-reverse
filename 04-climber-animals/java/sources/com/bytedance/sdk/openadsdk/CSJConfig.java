package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CSJConfig implements AdConfig {
    private boolean ab;
    private boolean ah;
    private boolean ao;
    private int c;
    private boolean ch;
    private String d;
    private IMediationConfig h;
    private Map<String, Object> hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1633ms;
    private int[] ny;
    private TTCustomController sl;
    private int u;
    private int ub;
    private boolean x;
    private String xr;
    private int zb;

    CSJConfig(ms msVar) {
        this.ah = false;
        this.c = 0;
        this.ab = true;
        this.x = false;
        this.ch = false;
        this.f1633ms = msVar.f1634ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c;
        this.ab = msVar.ab;
        this.x = msVar.x;
        this.ny = msVar.ny;
        this.ch = msVar.ch;
        this.sl = msVar.hi;
        this.zb = msVar.sl;
        this.ub = msVar.u;
        this.u = msVar.zb;
        this.ao = msVar.ub;
        this.h = msVar.ao;
        this.hi = msVar.h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.hi;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f1633ms;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.sl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.ub;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.ao;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.hi;
    }

    public void setAppId(String str) {
        this.f1633ms = str;
    }

    public void setAppName(String str) {
        this.xr = str;
    }

    public void setPaid(boolean z) {
        this.ah = z;
    }

    public void setKeywords(String str) {
        this.d = str;
    }

    public void setData(String str) {
        this.ka = str;
    }

    public void setTitleBarTheme(int i) {
        this.c = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.ab = z;
    }

    public void setDebug(boolean z) {
        this.x = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.ny = iArr;
    }

    public void setSupportMultiProcess(boolean z) {
        this.ch = z;
    }

    public void setAgeGroup(int i) {
        this.ub = i;
    }

    public void setThemeStatus(int i) {
        this.zb = i;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.sl = tTCustomController;
    }

    static class ms {
        private IMediationConfig ao;
        private String d;
        private TTCustomController hi;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f1634ms;
        private int[] ny;
        private int sl;
        private boolean ub;
        private String xr;
        private boolean ah = false;
        private int c = 0;
        private boolean ab = true;
        private boolean x = false;
        private boolean ch = false;
        private int zb = 2;
        private int u = 0;
        private Map<String, Object> h = null;

        ms() {
        }

        public ms ms(String str) {
            this.f1634ms = str;
            return this;
        }

        public ms xr(String str) {
            this.xr = str;
            return this;
        }

        public ms ms(boolean z) {
            this.ah = z;
            return this;
        }

        public ms ah(String str) {
            this.d = str;
            return this;
        }

        public ms d(String str) {
            this.ka = str;
            return this;
        }

        public ms ms(int i) {
            this.c = i;
            return this;
        }

        public ms xr(boolean z) {
            this.ab = z;
            return this;
        }

        public ms ah(boolean z) {
            this.x = z;
            return this;
        }

        public ms ms(int... iArr) {
            this.ny = iArr;
            return this;
        }

        public ms d(boolean z) {
            this.ch = z;
            return this;
        }

        public ms ms(TTCustomController tTCustomController) {
            this.hi = tTCustomController;
            return this;
        }

        public ms xr(int i) {
            this.sl = i;
            return this;
        }

        public ms ah(int i) {
            this.zb = i;
            return this;
        }

        public ms d(int i) {
            this.u = i;
            return this;
        }

        public ms ka(boolean z) {
            this.ub = z;
            return this;
        }

        public ms ms(IMediationConfig iMediationConfig) {
            this.ao = iMediationConfig;
            return this;
        }

        public ms ms(String str, Object obj) {
            if (this.h == null) {
                this.h = new HashMap();
            }
            this.h.put(str, obj);
            return this;
        }
    }
}
