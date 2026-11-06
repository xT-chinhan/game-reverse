package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class TagDetail implements Parcelable {
    public static final Parcelable.Creator<TagDetail> CREATOR = new a();
    int iconType;
    long tagId;
    String tagText;

    static class a implements Parcelable.Creator<TagDetail> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TagDetail createFromParcel(Parcel parcel) {
            return new TagDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TagDetail[] newArray(int i) {
            return new TagDetail[i];
        }
    }

    public TagDetail(long j, String str, int i) {
        this.tagId = j;
        this.tagText = str;
        this.iconType = i;
    }

    protected TagDetail(Parcel parcel) {
        this.tagId = parcel.readLong();
        this.tagText = parcel.readString();
        this.iconType = parcel.readInt();
    }

    public TagDetail(TapAdResp.b0 b0Var) {
        this.tagId = b0Var.w();
        this.iconType = b0Var.j0();
        this.tagText = b0Var.u0();
    }

    public TagDetail(String str) {
        this.tagText = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIconType() {
        return this.iconType;
    }

    public long getTagId() {
        return this.tagId;
    }

    public String getTagText() {
        return this.tagText;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.tagId);
        parcel.writeString(this.tagText);
        parcel.writeInt(this.iconType);
    }
}
