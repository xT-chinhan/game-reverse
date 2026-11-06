package com.byazt.go;

import com.byazt.tiu.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 37})
public class pr extends hn<com.byazt.tiu.hw> {
    public pr(com.byazt.eu.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.go.hn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.tiu.hw hw(com.byazt.eu.hw hwVar, aj.pr prVar) {
        return new com.byazt.tiu.hw(hwVar, prVar);
    }

    public static pr pr(final ByteBuffer byteBuffer) {
        return new pr(new com.byazt.eu.pr() { // from class: com.byazt.go.pr.1
            @Override // com.byazt.eu.pr
            public ByteBuffer pr() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
