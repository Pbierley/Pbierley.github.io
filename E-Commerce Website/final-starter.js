// URL to the API
const api_url="https://6245f389e3450d61b0f926c1.mockapi.io/api/v1/";

// Function to show the loader
function showLoader() {
	document.querySelector("#loading").style.display = 'block';
}
// Function to hide the loader
function hideLoader() {
	document.querySelector('#loading').style.display = 'none';
}
async function getApiData(url) {
	try {
		let connection = await fetch(url);
		return await connection.json(); // produces an object
	} catch (error) {
		console.log(error);
	}
}
async function processCategories() {
	showLoader();
	let results = await getApiData(api_url+"categories");
	if(results){
		hideLoader();
	}
	console.log(typeof(results)); // = object, because getApiData returns an object
	console.log(results);
	let html = '<span>Filter: </span>';
	results.forEach(category => {
		let htmlSegment = `<label>
			<input type="radio" name="category" onclick="processItems(${category.id});">
			 ${category.name}</label>`;
		html += htmlSegment;
	});
	let categoryContainer = document.querySelector('nav');
	categoryContainer.innerHTML = html;
}

async function processItems(category) {
	showLoader();
	// results will contain a json object
	let results = await getApiData(api_url+"categories/"+category+"/items");
	if(results){
		hideLoader();
	}
	let itemCount = (results.totalCount);
	let results1 =(results);
		var table = document.getElementById('tableItems');
		table.innerHTML = "";
		for (var i = 0; i < itemCount; i++){
			var row = `<tr id= "highlight" onclick = "displayItem(${category},${results1.items[i].itemId})">
							<td><img src = '${results1.items[i].image[0]}'class=listViewImg></td>
							<td>${results1.items[i].itemName}</td>
							<td>${results1.items[i].itemBrief}</</td>
							<td>${results1.items[i].price}</td>
							</tr>`;
			table.innerHTML += row;
		};
}
async function displayItem(category, id) {
	showLoader();
	let results = await getApiData(api_url+"categories/"+category+"/items/"+id);
	if(results){
		hideLoader();
	}
	hideList();
	showItemView();
	var category = category;
	console.log(results);
	console.log(results.itemName);
	document.querySelector('#productName').innerHTML = (results.itemName);
	document.querySelector('#price').innerHTML = (results.price);
	document.querySelector('#main-image').src = (results.image[0]);

	//Create loop for this 
	document.querySelector('#P1').src = (results.image[0]);
	document.querySelector('#P2').src = (results.image[1]);
	document.querySelector('#P3').src = (results.image[2]);
	document.querySelector('#P4').src = (results.image[3]);
	document.querySelector('#descriptionFull').innerHTML = (results.itemFull);
	
	// Size dropdown
	const sizeSelect = document.getElementById('size');
	// Sets the var options
	const sizeOptions = results.size;
	// Loop through the options array  and add them to the select element
	for (let i = 0; i < sizeOptions.length; i++) {
		const optionElement = document.createElement('option');
		optionElement.value = sizeOptions[i];
		optionElement.text = sizeOptions[i];
		sizeSelect.appendChild(optionElement);
	}

	//color dropdown
	const colorSelect = document.getElementById('color');
	const colorOptions = results.colors;
	for (let i = 0; i < colorOptions.length; i++) {
		const optionElement = document.createElement('option');
		optionElement.value = colorOptions[i];
		optionElement.text = colorOptions[i];
		colorSelect.appendChild(optionElement);
	}

};

function showItemView(){
	document.querySelector('#itemViewWrapper').style.display = 'inline';
}
function hideItemView(){
	document.querySelector('#itemViewWrapper').style.display = 'none';
}

function hideList() {
	document.querySelector('#listViewScreen').style.display = 'none';
}
function showList() {
	document.querySelector('#listViewScreen').style.display = 'inline';
}

function loadImage(clickedImage) {
	console.log(`got loadImage(${clickedImage})`);
	var mainImage = document.querySelector("#main-image");
	mainImage.src = clickedImage.src;
	mainImage.alt = clickedImage.alt;
}
function hideItem(category){
	showLoader();
	clearColor();
	clearSize();
	hideItemView();
	showList();
	if(showList){
		hideLoader();
	}

}
function clearColor() {
	var selectElement = document.getElementById("color");
	while (selectElement.options.length > 0) {
	  selectElement.remove(0);
	}
}
function clearSize() {
	var selectElement = document.getElementById("size");
	while (selectElement.options.length > 0) {
	  selectElement.remove(0);
	}
}