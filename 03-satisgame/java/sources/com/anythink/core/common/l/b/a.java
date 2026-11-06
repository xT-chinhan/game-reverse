package com.anythink.core.common.l.b;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "a";

    private a() {
    }

    public static List<InetAddress> a(String str, List<String> list) {
        if (str == null || str.isEmpty() || list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            InetAddress inetAddressA = a(str, it.next());
            if (inetAddressA != null) {
                arrayList.add(inetAddressA);
            }
        }
        return arrayList;
    }

    private static InetAddress a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            try {
                return InetAddress.getByAddress(str, InetAddress.getByName(str2).getAddress());
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
