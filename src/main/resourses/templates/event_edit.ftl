<#import "parts/page.ftl" as p>

<@p.page>
    <a href="event_moderation.ftl">Назад</a>
    <form action="/event_moderation" method="post">
        <label>Проверено<input type="checkbox" value="Moderated" name="state"></label>
        <input type="hidden" value="${event.id}" name="eventId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@p.page>