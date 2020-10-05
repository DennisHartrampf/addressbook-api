Nachdem es lokal gestartet wurde, kann man über die URL http://localhost:8080/h2-console Die H2 Konsole erreichen.

Über die URL GET http://localhost:8080/persons bekommt man alle Personen.

Über die URL POST http://localhost:8080/persons soll eine Liste von Kontakten (JSON Body) gespeichert werden, was leider nicht funktioniert, da man z.B. zuerst eine Adresse speichern muss um Sie dann einem Kontakt hinzuzufügen.

Hier ein JSON Body:

[{"id":1,"firstName":"Peter","lastName":"Parker","dob":"1975-01-01","company":"Avengers","vipStatus":"first class","description":"cool spider bro","labels":[{"id":1,"label":"rookie"},{"id":3,"label":"strong"},{"id":4,"label":"smart"}],"emails":[{"id":1,"email":"spidy@web.com"}],"addresses":[{"id":1,"streetName":"Evergreen","houseNumber":2,"city":"New Yorck","zipCode":12345,"country":"USA"}],"phoneNumbers":[{"id":1,"number":911}]},{"id":2,"firstName":"Nick","lastName":"Fury","dob":"1970-01-01","company":"Avengers","vipStatus":"first class leader","description":"boss","labels":[{"id":2,"label":"leader"}],"emails":[{"id":2,"email":"nick@fu.to"},{"id":3,"email":"fu.nick@gmx.com"}],"addresses":[{"id":2,"streetName":"qwerty","houseNumber":88,"city":"Washington DC","zipCode":10999,"country":"USA"}],"phoneNumbers":[{"id":2,"number":110},{"id":3,"number":88888888}]}]

oder formatiert:

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

