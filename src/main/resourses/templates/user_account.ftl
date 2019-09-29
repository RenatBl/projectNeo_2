<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <table>
            <tr>
                <th>Username</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Пол</th>
                <th>Дата рождения</th>
                <th>E-mail</th>
                <th>Телефон</th>
            </tr>
    <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.patronomyc}</td>
                <td>${user.patronomyc}</td>
                <td>${user.sex}</td>
                <td>${user.birth}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td><a href="/user_account/${user.id}">Редактировать</a></td>
            </tr>
    </#list>
        </table>
    </div>
</@p.page>