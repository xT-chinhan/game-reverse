package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.content.Context;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.n;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.ApkInfoDetails;
import com.tapsdk.tapad.model.entities.ApkUrlInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadPresenter {
    private static final String k = "DownloadPresenter";
    private com.tapsdk.tapad.internal.a c;
    WeakReference<Context> e;
    private final List<h> g;
    private int h;
    private boolean i;
    private Disposable j;
    private final com.tapsdk.tapad.e.b a = new com.tapsdk.tapad.e.b();
    private final Set<com.tapsdk.tapad.internal.a> b = new HashSet();
    private volatile DownloadState d = DownloadState.DEFAULT;
    private final CompositeDisposable f = new CompositeDisposable();

    public enum DownloadState {
        DEFAULT,
        STARTED,
        COMPLETE,
        ERROR
    }

    class a implements Consumer<com.tapsdk.tapad.internal.p.a> {
        a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.tapsdk.tapad.internal.p.a aVar) throws Exception {
            TapADLogger.d("retryDownload start");
            try {
                if (aVar.a() == null || !aVar.a().containsKey(Constants.p.a)) {
                    return;
                }
                AdInfo adInfo = (AdInfo) aVar.a().get(Constants.p.a);
                if (DownloadPresenter.this.c == null || DownloadPresenter.this.c.b() == null || DownloadPresenter.this.c.b().trackId == null || adInfo == null || !DownloadPresenter.this.c.b().trackId.equals(adInfo.trackId)) {
                    return;
                }
                if (adInfo.appInfo != null && adInfo.appInfo.appName != null && adInfo.appInfo.appName.length() > 0) {
                    TapADLogger.d("retryDownload adInfo:[trackId=" + adInfo.trackId + ",appName=" + adInfo.appInfo.appName + "]");
                }
                DownloadPresenter downloadPresenter = DownloadPresenter.this;
                downloadPresenter.c(downloadPresenter.c.b());
            } catch (Throwable th) {
                TapADLogger.d("retryDownload error:" + ("[cause=" + th.getCause() + ",message:" + th.getMessage()));
            }
        }
    }

    class b implements Consumer<Throwable> {
        b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            TapADLogger.d("receiver retry download error:" + (th != null ? th.getMessage() : "no error message"));
        }
    }

    class c implements Consumer<ApkInfoDetails> {
        final /* synthetic */ AdInfo a;

        c(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(ApkInfoDetails apkInfoDetails) {
            AppInfo appInfo = this.a.appInfo;
            appInfo.apkUrls = apkInfoDetails.apkUrlInfoList;
            appInfo.apkSize = apkInfoDetails.size;
            appInfo.apkMd5 = apkInfoDetails.md5;
            appInfo.packageName = apkInfoDetails.identifier;
            DownloadPresenter.this.c.a(DownloadPresenter.this.a(this.a, false));
            DownloadPresenter.this.b.add(DownloadPresenter.this.c);
            DownloadPresenter downloadPresenter = DownloadPresenter.this;
            downloadPresenter.a(downloadPresenter.d, DownloadState.STARTED);
            DownloadPresenter.this.c.j();
        }
    }

    class d implements Consumer<Throwable> {
        d() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            TapADLogger.e("DownloadPresenter downloadWithOtherUrl onFail:" + th.getMessage());
            DownloadPresenter downloadPresenter = DownloadPresenter.this;
            downloadPresenter.a(downloadPresenter.d, DownloadState.ERROR);
            DownloadPresenter.this.c.h();
        }
    }

    class e implements com.tapsdk.tapad.internal.a.l {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ AdInfo c;

        e(String str, boolean z, AdInfo adInfo) {
            this.a = str;
            this.b = z;
            this.c = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.a.l
        public void a(int i) {
            TapADLogger.d("DownloadPresenter " + this.a + " onProgress:" + i);
            DownloadPresenter.this.h = i;
            Iterator it = DownloadPresenter.this.g.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.a.l
        public void a(int i, Exception exc) {
            TapADLogger.e("DownloadPresenter " + this.a + " onFail:(code:" + i + ",e:" + (exc != null ? exc.getCause() : "") + ")");
            if (this.b && (i == 7 || i == 0)) {
                DownloadPresenter.this.a(this.c);
                return;
            }
            DownloadPresenter downloadPresenter = DownloadPresenter.this;
            downloadPresenter.a(downloadPresenter.d, DownloadState.ERROR);
            DownloadPresenter.this.c.h();
        }

        @Override // com.tapsdk.tapad.internal.a.l
        public void a(int i, String str) {
            DownloadPresenter.this.a(this.c, i, str, this.a);
        }

        @Override // com.tapsdk.tapad.internal.a.l
        public void a(File file) {
            TapADLogger.d("DownloadPresenter " + this.a + " onSuccess:" + file.getName());
            DownloadPresenter downloadPresenter = DownloadPresenter.this;
            downloadPresenter.a(downloadPresenter.d, DownloadState.COMPLETE);
            DownloadPresenter.this.c.h();
        }
    }

    class f implements com.tapsdk.tapad.internal.n.c.a {
        final /* synthetic */ Activity a;
        final /* synthetic */ File b;
        final /* synthetic */ AdInfo c;

        f(Activity activity, File file, AdInfo adInfo) {
            this.a = activity;
            this.b = file;
            this.c = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.n.c.a
        public void a(boolean z) {
            TapADLogger.d("DownloadPresenter installController:" + z);
            if (z) {
                Activity activity = this.a;
                if (com.tapsdk.tapad.internal.utils.b.a(activity, com.tapsdk.tapad.internal.utils.f.a(activity, this.b))) {
                    TapADLogger.d("DownloadPresenter installController installed");
                    Iterator it = DownloadPresenter.this.g.iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).a();
                    }
                    com.tapsdk.tapad.internal.c.b().a(this.a, this.c);
                    DownloadPresenter.this.i = true;
                    return;
                }
            }
            TapADLogger.d("DownloadPresenter install fail");
            Iterator it2 = DownloadPresenter.this.g.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).b();
            }
        }
    }

    public static class g extends com.tapsdk.tapad.internal.b {
    }

    public interface h {
        void a();

        void a(int i);

        void b();

        void c();

        void d();

        void e();
    }

    public static class i extends com.tapsdk.tapad.internal.b {
        public AdInfo a;

        public i(AdInfo adInfo) {
            this.a = adInfo;
        }
    }

    public static class j extends com.tapsdk.tapad.internal.b {
        public AdInfo a;

        public j(AdInfo adInfo) {
            this.a = adInfo;
        }
    }

    public static class k extends com.tapsdk.tapad.internal.b {
        public AdInfo a;

        public k(AdInfo adInfo) {
            this.a = adInfo;
        }
    }

    public DownloadPresenter(Context context, h hVar) {
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.h = 0;
        this.i = false;
        this.j = null;
        this.e = new WeakReference<>(context);
        this.j = n.a().a(com.tapsdk.tapad.internal.p.a.class).subscribe(new a(), new b());
        arrayList.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tapsdk.tapad.internal.a.l a(AdInfo adInfo, boolean z) {
        return new e(a(z), z, adInfo);
    }

    private String a(List<ApkUrlInfo> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2));
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private String a(boolean z) {
        return z ? "startDownload" : "downloadWithOtherUrl";
    }

    private void a() {
        com.tapsdk.tapad.internal.a aVar;
        if (((Integer) com.tapsdk.tapad.internal.k.a.a(Constants.f.a, Integer.class, -1)).intValue() == Constants.d.b || (aVar = this.c) == null) {
            return;
        }
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadState downloadState, DownloadState downloadState2) {
        if (downloadState == DownloadState.DEFAULT) {
            if (downloadState2 == DownloadState.STARTED) {
                this.d = downloadState2;
                Iterator<h> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                return;
            }
            return;
        }
        if (downloadState != DownloadState.STARTED) {
            if (downloadState == DownloadState.ERROR && downloadState2 == DownloadState.STARTED) {
                this.d = downloadState2;
                Iterator<h> it2 = this.g.iterator();
                while (it2.hasNext()) {
                    it2.next().c();
                }
                return;
            }
            return;
        }
        if (downloadState2 == DownloadState.COMPLETE) {
            this.d = downloadState2;
            Iterator<h> it3 = this.g.iterator();
            while (it3.hasNext()) {
                it3.next().d();
            }
            return;
        }
        if (downloadState2 == DownloadState.ERROR) {
            this.d = downloadState2;
            Iterator<h> it4 = this.g.iterator();
            while (it4.hasNext()) {
                it4.next().e();
            }
        }
    }

    private void a(j jVar) {
        if (this.d.equals(DownloadState.STARTED)) {
            TapADLogger.d("Download in progress. Pls not start multiple times");
            return;
        }
        com.tapsdk.tapad.internal.tracker.c cVarA = com.tapsdk.tapad.internal.tracker.c.a();
        AdInfo adInfo = jVar.a;
        cVarA.a(adInfo.downloadStartMonitorUrls, (Map<String, String>) null, adInfo.getDownloadStartMonitorHeaderListWrapper());
        com.tapsdk.tapad.internal.a aVar = new com.tapsdk.tapad.internal.a(this.e.get(), jVar.a, true);
        this.c = aVar;
        aVar.a(a(jVar.a, true));
        this.b.add(this.c);
        a(this.d, DownloadState.STARTED);
        this.c.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo) {
        TapADLogger.d("download With OtherUrl");
        this.c = new com.tapsdk.tapad.internal.a(this.e.get(), adInfo, true);
        this.f.add(this.a.a(adInfo.appInfo.getDownloadInfoUrl).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(adInfo), new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, int i2, String str, String str2) {
        try {
            TapADLogger.d("DownloadPresenter " + str2 + " onFail:(\ncode:" + i2 + "\n,type:sdk_download\n,message:" + str + "\n,mediaId:" + adInfo.mediaId + "\n,spaceId:" + adInfo.spaceId + "\n,trackId:" + adInfo.trackId + "\n,requestId:" + adInfo.trackBackData.requestId + "\n,requestUuid:" + adInfo.trackBackData.requestUUID + "\n,fromMethod:" + str2 + "\n,downloadUrls:" + a(adInfo.appInfo.apkUrls) + ")");
            com.tapsdk.tapad.internal.tracker.experiment.h.b bVar = new com.tapsdk.tapad.internal.tracker.experiment.h.b();
            bVar.a(adInfo.mediaId).b(adInfo.spaceId.longValue()).a(i2).d(str).e(adInfo.trackBackData.requestId).f(adInfo.trackBackData.requestUUID).g(adInfo.trackId).b(str2).a(a(adInfo.appInfo.apkUrls)).c("1").b(adInfo.sampleRatioDownload);
            com.tapsdk.tapad.internal.tracker.experiment.f.b().a(com.tapsdk.tapad.internal.tracker.experiment.g.b).a(bVar);
        } catch (Exception unused) {
        }
    }

    private void b(AdInfo adInfo) {
        com.tapsdk.tapad.e.f.a();
        Activity activityA = com.tapsdk.tapad.internal.utils.a.a(this.e.get());
        TapADLogger.d("gotoInstall internal");
        if (activityA != null) {
            File fileA = com.tapsdk.tapad.internal.a.a(activityA, adInfo);
            if (fileA.exists()) {
                TapADLogger.d("gotoInstall internal:" + fileA.getAbsolutePath());
                com.tapsdk.tapad.internal.n.c cVarA = com.tapsdk.tapad.internal.n.a.a(activityA, fileA, adInfo);
                if (cVarA != null) {
                    cVarA.a(new f(activityA, fileA, adInfo));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdInfo adInfo) {
        this.d = DownloadState.DEFAULT;
        a(new j(adInfo));
    }

    private void e() {
        Iterator<com.tapsdk.tapad.internal.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
        this.b.clear();
        if (!this.f.isDisposed()) {
            this.f.clear();
        }
        Disposable disposable = this.j;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.j.dispose();
    }

    public void a(Context context) {
        this.e = new WeakReference<>(context);
    }

    public void a(h hVar) {
        this.g.add(hVar);
    }

    public void a(com.tapsdk.tapad.internal.b bVar) {
        if (bVar instanceof j) {
            a((j) bVar);
            return;
        }
        if (bVar instanceof com.tapsdk.tapad.internal.d) {
            e();
            return;
        }
        if (bVar instanceof k) {
            b(((k) bVar).a);
        } else if (bVar instanceof i) {
            c(((i) bVar).a);
        } else if (bVar instanceof g) {
            a();
        }
    }

    public int b() {
        return this.h;
    }

    public DownloadState c() {
        return this.d;
    }

    public boolean d() {
        return this.i;
    }
}
