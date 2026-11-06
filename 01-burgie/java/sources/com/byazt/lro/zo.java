package com.byazt.lro;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements w {
    public final ByteBuffer pr;

    public zo(ByteBuffer byteBuffer) {
        this.pr = byteBuffer.slice();
    }

    @Override // com.byazt.lro.w
    public long pr() {
        return this.pr.capacity();
    }

    @Override // com.byazt.lro.w
    public void pr(vk vkVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.pr) {
            this.pr.position(0);
            int i2 = (int) j;
            this.pr.limit(i + i2);
            this.pr.position(i2);
            byteBufferSlice = this.pr.slice();
        }
        vkVar.pr(byteBufferSlice);
    }
}
