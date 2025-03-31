#!/usr/bin/env python
import cgi
import cgitb
cgitb.enable()

print("Content-Type: text/html\n\n")

form = cgi.FieldStorage()
name = form.getvalue('name', 'World')

print(f"""
<html>
<head><title>CGI Example</title></head>
<body>
<h1>Hello, {name}!</h1>
<p>This is a CGI program written in Python.</p>
</body>
</html>
""")