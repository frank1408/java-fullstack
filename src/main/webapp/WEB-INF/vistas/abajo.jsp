<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- content-section --></div>
<!-- End page content --></div>


<script>
// Accordion
function myAccFunc() {
var x = document.getElementById("demoAcc");
if (x.className.indexOf("w3-show") == -1) {
x.className += " w3-show";
} else {
x.className = x.className.replace(" w3-show", "");
}
}

// Click on the "Jeans" link on page load to open the accordion for demo purposes
document.getElementById("myBtn").click();


// Open and close sidebar
function w3_open() {
document.getElementById("mySidebar").style.display = "block";
document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
document.getElementById("mySidebar").style.display = "none";
document.getElementById("myOverlay").style.display = "none";
}
</script>
<!--
bootstrap 5.2.3
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
-->
<script src="secret.js"></script>
</body>
</html>