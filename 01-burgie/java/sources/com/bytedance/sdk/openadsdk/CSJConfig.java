package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 78, 79, 80, 1786})
public class CSJConfig implements AdConfig {
    private int[] aj;
    private String c;
    private boolean fw;
    private int g;
    private boolean hn;
    private int ho;
    private String hw;
    private TTCustomController k;
    private int m;
    private boolean nt;
    private String pr;
    private int uc;
    private boolean vk;
    private Map<String, Object> w;
    private String x;
    private IMediationConfig yb;
    private boolean zo;

    CSJConfig(pr prVar) {
        this.hn = false;
        this.uc = 0;
        this.fw = true;
        this.zo = false;
        this.vk = false;
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
        this.k = prVar.w;
        this.m = prVar.k;
        this.ho = prVar.g;
        this.g = prVar.m;
        this.nt = prVar.ho;
        this.yb = prVar.nt;
        this.w = prVar.yb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.w;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.pr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.hw;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.hn;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.uc;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.fw;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.zo;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.aj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.vk;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.ho;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.yb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.nt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.w;
    }

    public void setAppId(String str) {
        this.pr = str;
    }

    public void setAppName(String str) {
        this.hw = str;
    }

    public void setPaid(boolean z) {
        this.hn = z;
    }

    public void setKeywords(String str) {
        this.x = str;
    }

    public void setData(String str) {
        this.c = str;
    }

    public void setTitleBarTheme(int i) {
        this.uc = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.fw = z;
    }

    public void setDebug(boolean z) {
        this.zo = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.aj = iArr;
    }

    public void setSupportMultiProcess(boolean z) {
        this.vk = z;
    }

    public void setAgeGroup(int i) {
        this.ho = i;
    }

    public void setThemeStatus(int i) {
        this.m = i;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.k = tTCustomController;
    }

    @com.byazt.vzx.pr(pr = {0, 78, 79, 80, 1077})
    static class pr {
        private int[] aj;
        private String c;
        private boolean ho;
        private String hw;
        private int k;
        private IMediationConfig nt;
        private String pr;
        private TTCustomController w;
        private String x;
        private boolean hn = false;
        private int uc = 0;
        private boolean fw = true;
        private boolean zo = false;
        private boolean vk = false;
        private int m = 2;
        private int g = 0;
        private Map<String, Object> yb = null;

        pr() {
        }

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            this.hw = str;
            return this;
        }

        public pr pr(boolean z) {
            this.hn = z;
            return this;
        }

        public pr hn(String str) {
            this.x = str;
            return this;
        }

        public pr x(String str) {
            this.c = str;
            return this;
        }

        public pr pr(int i) {
            this.uc = i;
            return this;
        }

        public pr hw(boolean z) {
            this.fw = z;
            return this;
        }

        public pr hn(boolean z) {
            this.zo = z;
            return this;
        }

        public pr pr(int... iArr) {
            this.aj = iArr;
            return this;
        }

        public pr x(boolean z) {
            this.vk = z;
            return this;
        }

        public pr pr(TTCustomController tTCustomController) {
            this.w = tTCustomController;
            return this;
        }

        public pr hw(int i) {
            this.k = i;
            return this;
        }

        public pr hn(int i) {
            this.m = i;
            return this;
        }

        public pr x(int i) {
            this.g = i;
            return this;
        }

        public pr c(boolean z) {
            this.ho = z;
            return this;
        }

        public pr pr(IMediationConfig iMediationConfig) {
            this.nt = iMediationConfig;
            return this;
        }

        public pr pr(String str, Object obj) {
            if (this.yb == null) {
                this.yb = new HashMap();
            }
            this.yb.put(str, obj);
            return this;
        }
    }
}
