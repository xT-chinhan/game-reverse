package com.anythink.core.common.l.a.a;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String a = "d";

    private d() {
    }

    public static List<InetAddress> a(List<InetAddress> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (InetAddress inetAddress : list) {
            if (inetAddress != null && !inetAddress.isAnyLocalAddress() && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                arrayList.add(inetAddress);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
