package com.efs.sdk.net;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import com.efs.sdk.net.a.d;
import com.efs.sdk.net.a.e;
import com.efs.sdk.net.a.f;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpListener extends EventListener {
    private static AtomicInteger a = new AtomicInteger(0);
    private boolean b;
    private List c = new ArrayList();

    public static EventListener.Factory get() {
        return new EventListener.Factory() { // from class: com.efs.sdk.net.OkHttpListener.1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return new OkHttpListener();
            }
        };
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.b = true;
            }
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            e.a(call, new f(String.valueOf(a.getAndIncrement()), System.currentTimeMillis()));
            a(call, d.a);
            try {
                f fVarA = e.a(call);
                if (fVarA == null) {
                    return;
                }
                d dVarC = a.a().c(fVarA.a);
                if (dVarC != null) {
                    dVarC.B = call.request().url().toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(call, d.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(call, d.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(call, d.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(call, d.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(call, d.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(call, d.i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(call, d.j);
            a(call);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        try {
            Log.d("NetTrace-Listener", "connectionAcquired");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            InetAddress inetAddress = connection.socket().getInetAddress();
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                try {
                    f fVarA = e.a(call);
                    if (fVarA == null) {
                        return;
                    }
                    d dVarC = a.a().c(fVarA.a);
                    if (dVarC != null) {
                        dVarC.C = hostAddress;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(call, d.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(call, d.l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(call, d.m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            call.request().body();
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(call, d.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(call, d.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(call, d.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(call, d.q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(call, d.r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(call, d.b);
            a(call);
            e.b(call);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.b && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(call, d.c);
            a(call);
            e.b(call);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Call call, String str) {
        Map<String, Long> map;
        try {
            f fVarA = e.a(call);
            if (fVarA == null) {
                return;
            }
            d dVarC = a.a().c(fVarA.a);
            if (dVarC == null || (map = dVarC.E) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Call call) {
        String str;
        d dVarC;
        try {
            f fVarA = e.a(call);
            if (fVarA == null || (dVarC = a.a().c((str = fVarA.a))) == null) {
                return;
            }
            Map<String, Long> map = dVarC.E;
            Map<String, Long> map2 = dVarC.F;
            map2.put(d.s, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.a, d.b)));
            map2.put(d.t, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.d, d.e)));
            map2.put(d.u, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.g, d.h)));
            map2.put(d.v, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f, d.i)));
            map2.put(d.w, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.k, d.l)));
            map2.put(d.x, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.m, d.n)));
            map2.put(d.y, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.o, d.p)));
            map2.put(d.z, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.q, d.r)));
            a(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str) {
        try {
            final d dVarC = a.a().c(str);
            final c cVarA = a.a().a(str);
            if (dVarC == null || cVarA == null) {
                return;
            }
            Map<String, Long> map = dVarC.E;
            Map<String, Long> map2 = dVarC.F;
            Log.i("NetTrace-Listener", cVarA.toString());
            if (!TextUtils.isEmpty(dVarC.B)) {
                final EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
                if (map.containsKey(d.d)) {
                    efsJSONLog.put("wd_dns", map.get(d.d));
                }
                if (map.containsKey(d.e)) {
                    efsJSONLog.put("wd_dnstm", map.get(d.e));
                }
                if (map2.containsKey(d.t)) {
                    efsJSONLog.put("wl_dns", map2.get(d.t));
                }
                if (map.containsKey(d.f)) {
                    efsJSONLog.put("wd_tcp", map.get(d.f));
                }
                if (map.containsKey(d.i)) {
                    efsJSONLog.put("wd_tcptm", map.get(d.i));
                }
                if (map2.containsKey(d.v)) {
                    efsJSONLog.put("wl_tcp", map2.get(d.v));
                }
                if (map.containsKey(d.g)) {
                    efsJSONLog.put("wd_ssl", map.get(d.g));
                }
                if (map.containsKey(d.h)) {
                    efsJSONLog.put("wd_ssltm", map.get(d.h));
                }
                if (map2.containsKey(d.u)) {
                    efsJSONLog.put("wl_ssl", map2.get(d.u));
                }
                if (map.containsKey(d.k)) {
                    efsJSONLog.put("wd_ds", map.get(d.k));
                }
                if (map.containsKey(d.n)) {
                    efsJSONLog.put("wd_dstm", map.get(d.n));
                }
                if (map2.containsKey(d.w) && map2.containsKey(d.x)) {
                    efsJSONLog.put("wl_ds", Long.valueOf(map2.get(d.w).longValue() + map2.get(d.x).longValue()));
                }
                if (map.containsKey(d.o)) {
                    efsJSONLog.put("wd_srt", map.get(d.o));
                }
                if (map.containsKey(d.r)) {
                    efsJSONLog.put("wd_srttm", map.get(d.r));
                }
                if (map2.containsKey(d.y) && map2.containsKey(d.z)) {
                    efsJSONLog.put("wl_srt", Long.valueOf(map2.get(d.y).longValue() + map2.get(d.z).longValue()));
                }
                String[] strArrSplit = dVarC.B.split("\\?");
                String str2 = strArrSplit != null ? strArrSplit[0] : null;
                List list = this.c;
                if (list != null && str2 != null && !list.contains(str2)) {
                    this.c.add(str2);
                    if (map.containsKey(d.n)) {
                        efsJSONLog.put("wd_ttfb", map.get(d.n));
                    } else if (map.containsKey(d.l)) {
                        efsJSONLog.put("wd_ttfb", map.get(d.l));
                    }
                    if (map.containsKey(d.o)) {
                        efsJSONLog.put("wd_ttfbtm", map.get(d.o));
                    }
                    if (map.containsKey(d.o)) {
                        if (map.containsKey(d.n)) {
                            efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.n).longValue()));
                        } else if (map.containsKey(d.l)) {
                            efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.l).longValue()));
                        }
                    }
                } else {
                    efsJSONLog.put("wd_ttfb", 0);
                    efsJSONLog.put("wd_ttfbtm", 0);
                    efsJSONLog.put("wl_ttfb", 0);
                }
                if (map.containsKey(d.a)) {
                    efsJSONLog.put("wd_rt", map.get(d.a));
                }
                if (map.containsKey(d.b)) {
                    efsJSONLog.put("wd_rttm", map.get(d.b));
                }
                if (map2.containsKey(d.s)) {
                    efsJSONLog.put("wl_rt", map2.get(d.s));
                }
                efsJSONLog.put("wk_res", cVarA.c);
                efsJSONLog.put("wk_res_ori", dVarC.B);
                efsJSONLog.put("wk_ip", dVarC.C);
                efsJSONLog.put("wk_method", cVarA.e);
                efsJSONLog.put("wk_rc", Integer.valueOf(cVarA.i));
                efsJSONLog.put("wl_up", Long.valueOf(cVarA.g));
                efsJSONLog.put("wl_down", Long.valueOf(cVarA.m));
                efsJSONLog.put("wl_total", Long.valueOf(cVarA.g + cVarA.m));
                b.a(new Runnable() { // from class: com.efs.sdk.net.OkHttpListener.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            try {
                                String strA = com.efs.sdk.net.b.a.a((dVarC.E.containsKey(d.a) ? String.valueOf(dVarC.E.get(d.a)) : "") + ControllerCenter.getGlobalEnvStruct().getAppid() + ControllerCenter.getGlobalEnvStruct().getSecret());
                                if (NetManager.getNetConfigManager().getNetRequestBodyCollectState() && !TextUtils.isEmpty(cVarA.h)) {
                                    efsJSONLog.put("wk_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.h.getBytes(), strA.getBytes())));
                                }
                                if (NetManager.getNetConfigManager().getNetResponseBodyCollectState() && !TextUtils.isEmpty(cVarA.k)) {
                                    efsJSONLog.put("wk_res_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.k.getBytes(), strA.getBytes())));
                                }
                                if (NetManager.getNetConfigManager().getNetRequestHeaderCollectState() && cVarA.f != null && !cVarA.f.isEmpty()) {
                                    efsJSONLog.put("wk_req_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.f).toString().getBytes(), strA.getBytes())));
                                }
                                if (NetManager.getNetConfigManager().getNetResponseHeaderCollectState() && cVarA.l != null && !cVarA.l.isEmpty()) {
                                    efsJSONLog.put("wk_res_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.l).toString().getBytes(), strA.getBytes())));
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            OkHttpListener.a(cVarA, efsJSONLog);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
                a.a().d(str);
                a.a().b(str);
                return;
            }
            Log.d("NetTrace-Listener", "url is null.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(EfsJSONLog efsJSONLog) {
        try {
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                if (SamplingWhiteListUtil.isHitWL()) {
                    return;
                }
                SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
                String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
                if (sharedPreferences != null) {
                    int i = sharedPreferences.getInt(str, 0);
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (editorEdit != null) {
                        editorEdit.putInt(str, i + 1);
                        editorEdit.apply();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String a(Map<String, String> map, boolean z, boolean z2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!SamplingWhiteListUtil.isHitWL()) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append("|").append(NetManager.getNetConfigManager().getExtraRateFlag());
            if (map.size() != 0 && !z && z2) {
                sb.append("|1");
            } else {
                sb.append("|0");
            }
            sb.append("|").append(new JSONObject(map).toString());
            return com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(sb.toString().getBytes(), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:111:0x0209  */
    /* JADX WARN: Code duplicated, block: B:113:0x020d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x020f  */
    /* JADX WARN: Code duplicated, block: B:119:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b5 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c1 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cd A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x010b A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x012e  */
    /* JADX WARN: Code duplicated, block: B:47:0x012f A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0137 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x013f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0161  */
    /* JADX WARN: Code duplicated, block: B:64:0x0164 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:25:0x0099, B:27:0x00a8, B:30:0x00af, B:32:0x00b5, B:34:0x00c1, B:36:0x00cd, B:38:0x00d6, B:42:0x00e7, B:44:0x0124, B:49:0x0137, B:53:0x0142, B:64:0x0164, B:65:0x017a, B:57:0x014e, B:59:0x0158, B:43:0x010b, B:47:0x012f, B:66:0x017f), top: B:121:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0185  */
    /* JADX WARN: Code duplicated, block: B:69:0x0187  */
    /* JADX WARN: Code duplicated, block: B:84:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:97:0x01db  */
    /* JADX WARN: Code duplicated, block: B:98:0x01dd  */
    static /* synthetic */ void a(c cVar, EfsJSONLog efsJSONLog) {
        boolean z;
        boolean zA;
        boolean z2;
        boolean z3;
        int extraDataRate;
        JSONArray jSONArray;
        HashMap map;
        int i;
        JSONObject jSONObjectOptJSONObject;
        boolean z4;
        String strOptString;
        int iOptInt;
        int iOptInt2;
        Uri uri;
        int port;
        String str;
        try {
            SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
            String str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
            if (sharedPreferences != null) {
                int i2 = sharedPreferences.getInt(str2, 0);
                if (!SamplingWhiteListUtil.isHitWL() && NetManager.getNetConfigManager().getDayLimit() != -1 && i2 >= NetManager.getNetConfigManager().getDayLimit()) {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        Map<String, Object> strategyMap = NetManager.getReporter().getStrategyMap();
        boolean zA2 = com.efs.sdk.net.b.a.a(NetManager.getNetConfigManager().getDataRate());
        String strA = "";
        if (strategyMap == null || strategyMap.size() != 2) {
            z = false;
            zA = false;
        } else {
            try {
                zA = com.efs.sdk.net.b.a.a(((Integer) strategyMap.get("rate")).intValue());
                if (!zA2 && !zA) {
                    try {
                        if (!SamplingWhiteListUtil.isHitWL()) {
                            return;
                        }
                        jSONArray = (JSONArray) strategyMap.get("stra");
                        map = new HashMap();
                        if (jSONArray != null) {
                            for (i = 0; i < jSONArray.length(); i++) {
                                jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                                if (TextUtils.isEmpty(cVar.d)) {
                                    z4 = false;
                                } else {
                                    strOptString = jSONObjectOptJSONObject.optString("u");
                                    if (TextUtils.isEmpty(strOptString)) {
                                        z4 = false;
                                    } else {
                                        if (!strOptString.startsWith("^")) {
                                            uri = Uri.parse(cVar.d);
                                            port = uri.getPort();
                                            if (port < 0) {
                                                str = uri.getHost() + uri.getPath();
                                            } else {
                                                str = uri.getHost() + uri.getPath();
                                            }
                                            if (com.efs.sdk.net.b.a.a(str).equalsIgnoreCase(strOptString)) {
                                                iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                                if (iOptInt == -1) {
                                                }
                                            }
                                        } else if (Pattern.matches(strOptString, cVar.d)) {
                                            iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                            if (iOptInt == -1) {
                                            }
                                        }
                                        z4 = false;
                                    }
                                }
                                if (z4) {
                                    map.put(new StringBuilder().append(jSONObjectOptJSONObject.optInt("i")).toString(), "");
                                }
                            }
                        }
                        if (map.size() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                        }
                        strA = a(map, zA2, zA);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        th.printStackTrace();
                        if (TextUtils.isEmpty(strA)) {
                            z2 = false;
                            strA = a(new HashMap(), zA2, false);
                        } else {
                            z2 = false;
                        }
                        efsJSONLog.put("dx", strA);
                        if (SamplingWhiteListUtil.isHitWL()) {
                            a(efsJSONLog);
                            return;
                        }
                        if (z) {
                            if (zA2) {
                            }
                            a(efsJSONLog);
                            return;
                        }
                        if (NetManager.getNetConfigManager().getExtraRateFlag() == 1) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (z3) {
                            if (zA2) {
                                a(efsJSONLog);
                            }
                        } else if (NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
                            extraDataRate = NetManager.getNetConfigManager().getExtraDataRate();
                            if (extraDataRate != 0) {
                                z2 = true;
                            }
                            if (z2) {
                                a(efsJSONLog);
                            }
                        }
                    }
                } else {
                    try {
                        jSONArray = (JSONArray) strategyMap.get("stra");
                        map = new HashMap();
                        if (jSONArray != null && jSONArray.length() > 0) {
                            while (i < jSONArray.length()) {
                                jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                                if (TextUtils.isEmpty(cVar.d)) {
                                    strOptString = jSONObjectOptJSONObject.optString("u");
                                    if (TextUtils.isEmpty(strOptString)) {
                                        z4 = false;
                                    } else {
                                        if (!strOptString.startsWith("^")) {
                                            uri = Uri.parse(cVar.d);
                                            port = uri.getPort();
                                            if (port < 0 && port <= 65535) {
                                                str = uri.getHost() + ":" + port + uri.getPath();
                                            } else {
                                                str = uri.getHost() + uri.getPath();
                                            }
                                            if (com.efs.sdk.net.b.a.a(str).equalsIgnoreCase(strOptString)) {
                                                iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                                if (iOptInt == -1 && iOptInt <= 3 && ((iOptInt2 = jSONObjectOptJSONObject.optInt("s", -1)) == 0 || (iOptInt2 == 2 && NetManager.getNetConfigManager().getNetRequestBodyCollectState() && !TextUtils.isEmpty(cVar.h)))) {
                                                    z4 = true;
                                                }
                                            }
                                        } else if (Pattern.matches(strOptString, cVar.d)) {
                                            iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                            if (iOptInt == -1) {
                                            }
                                        }
                                        z4 = false;
                                    }
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    map.put(new StringBuilder().append(jSONObjectOptJSONObject.optInt("i")).toString(), "");
                                }
                            }
                        }
                        if (map.size() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            try {
                                NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                        strA = a(map, zA2, zA);
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                z = false;
                zA = false;
            }
        }
        if (TextUtils.isEmpty(strA)) {
            z2 = false;
            strA = a(new HashMap(), zA2, false);
        } else {
            z2 = false;
        }
        efsJSONLog.put("dx", strA);
        if (SamplingWhiteListUtil.isHitWL()) {
            a(efsJSONLog);
            return;
        }
        if (z) {
            if (!zA2 || zA) {
                a(efsJSONLog);
                return;
            }
            return;
        }
        if (NetManager.getNetConfigManager().getExtraRateFlag() == 1) {
            z3 = true;
        } else {
            z3 = z2;
        }
        if (z3) {
            if (zA2) {
                a(efsJSONLog);
            }
        } else if (NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
            extraDataRate = NetManager.getNetConfigManager().getExtraDataRate();
            if (extraDataRate != 0 && (extraDataRate == 100000 || new Random().nextInt(j.v.w) <= extraDataRate)) {
                z2 = true;
            }
            if (z2) {
                a(efsJSONLog);
            }
        }
    }
}
