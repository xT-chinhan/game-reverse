package com.tapsdk.tapad.internal.tracker;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.tapsdk.tapad.model.entities.TapAdResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ExposureTrackerObject implements Parcelable {
    public static final Parcelable.Creator<ExposureTrackerObject> CREATOR = new a();
    public final boolean a;
    final ConcurrentHashMap<String, Integer> b;
    final ConcurrentHashMap<String, Integer> c;
    final ConcurrentHashMap<String, Integer> d;
    final List<String> e;
    final List<DynamicHeader> f;
    final List<String> g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    long u;
    long v;
    long w;
    boolean x;
    long y;

    static class a implements Parcelable.Creator<ExposureTrackerObject> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExposureTrackerObject createFromParcel(Parcel parcel) {
            return new ExposureTrackerObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExposureTrackerObject[] newArray(int i) {
            return new ExposureTrackerObject[i];
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TapAdResp.ExposureFieldType.values().length];
            a = iArr;
            try {
                iArr[TapAdResp.ExposureFieldType.SCREEN_AREA_PERCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TapAdResp.ExposureFieldType.AD_AREA_PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TapAdResp.ExposureFieldType.AD_WIDTH_PIXEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TapAdResp.ExposureFieldType.IMAGE_DISPLAY_MILLISECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TapAdResp.ExposureFieldType.AD_DISPLAY_MILLISECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TapAdResp.ExposureFieldType.VIDEO_PLAY_MILLISECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected ExposureTrackerObject(Parcel parcel) {
        this.a = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.k, Integer.class, 1)).intValue() == 1;
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.g = arrayList3;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = false;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.j = parcel.readByte() != 0;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        parcel.readTypedList(arrayList2, DynamicHeader.CREATOR);
        parcel.readStringList(arrayList);
        this.n = parcel.readByte() != 0;
        parcel.readStringList(arrayList3);
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.b.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
        }
        int i3 = parcel.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.c.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
        }
        int i5 = parcel.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            this.d.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
        }
        this.y = parcel.readLong();
    }

    public ExposureTrackerObject(TapAdResp.f0 f0Var, List<String> list, List<String> list2, List<String> list3, List<String> list4, TapAdResp.d0 d0Var, List<String> list5, List<DynamicHeader> list6, boolean z, long j) {
        this.a = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.k, Integer.class, 1)).intValue() == 1;
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        this.b = concurrentHashMap;
        ConcurrentHashMap<String, Integer> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.c = concurrentHashMap2;
        ConcurrentHashMap<String, Integer> concurrentHashMap3 = new ConcurrentHashMap<>();
        this.d = concurrentHashMap3;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.g = arrayList3;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = false;
        a(concurrentHashMap3, list, list5, d0Var.t4());
        a(concurrentHashMap2, list2, list5, d0Var.N5());
        a(concurrentHashMap, list3, list5, d0Var.d1());
        a(f0Var);
        arrayList2.addAll(list6);
        arrayList.addAll(list4);
        this.n = z;
        arrayList3.addAll(list5);
        this.y = j;
    }

    private HashMap<String, String> a(View view) {
        HashMap<String, String> map = new HashMap<>();
        if (view == null) {
            return map;
        }
        map.put("__SPACE_WIDTH__", view.getMeasuredWidth() + "");
        map.put("__SPACE_HEIGHT__", view.getMeasuredHeight() + "");
        return map;
    }

    private void a(TapAdResp.f0 f0Var) {
        Iterator<TapAdResp.ExposureFieldType> it = f0Var.k5().iterator();
        while (it.hasNext()) {
            switch (b.a[it.next().ordinal()]) {
                case 1:
                    this.h = true;
                    this.o = f0Var.g3();
                    break;
                case 2:
                    this.i = true;
                    this.p = f0Var.J1();
                    break;
                case 3:
                    this.j = true;
                    this.q = f0Var.T2();
                    break;
                case 4:
                    this.k = true;
                    this.r = f0Var.t3();
                    break;
                case 5:
                    this.l = true;
                    this.s = f0Var.E5();
                    break;
                case 6:
                    this.m = true;
                    this.t = f0Var.I0();
                    break;
            }
        }
    }

    private void a(Map<String, Integer> map, List<String> list, List<String> list2, int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        for (String str : list) {
            map.put(str, list2.contains(Uri.parse(str).getHost()) ? Integer.MAX_VALUE : Integer.valueOf(i));
        }
    }

    private void a(Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue().intValue() > 0) {
                c.a().a(entry.getKey(), map2, this.f, map3);
                map.put(entry.getKey(), Integer.valueOf(entry.getValue().intValue() - 1));
            }
        }
    }

    void a(Map<String, String> map) {
        if (this.n) {
            c.a().a(this.e, map);
        }
    }

    boolean a() {
        boolean z = this.l && this.u == 0;
        if (z) {
            this.u = System.currentTimeMillis();
        }
        return z;
    }

    void b(View view) {
        a(this.c, null, a(view));
    }

    public void b(Map<String, String> map) {
        a(this.d, map, null);
    }

    boolean b() {
        boolean z = this.k && this.v == 0;
        if (z) {
            this.v = System.currentTimeMillis();
        }
        return z;
    }

    void c(View view) {
        this.x = true;
        a(this.b, null, a(view));
    }

    boolean c() {
        boolean z = this.m && this.w == 0;
        if (z) {
            this.w = System.currentTimeMillis();
        }
        return z;
    }

    void d() {
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void e() {
        if (this.x) {
            return;
        }
        this.x = true;
        Map<String, String> map = new HashMap<>();
        map.put("is_click_supplement", "1");
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
            if (this.g.contains(Uri.parse(entry.getKey()).getHost())) {
                map2.put(entry.getKey(), entry.getValue());
            } else {
                map3.put(entry.getKey(), entry.getValue());
            }
        }
        a(map2, map, null);
        a(map3, null, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeTypedList(this.f);
        parcel.writeStringList(this.e);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.g);
        parcel.writeInt(this.b.size());
        for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeInt(entry.getValue().intValue());
        }
        parcel.writeInt(this.c.size());
        for (Map.Entry<String, Integer> entry2 : this.c.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeInt(entry2.getValue().intValue());
        }
        parcel.writeInt(this.d.size());
        for (Map.Entry<String, Integer> entry3 : this.d.entrySet()) {
            parcel.writeString(entry3.getKey());
            parcel.writeInt(entry3.getValue().intValue());
        }
        parcel.writeLong(this.y);
    }
}
