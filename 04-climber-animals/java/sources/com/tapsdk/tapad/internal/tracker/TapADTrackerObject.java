package com.tapsdk.tapad.internal.tracker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TapADTrackerObject implements Parcelable {
    public static final Parcelable.Creator<TapADTrackerObject> CREATOR = new a();
    public ExposureTrackerObject a;
    public ClickTrackerObject b;

    static class a implements Parcelable.Creator<TapADTrackerObject> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TapADTrackerObject createFromParcel(Parcel parcel) {
            return new TapADTrackerObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TapADTrackerObject[] newArray(int i) {
            return new TapADTrackerObject[i];
        }
    }

    protected TapADTrackerObject(Parcel parcel) {
        this.a = (ExposureTrackerObject) parcel.readParcelable(ExposureTrackerObject.class.getClassLoader());
        this.b = (ClickTrackerObject) parcel.readParcelable(ClickTrackerObject.class.getClassLoader());
    }

    public TapADTrackerObject(ExposureTrackerObject exposureTrackerObject, ClickTrackerObject clickTrackerObject) {
        this.a = exposureTrackerObject;
        this.b = clickTrackerObject;
    }

    public void a(int i, Map<String, String> map) {
        ExposureTrackerObject exposureTrackerObject = this.a;
        if (exposureTrackerObject.a) {
            exposureTrackerObject.e();
        }
        this.b.a(i, map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }
}
