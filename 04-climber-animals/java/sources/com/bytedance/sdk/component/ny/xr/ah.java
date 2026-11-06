package com.bytedance.sdk.component.ny.xr;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.ab;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final com.bytedance.sdk.component.xr.ms.ms f1291ms = new com.bytedance.sdk.component.xr.ms.ms.C0257ms().ms().xr();
    public static final com.bytedance.sdk.component.xr.ms.ms xr = new com.bytedance.sdk.component.xr.ms.ms.C0257ms().xr();
    private Map<String, String> ch;
    private boolean ny;
    private com.bytedance.sdk.component.xr.ms.ms x;

    public ah(sl slVar) {
        super(slVar);
        this.x = f1291ms;
        this.ny = false;
        this.ch = new HashMap();
    }

    public void ms(String str, String str2) {
        if (str == null) {
            com.bytedance.sdk.component.ny.d.ka.ms("GetExecutor", "name cannot be null !!!");
        } else {
            this.ch.put(str, str2);
        }
    }

    public void ms(final com.bytedance.sdk.component.ny.ms.ms msVar) {
        try {
            u.ms msVar2 = new u.ms();
            if (this.ny) {
                msVar2.ms(this.c);
            } else {
                ab.ms msVar3 = new ab.ms();
                Uri uri = Uri.parse(this.c);
                msVar3.ms(uri.getScheme());
                msVar3.xr(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    msVar3.ah(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.ch.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.ch.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        msVar3.ms(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                msVar2.ms(msVar3.xr());
            }
            ms(msVar2);
            msVar2.ms(this.x);
            msVar2.ms((Object) xr());
            this.ah.ms(msVar2.ms().xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bytedance.sdk.component.ny.xr.ah.1
                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar, IOException iOException) {
                    com.bytedance.sdk.component.ny.ms.ms msVar4 = msVar;
                    if (msVar4 != null) {
                        msVar4.ms(ah.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onResponse(com.bytedance.sdk.component.xr.ms.xr xrVar, ao aoVar) throws IOException {
                    if (msVar != null) {
                        HashMap map = new HashMap();
                        if (aoVar != null) {
                            c cVarAb = aoVar.ab();
                            if (cVarAb != null) {
                                for (int i = 0; i < cVarAb.ms(); i++) {
                                    map.put(cVarAb.ms(i), cVarAb.xr(i));
                                }
                            }
                            h hVarC = aoVar.c();
                            msVar.ms(ah.this, new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, hVarC == null ? "" : hVarC.xr(), aoVar.xr(), aoVar.ms()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.ny.d.ka.ms()) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
            if (msVar != null) {
                msVar.ms(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.ny.xr.d
    public com.bytedance.sdk.component.ny.xr ms() {
        try {
            u.ms msVar = new u.ms();
            String strXr = "";
            if (this.ny) {
                msVar.ms(this.c);
            } else {
                ab.ms msVar2 = new ab.ms();
                Uri uri = Uri.parse(this.c);
                msVar2.ms(uri.getScheme());
                msVar2.xr(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    msVar2.ah(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.ch.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.ch.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        msVar2.ms(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                msVar.ms(msVar2.xr());
            }
            ms(msVar);
            msVar.ms(this.x);
            msVar.ms((Object) xr());
            ao aoVarMs = this.ah.ms(msVar.ms().xr()).ms();
            if (aoVarMs == null) {
                return null;
            }
            HashMap map = new HashMap();
            c cVarAb = aoVarMs.ab();
            if (cVarAb != null) {
                for (int i = 0; i < cVarAb.ms(); i++) {
                    map.put(cVarAb.ms(i), cVarAb.xr(i));
                }
            }
            h hVarC = aoVarMs.c();
            if (hVarC != null) {
                strXr = hVarC.xr();
            }
            return new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, strXr, aoVarMs.xr(), aoVarMs.ms());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }
}
