package com.anythink.core.common.n.b.a.g;

import android.net.ssl.SSLSockets;
import com.anythink.core.common.n.b.ab;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
final class a extends b {
    private a(Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    private static void b(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // com.anythink.core.common.n.b.a.g.b, com.anythink.core.common.n.b.a.g.c
    public final String a(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    public static c a() {
        if (!c.g()) {
            return null;
        }
        try {
            if (d() >= 29) {
                return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ReflectiveOperationException unused) {
        }
        return null;
    }

    @Override // com.anythink.core.common.n.b.a.g.b, com.anythink.core.common.n.b.a.g.c
    public final void a(SSLSocket sSLSocket, String str, List<ab> list) throws IOException {
        try {
            if (SSLSockets.isSupportedSocket(sSLSocket)) {
                SSLSockets.setUseSessionTickets(sSLSocket, true);
            }
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ab abVar = list.get(i);
                if (abVar != ab.HTTP_1_0) {
                    arrayList.add(abVar.toString());
                }
            }
            sSLParameters.setApplicationProtocols((String[]) arrayList.toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
