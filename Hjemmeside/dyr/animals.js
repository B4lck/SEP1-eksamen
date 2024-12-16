class Animal {
    id;
    category;
    name;
    price;
    comment;
    birthday;
    url;

    constructor(id, category, name, price, comment, birthday, url) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.birthday = birthday;
        this.url = "/img/kaninDyr.png"; // det er altid det samme billede
    }
}

/**
 * liste over dyr
 * @type {Animal[]}
 */
let animals = []
fetch("/data/animals_public.csv")
    .then(res => res.text())
    .then(data => {
        let rows = data.split("\n");
        for (let i = 1; i<rows.length; i++) {
            let cols = rows[i].split(";");
            if (cols.length > 0) {
                animals.push(new Animal(cols[0], cols[1], cols[2], cols[3], cols[4], europeanToAmericanDate(cols[5]), cols[6]));
            }
        }
        updateAnimals();
    })

function yearSince(date) {
    let today = new Date();
    let age = today.getFullYear() - (date.getFullYear() - 1); // getFullYear returnere åbenbart 2025, selvom der står 2024?!?!?!?
    if (today.getMonth() <= date.getMonth() && today.getDate() <= date.getDate()) age++;
    return age;
}

function europeanToAmericanDate(date) {
    const d = date.slice(0,2);
    const m = date.slice(3,5);
    const y = date.slice(6,10);
    return new Date(y,m,d)
}

function updateAnimals() {
    let row;
    for (let i = 0; i < animals.length; i++) {
        if (i % 4 === 0) {
            row = document.createElement("div");
            row.classList.add("row");
            document.getElementById("container").appendChild(row);
        }

        let animal = animals[i];
        let animalObject = document.createElement("div");

        animalObject.innerHTML = "" +
            "<img src='" + animal.url + "' alt='" + animal.name + "'>" +
            "<div class='left'>" +
                "<h2>" + animal.name + "</h2>" +
                "<h3>" + yearSince(animal.birthday) + " år</h3>" +
                "<p>" + animal.price + ",-- kr.</p>" +
            "</div>" +
            "<div class='right'>" +
                "<p class='beforePrice'></p>" +
                "<p class='saveText'></p>" +
            "</div>" +
            "<button>Læs mere</button>";

        animalObject.classList.add("animal");
        row.appendChild(animalObject);
    }
    document.getElementById("container").appendChild(row);
}