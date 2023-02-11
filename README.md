## UsernamePasswordAuthenticationFilter

This is the simplest possible SPRING BOOT REST API repo that applies the UsernamePasswordAuthenticationFilter with its defaults.

If username and password sent to the "/login" endpoint are correct, the filter redirects you and you receive a response sent by the "/" home endpoint (from the respective handler method). The POST request can be sent either via parameters or via a x-www-form-urlencoded Body.