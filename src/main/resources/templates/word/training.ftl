<#include "/part/header.ftl">

<hr/>

<h3>Давайте тренироваться! </h3>
<h4>Слово для перевода: <span class="label label-info">${word.spelling}</span></h4>
<p>Выберите один из вариантов ответа</p>
<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">

    <ol>
    <#list words as word>
        <li>${word.valueInLanguage}</li>
    </#list>
    </ol>

    <form action="/training" method="post" class="form-horizontal">
        <div class="form-group">
            <label>Ваш ответ [0..4]: </label>
            <input type="number" class="form-control" name="val">
        </div>
        <button class="btn btn-primary btn-1g" id="submit">Проверить</button>
    </form>

</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>

<hr/>

<#include "/part/footer.ftl">