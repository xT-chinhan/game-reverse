window.addEventListener("error", function(e) {
  if (document.body) {
    document.body.dataset.theatreError = e.message;
    document.body.dataset.theatreStack = e.error && e.error.stack || "";
  }
});
window.addEventListener("unhandledrejection", function(e) {
  if (document.body) document.body.dataset.theatreError = String(e.reason);
});
