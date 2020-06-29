$(document).ready(function() {
  var colorFunc = function(x, y) {
    return 'hsl(' + Math.floor(Math.abs(x * y) * 360) + ',80%,60%)';
  };

  // Create a new SVG pattern with Trianglify.

  var worldRect = {
    x: 0,
    y: 0,
    width: window.innerWidth,
    height: window.innerHeight
  };
  window.addEventListener('resize', windowResizeHandler, false);

  function windowResizeHandler() {
    worldRect.width = window.innerWidth;
    worldRect.height = window.innerHeight;
    //            console.log(worldRect.height);
    var pattern = Trianglify({
      width: worldRect.width,
      height: worldRect.height,
      cell_size: 80,
      variance: 1,
      stroke_width: 1,
      color_function: colorFunc
    }).svg(); // Render as SVG.

    // Add pattern to DOM.

    var container = document.querySelector('.trianglify');
    //      container.style.opacity = 0;
    container.removeChild(container.childNodes[0]);
    container.insertBefore(pattern, container.firstChild);
    // Get all pattern polygons.
    var polyArray = [].slice.call(pattern.children);

    // Get polygon coords and hide them.
    var polyPoints = polyArray.map(function(poly) {

      poly.classList.add('poly', 'invisible');

      var rect = poly.getBoundingClientRect();

      var point = {
        x: rect.left + rect.width / 2,
        y: rect.top + rect.height / 2
      };

      return point;
    });

    // Get circle for hover.
    var circle = document.querySelector('.circle');

    document.addEventListener('mousemove', onMouseMove);

    function onMouseMove(e) {

      var radius = circle.clientWidth / 2;

      var center = {
        x: e.clientX,
        y: e.clientY
      };

      circle.style.left = center.x - radius;
      circle.style.top = center.y - radius;

      polyPoints.forEach(function(point, i) {

        if (detectPointInCircle(point, radius, center)) {
          polyArray[i].classList.remove('invisible');
        } else {
          polyArray[i].classList.add('invisible');
        }
      });
    };

    function detectPointInCircle(point, radius, center) {

      var xp = point.x;
      var yp = point.y;

      var xc = center.x;
      var yc = center.y;

      var d = radius * radius;

      var isInside = Math.pow(xp - xc, 2) + Math.pow(yp - yc, 2) <= d;

      return isInside;
    };
  }
  var pattern = Trianglify({
    width: worldRect.width,
    height: worldRect.height,
    cell_size: 80,
    variance: 1,
    stroke_width: 1,
    color_function: colorFunc
  }).svg(); // Render as SVG.

  // Add pattern to DOM.

  var container = document.querySelector('.trianglify');
  container.style.opacity = 0;
  container.insertBefore(pattern, container.firstChild);

  // Get all pattern polygons.
  var polyArray = [].slice.call(pattern.children);

  // Get polygon coords and hide them.
  var polyPoints = polyArray.map(function(poly) {

    poly.classList.add('poly', 'invisible');

    var rect = poly.getBoundingClientRect();

    var point = {
      x: rect.left + rect.width / 2,
      y: rect.top + rect.height / 2
    };

    return point;
  });

  // Get circle for hover.
  var circle = document.querySelector('.circle');

  document.addEventListener('mousemove', onMouseMove);

  function onMouseMove(e) {
    container.style.opacity = 1;
    var radius = circle.clientWidth / 2;

    var center = {
      x: e.clientX,
      y: e.clientY
    };

    circle.style.left = center.x - radius;
    circle.style.top = center.y - radius;

    polyPoints.forEach(function(point, i) {

      if (detectPointInCircle(point, radius, center)) {
        polyArray[i].classList.remove('invisible');
      } else {
        polyArray[i].classList.add('invisible');
      }
    });
  };

  function detectPointInCircle(point, radius, center) {

    var xp = point.x;
    var yp = point.y;

    var xc = center.x;
    var yc = center.y;

    var d = radius * radius;

    var isInside = Math.pow(xp - xc, 2) + Math.pow(yp - yc, 2) <= d;

    return isInside;
  };

});