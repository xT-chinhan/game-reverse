package com.byazt.ev;

import androidx.core.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 26})
public class qg {
    public int[] cy;
    public int[] d;
    public final fs fs;
    public int hd;
    public int k;
    public final byte[] rv;
    public boolean sz;
    public x tj;
    public HashMap<Integer, Integer> n = new HashMap<>();
    public boolean qg = false;
    public boolean cp = false;
    public final n oa = new n();
    public int s = 0;
    public int q = 1;
    public int l = 2;
    public int w = 3;
    public int x = 4;

    public qg(byte[] bArr, fs fsVar) {
        this.fs = fsVar;
        this.rv = bArr;
        q();
    }

    public void n(InputStream inputStream) {
        n();
        if (inputStream != null) {
            this.tj = new x(new rv(new l(inputStream)));
        }
    }

    public void n() {
        if (this.cp) {
            this.cp = false;
            this.tj = null;
            this.d = null;
            this.oa.n();
            q();
        }
    }

    public int qg() throws IOException {
        if (this.tj == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            l();
            return this.k;
        } catch (IOException e) {
            n();
            throw e;
        }
    }

    public int s() throws IOException {
        return qg();
    }

    public void qg(InputStream inputStream) {
        n(inputStream);
    }

    @com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 48})
    private static final class n {
        public int[] n = new int[32];
        public int qg;
        public int s;

        public void n() {
            this.qg = 0;
            this.s = 0;
        }

        public int qg() {
            int i = this.qg;
            if (i == 0) {
                return 0;
            }
            return this.n[i - 1];
        }

        public void n(int i, int i2) {
            if (this.s == 0) {
                l();
            }
            n(2);
            int i3 = this.qg;
            int i4 = i3 - 1;
            int[] iArr = this.n;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.qg = i3 + 2;
        }

        public boolean s() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.qg;
            if (i3 == 0 || (i2 = (iArr = this.n)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.qg = i3 - 2;
            return true;
        }

        public int q() {
            return this.s;
        }

        public void l() {
            n(2);
            int i = this.qg;
            int[] iArr = this.n;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.qg = i + 2;
            this.s++;
        }

        public void w() {
            int i = this.qg;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.n[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.qg = i - (i3 + 2);
            this.s--;
        }

        private void n(int i) {
            int[] iArr = this.n;
            int length = iArr.length;
            int i2 = this.qg;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.n = iArr2;
        }
    }

    private void q() {
        this.k = -1;
        this.cy = null;
        this.hd = -1;
    }

    private void l() throws IOException {
        int[] iArr;
        if (!this.cp) {
            this.tj.n(524291, 524289);
            this.tj.n();
            d.n(this.tj);
            this.oa.l();
            this.cp = true;
        }
        int i = this.k;
        if (i == this.q) {
            return;
        }
        q();
        while (true) {
            int i2 = 0;
            if (this.sz) {
                this.sz = false;
                this.oa.w();
            }
            if (i == this.w && this.oa.q() == 1 && this.oa.qg() == 0) {
                this.k = this.q;
                return;
            }
            int i3 = i == this.s ? 1048834 : this.tj.readInt();
            if (i3 == 524672) {
                this.n.clear();
                int i4 = this.tj.readInt();
                if (i4 < 8 || i4 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + i4 + ").");
                }
                int iN = cp.n(this.tj);
                this.d = this.tj.n((i4 / 4) - 2);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int[] iArr2 = this.d;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    int iN2 = cp.n(this.rv, iArr2[i2], (i2 * 4) + iN, this.fs);
                    if (iN2 >= 2130706432) {
                        this.n.put(Integer.valueOf(i2), Integer.valueOf(iN2));
                        arrayList.add(Integer.valueOf(iN2));
                    }
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.qg = true;
                }
            } else {
                if (i3 < 1048832 || i3 > 1048836) {
                    throw new IOException("Invalid chunk type (" + i3 + ").");
                }
                if (i3 == 1048834 && i == -1) {
                    this.k = this.s;
                    return;
                }
                this.tj.n();
                this.tj.readInt();
                this.tj.n();
                if (i3 == 1048832 || i3 == 1048833) {
                    if (i3 == 1048832) {
                        this.oa.n(this.tj.readInt(), this.tj.readInt());
                    } else {
                        this.tj.n();
                        this.tj.n();
                        this.oa.s();
                    }
                } else {
                    if (i3 == 1048834) {
                        this.tj.readInt();
                        this.tj.readInt();
                        this.tj.n();
                        int i5 = this.tj.readInt() & SupportMenu.USER_MASK;
                        this.hd = (65535 & this.tj.readInt()) - 1;
                        int iN3 = cp.n(this.tj);
                        int i6 = i5 * 5;
                        this.cy = this.tj.n(i6);
                        int i7 = 3;
                        while (true) {
                            iArr = this.cy;
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
                            if (this.n.containsKey(Integer.valueOf(this.cy[i8 + 1]))) {
                                z = true;
                            }
                            int[] iArr3 = this.cy;
                            int i9 = iArr3[i8 + 3];
                            if (i9 == 1 || i9 == 2) {
                                int i10 = i8 + 4;
                                cp.n(this.rv, iArr3[i10], (i10 * 4) + iN3, this.fs);
                            }
                            i2++;
                        }
                        if (z && this.qg) {
                            cp.n(iN3, this.rv, this.cy, i5, this.n);
                        }
                        this.oa.l();
                        this.k = this.l;
                        return;
                    }
                    if (i3 == 1048835) {
                        this.tj.readInt();
                        this.tj.readInt();
                        this.k = this.w;
                        this.sz = true;
                        return;
                    }
                    if (i3 == 1048836) {
                        this.tj.readInt();
                        this.tj.n();
                        this.tj.n();
                        this.k = this.x;
                        return;
                    }
                }
            }
        }
    }
}
