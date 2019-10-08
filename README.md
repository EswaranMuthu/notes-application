
Awesome Notes Application :
  notes-applicaiton is smart project using microservice architecture where user can login read all his notes edit/delete them. also can create new notes. 
  
High level System Design :

  1) Form based or single sign on (SAML / OAUTH) user logon
  2) Identity service get form based request or SAML authn request. get user credientials authenticate against LDAP or active directory (authentication service).
  3) sucess or failure response from authentication service. 
  4) On successful login, create user profile. save user profile in redis with session expiry token as key.
  5) Pass session expiry token as query param to notes service home page (notes UI).
  6) landing page (home page of notes application) receives successfully logged in user request from authentication service.  
    drop unique session expiry token as cookie in user browser. all the subsequent request can fetch user profile using token. 
  7) UI passes token to backend. backend service gets user profile from redis using token.
  8) backend queries DB to fetch all notes pertaining to the user. 
  9) backend receives all notes of the user from DB.
  10)backend gives all notes of the user back to UI. UI will display all the user notes.
  
  For all subsequent transaction, the request need not to be authenticated against LDAP/Active directory since request will come with token. and the request can be routed to any instance of Athentication/UI/Backend since all service are stateless.    


![alt text](https://github.com/EswaranMuthu/notes-application/blob/master/notes_system_design.jpg)
