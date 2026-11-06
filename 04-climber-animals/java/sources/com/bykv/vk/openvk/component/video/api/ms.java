package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.ah.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ms {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.api.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0179ms {
        void ah(ms msVar);

        void ms(ms msVar);

        void ms(ms msVar, int i);

        void ms(ms msVar, int i, int i2);

        void ms(ms msVar, int i, int i2, int i3);

        void ms(ms msVar, long j);

        void ms(ms msVar, long j, long j2);

        void ms(ms msVar, com.bykv.vk.openvk.component.video.api.ah.xr xrVar);

        void ms(ms msVar, JSONObject jSONObject, String str);

        void ms(ms msVar, boolean z);

        void xr(ms msVar);

        void xr(ms msVar, int i);
    }

    SurfaceHolder ab();

    void ah();

    void ah(boolean z);

    long ao();

    boolean c();

    boolean ch();

    void d();

    int h();

    int hi();

    void ka();

    void ms();

    void ms(float f);

    void ms(int i);

    void ms(long j);

    void ms(SurfaceTexture surfaceTexture);

    void ms(SurfaceHolder surfaceHolder);

    void ms(d dVar);

    void ms(InterfaceC0179ms interfaceC0179ms);

    void ms(boolean z);

    void ms(boolean z, long j, boolean z2);

    boolean ny();

    long qv();

    int sl();

    boolean u();

    boolean ub();

    SurfaceTexture x();

    void xr();

    void xr(int i);

    void xr(boolean z);

    long y();

    boolean zb();
}
