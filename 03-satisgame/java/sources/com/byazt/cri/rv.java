package com.byazt.cri;

import com.byazt.pq.h;
import com.byazt.pq.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public static String n(h hVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(hVar.qg());
        sb.append(' ');
        if (qg(hVar, type)) {
            sb.append(hVar.n());
        } else {
            sb.append(n(hVar.n()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean qg(h hVar, Proxy.Type type) {
        return !hVar.rv() && type == Proxy.Type.HTTP;
    }

    public static String n(um umVar) {
        String strFs = umVar.fs();
        try {
            String strTj = umVar.tj();
            if (strTj != null) {
                return strFs + '?' + strTj;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strFs;
    }
}
