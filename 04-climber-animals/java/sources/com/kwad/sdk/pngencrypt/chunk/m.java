package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends p {
    private int aWn;
    private int[] aWo;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aWn = 0;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        ex(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.aWn) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            a(i, dVar.data[i2] & UByte.MAX_VALUE, dVar.data[i3] & UByte.MAX_VALUE, dVar.data[i4] & UByte.MAX_VALUE);
            i++;
            i2 = i4 + 1;
        }
    }

    private void ex(int i) {
        this.aWn = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.aWn);
        }
        int[] iArr = this.aWo;
        if (iArr == null || iArr.length != i) {
            this.aWo = new int[i];
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.aWo[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
