package com.bytedance.sdk.component.ny.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.ub;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ub f1294ms;

    public ka(sl slVar) {
        super(slVar);
        this.f1294ms = null;
    }

    public void ah(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f1294ms = ub.ms(ch.ms("application/json; charset=utf-8"), str);
    }

    public void ms(JSONObject jSONObject) {
        this.f1294ms = ub.ms(ch.ms("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void ms(Map<String, String> map) {
        com.bytedance.sdk.component.xr.ms.ka.ms msVar = new com.bytedance.sdk.component.xr.ms.ka.ms();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                msVar.ms(str, map.get(str));
            }
        }
        this.f1294ms = msVar.ms();
    }

    public void ms(String str, byte[] bArr) {
        this.f1294ms = ub.ms(ch.ms(str), bArr);
    }

    public void ms(final com.bytedance.sdk.component.ny.ms.ms msVar) {
        try {
            u.ms msVar2 = new u.ms();
            if (TextUtils.isEmpty(this.c)) {
                msVar.ms(this, new IOException("Url is Empty"));
                return;
            }
            msVar2.ms(this.c);
            if (this.f1294ms == null) {
                if (msVar != null) {
                    msVar.ms(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                ms(msVar2);
                msVar2.ms((Object) xr());
                this.ah.ms(msVar2.ms(this.f1294ms).xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bytedance.sdk.component.ny.xr.ka.1
                    @Override // com.bytedance.sdk.component.xr.ms.ah
                    public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar, IOException iOException) {
                        com.bytedance.sdk.component.ny.ms.ms msVar3 = msVar;
                        if (msVar3 != null) {
                            msVar3.ms(ka.this, iOException);
                        }
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.bytedance.sdk.component.xr.ms.ah
                    public void onResponse(com.bytedance.sdk.component.xr.ms.xr xrVar, ao aoVar) throws IOException {
                        com.bytedance.sdk.component.ny.xr xrVar2;
                        com.bytedance.sdk.component.ny.ms.ms msVar3 = msVar;
                        if (msVar3 != null) {
                            if (aoVar == null) {
                                msVar3.ms(ka.this, new IOException("No response"));
                                return;
                            }
                            com.bytedance.sdk.component.ny.xr xrVar3 = null;
                            IOException iOException = null;
                            try {
                                HashMap map = new HashMap();
                                c cVarAb = aoVar.ab();
                                if (cVarAb != null) {
                                    for (int i = 0; i < cVarAb.ms(); i++) {
                                        String strMs = cVarAb.ms(i);
                                        String strXr = cVarAb.xr(i);
                                        map.put(strMs, strXr);
                                        if (strMs != null && strMs.equalsIgnoreCase("content-type")) {
                                            map.put("content-type", strXr == null ? "" : strXr.toLowerCase());
                                        }
                                    }
                                }
                                try {
                                    if (com.bytedance.sdk.component.ny.d.ms.ms(map)) {
                                        byte[] bArrD = aoVar.c().d();
                                        xrVar2 = new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, null, aoVar.xr(), aoVar.ms());
                                        xrVar2.ms(bArrD);
                                    } else if (ka.this.ab) {
                                        byte[] bArrD2 = aoVar.c().d();
                                        ka kaVar = ka.this;
                                        xrVar2 = new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, new String(bArrD2, kaVar.ms(kaVar.ms(aoVar.c()))), aoVar.xr(), aoVar.ms());
                                        xrVar2.ms(bArrD2);
                                    } else {
                                        xrVar2 = new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, aoVar.c().xr(), aoVar.xr(), aoVar.ms());
                                    }
                                    ka.this.ms(xrVar2, aoVar);
                                } catch (Throwable th) {
                                    th = th;
                                    xrVar3 = xrVar2;
                                    xrVar2 = xrVar3;
                                    iOException = new IOException(th);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (xrVar2 != null) {
                                msVar.ms(ka.this, xrVar2);
                                return;
                            }
                            com.bytedance.sdk.component.ny.ms.ms msVar4 = msVar;
                            ka kaVar2 = ka.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            msVar4.ms(kaVar2, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            msVar.ms(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.ny.xr.d
    public com.bytedance.sdk.component.ny.xr ms() {
        com.bytedance.sdk.component.ny.xr xrVar;
        try {
            u.ms msVar = new u.ms();
            if (TextUtils.isEmpty(this.c)) {
                com.bytedance.sdk.component.ny.d.ka.ms("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.ny.xr(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            msVar.ms(this.c);
            if (this.f1294ms == null) {
                com.bytedance.sdk.component.ny.d.ka.ms("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.ny.xr(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            ms(msVar);
            msVar.ms((Object) xr());
            ao aoVarMs = this.ah.ms(msVar.ms(this.f1294ms).xr()).ms();
            if (aoVarMs == null) {
                return null;
            }
            HashMap map = new HashMap();
            c cVarAb = aoVarMs.ab();
            if (cVarAb != null) {
                for (int i = 0; i < cVarAb.ms(); i++) {
                    String strMs = cVarAb.ms(i);
                    String strXr = cVarAb.xr(i);
                    map.put(strMs, strXr);
                    if (strMs != null && strMs.equalsIgnoreCase("content-type")) {
                        map.put("content-type", strXr == null ? "" : strXr.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.ny.d.ms.ms(map)) {
                byte[] bArrD = aoVarMs.c().d();
                xrVar = new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, null, aoVarMs.xr(), aoVarMs.ms());
                xrVar.ms(bArrD);
            } else if (this.ab) {
                byte[] bArrD2 = aoVarMs.c().d();
                xrVar = new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, new String(bArrD2, ms(ms(aoVarMs.c()))), aoVarMs.xr(), aoVarMs.ms());
                xrVar.ms(bArrD2);
            } else {
                xrVar = new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, aoVarMs.c().xr(), aoVarMs.xr(), aoVarMs.ms());
            }
            ms(xrVar, aoVarMs);
            return xrVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.ny.xr(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset ms(ch chVar) {
        try {
            return chVar != null ? chVar.ms(com.bytedance.sdk.component.xr.ms.xr.ch.f1627ms) : com.bytedance.sdk.component.xr.ms.xr.ch.f1627ms;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.xr.ms.xr.ch.f1627ms;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ch ms(h hVar) {
        try {
            return hVar.ka();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.component.ny.xr xrVar, ao aoVar) {
        if (xrVar == null || aoVar == null) {
            return;
        }
        xrVar.ms(aoVar.ny());
    }
}
