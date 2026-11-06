package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
public final class y {
    public final InetSocketAddress hn;
    public final Proxy hw;
    public final pr pr;

    public y(pr prVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (prVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.pr = prVar;
        this.hw = proxy;
        this.hn = inetSocketAddress;
    }

    public pr pr() {
        return this.pr;
    }

    public Proxy hw() {
        return this.hw;
    }

    public InetSocketAddress hn() {
        return this.hn;
    }

    public boolean x() {
        return this.pr.aj != null && this.hw.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return yVar.pr.equals(this.pr) && yVar.hw.equals(this.hw) && yVar.hn.equals(this.hn);
    }

    public int hashCode() {
        return ((((this.pr.hashCode() + 527) * 31) + this.hw.hashCode()) * 31) + this.hn.hashCode();
    }

    public String toString() {
        return "Route{" + this.hn + "}";
    }
}
