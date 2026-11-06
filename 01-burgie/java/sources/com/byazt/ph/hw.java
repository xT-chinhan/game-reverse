package com.byazt.ph;

import android.support.v4.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 13})
public class hw {
    public final byte[] aj;
    public boolean g;
    public int ho;
    public int[] k;
    public int[] nt;
    public fw vk;
    public int yb;
    public final zo zo;
    public HashMap<Integer, Integer> pr = new HashMap<>();
    public boolean hw = false;
    public boolean w = false;
    public final pr m = new pr();
    public int hn = 0;
    public int x = 1;
    public int c = 2;
    public int uc = 3;
    public int fw = 4;

    public hw(byte[] bArr, zo zoVar) {
        this.zo = zoVar;
        this.aj = bArr;
        x();
    }

    public void pr(InputStream inputStream) {
        pr();
        if (inputStream != null) {
            this.vk = new fw(new aj(new c(inputStream)));
        }
    }

    public void pr() {
        if (!this.w) {
            return;
        }
        this.w = false;
        this.vk = null;
        this.k = null;
        this.m.pr();
        x();
    }

    public int hw() throws IOException {
        if (this.vk == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            c();
            return this.ho;
        } catch (IOException e) {
            pr();
            throw e;
        }
    }

    public int hn() throws IOException {
        return hw();
    }

    public void hw(InputStream inputStream) {
        pr(inputStream);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static final class pr {
        public int hn;
        public int hw;
        public int[] pr = new int[32];

        public void pr() {
            this.hw = 0;
            this.hn = 0;
        }

        public int hw() {
            int i = this.hw;
            if (i == 0) {
                return 0;
            }
            return this.pr[i - 1];
        }

        public void pr(int i, int i2) {
            if (this.hn == 0) {
                c();
            }
            pr(2);
            int i3 = this.hw;
            int i4 = i3 - 1;
            int[] iArr = this.pr;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.hw = i3 + 2;
        }

        public boolean hn() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.hw;
            if (i3 == 0 || (i2 = (iArr = this.pr)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.hw = i3 - 2;
            return true;
        }

        public int x() {
            return this.hn;
        }

        public void c() {
            pr(2);
            int i = this.hw;
            int[] iArr = this.pr;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hw = i + 2;
            this.hn++;
        }

        public void uc() {
            int i = this.hw;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.pr[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.hw = i - (i3 + 2);
            this.hn--;
        }

        private void pr(int i) {
            int[] iArr = this.pr;
            int length = iArr.length;
            int i2 = this.hw;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.pr = iArr2;
        }
    }

    private void x() {
        this.ho = -1;
        this.nt = null;
        this.yb = -1;
    }

    private void c() throws IOException {
        int i;
        int[] iArr;
        if (!this.w) {
            this.vk.pr(524291, 524289);
            this.vk.pr();
            k.pr(this.vk);
            this.m.c();
            this.w = true;
        }
        int i2 = this.ho;
        if (i2 == this.x) {
            return;
        }
        x();
        while (true) {
            int i3 = 0;
            if (this.g) {
                this.g = false;
                this.m.uc();
            }
            if (i2 == this.uc && this.m.x() == 1 && this.m.hw() == 0) {
                this.ho = this.x;
                return;
            }
            if (i2 == this.hn) {
                i = 1048834;
            } else {
                i = this.vk.readInt();
            }
            if (i == 524672) {
                this.pr.clear();
                int i4 = this.vk.readInt();
                if (i4 < 8 || i4 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + i4 + ").");
                }
                int iPr = w.pr(this.vk);
                this.k = this.vk.pr((i4 / 4) - 2);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int[] iArr2 = this.k;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    int iPr2 = w.pr(this.aj, iArr2[i3], (i3 * 4) + iPr, this.zo);
                    if (iPr2 >= 2130706432) {
                        this.pr.put(Integer.valueOf(i3), Integer.valueOf(iPr2));
                        arrayList.add(Integer.valueOf(iPr2));
                    }
                    i3++;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.hw = true;
                }
            } else {
                if (i < 1048832 || i > 1048836) {
                    throw new IOException("Invalid chunk type (" + i + ").");
                }
                if (i == 1048834 && i2 == -1) {
                    this.ho = this.hn;
                    return;
                }
                this.vk.pr();
                this.vk.readInt();
                this.vk.pr();
                if (i == 1048832 || i == 1048833) {
                    if (i == 1048832) {
                        this.m.pr(this.vk.readInt(), this.vk.readInt());
                    } else {
                        this.vk.pr();
                        this.vk.pr();
                        this.m.hn();
                    }
                } else {
                    if (i == 1048834) {
                        this.vk.readInt();
                        this.vk.readInt();
                        this.vk.pr();
                        int i5 = this.vk.readInt() & SupportMenu.USER_MASK;
                        int i6 = this.vk.readInt();
                        this.yb = i6;
                        this.yb = (65535 & i6) - 1;
                        int iPr3 = w.pr(this.vk);
                        int i7 = i5 * 5;
                        this.nt = this.vk.pr(i7);
                        int i8 = 3;
                        while (true) {
                            iArr = this.nt;
                            if (i8 >= iArr.length) {
                                break;
                            }
                            iArr[i8] = iArr[i8] >>> 24;
                            i8 += 5;
                        }
                        if (iArr.length != i7) {
                            throw new RuntimeException();
                        }
                        boolean z = false;
                        while (i3 < i5) {
                            int i9 = i3 * 5;
                            if (this.pr.containsKey(Integer.valueOf(this.nt[i9 + 1]))) {
                                z = true;
                            }
                            int[] iArr3 = this.nt;
                            int i10 = iArr3[i9 + 3];
                            if (i10 == 1 || i10 == 2) {
                                int i11 = i9 + 4;
                                w.pr(this.aj, iArr3[i11], (i11 * 4) + iPr3, this.zo);
                            }
                            i3++;
                        }
                        if (z && this.hw) {
                            w.pr(iPr3, this.aj, this.nt, i5, this.pr);
                        }
                        this.m.c();
                        this.ho = this.c;
                        return;
                    }
                    if (i == 1048835) {
                        this.vk.readInt();
                        this.vk.readInt();
                        this.ho = this.uc;
                        this.g = true;
                        return;
                    }
                    if (i == 1048836) {
                        this.vk.readInt();
                        this.vk.pr();
                        this.vk.pr();
                        this.ho = this.fw;
                        return;
                    }
                }
            }
        }
    }
}
