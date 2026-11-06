package com.tapsdk.tapad.internal.tracker;

import android.os.Parcel;
import android.os.Parcelable;
import com.tapsdk.tapad.internal.utils.s;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ClickTrackerObject implements Parcelable {
    public static final Parcelable.Creator<ClickTrackerObject> CREATOR = new a();
    final List<String> a;
    final List<DynamicHeader> b;

    static class a implements Parcelable.Creator<ClickTrackerObject> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClickTrackerObject createFromParcel(Parcel parcel) {
            return new ClickTrackerObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClickTrackerObject[] newArray(int i) {
            return new ClickTrackerObject[i];
        }
    }

    protected ClickTrackerObject(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        parcel.readStringList(arrayList);
        parcel.readTypedList(arrayList2, DynamicHeader.CREATOR);
    }

    public ClickTrackerObject(List<String> list, List<DynamicHeader> list2) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        arrayList.addAll(list);
        arrayList2.addAll(list2);
    }

    void a(int i, Map<String, String> map) {
        c.a().a(s.a(this.a, i), map, this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.a);
        parcel.writeTypedList(this.b);
    }
}
