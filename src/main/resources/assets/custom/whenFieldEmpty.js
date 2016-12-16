$(document).ready(function() {
    $("#ruField").focusout(function(){
        // здесь лучше сделать универсальным и навесить метод на класс, чтобы
        // было для всех инпутов абсолютно
        if($(this).val()==""){
            // неплохо бы добавить Node с предупреждением и бутстрап стилем before $("#theForm")
            $("#ruField").value = "default";
            $("#ruField").focusin();
        }
    });
});