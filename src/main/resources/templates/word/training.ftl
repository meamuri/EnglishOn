<#include "/part/header.ftl">

<hr/>

<h3>Давайте тренироваться! </h3>

<div class="alert alert-success" role="alert">
    Слово для перевода: ${word.spelling}
</div>
<p>Выберите один из вариантов ответа</p>
<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">

    <ol>
    <#list words as word>
        <li>${word.valueInLanguage}</li>
    </#list>
    </ol>

    <form action="/training" method="post" class="form-horizontal">
        <div class="form-group">
            <label>Ваш ответ [1..4]: </label>
            <input type="number" class="form-control" name="val" min="1" max="4">
        </div>
        <button class="btn btn-primary btn-1g" id="submit">Проверить</button>
    </form>

</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>

<hr/>

<#include "/part/footer.ftl">