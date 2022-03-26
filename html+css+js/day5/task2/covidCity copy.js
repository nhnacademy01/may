window.addEventListener("load", () => {
    getData()
        .then(makeDataList)
        .then(makeTable)
})

function getData() {
    return new Promise((resolve, reject)=>{
        const serviceKey = "SicnqwL4UZHLtg0iinrYfE98LwIwmj19BoMWDL3Uz8zAvFEnRw0gC%2BUaM2pITaR6B%2BxL2cnqDquxh1c3k0mc%2Fw%3D%3D";

        const xhr = new XMLHttpRequest();
        const url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";
        let queryParams = "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
        queryParams += "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /**/
        queryParams += "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("10"); /**/
        queryParams += "&" + encodeURIComponent("startCreateDt") + "=" + encodeURIComponent("20220324"); /**/
        queryParams += "&" + encodeURIComponent("endCreateDt") + "=" + encodeURIComponent("20220324"); /**/
        xhr.open("GET", url + queryParams);
        xhr.onreadystatechange = function () { // 이 메서드 분리하기
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
            let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
            let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
            let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;
            
            let item = {
                gubun,
                defCnt,
                incDec
            };
            itemList.push(item);
        }
        resolve(itemList);
    })
}

function makeTable(itemList) {

    return new Promise(function(resolve, reject){
        let tableContent = document.getElementById("tbody");

        for (let i = 1; i < itemList.length-1; ++i) {
            
            let contentTd = `
            <tr>
            <td>${itemList[i].gubun}</td>
            <td>${itemList[i].defCnt}</td>
            <td>${itemList[i].incDec}</td>
            </tr>
            `;

            tableContent.insertAdjacentHTML("beforeend",contentTd);
        }
        resolve(itemList);
    })
}
