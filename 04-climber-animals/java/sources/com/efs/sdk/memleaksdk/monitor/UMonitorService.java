package com.efs.sdk.memleaksdk.monitor;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.d.j;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers;
import com.efs.sdk.memleaksdk.monitor.shark.ApplicationLeak;
import com.efs.sdk.memleaksdk.monitor.shark.HeapAnalyzer;
import com.efs.sdk.memleaksdk.monitor.shark.HeapField;
import com.efs.sdk.memleaksdk.monitor.shark.HeapGraph;
import com.efs.sdk.memleaksdk.monitor.shark.HeapObject;
import com.efs.sdk.memleaksdk.monitor.shark.HprofHeapGraph;
import com.efs.sdk.memleaksdk.monitor.shark.HprofRecordTag;
import com.efs.sdk.memleaksdk.monitor.shark.LeakTrace;
import com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference;
import com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener;
import com.efs.sdk.memleaksdk.monitor.shark.ProguardMapping;
import com.efs.sdk.memleaksdk.monitor.shark.aa;
import com.efs.sdk.memleaksdk.monitor.shark.ah;
import com.efs.sdk.memleaksdk.monitor.shark.e;
import com.efs.sdk.memleaksdk.monitor.shark.g;
import com.efs.sdk.memleaksdk.monitor.shark.z;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class UMonitorService extends IntentService {
    private static final String ACTIVITY_CLASS_NAME = "android.app.Activity";
    private static final String ANDROIDX_FRAGMENT_CLASS_NAME = "androidx.fragment.app.Fragment";
    private static final String CURRENT_PAGE = "CURRENT_PAGE";
    private static final String DESTROYED_FIELD_NAME = "mDestroyed";
    private static final String FD = "FD";
    private static final String FINISHED_FIELD_NAME = "mFinished";
    private static final String FRAGMENT_MANAGER_FIELD_NAME = "mFragmentManager";
    private static final String FRAGMENT_MCALLED_FIELD_NAME = "mCalled";
    public static final String HPROF_FILE = "HPROF_FILE";
    public static final String JSON_FILE = "JSON_FILE";
    private static final String MANUFACTURE = "MANUFACTURE";
    private static final String MODEL = "MODEL";
    private static final String NATIVE_FRAGMENT_CLASS_NAME = "android.app.Fragment";
    private static final String REASON = "REASON";
    public static final String RESULT_RECEIVER = "RESULT_RECEIVER";
    public static final String ROOT_PATH = "ROOT_PATH";
    private static final String SDK = "SDK";
    private static final String SUPPORT_FRAGMENT_CLASS_NAME = "androidx.fragment.app.Fragment";
    private static final String TAG = "UMonitor.Service";
    private static final String THREAD = "THREAD";
    private static final String TIME = "TIME";
    private static final String USAGE_TIME = "USAGE_TIME";
    private HeapGraph mHeapGraph;
    private final aa mLeakModel;
    private final Map<Long, String> mLeakReasonTable;
    private final Set<Long> mLeakingObjectIds;

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(RESULT_RECEIVER);
        try {
            String stringExtra = intent.getStringExtra(HPROF_FILE);
            String stringExtra2 = intent.getStringExtra(JSON_FILE);
            e.a(getApplicationContext(), intent.getStringExtra(ROOT_PATH));
            buildIndex(stringExtra);
            buildJson(intent);
            filterLeakingObjects();
            findPathsToGcRoot();
            if (this.mLeakModel.a()) {
                fillJsonFile(stringExtra2);
                if (resultReceiver != null) {
                    resultReceiver.send(1001, null);
                }
            } else {
                g.b(TAG, "not found leak");
                if (resultReceiver != null) {
                    resultReceiver.send(1003, null);
                }
            }
        } catch (Throwable th) {
            g.b(TAG, "onHandleIntent", th);
            if (resultReceiver != null) {
                try {
                    resultReceiver.send(1002, null);
                } catch (Throwable th2) {
                    g.b(TAG, "send result failed", th2);
                }
            }
        }
        System.exit(0);
    }

    private void buildIndex(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g.b(TAG, "start analyze");
        HashSet hashSet = new HashSet();
        hashSet.add(HprofRecordTag.ROOT_JNI_GLOBAL);
        hashSet.add(HprofRecordTag.ROOT_JNI_LOCAL);
        hashSet.add(HprofRecordTag.ROOT_NATIVE_STACK);
        hashSet.add(HprofRecordTag.ROOT_STICKY_CLASS);
        hashSet.add(HprofRecordTag.ROOT_THREAD_BLOCK);
        hashSet.add(HprofRecordTag.ROOT_THREAD_OBJECT);
        this.mHeapGraph = HprofHeapGraph.a.a(new File(str), (ProguardMapping) null, hashSet);
    }

    private void buildJson(Intent intent) throws Throwable {
        if (intent == null) {
            return;
        }
        final aa.c cVar = new aa.c();
        this.mLeakModel.a = cVar;
        cVar.a = intent.getStringExtra(THREAD);
        cVar.b = intent.getStringExtra(FD);
        cVar.e = intent.getStringExtra(SDK);
        cVar.f = intent.getStringExtra(MANUFACTURE);
        cVar.g = intent.getStringExtra(MODEL);
        cVar.j = intent.getStringExtra(USAGE_TIME);
        cVar.i = intent.getStringExtra(CURRENT_PAGE);
        cVar.k = intent.getStringExtra(TIME);
        cVar.l = intent.getStringExtra(REASON);
        File fileA = e.a(e.e());
        e.a(fileA, new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.1
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                cVar.d.add(str);
                return true;
            }
        });
        fileA.delete();
        File fileA2 = e.a(e.d());
        e.a(fileA2, new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.2
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                cVar.c.add(str);
                return true;
            }
        });
        fileA2.delete();
    }

    private void filterLeakingObjects() {
        HeapField heapFieldB;
        HeapField heapFieldB2;
        Boolean boolA;
        HeapField heapFieldB3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        g.b(TAG, "filterLeakingObjects " + Thread.currentThread());
        HeapGraph heapGraph = this.mHeapGraph;
        if (heapGraph == null) {
            return;
        }
        HeapObject.b bVarA = heapGraph.a(ACTIVITY_CLASS_NAME);
        HeapObject.b bVarA2 = this.mHeapGraph.a("androidx.fragment.app.Fragment");
        if (bVarA2 == null && (bVarA2 = this.mHeapGraph.a(NATIVE_FRAGMENT_CLASS_NAME)) == null) {
            bVarA2 = this.mHeapGraph.a("androidx.fragment.app.Fragment");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<HeapObject.c> it = this.mHeapGraph.e().iterator();
        while (it.hasNext()) {
            HeapObject.c next = it.next();
            if (!next.f()) {
                long j = next.c.a;
                Pair pairCreate = (Pair) linkedHashMap.get(Long.valueOf(j));
                if (pairCreate == null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<HeapObject.b> it2 = next.i().k().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                    pairCreate = Pair.create(Long.valueOf(arrayList.size() >= 2 ? ((HeapObject.b) arrayList.get(arrayList.size() - 2)).getE() : 0L), Long.valueOf(arrayList.size() >= 5 ? ((HeapObject.b) arrayList.get(arrayList.size() - 5)).getE() : 0L));
                    linkedHashMap.put(Long.valueOf(j), pairCreate);
                } else {
                    it = it;
                }
                if (bVarA != null && bVarA.getE() == ((Long) pairCreate.second).longValue()) {
                    HeapField heapFieldB4 = next.b(ACTIVITY_CLASS_NAME, DESTROYED_FIELD_NAME);
                    if (heapFieldB4 != null && (heapFieldB3 = next.b(ACTIVITY_CLASS_NAME, FINISHED_FIELD_NAME)) != null) {
                        Boolean boolA2 = heapFieldB4.c.a();
                        Boolean boolA3 = heapFieldB3.c.a();
                        if (boolA2 == Boolean.TRUE || boolA3 == Boolean.TRUE) {
                            updateClassObjectCounterMap(linkedHashMap2, j, true);
                            g.b(TAG, "activity name : " + next.h() + " mDestroyed:" + boolA2 + " mFinished:" + boolA3 + " objectId:" + (next.getE() & 4294967295L));
                            this.mLeakingObjectIds.add(Long.valueOf(next.getE()));
                            this.mLeakReasonTable.put(Long.valueOf(next.getE()), "Activity Leak");
                            g.b(TAG, next.h() + " objectId:" + next.getE());
                        }
                    }
                } else if (bVarA2 != null && bVarA2.getE() == ((Long) pairCreate.first).longValue() && (heapFieldB = next.b(bVarA2.f(), FRAGMENT_MANAGER_FIELD_NAME)) != null && heapFieldB.c.f() != null && (heapFieldB2 = next.b(bVarA2.f(), FRAGMENT_MCALLED_FIELD_NAME)) != null && (boolA = heapFieldB2.c.a()) != null) {
                    updateClassObjectCounterMap(linkedHashMap2, j, boolA.booleanValue());
                    g.b(TAG, "fragment name:" + next.h() + " isLeak:" + boolA);
                    if (boolA.booleanValue()) {
                        this.mLeakingObjectIds.add(Long.valueOf(next.getE()));
                        this.mLeakReasonTable.put(Long.valueOf(next.getE()), "Fragment Leak");
                        g.b(TAG, next.h() + " objectId:" + next.getE());
                    }
                }
                it = it;
                jCurrentTimeMillis = jCurrentTimeMillis;
            }
        }
        long j2 = jCurrentTimeMillis;
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            aa.a aVar = new aa.a();
            HeapObject.b bVarD = this.mHeapGraph.a(((Long) entry.getKey()).longValue()).d();
            if (bVarD != null) {
                aVar.a = bVarD.f();
            }
            aVar.b = ((a) entry.getValue()).a + "";
            this.mLeakModel.c.add(aVar);
            g.b(TAG, String.format(Locale.US, "class: %s, leak count:%s", aVar.a, aVar.b));
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (this.mLeakModel.a != null) {
            this.mLeakModel.a.o = ((jCurrentTimeMillis2 - j2) / 1000.0f) + "";
        }
        g.b(TAG, "filter leaking objects cost: " + ((jCurrentTimeMillis2 - j2) / 1000.0f) + "s");
    }

    private void findPathsToGcRoot() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeapAnalyzer.c cVarA = new HeapAnalyzer(new OnAnalysisProgressListener() { // from class: com.efs.sdk.memleaksdk.monitor.UMonitorService.3
            @Override // com.efs.sdk.memleaksdk.monitor.shark.OnAnalysisProgressListener
            public void a(OnAnalysisProgressListener.b bVar) {
                g.b(UMonitorService.TAG, "heap analysis start: " + bVar.name());
            }
        }).a(new HeapAnalyzer.a(this.mHeapGraph, AndroidReferenceMatchers.b(), true, new ArrayList()), this.mLeakingObjectIds);
        g.b(TAG, "size: " + cVarA.a.size());
        for (ApplicationLeak applicationLeak : cVarA.a) {
            g.b(TAG, applicationLeak.b() + ", signature:" + applicationLeak.a() + ", trace size:" + applicationLeak.c().size());
            List<LeakTrace> listC = applicationLeak.c();
            if (!listC.isEmpty()) {
                LeakTrace leakTrace = listC.get(0);
                String str = leakTrace.a.j;
                Set<String> set = leakTrace.c.c;
                leakTrace.c.a(String.valueOf(this.mLeakReasonTable.get(Long.valueOf(leakTrace.c.a))));
                g.b(TAG, str + ", class:" + leakTrace.c.b + ", type:" + leakTrace.c.b() + ", labels:" + set + ", reason:" + leakTrace.c.e + ", objId:" + (leakTrace.c.a & 4294967295L));
                aa.b bVar = new aa.b();
                bVar.c = str;
                bVar.d = leakTrace.c.b;
                bVar.b = leakTrace.c.e;
                bVar.e = applicationLeak.a();
                g.b(TAG, "signature origin: \n" + applicationLeak.c().get(0).toString());
                bVar.a = Integer.valueOf(applicationLeak.c().size());
                this.mLeakModel.b.add(bVar);
                for (LeakTraceReference leakTraceReference : leakTrace.b) {
                    String str2 = leakTraceReference.a.b;
                    String strB = leakTraceReference.b();
                    aa.b.a aVar = new aa.b.a();
                    if (strB.startsWith("[")) {
                        aVar.a = "array " + str2 + ".[" + leakTraceReference.a.g + "]";
                    } else {
                        aVar.a = str2 + j.z + strB;
                    }
                    g.a(TAG, "\t" + aVar.a);
                    bVar.g.add(aVar);
                }
                aa.b.a aVar2 = new aa.b.a();
                aVar2.a = leakTrace.c.b;
                bVar.f = leakTrace.c.f + "";
                bVar.g.add(aVar2);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (this.mLeakModel.a != null) {
            this.mLeakModel.a.p = ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0f) + "";
        }
        g.b(TAG, "find paths to GcRoot cost: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0f) + "s");
    }

    private void fillJsonFile(String str) throws Throwable {
        try {
            e.a(new File(str), this.mLeakModel.b().toString());
        } catch (Exception e) {
            g.b(TAG, "json write failed", e);
        }
    }

    private a updateClassObjectCounterMap(Map<Long, a> map, long j, boolean z) {
        a aVar = map.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a((byte) 0);
            map.put(Long.valueOf(j), aVar);
        }
        aVar.a++;
        if (z) {
            aVar.b++;
        }
        return aVar;
    }

    public UMonitorService() {
        super("UMonitorService");
        this.mLeakModel = new aa();
        this.mLeakingObjectIds = new HashSet();
        this.mLeakReasonTable = new HashMap();
    }

    static final class a {
        int a;
        int b;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void startAnalysisService(Context context, String str, String str2, z zVar, UMonitorHeapResult.a aVar) {
        try {
            g.b(TAG, "startService");
            UMonitorHeapResult uMonitorHeapResult = new UMonitorHeapResult();
            uMonitorHeapResult.a(aVar);
            Intent intent = new Intent(context, (Class<?>) UMonitorService.class);
            intent.putExtra(HPROF_FILE, str);
            intent.putExtra(JSON_FILE, str2);
            intent.putExtra(ROOT_PATH, e.a().getPath());
            intent.putExtra(RESULT_RECEIVER, uMonitorHeapResult);
            File[] fileArrListFiles = new File("/proc/self/fd").listFiles();
            intent.putExtra(FD, String.valueOf(fileArrListFiles != null ? fileArrListFiles.length : 0));
            intent.putExtra(THREAD, String.valueOf(ah.e.a));
            intent.putExtra(MANUFACTURE, Build.MANUFACTURER);
            if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion()) {
                intent.putExtra(SDK, String.valueOf(Build.VERSION.SDK_INT));
            } else {
                intent.putExtra(SDK, "UNKNOWN");
            }
            if (ControllerCenter.getGlobalEnvStruct().getCustomController() != null && !ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel()) {
                intent.putExtra(MODEL, "UNKNOWN");
            } else {
                intent.putExtra(MODEL, Build.MODEL);
            }
            intent.putExtra(TIME, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.CHINESE).format(new Date()));
            if (zVar.a != null) {
                intent.putExtra(REASON, zVar.a);
            }
            if (zVar.c != null) {
                intent.putExtra(CURRENT_PAGE, zVar.c);
            }
            if (zVar.b != null) {
                intent.putExtra(USAGE_TIME, zVar.b);
            }
            context.startService(intent);
        } catch (Throwable th) {
            g.b(TAG, "startAnalysisService", th);
        }
    }
}
