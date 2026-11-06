package com.tapsdk.tapad.internal.oaid;

/* JADX INFO: loaded from: classes2.dex */
public final class OaidSnapshot {
    private final String developerOaid;
    private final String manufacturerOaid;
    private final String msaOaid;

    public OaidSnapshot(String str, String str2, String str3) {
        this.developerOaid = safe(str);
        this.msaOaid = safe(str2);
        this.manufacturerOaid = safe(str3);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public String getDeveloperOaid() {
        return this.developerOaid;
    }

    public String getManufacturerOaid() {
        return this.manufacturerOaid;
    }

    public String getMsaOaid() {
        return this.msaOaid;
    }

    public OaidSnapshot withDeveloperOaid(String str) {
        return new OaidSnapshot(str, this.msaOaid, this.manufacturerOaid);
    }

    public OaidSnapshot withProviderOaids(String str, String str2) {
        return new OaidSnapshot(this.developerOaid, str, str2);
    }
}
