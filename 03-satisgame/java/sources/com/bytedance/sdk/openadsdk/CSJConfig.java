package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 55, 56, 57, 1946})
public class CSJConfig implements AdConfig {
    private Map<String, Object> cp;
    private boolean cy;
    private TTCustomController d;
    private boolean fs;
    private IMediationConfig hd;
    private int k;
    private String l;
    private String n;
    private int oa;
    private String q;
    private String qg;
    private int[] rv;
    private boolean s;
    private int sz;
    private boolean tj;
    private int w;
    private boolean x;

    CSJConfig(n nVar) {
        this.s = false;
        this.w = 0;
        this.x = true;
        this.fs = false;
        this.tj = false;
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
        this.d = nVar.cp;
        this.oa = nVar.d;
        this.k = nVar.sz;
        this.sz = nVar.oa;
        this.cy = nVar.k;
        this.hd = nVar.cy;
        this.cp = nVar.hd;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.cp;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.qg;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.fs;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.rv;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.tj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.sz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.oa;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.hd;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.cy;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.cp;
    }

    public void setAppId(String str) {
        this.n = str;
    }

    public void setAppName(String str) {
        this.qg = str;
    }

    public void setPaid(boolean z) {
        this.s = z;
    }

    public void setKeywords(String str) {
        this.q = str;
    }

    public void setData(String str) {
        this.l = str;
    }

    public void setTitleBarTheme(int i) {
        this.w = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.x = z;
    }

    public void setDebug(boolean z) {
        this.fs = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.rv = iArr;
    }

    public void setSupportMultiProcess(boolean z) {
        this.tj = z;
    }

    public void setAgeGroup(int i) {
        this.k = i;
    }

    public void setThemeStatus(int i) {
        this.oa = i;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.d = tTCustomController;
    }

    @com.byazt.cp.n(n = {0, 55, 56, 57, 2164})
    static class n {
        private TTCustomController cp;
        private IMediationConfig cy;
        private int d;
        private boolean k;
        private String l;
        private String n;
        private String q;
        private String qg;
        private int[] rv;
        private boolean s = false;
        private int w = 0;
        private boolean x = true;
        private boolean fs = false;
        private boolean tj = false;
        private int oa = 2;
        private int sz = 0;
        private Map<String, Object> hd = null;

        n() {
        }

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n qg(String str) {
            this.qg = str;
            return this;
        }

        public n n(boolean z) {
            this.s = z;
            return this;
        }

        public n s(String str) {
            this.q = str;
            return this;
        }

        public n q(String str) {
            this.l = str;
            return this;
        }

        public n n(int i) {
            this.w = i;
            return this;
        }

        public n qg(boolean z) {
            this.x = z;
            return this;
        }

        public n s(boolean z) {
            this.fs = z;
            return this;
        }

        public n n(int... iArr) {
            this.rv = iArr;
            return this;
        }

        public n q(boolean z) {
            this.tj = z;
            return this;
        }

        public n n(TTCustomController tTCustomController) {
            this.cp = tTCustomController;
            return this;
        }

        public n qg(int i) {
            this.d = i;
            return this;
        }

        public n s(int i) {
            this.oa = i;
            return this;
        }

        public n q(int i) {
            this.sz = i;
            return this;
        }

        public n l(boolean z) {
            this.k = z;
            return this;
        }

        public n n(IMediationConfig iMediationConfig) {
            this.cy = iMediationConfig;
            return this;
        }

        public n n(String str, Object obj) {
            if (this.hd == null) {
                this.hd = new HashMap();
            }
            this.hd.put(str, obj);
            return this;
        }
    }
}
