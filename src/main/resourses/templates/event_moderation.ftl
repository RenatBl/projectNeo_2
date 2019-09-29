<#import "parts/page.ftl" as p>

<@p.page>
    <div>
        <table>
            <tr>
                <th>Тэг</th>
                <th>Описание</th>
                <th>Дата окончания сборов</th>
                <th>Цель</th>
            </tr>
    <#list events as event>
            <tr>
                <td>${event.tag}</td>
                <td>${event.text}</td>
                <td>${event.deadline}</td>
                <td>${event.target}</td>
                <td><a href="/event_moderation/${event.id}">Редактировать</a></td>
            </tr>
    </#list>
        </table>
    </div>
</@p.page>