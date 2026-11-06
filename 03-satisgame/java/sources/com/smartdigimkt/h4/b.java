package com.smartdigimkt.h4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    public final String c;
    public final int d;

    public b(String str, int i) {
        this.d = 8;
        this.c = str;
        if (i == 1000) {
            this.d = 8;
        } else if (i == 1001) {
            this.d = 2;
        }
    }

    @Override // com.smartdigimkt.h4.d
    public final int a() {
        return this.d;
    }

    @Override // com.smartdigimkt.h4.d
    public final void a(int i, String str, String str2) {
    }

    @Override // com.smartdigimkt.h4.d
    public final byte[] b() {
        return !TextUtils.isEmpty(this.c) ? d.a(this.c) : new byte[0];
    }
}
