package com.tapsdk.tapad.internal.ui.views;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.ApkNotificationReceiver;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.k;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.stub.activity.Stub_Install_or_OpenApp_Translucent_Activity;
import com.umeng.analytics.pro.bv;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.tapsdk.tapad.internal.download.m.i.e {
    public static final String k = "TapAdNotificationChannelID";
    private static final ConcurrentHashMap<String, Integer> l = new ConcurrentHashMap<>();
    private static final AtomicInteger m = new AtomicInteger(0);
    private NotificationCompat.Builder b;
    private NotificationManager c;
    private final AdInfo d;
    private final Context e;
    private RemoteViews i;
    private volatile boolean f = false;
    private int g = 1;
    private int h = 0;
    private final boolean j = d();

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.ui.views.a$a, reason: collision with other inner class name */
    class C0636a implements Consumer<Bitmap> {
        C0636a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Bitmap bitmap) {
            if (bitmap != null) {
                if (a.this.j) {
                    a.this.i.setImageViewBitmap(R.id.tv_icon, bitmap);
                } else {
                    a.this.b.setLargeIcon(bitmap);
                }
                if (a.l.containsValue(Integer.valueOf(a.this.h))) {
                    a.this.c.notify(a.this.h, a.this.b.build());
                }
            }
        }
    }

    class b implements Consumer<Throwable> {
        b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class c implements ObservableOnSubscribe<Bitmap> {
        c() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Bitmap> observableEmitter) {
            try {
                observableEmitter.onNext(Glide.with(a.this.e).asBitmap().load(a.this.d.appInfo.appIconImage.imageUrl).submit().get());
                observableEmitter.onComplete();
            } catch (Throwable th) {
                observableEmitter.onError(th);
            }
        }
    }

    class d implements com.tapsdk.tapad.internal.n.c.a {
        d() {
        }

        @Override // com.tapsdk.tapad.internal.n.c.a
        public void a(boolean z) {
            a.this.a("NotificationDownloadListener install callback onResult");
        }
    }

    class e extends TimerTask {
        final /* synthetic */ Notification a;

        e(Notification notification) {
            this.a = notification;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.l.containsValue(Integer.valueOf(a.this.h))) {
                a.this.c.notify(a.this.h, this.a);
            }
        }
    }

    class f extends TimerTask {
        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.l.containsValue(Integer.valueOf(a.this.h))) {
                a.this.c.notify(a.this.h, a.this.b.build());
            }
        }
    }

    public a(Context context, AdInfo adInfo) {
        this.e = context.getApplicationContext();
        this.d = adInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    private boolean d() {
        if (com.tapsdk.tapad.internal.utils.d.l() && Build.VERSION.SDK_INT == 27) {
            return false;
        }
        return !com.tapsdk.tapad.internal.utils.d.m();
    }

    public void a(EndCause endCause, com.tapsdk.tapad.internal.download.f fVar) {
        Context context;
        int i;
        Context context2;
        int i2;
        this.b.setOngoing(false);
        this.b.setAutoCancel(true);
        a("NotificationDownloadListener updateDownloadSuccessState:cause" + endCause + ",Task:" + (fVar != null ? "id:" + fVar.b() + ", url:" + fVar.e() : ""));
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.k.a.a(Constants.f.a, Integer.class, -1)).intValue();
        if (this.j) {
            this.i.setTextViewText(R.id.tv_title, this.d.materialInfo.title);
            this.i.setTextViewText(R.id.tv_sub_title, "");
            RemoteViews remoteViews = this.i;
            int i3 = R.id.tv_content;
            if (endCause == EndCause.COMPLETED) {
                context2 = this.e;
                i2 = R.string.tapad_download_complete;
            } else {
                context2 = this.e;
                i2 = R.string.tapad_download_error;
            }
            remoteViews.setTextViewText(i3, context2.getString(i2));
            this.i.setTextViewText(R.id.tv_sub_content, "");
            this.i.setViewVisibility(R.id.pb_progress, 8);
            if (iIntValue == Constants.d.a) {
                Intent intent = new Intent(this.e, (Class<?>) ApkNotificationReceiver.class);
                intent.setAction(ApkNotificationReceiver.NOTIFICATION_RESUME_CLICK);
                intent.putExtra(ApkNotificationReceiver.DOWNLOAD_TASK_TAG, (String) fVar.w());
                intent.putExtra(bv.aw, this.d);
                intent.putExtra("notifyId", this.h);
                if (fVar.h() != null) {
                    intent.putExtra(TTDownloadField.TT_FILE_PATH, fVar.h().getAbsolutePath());
                }
                intent.putExtra("success", endCause == EndCause.COMPLETED ? 0 : -1);
                PendingIntent broadcast = PendingIntent.getBroadcast(this.e, this.h, intent, 201326592);
                this.i.setViewVisibility(R.id.interactionPauseButton, 8);
                this.i.setViewVisibility(R.id.interactionResumeButton, 0);
                if (endCause == EndCause.COMPLETED) {
                    this.i.setTextViewText(R.id.interactionResumeButton, "安装");
                }
                this.i.setOnClickPendingIntent(R.id.interactionResumeButton, broadcast);
            }
        } else {
            this.b.setContentTitle(this.d.materialInfo.title);
            this.b.setProgress(0, 0, false);
            NotificationCompat.Builder builder = this.b;
            if (endCause == EndCause.COMPLETED) {
                context = this.e;
                i = R.string.tapad_download_complete;
            } else {
                context = this.e;
                i = R.string.tapad_download_error;
            }
            builder.setContentText(context.getString(i));
        }
        Intent intent2 = new Intent(this.e, (Class<?>) ApkNotificationReceiver.class);
        intent2.putExtra(bv.aw, this.d);
        intent2.putExtra("notifyId", this.h);
        if (fVar == null || fVar.h() == null) {
            a("NotificationDownloadListener no file found");
        } else {
            String absolutePath = fVar.h().getAbsolutePath();
            a("NotificationDownloadListener filePath:" + absolutePath);
            intent2.putExtra(TTDownloadField.TT_FILE_PATH, absolutePath);
        }
        byte b2 = endCause == EndCause.COMPLETED ? (byte) 0 : (byte) -1;
        PendingIntent broadcast2 = null;
        if (b2 == 0 && fVar != null) {
            try {
                if (this.d.appInfo != null) {
                    broadcast2 = PendingIntent.getActivity(this.e, 0, Stub_Install_or_OpenApp_Translucent_Activity.getNewIntent(this.e, fVar.h(), this.d, new d()), 201326592);
                    a("NotificationDownloadListener get (install app)/(open app) pendingIntent success");
                }
            } catch (Throwable unused) {
            }
        }
        if (broadcast2 == null) {
            intent2.putExtra("success", endCause != EndCause.COMPLETED ? -1 : 0);
            broadcast2 = PendingIntent.getBroadcast(this.e, this.h, intent2, 201326592);
            a("NotificationDownloadListener use origin logic to send broadcast");
        }
        this.b.setContentIntent(broadcast2);
        Notification notificationBuild = this.b.build();
        notificationBuild.flags = b2 == 0 ? 16 : 32;
        if (l.containsValue(Integer.valueOf(this.h))) {
            new Timer().schedule(new e(notificationBuild), 1000L);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar) {
        this.f = true;
        int iA = com.tapsdk.tapad.internal.utils.b.a(this.e);
        if (iA <= 0) {
            iA = R.drawable.tapad_temp_icon;
        }
        if (!this.j) {
            this.b.setOngoing(true);
            this.b.setProgress(0, 0, true);
        }
        this.b.setSmallIcon(iA).setAutoCancel(false).setShowWhen(true).setWhen(System.currentTimeMillis());
        ConcurrentHashMap<String, Integer> concurrentHashMap = l;
        Integer num = concurrentHashMap.get(this.d.appInfo.packageName);
        if (num != null) {
            TapADLogger.d("NotificationActivity find ad oldTaskId = " + num);
            this.c.cancel(num.intValue());
            concurrentHashMap.remove(this.d.appInfo.packageName);
        }
        int iAddAndGet = m.addAndGet(1);
        this.h = iAddAndGet;
        concurrentHashMap.put(this.d.appInfo.packageName, Integer.valueOf(iAddAndGet));
        if (((Integer) com.tapsdk.tapad.internal.k.a.a(Constants.f.a, Integer.class, -1)).intValue() == Constants.d.a) {
            Intent intent = new Intent(this.e, (Class<?>) ApkNotificationReceiver.class);
            intent.setAction(ApkNotificationReceiver.NOTIFICATION_DELETE);
            intent.putExtra(ApkNotificationReceiver.DOWNLOAD_TASK_TAG, (String) fVar.w());
            intent.putExtra(ApkNotificationReceiver.DOWNLOAD_TASK_Id, fVar.b());
            this.b.setDeleteIntent(PendingIntent.getBroadcast(this.e, this.h, intent, 201326592));
            if (this.j) {
                Intent intent2 = new Intent(this.e, (Class<?>) ApkNotificationReceiver.class);
                intent2.setAction(ApkNotificationReceiver.NOTIFICATION_PAUSE_CLICK);
                intent2.putExtra(ApkNotificationReceiver.DOWNLOAD_TASK_TAG, (String) fVar.w());
                PendingIntent broadcast = PendingIntent.getBroadcast(this.e, this.h, intent2, 201326592);
                this.i.setViewVisibility(R.id.interactionResumeButton, 8);
                this.i.setViewVisibility(R.id.interactionPauseButton, 0);
                this.i.setOnClickPendingIntent(R.id.interactionPauseButton, broadcast);
            } else {
                Intent intent3 = new Intent(this.e, (Class<?>) ApkNotificationReceiver.class);
                intent3.setAction(ApkNotificationReceiver.NOTIFICATION_PAUSE_CLICK);
                intent3.putExtra(ApkNotificationReceiver.DOWNLOAD_TASK_TAG, (String) fVar.w());
                this.b.setContentIntent(PendingIntent.getBroadcast(this.e, this.h, intent3, 201326592));
            }
        } else if (this.j) {
            this.i.setViewVisibility(R.id.interactionPauseButton, 8);
            this.i.setViewVisibility(R.id.interactionResumeButton, 8);
        }
        TapADLogger.d("NotificationActivity taskStart id = " + this.h + " apk = " + this.d.appInfo.packageName);
        Notification notificationBuild = this.b.build();
        notificationBuild.flags = 32;
        Observable.create(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0636a(), new b());
        if (concurrentHashMap.containsValue(Integer.valueOf(this.h))) {
            this.c.notify(this.h, notificationBuild);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, int i2, Map<String, List<String>> map) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j, k kVar) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar, k kVar) {
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
    public void a(com.tapsdk.tapad.internal.download.f fVar, long j, k kVar) {
        TapADLogger.d("NotificationActivity progress " + j + " id = " + this.h);
        if (!this.f) {
            a(fVar);
        }
        long jH = fVar.l() == null ? 1L : fVar.l().h();
        int iMax = (int) ((jH - j) / Math.max(kVar.d(), 1L));
        if (this.j) {
            this.i.setTextViewText(R.id.tv_title, this.d.materialInfo.title);
            if (jH != 0) {
                this.i.setTextViewText(R.id.tv_sub_title, ((100 * j) / jH) + "%");
            }
            RemoteViews remoteViews = this.i;
            int i = R.id.pb_progress;
            long j2 = this.g;
            remoteViews.setProgressBar(i, (int) (jH / j2), (int) (j / j2), false);
            this.i.setTextViewText(R.id.tv_content, kVar.n());
            this.i.setTextViewText(R.id.tv_sub_content, this.e.getString(R.string.tapad_download_last_duration) + " " + iMax + this.e.getString(R.string.tapad_str_seconds));
        } else {
            this.b.setContentTitle(this.d.materialInfo.title);
            NotificationCompat.Builder builder = this.b;
            long j3 = this.g;
            builder.setProgress((int) (jH / j3), (int) (j / j3), false);
            this.b.setContentInfo(((j * 100) / jH) + "%");
            this.b.setContentText(this.e.getString(R.string.tapad_download_last_duration) + " " + iMax + this.e.getString(R.string.tapad_str_seconds));
        }
        Notification notificationBuild = this.b.build();
        notificationBuild.flags = 32;
        if (l.containsValue(Integer.valueOf(this.h))) {
            this.c.notify(this.h, notificationBuild);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, com.tapsdk.tapad.internal.download.m.i.g.c.b bVar) {
        TapADLogger.d("NotificationActivity infoReady " + cVar + " id = " + this.h);
        if (cVar.h() > 2147483647L) {
            this.g = Math.max((int) (cVar.h() / 2147483647L), 1);
        }
        if (this.j) {
            this.i.setProgressBar(R.id.pb_progress, (int) (cVar.h() / ((long) this.g)), (int) (cVar.i() / ((long) this.g)), true);
        } else {
            this.b.setProgress((int) (cVar.h() / ((long) this.g)), (int) (cVar.i() / ((long) this.g)), true);
        }
        if (l.containsValue(Integer.valueOf(this.h))) {
            this.c.notify(this.h, this.b.build());
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.c.a
    public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc, k kVar) {
        if (!this.f) {
            a(fVar);
        }
        TapADLogger.d("NotificationActivity taskEnd " + endCause + " id = " + this.h);
        a(endCause, fVar);
    }

    public synchronized void c() {
        this.c = (NotificationManager) this.e.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel(k, "TapAdNotification", 3);
        notificationChannel.setSound(null, null);
        this.c.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder priority = new NotificationCompat.Builder(this.e, k).setDefaults(4).setOnlyAlertOnce(true).setPriority(1);
        this.b = priority;
        if (this.j) {
            priority.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            RemoteViews remoteViews = new RemoteViews(this.e.getPackageName(), R.layout.tapad_notification_content);
            this.i = remoteViews;
            this.b.setCustomContentView(remoteViews);
        } else {
            priority.setOngoing(true);
        }
    }

    public void c(boolean z) {
        if (!z || this.h <= 0) {
            return;
        }
        if (this.j) {
            this.i.setViewVisibility(R.id.pb_progress, 8);
            this.i.setTextViewText(R.id.tv_content, this.e.getString(R.string.tapad_download_error));
        } else {
            this.b.setContentText(this.e.getString(R.string.tapad_download_error));
            this.b.setProgress(0, 0, false);
        }
        if (l.containsValue(Integer.valueOf(this.h))) {
            new Timer().schedule(new f(), 1000L);
        }
    }
}
