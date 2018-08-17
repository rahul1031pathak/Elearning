function getCurrentDate(){
	var d=new Date();
	var currdate=d.getDate();
	var currmonth=d.getMonth()+1;
	var curryear=d.getFullYear();

	currdate=(currdate<10?"0"+currdate:currdate);
	currmonth=(currmonth<10?"0"+currmonth:currmonth);
	curryear=(curryear<10?"0"+curryear:curryear);
	
	var sysdate=currdate+"-"+currmonth+"-"+curryear;
	
	return sysdate;
}

function getDeliveryDate(){
	var d=new Date();
	var currdate=d.getDate()+1;
	var currmonth=d.getMonth()+1;
	var curryear=d.getFullYear();

	currdate=(currdate<10?"0"+currdate:currdate);
	currmonth=(currmonth<10?"0"+currmonth:currmonth);
	curryear=(curryear<10?"0"+curryear:curryear);
	
	var nxtdate=currdate+"-"+currmonth+"-"+curryear;
	
	return nxtdate;
}

function checkMandatory(fieldVal){
	var pattern=new RegExp("[\\S]");
	if(fieldVal==null || fieldVal=="" || !pattern.test(fieldVal)){
		return true;
	}
}

function checkNumericRegEx(fieldVal) {
	var obj = new RegExp("[^0-9]");
	return obj.test(fieldVal);
}

function checkAlphabetRegEx(fieldVal) {
	var obj = new RegExp("[^A-z ]");	//includes 'space'
	return obj.test(fieldVal);
}

function checkAlphaNumericRegEx(fieldVal) {
	var obj = new RegExp("[^A-z0-9\s]");
	return obj.test(fieldVal);
}

function checkDecimalRegEx(fieldVal) {
	//var obj = new RegExp("[^0-9.]");
	var pattern=/^\d{0,4}[0-9](.)?\d{0,1}[0-9]$/;
	return pattern.test(fieldVal);
}

function checkDateRegEx(fieldVal) {
	var pattern = /^\d{1,2}-\d{1,2}-\d{4}$/;
	return pattern.test(fieldVal);
}

function checkDate(dateVal) {
	var dateArray=dateVal.split("-");
	var day=dateArray[0];
	var month=Number(dateArray[1])-1;
	var year=dateArray[2];
	var jsDate=new Date(year, month, day);
	
	if(year!=jsDate.getFullYear()){
		return false;
	}
	else if(month!=jsDate.getMonth()){
		return false;
	}
	else if(day!=jsdate.getDay()){
		return false;
	}
	else 
		return true;
}