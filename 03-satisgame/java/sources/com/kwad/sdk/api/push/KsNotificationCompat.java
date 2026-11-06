package com.kwad.sdk.api.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkApi
public class KsNotificationCompat {

    @KsAdSdkApi
    public static final class Builder {
        private NotificationCompat.Builder mBuilder;

        public Builder(Context context, String str) {
            try {
                this.mBuilder = new NotificationCompat.Builder(context, str);
            } catch (Throwable unused) {
                this.mBuilder = new NotificationCompat.Builder(context);
            }
        }

        @KsAdSdkApi
        public Builder(Context context) {
            this(context, null);
        }

        @KsAdSdkApi
        public Builder setWhen(long j) {
            this.mBuilder.setWhen(j);
            return this;
        }

        @KsAdSdkApi
        public Builder setShowWhen(boolean z) {
            this.mBuilder.setShowWhen(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setDecoratedCustomStyle() {
            this.mBuilder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            return this;
        }

        @KsAdSdkApi
        public Builder setUsesChronometer(boolean z) {
            this.mBuilder.setUsesChronometer(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setSmallIcon(int i) {
            this.mBuilder.setSmallIcon(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setSmallIcon(int i, int i2) {
            this.mBuilder.setSmallIcon(i, i2);
            return this;
        }

        @KsAdSdkApi
        public Builder setContentTitle(CharSequence charSequence) {
            this.mBuilder.setContentTitle(charSequence);
            return this;
        }

        @KsAdSdkApi
        public Builder setContentText(CharSequence charSequence) {
            this.mBuilder.setContentText(charSequence);
            return this;
        }

        @KsAdSdkApi
        public Builder setSubText(CharSequence charSequence) {
            this.mBuilder.setSubText(charSequence);
            return this;
        }

        @KsAdSdkApi
        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.setRemoteInputHistory(charSequenceArr);
            return this;
        }

        @KsAdSdkApi
        public Builder setNumber(int i) {
            this.mBuilder.setNumber(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setContentInfo(CharSequence charSequence) {
            this.mBuilder.setContentInfo(charSequence);
            return this;
        }

        @KsAdSdkApi
        public Builder setProgress(int i, int i2, boolean z) {
            this.mBuilder.setProgress(i, i2, z);
            return this;
        }

        @KsAdSdkApi
        public Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.setContent(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.setContentIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.setDeleteIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mBuilder.setFullScreenIntent(pendingIntent, z);
            return this;
        }

        @KsAdSdkApi
        public Builder setTicker(CharSequence charSequence) {
            this.mBuilder.setTicker(charSequence);
            return this;
        }

        @KsAdSdkApi
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mBuilder.setTicker(charSequence, remoteViews);
            return this;
        }

        @KsAdSdkApi
        public Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.setLargeIcon(bitmap);
            return this;
        }

        @KsAdSdkApi
        public Builder setSound(Uri uri) {
            this.mBuilder.setSound(uri);
            return this;
        }

        @KsAdSdkApi
        public Builder setSound(Uri uri, int i) {
            this.mBuilder.setSound(uri, i);
            return this;
        }

        @KsAdSdkApi
        public Builder setVibrate(long[] jArr) {
            this.mBuilder.setVibrate(jArr);
            return this;
        }

        @KsAdSdkApi
        public Builder setLights(int i, int i2, int i3) {
            this.mBuilder.setLights(i, i2, i3);
            return this;
        }

        @KsAdSdkApi
        public Builder setOngoing(boolean z) {
            this.mBuilder.setOngoing(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setColorized(boolean z) {
            this.mBuilder.setColorized(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setOnlyAlertOnce(boolean z) {
            this.mBuilder.setOnlyAlertOnce(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setAutoCancel(boolean z) {
            this.mBuilder.setAutoCancel(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setLocalOnly(boolean z) {
            this.mBuilder.setLocalOnly(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setCategory(String str) {
            this.mBuilder.setCategory(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setDefaults(int i) {
            this.mBuilder.setDefaults(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setPriority(int i) {
            this.mBuilder.setPriority(i);
            return this;
        }

        @KsAdSdkApi
        public Builder addPerson(String str) {
            this.mBuilder.addPerson(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setGroup(String str) {
            this.mBuilder.setGroup(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setGroupSummary(boolean z) {
            this.mBuilder.setGroupSummary(z);
            return this;
        }

        @KsAdSdkApi
        public Builder setSortKey(String str) {
            this.mBuilder.setSortKey(str);
            return this;
        }

        @KsAdSdkApi
        public Builder addExtras(Bundle bundle) {
            this.mBuilder.addExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        public Builder setExtras(Bundle bundle) {
            this.mBuilder.setExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        public Bundle getExtras() {
            return this.mBuilder.getExtras();
        }

        @KsAdSdkApi
        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.addAction(i, charSequence, pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public Builder setColor(int i) {
            this.mBuilder.setColor(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setVisibility(int i) {
            this.mBuilder.setVisibility(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setPublicVersion(Notification notification) {
            this.mBuilder.setPublicVersion(notification);
            return this;
        }

        @KsAdSdkApi
        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomBigContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public Builder setChannelId(String str) {
            this.mBuilder.setChannelId(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setTimeoutAfter(long j) {
            this.mBuilder.setTimeoutAfter(j);
            return this;
        }

        @KsAdSdkApi
        public Builder setShortcutId(String str) {
            this.mBuilder.setShortcutId(str);
            return this;
        }

        @KsAdSdkApi
        public Builder setBadgeIconType(int i) {
            this.mBuilder.setBadgeIconType(i);
            return this;
        }

        @KsAdSdkApi
        public Builder setGroupAlertBehavior(int i) {
            this.mBuilder.setGroupAlertBehavior(i);
            return this;
        }

        @KsAdSdkApi
        public Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        public Notification build() {
            return this.mBuilder.build();
        }
    }
}
