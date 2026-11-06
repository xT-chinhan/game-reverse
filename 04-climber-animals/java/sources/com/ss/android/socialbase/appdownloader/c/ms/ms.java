package com.ss.android.socialbase.appdownloader.c.ms;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
class ms implements ny {
    private boolean ab;
    private boolean ah = false;
    private C0545ms c = new C0545ms();
    private int ch;
    private c d;
    private int hi;
    private int[] ka;
    private int ny;
    private int[] sl;
    private int u;
    private int ub;
    private int x;
    private d xr;
    private int zb;

    @Override // com.ss.android.socialbase.appdownloader.c.ms.ab
    public int c() {
        return -1;
    }

    public ms() {
        ab();
    }

    public void ms(InputStream inputStream) {
        ms();
        if (inputStream != null) {
            this.xr = new d(inputStream, false);
        }
    }

    public void ms() {
        if (this.ah) {
            this.ah = false;
            this.xr.ms();
            this.xr = null;
            this.d = null;
            this.ka = null;
            this.c.ms();
            ab();
        }
    }

    public int xr() throws x, IOException {
        if (this.xr == null) {
            throw new x("Parser is not opened.", this, null);
        }
        try {
            x();
            return this.x;
        } catch (IOException e) {
            ms();
            throw e;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ms.ab
    public int ah() {
        return this.ny;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ms.ab
    public String d() {
        return "XML line #" + ah();
    }

    public int ka() {
        if (this.x != 2) {
            return -1;
        }
        return this.sl.length / 5;
    }

    public String ms(int i) {
        int i2 = this.sl[ka(i) + 1];
        return i2 == -1 ? "" : this.d.ms(i2);
    }

    public int xr(int i) {
        return this.sl[ka(i) + 3];
    }

    public int ah(int i) {
        return this.sl[ka(i) + 4];
    }

    public String d(int i) {
        int iKa = ka(i);
        int[] iArr = this.sl;
        if (iArr[iKa + 3] != 3) {
            return "";
        }
        return this.d.ms(iArr[iKa + 2]);
    }

    private final int ka(int i) {
        if (this.x != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.sl.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private final void ab() {
        this.x = -1;
        this.ny = -1;
        this.ch = -1;
        this.hi = -1;
        this.sl = null;
        this.zb = -1;
        this.u = -1;
        this.ub = -1;
    }

    private final void x() throws IOException {
        if (this.d == null) {
            xr.ms(this.xr, 524291);
            this.xr.ah();
            this.d = c.ms(this.xr);
            this.c.ka();
            this.ah = true;
        }
        int i = this.x;
        if (i == 1) {
            return;
        }
        ab();
        while (true) {
            if (this.ab) {
                this.ab = false;
                this.c.c();
            }
            int i2 = 3;
            if (i == 3 && this.c.d() == 1 && this.c.xr() == 0) {
                this.x = 1;
                return;
            }
            int iXr = i == 0 ? 1048834 : this.xr.xr();
            if (iXr == 524672) {
                int iXr2 = this.xr.xr();
                if (iXr2 >= 8 && iXr2 % 4 == 0) {
                    this.ka = this.xr.xr((iXr2 / 4) - 2);
                } else {
                    throw new IOException("Invalid resource ids size (" + iXr2 + ").");
                }
            } else {
                if (iXr < 1048832 || iXr > 1048836) {
                    throw new IOException("Invalid chunk type (" + iXr + ").");
                }
                if (iXr == 1048834 && i == -1) {
                    this.x = 0;
                    return;
                }
                this.xr.ah();
                int iXr3 = this.xr.xr();
                this.xr.ah();
                if (iXr != 1048832 && iXr != 1048833) {
                    this.ny = iXr3;
                    if (iXr == 1048834) {
                        this.hi = this.xr.xr();
                        this.ch = this.xr.xr();
                        this.xr.ah();
                        int iXr4 = this.xr.xr();
                        this.zb = (iXr4 >>> 16) - 1;
                        int i3 = iXr4 & SupportMenu.USER_MASK;
                        int iXr5 = this.xr.xr();
                        this.ub = (iXr5 >>> 16) - 1;
                        this.u = (65535 & iXr5) - 1;
                        this.sl = this.xr.xr(i3 * 5);
                        while (true) {
                            int[] iArr = this.sl;
                            if (i2 < iArr.length) {
                                iArr[i2] = iArr[i2] >>> 24;
                                i2 += 5;
                            } else {
                                this.c.ka();
                                this.x = 2;
                                return;
                            }
                        }
                    } else {
                        if (iXr == 1048835) {
                            this.hi = this.xr.xr();
                            this.ch = this.xr.xr();
                            this.x = 3;
                            this.ab = true;
                            return;
                        }
                        if (iXr == 1048836) {
                            this.ch = this.xr.xr();
                            this.xr.ah();
                            this.xr.ah();
                            this.x = 4;
                            return;
                        }
                    }
                } else if (iXr == 1048832) {
                    this.c.ms(this.xr.xr(), this.xr.xr());
                } else {
                    this.xr.ah();
                    this.xr.ah();
                    this.c.ah();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.c.ms.ms$ms, reason: collision with other inner class name */
    private static final class C0545ms {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int[] f4567ms = new int[32];
        private int xr;

        public final void ms() {
            this.xr = 0;
            this.ah = 0;
        }

        public final int xr() {
            int i = this.xr;
            if (i == 0) {
                return 0;
            }
            return this.f4567ms[i - 1];
        }

        public final void ms(int i, int i2) {
            if (this.ah == 0) {
                ka();
            }
            ms(2);
            int i3 = this.xr;
            int i4 = i3 - 1;
            int[] iArr = this.f4567ms;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.xr = i3 + 2;
        }

        public final boolean ah() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.xr;
            if (i3 == 0 || (i2 = (iArr = this.f4567ms)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.xr = i3 - 2;
            return true;
        }

        public final int d() {
            return this.ah;
        }

        public final void ka() {
            ms(2);
            int i = this.xr;
            int[] iArr = this.f4567ms;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.xr = i + 2;
            this.ah++;
        }

        public final void c() {
            int i = this.xr;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.f4567ms[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.xr = i - (i3 + 2);
                    this.ah--;
                }
            }
        }

        private void ms(int i) {
            int[] iArr = this.f4567ms;
            int length = iArr.length;
            int i2 = this.xr;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.f4567ms = iArr2;
            }
        }
    }
}
