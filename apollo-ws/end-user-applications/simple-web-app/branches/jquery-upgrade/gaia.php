<?php
$modelIndex = $_GET['index'];
?>
<script type="text/javascript" src="js/array.js"></script>

<script type="text/javascript">
    try{
           
        var webservice_result = $.parseJSON(dataExchange.model_urls[<?php print $modelIndex; ?>]);

        var url = webservice_result.gaia;
        
        document.getElementById("gaia-div-<?php print $modelIndex; ?>").innerHTML="<video controls> <source src='" + url + "' type=video/ogg></video>";
        
    }catch (err){
        alert(err);
    }
    
</script>
<div style="text-align: center; font-family: Segoe UI, Arial, sans-serif; font-size: 25px">GAIA Epidemic Visualization of Influenza in 42003</div>

<div id="gaia-div-<?php print $modelIndex; ?>">

<!--    <video controls> -->
<!--  <source src=http://techslides.com/demos/sample-videos/small.webm type=video/webm> -->
<!--        <source src=http://warhol-fred.psc.edu/test1.ogg type=video/ogg> -->
      <!--    <source src=http://localhost:8070/videos/Chrome_ImF.mp4 type=video/mp4>-->
      <!--  <source src=http://techslides.com/demos/sample-videos/small.3gp type=video/3gp>-->
<!--    </video> -->

</div>
