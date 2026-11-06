package com.anythink.core.api;

/* JADX INFO: loaded from: classes.dex */
public class ATAdCreateConfig {
    private boolean isMultiton;

    private ATAdCreateConfig() {
    }

    public boolean isMultiton() {
        return this.isMultiton;
    }

    public static class Builder {
        ATAdCreateConfig config = new ATAdCreateConfig();

        public Builder setMultiton(boolean z) {
            this.config.isMultiton = z;
            return this;
        }

        public ATAdCreateConfig build() {
            return this.config;
        }
    }
}
