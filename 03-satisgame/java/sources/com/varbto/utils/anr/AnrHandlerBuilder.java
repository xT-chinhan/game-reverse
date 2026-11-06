package com.varbto.utils.anr;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.f;
import com.varbto.internal.j;
import com.varbto.internal.l;

/* JADX INFO: loaded from: classes3.dex */
public class AnrHandlerBuilder {
    public final Context a;
    public l b;
    public AnrRecorder c;
    public long d = 5000;
    public boolean e = true;
    public boolean f;

    public AnrHandlerBuilder(Context context) {
        this.a = context;
    }

    public AnrHandler build() {
        if (f.a) {
            Log.d("AnrHandlerBuilder", "Building AnrHandler, stackSwitch: " + this.f);
        }
        if (this.b == null) {
            this.b = new j();
        }
        if (this.c == null) {
            this.c = new LoggingAnrRecorder(this.a, this.f);
        }
        AnrHandler anrHandler = new AnrHandler(this.a, this.b, this.c, this.d, this.f);
        if (this.e) {
            if (f.a) {
                Log.d("AnrHandlerBuilder", "Starting ANR monitoring immediately");
            }
            anrHandler.startMonitoring();
        }
        if (f.a) {
            Log.d("AnrHandlerBuilder", "AnrHandler built successfully");
        }
        return anrHandler;
    }

    public AnrHandlerBuilder setAnrRecorder(AnrRecorder anrRecorder) {
        this.c = anrRecorder;
        return this;
    }

    public AnrHandlerBuilder setAnrStaceSwitch(boolean z) {
        this.f = z;
        return this;
    }

    public AnrHandlerBuilder setCheckIntervalMs(long j) {
        this.d = j;
        return this;
    }

    public AnrHandlerBuilder setErrorService(l lVar) {
        this.b = lVar;
        return this;
    }

    public AnrHandlerBuilder setStartImmediately(boolean z) {
        this.e = z;
        return this;
    }
}
