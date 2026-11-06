package com.qq.e.comm.pi;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface AdData {

    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    @Deprecated
    String getDesc();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    <T> T getProperty(Class<T> cls);

    @Deprecated
    String getProperty(String str);

    @Deprecated
    String getTitle();

    int getVideoDuration();

    @Deprecated
    void setECPMLevel(String str);
}
