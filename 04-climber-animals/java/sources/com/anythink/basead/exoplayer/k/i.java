package com.anythink.basead.exoplayer.k;

import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i implements com.anythink.basead.exoplayer.a.b {
    private static final String a = "EventLogger";
    private static final int b = 3;
    private static final NumberFormat c;
    private final com.anythink.basead.exoplayer.i.e d;
    private final com.anythink.basead.exoplayer.ae.b e = new com.anythink.basead.exoplayer.ae.b();
    private final com.anythink.basead.exoplayer.ae.a f = new com.anythink.basead.exoplayer.ae.a();
    private final long g = SystemClock.elapsedRealtime();

    private static String a(int i) {
        if (i == 1) {
            return "IDLE";
        }
        if (i == 2) {
            return "BUFFERING";
        }
        if (i != 3) {
            return i != 4 ? "?" : "ENDED";
        }
        return "READY";
    }

    private static String a(int i, int i2) {
        if (i < 2) {
            return "N/A";
        }
        if (i2 == 0) {
            return "NO";
        }
        if (i2 != 8) {
            return i2 != 16 ? "?" : "YES";
        }
        return "YES_NOT_SEAMLESS";
    }

    private static String a(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private static String b(int i) {
        if (i == 0) {
            return "NO";
        }
        if (i == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i != 3) {
            return i != 4 ? "?" : "YES";
        }
        return "NO_EXCEEDS_CAPABILITIES";
    }

    private static String c(int i) {
        if (i == 0) {
            return "OFF";
        }
        if (i != 1) {
            return i != 2 ? "?" : "ALL";
        }
        return "ONE";
    }

    private static String d(int i) {
        if (i == 0) {
            return "PERIOD_TRANSITION";
        }
        if (i == 1) {
            return "SEEK";
        }
        if (i == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (i != 3) {
            return i != 4 ? "?" : "INTERNAL";
        }
        return "AD_INSERTION";
    }

    private static String e(int i) {
        if (i == 0) {
            return "PREPARED";
        }
        if (i != 1) {
            return i != 2 ? "?" : "DYNAMIC";
        }
        return "RESET";
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a() {
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b() {
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void c() {
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void d() {
    }

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        c = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    private i(com.anythink.basead.exoplayer.i.e eVar) {
        this.d = eVar;
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b(com.anythink.basead.exoplayer.a.b.a aVar, boolean z) {
        a(aVar, com.anythink.core.express.b.a.e, Boolean.toString(z));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, boolean z, int i) {
        String str;
        StringBuilder sbAppend = new StringBuilder().append(z).append(", ");
        if (i == 1) {
            str = "IDLE";
        } else if (i == 2) {
            str = "BUFFERING";
        } else if (i != 3) {
            str = i != 4 ? "?" : "ENDED";
        } else {
            str = "READY";
        }
        a(aVar, "state", sbAppend.append(str).toString());
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void c(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        String str;
        if (i == 0) {
            str = "OFF";
        } else if (i != 1) {
            str = i != 2 ? "?" : "ALL";
        } else {
            str = "ONE";
        }
        a(aVar, "repeatMode", str);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, boolean z) {
        a(aVar, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        String str;
        if (i == 0) {
            str = "PERIOD_TRANSITION";
        } else if (i == 1) {
            str = "SEEK";
        } else if (i == 2) {
            str = "SEEK_ADJUSTMENT";
        } else if (i != 3) {
            str = i != 4 ? "?" : "INTERNAL";
        } else {
            str = "AD_INSERTION";
        }
        a(aVar, "positionDiscontinuity", str);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "seekStarted");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.v vVar) {
        a(aVar, "playbackParameters", af.a("speed=%.2f, pitch=%.2f, skipSilence=%s", Float.valueOf(vVar.b), Float.valueOf(vVar.c), Boolean.valueOf(vVar.d)));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        String str;
        int iC = aVar.b.c();
        int iB = aVar.b.b();
        StringBuilder sbAppend = new StringBuilder("timelineChanged [").append(i(aVar)).append(", periodCount=").append(iC).append(", windowCount=").append(iB).append(", reason=");
        if (i == 0) {
            str = "PREPARED";
        } else if (i != 1) {
            str = i != 2 ? "?" : "DYNAMIC";
        } else {
            str = "RESET";
        }
        a(sbAppend.append(str).toString());
        for (int i2 = 0; i2 < Math.min(iC, 3); i2++) {
            aVar.b.a(i2, this.f, false);
            a("  period [" + a(com.anythink.basead.exoplayer.b.a(this.f.d)) + "]");
        }
        if (iC > 3) {
            a("  ...");
        }
        for (int i3 = 0; i3 < Math.min(iB, 3); i3++) {
            aVar.b.a(i3, this.e, false);
            a("  window [" + a(com.anythink.basead.exoplayer.b.a(this.e.i)) + ", " + this.e.d + ", " + this.e.e + "]");
        }
        if (iB > 3) {
            a("  ...");
        }
        a("]");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.i.g gVar) {
        int i;
        String str;
        com.anythink.basead.exoplayer.i.e eVar = this.d;
        com.anythink.basead.exoplayer.i.e.a aVarA = eVar != null ? eVar.a() : null;
        if (aVarA == null) {
            a(aVar, "tracksChanged", "[]");
            return;
        }
        a("tracksChanged [" + i(aVar) + ", ");
        int iA = aVarA.a();
        int i2 = 0;
        while (true) {
            String str2 = " [";
            if (i2 >= iA) {
                break;
            }
            com.anythink.basead.exoplayer.h.af afVarB = aVarA.b(i2);
            com.anythink.basead.exoplayer.i.f fVarA = gVar.a(i2);
            if (afVarB.b > 0) {
                a("  Renderer:" + i2 + " [");
                int i3 = 0;
                while (i3 < afVarB.b) {
                    com.anythink.basead.exoplayer.h.ae aeVarA = afVarB.a(i3);
                    int i4 = iA;
                    int i5 = aeVarA.a;
                    com.anythink.basead.exoplayer.h.af afVar = afVarB;
                    int iA2 = aVarA.a(i2, i3);
                    if (i5 < 2) {
                        str = "N/A";
                    } else if (iA2 == 0) {
                        str = "NO";
                    } else if (iA2 != 8) {
                        str = iA2 != 16 ? "?" : "YES";
                    } else {
                        str = "YES_NOT_SEAMLESS";
                    }
                    a("    Group:" + i3 + ", adaptive_supported=" + str + str2);
                    int i6 = 0;
                    while (i6 < aeVarA.a) {
                        a("      " + a((fVarA == null || fVarA.f() != aeVarA || fVarA.c(i6) == -1) ? false : true) + " Track:" + i6 + ", " + com.anythink.basead.exoplayer.m.c(aeVarA.a(i6)) + ", supported=" + b(aVarA.a(i2, i3, i6)));
                        i6++;
                        str2 = str2;
                    }
                    a("    ]");
                    i3++;
                    iA = i4;
                    afVarB = afVar;
                }
                i = iA;
                if (fVarA != null) {
                    for (int i7 = 0; i7 < fVarA.g(); i7++) {
                        com.anythink.basead.exoplayer.g.a aVar2 = fVarA.a(i7).f;
                        if (aVar2 != null) {
                            a("    Metadata [");
                            a(aVar2, "      ");
                            a("    ]");
                            break;
                        }
                    }
                }
                a("  ]");
            } else {
                i = iA;
            }
            i2++;
            iA = i;
        }
        String str3 = " [";
        com.anythink.basead.exoplayer.h.af afVarB2 = aVarA.b();
        if (afVarB2.b > 0) {
            a("  Renderer:None [");
            int i8 = 0;
            while (i8 < afVarB2.b) {
                String str4 = str3;
                a("    Group:" + i8 + str4);
                com.anythink.basead.exoplayer.h.ae aeVarA2 = afVarB2.a(i8);
                for (int i9 = 0; i9 < aeVarA2.a; i9++) {
                    a("      " + a(false) + " Track:" + i9 + ", " + com.anythink.basead.exoplayer.m.c(aeVarA2.a(i9)) + ", supported=" + b(0));
                }
                a("    ]");
                i8++;
                str3 = str4;
            }
            a("  ]");
        }
        a("]");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "seekProcessed");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.g.a aVar2) {
        a("metadata [" + i(aVar) + ", ");
        a(aVar2, "  ");
        a("]");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void d(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        a(aVar, "decoderEnabled", f(i));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void f(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        a(aVar, "audioSessionId", Integer.toString(i));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, int i, String str) {
        a(aVar, "decoderInitialized", f(i) + ", " + str);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, int i, com.anythink.basead.exoplayer.m mVar) {
        a(aVar, "decoderInputFormatChanged", f(i) + ", " + com.anythink.basead.exoplayer.m.c(mVar));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void e(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        a(aVar, "decoderDisabled", f(i));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, int i, long j, long j2) {
        a(aVar, "audioTrackUnderrun", i + ", " + j + ", " + j2 + "]", (Throwable) null);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void g(com.anythink.basead.exoplayer.a.b.a aVar, int i) {
        a(aVar, "droppedFrames", Integer.toString(i));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b(com.anythink.basead.exoplayer.a.b.a aVar, int i, int i2) {
        a(aVar, "videoSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, Surface surface) {
        a(aVar, "renderedFirstFrame", surface.toString());
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void c(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodCreated");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void d(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodReleased");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, IOException iOException) {
        a(aVar, "loadError", (Exception) iOException);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void e(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodReadingStarted");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, int i, int i2) {
        a(aVar, "viewportSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, NetworkInfo networkInfo) {
        a(aVar, "networkTypeChanged", networkInfo == null ? "none" : networkInfo.toString());
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void b(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.h.t.c cVar) {
        a(aVar, "upstreamDiscarded", com.anythink.basead.exoplayer.m.c(cVar.c));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.h.t.c cVar) {
        a(aVar, "downstreamFormatChanged", com.anythink.basead.exoplayer.m.c(cVar.c));
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, Exception exc) {
        a(aVar, "drmSessionManagerError", exc);
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void g(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysRestored");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void h(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysRemoved");
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void f(com.anythink.basead.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysLoaded");
    }

    private static void a(String str) {
        Log.d(a, str);
    }

    private static void a(String str, Throwable th) {
        Log.e(a, str, th);
    }

    private void a(com.anythink.basead.exoplayer.a.b.a aVar, String str) {
        a(b(aVar, str));
    }

    private void a(com.anythink.basead.exoplayer.a.b.a aVar, String str, String str2) {
        a(b(aVar, str, str2));
    }

    private void a(com.anythink.basead.exoplayer.a.b.a aVar, String str, Throwable th) {
        a(b(aVar, str), th);
    }

    private void a(com.anythink.basead.exoplayer.a.b.a aVar, String str, String str2, Throwable th) {
        a(b(aVar, str, str2), th);
    }

    private void a(com.anythink.basead.exoplayer.a.b.a aVar, String str, Exception exc) {
        a(aVar, "internalError", str, exc);
    }

    private static void a(com.anythink.basead.exoplayer.g.a aVar, String str) {
        for (int i = 0; i < aVar.a(); i++) {
            a(str + aVar.a(i));
        }
    }

    private String b(com.anythink.basead.exoplayer.a.b.a aVar, String str) {
        return str + " [" + i(aVar) + "]";
    }

    private String b(com.anythink.basead.exoplayer.a.b.a aVar, String str, String str2) {
        return str + " [" + i(aVar) + ", " + str2 + "]";
    }

    private String i(com.anythink.basead.exoplayer.a.b.a aVar) {
        String str = "window=" + aVar.c;
        if (aVar.d != null) {
            str = str + ", period=" + aVar.d.a;
            if (aVar.d.a()) {
                str = (str + ", adGroup=" + aVar.d.b) + ", ad=" + aVar.d.c;
            }
        }
        return a(aVar.a - this.g) + ", " + a(aVar.f) + ", " + str;
    }

    private static String a(long j) {
        return j == -9223372036854775807L ? "?" : c.format(j / 1000.0f);
    }

    private static String a(com.anythink.basead.exoplayer.i.f fVar, com.anythink.basead.exoplayer.h.ae aeVar, int i) {
        return a((fVar == null || fVar.f() != aeVar || fVar.c(i) == -1) ? false : true);
    }

    private static String f(int i) {
        if (i == 0) {
            return com.anythink.core.express.b.a.f;
        }
        if (i == 1) {
            return "audio";
        }
        if (i == 2) {
            return "video";
        }
        if (i == 3) {
            return "text";
        }
        if (i == 4) {
            return "metadata";
        }
        if (i != 5) {
            return i >= 10000 ? "custom (" + i + ")" : "?";
        }
        return "none";
    }

    @Override // com.anythink.basead.exoplayer.a.b
    public final void a(com.anythink.basead.exoplayer.a.b.a aVar, com.anythink.basead.exoplayer.g gVar) {
        a(b(aVar, "playerFailed"), gVar);
    }
}
