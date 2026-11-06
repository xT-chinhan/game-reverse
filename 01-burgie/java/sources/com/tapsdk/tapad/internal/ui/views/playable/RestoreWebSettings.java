package com.tapsdk.tapad.internal.ui.views.playable;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class RestoreWebSettings {
    public final boolean enableDomStorage;
    public final boolean enableJavaScript;
    public final boolean mediaPlaybackRequiresUserGesture;
    public final int mixContentMode;

    public static class Builder {
        private boolean enableJavaScript = false;
        private boolean enableDomStorage = false;
        private boolean mediaPlaybackRequiresUserGesture = false;
        private int mixContentMode = -1;

        public RestoreWebSettings build() {
            return new RestoreWebSettings(this);
        }

        public Builder withEnableDomStorage(boolean z) {
            this.enableDomStorage = z;
            return this;
        }

        public Builder withEnableJavaScript(boolean z) {
            this.enableJavaScript = z;
            return this;
        }

        public Builder withMediaPlaybackRequiresUserGesture(boolean z) {
            this.mediaPlaybackRequiresUserGesture = z;
            return this;
        }

        public Builder withMixContentMode(int i) {
            this.mixContentMode = i;
            return this;
        }
    }

    public RestoreWebSettings(Builder builder) {
        this.enableJavaScript = builder.enableJavaScript;
        this.enableDomStorage = builder.enableDomStorage;
        this.mediaPlaybackRequiresUserGesture = builder.mediaPlaybackRequiresUserGesture;
        this.mixContentMode = builder.mixContentMode;
    }

    public String toString() {
        return "RestoreWebSettings{enableJavaScript=" + this.enableJavaScript + ", enableDomStorage=" + this.enableDomStorage + ", mediaPlaybackRequiresUserGesture=" + this.mediaPlaybackRequiresUserGesture + ", mixContentMode=" + this.mixContentMode + AbstractJsonLexerKt.END_OBJ;
    }
}
