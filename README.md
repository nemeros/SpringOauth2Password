An application with Authorization Server & Resource Server.

Support password flow only.


To log-in call the endpoint : 
POST /oauth/token?grant_type=password&username=bill&password=abc123

Header :
Authorization : Bearer <base64>

base64 : my-trusted-client:secret