<#import "parts/page.ftl" as p>

<@p.page>
    События
    <#list events as event>
        <div>
            <h3>${event.tag}</h3>
            <p>${event.text}</p>
            <i>${event.deadline}</i>
            <strong>${event.target}</strong>

        </div>
    </#list>
</@p.page>