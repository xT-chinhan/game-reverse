package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.QyImage;

/* JADX INFO: loaded from: classes2.dex */
public final class sd extends QyImage {
    public final String a;

    public sd(String str) {
        this.a = str;
    }

    @Override // com.mcto.sspsdk.QyImage
    public final String getHttpUrl() {
        return this.a;
    }
}
