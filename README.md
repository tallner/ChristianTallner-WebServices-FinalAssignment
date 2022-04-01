# ChristianTallner-WebServices-FinalAssignment


<!-- Checkbox with color 
-- Done? | Name
:---:| ---
⬜️| Nope
✅| Yep
-->


## Requirements for this assignment

### Handing in
- [ ] Friday 1st April 2022 16:00
- [x] Complete project on github account
- [x] Name it YOURNAME-COURSE-PROJECT
- [ ] Mark with the grade you are aiming for
- [x] Book 15 minutes status meeting via Doodle 2 days before handing in 

### Functionality overview
- [x] Functionalities from each separate assignment in the course
- [ ] Each API documented
- [x] Root ("/") is landing a page where all functionlities and documents are linked.

### Functions and subfunctions
- [x] Kalcylator
  * [x] Plus
  * [x] Minus
  * [x] Multiplication
  * [x] Tests

- [x] Rock, Scissors, paper
  * [x] Play against computer
  * [x] See all results
  * [x] Tests

- [x] Read CSV fil
  * [x] Return resultat as Json

- [x] Read pictures
  * [x] Return random picture

### Grading
- [ ] Use HTTP Request methods correct
- [ ] Data, beans, controller, logic etc for API:s in their own separate classes
- [ ] Documentation
- [x] Data returned in Json, except pictures
- [ ] Basic error handling; error page and show documentaion for that error
- [x] Codestructure designed and thought through. Use help classes when needed, no static beans
- [ ] No known bugs
- [ ] No compile errors
- [ ] Unit tests built for each method
  * [ ] Exemple
    * [ ] Test en endpoint so it replies on correct path with correct values
    * [ ] Test the endpoints functionlity and logic in its serviceclass
- [x] Classes self-aware, eg control its own documentation and return result



### Hints
- Json validator: https://jsonlint.com/

### Documentation example
- Minimum limit is text
- Preferred is interactive  
  
    
    
"JWS kurs API
Detta API har tre funktionsgrupper: Kalkylator, SSP och bildbank

Grupp Kalkylator (/calc)
Räknar plus, minus och multiplikation

[GET] Endpoint /calc/plus?val1=x&val2=y
! Räknar plus mellan två tal
> Query parameter val1 [String]
> Query parameter val2 [String]
< Returns Json => { "result": answer }
/* Exempel på användande och dess resultat */

[GET] Endpoint /calc/minus/{val1}/{val2}
! Räknar minus mellan två tal
> Path parameter val1 [String]
> Path parameter val2 [String]
< Returns Json => { "result": answer }
/* Exempel på användande och dess resultat */

Grupp SSP (/ssp)
Spelar Sten, sax och påse

[GET] Endpoint /SSP
! Visar resultat av pågående match
> Inga parameterar
< Returns Json => { "wins": value, "losses": value }
/* Exempel på användande och dess respons */

[POST] Endpoint /SSP
! Gör ett drag
> header: Content-Type = application/x-www-form-urlencoded
> body parameter: choice [String] - valid values are Stone, Scissors, Paper
< Returns Json => { "Computer move": value, "Winner": value }
/* Exempel på användande och dess 

respons */


Interaktiv dokumentation
Detta presenteras med fördel i html format och alla endpoints har länkar eller formulär som gör att man kan nå och testa dem direkt.
"



