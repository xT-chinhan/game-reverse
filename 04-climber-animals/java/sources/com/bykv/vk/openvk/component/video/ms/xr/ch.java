package com.bykv.vk.openvk.component.video.ms.xr;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ch extends ProxySelector {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final List<Proxy> f74ms = Collections.singletonList(Proxy.NO_PROXY);
    private final String ah;
    private final int d;
    private final ProxySelector xr = ProxySelector.getDefault();

    private ch(String str, int i) {
        this.ah = str;
        this.d = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.ah.equalsIgnoreCase(uri.getHost()) && this.d == uri.getPort()) ? f74ms : this.xr.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.xr.connectFailed(uri, socketAddress, iOException);
    }

    static void ms(String str, int i) {
        ProxySelector.setDefault(new ch(str, i));
    }
}
