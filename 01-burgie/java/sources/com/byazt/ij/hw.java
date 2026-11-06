package com.byazt.ij;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, 13})
public class hw {
    public boolean pr = false;
    public int hw = -1;
    public String hn = null;
    public ValueSet x = null;

    private hw() {
    }

    public static final hw pr() {
        return new hw();
    }

    public hw pr(boolean z) {
        this.pr = z;
        return this;
    }

    public hw pr(int i) {
        this.hw = i;
        return this;
    }

    public hw pr(String str) {
        this.hn = str;
        return this;
    }

    public hw pr(ValueSet valueSet) {
        this.x = valueSet;
        return this;
    }

    public Result hw() {
        boolean z = this.pr;
        int i = this.hw;
        String str = this.hn;
        ValueSet valueSetHw = this.x;
        if (valueSetHw == null) {
            valueSetHw = hn.pr().hw();
        }
        return new pr(z, i, str, valueSetHw);
    }

    @com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static final class pr implements Result {
        public final String hn;
        public final int hw;
        public final boolean pr;
        public final ValueSet x;

        private pr(boolean z, int i, String str, ValueSet valueSet) {
            this.pr = z;
            this.hw = i;
            this.hn = str;
            this.x = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.pr;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.hw;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.hn;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.x;
        }
    }
}
