<#include "/part/header.ftl">

<hr/>

<h3>Добавить новое слово <span class="label label-info">New</span></h3>

<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">

<form action="/add" method="post" class="form-horizontal" id = "theForm">
    <div class="form-group">
        <label>Написание слова на английском:</label>
        <input type="text" class="form-control" name="spelling">
    </div>
    <div class="form-group">
        <label>Его перевод на ваш язык:</label>
        <input type="text" class="form-control" name="valueInLanguage" id="ruField">
    </div>
    <button class="btn btn-primary btn-1g" id="submit">Добавить слово</button>
</form>
</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>
<hr/>

<script type="text/javascript" src="/assets/custom/whenFieldEmpty.js"></script>
<#include "/part/footer.ftl">