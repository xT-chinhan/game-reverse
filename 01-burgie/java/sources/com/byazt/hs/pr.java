package com.byazt.hs;

import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 37})
public final class pr implements com.byazt.nq.pr.InterfaceC0144pr {
    public hw hw = new hw();
    public final com.byazt.nq.pr.InterfaceC0144pr pr;

    /* JADX INFO: renamed from: com.byazt.hs.pr$pr, reason: collision with other inner class name */
    private interface InterfaceC0090pr {
        void pr(String str, String str2);
    }

    public pr(com.byazt.nq.pr.InterfaceC0144pr interfaceC0144pr) {
        this.pr = interfaceC0144pr;
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void pr(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            pr(str, str2, new InterfaceC0090pr() { // from class: com.byazt.hs.pr.1
                @Override // com.byazt.hs.pr.InterfaceC0090pr
                public void pr(String str3, String str4) {
                    pr.this.pr.pr(str3, str4);
                }
            });
        } else {
            this.pr.pr(str, str2);
        }
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void hw(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            pr(str, str2, new InterfaceC0090pr() { // from class: com.byazt.hs.pr.2
                @Override // com.byazt.hs.pr.InterfaceC0090pr
                public void pr(String str3, String str4) {
                    pr.this.pr.hw(str3, str4);
                }
            });
        } else {
            this.pr.hw(str, str2);
        }
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void hn(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            pr(str, str2, new InterfaceC0090pr() { // from class: com.byazt.hs.pr.3
                @Override // com.byazt.hs.pr.InterfaceC0090pr
                public void pr(String str3, String str4) {
                    pr.this.pr.hn(str3, str4);
                }
            });
        } else {
            this.pr.hn(str, str2);
        }
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void x(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            pr(str, str2, new InterfaceC0090pr() { // from class: com.byazt.hs.pr.4
                @Override // com.byazt.hs.pr.InterfaceC0090pr
                public void pr(String str3, String str4) {
                    pr.this.pr.x(str3, str4);
                }
            });
        } else {
            this.pr.x(str, str2);
        }
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void pr(String str, String str2, Throwable th) {
        this.pr.pr(str, str2, th);
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void pr(String str, Throwable th) {
        this.pr.pr(str, th);
    }

    @Override // com.byazt.nq.pr.InterfaceC0144pr
    public void pr() {
        this.pr.pr();
    }

    private void pr(final String str, final String str2, final InterfaceC0090pr interfaceC0090pr) {
        try {
            if (zo.pr()) {
                zo.hw(new Runnable() { // from class: com.byazt.hs.pr.5
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw.pr(str, str2, interfaceC0090pr);
                    }
                });
            } else {
                this.hw.pr(str, str2, interfaceC0090pr);
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private class hw {
        private hw() {
        }

        public void pr(String str, String str2, InterfaceC0090pr interfaceC0090pr) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0090pr.pr(pr(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String pr(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }
}
