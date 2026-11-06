package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements Parcelable {
    public static final Parcelable.Creator<xr> CREATOR = new Parcelable.Creator<xr>() { // from class: com.ss.android.socialbase.downloader.model.xr.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public xr createFromParcel(Parcel parcel) {
            return new xr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public xr[] newArray(int i) {
            return new xr[i];
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4715ms = "xr";
    private int ab;
    private long ah;
    private long c;
    private List<xr> ch;
    private AtomicLong d;
    private xr hi;
    private long ka;
    private long ny;
    private int sl;
    private AtomicBoolean u;
    private com.ss.android.socialbase.downloader.x.xr ub;
    private AtomicInteger x;
    private int xr;
    private boolean zb;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private xr(ms msVar) {
        if (msVar == null) {
            return;
        }
        this.xr = msVar.f4716ms;
        this.ah = msVar.xr;
        this.d = new AtomicLong(msVar.ah);
        this.ka = msVar.d;
        this.c = msVar.ka;
        this.ab = msVar.c;
        this.ny = msVar.ab;
        this.x = new AtomicInteger(-1);
        ms(msVar.x);
        this.u = new AtomicBoolean(false);
    }

    public xr(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.xr = cursor.getInt(cursor.getColumnIndex(bz.d));
        this.ab = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.ah = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.d = new AtomicLong(0L);
        }
        this.ka = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.x = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.x = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.c = cursor.getLong(columnIndex3);
        }
        this.u = new AtomicBoolean(false);
    }

    protected xr(Parcel parcel) {
        this.xr = parcel.readInt();
        this.ah = parcel.readLong();
        this.d = new AtomicLong(parcel.readLong());
        this.ka = parcel.readLong();
        this.c = parcel.readLong();
        this.ab = parcel.readInt();
        this.x = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.xr);
        parcel.writeLong(this.ah);
        AtomicLong atomicLong = this.d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.ka);
        parcel.writeLong(this.c);
        parcel.writeInt(this.ab);
        AtomicInteger atomicInteger = this.x;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues ms() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(bz.d, Integer.valueOf(this.xr));
        contentValues.put("chunkIndex", Integer.valueOf(this.ab));
        contentValues.put("startOffset", Long.valueOf(this.ah));
        contentValues.put("curOffset", Long.valueOf(u()));
        contentValues.put("endOffset", Long.valueOf(this.ka));
        contentValues.put("chunkContentLen", Long.valueOf(this.c));
        contentValues.put("hostChunkIndex", Integer.valueOf(xr()));
        return contentValues;
    }

    public void ms(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.sl = 0;
        sQLiteStatement.clearBindings();
        int i = this.sl + 1;
        this.sl = i;
        sQLiteStatement.bindLong(i, this.xr);
        int i2 = this.sl + 1;
        this.sl = i2;
        sQLiteStatement.bindLong(i2, this.ab);
        int i3 = this.sl + 1;
        this.sl = i3;
        sQLiteStatement.bindLong(i3, this.ah);
        int i4 = this.sl + 1;
        this.sl = i4;
        sQLiteStatement.bindLong(i4, u());
        int i5 = this.sl + 1;
        this.sl = i5;
        sQLiteStatement.bindLong(i5, this.ka);
        int i6 = this.sl + 1;
        this.sl = i6;
        sQLiteStatement.bindLong(i6, this.c);
        int i7 = this.sl + 1;
        this.sl = i7;
        sQLiteStatement.bindLong(i7, xr());
    }

    public int xr() {
        AtomicInteger atomicInteger = this.x;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void ms(int i) {
        AtomicInteger atomicInteger = this.x;
        if (atomicInteger == null) {
            this.x = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean ah() {
        AtomicBoolean atomicBoolean = this.u;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void ms(com.ss.android.socialbase.downloader.x.xr xrVar) {
        this.ub = xrVar;
        qv();
    }

    public void ms(boolean z) {
        AtomicBoolean atomicBoolean = this.u;
        if (atomicBoolean == null) {
            this.u = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.ub = null;
    }

    public void ms(xr xrVar) {
        this.hi = xrVar;
        if (xrVar != null) {
            ms(xrVar.y());
        }
    }

    public boolean d() {
        return xr() == -1;
    }

    public xr ka() {
        xr xrVar = !d() ? this.hi : this;
        if (xrVar == null || !xrVar.c()) {
            return null;
        }
        return xrVar.ab().get(0);
    }

    public boolean c() {
        List<xr> list = this.ch;
        return list != null && list.size() > 0;
    }

    public void ms(List<xr> list) {
        this.ch = list;
    }

    public List<xr> ab() {
        return this.ch;
    }

    public boolean x() {
        xr xrVar = this.hi;
        if (xrVar == null) {
            return true;
        }
        if (!xrVar.c()) {
            return false;
        }
        for (int i = 0; i < this.hi.ab().size(); i++) {
            xr xrVar2 = this.hi.ab().get(i);
            if (xrVar2 != null) {
                int iIndexOf = this.hi.ab().indexOf(this);
                if (iIndexOf > i && !xrVar2.ny()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void xr(boolean z) {
        this.zb = z;
    }

    public boolean ny() {
        long j = this.ah;
        if (d()) {
            long j2 = this.ny;
            if (j2 > this.ah) {
                j = j2;
            }
        }
        return u() - j >= this.c;
    }

    public long ch() {
        xr xrVar = this.hi;
        if (xrVar != null && xrVar.ab() != null) {
            int iIndexOf = this.hi.ab().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.hi.ab().size(); i++) {
                xr xrVar2 = this.hi.ab().get(i);
                if (xrVar2 != null) {
                    if (z) {
                        return xrVar2.u();
                    }
                    if (iIndexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public void xr(int i) {
        this.xr = i;
    }

    public void ah(int i) {
        this.ab = i;
    }

    public void ms(long j) {
        this.c = j;
    }

    public int hi() {
        return this.xr;
    }

    public long sl() {
        return this.ah;
    }

    public long zb() {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long u() {
        if (d() && c()) {
            long jZb = 0;
            for (int i = 0; i < this.ch.size(); i++) {
                xr xrVar = this.ch.get(i);
                if (xrVar != null) {
                    if (!xrVar.ny()) {
                        return xrVar.zb();
                    }
                    if (jZb < xrVar.zb()) {
                        jZb = xrVar.zb();
                    }
                }
            }
            return jZb;
        }
        return zb();
    }

    public void xr(long j) {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.d = new AtomicLong(j);
        }
    }

    public long ub() {
        long jU = u() - this.ah;
        if (c()) {
            jU = 0;
            for (int i = 0; i < this.ch.size(); i++) {
                xr xrVar = this.ch.get(i);
                if (xrVar != null) {
                    jU += xrVar.u() - xrVar.sl();
                }
            }
        }
        return jU;
    }

    public long ao() {
        return this.ka;
    }

    public long h() {
        return this.c;
    }

    public void qv() {
        this.ny = u();
    }

    public long ah(boolean z) {
        long jU = u();
        long j = this.c;
        long j2 = this.ny;
        long j3 = j - (jU - j2);
        if (!z && jU == j2) {
            j3 = j - (jU - this.ah);
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("DownloadChunk", "contentLength:" + this.c + " curOffset:" + u() + " oldOffset:" + this.ny + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<xr> ms(int i, long j) {
        xr xrVar;
        long jAo;
        long jSl;
        long j2;
        long j3;
        xr xrVar2 = this;
        int i2 = i;
        if (!d() || c()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jZb = zb();
        long jAh = xrVar2.ah(true);
        long j4 = jAh / ((long) i2);
        com.ss.android.socialbase.downloader.ah.ms.xr(f4715ms, "retainLen:" + jAh + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + xrVar2.ab);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jSl = sl();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jAo2 = ao();
                    j2 = jAo2;
                    j3 = jAo2 > jZb ? (jAo2 - jZb) + 1 : jAh - (((long) i4) * j4);
                    jSl = jZb;
                } else {
                    jSl = jZb;
                }
                long j5 = jAh;
                long j6 = j3;
                xr xrVarMs = new ms(xrVar2.xr).ms((-i3) - 1).ms(jSl).xr(jZb).ka(jZb).ah(j2).d(j6).ms(xrVar2).ms();
                com.ss.android.socialbase.downloader.ah.ms.xr(f4715ms, "divide sub chunk : " + i3 + " startOffset:" + jSl + " curOffset:" + jZb + " endOffset:" + j2 + " contentLen:" + j6);
                arrayList.add(xrVarMs);
                jZb += j4;
                i3++;
                xrVar2 = this;
                i2 = i;
                jAh = j5;
            }
            j2 = (jZb + j4) - 1;
            j3 = j4;
            long j7 = jAh;
            long j8 = j3;
            xr xrVarMs2 = new ms(xrVar2.xr).ms((-i3) - 1).ms(jSl).xr(jZb).ka(jZb).ah(j2).d(j8).ms(xrVar2).ms();
            com.ss.android.socialbase.downloader.ah.ms.xr(f4715ms, "divide sub chunk : " + i3 + " startOffset:" + jSl + " curOffset:" + jZb + " endOffset:" + j2 + " contentLen:" + j8);
            arrayList.add(xrVarMs2);
            jZb += j4;
            i3++;
            xrVar2 = this;
            i2 = i;
            jAh = j7;
        }
        long jH = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            xr xrVar3 = arrayList.get(size);
            if (xrVar3 != null) {
                jH += xrVar3.h();
            }
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(f4715ms, "reuseChunkContentLen:".concat(String.valueOf(jH)));
        xr xrVar4 = arrayList.get(0);
        if (xrVar4 != null) {
            if (ao() == 0) {
                jAo = j - sl();
            } else {
                jAo = (ao() - sl()) + 1;
            }
            xrVar4.ms(jAo - jH);
            xrVar = this;
            xrVar4.ah(xrVar.ab);
            com.ss.android.socialbase.downloader.x.xr xrVar5 = xrVar.ub;
            if (xrVar5 != null) {
                xrVar5.ms(xrVar4.ao(), h() - jH);
            }
        } else {
            xrVar = this;
        }
        xrVar.ms(arrayList);
        return arrayList;
    }

    public int y() {
        return this.ab;
    }

    public static class ms {
        private long ab;
        private long ah;
        private int c;
        private long d;
        private long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f4716ms;
        private xr x;
        private long xr;

        public ms(int i) {
            this.f4716ms = i;
        }

        public ms ms(long j) {
            this.xr = j;
            return this;
        }

        public ms xr(long j) {
            this.ah = j;
            return this;
        }

        public ms ah(long j) {
            this.d = j;
            return this;
        }

        public ms d(long j) {
            this.ka = j;
            return this;
        }

        public ms ms(int i) {
            this.c = i;
            return this;
        }

        public ms ms(xr xrVar) {
            this.x = xrVar;
            return this;
        }

        public ms ka(long j) {
            this.ab = j;
            return this;
        }

        public xr ms() {
            return new xr(this);
        }
    }
}
