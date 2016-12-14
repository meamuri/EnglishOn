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
<#include "/part/footer.ftl">