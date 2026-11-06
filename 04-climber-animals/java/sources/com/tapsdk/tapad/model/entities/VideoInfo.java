package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new a();
    public final ImageInfo coverImage;
    public final int duration;
    public final long urlExpires;
    public final VideoType videoType;
    public String videoUrl;
    public final String videoUrlH265;
    public final int volumeDefaultState;

    enum VideoType {
        VIDEOTYPE_UNKOWN,
        VIDEOTYPE_HORIZONTAL,
        VIDEOTYPE_VERTICAL
    }

    static class a implements Parcelable.Creator<VideoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo[] newArray(int i) {
            return new VideoInfo[i];
        }
    }

    public VideoInfo() {
        this.coverImage = new ImageInfo();
        this.videoUrl = "https://pl.taptap.cn/hls/lqJK8gQcP_cB58xTKlhdtyXU4hoi.m3u8?ts=1708346107&sign=tapad-3b620e0dd397f88e375507c1156f4486e66eb75e";
        this.duration = 30;
        this.urlExpires = 1708692869L;
        this.videoUrlH265 = null;
        this.videoType = VideoType.VIDEOTYPE_UNKOWN;
        this.volumeDefaultState = 1;
    }

    protected VideoInfo(Parcel parcel) {
        this.videoUrl = parcel.readString();
        this.videoUrlH265 = parcel.readString();
        this.duration = parcel.readInt();
        this.coverImage = (ImageInfo) parcel.readParcelable(VideoInfo.class.getClassLoader());
        this.videoType = VideoType.values()[parcel.readInt()];
        this.urlExpires = parcel.readLong();
        this.volumeDefaultState = parcel.readInt();
    }

    public VideoInfo(TapAdResp.h0 h0Var) {
        this.coverImage = new ImageInfo(h0Var.D0());
        this.videoUrl = h0Var.O5();
        this.duration = h0Var.F1();
        this.videoType = getVideoType(h0Var.r5());
        this.urlExpires = h0Var.x3();
        this.videoUrlH265 = null;
        this.volumeDefaultState = h0Var.h1();
    }

    private VideoType getVideoType(TapAdResp.VideoType videoType) {
        return VideoType.values()[videoType.ordinal()];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.videoUrlH265);
        parcel.writeInt(this.duration);
        parcel.writeParcelable(this.coverImage, i);
        parcel.writeInt(this.videoType.ordinal());
        parcel.writeLong(this.urlExpires);
        parcel.writeInt(this.volumeDefaultState);
    }
}
