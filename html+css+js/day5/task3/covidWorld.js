window.addEventListener("load", () => {
    getData()
        .then(makeDataList)
        .then(makeTable)
        .then(makeChart)
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

function makeDataList(xmlDoc) {
    return new Promise(function(resolve, reject){
        const items = xmlDoc.getElementsByTagName("item");
        let itemList = [];

        for(let i = 0; i < items.length; i++) {
            let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML;
            let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;
            let natDeathCnt = items[i].getElementsByTagName("natDeathCnt")[0].innerHTML;
            let natDeathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;
            
            let item = {
                nationNm,
                natDefCnt,
                natDeathCnt,
                natDeathRate
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
            <td>${itemList[i].nationNm}</td>
            <td>${itemList[i].natDefCnt}</td>
            <td>${itemList[i].natDeathCnt}</td>
            <td>${itemList[i].natDeathRate}</td>
            </tr>
            `;

            tableContent.insertAdjacentHTML("beforeend",contentTd);
        }
        resolve(itemList);
    })
}



function makeChart(itemList) {

    google.charts.load('current', {'packages':['geochart'],});
    google.charts.setOnLoadCallback(drawRegionsMap);
    var data = google.visualization.arrayToDataTable([
    ['Country', 'Popularity'],
    ['Germany', 200],
    ['United States', 300],
    ['Brazil', 400],
    ['Canada', 500],
    ['France', 600],
    ['RU', 700]
    ]);
    var options = {};
    var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
}




