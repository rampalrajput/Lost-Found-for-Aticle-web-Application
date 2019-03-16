alert("lostSomethings js");
var itemName,itemPlace,itemCat,itemDate,itemDesc,file,itemReward,personName,mobile,otp;
  var respotp,x=0;
var itemdata;
var ajaxReq=new XMLHttpRequest();
$(document).ready(function()
{
    $("#otp").hide();
  $("#glycon").hide();

  $(document).on('click', '.follow', function() {
    
    if(!connect())
    {
         return;
     }
     else
     {
    $(this).removeClass('follow').addClass('unfollow');
      
 }   
});
$(document).on('click', '.unfollow', function() {
   
    submitdata();
  });
});
function validate ()
{
     itemName=$("#itemName").val();
    itemPlace=$("#itemPlace").val();
    itemCat=$("#itemCat").val();
    itemDate=$("#itemDate").val();
    itemDesc=$("#itemDesc").val();
    itemImg=$("#file").val();
    alert(" img"+ itemImg);
    itemReward=$("#itemReward").val();
    personName=$("#personName").val();
    mobile=$("#mobile").val();
   
    var status=true;
    if(itemName==="")
    {
       $("#sp1").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(itemPlace==="")
    {
       $("#sp2").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(itemDate==="")
    {
       $("#sp3").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(itemCat==="")
    {
       $("#sp4").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(itemDesc==="")
    {
       $("#sp5").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
   
    if(file==="")
    {
       $("#sp6").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(itemReward==="")
    {
       $("#sp7").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(personName==="")
    {
       $("#sp8").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
    }
    if(mobile==="")
    {
       $("#sp9").text("This fieid is required.").css("color","red").fadeOut(10000);
       status=false;  
   }
          return status;
       Upload();
    }
    
   function valid()
   {
       
    otp=$("#otp").val();
    var status1=true;
    if(otp==="")
    {
       $("#sp10").text("This fieid is required.").css("color","red").fadeOut(10000);
       status1=false;    
    }
    return status1;
   }
function connect() {
  if(!validate())
       {
           
           return;
         
       }
       else
       {
           x=1;
           otpgenerte();
        
      $("#otp").show();
      $("#glycon").show();
       Disabled();
       
        $('#lostbtn').attr("value","VERIFY OTP");
       
 
        return true;
   }
}
   function submitdata()
   { 
  // document.getElementById("#lostbtn").id="verifybtn";
   //document.getElementById("#lostbtn").setAttribute(" onClick","javascript : submit();");
  
   
  otp =$("#otp").val();
  
         if(!valid()) {
        
       return;
      }
    else{
 // alert("response"+respotp);
      
     if(respotp!==otp)
     {
           $("#otp").text("");
           $("#sp10").text("Invalid Otp.").css("color","red").fadeOut(10000);
           $("#otp").text("");
           return;
      }
      else
      {
          alert("otp matched");
      itemdata={ itemName: itemName,itemPlace:itemPlace,itemCat:itemCat,itemDate:itemDate,itemDesc:itemDesc,file:file,itemReward:itemReward,personName:personName, mobile: mobile}  ;
    alert(" itemdata"+itemdata); 
    var request=$.post("LostitemServlet",itemdata,processresponse);
     
 request.error(handleError);
     
           }
       }
   }
       function processresponse(responseText)
{
     var resp=responseText;
     resp=resp.trim();
    alert(" response text"+resp);
     if(resp.include("success"))
     {
       alert("Record insert Sucessfully in DB");
     }
     else
     {
         alert("Record are not inserted in DB");
     }
 }

function handleError(xhr,textStatus)    {
    
    if(textStatus==='error'){
        $("#lostbtn").html("Error is "+xhr.status);
    }
}
    
 
   function Disabled()
   {
    $("#itemName").prop("disabled",true);
    $("#itemPlace").prop("disabled",true);

    $("#itemCat").prop("disabled",true);

    $("#itemDate").prop("disabled",true);

    $("#itemDesc").prop("disabled",true);

    $("#file").prop("disabled",true);

    $("#itemReward").prop("disabled",true);

    $("#personName").prop("disabled",true);

    $("#mobile").prop("disabled",true);

   }
   
   function otpgenerte()
 {
      itemName=$("#itemName").val();
    itemPlace=$("#itemPlace").val();
    itemCat=$("#itemCat").val();
     itemDate=$("#itemDate").val();
     itemDesc =$("#itemDesc").val()   ;
     //itemImg=$("#file").val();
      itemReward=$("#itemReward").val();
     personName=$("#personName").val();
     mobile=$("#mobile").val();

 
 var mobilenumber = {mobile:mobile};
 var request=$.post("OtpServlet",mobilenumber,otpresponse);
 request.error(handleError);

}
function otpresponse(responseText)
{
     respotp=responseText;
     respotp=respotp.trim();
    alert("generted otp is "+respotp);
} 
function handleError(xhr,textStatus)
    {
    
    if(textStatus==='error'){
        $("#lostbtn").html("Error is "+xhr.status);
    }
}

function Upload(evt)
   {
     var tgt = evt.target || window.event.srcElement,
        files = tgt.files;

    // FileReader support
    if (FileReader && files && files.length) {
        var fr = new FileReader();
        fr.onload = function () {
            document.getElementById('upload').src = fr.result;
        }
        fr.readAsDataURL(files[0]);
    }
   }		