package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterLocation {
    private final double accuracy;
    private final double latitude;
    private final double longitude;

    public AdapterLocation(double d, double d2, double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
