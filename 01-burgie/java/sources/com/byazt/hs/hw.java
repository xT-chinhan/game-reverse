package com.byazt.hs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 13})
public class hw implements com.byazt.utw.pr {
    public static hw pr = null;
    public com.byazt.nq.pr.InterfaceC0144pr hw;

    private hw() {
    }

    public com.byazt.nq.pr.InterfaceC0144pr pr() {
        return this.hw;
    }

    public static void pr(com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr, boolean z) {
        hw hwVar = new hw();
        pr = hwVar;
        if (z) {
            hwVar.hw = new pr(interfaceC0144pr);
        } else {
            hwVar.hw = interfaceC0144pr;
        }
    }

    public void hn(String str, String str2) {
        com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr = this.hw;
        if (interfaceC0144pr != null) {
            interfaceC0144pr.hw(str, str2);
        }
    }

    @Override // com.byazt.utw.pr
    public void pr(String str, String str2) {
        com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr = this.hw;
        if (interfaceC0144pr != null) {
            interfaceC0144pr.hn(str, str2);
        }
    }

    @Override // com.byazt.utw.pr
    public void hw(String str, String str2) {
        com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr = this.hw;
        if (interfaceC0144pr != null) {
            interfaceC0144pr.x(str, str2);
        }
    }

    @Override // com.byazt.utw.pr
    public void pr(String str, String str2, Throwable th) {
        com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr = this.hw;
        if (interfaceC0144pr != null) {
            interfaceC0144pr.pr(str, str2, th);
        }
    }

    @Override // com.byazt.utw.pr
    public void pr(String str, Throwable th) {
        com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr = this.hw;
        if (interfaceC0144pr != null) {
            interfaceC0144pr.pr(str, th);
        }
    }
}
