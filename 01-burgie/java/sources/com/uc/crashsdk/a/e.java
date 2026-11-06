package com.uc.crashsdk.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Runnable {
    static final /* synthetic */ boolean a = true;
    private final int b;
    private final Object[] c;

    public e(int i) {
        this.b = i;
        this.c = null;
    }

    public e(int i, Object[] objArr) {
        this.b = i;
        this.c = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i == 10) {
            f.a(this.b, this.c);
            return;
        }
        if (i == 500) {
            d.a(this.b);
            return;
        }
        if (i == 700) {
            com.uc.crashsdk.f.b(this.b);
            return;
        }
        if (i != 800) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    com.uc.crashsdk.b.a(this.b);
                    return;
                default:
                    switch (i) {
                        case 201:
                        case 202:
                            com.uc.crashsdk.a.a(this.b);
                            return;
                        default:
                            switch (i) {
                                case 301:
                                case 302:
                                case 303:
                                    h.a(this.b, this.c);
                                    return;
                                default:
                                    switch (i) {
                                        case 401:
                                        case 402:
                                        case 403:
                                            break;
                                        default:
                                            switch (i) {
                                                case 405:
                                                case 406:
                                                case 407:
                                                case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                                case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                                case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                                case TTAdConstant.IMAGE_CODE /* 411 */:
                                                case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                                case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                                case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                                case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                                case 416:
                                                    break;
                                                default:
                                                    a.d("crashsdk", "Unknown async runnable: " + toString());
                                                    if (!a) {
                                                        throw new AssertionError();
                                                    }
                                                    return;
                                            }
                                            break;
                                    }
                                    com.uc.crashsdk.e.a(this.b, this.c);
                                    return;
                            }
                    }
            }
        }
        g.a(this.b);
    }

    public final boolean a() {
        int i = this.b;
        switch (i) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED /* 351 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT /* 352 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS /* 353 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY /* 354 */:
                return h.b(this.b, this.c);
            default:
                switch (i) {
                    case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME /* 451 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME /* 452 */:
                        return com.uc.crashsdk.e.b(this.b, this.c);
                    default:
                        switch (i) {
                            case 751:
                            case 752:
                            case 753:
                            case 754:
                            case 755:
                            case 756:
                                return com.uc.crashsdk.f.a(this.b, this.c);
                            default:
                                a.d("crashsdk", "Unknown sync runnable: " + toString());
                                if (a) {
                                    return false;
                                }
                                throw new AssertionError();
                        }
                }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.b;
    }
}
