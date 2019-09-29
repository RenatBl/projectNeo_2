<#import "parts/page.ftl" as p>

<@p.page>
Настройки пользователя

<form action="/user_list" method="post">
    <input type="text" name="username" value="${user.username}">
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</@p.page>