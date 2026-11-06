package com.byazt.cxa;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 228, 13})
public class hw {
    public View aj;
    public String c;
    public Drawable fw;
    public String hn;
    public String hw;
    public Context pr;
    public boolean uc;
    public int vk;
    public String x;
    public InterfaceC0036hw zo;

    /* JADX INFO: renamed from: com.byazt.cxa.hw$hw, reason: collision with other inner class name */
    public interface InterfaceC0036hw {
        void hn(DialogInterface dialogInterface);

        void hw(DialogInterface dialogInterface);

        void pr(DialogInterface dialogInterface);
    }

    private hw(pr prVar) {
        this.uc = true;
        this.pr = prVar.hn;
        this.hw = prVar.x;
        this.hn = prVar.c;
        this.x = prVar.uc;
        this.c = prVar.fw;
        this.uc = prVar.zo;
        this.fw = prVar.aj;
        this.zo = prVar.vk;
        this.aj = prVar.pr;
        this.vk = prVar.hw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 228, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public Drawable aj;
        public String c;
        public String fw;
        public Context hn;
        public int hw;
        public View pr;
        public String uc;
        public InterfaceC0036hw vk;
        public String x;
        public boolean zo;

        public pr(Context context) {
            this.hn = context;
        }

        public pr pr(String str) {
            this.x = str;
            return this;
        }

        public pr hw(String str) {
            this.c = str;
            return this;
        }

        public pr hn(String str) {
            this.uc = str;
            return this;
        }

        public pr x(String str) {
            this.fw = str;
            return this;
        }

        public pr pr(boolean z) {
            this.zo = z;
            return this;
        }

        public pr pr(Drawable drawable) {
            this.aj = drawable;
            return this;
        }

        public pr pr(InterfaceC0036hw interfaceC0036hw) {
            this.vk = interfaceC0036hw;
            return this;
        }

        public pr pr(int i) {
            this.hw = i;
            return this;
        }

        public hw pr() {
            return new hw(this);
        }
    }
}
