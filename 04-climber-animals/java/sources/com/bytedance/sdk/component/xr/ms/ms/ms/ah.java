package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ao {
    private ms xr;

    public ah(ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ao
    public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, InetSocketAddress inetSocketAddress, Proxy proxy, i iVar, IOException iOException) {
        super.ms(kaVar, inetSocketAddress, proxy, iVar, iOException);
        ms msVar = this.xr;
        if (msVar != null) {
            msVar.ms(kaVar, inetSocketAddress, proxy, iVar, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ao
    public void ms(com.bytedance.sdk.component.ah.xr.ka kaVar, IOException iOException) {
        super.ms(kaVar, iOException);
        ms msVar = this.xr;
        if (msVar != null) {
            msVar.ms(kaVar, iOException);
        }
    }
}
