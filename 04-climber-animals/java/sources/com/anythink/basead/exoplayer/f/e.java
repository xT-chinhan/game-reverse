package com.anythink.basead.exoplayer.f;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private e() {
    }

    private static void a(MediaFormat mediaFormat, String str, String str2) {
        mediaFormat.setString(str, str2);
    }

    public static void a(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    private static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    private static void a(MediaFormat mediaFormat, com.anythink.basead.exoplayer.l.b bVar) {
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.c);
            a(mediaFormat, "color-standard", bVar.a);
            a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
    }
}
