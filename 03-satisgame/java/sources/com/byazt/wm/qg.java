package com.byazt.wm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 26})
public class qg implements Parcelable {
    public static final Parcelable.Creator<qg> CREATOR = new Parcelable.Creator<qg>() { // from class: com.byazt.wm.qg.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public qg createFromParcel(Parcel parcel) {
            return new qg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public qg[] newArray(int i) {
            return new qg[i];
        }
    };
    public static final String n = "qg";
    public qg cp;
    public int d;
    public AtomicInteger fs;
    public com.byazt.l.qg k;
    public long l;
    public boolean oa;
    public AtomicLong q;
    public int qg;
    public long rv;
    public long s;
    public AtomicBoolean sz;
    public List<qg> tj;
    public long w;
    public int x;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private qg(n nVar) {
        if (nVar == null) {
            return;
        }
        this.qg = nVar.n;
        this.s = nVar.qg;
        this.q = new AtomicLong(nVar.s);
        this.l = nVar.q;
        this.w = nVar.l;
        this.x = nVar.w;
        this.rv = nVar.x;
        this.fs = new AtomicInteger(-1);
        n(nVar.fs);
        this.sz = new AtomicBoolean(false);
    }

    public qg(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.qg = cursor.getInt(cursor.getColumnIndex("_id"));
        this.x = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.s = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.q = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.q = new AtomicLong(0L);
        }
        this.l = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.fs = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.fs = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.w = cursor.getLong(columnIndex3);
        }
        this.sz = new AtomicBoolean(false);
    }

    public qg(Parcel parcel) {
        this.qg = parcel.readInt();
        this.s = parcel.readLong();
        this.q = new AtomicLong(parcel.readLong());
        this.l = parcel.readLong();
        this.w = parcel.readLong();
        this.x = parcel.readInt();
        this.fs = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.qg);
        parcel.writeLong(this.s);
        AtomicLong atomicLong = this.q;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.l);
        parcel.writeLong(this.w);
        parcel.writeInt(this.x);
        AtomicInteger atomicInteger = this.fs;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues n() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.qg));
        contentValues.put("chunkIndex", Integer.valueOf(this.x));
        contentValues.put("startOffset", Long.valueOf(this.s));
        contentValues.put("curOffset", Long.valueOf(sz()));
        contentValues.put("endOffset", Long.valueOf(this.l));
        contentValues.put("chunkContentLen", Long.valueOf(this.w));
        contentValues.put("hostChunkIndex", Integer.valueOf(qg()));
        return contentValues;
    }

    public void n(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.d = 0;
        sQLiteStatement.clearBindings();
        int i = this.d + 1;
        this.d = i;
        sQLiteStatement.bindLong(i, this.qg);
        int i2 = this.d + 1;
        this.d = i2;
        sQLiteStatement.bindLong(i2, this.x);
        int i3 = this.d + 1;
        this.d = i3;
        sQLiteStatement.bindLong(i3, this.s);
        int i4 = this.d + 1;
        this.d = i4;
        sQLiteStatement.bindLong(i4, sz());
        int i5 = this.d + 1;
        this.d = i5;
        sQLiteStatement.bindLong(i5, this.l);
        int i6 = this.d + 1;
        this.d = i6;
        sQLiteStatement.bindLong(i6, this.w);
        int i7 = this.d + 1;
        this.d = i7;
        sQLiteStatement.bindLong(i7, qg());
    }

    public int qg() {
        AtomicInteger atomicInteger = this.fs;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void n(int i) {
        AtomicInteger atomicInteger = this.fs;
        if (atomicInteger == null) {
            this.fs = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public boolean s() {
        AtomicBoolean atomicBoolean = this.sz;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void n(com.byazt.l.qg qgVar) {
        this.k = qgVar;
        cd();
    }

    public void n(boolean z) {
        AtomicBoolean atomicBoolean = this.sz;
        if (atomicBoolean == null) {
            this.sz = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.k = null;
    }

    public void n(qg qgVar) {
        this.cp = qgVar;
        if (qgVar != null) {
            n(qgVar.um());
        }
    }

    public boolean q() {
        return qg() == -1;
    }

    public qg l() {
        qg qgVar = !q() ? this.cp : this;
        if (qgVar == null || !qgVar.w()) {
            return null;
        }
        return qgVar.x().get(0);
    }

    public boolean w() {
        List<qg> list = this.tj;
        return list != null && list.size() > 0;
    }

    public void n(List<qg> list) {
        this.tj = list;
    }

    public List<qg> x() {
        return this.tj;
    }

    public boolean fs() {
        qg qgVar = this.cp;
        if (qgVar == null) {
            return true;
        }
        if (!qgVar.w()) {
            return false;
        }
        for (int i = 0; i < this.cp.x().size(); i++) {
            qg qgVar2 = this.cp.x().get(i);
            if (qgVar2 != null) {
                int iIndexOf = this.cp.x().indexOf(this);
                if (iIndexOf > i && !qgVar2.rv()) {
                    return false;
                }
                if (iIndexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void qg(boolean z) {
        this.oa = z;
    }

    public boolean rv() {
        long j = this.s;
        if (q()) {
            long j2 = this.rv;
            if (j2 > this.s) {
                j = j2;
            }
        }
        return sz() - j >= this.w;
    }

    public long tj() {
        qg qgVar = this.cp;
        if (qgVar != null && qgVar.x() != null) {
            int iIndexOf = this.cp.x().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.cp.x().size(); i++) {
                qg qgVar2 = this.cp.x().get(i);
                if (qgVar2 != null) {
                    if (z) {
                        return qgVar2.sz();
                    }
                    if (iIndexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public void s(int i) {
        this.x = i;
    }

    public void n(long j) {
        this.w = j;
    }

    public int cp() {
        return this.qg;
    }

    public long d() {
        return this.s;
    }

    public long oa() {
        AtomicLong atomicLong = this.q;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long sz() {
        if (q() && w()) {
            long jOa = 0;
            for (int i = 0; i < this.tj.size(); i++) {
                qg qgVar = this.tj.get(i);
                if (qgVar != null) {
                    if (!qgVar.rv()) {
                        return qgVar.oa();
                    }
                    if (jOa < qgVar.oa()) {
                        jOa = qgVar.oa();
                    }
                }
            }
            return jOa;
        }
        return oa();
    }

    public void qg(long j) {
        AtomicLong atomicLong = this.q;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.q = new AtomicLong(j);
        }
    }

    public long k() {
        long jSz = sz() - this.s;
        if (w()) {
            jSz = 0;
            for (int i = 0; i < this.tj.size(); i++) {
                qg qgVar = this.tj.get(i);
                if (qgVar != null) {
                    jSz += qgVar.sz() - qgVar.d();
                }
            }
        }
        return jSz;
    }

    public long cy() {
        return this.l;
    }

    public long hd() {
        return this.w;
    }

    public void cd() {
        this.rv = sz();
    }

    public long s(boolean z) {
        long jSz = sz();
        long j = this.w;
        long j2 = this.rv;
        long j3 = j - (jSz - j2);
        if (!z && jSz == j2) {
            j3 = j - (jSz - this.s);
        }
        com.byazt.fe.n.qg("DownloadChunk", "contentLength:" + this.w + " curOffset:" + sz() + " oldOffset:" + this.rv + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public List<qg> n(int i, long j) {
        qg qgVar;
        long jCy;
        long jD;
        long j2;
        long j3;
        qg qgVar2 = this;
        int i2 = i;
        if (!q() || w()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jOa = oa();
        long jS = qgVar2.s(true);
        long j4 = jS / ((long) i2);
        com.byazt.fe.n.qg(n, "retainLen:" + jS + " divideChunkForReuse chunkSize:" + j4 + " current host downloadChunk index:" + qgVar2.x);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                jD = d();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long jCy2 = cy();
                    j2 = jCy2;
                    j3 = jCy2 > jOa ? (jCy2 - jOa) + 1 : jS - (((long) i4) * j4);
                    jD = jOa;
                } else {
                    jD = jOa;
                }
                long j5 = jS;
                long j6 = j3;
                qg qgVarN = new n(qgVar2.qg).n((-i3) - 1).n(jD).qg(jOa).l(jOa).s(j2).q(j6).n(qgVar2).n();
                com.byazt.fe.n.qg(n, "divide sub chunk : " + i3 + " startOffset:" + jD + " curOffset:" + jOa + " endOffset:" + j2 + " contentLen:" + j6);
                arrayList.add(qgVarN);
                jOa += j4;
                i3++;
                qgVar2 = this;
                i2 = i;
                jS = j5;
            }
            j2 = (jOa + j4) - 1;
            j3 = j4;
            long j7 = jS;
            long j8 = j3;
            qg qgVarN2 = new n(qgVar2.qg).n((-i3) - 1).n(jD).qg(jOa).l(jOa).s(j2).q(j8).n(qgVar2).n();
            com.byazt.fe.n.qg(n, "divide sub chunk : " + i3 + " startOffset:" + jD + " curOffset:" + jOa + " endOffset:" + j2 + " contentLen:" + j8);
            arrayList.add(qgVarN2);
            jOa += j4;
            i3++;
            qgVar2 = this;
            i2 = i;
            jS = j7;
        }
        long jHd = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            qg qgVar3 = arrayList.get(size);
            if (qgVar3 != null) {
                jHd += qgVar3.hd();
            }
        }
        com.byazt.fe.n.qg(n, "reuseChunkContentLen:".concat(String.valueOf(jHd)));
        qg qgVar4 = arrayList.get(0);
        if (qgVar4 != null) {
            if (cy() == 0) {
                jCy = j - d();
            } else {
                jCy = (cy() - d()) + 1;
            }
            qgVar4.n(jCy - jHd);
            qgVar = this;
            qgVar4.s(qgVar.x);
            com.byazt.l.qg qgVar5 = qgVar.k;
            if (qgVar5 != null) {
                qgVar5.n(qgVar4.cy(), hd() - jHd);
            }
        } else {
            qgVar = this;
        }
        qgVar.n(arrayList);
        return arrayList;
    }

    public int um() {
        return this.x;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 48})
    public static class n {
        public qg fs;
        public long l;
        public int n;
        public long q;
        public long qg;
        public long s;
        public int w;
        public long x;

        public n(int i) {
            this.n = i;
        }

        public n n(long j) {
            this.qg = j;
            return this;
        }

        public n qg(long j) {
            this.s = j;
            return this;
        }

        public n s(long j) {
            this.q = j;
            return this;
        }

        public n q(long j) {
            this.l = j;
            return this;
        }

        public n n(int i) {
            this.w = i;
            return this;
        }

        public n n(qg qgVar) {
            this.fs = qgVar;
            return this;
        }

        public n l(long j) {
            this.x = j;
            return this;
        }

        public qg n() {
            return new qg(this);
        }
    }
}
