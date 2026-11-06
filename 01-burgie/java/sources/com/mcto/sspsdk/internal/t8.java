package com.mcto.sspsdk.internal;

import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class t8 extends ld {
    public final /* synthetic */ u8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(u8 u8Var, long j) {
        super(j);
        this.f = u8Var;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        TextView textView;
        u8 u8Var = this.f;
        if (u8Var.v != 0 || (textView = u8Var.f) == null) {
            return;
        }
        textView.setText(String.format(Locale.CHINA, "%d秒后自动放弃", Long.valueOf(j / 1000)));
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.f.destroy();
    }
}
