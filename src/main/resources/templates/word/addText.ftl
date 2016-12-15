<#include "/part/header.ftl">

<hr/>

<h3>Добавить набор слов, полученный из текста <span class="label label-info">New</span></h3>
<p> Вам достаточно добавить сюда текст, а перевод слов из него мы получим сами!</p>
<div class="container body-container"><div class="row"><div class="col-xs-8 cols-md-8">
    <form action="/checkText" method="post" class="form-horizontal">
        <div class="form-group">
            <label>Текст для перевода на ваш язык:</label>
            <textarea lang="en" class="form-control" rows="8" id="comment" name="text"></textarea>
        </div>
        <button class="btn btn-primary btn-1g" id="submit">Получить слова</button>
    </form>
</div>
    <div class="col-xs-4 cols-md-4"></div>
</div></div>
<hr/>

<#include "/part/footer.ftl">