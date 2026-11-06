package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new a();
    public String apkMd5;
    public long apkSize;
    public List<ApkUrlInfo> apkUrls;
    public final ApkVerifyType apkVerifyType;
    public final String appDesc;
    public final String appDescUrl;
    public String appDeveloper;
    public final ImageInfo appIconImage;
    public final long appId;
    public final String appName;
    public final String appPermissionsLink;
    public final String appPrivacyPolicy;
    public final String appSize;
    public final String appVersion;
    public final String getDownloadInfoUrl;
    public final long itunesId;
    public String packageName;
    public final float tapScore;

    public enum ApkVerifyType {
        APK_VERIFY_TYPE_DEFAULT,
        APK_VERIFY_TYPE_NOT_VERIFY
    }

    static class a implements Parcelable.Creator<AppInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    }

    protected AppInfo(Parcel parcel) {
        this.apkUrls = new ArrayList();
        this.apkSize = -1L;
        this.appId = parcel.readLong();
        this.appName = parcel.readString();
        this.packageName = parcel.readString();
        this.appDesc = parcel.readString();
        this.appVersion = parcel.readString();
        this.appSize = parcel.readString();
        this.appDeveloper = parcel.readString();
        this.appPrivacyPolicy = parcel.readString();
        this.appPermissionsLink = parcel.readString();
        this.tapScore = parcel.readFloat();
        this.appIconImage = (ImageInfo) parcel.readParcelable(ImageInfo.class.getClassLoader());
        this.itunesId = parcel.readLong();
        this.apkUrls = parcel.createTypedArrayList(ApkUrlInfo.CREATOR);
        this.apkMd5 = parcel.readString();
        this.apkSize = parcel.readLong();
        this.getDownloadInfoUrl = parcel.readString();
        this.appDescUrl = parcel.readString();
        this.apkVerifyType = ApkVerifyType.values()[parcel.readInt()];
    }

    public AppInfo(TapAdResp.f fVar) {
        this.apkUrls = new ArrayList();
        this.apkSize = -1L;
        this.appId = fVar.r4();
        this.appName = fVar.getAppName();
        this.packageName = fVar.c();
        this.appDesc = fVar.r3();
        this.appVersion = fVar.getAppVersion();
        this.appSize = fVar.S1();
        this.appDeveloper = fVar.y3();
        this.appPrivacyPolicy = fVar.T();
        this.appPermissionsLink = fVar.q();
        this.tapScore = fVar.H();
        this.appIconImage = new ImageInfo(fVar.i3());
        this.itunesId = fVar.V0();
        if (fVar.V1() > 0) {
            Iterator<TapAdResp.d> it = fVar.a2().iterator();
            while (it.hasNext()) {
                this.apkUrls.add(new ApkUrlInfo(it.next()));
            }
        }
        this.apkMd5 = fVar.s();
        this.apkSize = fVar.getApkSize();
        this.getDownloadInfoUrl = fVar.O4();
        this.appDescUrl = fVar.t5();
        this.apkVerifyType = getApkVerifyType(fVar.e3());
    }

    private ApkVerifyType getApkVerifyType(TapAdResp.ApkVerifyType apkVerifyType) {
        try {
            return ApkVerifyType.values()[apkVerifyType.ordinal()];
        } catch (Exception unused) {
            return ApkVerifyType.APK_VERIFY_TYPE_DEFAULT;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appDesc);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.appSize);
        parcel.writeString(this.appDeveloper);
        parcel.writeString(this.appPrivacyPolicy);
        parcel.writeString(this.appPermissionsLink);
        parcel.writeFloat(this.tapScore);
        parcel.writeParcelable(this.appIconImage, i);
        parcel.writeLong(this.itunesId);
        parcel.writeTypedList(this.apkUrls);
        parcel.writeString(this.apkMd5);
        parcel.writeLong(this.apkSize);
        parcel.writeString(this.getDownloadInfoUrl);
        parcel.writeString(this.appDescUrl);
        parcel.writeInt(this.apkVerifyType.ordinal());
    }
}
