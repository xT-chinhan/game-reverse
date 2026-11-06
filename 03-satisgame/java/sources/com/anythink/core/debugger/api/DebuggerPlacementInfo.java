package com.anythink.core.debugger.api;

/* JADX INFO: loaded from: classes.dex */
public class DebuggerPlacementInfo {
    private DebuggerAdSourceInfo debuggerAdSourceInfo;
    private Object onlinePlaceGroupStrategy;
    private Object onlinePlacementConfig;
    private Object onlinePlacementStrategy;

    private DebuggerPlacementInfo(Object obj) {
        this.onlinePlaceGroupStrategy = obj;
    }

    private DebuggerPlacementInfo(Object obj, Object obj2) {
        this.onlinePlacementStrategy = obj2;
        this.onlinePlacementConfig = obj;
    }

    public static DebuggerPlacementInfo create(Object obj, Object obj2) {
        return new DebuggerPlacementInfo(obj, obj2);
    }

    public static DebuggerPlacementInfo create(Object obj) {
        return new DebuggerPlacementInfo(obj);
    }

    public Object getOnlinePlacementConfig() {
        return this.onlinePlacementConfig;
    }

    public Object getOnlinePlacementStrategy() {
        return this.onlinePlacementStrategy;
    }

    public Object getOnlinePlaceGroupStrategy() {
        return this.onlinePlaceGroupStrategy;
    }

    public DebuggerAdSourceInfo getDebuggerAdSourceInfo() {
        return this.debuggerAdSourceInfo;
    }

    public void setDebuggerAdSourceInfo(DebuggerAdSourceInfo debuggerAdSourceInfo) {
        this.debuggerAdSourceInfo = debuggerAdSourceInfo;
    }
}
