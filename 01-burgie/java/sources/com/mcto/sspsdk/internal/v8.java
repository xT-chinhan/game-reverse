package com.mcto.sspsdk.internal;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class v8 extends ld {
    public final /* synthetic */ x8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v8(x8 x8Var, long j) {
        super(j);
        this.f = x8Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        long j2 = j / 1000;
        if (j2 > 0) {
            this.f.f.setText(String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        }
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.destroy();
    }
}
