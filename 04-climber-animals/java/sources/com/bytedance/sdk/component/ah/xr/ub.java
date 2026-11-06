package com.bytedance.sdk.component.ah.xr;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ub {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ub f1142ms = new ub() { // from class: com.bytedance.sdk.component.ah.xr.ub.1
        @Override // com.bytedance.sdk.component.ah.xr.ub
        public List<InetAddress> ms(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> ms(String str) throws UnknownHostException;
}
