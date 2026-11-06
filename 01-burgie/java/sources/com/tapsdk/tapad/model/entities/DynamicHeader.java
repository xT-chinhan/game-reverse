package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicHeader implements Parcelable {
    public static final Parcelable.Creator<DynamicHeader> CREATOR = new Parcelable.Creator<DynamicHeader>() { // from class: com.tapsdk.tapad.model.entities.DynamicHeader.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicHeader createFromParcel(Parcel parcel) {
            return new DynamicHeader(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicHeader[] newArray(int i) {
            return new DynamicHeader[i];
        }
    };
    public final int mode;
    public final String name;
    public List<String> valueList;

    public DynamicHeader(String str, List<String> list, int i) {
        new ArrayList();
        this.name = str;
        this.valueList = list;
        this.mode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "name:" + this.name + "\nvalue:" + this.valueList + "\nmode:" + this.mode + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeStringList(this.valueList);
        parcel.writeInt(this.mode);
    }

    public DynamicHeader(Parcel parcel) {
        this.valueList = new ArrayList();
        this.name = parcel.readString();
        this.valueList = parcel.createStringArrayList();
        this.mode = parcel.readInt();
    }
}
