/**
 * 
 */
 
 

// 가입부분 체크
function signUpCheck(){

  let id = document.getElementById("userId").value
  let name = document.getElementById("userName").value
  let pwd = document.getElementById("userPwd").value
  let rePwd = document.getElementById("rePwd").value
  let email = document.getElementById("userEmail").value
  let gender_man = document.getElementById("gender_man").checked
  let gender_woman = document.getElementById("gender_woman").checked
  let check = true;
  // 아이디확인
  if(id === ""){
    document.getElementById("idError").innerHTML="아이디는 필수입력 항목입니다"
    check = false
  }else{
    document.getElementById("idError").innerHTML=""
  }
  
  alert("id => " + id);

  }












// 약관동의 모두선택
function selectAll(selectAll)  {
  let checkboxes 
      = document.getElementsByName('agree');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}
 
 