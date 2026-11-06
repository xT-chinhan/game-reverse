package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public abstract class t {
    public abstract py n();

    public abstract void n(com.byazt.wa.q qVar) throws IOException;

    public long qg() throws IOException {
        return -1L;
    }

    public static t n(py pyVar, String str) {
        Charset charsetS = com.byazt.zho.s.l;
        if (pyVar != null && (charsetS = pyVar.s()) == null) {
            charsetS = com.byazt.zho.s.l;
            pyVar = py.n(pyVar + "; charset=utf-8");
        }
        return n(pyVar, str.getBytes(charsetS));
    }

    public static t n(py pyVar, byte[] bArr) {
        return n(pyVar, bArr, 0, bArr.length);
    }

    public static t n(final py pyVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.byazt.zho.s.n(bArr.length, i, i2);
        return new t() { // from class: com.byazt.pq.t.1
            @Override // com.byazt.pq.t
            public py n() {
                return pyVar;
            }

            @Override // com.byazt.pq.t
            public long qg() {
                return i2;
            }

            @Override // com.byazt.pq.t
            public void n(com.byazt.wa.q qVar) throws IOException {
                qVar.s(bArr, i, i2);
            }
        };
    }
}
