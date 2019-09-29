<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <table>
            <tr>
                <th>Username</th>
            </tr>
    <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><a href="/user_list/${user.id}">Редактировать</a></td>
            </tr>
    </#list>
        </table>
    </div>
</@p.page>