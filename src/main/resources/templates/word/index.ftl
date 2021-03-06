<#include "/part/header.ftl">

<script type="text/javascript" src="/assets/custom/index.js"></script>
<table class="table table-striped">
    <tr>
        <th>Слово</th>
        <th>Перевод</th>
    </tr>
    <#list words as word>
    <tr>
        <td>${word.spelling}</td>
        <td>${word.valueInLanguage}</td>
    </tr>
    </#list>
</table>
<div class="alert alert-success" role="alert">
    <a href="/addWithApi" class="alert-link">Добавить еще слово</a><br/>
    <a href="/addText" class="alert-link">или целый текст сразу</a>
</div>
<#include "/part/footer.ftl">