package com.tapsdk.tapad.internal.tracker.experiment.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExpTrackMessageList implements Parcelable {
    public static final Parcelable.Creator<ExpTrackMessageList> CREATOR = new a();
    public List<ExpTrackMessage> trackMessageList;

    static class a implements Parcelable.Creator<ExpTrackMessageList> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTrackMessageList createFromParcel(Parcel parcel) {
            return new ExpTrackMessageList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTrackMessageList[] newArray(int i) {
            return new ExpTrackMessageList[i];
        }
    }

    protected ExpTrackMessageList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.trackMessageList = arrayList;
        parcel.readTypedList(arrayList, ExpTrackMessage.CREATOR);
    }

    public ExpTrackMessageList(List<ExpTrackMessage> list) {
        this.trackMessageList = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.trackMessageList);
    }
}
