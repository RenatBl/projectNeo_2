<#import "parts/page.ftl" as p>

<@p.page>
Add new author
    ${message!}
    <form action="/author_registration" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> Наименование организации: <input type="text" name="companyName"/> </label></div>
        <div><label> ИНН: <input type="text" name="inn"/> </label></div>
        <div><label> ОГРН: <input type="text" name="ogrn"/> </label></div>
        <div><label> E-mail: <input type="text" name="email"/> </label></div>
        <div><label> Телефон: <input type="text" name="phoneNumber"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign Up"/></div>
    </form>
</@p.page>