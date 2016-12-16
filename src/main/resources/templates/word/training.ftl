<#include "/part/header.ftl">

<hr/>

<h3>Давайте тренироваться! </h3>

<#if result.name() == "TRUE">

<button class="btn btn-success" type="button">
    Ваш предыдущий ответ абсолютно верный <span class="badge">Блестяще!</span>
</button>
<#elseif  result.name() == "FALSE">
<button class="btn btn-warning" type="button">
    К сожалению, вы ответили неверно. Попробуйте снова
</button>
</#if>

<div class="alert alert-success" role="alert">
    Слово для перевода: ${word.spelling}
</div>

<hr/>
<p>Выберите один из вариантов ответа</p>
<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">

    <ol>
    <#list words as word>
        <li>${word.valueInLanguage}</li>
    </#list>
    </ol>

    <form action="/training/${whichAnswerTrue + 1}" method="post" class="form-horizontal">
        <div class="form-group">
            <label>Ваш ответ [1..4]: </label>
            <input type="number" class="form-control" name="val" min="1" max="4" value="1">
            <input type="hidden"  class="form-control" name="id" value="${word.id}">
        </div>
        <button class="btn btn-primary btn-1g" id="submit">Проверить</button>
    </form>

</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>

<hr/>

<#include "/part/footer.ftl">