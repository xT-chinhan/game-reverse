package com.anythink.core.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ATNetworkConfig {
    List<ATInitConfig> mATInitConfigList;

    public List<ATInitConfig> getATInitConfigList() {
        return this.mATInitConfigList;
    }

    public static class Builder {
        List<ATInitConfig> mATInitConfigs;

        public Builder withInitConfigList(List<ATInitConfig> list) {
            this.mATInitConfigs = list;
            return this;
        }

        public ATNetworkConfig build() {
            ATNetworkConfig aTNetworkConfig = new ATNetworkConfig();
            aTNetworkConfig.mATInitConfigList = this.mATInitConfigs;
            return aTNetworkConfig;
        }
    }
}
