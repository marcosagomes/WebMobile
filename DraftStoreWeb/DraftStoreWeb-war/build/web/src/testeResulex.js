$(document).ready(function() {

  var
    $headers     = $('body > h3'),
    $header      = $headers.first(),
    ignoreScroll = false,
    timer
  ;

  // Preserve example in viewport when resizing browser
  $(window)
    .on('resize', function() {
      // ignore callbacks from scroll change
      clearTimeout(timer);
      $headers.visibility('disable callbacks');

      // preserve position
      $(document).scrollTop( $header.offset().top );

      // allow callbacks in 500ms
      timer = setTimeout(function() {
        $headers.visibility('enable callbacks');
      }, 500);
    })
  ;
  $headers
    .visibility({
      // fire once each time passed
      once: false,

      // don't refresh position on resize
      checkOnRefresh: true,

      // lock to this element on resize
      onTopPassed: function() {
        $header = $(this);
      },
      onTopPassedReverse: function() {
        $header = $(this);
      }
    })
  ;
});