package com.tapsdk.tapad.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.download.StatusUtil;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.ApkUrlInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.TapAdResp;
import com.tapsdk.tapad.model.entities.UninstalledAdInfo;
import com.umeng.analytics.pro.bv;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String p = "APKDownload";
    private static String q = null;
    public static final int r = 0;
    public static final int s = 1;
    private static final int t = 1;
    private static final int u = 2;
    private static final int v = -1;
    private static final int w = 3;
    private final AdInfo a;
    private com.tapsdk.tapad.internal.download.f b;
    private int c;
    private boolean d;
    private int e;
    private final Context f;
    private com.tapsdk.tapad.internal.ui.views.a g;
    private com.tapsdk.tapad.internal.download.m.i.e h;
    private l i;
    private final long j;
    private Timer k;
    private final AtomicBoolean l;
    private final AtomicInteger m;
    private final AtomicInteger n;
    private final Handler o;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.a$a, reason: collision with other inner class name */
    class C0602a implements FileFilter {
        C0602a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(com.anythink.dlopt.common.a.a.h);
        }
    }

    class b implements ObservableOnSubscribe<com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, Long>> {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, Long>> observableEmitter) {
            Boolean bool;
            long jC = a.this.c();
            if (a.this.a.appInfo.apkVerifyType == AppInfo.ApkVerifyType.APK_VERIFY_TYPE_NOT_VERIFY) {
                bool = Boolean.TRUE;
            } else {
                if (a.this.a.appInfo.apkSize >= 0) {
                    if (jC >= a.this.a.appInfo.apkSize) {
                        observableEmitter.onNext(com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(Boolean.TRUE, Long.valueOf(jC)));
                        observableEmitter.onComplete();
                        return;
                    } else {
                        a.this.b(this.a);
                        long jC2 = a.this.c();
                        observableEmitter.onNext(com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(Boolean.valueOf(jC2 >= a.this.a.appInfo.apkSize), Long.valueOf(jC2)));
                        return;
                    }
                }
                bool = Boolean.FALSE;
            }
            observableEmitter.onNext(com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(bool, Long.valueOf(jC)));
            observableEmitter.onComplete();
        }
    }

    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (a.this.i == null) {
                TapADLogger.d("APKDownload download " + i + " apkDownloadListener is null");
                return;
            }
            if (i == -1) {
                try {
                    int i2 = message.arg1;
                    Exception exc = (Exception) message.obj;
                    a.this.i.a(i2, "message:" + (exc != null ? exc.getMessage() : "no exception message") + ",class:" + (message.obj != null ? message.obj.getClass().getName() : "no exception class"));
                    a.this.i.a(i2, exc);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (i == 1) {
                a.this.i.a(new File((String) message.obj));
                TapADLogger.d("ApkDownload handleMessage DOWNLOAD_SUCCESS");
            } else if (i == 2) {
                a.this.i.a(message.arg1);
            } else if (i == 3 && (message.obj instanceof String)) {
                a.this.i.a(3, (String) message.obj);
            }
        }
    }

    class d implements Consumer<com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, Long>> {
        final /* synthetic */ ApkUrlInfo a;

        d(ApkUrlInfo apkUrlInfo) {
            this.a = apkUrlInfo;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, Long> aVar) {
            String str;
            if (!aVar.a.booleanValue()) {
                if (a.this.i != null) {
                    String str2 = "APKDownload start no enough storage(apkSize:" + (a.this.a.appInfo != null ? a.this.a.appInfo.apkSize : -1L) + ",storage:" + aVar.b + ")";
                    TapADLogger.e(str2);
                    a.this.i.a(2, str2);
                    a.this.i.a(2, new RuntimeException(str2));
                    return;
                }
                return;
            }
            boolean zA = a.this.a(this.a);
            if (a.this.b != null) {
                if (zA) {
                    if (a.this.d) {
                        a aVar2 = a.this;
                        aVar2.d(aVar2.f);
                        m.a().a(a.this.b, a.this.g);
                    }
                    com.tapsdk.tapad.internal.download.g.a().a(a.this);
                    m.a().a(a.this.b, a.this.h);
                    m.a().a(a.this.b.b());
                    m.a().c(a.this.b, a.this.h);
                    str = "APKDownload start download task id = " + a.this.b.b();
                } else {
                    if (a.this.e == 1) {
                        return;
                    }
                    m.a().a(a.this.b, a.this.h);
                    str = "APKDownload same task is running just return";
                }
                TapADLogger.d(str);
            }
        }
    }

    class e implements Consumer<Throwable> {
        e() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class f extends TimerTask {
        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AtomicInteger atomicInteger;
            int i = 0;
            if (!m.a().d(a.this.b, a.this.h)) {
                a.this.k.cancel();
                a.this.l.set(false);
                atomicInteger = a.this.m;
            } else {
                if (a.this.m.get() > 5) {
                    TapADLogger.d("APKDownload DownloadTask timeout so cancel ----");
                    com.tapsdk.tapad.internal.download.i.j().e().a(a.this.b.b());
                    a.this.l.set(false);
                    a.this.m.set(0);
                    a.this.k.cancel();
                    return;
                }
                atomicInteger = a.this.m;
                i = a.this.m.get() + 1;
            }
            atomicInteger.set(i);
        }
    }

    class g extends com.tapsdk.tapad.internal.download.m.i.e {
        g() {
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar) {
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i, int i2, Map<String, List<String>> map) {
            if (a.this.n.get() == 0) {
                a.this.n.set(1);
            }
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j, com.tapsdk.tapad.internal.download.k kVar) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar, com.tapsdk.tapad.internal.download.k kVar) {
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
        public void a(com.tapsdk.tapad.internal.download.f fVar, long j, com.tapsdk.tapad.internal.download.k kVar) {
            long jH;
            if (fVar.l() != null) {
                jH = fVar.l().h();
                TapADLogger.d("APKDownload PROGRESS fileTotalLength = " + jH + " currentOffset = " + j);
            } else {
                jH = 0;
            }
            if (jH == 0) {
                return;
            }
            a.this.m.set(0);
            int iMin = Math.min(99, (int) ((j * 100) / jH));
            Message messageObtainMessage = a.this.o.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.arg1 = iMin;
            a.this.o.sendMessage(messageObtainMessage);
            a.this.g();
            TapADLogger.d("APKDownload download progress " + iMin + "%  task name = " + fVar.a() + " listener = " + a.this.h.hashCode());
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
        public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, com.tapsdk.tapad.internal.download.m.i.g.c.b bVar) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
        public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc, com.tapsdk.tapad.internal.download.k kVar) {
            Object exc2;
            String str;
            TapADLogger.d("APKDownload task end name= " + fVar.a() + " state = " + endCause + " realCause = " + (exc == null ? "" : exc.getMessage()));
            a.this.l.set(false);
            a.this.m.set(0);
            if (a.this.k != null) {
                a.this.k.cancel();
            }
            Message messageObtainMessage = a.this.o.obtainMessage();
            if (endCause != EndCause.SAME_TASK_BUSY) {
                if (endCause == EndCause.ERROR) {
                    TapADLogger.d("APKDownload set ERROR message 0");
                    if (com.tapsdk.tapad.internal.utils.d.g(a.this.f)) {
                        if (a.this.i()) {
                            return;
                        }
                        messageObtainMessage.what = -1;
                        messageObtainMessage.arg1 = 7;
                        messageObtainMessage.obj = exc;
                    } else {
                        TapADLogger.d("APKDownload download fail error :  network error");
                        messageObtainMessage.what = -1;
                        messageObtainMessage.arg1 = 1;
                        exc2 = new RuntimeException("network is disconnected");
                        messageObtainMessage.obj = exc2;
                    }
                } else if (endCause == EndCause.FILE_BUSY) {
                    str = "APKDownload set FILE_BUSY message";
                } else {
                    if (endCause == EndCause.COMPLETED) {
                        TapADLogger.d("APKDownload download complete");
                        a.this.a(fVar, endCause, exc);
                        return;
                    }
                    if (endCause == EndCause.CANCELED) {
                        TapADLogger.d("APKDownload set cancel message");
                        messageObtainMessage.what = -1;
                        messageObtainMessage.arg1 = 6;
                        exc2 = new Exception("User cancel:(has_connected_file_server=" + a.this.n.get() + ")");
                    } else {
                        if (endCause == EndCause.PRE_ALLOCATE_FAILED) {
                            TapADLogger.d("APKDownload set pre allocate failed message");
                            messageObtainMessage.what = -1;
                            messageObtainMessage.arg1 = 5;
                            exc2 = exc != null ? "cause:" + exc.getCause() + ",message:" + exc.getMessage() : "no details info";
                        }
                        messageObtainMessage.what = -1;
                        messageObtainMessage.arg1 = 7;
                        messageObtainMessage.obj = exc;
                    }
                    messageObtainMessage.obj = exc2;
                }
                a.this.o.sendMessage(messageObtainMessage);
                m.a().b(fVar, a.this.h);
                m.a().b(fVar, a.this.g);
            }
            str = "APKDownload set SAME_TASK_BUSY message 0";
            TapADLogger.d(str);
            messageObtainMessage.what = -1;
            messageObtainMessage.arg1 = 4;
            messageObtainMessage.obj = exc;
            a.this.o.sendMessage(messageObtainMessage);
            m.a().b(fVar, a.this.h);
            m.a().b(fVar, a.this.g);
        }
    }

    class h implements Consumer<Boolean> {
        final /* synthetic */ com.tapsdk.tapad.internal.download.f a;
        final /* synthetic */ EndCause b;
        final /* synthetic */ Exception c;

        h(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
            this.a = fVar;
            this.b = endCause;
            this.c = exc;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
            Exception exc;
            Message messageObtainMessage = a.this.o.obtainMessage();
            if (bool.booleanValue()) {
                messageObtainMessage.what = 1;
                messageObtainMessage.obj = this.a.h() != null ? this.a.h().getAbsolutePath() : "";
                Intent intent = new Intent(a.this.f, (Class<?>) ApkNotificationReceiver.class);
                intent.putExtra(bv.aw, a.this.a);
                intent.putExtra("download_result", this.b == EndCause.COMPLETED ? 1 : 0);
                intent.putExtra(MediationConstant.KEY_REASON, (this.b == EndCause.COMPLETED || (exc = this.c) == null) ? "" : exc.getMessage());
                if (this.a.h() != null) {
                    intent.putExtra(TTDownloadField.TT_FILE_PATH, this.a.h().getAbsolutePath());
                }
                a.this.f.sendBroadcast(intent);
                if (this.b == EndCause.COMPLETED && a.this.g != null) {
                    a.this.g.a(this.b, this.a);
                }
                if (a.this.a.renderStyles.b == 3 || a.this.a.renderStyles.b == 2) {
                    com.tapsdk.tapad.e.f.a(new UninstalledAdInfo(a.this.a, this.a.h() != null ? this.a.h().getAbsolutePath() : ""));
                }
            } else {
                a.this.b(this.a.h());
                if (a.this.i()) {
                    return;
                }
                if (a.this.g != null) {
                    a.this.g.c(true);
                }
                messageObtainMessage.what = -1;
                messageObtainMessage.arg1 = 0;
                messageObtainMessage.obj = new RuntimeException("no valid url");
            }
            TapADLogger.d("ApkDownload taskEndAction Assemble message");
            a.this.a(bool.booleanValue(), this.b, this.c);
            a.this.a(this.a, messageObtainMessage);
        }
    }

    class i implements Consumer<Throwable> {
        i() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            TapADLogger.e("ApkDownload send deal message fail:" + th.toString());
        }
    }

    class j implements ObservableOnSubscribe<Boolean> {
        final /* synthetic */ com.tapsdk.tapad.internal.download.f a;

        j(com.tapsdk.tapad.internal.download.f fVar) {
            this.a = fVar;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                TapADLogger.d("ApkDownload taskEndAction start checkFileValid");
                boolean zA = a.this.a(this.a.h());
                TapADLogger.d("ApkDownload taskEndAction end checkFileValid valid:" + zA);
                observableEmitter.onNext(Boolean.valueOf(zA));
                observableEmitter.onComplete();
            } catch (Throwable unused) {
                observableEmitter.onNext(Boolean.FALSE);
                observableEmitter.onComplete();
            }
        }
    }

    class k implements FileFilter {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String str = this.a;
            return str != null && str.length() > 0 && file.getName().startsWith(this.a) && file.getName().endsWith(com.anythink.dlopt.common.a.a.h);
        }
    }

    public interface l {
        void a(int i);

        void a(int i, Exception exc);

        void a(int i, String str);

        void a(File file);
    }

    static class m {
        private final com.tapsdk.tapad.internal.download.l a;

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.a$m$a, reason: collision with other inner class name */
        private static class C0603a {
            private static final m a = new m(null);

            private C0603a() {
            }
        }

        private m() {
            this.a = new com.tapsdk.tapad.internal.download.l();
        }

        /* synthetic */ m(c cVar) {
            this();
        }

        static m a() {
            return C0603a.a;
        }

        void a(int i) {
            this.a.a(i);
        }

        void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.c cVar) {
            this.a.b(fVar, cVar);
        }

        void b(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.c cVar) {
            this.a.c(fVar, cVar);
        }

        void c(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.c cVar) {
            this.a.d(fVar, cVar);
        }

        boolean d(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.c cVar) {
            return this.a.f(fVar, cVar);
        }

        void e(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.c cVar) {
            this.a.g(fVar, cVar);
        }
    }

    public a(Context context, AdInfo adInfo, int i2) {
        this.c = 0;
        this.d = false;
        this.e = 0;
        this.j = System.currentTimeMillis() / 1000;
        this.l = new AtomicBoolean(false);
        this.m = new AtomicInteger(0);
        this.n = new AtomicInteger(0);
        this.o = new c(Looper.getMainLooper());
        this.a = adInfo;
        if (i2 == 1) {
            this.d = true;
        }
        this.e = i2;
        this.f = context.getApplicationContext();
        e(context);
        f();
    }

    public a(Context context, AdInfo adInfo, boolean z) {
        this.c = 0;
        this.d = false;
        this.e = 0;
        this.j = System.currentTimeMillis() / 1000;
        this.l = new AtomicBoolean(false);
        this.m = new AtomicInteger(0);
        this.n = new AtomicInteger(0);
        this.o = new c(Looper.getMainLooper());
        this.a = adInfo;
        this.d = z;
        this.f = context.getApplicationContext();
        e(context);
        f();
    }

    private Observable<com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, Long>> a(Context context) {
        return Observable.create(new b(context));
    }

    public static File a(Context context, AdInfo adInfo) {
        return new File(c(context) + File.separator + a(adInfo));
    }

    private File a(Context context, String str) {
        File[] fileArrListFiles;
        try {
            File file = new File(c(context.getApplicationContext()));
            if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles(new k(str))) == null || fileArrListFiles.length <= 0) {
                return null;
            }
            return fileArrListFiles[fileArrListFiles.length - 1];
        } catch (Exception e2) {
            TapADLogger.d("APKDownload delete old cache file fail reason = " + e2.getMessage());
            return null;
        }
    }

    private static String a(AdInfo adInfo) {
        AppInfo appInfo = adInfo.appInfo;
        return appInfo.packageName + "_" + appInfo.apkMd5 + "_" + appInfo.appName;
    }

    public static List<String> a(List<ApkUrlInfo> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ApkUrlInfo apkUrlInfo = list.get(i2);
            if (apkUrlInfo != null && (str = apkUrlInfo.url) != null && str.length() > 0) {
                arrayList.add(apkUrlInfo.url);
            }
        }
        return arrayList;
    }

    private Map<String, List<String>> a(String str) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(v.a().b(str));
        map.put("User-Agent", arrayList);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
        Observable.create(new j(fVar)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(fVar, endCause, exc), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, EndCause endCause, Exception exc) {
        String message = exc != null ? exc.getMessage() : "";
        if (Constants.q.b.equals(message)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.arg1 = 3;
            messageObtain.obj = "ApkDownload Download end result(valid:" + (z ? "valid" : "invalid") + "，endCause:" + endCause + ",realCause:" + message + ")";
            this.o.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.tapsdk.tapad.internal.download.f fVar, Message message) {
        TapADLogger.d("ApkDownload dealMsg start");
        if (message == null) {
            return true;
        }
        TapADLogger.d("ApkDownload dealMsg end");
        Message messageObtainMessage = this.o.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = 100;
        this.o.sendMessage(messageObtainMessage);
        this.o.sendMessage(message);
        m.a().b(fVar, this.h);
        m.a().b(fVar, this.g);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ApkUrlInfo apkUrlInfo) {
        com.tapsdk.tapad.internal.download.f fVarA = new com.tapsdk.tapad.internal.download.f.a(apkUrlInfo.url, q, a(this.a)).a(a(apkUrlInfo.url)).c(1000).c(true).b(apkUrlInfo.apkDownloadType == TapAdResp.ApkDownloadType.ApkDownloadType_default).d(true).a();
        this.b = fVarA;
        fVarA.a((Object) a(this.a));
        if (!StatusUtil.e(this.b)) {
            return true;
        }
        TapADLogger.d("APKDownload init download task find same task");
        com.tapsdk.tapad.internal.download.f fVarE = com.tapsdk.tapad.internal.download.i.j().e().e(this.b);
        if (fVarE == null) {
            return true;
        }
        TapADLogger.d("APKDownload same task state = " + StatusUtil.b(fVarE));
        return (StatusUtil.b(fVarE) == StatusUtil.Status.PENDING || StatusUtil.b(fVarE) == StatusUtil.Status.RUNNING) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(File file) throws Throwable {
        String str;
        if (file == null || !file.exists()) {
            str = "APKDownload checkFileValid file is null or not exists";
        } else {
            AppInfo appInfo = this.a.appInfo;
            if (appInfo.apkVerifyType == AppInfo.ApkVerifyType.APK_VERIFY_TYPE_NOT_VERIFY) {
                return true;
            }
            if (appInfo.apkSize < 0) {
                return false;
            }
            if (Math.abs(file.length() - this.a.appInfo.apkSize) < 10) {
                String strB = com.tapsdk.tapad.internal.utils.f.b(file);
                TapADLogger.d("APKDownload checkFileValid downloadFile md5 = " + strB + " origin md5 = " + this.a.appInfo.apkMd5);
                return TextUtils.isEmpty(this.a.appInfo.apkMd5) || this.a.appInfo.apkMd5.equalsIgnoreCase(strB);
            }
            str = "APKDownload checkFileValid file size not match";
        }
        TapADLogger.d(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        File[] fileArrListFiles;
        try {
            File file = new File(c(context.getApplicationContext()));
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new C0602a())) != null) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            TapADLogger.d("ApkDownload delete file fail reason = " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        try {
            long jA = com.tapsdk.tapad.internal.download.m.c.a(new StatFs(c(this.f)));
            TapADLogger.d("APKDownload getFreeSpaceBytes from statFs:" + jA);
            return jA;
        } catch (Throwable unused) {
            long j2 = com.tapsdk.tapad.internal.utils.d.h()[0];
            TapADLogger.d("APKDownload getFreeSpaceBytes from memory:" + j2);
            return j2;
        }
    }

    private static String c(Context context) {
        File externalCacheDir;
        if (TextUtils.isEmpty(q)) {
            File externalCacheDir2 = context.getApplicationContext().getExternalCacheDir();
            Context applicationContext = context.getApplicationContext();
            if (externalCacheDir2 == null) {
                externalCacheDir = applicationContext.getExternalFilesDir(null);
                if (externalCacheDir != null) {
                }
            } else {
                externalCacheDir = applicationContext.getExternalCacheDir();
            }
            q = externalCacheDir.getAbsolutePath();
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        if (this.g == null) {
            com.tapsdk.tapad.internal.ui.views.a aVar = new com.tapsdk.tapad.internal.ui.views.a(context, this.a);
            this.g = aVar;
            aVar.c();
        }
    }

    private ApkUrlInfo e() {
        List<ApkUrlInfo> list = this.a.appInfo.apkUrls;
        if (list == null || list.isEmpty()) {
            return null;
        }
        a(list);
        for (int i2 = this.c; i2 < list.size(); i2++) {
            long j2 = list.get(i2).expire;
            if (j2 < 946656000) {
                j2 += this.j;
            }
            if (list.get(i2) != null && j2 > System.currentTimeMillis() / 1000) {
                ApkUrlInfo apkUrlInfo = list.get(i2);
                this.c = i2;
                return apkUrlInfo;
            }
        }
        return null;
    }

    private void e(Context context) {
        c(context);
    }

    private void f() {
        if (this.h == null) {
            this.h = new g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.l.get()) {
            return;
        }
        this.l.set(true);
        this.k = new Timer();
        this.k.schedule(new f(), 1000L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        this.c++;
        ApkUrlInfo apkUrlInfoE = e();
        if (apkUrlInfoE == null || TextUtils.isEmpty(apkUrlInfoE.url)) {
            return false;
        }
        TapADLogger.d("APKDownload start download from requestNextUrl");
        j();
        return true;
    }

    public void a() {
        com.tapsdk.tapad.internal.download.f fVar = this.b;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void a(l lVar) {
        TapADLogger.d("ApkDownload set listener");
        this.i = lVar;
    }

    public AdInfo b() {
        return this.a;
    }

    public Object d() {
        return this.b.w();
    }

    public void h() {
        this.i = null;
    }

    public void j() {
        if (this.a.appInfo.apkVerifyType == AppInfo.ApkVerifyType.APK_VERIFY_TYPE_NOT_VERIFY) {
            TapADLogger.d("APKDownload APK type is not verify, don't check the cache file of md5");
        } else {
            File fileA = a(com.tapsdk.tapad.c.a, this.a.appInfo.packageName);
            TapADLogger.d("APKDownload get cached download file:" + (fileA != null ? fileA.getName() : "no file"));
            if (fileA != null) {
                TapADLogger.d("APKDownload " + fileA.getName());
                String name = fileA.getName();
                int iIndexOf = name.indexOf("_");
                int i2 = iIndexOf + 1;
                int iIndexOf2 = name.indexOf("_", i2);
                if (iIndexOf < iIndexOf2) {
                    String strSubstring = name.substring(i2, iIndexOf2);
                    if (strSubstring.length() > 0 && !strSubstring.equals(this.a.appInfo.apkMd5)) {
                        try {
                            TapADLogger.d("APKDownload old cache file deleted result:" + fileA.delete());
                        } catch (Exception e2) {
                            TapADLogger.e("APKDownload old cache file deleted error:" + e2.getCause());
                        }
                    }
                }
            }
        }
        ApkUrlInfo apkUrlInfoE = e();
        if (apkUrlInfoE != null && !TextUtils.isEmpty(apkUrlInfoE.url)) {
            if (com.tapsdk.tapad.internal.utils.d.g(this.f)) {
                a(this.f).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(apkUrlInfoE), new e());
                return;
            } else {
                if (this.i != null) {
                    TapADLogger.e("APKDownload start no network now");
                    this.i.a(1, "APKDownload start no network now");
                    this.i.a(1, new RuntimeException("APKDownload start no network now"));
                    return;
                }
                return;
            }
        }
        if (this.i != null) {
            StringBuilder sb = new StringBuilder("[");
            AppInfo appInfo = this.a.appInfo;
            if (appInfo != null && appInfo.apkUrls != null) {
                for (int i3 = 0; i3 < this.a.appInfo.apkUrls.size(); i3++) {
                    sb.append(this.a.appInfo.apkUrls.get(i3));
                }
            }
            sb.append("]");
            String str = "APKDownload start no validUrl:" + ((Object) sb);
            TapADLogger.e(str);
            this.i.a(0, str);
            this.i.a(0, new RuntimeException(str));
        }
    }
}
