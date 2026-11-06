package com.byazt.yi;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 61})
public class aj {
    public vk c;
    public String hn;
    public String hw;
    public Context pr;
    public boolean x;

    public Context pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public boolean hn() {
        return this.x;
    }

    public vk x() {
        return this.c;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 586, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr {
        public final String hn;
        public final String hw;
        public final Context pr;
        public boolean x = false;
        public vk c = null;

        public pr(Context context, String str, String str2) {
            this.pr = context;
            this.hn = str2;
            this.hw = str;
        }

        public void pr(vk vkVar) {
            this.c = vkVar;
        }

        public pr pr(boolean z) {
            this.x = z;
            return this;
        }

        public aj pr() {
            aj ajVar = new aj();
            ajVar.pr = this.pr;
            ajVar.hw = this.hw;
            ajVar.hn = this.hn;
            ajVar.c = this.c;
            ajVar.x = this.x;
            return ajVar;
        }
    }
}
