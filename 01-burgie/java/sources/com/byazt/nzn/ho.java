package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 19})
public class ho {
    public byte[] c;
    public vk hn;
    public String hw;
    public String pr;
    public pr uc;
    public String x;

    public enum pr {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public ho() {
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public ho(vk vkVar, String str, pr prVar) {
        this.hn = vkVar;
        this.x = str;
        this.uc = prVar;
    }

    public ho(vk vkVar, byte[] bArr, String str, String str2, pr prVar) {
        this.hn = vkVar;
        this.c = bArr;
        this.hw = str;
        this.pr = str2;
        this.uc = prVar;
    }

    public ho(vk vkVar, byte[] bArr, pr prVar) {
        this.hn = vkVar;
        this.c = bArr;
        this.uc = prVar;
    }

    public static ho pr(vk vkVar, String str) {
        return new ho(vkVar, str, pr.STRING_TYPE);
    }

    public static ho pr(vk vkVar, byte[] bArr) {
        return new ho(vkVar, bArr, pr.BYTE_ARRAY_TYPE);
    }

    public static ho pr(vk vkVar, byte[] bArr, String str, String str2) {
        return new ho(vkVar, bArr, str, str2, pr.FILE_TYPE);
    }
}
