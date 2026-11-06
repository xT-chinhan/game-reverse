package com.bytedance.sdk.component.c.d;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ms {
    @Override // com.bytedance.sdk.component.c.d.ny
    public String ms() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.c.d.ny
    public void ms(final com.bytedance.sdk.component.c.ah.ah ahVar) {
        final com.bytedance.sdk.component.c.ah.c cVarT = ahVar.t();
        com.bytedance.sdk.component.c.d dVarD = cVarT.d();
        ahVar.ms(false);
        try {
            com.bytedance.sdk.component.c.c cVarCall = dVarD.call(new com.bytedance.sdk.component.c.xr.ah(ahVar.xr(), ahVar.u(), ahVar.ub(), ahVar.re()));
            int iXr = cVarCall.xr();
            ahVar.ms(cVarCall.ms());
            if (cVarCall.xr() == 200) {
                final byte[] bArr = (byte[]) cVarCall.ah();
                ahVar.ms(new xr(bArr, cVarCall));
                final String strC = ahVar.c();
                final com.bytedance.sdk.component.c.xr xrVarNw = ahVar.nw();
                if (xrVarNw.ab()) {
                    cVarT.xr(ahVar.nw()).ms(strC, bArr);
                }
                cVarT.c().submit(new Runnable() { // from class: com.bytedance.sdk.component.c.d.hi.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xrVarNw.d()) {
                            cVarT.ah(ahVar.nw()).ms(strC, bArr);
                        }
                    }
                });
                return;
            }
            cVarT.x();
            String.valueOf(cVarCall);
            Object objAh = cVarCall.ah();
            ms(iXr, cVarCall.d(), objAh instanceof Throwable ? (Throwable) objAh : null, ahVar);
        } catch (Throwable th) {
            ms(1004, "net request failed!", th, ahVar);
        }
    }

    private void ms(int i, String str, Throwable th, com.bytedance.sdk.component.c.ah.ah ahVar) {
        ahVar.ms(new x(i, str, th));
    }
}
