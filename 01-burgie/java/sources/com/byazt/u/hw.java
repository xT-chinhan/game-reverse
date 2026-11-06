package com.byazt.u;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.ihe.m;
import com.byazt.ihe.vk;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1259, 13})
public class hw {
    public File c;
    public m hw;
    public Context pr;
    public File x;
    public volatile boolean hn = false;
    public final List<vk.pr> uc = new ArrayList();
    public volatile boolean fw = false;

    public hw(Context context, m mVar) {
        this.x = null;
        this.c = null;
        this.pr = context;
        this.hw = mVar;
        this.x = com.byazt.t.hn.hw(mVar.c(), mVar.fo());
        this.c = com.byazt.t.hn.hn(mVar.c(), mVar.fo());
    }

    public void pr(vk.pr prVar) {
        if (this.fw) {
            synchronized (vk.pr.class) {
                this.uc.add(prVar);
            }
            return;
        }
        this.uc.add(prVar);
        if (hw()) {
            this.hw.aj(1);
            pr(this.hw, 200);
            hn.pr(this.hw);
        } else {
            this.fw = true;
            this.hw.aj(0);
            hn();
        }
    }

    private boolean hw() {
        if (this.c.exists()) {
            return true;
        }
        return !this.hw.yb() && this.x.length() >= ((long) this.hw.fw());
    }

