$param = $(location).attr('href');
console.log($param);

// код выше будет использован для унификации определения активного пункта меню и добавления
// скрипта единожды в шаблон-хеадер

jQuery('#main-page').addClass('active');