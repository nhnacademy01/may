window.addEventListener("load", () => {
    getData()
        .then(makeDataList)
        .then(monthTable)
})


function getData() {
    return new Promise((resolve, reject)=>{
        const serviceKey = "SicnqwL4UZHLtg0iinrYfE98LwIwmj19BoMWDL3Uz8zAvFEnRw0gC%2BUaM2pITaR6B%2BxL2cnqDquxh1c3k0mc%2Fw%3D%3D";

        const xhr2 = new XMLHttpRequest();
        const url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"; /*URL*/
        let queryParams = "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
        queryParams += "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /**/
        queryParams += "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("10"); /**/
        queryParams += "&" + encodeURIComponent("startCreateDt") + "=" + encodeURIComponent("20220301"); /**/
        queryParams += "&" + encodeURIComponent("endCreateDt") + "=" + encodeURIComponent("20220331"); /**/
        xhr2.open("GET", url + queryParams);
        xhr2.onreadystatechange = function () { 
            if (this.readyState == 4) {
                const parser2 = new DOMParser();
                const xmlDoc2 = parser2.parseFromString(this.responseText, "text/xml");
                resolve(xmlDoc2);
            }
        };
        xhr2.send("");
    })
}

function makeDataList(xmlDoc2) {
    return new Promise(function(resolve, reject){
        let items = xmlDoc2.getElementsByTagName("item");
        let itemList = [];
            for (let i = 1; i < items.length-1; i++) {
                let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
                let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
                let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
                let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;
                let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;

                let item = {
                    gubun,
                    createDt,
                    deathCnt,
                    defCnt,
                    incDec
                };
                itemList.push(item);
        }
        resolve(itemList);
    })
}


function monthTable(itemList) {
    let tableContent = document.getElementById("gubunCnt");
    let cnt = opener.document.getElementById("pInput").value;
    gubunDict = {0 : "??????", 1: "??????", 2:"??????", 3:"??????", 4:"??????", 5:"??????", 6:"??????", 7:"??????", 8:"??????", 9:"??????", 10:"??????", 11:"??????", 12:"??????", 13:"??????", 14:"??????", 15:"??????", 16:"??????"}
    let gubun = gubunDict[cnt];
    for (let i = 1; i < itemList.length-1; i++) {
        if (gubun == itemList[i].gubun) {
            let contentTd = `
            <tr>
            <td>${itemList[i].gubun}</td>
            <td>${itemList[i].createDt}</td>
            <td>${itemList[i].deathCnt}</td>
            <td>${itemList[i].incDec}</td>
            <td>${itemList[i].defCnt}</td>
            </tr>
            `;
            tableContent.insertAdjacentHTML("beforeend",contentTd);
        }
    }
}