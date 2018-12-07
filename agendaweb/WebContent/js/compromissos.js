const combo_status = document.querySelector("#combo-status");
combo_status.onchange = () =>{
	
    if(combo_status.value == 0){
        window.location.href = "http://localhost:8080/agendaweb/compromissos.jsp?status=0";
    }
    
    if(combo_status.value == 1){
        window.location.href = "http://localhost:8080/agendaweb/compromissos.jsp?status=1";
    }
    
    if(combo_status.value == 2){
        window.location.href = "http://localhost:8080/agendaweb/compromissos.jsp?status=2";
    }
}