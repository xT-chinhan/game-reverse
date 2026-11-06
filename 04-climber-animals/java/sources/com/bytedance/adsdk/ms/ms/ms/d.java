package com.bytedance.adsdk.ms.ms.ms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    static class ms extends IOException {
        ms() {
            super("APNG Format error");
        }
    }

    public static List<ka> ms(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
        if (!msVar.ms("\u0089PNG") || !msVar.ms("\r\n\u001a\n")) {
            throw new ms();
        }
        ArrayList arrayList = new ArrayList();
        while (msVar.d() > 0) {
            arrayList.add(xr(msVar));
        }
        return arrayList;
    }

    private static ka xr(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
        ka kaVar;
        int iAh = msVar.ah();
        int iXr = msVar.xr();
        int iB_ = msVar.b_();
        if (iB_ == com.bytedance.adsdk.ms.ms.ms.ms.f308ms) {
            kaVar = new com.bytedance.adsdk.ms.ms.ms.ms();
        } else if (iB_ == c.f305ms) {
            kaVar = new c();
        } else if (iB_ == ab.f303ms) {
            kaVar = new ab();
        } else if (iB_ == ch.f306ms) {
            kaVar = new ch();
        } else if (iB_ == hi.f307ms) {
            kaVar = new hi();
        } else if (iB_ == sl.f320ms) {
            kaVar = new sl();
        } else {
            kaVar = new ka();
        }
        kaVar.ab = iAh;
        kaVar.ka = iB_;
        kaVar.d = iXr;
        kaVar.xr(msVar);
        kaVar.c = msVar.xr();
        return kaVar;
    }
}
