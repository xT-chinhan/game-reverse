package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 166})
public abstract class iu {
    public abstract cz pr();

    public abstract void pr(com.byazt.du.x xVar) throws IOException;

    public long hw() throws IOException {
        return -1L;
    }

    public static iu pr(cz czVar, String str) {
        Charset charsetHn = com.byazt.xx.hn.c;
        if (czVar != null && (charsetHn = czVar.hn()) == null) {
            charsetHn = com.byazt.xx.hn.c;
            czVar = cz.pr(czVar + "; charset=utf-8");
        }
        return pr(czVar, str.getBytes(charsetHn));
    }

    public static iu pr(cz czVar, byte[] bArr) {
        return pr(czVar, bArr, 0, bArr.length);
    }

    public static iu pr(final cz czVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.byazt.xx.hn.pr(bArr.length, i, i2);
        return new iu() { // from class: com.byazt.jv.iu.1
            @Override // com.byazt.jv.iu
            public cz pr() {
                return czVar;
            }

            @Override // com.byazt.jv.iu
            public long hw() {
                return i2;
            }

            @Override // com.byazt.jv.iu
            public void pr(com.byazt.du.x xVar) throws IOException {
                xVar.hn(bArr, i, i2);
            }
        };
    }
}
