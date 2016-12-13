<#include "/part/header.ftl">

<form action="/add" method="post" class="form-horizontal">
    <div class="form-group">
        <label>Написание слова на английском:</label>
        <input type="text" class="form-control" name="spelling">
    </div>
    <div class="form-group">
        <label>Написание слова на английском:</label>
        <input type="text" class="form-control" name="value">
    </div>
    <button class="btn btn-primary btn-1g" id="submit">Добавить слово</button>
</form>

<#include "/part/footer.ftl">