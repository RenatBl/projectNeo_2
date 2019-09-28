<#import "parts/page.ftl" as p>
<#import "parts/login.ftl" as l>

<@p.page>
Login page
    <@l.login "/login" />
<a href="/logup">Add new user</a>
</@p.page>