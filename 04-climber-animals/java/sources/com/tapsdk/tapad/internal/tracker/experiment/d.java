package com.tapsdk.tapad.internal.tracker.experiment;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tapsdk.tapad.internal.tracker.experiment.entities.ExpTrackMessage;
import com.tapsdk.tapad.internal.tracker.experiment.entities.ExpTrackMessageList;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import io.reactivex.subjects.PublishSubject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class d extends Handler {
    public static final String k = "ExpTdsTrackerHandler";
    private static final String l = "topic_preference";
    private static final String m = "_topic_count_preference";
    private static final String n = "_topic_data_size_preference";
    public static final String o = "updateUnsentMessageSize";
    public static final String p = "generatedAmount";
    public static final String q = "amount";
    private static final long r = 500;
    public static final int s = 5000;
    public static final int t = 2000;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final Set<String> y = new HashSet();
    private boolean a;
    private boolean b;
    private Application c;
    private PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> d;
    private boolean e;
    private long f;
    com.tapsdk.tapad.internal.network.a g;
    private Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> h;
    Map<String, CopyOnWriteArrayList<ExpTrackMessage>> i;
    private final com.tapsdk.tapad.internal.u.a j;

    public d(Looper looper) {
        super(looper);
        this.a = false;
        this.b = false;
        this.e = false;
        this.f = -1L;
        this.h = null;
        this.i = new ConcurrentHashMap();
        this.g = new com.tapsdk.tapad.internal.network.a.g().a("").a(new OkHttpClient().newBuilder().build()).a();
        this.j = com.tapsdk.tapad.internal.u.a.b(k);
    }

    private com.tapsdk.tapad.internal.tracker.experiment.entities.a<Integer, byte[]> a(String str) {
        byte[] bArrA;
        Log.i(k, "-------getUnSendByteData-------start");
        CopyOnWriteArrayList<ExpTrackMessage> copyOnWriteArrayList = this.i.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            bArrA = null;
        } else {
            try {
                bArrA = com.tapsdk.tapad.internal.tracker.experiment.j.g.a(new ExpTrackMessageList(copyOnWriteArrayList));
            } catch (Exception e) {
                e.printStackTrace();
                bArrA = null;
            }
        }
        int size = copyOnWriteArrayList != null ? copyOnWriteArrayList.size() : 0;
        Log.i(k, "-------getUnSendByteData-------end");
        return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Integer.valueOf(size), bArrA);
    }

    private String a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(TapHttpUtil.HMAC_SHA1);
        mac.init(new SecretKeySpec(str2.getBytes(), TapHttpUtil.HMAC_SHA1));
        return new String(Base64.encode(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2), StandardCharsets.UTF_8);
    }

    private List<com.tapsdk.tapad.internal.tracker.experiment.entities.b.c> a(Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(com.tapsdk.tapad.internal.tracker.experiment.entities.b.c.T5().a(entry.getKey()).b(entry.getValue()).build());
        }
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            arrayList.add(com.tapsdk.tapad.internal.tracker.experiment.entities.b.c.T5().a(entry2.getKey()).b(entry2.getValue()).build());
        }
        return arrayList;
    }

    private void a(ExpTdsTrackerConfig expTdsTrackerConfig) {
        com.tapsdk.tapad.internal.utils.f.a(expTdsTrackerConfig.o);
    }

    private void a(ExpTdsTrackerConfig expTdsTrackerConfig, long j) {
        removeMessages(3);
        Message messageObtain = Message.obtain(this, 3);
        messageObtain.obj = expTdsTrackerConfig;
        sendMessageDelayed(messageObtain, j);
    }

    private boolean a() {
        if (this.a || this.b) {
            return false;
        }
        return e();
    }

    private boolean a(List<ExpTrackMessage> list) {
        boolean z = list != null && list.size() >= 2000;
        if (z) {
            ExpTdsTrackerConfig expTdsTrackerConfig = list.get(0).tdsTrackerConfig;
            list.clear();
            c(expTdsTrackerConfig);
            a(expTdsTrackerConfig);
            HashMap map = new HashMap();
            map.put(q, 0);
            PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject = this.d;
            if (publishSubject != null) {
                publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTdsTrackerConfig.g, o, map));
            }
        }
        return z;
    }

    private com.tapsdk.tapad.internal.tracker.experiment.entities.b.e b(List<ExpTrackMessage> list) {
        com.tapsdk.tapad.internal.tracker.experiment.entities.b.e.a aVarD = com.tapsdk.tapad.internal.tracker.experiment.entities.b.e.b6().d(list.get(0).tdsTrackerConfig.g);
        aVarD.b(c(list));
        return aVarD.build();
    }

    private Map<String, String> b(ExpTdsTrackerConfig expTdsTrackerConfig) {
        HashMap map = new HashMap();
        map.put("sdk_version", String.valueOf(expTdsTrackerConfig.i));
        map.put(a.b, String.valueOf(expTdsTrackerConfig.j));
        map.put("device_id", GUIDHelper.INSTANCE.getUID());
        map.put("t_log_id", UUID.randomUUID().toString());
        map.put("version", b.a);
        map.put("dv", com.tapsdk.tapad.internal.tracker.experiment.j.b.d());
        map.put("md", com.tapsdk.tapad.internal.tracker.experiment.j.b.e());
        map.put("cpu", com.tapsdk.tapad.internal.tracker.experiment.j.b.a());
        map.put(a.i, expTdsTrackerConfig.p);
        map.put("app_version", expTdsTrackerConfig.n);
        map.put("ram", expTdsTrackerConfig.q);
        map.put("rom", expTdsTrackerConfig.r);
        map.put("network_type", expTdsTrackerConfig.s);
        map.put("mobile_type", expTdsTrackerConfig.t);
        map.put("os", com.tapsdk.tapad.internal.tracker.experiment.j.b.g());
        map.put("sv", com.tapsdk.tapad.internal.tracker.experiment.j.b.f());
        return map;
    }

    private void b() {
        for (Map.Entry<String, CopyOnWriteArrayList<ExpTrackMessage>> entry : this.i.entrySet()) {
            if (entry.getValue() != null) {
                CopyOnWriteArrayList<ExpTrackMessage> value = entry.getValue();
                while (value.size() > 0) {
                    ExpTdsTrackerConfig expTdsTrackerConfig = value.get(0).tdsTrackerConfig;
                    int iMin = Math.min(value.size(), expTdsTrackerConfig.f);
                    try {
                        if (a(value)) {
                            return;
                        }
                        List<ExpTrackMessage> listSubList = value.subList(0, iMin);
                        int iE = e(listSubList);
                        if (iE != 200) {
                            if (iE >= 400 && iE < 500) {
                                this.b = true;
                                a(expTdsTrackerConfig);
                                return;
                            } else if (iE < 500 || iE >= 600) {
                                g();
                                return;
                            } else {
                                this.a = true;
                                return;
                            }
                        }
                        value.removeAll(listSubList);
                        c(expTdsTrackerConfig);
                        HashMap map = new HashMap();
                        map.put(q, Integer.valueOf(value.size()));
                        PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject = this.d;
                        if (publishSubject != null) {
                            publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTdsTrackerConfig.g, o, map));
                        }
                    } catch (Exception e) {
                        g();
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    private long c() {
        return new Date().getTime() / 1000;
    }

    private List<com.tapsdk.tapad.internal.tracker.experiment.entities.b.C0635b> c(List<ExpTrackMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (ExpTrackMessage expTrackMessage : list) {
            Log.d("trackerData", "contents:" + expTrackMessage.logContentsMap + "\n common params" + expTrackMessage.logCommonParams + "\n");
            arrayList.add(com.tapsdk.tapad.internal.tracker.experiment.entities.b.C0635b.V5().p0((int) expTrackMessage.createTime).a(a(expTrackMessage.logContentsMap, expTrackMessage.logCommonParams)).build());
        }
        return arrayList;
    }

    private void c(ExpTdsTrackerConfig expTdsTrackerConfig) {
        if (this.j == null) {
            return;
        }
        System.currentTimeMillis();
        String str = expTdsTrackerConfig.o;
        com.tapsdk.tapad.internal.tracker.experiment.entities.a<Integer, byte[]> aVarA = a(expTdsTrackerConfig.g);
        int iIntValue = aVarA.a.intValue();
        byte[] bArr = aVarA.b;
        Set<String> setA = this.j.a(l, new HashSet());
        if (bArr == null) {
            setA.remove(expTdsTrackerConfig.o);
            this.j.b(expTdsTrackerConfig.g + n, 0);
            this.j.b(expTdsTrackerConfig.g + m, 0);
            com.tapsdk.tapad.internal.utils.f.a(str);
        } else {
            this.j.b(expTdsTrackerConfig.g + n, bArr.length);
            this.j.b(expTdsTrackerConfig.g + m, iIntValue);
            setA.add(expTdsTrackerConfig.o);
            com.tapsdk.tapad.internal.utils.f.a(com.tapsdk.tapad.internal.tracker.experiment.j.e.a(bArr), str);
        }
        this.j.b(l, setA);
    }

    private String d() {
        return String.valueOf(c());
    }

    private void d(ExpTdsTrackerConfig expTdsTrackerConfig) {
        removeMessages(3);
        Message messageObtain = Message.obtain(this, 3);
        messageObtain.obj = expTdsTrackerConfig;
        sendMessage(messageObtain);
    }

    private byte[] d(List<ExpTrackMessage> list) {
        return b(list).toByteArray();
    }

    private int e(List<ExpTrackMessage> list) {
        String strA;
        if (this.a) {
            return -1;
        }
        ExpTdsTrackerConfig expTdsTrackerConfig = list.get(0).tdsTrackerConfig;
        try {
            byte[] bArrD = d(list);
            byte[] bArrA = com.tapsdk.tapad.internal.tracker.experiment.j.e.a(bArrD);
            HashMap map = new HashMap();
            String upperCase = com.tapsdk.tapad.internal.tracker.experiment.j.a.a(bArrA).toUpperCase();
            String strD = d();
            Object[] objArr = new Object[5];
            objArr[0] = upperCase;
            objArr[1] = Integer.valueOf(bArrD.length);
            objArr[2] = strD;
            try {
                objArr[3] = expTdsTrackerConfig.a;
                objArr[4] = expTdsTrackerConfig.c;
                try {
                    strA = a(String.format("POST\n%s\napplication/x-protobuf\nx-log-apiversion:0.6.0\nx-log-bodyrawsize:%d\nx-log-compresstype:lz4\nx-log-signaturemethod:hmac-sha1\nx-log-timestamp:%s\n/putrecords/%s/%s", objArr), expTdsTrackerConfig.e);
                } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    strA = "";
                }
                String str = String.format("LOG %s:%s", expTdsTrackerConfig.d, strA);
                map.put("x-log-timestamp", strD);
                map.put("Content-MD5", upperCase);
                map.put("Content-Length", String.valueOf(bArrA.length));
                map.put("x-log-bodyrawsize", String.valueOf(bArrD.length));
                map.put("Authorization", str);
                map.put("Content-Type", "application/x-protobuf");
                map.put("x-log-apiversion", "0.6.0");
                map.put("x-log-compresstype", "lz4");
                map.put("x-log-signaturemethod", "hmac-sha1");
                map.put("Host", expTdsTrackerConfig.b);
                map.put("accept", "*/*");
                map.put("Accept-Encoding", "identity");
                String strB = v.a().b(expTdsTrackerConfig.b);
                if (!TextUtils.isEmpty(strB)) {
                    map.put("user-agent", strB);
                }
                ExpTrackMessage expTrackMessage = list.get(0);
                if (expTrackMessage.logContentsMap.containsKey("is_sdk_debug")) {
                    map.put("is_sdk_debug", expTrackMessage.logContentsMap.get("is_sdk_debug"));
                }
                return this.g.a("https://" + expTdsTrackerConfig.b + "/putrecords/" + expTdsTrackerConfig.a + "/" + expTdsTrackerConfig.c, (Map<String, String>) null, map, bArrA);
            } catch (Throwable unused) {
                return -1;
            }
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private boolean e() {
        Iterator<Map.Entry<String, CopyOnWriteArrayList<ExpTrackMessage>>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().size() > 0) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        com.tapsdk.tapad.internal.u.a aVar = this.j;
        if (aVar == null) {
            return;
        }
        for (String str : aVar.a(l, new HashSet())) {
            try {
                String strSubstring = str.substring(str.lastIndexOf("/")).substring(1);
                List<ExpTrackMessage> arrayList = ((ExpTrackMessageList) com.tapsdk.tapad.internal.tracker.experiment.j.g.a(com.tapsdk.tapad.internal.tracker.experiment.j.e.a(com.tapsdk.tapad.internal.utils.f.b(str), this.j.a(strSubstring + n, 0)), ExpTrackMessageList.CREATOR)).trackMessageList;
                if (com.tapsdk.tapad.internal.tracker.experiment.j.d.a(arrayList)) {
                    arrayList = new ArrayList();
                }
                for (ExpTrackMessage expTrackMessage : arrayList) {
                    if (expTrackMessage != null && expTrackMessage.tdsTrackerConfig != null && !TextUtils.isEmpty(expTrackMessage.tdsTrackerConfig.g)) {
                        CopyOnWriteArrayList<ExpTrackMessage> copyOnWriteArrayList = this.i.get(expTrackMessage.tdsTrackerConfig.g);
                        if (copyOnWriteArrayList == null) {
                            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                            this.i.put(expTrackMessage.tdsTrackerConfig.g, copyOnWriteArrayList);
                        }
                        copyOnWriteArrayList.add(expTrackMessage);
                    }
                }
                HashMap map = new HashMap();
                map.put(q, Integer.valueOf(arrayList.size()));
                PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject = this.d;
                if (publishSubject != null) {
                    publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(strSubstring, o, map));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (a()) {
            b();
        }
    }

    private void g() {
        removeMessages(2);
        sendMessageDelayed(Message.obtain(this, 2), 5000L);
    }

    private void h() {
        sendMessage(Message.obtain(this, 0));
    }

    public void a(Application application) {
        if (this.c == null || application == null) {
            return;
        }
        this.c = application;
        h();
    }

    public void a(ExpTdsTrackerConfig expTdsTrackerConfig, Map<String, String> map) {
        sendMessage(Message.obtain(this, 1, new ExpTrackMessage(expTdsTrackerConfig, map, c(), b(expTdsTrackerConfig))));
    }

    public void a(ExpTrackMessage expTrackMessage) {
        CopyOnWriteArrayList<ExpTrackMessage> copyOnWriteArrayList;
        ExpTdsTrackerConfig expTdsTrackerConfig = expTrackMessage.tdsTrackerConfig;
        if (this.i.containsKey(expTdsTrackerConfig.g)) {
            copyOnWriteArrayList = this.i.get(expTdsTrackerConfig.g);
        } else {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.i.put(expTdsTrackerConfig.g, copyOnWriteArrayList);
        }
        if (copyOnWriteArrayList == null || a(copyOnWriteArrayList)) {
            return;
        }
        copyOnWriteArrayList.add(expTrackMessage);
        HashMap map = new HashMap();
        map.put(q, String.valueOf(copyOnWriteArrayList.size()));
        PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject = this.d;
        if (publishSubject != null) {
            publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTdsTrackerConfig.g, o, map));
        }
        com.tapsdk.tapad.internal.u.a aVar = this.j;
        if (aVar != null) {
            aVar.b(expTdsTrackerConfig.g + m, copyOnWriteArrayList.size());
        }
        while (true) {
            int size = copyOnWriteArrayList.size();
            int i = expTdsTrackerConfig.f;
            if (size < i) {
                break;
            }
            List<ExpTrackMessage> listSubList = copyOnWriteArrayList.subList(0, i);
            if (e(listSubList) != 200) {
                break;
            }
            copyOnWriteArrayList.removeAll(listSubList);
            c(expTdsTrackerConfig);
            HashMap map2 = new HashMap();
            map2.put(q, String.valueOf(copyOnWriteArrayList.size()));
            PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject2 = this.d;
            if (publishSubject2 != null) {
                publishSubject2.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTdsTrackerConfig.g, o, map2));
            }
        }
        if (a()) {
            g();
        }
    }

    public void a(PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject) {
        if (this.d != null || publishSubject == null) {
            return;
        }
        this.d = publishSubject;
    }

    public void a(String str, com.tapsdk.tapad.internal.tracker.experiment.i.a aVar) {
        this.h.put(str, aVar);
    }

    public void a(Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> map) {
        this.h = map;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ba, blocks: (B:2:0x0000, B:10:0x000f, B:12:0x001b, B:15:0x0024, B:16:0x002d, B:17:0x0038, B:18:0x003d, B:21:0x0044, B:23:0x0054, B:25:0x0062, B:30:0x0072, B:32:0x0079, B:34:0x0088, B:35:0x0096, B:37:0x00a3, B:39:0x00a7, B:40:0x00aa, B:27:0x0069, B:41:0x00b0, B:43:0x00b4), top: B:48:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:2:0x0000, B:10:0x000f, B:12:0x001b, B:15:0x0024, B:16:0x002d, B:17:0x0038, B:18:0x003d, B:21:0x0044, B:23:0x0054, B:25:0x0062, B:30:0x0072, B:32:0x0079, B:34:0x0088, B:35:0x0096, B:37:0x00a3, B:39:0x00a7, B:40:0x00aa, B:27:0x0069, B:41:0x00b0, B:43:0x00b4), top: B:48:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        HashMap map;
        PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject;
        try {
            int i = message.what;
            boolean zA = true;
            if (i == 0) {
                if (this.e) {
                    return;
                }
                f();
                this.e = true;
                return;
            }
            if (i != 1) {
                if (i == 2) {
                    b();
                    return;
                }
                if (i != 3) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j = this.f;
                if (j != -1 && jUptimeMillis - j <= 500) {
                    a((ExpTdsTrackerConfig) message.obj, 500L);
                    return;
                }
                c((ExpTdsTrackerConfig) message.obj);
                this.f = jUptimeMillis;
                return;
            }
            if (message.obj instanceof ExpTrackMessage) {
                ExpTrackMessage expTrackMessage = (ExpTrackMessage) message.obj;
                if (this.h.containsKey(expTrackMessage.tdsTrackerConfig.g)) {
                    com.tapsdk.tapad.internal.tracker.experiment.i.a aVar = this.h.get(expTrackMessage.tdsTrackerConfig.g);
                    if (aVar != null) {
                        zA = aVar.a(expTrackMessage);
                    } else {
                        str = "ExpTdsTrackerHandler handleMessage logSampleCondition config error";
                    }
                    if (zA) {
                        map = new HashMap();
                        map.put(q, expTrackMessage.logContentsMap.get("tds_user_id"));
                        publishSubject = this.d;
                        if (publishSubject != null) {
                            publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTrackMessage.tdsTrackerConfig.g, p, map));
                        }
                        y.add(expTrackMessage.tdsTrackerConfig.o);
                        if (!this.a && !this.b) {
                            a(expTrackMessage);
                        }
                        d(expTrackMessage.tdsTrackerConfig);
                    }
                }
                str = "ExpTdsTrackerHandler handleMessage logSampleCondition not config";
                TapADLogger.e(str);
                if (zA) {
                    map = new HashMap();
                    map.put(q, expTrackMessage.logContentsMap.get("tds_user_id"));
                    publishSubject = this.d;
                    if (publishSubject != null) {
                        publishSubject.onNext(new com.tapsdk.tapad.internal.tracker.experiment.entities.c(expTrackMessage.tdsTrackerConfig.g, p, map));
                    }
                    y.add(expTrackMessage.tdsTrackerConfig.o);
                    if (!this.a) {
                        a(expTrackMessage);
                    }
                    d(expTrackMessage.tdsTrackerConfig);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
