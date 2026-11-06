package com.anythink.core.common.n.b.a.b;

import com.anythink.core.common.n.b.ah;
import com.anythink.core.common.n.b.r;
import com.anythink.core.common.n.b.v;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class i {
    private final com.anythink.core.common.n.b.a a;
    private final g b;
    private final com.anythink.core.common.n.b.e c;
    private final r d;
    private List<Proxy> e;
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ah> h = new ArrayList();

    i(com.anythink.core.common.n.b.a aVar, g gVar, com.anythink.core.common.n.b.e eVar, r rVar) {
        List<Proxy> listA;
        this.e = Collections.emptyList();
        this.a = aVar;
        this.b = gVar;
        this.c = eVar;
        this.d = rVar;
        v vVarA = aVar.a();
        Proxy proxyH = aVar.h();
        if (proxyH != null) {
            listA = Collections.singletonList(proxyH);
        } else {
            List<Proxy> listSelect = aVar.g().select(vVarA.a());
            listA = (listSelect == null || listSelect.isEmpty()) ? com.anythink.core.common.n.b.a.c.a(Proxy.NO_PROXY) : com.anythink.core.common.n.b.a.c.a(listSelect);
        }
        this.e = listA;
        this.f = 0;
    }

    public final boolean a() {
        return c() || !this.h.isEmpty();
    }

    public final a b() throws SocketException, UnknownHostException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            if (!c()) {
                throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
            }
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                ah ahVar = new ah(this.a, proxy, this.g.get(i2));
                if (this.b.c(ahVar)) {
                    this.h.add(ahVar);
                } else {
                    arrayList.add(ahVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    private void a(v vVar, Proxy proxy) {
        List<Proxy> listA;
        if (proxy != null) {
            listA = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.a.g().select(vVar.a());
            listA = (listSelect == null || listSelect.isEmpty()) ? com.anythink.core.common.n.b.a.c.a(Proxy.NO_PROXY) : com.anythink.core.common.n.b.a.c.a(listSelect);
        }
        this.e = listA;
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws SocketException, UnknownHostException {
        if (!c()) {
            throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) throws SocketException, UnknownHostException {
        String strF;
        int iG;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strF = this.a.a().f();
            iG = this.a.a().g();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                strF = inetSocketAddress.getHostName();
            } else {
                strF = address.getHostAddress();
            }
            iG = inetSocketAddress.getPort();
        }
        if (iG <= 0 || iG > 65535) {
            throw new SocketException("No route to " + strF + ":" + iG + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(strF, iG));
            return;
        }
        List<InetAddress> listLookup = this.a.b().lookup(strF);
        if (listLookup.isEmpty()) {
            throw new UnknownHostException(this.a.b() + " returned no addresses for " + strF);
        }
        int size = listLookup.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(listLookup.get(i), iG));
        }
    }

    private static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class a {
        private final List<ah> a;
        private int b = 0;

        a(List<ah> list) {
            this.a = list;
        }

        public final boolean a() {
            return this.b < this.a.size();
        }

        public final ah b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<ah> list = this.a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }

        public final List<ah> c() {
            return new ArrayList(this.a);
        }
    }
}
