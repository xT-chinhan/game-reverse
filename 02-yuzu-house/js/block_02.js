(function() {
  "use strict";
  const root = document.documentElement, loader = document.getElementById("startupLoader"), bar = document.getElementById("startupProgress"), percent = document.getElementById("startupPercent"), text = document.getElementById("startupText");
  root.setAttribute("data-startup-loading", "");
  let value = 0, ready = false, dom = false, fonts = false, ending = false, failed = false, timer = 0;
  const en = (() => {
    var _a;
    try {
      return ((_a = JSON.parse(localStorage.getItem("yuzu-app-settings-v1"))) == null ? void 0 : _a.language) === "en";
    } catch (e) {
      return false;
    }
  })();
  if (en) {
    loader.setAttribute("aria-label", "Loading");
    loader.querySelector("h1").textContent = "Yuzu House";
    bar.setAttribute("aria-label", "Loading progress");
    text.textContent = "Getting ready…";
    document.getElementById("startupRetry").textContent = "Reload";
  }
  function update(n) {
    value = Math.max(value, Math.min(100, Math.round(n)));
    bar.setAttribute("aria-valuenow", value);
    bar.querySelectorAll(".startup-symbol").forEach((icon, i) => icon.style.setProperty("--fill", Math.max(0, Math.min(100, value * 3 - i * 100)) + "%"));
    percent.textContent = value + "%";
  }
  function finish() {
    if (ending || failed || !ready || !dom || !fonts || !window.CottonAppSettings) return;
    ending = true;
    clearInterval(timer);
    window.removeEventListener("message", receive);
    update(100);
    setTimeout(() => {
      root.removeAttribute("data-startup-loading");
      loader.classList.add("leaving");
      document.removeEventListener("keydown", hold, true);
      setTimeout(() => {
        loader.hidden = true;
      }, 180);
    }, 180);
  }
  function receive(e) {
    var _a;
    const frame = document.getElementById("cottonFrame");
    if (e.source !== (frame == null ? void 0 : frame.contentWindow) || ((_a = e.data) == null ? void 0 : _a.channel) !== "cotton-theatre") return;
    const p = e.data.payload || {};
    if (e.data.type === "load-progress" && p.total > 0) update(p.loaded / p.total * 94);
    if (e.data.type === "ready") {
      ready = true;
      update(96);
      finish();
    }
    if (e.data.type === "load-error") showError(p.message);
  }
  function engineInfo() {
    var _a;
    try {
      if ((_a = window.YuzuAndroid) == null ? void 0 : _a.runtimeInfo) return String(YuzuAndroid.runtimeInfo());
    } catch (e) {
    }
    const match = /Chrome\/(\d+)/.exec(navigator.userAgent);
    return match ? "Chromium " + match[1] : "";
  }
  function showError(message) {
    if (ending) return;
    failed = true;
    clearInterval(timer);
    text.textContent = (en ? "Could not finish loading" : "加载未能完成") + (message ? "：" + String(message).slice(0, 240) : "") + (engineInfo() ? " · " + engineInfo() : "");
    document.getElementById("startupRetry").hidden = false;
  }
  function hold(e) {
    if (!loader.contains(e.target)) e.preventDefault();
  }
  document.addEventListener("keydown", hold, true);
  window.addEventListener("message", receive);
  document.getElementById("startupRetry").onclick = () => location.reload();
  document.addEventListener("DOMContentLoaded", () => {
    var _a;
    dom = true;
    Promise.race([((_a = document.fonts) == null ? void 0 : _a.ready) || Promise.resolve(), new Promise((r) => setTimeout(r, 5e3))]).then(() => {
      fonts = true;
      finish();
    });
    finish();
  }, { once: true });
  timer = setInterval(finish, 80);
  setTimeout(() => {
    if (!ending && !failed) {
      text.textContent = en ? "Still loading. You can retry if it stays here." : "正在整理角色，长时间无变化可重新加载";
      if (engineInfo()) text.textContent += " · " + engineInfo();
      document.getElementById("startupRetry").hidden = false;
    }
  }, 25e3);
  window.addEventListener("error", (e) => showError(e.message));
  window.addEventListener("unhandledrejection", (e) => {
    var _a;
    return showError(((_a = e.reason) == null ? void 0 : _a.message) || e.reason);
  });
})();
