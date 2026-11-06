package com.mar.sdk.utils;

import java.io.IOException;
import java.io.OutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class BASE64Encoder extends CharacterEncoder {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    @Override // com.mar.sdk.utils.CharacterEncoder
    protected int bytesPerAtom() {
        return 3;
    }

    @Override // com.mar.sdk.utils.CharacterEncoder
    protected int bytesPerLine() {
        return 57;
    }

    @Override // com.mar.sdk.utils.CharacterEncoder
    protected void encodeAtom(OutputStream outStream, byte[] data, int offset, int len) throws IOException {
        if (len == 1) {
            byte a = data[offset];
            outStream.write(pem_array[(a >>> 2) & 63]);
            outStream.write(pem_array[((a << 4) & 48) + 0]);
            outStream.write(61);
            outStream.write(61);
            return;
        }
        if (len == 2) {
            byte a2 = data[offset];
            byte b = data[offset + 1];
            outStream.write(pem_array[(a2 >>> 2) & 63]);
            outStream.write(pem_array[((a2 << 4) & 48) + ((b >>> 4) & 15)]);
            outStream.write(pem_array[((b << 2) & 60) + 0]);
            outStream.write(61);
            return;
        }
        byte a3 = data[offset];
        byte b2 = data[offset + 1];
        byte c = data[offset + 2];
        outStream.write(pem_array[(a3 >>> 2) & 63]);
        outStream.write(pem_array[((a3 << 4) & 48) + ((b2 >>> 4) & 15)]);
        outStream.write(pem_array[((b2 << 2) & 60) + ((c >>> 6) & 3)]);
        outStream.write(pem_array[c & 63]);
    }
}
