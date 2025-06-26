const  header= document.getElementsByTagName("header")[0];
const  nav = document.getElementsByTagName("nav")[0];
var open = false;

nav.style.border="none"

function openMenu(){
    if(!open){
        // menuToggle.classList.toggle("open");
        header.style.height="200px";
        nav.style.border="block"

        open = true;
    }
    else{
        header.style.height="70px";
        nav.style.border="none"
        open = false;
    }

}

