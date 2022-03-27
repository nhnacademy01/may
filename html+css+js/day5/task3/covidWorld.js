window.addEventListener("load", () => {
    getData()
        .then(makeDataList)
        .then(makeTable)
})

function getData() {
    return new Promise((resolve, reject)=>{
        const serviceKey = "SicnqwL4UZHLtg0iinrYfE98LwIwmj19BoMWDL3Uz8zAvFEnRw0gC%2BUaM2pITaR6B%2BxL2cnqDquxh1c3k0mc%2Fw%3D%3D";
        const xhr = new XMLHttpRequest();
        const url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson";
        let queryParams = "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
        queryParams += "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /**/
        queryParams += "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("10"); /**/
        queryParams += "&" + encodeURIComponent("startCreateDt") + "=" + encodeURIComponent("20220324"); /**/
        queryParams += "&" + encodeURIComponent("endCreateDt") + "=" + encodeURIComponent("20220324"); /**/
        xhr.open("GET", url + queryParams);
        xhr.onreadystatechange = function () { 
            if (this.readyState == 4) {
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(this.responseText, "text/xml");
                resolve(xmlDoc);
            }
        };
        xhr.send("");
    })
}

let itemList = [];

function makeDataList(xmlDoc) {
    return new Promise(function(resolve, reject){
        const items = xmlDoc.getElementsByTagName("item");

        for(let i = 0; i < items.length; i++) {
            let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML;
            let nationNmEn = items[i].getElementsByTagName("nationNmEn")[0].innerHTML;
            let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;
            let natDeathCnt = items[i].getElementsByTagName("natDeathCnt")[0].innerHTML;
            let natDeathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;
            
            let item = {
                nationNm,
                natDefCnt,
                natDeathCnt,
                natDeathRate,
                nationNmEn
            };
            itemList.push(item);
        }
        resolve(itemList);
    })
}

function makeTable(itemList) {

    return new Promise(function(resolve, reject){
        let tableContent = document.getElementById("tbody");

        for (let i = 0; i < itemList.length; ++i) {
            let contentTd = `
            <tr>
            <td id='nationNm${i}' onClick="popup(${i})" style="cursor:pointer; font-weight: bold;">${itemList[i].nationNm}</td>
            <td>${itemList[i].natDefCnt}</td>
            <td>${itemList[i].natDeathCnt}</td>
            <td>${itemList[i].natDeathRate}</td>
            </tr>
            `;

            tableContent.insertAdjacentHTML("beforeend",contentTd);
        }
        google.charts.load('current', {'packages':['geochart'],});
        google.charts.setOnLoadCallback(drawRegionsMap);
        resolve(itemList);
    })
}

function popup(i) {
    var url = "popup.html";
    var name = "popup test";
    var option = "width = 500, height = 1000, top = 100, left = 200, location = no"
    window.open(url, name, option);
    document.getElementById("pInput").value = i;
}


// function makeChart(itemList) {
//     google.charts.load('current', {'packages':['geochart'],});
//     google.charts.setOnLoadCallback(drawRegionsMap);
// }

function drawRegionsMap() {
    let tmpTable = [['Country', 'natDefCnt']];
    for (let i = 0; i < itemList.length; ++i) {
        tmpTable.push([itemList[i].nationNmEn, itemList[i].natDefCnt])
    }
    var data = google.visualization.arrayToDataTable(tmpTable);
    var options = {};
    var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
    chart.draw(data, options);
}

