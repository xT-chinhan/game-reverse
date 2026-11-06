package com.tapsdk.tapad.group.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterAdEventSink {
    public static final AdapterAdEventSink NONE = new AdapterAdEventSink() { // from class: com.tapsdk.tapad.group.adapter.AdapterAdEventSink.1
    };

    default void onClick(View view) {
    }

    default void onClose() {
    }

    default void onCreativeClick(View view) {
    }

    default void onDownloadComplete(long j, long j2, String str, String str2) {
    }

    default void onDownloadFailure(long j, long j2, long j3, String str, String str2, int i, String str3) {
    }

    default void onDownloadPause(long j, long j2, long j3, String str, String str2) {
    }

    default void onDownloadProgress(long j, long j2, long j3, String str, String str2) {
    }

    default void onDownloadStart(long j, String str, String str2) {
    }

    default void onDownloadWindowConfirm() {
    }

    default void onInstalled(long j, String str, String str2) {
    }

    default void onInvalidShow(View view, String str, Object obj) {
    }

    default void onItemElseClick(View view) {
    }

    default void onRenderFailure(View view, int i, String str) {
    }

    default void onRenderSuccess(View view, float f, float f2) {
    }

    default void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
    }

    default void onShow(View view) {
    }

    default void onSkip() {
    }

    default void onTimeOver() {
    }

    default void onVideoComplete(long j) {
    }

    default void onVideoFailure(int i, String str) {
    }

    default void onVideoPause() {
    }

    default void onVideoPrepared() {
    }

    default void onVideoResume() {
    }

    default void onVideoStart() {
    }

    default void onViewAcquired(View view) {
    }
}
