/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



function Orgpageselect()
{
    
    var className=document.getElementById("showList").className;
//    alert(className);
//    var className1=document.getElementById("create").className;
//    alert(className1);
    if(className=="show")
        {
            document.getElementById("showList").className="hide";
            document.getElementById("create").className="show";
            
        }
    else
        {
            document.getElementById("showList").className="show";
            document.getElementById("create").className="hide";
            
        }
    
}


function getPath()
{
   var path = document.location.pathname;
   return path;
}
function submitform()
{
  alert("Potakkkkkkkkkk");
 
  document.deleteform.submit();
}
function postwith (to) {
  var myForm = document.createElement("form");
  myForm.method="post" ;
  myForm.action = to ;
//  for (var k in p) {
//    var myInput = document.createElement("input") ;
//    myInput.setAttribute("name", k) ;
//    myInput.setAttribute("value", p[k]);
//    myForm.appendChild(myInput) ;
//  }
  document.body.appendChild(myForm) ;
  myForm.submit() ;
  document.body.removeChild(myForm) ;
}

//function PostAsJson()
//{
//    $(document).ready(function(){
//    alert('Potakkkkkkkkkkkkkkkk');
//    $('form').submit(function(e) {
//    e.preventDefault();
//    $.post($(this).attr("action"), $(this).serialize(), function(json) {
//        // handle response
//    }, "json");
//    });
//   });
//}


function isEmpty() {


//change "field1, field2 and field3" to your field names
strfield1 = document.forms[0].name.value
strfield2 = document.forms[0].uniqueShortName.value
strfield3 = document.forms[0].country.value

  //name field
    if (strfield1 == "" || strfield1 == null || !isNaN(strfield1) || strfield1.charAt(0) == ' ')
    {
    alert("\"name\" is a mandatory field.\nPlease amend and retry.")
    return false;
    }

  //url field
    if (strfield2 == "" || strfield2 == null || strfield2.charAt(0) == ' ')
    {
    alert("\"Unique Short name\" is a mandatory field.\nPlease amend and retry.")
    return false;
    }

  //title field
    if (strfield3 == "" || strfield3 == null || strfield3.charAt(0) == ' ')
    {
    alert("\"country\" is a mandatory field.\nPlease amend and retry.")
    return false;
    }
    return true;
}

function onmouse_over()
{
    document.getElementById(submit).onfocus();
        
}
