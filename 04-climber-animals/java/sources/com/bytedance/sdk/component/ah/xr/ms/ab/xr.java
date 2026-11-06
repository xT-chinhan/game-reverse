package com.bytedance.sdk.component.ah.xr.ms.ab;

import com.bytedance.sdk.component.ah.xr.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
final class xr extends ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final Method f1056ms;
    final Method xr;

    xr(Method method, Method method2) {
        this.f1056ms = method;
        this.xr = method2;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public void ms(SSLSocket sSLSocket, String str, List<i> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listMs = ms(list);
            this.f1056ms.invoke(sSLParameters, listMs.toArray(new String[listMs.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ab.ka
    public String ms(SSLSocket sSLSocket) {
        try {
            String str = (String) this.xr.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("unable to get selected protocols", (Exception) e);
        }
    }

    public static xr ms() {
        try {
            return new xr(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
