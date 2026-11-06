package com.bykv.vk.component.ttvideo.mediakit.net;

import com.anythink.core.common.l.b;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.hd;
import com.byazt.tbt.k;
import com.byazt.tbt.qg;
import com.byazt.tbt.s;
import com.byazt.tbt.sz;
import com.byazt.tbt.tj;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final tj JSON = tj.n(b.h);
    private static d mClient;
    private qg mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new d().qg().n(10L, TimeUnit.SECONDS).s(10L, TimeUnit.SECONDS).qg(10L, TimeUnit.SECONDS).n();
            }
        }
        sz.n nVarQg = new sz.n().qg(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                nVarQg.n(str2, map.get(str2));
            }
        }
        qg qgVarN = mClient.n(nVarQg.qg());
        this.mCall = qgVarN;
        qgVarN.n(new s() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.byazt.tbt.s
            public void onFailure(qg qgVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.tbt.s
            public void onResponse(qg qgVar, cy cyVar) throws Throwable {
                hd hdVarX;
                Throwable th;
                JSONObject jSONObject;
                try {
                    hdVarX = cyVar.x();
                    try {
                        try {
                            jSONObject = new JSONObject(hdVarX.qg());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (hdVarX != null) {
                                try {
                                    hdVarX.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        jSONObject = null;
                    }
                    if (e == null && !cyVar.l()) {
                        e = new Exception("http fail");
                        cyVar.q();
                    }
                    if (hdVarX != null) {
                        try {
                            hdVarX.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    hdVarX = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new d().qg().n(10L, TimeUnit.SECONDS).s(10L, TimeUnit.SECONDS).qg(10L, TimeUnit.SECONDS).n();
            }
        }
        sz.n nVarQg = new sz.n().qg(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                nVarQg.qg(str2, map.get(str2));
            }
        }
        if (i == 1) {
            nVarQg.n(k.n(JSON, String.valueOf(jSONObject)));
        }
        qg qgVarN = mClient.n(nVarQg.qg());
        this.mCall = qgVarN;
        qgVarN.n(new s() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.byazt.tbt.s
            public void onFailure(qg qgVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.tbt.s
            public void onResponse(qg qgVar, cy cyVar) throws Throwable {
                hd hdVarX;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    hdVarX = cyVar.x();
                    try {
                        try {
                            jSONObject2 = new JSONObject(hdVarX.qg());
                            string = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (hdVarX != null) {
                                try {
                                    hdVarX.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        string = e.toString();
                        jSONObject2 = null;
                    }
                    if (!cyVar.l()) {
                        string = cyVar.w();
                        cyVar.q();
                    }
                    if (hdVarX != null) {
                        try {
                            hdVarX.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string.toString()));
                    }
                } catch (Throwable th3) {
                    hdVarX = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        qg qgVar = this.mCall;
        if (qgVar == null || qgVar.q()) {
            return;
        }
        this.mCall.s();
    }
}
