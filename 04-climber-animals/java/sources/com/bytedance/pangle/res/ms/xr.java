package com.bytedance.pangle.res.ms;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private int[] ao;
    private ab ch;
    private int h;
    private final byte[] ny;
    private int[] sl;
    private boolean u;
    private int ub;
    private final x x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    HashMap<Integer, Integer> f680ms = new HashMap<>();
    boolean xr = false;
    private boolean hi = false;
    private final ms zb = new ms();
    int ah = 0;
    int d = 1;
    int ka = 2;
    int c = 3;
    int ab = 4;

    public xr(byte[] bArr, x xVar) {
        this.x = xVar;
        this.ny = bArr;
        d();
    }

    public void ms(InputStream inputStream) {
        ms();
        if (inputStream != null) {
            this.ch = new ab(new ny(new ka(inputStream)));
        }
    }

    public void ms() {
        if (this.hi) {
            this.hi = false;
            this.ch = null;
            this.sl = null;
            this.zb.ms();
            d();
        }
    }

    public int xr() throws IOException {
        if (this.ch == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            ka();
            return this.ub;
        } catch (IOException e) {
            ms();
            throw e;
        }
    }

    public int ah() throws IOException {
        return xr();
    }

    public void xr(InputStream inputStream) {
        ms(inputStream);
    }

    private static final class ms {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int[] f681ms = new int[32];
        private int xr;

        public void ms() {
            this.xr = 0;
            this.ah = 0;
        }

        public int xr() {
            int i = this.xr;
            if (i == 0) {
                return 0;
            }
            return this.f681ms[i - 1];
        }

        public void ms(int i, int i2) {
            if (this.ah == 0) {
                ka();
            }
            ms(2);
            int i3 = this.xr;
            int i4 = i3 - 1;
            int[] iArr = this.f681ms;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.xr = i3 + 2;
        }

        public boolean ah() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.xr;
            if (i3 == 0 || (i2 = (iArr = this.f681ms)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.xr = i3 - 2;
            return true;
        }

        public int d() {
            return this.ah;
        }

        public void ka() {
            ms(2);
            int i = this.xr;
            int[] iArr = this.f681ms;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.xr = i + 2;
            this.ah++;
        }

        public void c() {
            int i = this.xr;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.f681ms[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.xr = i - (i3 + 2);
            this.ah--;
        }

        private void ms(int i) {
            int[] iArr = this.f681ms;
            int length = iArr.length;
            int i2 = this.xr;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f681ms = iArr2;
        }
    }

    private void d() {
        this.ub = -1;
        this.ao = null;
        this.h = -1;
    }

    private void ka() throws IOException {
        int[] iArr;
        if (!this.hi) {
            this.ch.ms(524291, 524289);
            this.ch.ms();
            sl.ms(this.ch);
            this.zb.ka();
            this.hi = true;
        }
        int i = this.ub;
        if (i == this.d) {
            return;
        }
        d();
        while (true) {
            int i2 = 0;
            if (this.u) {
                this.u = false;
                this.zb.c();
            }
            if (i == this.c && this.zb.d() == 1 && this.zb.xr() == 0) {
                this.ub = this.d;
                return;
            }
            int i3 = i == this.ah ? 1048834 : this.ch.readInt();
            if (i3 == 524672) {
                this.f680ms.clear();
                int i4 = this.ch.readInt();
                if (i4 < 8 || i4 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + i4 + ").");
                }
                int iMs = hi.ms(this.ch);
                this.sl = this.ch.ms((i4 / 4) - 2);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int[] iArr2 = this.sl;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    int iMs2 = hi.ms(this.ny, iArr2[i2], (i2 * 4) + iMs, this.x);
                    if (iMs2 >= 2130706432) {
                        this.f680ms.put(Integer.valueOf(i2), Integer.valueOf(iMs2));
                        arrayList.add(Integer.valueOf(iMs2));
                    }
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.xr = true;
                }
            } else {
                if (i3 < 1048832 || i3 > 1048836) {
                    throw new IOException("Invalid chunk type (" + i3 + ").");
                }
                if (i3 == 1048834 && i == -1) {
                    this.ub = this.ah;
                    return;
                }
                this.ch.ms();
                this.ch.readInt();
                this.ch.ms();
                if (i3 == 1048832 || i3 == 1048833) {
                    if (i3 == 1048832) {
                        this.zb.ms(this.ch.readInt(), this.ch.readInt());
                    } else {
                        this.ch.ms();
                        this.ch.ms();
                        this.zb.ah();
                    }
                } else {
                    if (i3 == 1048834) {
                        this.ch.readInt();
                        this.ch.readInt();
                        this.ch.ms();
                        int i5 = this.ch.readInt() & SupportMenu.USER_MASK;
                        this.h = (65535 & this.ch.readInt()) - 1;
                        int iMs3 = hi.ms(this.ch);
                        int i6 = i5 * 5;
                        this.ao = this.ch.ms(i6);
                        int i7 = 3;
                        while (true) {
                            iArr = this.ao;
                            if (i7 >= iArr.length) {
                                break;
                            }
                            iArr[i7] = iArr[i7] >>> 24;
                            i7 += 5;
                        }
                        if (iArr.length != i6) {
                            throw new RuntimeException();
                        }
                        boolean z = false;
                        while (i2 < i5) {
                            int i8 = i2 * 5;
                            if (this.f680ms.containsKey(Integer.valueOf(this.ao[i8 + 1]))) {
                                z = true;
                            }
                            int[] iArr3 = this.ao;
                            int i9 = iArr3[i8 + 3];
                            if (i9 == 1 || i9 == 2) {
                                int i10 = i8 + 4;
                                hi.ms(this.ny, iArr3[i10], (i10 * 4) + iMs3, this.x);
                            }
                            i2++;
                        }
                        if (z && this.xr) {
                            hi.ms(iMs3, this.ny, this.ao, i5, this.f680ms);
                        }
                        this.zb.ka();
                        this.ub = this.ka;
                        return;
                    }
                    if (i3 == 1048835) {
                        this.ch.readInt();
                        this.ch.readInt();
                        this.ub = this.c;
                        this.u = true;
                        return;
                    }
                    if (i3 == 1048836) {
                        this.ch.readInt();
                        this.ch.ms();
                        this.ch.ms();
                        this.ub = this.ab;
                        return;
                    }
                }
            }
        }
    }
}
