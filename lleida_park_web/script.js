
var map = L.map('map').setView([41.614245, 0.626627], 13);

var osm = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
});

const marker = L.marker([41.610455, 0.6093381]).addTo(map).bindPopup('<b>Hello world!</b><br />I am a popup.').openPopup();

let spots = 0;
let maxSpots = 0;
let name = '';
let marker2 = L.marker([41.6094412, 0.6298933]).addTo(map);

function updatePopup() {
    let popupContent = `
        <div>
        <img src="https://lh5.googleusercontent.com/p/AF1QipO27RUJswSvGPpVkqaudn0OloSZagbTFeUJdK1m=w408-h306-k-no" alt="Image description" width="200">
            <h2>${name}</h2>
            <p>Ara mateix queden ${spots} de ${maxSpots} places disponibles.</p>
        </div>
    `;
    marker2.bindPopup(popupContent).openPopup();
}

$.ajax({
	url: 'http://192.168.237.224:8080/lot/1',
	method: 'GET',
	dataTYpe: 'json',
	success: function (response) {
		maxSpots = response.maxSpots;
		name = response.name;
		updatePopup();                
	},
	error: function (xhr, status, error) {
		console.error('Error fetching data:', error);
	}
});

osm.addTo(map);


setInterval(() => {
    $.ajax({
        url: 'http://192.168.237.224:8080/lot/1/freeSpots',
        method: 'GET',
        success: function (response) {
            spots = response;
            updatePopup();                
        },
        error: function (xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });
}, 1000);