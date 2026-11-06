package com.anythink.core.common.l.b;

import com.anythink.core.common.m.b.e;
import com.anythink.core.common.m.b.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public class c extends r {
    public static final c a = new c();
    private static final String c = "c";

    private c() {
    }

    @Override // com.anythink.core.common.m.b.r
    public final void a(e eVar, InetSocketAddress inetSocketAddress) {
        if (eVar == null || inetSocketAddress == null || inetSocketAddress.getAddress() == null) {
            return;
        }
        String strA = a(eVar);
        String hostAddress = inetSocketAddress.getAddress().getHostAddress();
        if (strA == null || hostAddress == null) {
            return;
        }
        b.a().a(strA, hostAddress);
    }

    @Override // com.anythink.core.common.m.b.r
    public final void a(e eVar, InetSocketAddress inetSocketAddress, IOException iOException) {
        if (eVar == null || inetSocketAddress == null || inetSocketAddress.getAddress() == null) {
            return;
        }
        if (iOException instanceof SSLException ? false : iOException instanceof SocketException) {
            String strA = a(eVar);
            String hostAddress = inetSocketAddress.getAddress().getHostAddress();
            if (strA == null || hostAddress == null || !b.a().b(strA, hostAddress)) {
                return;
            }
            com.anythink.core.common.l.a.a.e.a().b();
        }
    }

    private static boolean a(IOException iOException) {
        if (iOException == null || (iOException instanceof SSLException)) {
            return false;
        }
        return iOException instanceof SocketException;
    }

    private static String a(e eVar) {
        try {
            return eVar.a().a().f();
        } catch (Throwable unused) {
            return null;
        }
    }
}
