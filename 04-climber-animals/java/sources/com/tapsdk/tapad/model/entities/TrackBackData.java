package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class TrackBackData implements Parcelable {
    public static final Parcelable.Creator<TrackBackData> CREATOR = new a();
    public final String requestId;
    public final String requestUUID;
    public final long spaceId;

    static class a implements Parcelable.Creator<TrackBackData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackBackData createFromParcel(Parcel parcel) {
            return new TrackBackData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackBackData[] newArray(int i) {
            return new TrackBackData[i];
        }
    }

    public TrackBackData() {
        this.requestId = "";
        this.requestUUID = "";
        this.spaceId = -1L;
    }

    public TrackBackData(Parcel parcel) {
        this.requestId = parcel.readString();
        this.requestUUID = parcel.readString();
        this.spaceId = parcel.readLong();
    }

    public TrackBackData(String str, String str2, long j) {
        this.requestId = str;
        this.requestUUID = str2;
        this.spaceId = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requestId);
        parcel.writeString(this.requestUUID);
        parcel.writeLong(this.spaceId);
    }
}
