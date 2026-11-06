package com.byazt.lp;

import com.byazt.jv.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 13})
public final class hw extends c {
    public final Method hw;
    public final Method pr;

    public hw(Method method, Method method2) {
        this.pr = method;
        this.hw = method2;
    }

    @Override // com.byazt.lp.c
    public void pr(SSLSocket sSLSocket, String str, List<rc> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listPr = pr(list);
            this.pr.invoke(sSLParameters, listPr.toArray(new String[listPr.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.xx.hn.pr("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.byazt.lp.c
    public String pr(SSLSocket sSLSocket) {
        try {
            String str = (String) this.hw.invoke(sSLSocket, new Object[0]);
            if (str == null || str.isEmpty()) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.xx.hn.pr("unable to get selected protocols", (Exception) e);
        }
    }

    public static hw pr() {
        try {
            return new hw(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
