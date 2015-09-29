
function sizeOfThings() {
    var windowWidth = window.innerWidth;
    var windowHeight = window.innerHeight;

    var screenWidth = screen.width;
    var screenHeight = screen.height;

    if (windowWidth <= 799) {

        location.href = "http://localhost:8080//WebMobile/detalheMobile.html"

    }else if (windowWidth >= 800) {
        location.href = "http://localhost:8080//WebMobile/detalhe.html"
    }
};

window.addEventListener('resize', function () {
    sizeOfThings();
});