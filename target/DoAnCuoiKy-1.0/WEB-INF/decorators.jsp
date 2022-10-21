<?xml version="1.0" encoding="UTF-8"?>
<decorators defaultdir="/decorators">
    <!-- Any urls that are excluded will never be decorated by Sitemesh -->
    <excludes>
        <pattern>/api*</pattern>
    </excludes>
    <!-- apply Sitemesh default template -->
    <decorator name="admin" page="admin.jsp">
        <pattern>/admin*</pattern>
    </decorator>
    <decorator name="web" page="web.jsp">
        <pattern>/*</pattern>
    </decorator>
    <decorator name="seller" page="seller.jsp">
        <pattern>/seller*</pattern>
    </decorator>
    <decorator name="login" page="login.jsp">
        <pattern>/login</pattern>
    </decorator>
</decorators>