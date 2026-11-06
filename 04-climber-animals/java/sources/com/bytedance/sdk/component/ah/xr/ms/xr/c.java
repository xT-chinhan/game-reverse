package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.of;
import com.bytedance.sdk.component.ah.xr.y;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final com.bytedance.sdk.component.ah.xr.ka ah;
    private int c;
    private final ao d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.component.ah.xr.ms f1126ms;
    private final d xr;
    private List<Proxy> ka = Collections.emptyList();
    private List<InetSocketAddress> ab = Collections.emptyList();
    private final List<of> x = new ArrayList();

    public c(com.bytedance.sdk.component.ah.xr.ms msVar, d dVar, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar) throws IOException {
        this.f1126ms = msVar;
        this.xr = dVar;
        this.ah = kaVar;
        this.d = aoVar;
        ms(msVar.ms(), msVar.x());
    }

    public boolean ms() {
        return ah() || !this.x.isEmpty();
    }

    public ms xr() throws IOException {
        if (!ms()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (ah()) {
            Proxy proxyD = d();
            int size = this.ab.size();
            for (int i = 0; i < size; i++) {
                of ofVar = new of(this.f1126ms, proxyD, this.ab.get(i));
                if (this.xr.ah(ofVar)) {
                    this.x.add(ofVar);
                } else {
                    arrayList.add(ofVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.x);
            this.x.clear();
        }
        return new ms(arrayList);
    }

    public void ms(of ofVar, IOException iOException) {
        if (ofVar.xr().type() != Proxy.Type.DIRECT && this.f1126ms.ab() != null) {
            this.f1126ms.ab().connectFailed(this.f1126ms.ms().xr(), ofVar.xr().address(), iOException);
        }
        this.xr.ms(ofVar);
    }

    private void ms(y yVar, Proxy proxy) throws IOException {
        List<Proxy> listMs;
        if (proxy != null) {
            this.ka = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.f1126ms.ab().select(yVar.xr());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(listSelect);
                } else {
                    listMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(Proxy.NO_PROXY);
                }
                this.ka = listMs;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.c = 0;
    }

    private boolean ah() {
        return this.c < this.ka.size();
    }

    private Proxy d() throws IOException {
        if (!ah()) {
            throw new SocketException("No route to " + this.f1126ms.ms().ab() + "; exhausted proxy configurations: " + this.ka);
        }
        List<Proxy> list = this.ka;
        int i = this.c;
        this.c = i + 1;
        Proxy proxy = list.get(i);
        ms(proxy);
        return proxy;
    }

    private void ms(Proxy proxy) throws IOException {
        String strAb;
        int iX;
        this.ab = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strAb = this.f1126ms.ms().ab();
            iX = this.f1126ms.ms().x();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strAb = ms(inetSocketAddress);
            iX = inetSocketAddress.getPort();
        }
        if (iX <= 0 || iX > 65535) {
            throw new SocketException("No route to " + strAb + ":" + iX + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.ab.add(InetSocketAddress.createUnresolved(strAb, iX));
            return;
        }
        List<InetAddress> listMs = this.f1126ms.xr().ms(strAb);
        if (listMs.isEmpty()) {
            return;
        }
        int size = listMs.size();
        for (int i = 0; i < size; i++) {
            this.ab.add(new InetSocketAddress(listMs.get(i), iX));
        }
    }

    static String ms(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final List<of> f1127ms;
        private int xr = 0;

        ms(List<of> list) {
            this.f1127ms = list;
        }

        public boolean ms() {
            return this.xr < this.f1127ms.size();
        }

        public of xr() {
            if (!ms()) {
                throw new NoSuchElementException();
            }
            List<of> list = this.f1127ms;
            int i = this.xr;
            this.xr = i + 1;
            return list.get(i);
        }

        public List<of> ah() {
            return new ArrayList(this.f1127ms);
        }
    }
}
