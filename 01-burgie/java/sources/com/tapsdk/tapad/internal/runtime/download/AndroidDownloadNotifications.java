package com.tapsdk.tapad.internal.runtime.download;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.widget.RemoteViews;
import com.byazt.eyv.AdBaseConstants;
import com.tapsdk.tapad.internal.TapADFileProvider;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidDownloadNotifications {
    private static final String CHANNEL_ID = "dirichlet_download_channel";
    private static final int ICON_SIZE_DP = 40;
    private static final AtomicInteger NEXT_NOTIFICATION_ID = new AtomicInteger(10000);
    private static final long PROGRESS_UPDATE_INTERVAL_MS = 1000;
    private static AndroidDownloadNotifications instance;
    private final Context context;
    private final ConcurrentHashMap<Integer, Entry> entries = new ConcurrentHashMap<>();
    private final NotificationManager manager;

    public static final class Entry {
        volatile Bitmap iconBitmap;
        volatile MechanicalImageLoader.Request iconRequest;
        volatile RenderedNotification rendered;
        final String title;
        final int notificationId = AndroidDownloadNotifications.NEXT_NOTIFICATION_ID.incrementAndGet();
        long lastProgressPublishedAtMs = -1;

        public Entry(String str) {
            this.title = (str == null || str.isEmpty()) ? "下载中" : str;
        }
    }

    public static final class RenderedNotification {
        final RemoteViews contentView;
        final Notification notification;

        public RenderedNotification(RemoteViews remoteViews, Notification notification) {
            this.contentView = remoteViews;
            this.notification = notification;
        }
    }

    private AndroidDownloadNotifications(Context context) {
        Context applicationContext = context.getApplicationContext();
        context = applicationContext != null ? applicationContext : context;
        this.context = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.manager = notificationManager;
        if (notificationManager == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "下载通知", 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private PendingIntent action(int i, Entry entry, String str, int i2) {
        Intent intent = new Intent(ApkNotificationReceiver.getActionName(this.context, str));
        intent.setPackage(this.context.getPackageName());
        intent.putExtra(ApkNotificationReceiver.EXTRA_DOWNLOAD_ID, i);
        intent.putExtra(ApkNotificationReceiver.EXTRA_PROCESS_ID, Process.myPid());
        return PendingIntent.getBroadcast(this.context, (entry.notificationId * 10) + i2, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
    }

    private Notification.Builder builder(Entry entry) {
        return (Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.context, CHANNEL_ID) : new Notification.Builder(this.context)).setSmallIcon(R.drawable.stat_sys_download).setContentTitle(entry.title).setOnlyAlertOnce(true).setPriority(-1).setWhen(System.currentTimeMillis());
    }

    private void configureCancel(RemoteViews remoteViews, int i, Entry entry) {
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_cancel, 0);
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_action, 8);
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_cancel, this.context.getString(com.tapsdk.tapad.R.string.tapad_btn_cancel));
        remoteViews.setOnClickPendingIntent(com.tapsdk.tapad.R.id.tapad_notification_cancel, action(i, entry, ApkNotificationReceiver.ACTION_CANCEL, 1));
    }

    private void configureResume(RemoteViews remoteViews, int i, Entry entry) {
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_cancel, 8);
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_action, 0);
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_action, this.context.getString(com.tapsdk.tapad.R.string.tapad_btn_continue));
        remoteViews.setOnClickPendingIntent(com.tapsdk.tapad.R.id.tapad_notification_action, action(i, entry, ApkNotificationReceiver.ACTION_RESUME, 3));
    }

    private static void configureTerminalAction(RemoteViews remoteViews, PendingIntent pendingIntent, String str) {
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_cancel, 8);
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_action, pendingIntent != null ? 0 : 8);
        if (pendingIntent != null) {
            remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_action, str);
            remoteViews.setOnClickPendingIntent(com.tapsdk.tapad.R.id.tapad_notification_action, pendingIntent);
        }
    }

    private RemoteViews contentView(Entry entry) {
        RemoteViews remoteViews = new RemoteViews(this.context.getPackageName(), com.tapsdk.tapad.R.layout.tapad_notification_content);
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_title, entry.title);
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_progress_text, "");
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, "");
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_sub_content, "");
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_cancel, 0);
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_action, 8);
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_progress, 0);
        Bitmap bitmap = entry.iconBitmap;
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(com.tapsdk.tapad.R.id.tapad_notification_icon, bitmap);
        }
        return remoteViews;
    }

    private static String formatSpeed(long j) {
        String str;
        double d = j;
        if (d >= 1024.0d) {
            d /= 1024.0d;
            str = "KB/s";
        } else {
            str = "B/s";
        }
        if (d >= 1024.0d) {
            d /= 1024.0d;
            str = "MB/s";
        }
        return String.format(Locale.US, "%.1f %s", Double.valueOf(d), str);
    }

    public static synchronized AndroidDownloadNotifications get(Context context) {
        if (instance == null) {
            instance = new AndroidDownloadNotifications(context);
        }
        return instance;
    }

    private static void hideProgress(RemoteViews remoteViews) {
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_progress_text, "");
        remoteViews.setViewVisibility(com.tapsdk.tapad.R.id.tapad_notification_progress, 8);
        remoteViews.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_sub_content, "");
    }

    private PendingIntent installIntent(Entry entry, File file) {
        if (file != null && file.isFile()) {
            try {
                return PendingIntent.getActivity(this.context, entry.notificationId, new Intent("android.intent.action.VIEW").setDataAndType(TapADFileProvider.getUriForFile(this.context, this.context.getPackageName() + ".com.tds.ad.fileprovider", file), AdBaseConstants.MIME_APK).addFlags(268435457), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private void notify(Entry entry, Notification.Builder builder, RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setCustomContentView(remoteViews).setStyle(new Notification.DecoratedCustomViewStyle());
        } else {
            builder.setContent(remoteViews);
        }
        Notification notificationBuild = builder.build();
        entry.rendered = new RenderedNotification(remoteViews, notificationBuild);
        notify(entry, notificationBuild);
    }

    private void onIconLoaded(int i, Entry entry, Bitmap bitmap) {
        entry.iconRequest = null;
        if (bitmap == null || this.entries.get(Integer.valueOf(i)) != entry) {
            return;
        }
        entry.iconBitmap = bitmap;
        RenderedNotification renderedNotification = entry.rendered;
        if (renderedNotification == null) {
            return;
        }
        renderedNotification.contentView.setImageViewBitmap(com.tapsdk.tapad.R.id.tapad_notification_icon, bitmap);
        notify(entry, renderedNotification.notification);
    }

    private static void release(Entry entry) {
        if (entry == null) {
            return;
        }
        MechanicalImageLoader.Request request = entry.iconRequest;
        entry.iconRequest = null;
        if (request != null && !request.isComplete()) {
            request.cancel();
        }
        entry.rendered = null;
    }

    private String remainingText(long j, long j2, long j3) {
        if (j3 <= 0 || j2 <= j || j < 0) {
            return "";
        }
        long j4 = j2 - j;
        long j5 = j4 / j3;
        if (j4 % j3 != 0) {
            j5++;
        }
        return this.context.getString(com.tapsdk.tapad.R.string.tapad_download_last_duration) + " " + j5 + this.context.getString(com.tapsdk.tapad.R.string.tapad_str_seconds);
    }

    public void cancel(int i) {
        NotificationManager notificationManager;
        Entry entryRemove = this.entries.remove(Integer.valueOf(i));
        release(entryRemove);
        if (entryRemove == null || (notificationManager = this.manager) == null) {
            return;
        }
        notificationManager.cancel(entryRemove.notificationId);
    }

    /* JADX INFO: renamed from: lambda$prepare$0$com-tapsdk-tapad-internal-runtime-download-AndroidDownloadNotifications, reason: not valid java name */
    /* synthetic */ void m269lambda$prepare$0$comtapsdktapadinternalruntimedownloadAndroidDownloadNotifications(int i, Entry entry, MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
        onIconLoaded(i, entry, bitmap);
    }

    public void prepare(final int i, String str, String str2) {
        final Entry entry = new Entry(str);
        release(this.entries.put(Integer.valueOf(i), entry));
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        int iMax = Math.max(1, Math.round(this.context.getResources().getDisplayMetrics().density * 40.0f));
        try {
            entry.iconRequest = MechanicalImageLoader.loadBitmap(this.context, str2, MechanicalImageLoader.Options.builder().targetSize(iMax, iMax).build(), new MechanicalImageLoader.BitmapCallback() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadNotifications$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
                public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
                    this.f$0.m269lambda$prepare$0$comtapsdktapadinternalruntimedownloadAndroidDownloadNotifications(i, entry, request, bitmap, exc);
                }
            });
        } catch (RuntimeException e) {
        }
    }

    public void showComplete(int i, File file) {
        Entry entryRemove = this.entries.remove(Integer.valueOf(i));
        if (entryRemove == null) {
            return;
        }
        PendingIntent pendingIntentInstallIntent = installIntent(entryRemove, file);
        RemoteViews remoteViewsContentView = contentView(entryRemove);
        hideProgress(remoteViewsContentView);
        remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, this.context.getString(com.tapsdk.tapad.R.string.tapad_download_complete));
        configureTerminalAction(remoteViewsContentView, pendingIntentInstallIntent, this.context.getString(com.tapsdk.tapad.R.string.tapad_btn_install));
        Notification.Builder progress = builder(entryRemove).setSmallIcon(R.drawable.stat_sys_download_done).setContentText(this.context.getString(com.tapsdk.tapad.R.string.tapad_download_complete)).setAutoCancel(true).setOngoing(false).setProgress(0, 0, false);
        if (pendingIntentInstallIntent != null) {
            progress.setContentIntent(pendingIntentInstallIntent);
        }
        notify(entryRemove, progress, remoteViewsContentView);
        release(entryRemove);
    }

    public void showFailed(int i, String str) {
        Entry entryRemove = this.entries.remove(Integer.valueOf(i));
        if (entryRemove == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            str = this.context.getString(com.tapsdk.tapad.R.string.tapad_download_error);
        }
        RemoteViews remoteViewsContentView = contentView(entryRemove);
        hideProgress(remoteViewsContentView);
        remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, str);
        configureTerminalAction(remoteViewsContentView, null, "");
        notify(entryRemove, builder(entryRemove).setSmallIcon(R.drawable.stat_notify_error).setContentText(str).setAutoCancel(true).setOngoing(false).setProgress(0, 0, false), remoteViewsContentView);
        release(entryRemove);
    }

    public void showPaused(int i, int i2) {
        Entry entry = this.entries.get(Integer.valueOf(i));
        if (entry == null) {
            return;
        }
        synchronized (entry) {
            entry.lastProgressPublishedAtMs = -1L;
        }
        int iMax = Math.max(0, Math.min(100, i2));
        RemoteViews remoteViewsContentView = contentView(entry);
        remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_progress_text, iMax + "%");
        remoteViewsContentView.setProgressBar(com.tapsdk.tapad.R.id.tapad_notification_progress, 100, iMax, false);
        remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, this.context.getString(com.tapsdk.tapad.R.string.tapad_download_paused));
        configureResume(remoteViewsContentView, i, entry);
        notify(entry, builder(entry).setSmallIcon(R.drawable.ic_media_pause).setContentText(this.context.getString(com.tapsdk.tapad.R.string.tapad_download_paused) + " · " + iMax + "%").setOngoing(true).setProgress(100, iMax, false), remoteViewsContentView);
    }

    public void showProgress(int i, int i2, long j, long j2, long j3) {
        Entry entry = this.entries.get(Integer.valueOf(i));
        if (entry == null) {
            return;
        }
        int iMax = Math.max(0, Math.min(100, i2));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (entry) {
            if (iMax < 100) {
                long j4 = entry.lastProgressPublishedAtMs;
                if (j4 >= 0 && jElapsedRealtime - j4 < 1000) {
                    return;
                }
            }
            entry.lastProgressPublishedAtMs = jElapsedRealtime;
            String speed = j3 > 0 ? formatSpeed(j3) : "";
            CharSequence charSequenceRemainingText = remainingText(j, j2, j3);
            RemoteViews remoteViewsContentView = contentView(entry);
            remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_progress_text, iMax + "%");
            remoteViewsContentView.setProgressBar(com.tapsdk.tapad.R.id.tapad_notification_progress, 100, iMax, false);
            remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, speed);
            remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_sub_content, charSequenceRemainingText);
            configureCancel(remoteViewsContentView, i, entry);
            String str = iMax + "%";
            if (!speed.isEmpty()) {
                str = str + " · " + speed;
            }
            notify(entry, builder(entry).setContentText(str).setOngoing(true).setProgress(100, iMax, false).setDeleteIntent(action(i, entry, ApkNotificationReceiver.ACTION_DELETE, 2)), remoteViewsContentView);
        }
    }

    public void showStarted(int i) {
        Entry entry = this.entries.get(Integer.valueOf(i));
        if (entry == null) {
            return;
        }
        RemoteViews remoteViewsContentView = contentView(entry);
        remoteViewsContentView.setProgressBar(com.tapsdk.tapad.R.id.tapad_notification_progress, 100, 0, true);
        remoteViewsContentView.setTextViewText(com.tapsdk.tapad.R.id.tapad_notification_content, this.context.getString(com.tapsdk.tapad.R.string.tapad_download_preparing));
        configureCancel(remoteViewsContentView, i, entry);
        notify(entry, builder(entry).setContentText(this.context.getString(com.tapsdk.tapad.R.string.tapad_download_preparing)).setOngoing(true).setProgress(100, 0, true).setDeleteIntent(action(i, entry, ApkNotificationReceiver.ACTION_DELETE, 2)), remoteViewsContentView);
    }

    private void notify(Entry entry, Notification notification) {
        NotificationManager notificationManager = this.manager;
        if (notificationManager == null) {
            return;
        }
        try {
            notificationManager.notify(entry.notificationId, notification);
        } catch (Throwable th) {
        }
    }
}