    private void hn() {
        k.pr prVar;
        if (com.byazt.y.hw.hn() != null) {
            prVar = com.byazt.y.hw.hn().hw();
        } else {
            prVar = new k.pr("v_preload");
        }
        prVar.pr(this.hw.z(), TimeUnit.MILLISECONDS).hw(this.hw.b(), TimeUnit.MILLISECONDS).hn(this.hw.iu(), TimeUnit.MILLISECONDS);
        k kVarPr = prVar.pr();
        g.pr prVar2 = new g.pr();
        final long length = this.x.length();
        int iFw = this.hw.fw();
        if (this.hw.yb()) {
            prVar2.pr("RANGE", "bytes=" + length + "-").pr(this.hw.ny()).pr().hw();
        } else {
            prVar2.pr("RANGE", "bytes=" + length + "-" + iFw).pr(this.hw.ny()).pr().hw();
        }
        kVarPr.pr(prVar2.hw()).pr(new com.byazt.nzn.hn() { // from class: com.byazt.u.hw.1
            @Override // com.byazt.nzn.hn
            public void onFailure(com.byazt.nzn.hw hwVar, IOException iOException) {
                hw hwVar2 = hw.this;
                hwVar2.pr(hwVar2.hw, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                hn.pr(hw.this.hw);
            }

            /* JADX WARN: Code duplicated, block: B:85:0x0240 A[Catch: all -> 0x0285, TryCatch #2 {all -> 0x0285, blocks: (B:83:0x0233, B:85:0x0240, B:86:0x0244), top: B:95:0x0233 }] */
            @Override // com.byazt.nzn.hn
            public void onResponse(com.byazt.nzn.hw hwVar, nt ntVar) throws IOException {
                int iHn;
                InputStream inputStream;
                InputStream inputStreamHn;
                yb ybVar;
                RandomAccessFile randomAccessFile;
                RandomAccessFile randomAccessFile2;
                long jPr;
                long j = length;
                yb ybVar2 = null;
                char c = 0;
                if (ntVar != null) {
                    try {
                        boolean zX = ntVar.x();
                        if (zX) {
                            yb ybVarUc = ntVar.uc();
                            try {
                                yb ybVarUc2 = ntVar.uc();
                                if (!zX || ybVarUc2 == null) {
                                    inputStreamHn = null;
                                    jPr = 0;
                                } else {
                                    try {
                                        jPr = length + ybVarUc2.pr();
                                        inputStreamHn = ybVarUc2.hn();
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream = null;
                                        randomAccessFile2 = null;
                                    }
                                }
                                if (inputStreamHn == null) {
                                    try {
                                        hw hwVar2 = hw.this;
                                        hwVar2.pr(hwVar2.hw, ntVar.hn(), ntVar.c());
                                        hw.this.pr((Closeable) null);
                                        hw.this.pr(inputStreamHn);
                                        hw.this.pr(ybVarUc2);
                                        hw.this.pr(ntVar);
                                        Object[] objArr = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                                        hn.pr(hw.this.hw);
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStreamHn;
                                        randomAccessFile2 = null;
                                    }
                                } else {
                                    try {
                                        randomAccessFile2 = new RandomAccessFile(hw.this.x, "rw");
                                        try {
                                            byte[] bArr = new byte[8192];
                                            int i = 0;
                                            long j2 = 0;
                                            while (true) {
                                                int i2 = inputStreamHn.read(bArr, i, 8192 - i);
                                                if (i2 == -1) {
                                                    ybVar = ybVarUc2;
                                                    if (hw.this.hw.yb() && jPr == hw.this.x.length()) {
                                                        hw.this.c();
                                                    }
                                                    hw hwVar3 = hw.this;
                                                    hwVar3.pr(hwVar3.hw, ntVar.hn());
                                                    randomAccessFile = randomAccessFile2;
                                                    break;
                                                }
                                                if (hw.this.hn) {
                                                    try {
                                                        hw hwVar4 = hw.this;
                                                        hwVar4.hw(hwVar4.hw, ntVar.hn());
                                                        hw.this.pr(randomAccessFile2);
                                                        hw.this.pr(inputStreamHn);
                                                        hw.this.pr(ybVarUc2);
                                                        hw.this.pr(ntVar);
                                                        Object[] objArr2 = new Object[4];
                                                        objArr2[c] = "Pre finally ";
                                                        objArr2[1] = hw.this.hw.ny();
                                                        objArr2[2] = " Preload size=";
                                                        objArr2[3] = Integer.valueOf(hw.this.hw.fw());
                                                        hn.pr(hw.this.hw);
                                                        return;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        inputStream = inputStreamHn;
                                                    }
                                                } else {
                                                    i += i2;
                                                    ybVar = ybVarUc2;
                                                    j2 += (long) i2;
                                                    try {
                                                        if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == jPr - length) {
                                                            com.byazt.t.hn.pr(randomAccessFile2, bArr, j, i);
                                                            j += (long) i;
                                                            i = 0;
                                                        }
                                                        ybVarUc2 = ybVar;
                                                        c = 0;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                    }
                                                }
                                                th = th4;
                                                inputStream = inputStreamHn;
                                                ybVar2 = ybVar;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            ybVar = ybVarUc2;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        inputStream = inputStreamHn;
                                        ybVar2 = ybVarUc2;
                                        iHn = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                        randomAccessFile2 = null;
                                        hw.this.x();
                                        hw hwVar5 = hw.this;
                                        m mVar = hwVar5.hw;
                                        if (ntVar != null) {
                                            iHn = ntVar.hn();
                                        }
                                        hwVar5.pr(mVar, iHn, th.getMessage());
                                        hw.this.pr(randomAccessFile2);
                                        hw.this.pr(inputStream);
                                        hw.this.pr(ybVar2);
                                        hw.this.pr(ntVar);
                                        Object[] objArr3 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                                    }
                                }
                                ybVar2 = ybVarUc2;
                            } catch (Throwable th7) {
                                th = th7;
                                ybVar2 = ybVarUc;
                                inputStream = null;
                            }
                        } else {
                            try {
                                hw hwVar6 = hw.this;
                                hwVar6.pr(hwVar6.hw, ntVar.hn(), ntVar.c());
                                hw.this.pr((Closeable) null);
                                hw.this.pr((Closeable) null);
                                hw.this.pr((Closeable) null);
                                hw.this.pr(ntVar);
                                Object[] objArr4 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                                hn.pr(hw.this.hw);
                                return;
                            } catch (Throwable th8) {
                                th = th8;
                                inputStream = null;
                                randomAccessFile2 = null;
                            }
                        }
                        iHn = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                    } catch (Throwable th9) {
                        th = th9;
                        inputStream = null;
                        iHn = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                        randomAccessFile2 = null;
                        ybVar2 = null;
                    }
                    try {
                        hw.this.x();
                        hw hwVar7 = hw.this;
                        m mVar2 = hwVar7.hw;
                        if (ntVar != null) {
                            iHn = ntVar.hn();
                        }
                        hwVar7.pr(mVar2, iHn, th.getMessage());
                        hw.this.pr(randomAccessFile2);
                        hw.this.pr(inputStream);
                        hw.this.pr(ybVar2);
                        hw.this.pr(ntVar);
                        Object[] objArr5 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                    } finally {
                        hw.this.pr(randomAccessFile2);
                        hw.this.pr(inputStream);
                        hw.this.pr(ybVar2);
                        hw.this.pr(ntVar);
                        Object[] objArr6 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                        hn.pr(hw.this.hw);
                    }
                }
                try {
                    hw hwVar8 = hw.this;
                    m mVar3 = hwVar8.hw;
                    iHn = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                    try {
                        hwVar8.pr(mVar3, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, "Network link failed.");
                        inputStreamHn = null;
                        ybVar = null;
                        randomAccessFile = null;
                    } catch (Throwable th10) {
                        th = th10;
                        inputStream = null;
                        randomAccessFile2 = null;
                        ybVar2 = null;
                        hw.this.x();
                        hw hwVar9 = hw.this;
                        m mVar4 = hwVar9.hw;
                        if (ntVar != null) {
                            iHn = ntVar.hn();
                        }
                        hwVar9.pr(mVar4, iHn, th.getMessage());
                        hw.this.pr(randomAccessFile2);
                        hw.this.pr(inputStream);
                        hw.this.pr(ybVar2);
                        hw.this.pr(ntVar);
                        Object[] objArr7 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
                    }
                } catch (Throwable th11) {
                    th = th11;
                    iHn = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                }
                hw.this.pr(randomAccessFile);
                hw.this.pr(inputStreamHn);
                hw.this.pr(ybVar);
                hw.this.pr(ntVar);
                Object[] objArr8 = {"Pre finally ", hw.this.hw.ny(), " Preload size=", Integer.valueOf(hw.this.hw.fw())};
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public m pr() {
        return this.hw;
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(m mVar, int i) {
        synchronized (vk.pr.class) {
            for (vk.pr prVar : this.uc) {
                if (prVar != null) {
                    prVar.hw(mVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(m mVar, int i, String str) {
        synchronized (vk.pr.class) {
            for (vk.pr prVar : this.uc) {
                if (prVar != null) {
                    prVar.pr(mVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(m mVar, int i) {
        synchronized (vk.pr.class) {
            for (vk.pr prVar : this.uc) {
                if (prVar != null) {
                    prVar.pr(mVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            this.c.delete();
            this.x.delete();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (!this.x.renameTo(this.c)) {
                throw new IOException("Error renaming file " + this.x + " to " + this.c + " for completion!");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
