(function() {
  "use strict";
  const bubble = document.createElement("div");
  bubble.id = "characterSpeech";
  bubble.hidden = true;
  bubble.setAttribute("role", "status");
  bubble.setAttribute("aria-live", "polite");
  document.body.append(bubble);
  let timer = 0;
  function send(text, duration) {
    var _a;
    (_a = document.getElementById("cottonFrame").contentWindow) == null ? void 0 : _a.postMessage({ channel: "cotton-theatre-parent", type: "speak", payload: { text, duration } }, "*");
  }
  function clear() {
    clearTimeout(timer);
    bubble.hidden = true;
    bubble.textContent = "";
    send("", 0);
  }
  function place() {
    const home = document.body.classList.contains("in-home"), anchor = document.getElementById(home ? "homePuppetSpace" : "puppet").getBoundingClientRect(), app = document.getElementById("app").getBoundingClientRect();
    bubble.style.left = Math.min(app.right - 116, anchor.left + anchor.width * 0.67) + "px";
    bubble.style.top = anchor.top + anchor.height * 0.25 + "px";
  }
  window.addEventListener("cotton-speech", (e) => {
    const { text, duration } = e.detail || {};
    clear();
    if (!text || ["wardrobeOverlay", "set", "up", "win", "codexPanel"].some((id) => {
      var _a;
      return (_a = document.getElementById(id)) == null ? void 0 : _a.classList.contains("on");
    })) return;
    bubble.textContent = text;
    bubble.hidden = false;
    place();
    send(text, duration || 4300);
    timer = setTimeout(clear, duration || 4300);
  });
  window.addEventListener("resize", place);
  for (const id of ["wardrobeOverlay", "set", "up", "win", "codexPanel"]) new MutationObserver(() => {
    if (document.getElementById(id).classList.contains("on")) clear();
  }).observe(document.getElementById(id), { attributes: true, attributeFilter: ["class"] });
})();
