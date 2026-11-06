package com.tapsdk.tapad.internal.download;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static final int a = 10;
    static final int b = 307;
    static final int c = 308;

    public static String a(com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605a, int i) throws IOException {
        String strC = interfaceC0605a.c("Location");
        if (strC != null) {
            return strC;
        }
        throw new ProtocolException("Response code is " + i + " but can't find Location field");
    }

    public static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
