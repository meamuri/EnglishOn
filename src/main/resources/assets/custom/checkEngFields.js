$(document).ready(function() {
    $("#engField").focusout(function(){
        if($(this).val()==""){
            alert("This field is required");
            $("#engField").focusin();
        }
    });
});