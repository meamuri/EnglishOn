<#include "/part/header.ftl">
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
<#include "/part/footer.ftl">