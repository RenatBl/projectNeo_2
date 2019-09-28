<#import "parts/page.ftl" as p>

<@p.page>
Add new user
    ${message!}
    <form action="/logup" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><label> Имя: <input type="text" name="name"/> </label></div>
        <div><label> Фамилия: <input type="text" name="surname"/> </label></div>
        <div><label> Отчество: <input type="text" name="patronymic"/> </label></div>
        <div>
            <label>
                Пол:
                <input type="radio" name="sex" value="M"/>
                <input type="radio" name="sex" value="W"/>
            </label>
        </div>
        <div><label> Дата рождения: <input type="date" name="birth"/> </label></div>
        <div><label> E-mail: <input type="text" name="email"/> </label></div>
        <div><label> Телефон: <input type="text" name="phoneNumber"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>
</@p.page>