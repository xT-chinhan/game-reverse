package com.byazt.auw;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 13})
public class hw implements Parcelable {
    public long aj;
    public long c;
    public int fw;
    public AtomicBoolean g;
    public long hn;
    public com.byazt.gi.hw ho;
    public int hw;
    public int k;
    public boolean m;
    public long uc;
    public List<hw> vk;
    public hw w;
    public AtomicLong x;
    public AtomicInteger zo;
    public static final String pr = hw.class.getSimpleName();
    public static final Parcelable.Creator<hw> CREATOR = new Parcelable.Creator<hw>() { // from class: com.byazt.auw.hw.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hw createFromParcel(Parcel parcel) {
            return new hw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hw[] newArray(int i) {
            return new hw[i];
        }
    };

    private hw(pr prVar) {
        if (prVar == null) {
            return;
        }
        this.hw = prVar.pr;
        this.hn = prVar.hw;
        this.x = new AtomicLong(prVar.hn);
        this.c = prVar.x;
        this.uc = prVar.c;
        this.fw = prVar.uc;
        this.aj = prVar.fw;
        this.zo = new AtomicInteger(-1);
        pr(prVar.zo);
        this.g = new AtomicBoolean(false);
    }

    public hw(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.hw = cursor.getInt(cursor.getColumnIndex(ar.d));
        this.fw = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.hn = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.x = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.x = new AtomicLong(0L);
        }
        this.c = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.zo = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.zo = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.uc = cursor.getLong(columnIndex3);
        }
        this.g = new AtomicBoolean(false);
    }

    public hw(Parcel parcel) {
        this.hw = parcel.readInt();
        this.hn = parcel.readLong();
        this.x = new AtomicLong(parcel.readLong());
        this.c = parcel.readLong();
        this.uc = parcel.readLong();
        this.fw = parcel.readInt();
        this.zo = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        long j;
        parcel.writeInt(this.hw);
        parcel.writeLong(this.hn);
        AtomicLong atomicLong = this.x;
        if (atomicLong == null) {
            j = 0;
        } else {
            j = atomicLong.get();
        }
        parcel.writeLong(j);
        parcel.writeLong(this.c);
        parcel.writeLong(this.uc);
        parcel.writeInt(this.fw);
        int i2 = -1;
        AtomicInteger atomicInteger = this.zo;
        if (atomicInteger != null) {
            i2 = atomicInteger.get();
        }
        parcel.writeInt(i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContentValues pr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(this.hw));
        contentValues.put("chunkIndex", Integer.valueOf(this.fw));
        contentValues.put("startOffset", Long.valueOf(this.hn));
        contentValues.put("curOffset", Long.valueOf(g()));
        contentValues.put("endOffset", Long.valueOf(this.c));
        contentValues.put("chunkContentLen", Long.valueOf(this.uc));
        contentValues.put("hostChunkIndex", Integer.valueOf(hw()));
        return contentValues;
    }

    public void pr(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.k = 0;
        sQLiteStatement.clearBindings();
        int i = this.k + 1;
        this.k = i;
        sQLiteStatement.bindLong(i, this.hw);
        int i2 = this.k + 1;
        this.k = i2;
        sQLiteStatement.bindLong(i2, this.fw);
        int i3 = this.k + 1;
        this.k = i3;
        sQLiteStatement.bindLong(i3, this.hn);
        int i4 = this.k + 1;
        this.k = i4;
        sQLiteStatement.bindLong(i4, g());
        int i5 = this.k + 1;
        this.k = i5;
        sQLiteStatement.bindLong(i5, this.c);
        int i6 = this.k + 1;
        this.k = i6;
        sQLiteStatement.bindLong(i6, this.uc);
        int i7 = this.k + 1;
        this.k = i7;
        sQLiteStatement.bindLong(i7, hw());
    }

    public int hw() {
        AtomicInteger atomicInteger = this.zo;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void pr(int i) {
        AtomicInteger atomicInteger = this.zo;
        if (atomicInteger == null) {
            this.zo = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean hn() {
        AtomicBoolean atomicBoolean = this.g;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void pr(com.byazt.gi.hw hwVar) {
        this.ho = hwVar;
        lb();
    }

    public void pr(boolean z) {
        AtomicBoolean atomicBoolean = this.g;
        if (atomicBoolean == null) {
            this.g = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.ho = null;
    }

    public void pr(hw hwVar) {
        this.w = hwVar;
        if (hwVar != null) {
            pr(hwVar.qa());
        }
    }

    public boolean x() {
        return hw() == -1;
    }

    public hw c() {
        hw hwVar;
        if (x()) {
            hwVar = this;
        } else {
            hwVar = this.w;
        }
        if (hwVar == null || !hwVar.uc()) {
            return null;
        }
        return hwVar.fw().get(0);
    }

    public boolean uc() {
        List<hw> list = this.vk;
        return list != null && list.size() > 0;
    }

    public void pr(List<hw> list) {
        this.vk = list;
    }

    public List<hw> fw() {
        return this.vk;
    }

    public boolean zo() {
        hw hwVar = this.w;
        if (hwVar == null) {
            return true;
        }
        if (!hwVar.uc()) {
            return false;
        }
        for (int i = 0; i < this.w.fw().size(); i++) {
            hw hwVar2 = this.w.fw().get(i);
            if (hwVar2 != null) {
                int iIndexOf = this.w.fw().indexOf(this);
                if (iIndexOf > i && !hwVar2.aj()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void hw(boolean z) {
        this.m = z;
    }

    public boolean aj() {
        long j = this.hn;
        if (x()) {
            long j2 = this.aj;
            if (j2 > this.hn) {
                j = j2;
            }
        }
        return g() - j >= this.uc;
    }

    public long vk() {
        hw hwVar = this.w;
        if (hwVar == null || hwVar.fw() == null) {
            return -1L;
        }
        int iIndexOf = this.w.fw().indexOf(this);
        boolean z = false;
        for (int i = 0; i < this.w.fw().size(); i++) {
            hw hwVar2 = this.w.fw().get(i);
            if (hwVar2 != null) {
                if (z) {
                    return hwVar2.g();
                }
                if (iIndexOf == i) {
                    z = true;
                }
            }
        }
        return -1L;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public void hn(int i) {
        this.fw = i;
    }

    public void pr(long j) {
        this.uc = j;
    }

    public int w() {
        return this.hw;
    }

    public long k() {
        return this.hn;
    }

    public long m() {
        AtomicLong atomicLong = this.x;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long g() {
        if (x() && uc()) {
            long jM = 0;
            for (int i = 0; i < this.vk.size(); i++) {
                hw hwVar = this.vk.get(i);
                if (hwVar != null) {
                    if (!hwVar.aj()) {
                        return hwVar.m();
                    }
                    if (jM < hwVar.m()) {
                        jM = hwVar.m();
                    }
                }
            }
            return jM;
        }
        return m();
    }

    public void hw(long j) {
        AtomicLong atomicLong = this.x;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.x = new AtomicLong(j);
        }
    }

    public long ho() {
        long jG = g() - this.hn;
        if (uc()) {
            jG = 0;
            for (int i = 0; i < this.vk.size(); i++) {
                hw hwVar = this.vk.get(i);
                if (hwVar != null) {
                    jG += hwVar.g() - hwVar.k();
                }
            }
        }
        return jG;
    }

    public long nt() {
        return this.c;
    }

    public long yb() {
        return this.uc;
    }

    public void lb() {
        this.aj = g();
    }

    public long hn(boolean z) {
        long jG = g();
        long j = this.uc;
        long j2 = this.aj;
        long j3 = j - (jG - j2);
        if (!z && jG == j2) {
            j3 = j - (jG - this.hn);
        }
        com.byazt.p000do.pr.hw("DownloadChunk", "contentLength:" + this.uc + " curOffset:" + g() + " oldOffset:" + this.aj + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<hw> pr(int i, long j) {
        hw hwVar;
        long jNt;
        long jK;
        long j2;
        long j3;
        hw hwVar2 = this;
        int i2 = i;
        if (x() && !uc()) {
            ArrayList arrayList = new ArrayList();
            long jM = m();
            long jHn = hwVar2.hn(true);
            long j4 = jHn / ((long) i2);
            com.byazt.p000do.pr.hw(pr, "retainLen:" + jHn + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + hwVar2.fw);
            int i3 = 0;
            while (i3 < i2) {
                if (i3 == 0) {
                    jK = k();
                } else {
                    int i4 = i2 - 1;
                    if (i3 != i4) {
                        jK = jM;
                    } else {
                        long jNt2 = nt();
                        if (jNt2 > jM) {
                            j2 = jNt2;
                            j3 = (jNt2 - jM) + 1;
                            jK = jM;
                        } else {
                            j2 = jNt2;
                            j3 = jHn - (((long) i4) * j4);
                            jK = jM;
                        }
                    }
                    long j5 = jHn;
                    long j6 = j3;
                    hw hwVarPr = new pr(hwVar2.hw).pr((-i3) - 1).pr(jK).hw(jM).c(jM).hn(j2).x(j6).pr(hwVar2).pr();
                    com.byazt.p000do.pr.hw(pr, "divide sub chunk : " + i3 + " startOffset:" + jK + " curOffset:" + jM + " endOffset:" + j2 + " contentLen:" + j6);
                    arrayList.add(hwVarPr);
                    jM += j4;
                    i3++;
                    hwVar2 = this;
                    i2 = i;
                    jHn = j5;
                }
                j2 = (jM + j4) - 1;
                j3 = j4;
                long j7 = jHn;
                long j8 = j3;
                hw hwVarPr2 = new pr(hwVar2.hw).pr((-i3) - 1).pr(jK).hw(jM).c(jM).hn(j2).x(j8).pr(hwVar2).pr();
                com.byazt.p000do.pr.hw(pr, "divide sub chunk : " + i3 + " startOffset:" + jK + " curOffset:" + jM + " endOffset:" + j2 + " contentLen:" + j8);
                arrayList.add(hwVarPr2);
                jM += j4;
                i3++;
                hwVar2 = this;
                i2 = i;
                jHn = j7;
            }
            long jYb = 0;
            for (int size = arrayList.size() - 1; size > 0; size--) {
                hw hwVar3 = arrayList.get(size);
                if (hwVar3 != null) {
                    jYb += hwVar3.yb();
                }
            }
            com.byazt.p000do.pr.hw(pr, "reuseChunkContentLen:".concat(String.valueOf(jYb)));
            hw hwVar4 = arrayList.get(0);
            if (hwVar4 == null) {
                hwVar = this;
            } else {
                if (nt() == 0) {
                    jNt = j - k();
                } else {
                    jNt = (nt() - k()) + 1;
                }
                hwVar4.pr(jNt - jYb);
                hwVar = this;
                hwVar4.hn(hwVar.fw);
                com.byazt.gi.hw hwVar5 = hwVar.ho;
                if (hwVar5 != null) {
                    hwVar5.pr(hwVar4.nt(), yb() - jYb);
                }
            }
            hwVar.pr(arrayList);
            return arrayList;
        }
        return null;
    }

    public int qa() {
        return this.fw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public long c;
        public long fw;
        public long hn;
        public long hw;
        public int pr;
        public int uc;
        public long x;
        public hw zo;

        public pr(int i) {
            this.pr = i;
        }

        public pr pr(long j) {
            this.hw = j;
            return this;
        }

        public pr hw(long j) {
            this.hn = j;
            return this;
        }

        public pr hn(long j) {
            this.x = j;
            return this;
        }

        public pr x(long j) {
            this.c = j;
            return this;
        }

        public pr pr(int i) {
            this.uc = i;
            return this;
        }

        public pr pr(hw hwVar) {
            this.zo = hwVar;
            return this;
        }

        public pr c(long j) {
            this.fw = j;
            return this;
        }

        public hw pr() {
            return new hw(this);
        }
    }
}
