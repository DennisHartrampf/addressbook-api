Nachdem es lokal gestartet wurde, kann man über die URL http://localhost:8080/h2-console Die H2 Konsole erreichen.

Über die URL POST http://localhost:8080/contacts wird eine Liste von Kontakten (JSON Body) gespeichert.

Hier ein JSON Body:

Beginn-->
[
    {
        "firstName": "Peter",
        "lastName": "Parker",
        "dob": "1975-01-01",
        "company": "Avengers",
        "vipStatus": "first class",
        "description": "cool spider bro",
        "labels": [
            {
                "label": "rookie"
            },
            {
                "label": "strong"
            },
            {
                "label": "smart"
            }
        ],
        "emails": [
            {
                "email": "spidy@web.com"
            }
        ],
        "addresses": [
            {
                "streetName": "Evergreen",
                "houseNumber": 2,
                "city": "New Yorck",
                "zipCode": 12345,
                "country": "USA"
            }
        ],
        "phoneNumbers": [
            {
                "number": 911
            }
        ]
    },
    {
        "firstName": "Nick",
        "lastName": "Fury",
        "dob": "1970-01-01",
        "company": "Avengers",
        "vipStatus": "first class leader",
        "description": "boss",
        "labels": [
            {
                "label": "leader"
            }
        ],
        "emails": [
            {
                "email": "nick@fu.to"
            },
            {
                "email": "fu.nick@gmx.com"
            }
        ],
        "addresses": [
            {
                "streetName": "qwerty",
                "houseNumber": 88,
                "city": "Washington DC",
                "zipCode": 10999,
                "country": "USA"
            }
        ],
        "phoneNumbers": [
            {
                "number": 110
            },
            {
                "number": 88888888
            }
        ]
    }
]
<--Ende


Über die URL GET http://localhost:8080/contacts bekommt man alle Kontakte.

Output-->
[{"id":1,"firstName":"Peter","lastName":"Parker","dob":"1975-01-01","company":"Avengers","vipStatus":"first class","description":"cool spider bro","labels":[{"id":4,"label":"rookie"},{"id":5,"label":"strong"},{"id":6,"label":"smart"}],"emails":[{"id":3,"email":"spidy@web.com"}],"addresses":[{"id":2,"streetName":"Evergreen","houseNumber":2,"city":"New Yorck","zipCode":12345,"country":"USA"}],"phoneNumbers":[{"id":7,"number":911}]},{"id":8,"firstName":"Nick","lastName":"Fury","dob":"1970-01-01","company":"Avengers","vipStatus":"first class leader","description":"boss","labels":[{"id":12,"label":"leader"}],"emails":[{"id":10,"email":"nick@fu.to"},{"id":11,"email":"fu.nick@gmx.com"}],"addresses":[{"id":9,"streetName":"qwerty","houseNumber":88,"city":"Washington DC","zipCode":10999,"country":"USA"}],"phoneNumbers":[{"id":13,"number":110},{"id":14,"number":88888888}]}]

Einzelne Kontakte nicht getestet.
