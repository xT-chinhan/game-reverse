package com.bytedance.sdk.component.ny.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends d {
    public ms(sl slVar) {
        super(slVar);
    }

    public void ms(final com.bytedance.sdk.component.ny.ms.ms msVar) {
        try {
            u.ms msVar2 = new u.ms();
            msVar2.ms((Object) xr());
            xr("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.c)) {
                msVar.ms(this, new IOException("Url is Empty"));
                return;
            }
            msVar2.ms(this.c);
            ms(msVar2);
            this.ah.ms(msVar2.ms().xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bytedance.sdk.component.ny.xr.ms.1
                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar, IOException iOException) {
                    com.bytedance.sdk.component.ny.ms.ms msVar3 = msVar;
                    if (msVar3 != null) {
                        msVar3.ms(ms.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onResponse(com.bytedance.sdk.component.xr.ms.xr xrVar, ao aoVar) throws IOException {
                    if (msVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (aoVar == null) {
                        return;
                    }
                    com.bytedance.sdk.component.ny.xr xrVar2 = new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, null, aoVar.xr(), aoVar.ms());
                    if (aoVar.d()) {
                        InputStream inputStream = null;
                        try {
                            c cVarAb = aoVar.ab();
                            if (cVarAb != null) {
                                for (int i = 0; i < cVarAb.ms(); i++) {
                                    map.put(cVarAb.ms(i), cVarAb.xr(i));
                                }
                            }
                            int iIntValue = Long.valueOf(aoVar.c().ms()).intValue();
                            byte[] bArr = new byte[iIntValue];
                            InputStream inputStreamAh = aoVar.c().ah();
                            try {
                                if (inputStreamAh.read(bArr) == iIntValue) {
                                    xrVar2.ms(bArr);
                                } else {
                                    xrVar2 = new com.bytedance.sdk.component.ny.xr(false, aoVar.ah(), "Byte opt fail", map, null, aoVar.xr(), aoVar.ms());
                                }
                                msVar.ms(ms.this, xrVar2);
                                if (inputStreamAh != null) {
                                    try {
                                        inputStreamAh.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStreamAh;
                                try {
                                    com.bytedance.sdk.component.utils.sl.ms(th);
                                    msVar.ms(ms.this, new IOException(th.getMessage()));
                                } finally {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        msVar.ms(ms.this, xrVar2);
                    }
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    @Override // com.bytedance.sdk.component.ny.xr.d
    public com.bytedance.sdk.component.ny.xr ms() {
        InputStream inputStreamAh;
        try {
            u.ms msVar = new u.ms();
            msVar.ms((Object) xr());
            xr("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.c)) {
                com.bytedance.sdk.component.utils.sl.d("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            msVar.ms(this.c);
            ms(msVar);
            ao aoVarMs = this.ah.ms(msVar.ms().xr()).ms();
            if (aoVarMs == null || !aoVarMs.d()) {
                return null;
            }
            HashMap map = new HashMap();
            c cVarAb = aoVarMs.ab();
            if (cVarAb != null) {
                for (int i = 0; i < cVarAb.ms(); i++) {
                    map.put(cVarAb.ms(i), cVarAb.xr(i));
                }
            }
            long jMs = aoVarMs.c().ms();
            byte[] bArr = new byte[Long.valueOf(jMs).intValue()];
            inputStreamAh = aoVarMs.c().ah();
            try {
                if (inputStreamAh.read(bArr) == jMs) {
                    com.bytedance.sdk.component.ny.xr xrVar = new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, null, aoVarMs.xr(), aoVarMs.ms());
                    xrVar.ms(bArr);
                    if (inputStreamAh != null) {
                        try {
                            inputStreamAh.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return xrVar;
                }
                com.bytedance.sdk.component.ny.xr xrVar2 = new com.bytedance.sdk.component.ny.xr(false, aoVarMs.ah(), "Byte opt fail", map, null, aoVarMs.xr(), aoVarMs.ms());
                if (inputStreamAh != null) {
                    try {
                        inputStreamAh.close();
                    } catch (Throwable unused2) {
                    }
                }
                return xrVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                    return null;
                } finally {
                    if (inputStreamAh != null) {
                        try {
                            inputStreamAh.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamAh = null;
        }
    }
}
