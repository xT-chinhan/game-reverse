package com.tapsdk.tapad.internal.tracker.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TrackADMessage implements Parcelable {
    public final String a;
    private int b;
    public final Map<String, String> c;
    public final List<DynamicHeader> d;
    public final Map<String, String> e;
    public static final List<DynamicHeader> f = new ArrayList();
    public static final Map<String, String> g = new HashMap();
    public static final Parcelable.Creator<TrackADMessage> CREATOR = new a();

    static class a implements Parcelable.Creator<TrackADMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackADMessage createFromParcel(Parcel parcel) {
            return new TrackADMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackADMessage[] newArray(int i) {
            return new TrackADMessage[i];
        }
    }

    protected TrackADMessage(Parcel parcel) {
        this.b = 0;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        HashMap map = new HashMap();
        this.c = map;
        parcel.readMap(map, TrackADMessage.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        parcel.readTypedList(arrayList, DynamicHeader.CREATOR);
        HashMap map2 = new HashMap();
        this.e = map2;
        parcel.readMap(map2, TrackADMessage.class.getClassLoader());
    }

    public TrackADMessage(String str, Map<String, String> map) {
        this(str, map, f, g);
    }

    public TrackADMessage(String str, Map<String, String> map, List<DynamicHeader> list) {
        this(str, map, list, g);
    }

    public TrackADMessage(String str, Map<String, String> map, List<DynamicHeader> list, Map<String, String> map2) {
        this.b = 0;
        this.a = str;
        this.c = map;
        this.d = list;
        this.e = map2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        int i = this.b + 1;
        this.b = i;
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeMap(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeMap(this.e);
    }
}
