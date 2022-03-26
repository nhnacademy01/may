const now = new Date();              //오늘 날짜
let year = now.getFullYear();       //현재 년도 
let month = (now.getMonth() + 1);  //현재 달 (제로베이스라서 + 1)

let dayDict = {0: "일", 1:"월", 2:"화", 3:"수", 4:"목", 5:"금", 6:"토"}

switch (month) {
    case 2:
        monthDate = 28;
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        monthDate = 30;
        break;
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        monthDate = 31;
        break;
}

document.write(`<h1 id="listTitle">[${year}-${month} My ToDo List]</h1>`)  

document.write(`<div><input type='button' value='전체 List 삭제' id='Drop' onclick='Drop()'></div>`)


for (let i = 1; i <= monthDate; i++) {
    let Today = new Date(year, month-1, i).getDay();     //현재 요일 구하기 (0:일요일, 1:월요일, ...)
    document.write(`<table id='ListTable'>
                    <tr>
                    <td style = text-align:center; rowspan="1" id = 'day${Today}'>${i}</td>
                    <td colspan="1"><input type='text' id='memo${i}'> <input type='button' value='등록' id='submit-button' onclick='register(${i})'></td>
                    <td colspan="1" id="mylist${i}"></td>
                    </tr>
                    <tr>
                    <td style = text-align:center; rowspan="1" id = 'date${Today}'>${dayDict[Today]}</td>
                    <td rowspan="2" colspan="1"><input type='button' value='모두삭제' id='delete' onclick='Delete(${i})'></td>
                    </tr>
                    </table>` );
    
}


//todolist 등록
function register(i) {
    let text = document.getElementById('memo' + i).value;
    localStorage.setItem(i, text);
    let resultArea = document.getElementById("mylist" + i);
    resultArea.innerHTML += `<div style = color:#FFB400; font-weight: bold; id='memo${i}'>${text}</div>`;
    document.getElementById("memo" + i).value ='';   
}

//list 삭제
function Delete(i) {
    let resultArea = document.getElementById("mylist" + i);
    localStorage.removeItem(i, resultArea)
    resultArea.remove(resultArea);
}

//list 모두 삭제
function Drop() {
    localStorage.clear();
    for (let i = 1; i <= monthDate; i++) {
        let resultArea = document.getElementById("mylist" + i);
        if (resultArea != null) {
            resultArea.remove();
        }
    }
}

//저장된 값 불러오기
for (let i = 1; i <= monthDate; i++) {
    const savedToDos = localStorage.getItem(i);
    if (savedToDos !== null) {
        let resultArea = document.getElementById("mylist" + i);
        resultArea.innerHTML += `<div id='memo${i}'>${text}</div>`;
    }
}