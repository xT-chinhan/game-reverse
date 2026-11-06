package com.anythink.core.api;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public interface ATGDPRConsentDismissListener {
    void onDismiss(ConsentDismissInfo consentDismissInfo);

    public static class ConsentDismissInfo {
        private int dismissType;
        private String infoMsg;

        public ConsentDismissInfo(String str, int i) {
            this.infoMsg = str;
            this.dismissType = i;
        }

        public String getInfoMsg() {
            return this.infoMsg;
        }

        public int getDismissType() {
            return this.dismissType;
        }

        public String toString() {
            return "ConsentDismissInfo{infoMsg='" + this.infoMsg + "', dismissType=" + this.dismissType + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
