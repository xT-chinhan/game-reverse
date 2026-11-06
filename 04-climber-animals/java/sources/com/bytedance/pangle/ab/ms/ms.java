package com.bytedance.pangle.ab.ms;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class ms {
    private boolean ab;
    private int c;
    private c hi;
    private int[] ny;
    private xr x;
    private boolean ch = false;
    private final ah sl = new ah();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f614ms = 0;
    int xr = 1;
    int ah = 2;
    int d = 3;
    int ka = 4;

    public ms() {
        d();
    }

    public void ms(InputStream inputStream) {
        ms();
        if (inputStream != null) {
            this.x = new xr(inputStream);
        }
    }

    public void ms() {
        if (this.ch) {
            this.ch = false;
            this.x.ms();
            this.hi = null;
            this.x = null;
            this.sl.ms();
            d();
        }
    }

    public int xr() throws IOException {
        try {
            if (this.x != null) {
                ka();
                return this.c;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            ms();
            throw e;
        }
    }

    public int ah() {
        if (this.c != 2) {
            return -1;
        }
        return this.ny.length / 5;
    }

    public String ms(int i) {
        int i2 = this.ny[ka(i) + 1];
        return i2 == -1 ? "" : this.hi.ms(i2);
    }

    public int xr(int i) {
        return this.ny[ka(i) + 3];
    }

    public int ah(int i) {
        return this.ny[ka(i) + 4];
    }

    public String d(int i) {
        int iKa = ka(i);
        int[] iArr = this.ny;
        if (iArr[iKa + 3] != 3) {
            return "";
        }
        return this.hi.ms(iArr[iKa + 2]);
    }

    private int ka(int i) {
        if (this.c != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.ny.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private void d() {
        this.ny = null;
        this.c = -1;
    }

    private void ka() throws IOException {
        if (this.hi == null) {
            this.x.xr(524291);
            this.x.ah();
            this.hi = c.ms(this.x);
            this.sl.ka();
            this.ch = true;
        }
        int i = this.c;
        if (i == this.xr) {
            return;
        }
        d();
        while (true) {
            if (this.ab) {
                this.ab = false;
                this.sl.c();
            }
            if (i == this.d && this.sl.d() == 1 && this.sl.xr() == 0) {
                this.c = this.xr;
                return;
            }
            int iXr = i == this.f614ms ? 1048834 : this.x.xr();
            if (iXr == 524672) {
                int iXr2 = this.x.xr();
                if (iXr2 < 8 || iXr2 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + iXr2 + ").");
                }
                this.x.ms((iXr2 / 4) - 2);
            } else {
                if (iXr < 1048832 || iXr > 1048836) {
                    throw new IOException("Invalid chunk type (" + iXr + ").");
                }
                if (iXr == 1048834 && i == -1) {
                    this.c = this.f614ms;
                    return;
                }
                this.x.ah();
                this.x.xr();
                this.x.ah();
                if (iXr == 1048832 || iXr == 1048833) {
                    if (iXr == 1048832) {
                        this.sl.ms(this.x.xr(), this.x.xr());
                    } else {
                        this.x.ah();
                        this.x.ah();
                        this.sl.ah();
                    }
                } else if (iXr == 1048834) {
                    this.x.xr();
                    this.x.xr();
                    this.x.ah();
                    int iXr3 = this.x.xr() & SupportMenu.USER_MASK;
                    this.x.xr();
                    this.ny = this.x.ms(iXr3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.ny;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.sl.ka();
                            this.c = this.ah;
                            return;
                        }
                    }
                } else {
                    if (iXr == 1048835) {
                        this.x.xr();
                        this.x.xr();
                        this.c = this.d;
                        this.ab = true;
                        return;
                    }
                    if (iXr == 1048836) {
                        this.x.xr();
                        this.x.ah();
                        this.x.ah();
                        this.c = this.ka;
                        return;
                    }
                }
            }
        }
    }
}
