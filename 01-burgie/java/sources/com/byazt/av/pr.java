package com.byazt.av;

import com.taptap.sdk.compliance.constants.ComplianceMessage;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 37})
public class pr implements com.byazt.mqu.pr {
    public final boolean c;
    public final String fw;
    public final String hn;
    public final int hw;
    public final boolean pr;
    public final Throwable uc;
    public final String x;
    public boolean zo;

    public pr(boolean z, int i, String str, boolean z2, String str2) {
        this(z, i, str, z2, str2, null, "");
    }

    public pr(boolean z, int i, String str, boolean z2, String str2, Throwable th) {
        this(z, i, str, z2, str2, th, "");
    }

    public pr(boolean z, int i, String str, boolean z2, String str2, Throwable th, String str3) {
        this.pr = z;
        this.hw = i;
        this.hn = str;
        this.c = z2;
        this.x = str2;
        this.uc = th;
        this.fw = str3 == null ? "" : str3;
    }

    @Override // com.byazt.mqu.pr
    public boolean uc() {
        return this.zo;
    }

    public void pr(boolean z) {
        this.zo = z;
    }

    @Override // com.byazt.mqu.pr
    public boolean pr() {
        return this.pr;
    }

    @Override // com.byazt.mqu.pr
    public int hw() {
        return this.hw;
    }

    @Override // com.byazt.mqu.pr
    public String hn() {
        return this.hn;
    }

    @Override // com.byazt.mqu.pr
    public String x() {
        return this.x;
    }

    @Override // com.byazt.mqu.pr
    public boolean c() {
        return this.c;
    }
}
