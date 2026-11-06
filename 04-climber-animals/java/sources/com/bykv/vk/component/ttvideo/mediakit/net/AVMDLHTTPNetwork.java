package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bytedance.sdk.component.xr.ms.ah;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.ub;
import com.bytedance.sdk.component.xr.ms.xr;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final ch JSON = ch.ms("application/json");
    private static sl mClient;
    private xr mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new sl().xr().ms(10L, TimeUnit.SECONDS).ah(10L, TimeUnit.SECONDS).xr(10L, TimeUnit.SECONDS).ms();
            }
        }
        u.ms msVarMs = new u.ms().ms(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                msVarMs.ms(str2, map.get(str2));
            }
        }
        xr xrVarMs = mClient.ms(msVarMs.xr());
        this.mCall = xrVarMs;
        xrVarMs.ms(new ah() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onFailure(xr xrVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onResponse(xr xrVar, ao aoVar) throws Throwable {
                h hVarC;
                Throwable th;
                JSONObject jSONObject;
                try {
                    hVarC = aoVar.c();
                    try {
                        try {
                            jSONObject = new JSONObject(hVarC.xr());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (hVarC != null) {
                                try {
                                    hVarC.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        jSONObject = null;
                    }
                    if (e == null && !aoVar.d()) {
                        e = new Exception("http fail");
                        aoVar.ah();
                    }
                    if (hVarC != null) {
                        try {
                            hVarC.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    hVarC = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new sl().xr().ms(10L, TimeUnit.SECONDS).ah(10L, TimeUnit.SECONDS).xr(10L, TimeUnit.SECONDS).ms();
            }
        }
        u.ms msVarMs = new u.ms().ms(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                msVarMs.xr(str2, map.get(str2));
            }
        }
        if (i == 1) {
            msVarMs.ms(ub.ms(JSON, String.valueOf(jSONObject)));
        }
        xr xrVarMs = mClient.ms(msVarMs.xr());
        this.mCall = xrVarMs;
        xrVarMs.ms(new ah() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onFailure(xr xrVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onResponse(xr xrVar, ao aoVar) throws Throwable {
                h hVarC;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    hVarC = aoVar.c();
                    try {
                        try {
                            jSONObject2 = new JSONObject(hVarC.xr());
                            string = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (hVarC != null) {
                                try {
                                    hVarC.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        string = e.toString();
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        jSONObject2 = null;
                    }
                    if (!aoVar.d()) {
                        string = aoVar.ka();
                        aoVar.ah();
                    }
                    if (hVarC != null) {
                        try {
                            hVarC.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string.toString()));
                    }
                } catch (Throwable th3) {
                    hVarC = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        xr xrVar = this.mCall;
        if (xrVar == null || xrVar.ah()) {
            return;
        }
        this.mCall.xr();
    }
}
