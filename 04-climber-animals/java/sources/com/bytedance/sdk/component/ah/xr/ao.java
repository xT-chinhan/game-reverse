package com.bytedance.sdk.component.ah.xr;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ao {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ao f1030ms = new ao() { // from class: com.bytedance.sdk.component.ah.xr.ao.1
    };

    public interface ms {
        ao ms(ka kaVar);
    }

    public void ms(ka kaVar, IOException iOException) {
    }

    public void ms(ka kaVar, InetSocketAddress inetSocketAddress, Proxy proxy, i iVar, IOException iOException) {
    }

    static ms ms(ao aoVar) {
        return new ms() { // from class: com.bytedance.sdk.component.ah.xr.ao.2
            @Override // com.bytedance.sdk.component.ah.xr.ao.ms
            public ao ms(ka kaVar) {
                return ao.this;
            }
        };
    }
}
