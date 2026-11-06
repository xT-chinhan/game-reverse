package com.bykv.vk.component.ttvideo.mediakit.net;

import com.byazt.nzn.g;
import com.byazt.nzn.hn;
import com.byazt.nzn.ho;
import com.byazt.nzn.hw;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.vk;
import com.byazt.nzn.yb;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    private hw mCall;
    private static k mClient = null;
    public static final vk JSON = vk.pr("application/json");

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new k().hw().pr(10L, TimeUnit.SECONDS).hn(10L, TimeUnit.SECONDS).hw(10L, TimeUnit.SECONDS).pr();
            }
        }
        g.pr prVarPr = new g.pr().pr(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                prVarPr.pr(str2, map.get(str2));
            }
        }
        hw hwVarPr = mClient.pr(prVarPr.hw());
        this.mCall = hwVarPr;
        hwVarPr.pr(new hn() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.byazt.nzn.hn
            public void onFailure(hw hwVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.nzn.hn
            public void onResponse(hw hwVar, nt ntVar) throws Throwable {
                yb ybVarUc;
                Throwable th;
                JSONObject jSONObject;
                try {
                    ybVarUc = ntVar.uc();
                    try {
                        try {
                            jSONObject = new JSONObject(ybVarUc.hw());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (ybVarUc != null) {
                                try {
                                    ybVarUc.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject = null;
                    }
                    if (e == null && !ntVar.x()) {
                        e = new Exception("http fail");
                        ntVar.hn();
                    }
                    if (ybVarUc != null) {
                        try {
                            ybVarUc.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    ybVarUc = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new k().hw().pr(10L, TimeUnit.SECONDS).hn(10L, TimeUnit.SECONDS).hw(10L, TimeUnit.SECONDS).pr();
            }
        }
        g.pr prVarPr = new g.pr().pr(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                prVarPr.hw(str2, map.get(str2));
            }
        }
        if (i == 1) {
            prVarPr.pr(ho.pr(JSON, String.valueOf(jSONObject)));
        }
        hw hwVarPr = mClient.pr(prVarPr.hw());
        this.mCall = hwVarPr;
        hwVarPr.pr(new hn() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.byazt.nzn.hn
            public void onFailure(hw hwVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.nzn.hn
            public void onResponse(hw hwVar, nt ntVar) throws Throwable {
                yb ybVarUc;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    ybVarUc = ntVar.uc();
                    try {
                        try {
                            jSONObject2 = new JSONObject(ybVarUc.hw());
                            string = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (ybVarUc != null) {
                                try {
                                    ybVarUc.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        string = e2.toString();
                        jSONObject2 = null;
                    }
                    if (!ntVar.x()) {
                        string = ntVar.c();
                        ntVar.hn();
                    }
                    if (ybVarUc != null) {
                        try {
                            ybVarUc.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string.toString()));
                    }
                } catch (Throwable th3) {
                    ybVarUc = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        hw hwVar = this.mCall;
        if (hwVar != null && !hwVar.x()) {
            this.mCall.hn();
        }
    }
}
