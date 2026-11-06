package com.kwad.sdk.utils.b;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public int bcQ = -1;
    public int bcR = -1;
    public int bcS = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.bcQ + ", getFailedCount=" + this.bcR + ", getSuccessCount=" + this.bcS + AbstractJsonLexerKt.END_OBJ;
    }
}
