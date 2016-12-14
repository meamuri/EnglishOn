<#include "/part/header.ftl">

<hr/>

<h3>Добавить новое слово <span class="label label-info">New</span></h3>
<p> Вам достаточно написать интересующее слово, а его перевод мы получим сами!</p>
<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">
    <form action="/addWithApi" method="post" class="form-horizontal">
        <div class="form-group">
            <label>Написание слова на английском:</label>
            <input type="text" class="form-control" name="spelling">
        </div>
        <button class="btn btn-primary btn-1g" id="submit">Добавить слово</button>
    </form>
</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>
<hr/>

<#include "/part/footer.ftl">