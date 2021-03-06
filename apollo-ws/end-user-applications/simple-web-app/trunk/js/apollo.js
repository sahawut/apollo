/*

    Copyright (C) 2011 University of Pittsburgh

    This file is part of Apollo.

    Apollo is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of
    the License, or (at your option) any later version.

    Apollo is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Apollo.  If not, see <http://www.gnu.org/licenses/>.

 */

/**
 * Base functions for apollo
 *
 * @author Yang Hu <yah14@pitt.edu>
 */

//----- global exchange area
//TODO : event communication?
//TODO : on tab destory
//TODO : js access control?
var dataExchange = new function(){
    this.tab_input = null;
    this.tab_return = null;
    this.model_urls = {};

    //for paramGrid
    this.gridId = '#west-grid';

    //for statusbar
    this.statusBar = '#status-div-3';
};

var diseaseExchange = new function(){
    this.tab_input = null;
    this.tab_return = null;

    //for paramGrid
    this.gridId = '#disease-grid';

};
//-----

//--- Global Var
var maintab;
var lastEditId;
var finishedSimulators;
var numSimulators;
var combinedRunId;
var combinedRunNumber;
var numberOfVisualizations;
var numberOfVisualizationsFinished;
var firstLinePrinted = true;
var simulatorListJson;

var InfluenzaId = 442696006;
var AnthraxId = 21927003;
//---

function clearParamGrid(){
    //unload grid first
    paramGrid = $(dataExchange.gridId);
    if (paramGrid.GridUnload)
        paramGrid.GridUnload();
    //get the empty div by id
    paramGrid = $(dataExchange.gridId);
	
    //hide the legend
    $('#param-legend').hide();
	
    //show the model selection img
    $('#select-img').show();
}
    
function addZero(n) {
        
    return n<10? '0'+n:''+n;
}

var isRowEditable = function(id) {
    
    if (id == 0 || id == 1 || id == 6 || id == 12 || id == 13 || id == 23 || id == 33 || id == 34 || id == 44 || id == 49) {
        return false
    } else {
        return true;
    }
}

var isRowBlue = function(id) {
    
    if (id == 0 || id == 6 || id == 12 || id == 49) {
        return true;
    } else {
        return false;
    }
}

var isRowTree = function(id) {
    
    if (id == 2 || id == 14 || id == 24 || id == 34 || id == 35 || id == 44) {
        return true;
    } else {
        return false;
    }
}

function loadParamGrid(){
    //clear up
    clearParamGrid();
        
    outerwidth=$('#west-div').width();
    
    var createRadioButtonChecked = function(value) {
        return $("<input type='radio' name='radio1' id='reactiveCm' checked />").get();
    }
    var createRadioButton = function(value) {
        return $("<input type='radio' name='radio1' id='fixedCm' />").get();
    }
    
    var extractFromRadioButton = function(elem) {
        return $(elem).val();
    }
    
    paramGrid.jqGrid({
        url: "simulation/apollo_param.php",
        editurl: "edit.php",//dummy edit url
        datatype: "json",
        height: "auto",
        pager: false,
        loadui: "disable",
        //cellEdit: true,
        colNames: ["id", "Parameter Name", "Value&nbsp;&nbsp;&nbsp;", "url", "extra",  "tooltip"],
        colModel: [
        {
            name: "id",
            width:0,
            hidden:true, 
            key:true
        },

        {
            name: "pname", 
            width:260, 
            resizable: false, 
            sortable:false
        },

        {
            name: "value", 
            width: 100, 
            resizable: false, 
            editable:true, 
            sortable: false,
            edittype:"text", 
            editoptions:{
                size:10,
                maxlength: 15
            }
        },
        {
            name: "url",
            width:0,
            hidden:true
        },

        {
            name: "extra",
            width:0,
            hidden:true
        },
        {
            name: "tooltip",
            width:0,
            hidden:true
        }
        ],
        treeGrid: true,
        treeGridModel: 'nested',
        caption: 'Simulator Configuration',
        ExpandColumn: "pname",
        autowidth: true,
        rowNum: 65,
        ExpandColClick: true,
        shrinkToFit: true,
        treeIcons: {
            leaf:'ui-icon-blank'
        },
        
        loadComplete: function(data){
            var rowIDs = jQuery("#west-grid").getDataIDs();
            //        $(".jqgrow").addClass("ui-state-hover").css("background", "none !important");
            for (var i=0;i<rowIDs.length;i=i+1){ 
                
                var cellData = $("#west-grid").jqGrid('getCell', i, 'tooltip');
                $("#west-grid").jqGrid('setCell', i,'pname','','',{
                    'title':cellData.toString().trim()
                });
               
                
                var trElement = jQuery("#"+ rowIDs[i],jQuery('#west-grid'));
        
                if (i==51) { // TIME STEP UNIT
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'select';
                    cm.editoptions = {
                        value: "loading:Loading...",
                        dataInit: function(elem) {
                            $(elem).width(75);  // set the width which you need
                        }
                    };
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
                //                if (i == 10) { // POPULATION LOCATION STATE
                //                    
                //                    var cm = paramGrid.jqGrid('getColProp','value');
                //                    cm.edittype = 'select';
                //                    cm.editoptions = {
                //                        value: "loading:Loading...",
                //                        dataInit: function(elem) {
                //                            $(elem).width(120);  // set the width which you need
                //                        },
                //                        dataEvents:
                //                        [
                //                        {
                //                            type: 'change',
                //                            fn: function(e) {
                // 
                //                                var stateVal = $("#10_value").val();
                //                                if (stateVal != 'select') {
                //                                    
                //                                    removeSelectStateItem();
                //                                    if (!checkStateOtherLocationValue(stateVal)) {
                //                                        var countyList = getCountyComboBoxValues(stateVal);
                //                                        changeCountyComboBoxValues(countyList, stateVal);
                //                                        $("#11_value").attr('disabled', false);
                //                                        
                //                                        // then update population if neccesary
                //                                        var countyVal = $("#11_value").val();
                //                                    //                                        changeDiseaseStateValues(countyVal)
                //                                    } else {
                //                                        clearCountyComboBoxValues();
                //                                        $("#11_value").attr('disabled', true);
                //                                    }
                //                                }
                //                            }
                //                        }
                //                        ]
                //                    };
                //                    paramGrid.jqGrid('editRow', i);
                //                    cm.edittype = 'text';
                //                    cm.editoptions = null;  
                //                }
                //                
                //                if (i == 11) { // POPULATION LOCATION COUNTY
                //                    
                //                    var cm = paramGrid.jqGrid('getColProp','value');
                //                    cm.edittype = 'select';
                //                    cm.editoptions = {
                //                        value: "loading:Loading...",
                //                        dataInit: function(elem) {
                //                            $(elem).width(120);  // set the width which you need
                //                        },
                //                        dataEvents:
                //                        [
                //                        {
                //                            type: 'change',
                //                            fn: function(e) {
                // 
                //                                var countyVal = $("#11_value").val();
                //                            //                                changeDiseaseStateValues(countyVal);
                //                            }
                //                        }
                //                        ]
                //                       
                //                    };
                //                    paramGrid.jqGrid('editRow', i);
                //                    cm.edittype = 'text';
                //                    cm.editoptions = null;  
                //                }
                
                if (i == 7) { // DISEASE
                    paramGrid.setCell(i, 'value', 
                        "<button type=\"button\" onclick=\"queryDatabaseAndCreateTab();\">Query database</button>");
                }
                
                if (i==27) { // VACCINATION NAMED PRIORITIZATION SCHEME
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'select';
                    cm.editoptions = {
                        value: "None:None;ACIP:ACIP;tpp:Described",
                        dataInit: function(elem) {
                            $(elem).width(88);  // set the width which you need
                        },
                        dataEvents:
                        [
                        {
                            type: 'change',
                            fn: function(e) {
 
                                var scheme = $("#37_value").val();
                                if (scheme == 'tpp') {
                                    var vaccDescriptionId = '#vacc-description';
                                    if ($(vaccDescriptionId).html() != null) {
                                        // select the tab
                                        maintab.tabs('select', vaccDescriptionId);
                                        //clear current tab content
                                        $(vaccDescriptionId).empty();
                                    } else {
                                        // create the tab
                                        maintab.tabs('add', vaccDescriptionId, 'Vaccination described prioritization scheme');
                                    }
                        
            
                                    // load the tab
                                    $(vaccDescriptionId, "#tabs").load('simulation/control_measures/vacc_described.html');
                                }
                            }
                        }
                        ]
                    };
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
                if (i==38) { // SCHOOL CLOSURE TARGET FACILITIES
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'select';
                    cm.editoptions = {
                        value: "all:All;individual:Individual",
                        dataInit: function(elem) {
                            $(elem).width(75);  // set the width which you need
                        }
                    };
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
                if (i == 47) { // SCHOOL CLOSURE TARGET FACILITIES
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'select';
                    cm.editoptions = {
                        value: "all:All",
                        dataInit: function(elem) {
                            $(elem).width(75);  // set the width which you need
                        }
                    };
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
                
                if (i == 14 || i == 24 || i ==34) {
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'checkbox';
                    cm.editoptions = {
                        value:"True:False"
                    };
                    
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
                if (i == 35 || i == 44) {
                    
                    var customElement;
                    if (i == 35) {
                        customElement = createRadioButtonChecked;
                    } else {
                        customElement = createRadioButton;
                    }
                    
                    var cm = paramGrid.jqGrid('getColProp','value');
                    cm.edittype = 'custom';
                    cm.editoptions = {
                        custom_element: customElement,
                        custom_value: extractFromRadioButton
                    };
                    
                    paramGrid.jqGrid('editRow', i);
                    cm.edittype = 'text';
                    cm.editoptions = null;
                }
                
            
                if (isRowBlue(i)) {
                    trElement.removeClass('ui-widget-content');
                    trElement.addClass('Color_Blue');
                }
            }
            
            loadTimeStepUnitValues();
           
            
            // open trees
            var rows = paramGrid.jqGrid('getRootNodes');
            for (var i = 0; i < rows.length; i++){
                if (i == 1) {
                    paramGrid.jqGrid('expandNode', rows[i]);
                    paramGrid.jqGrid('expandRow', rows[i]);
                }
            }
            
            
        },

        
        //        onSelectRow: function(rowid, iRow, iCol, e) { // open a new tab when double click
        //        
        //   
        //        
        //            if (isRowEditable(rowid  - 1)) {
        //                
        //                //                if (rowid == 9) {
        //                //                    $(this).jqGrid('editRow', rowid, true, null, null, null, {}, function (rowid) {
        //                //                  
        //                //                        var value = paramGrid.jqGrid('getCell',rowid,'value');
        //                //                        changeDiseaseStateValues(value);
        //                //                  
        //                //                    }); 
        //                //                }
        //                var treedata = $(this).getRowData(rowid);
        //	        
        //                //don't open a tab if the url is empty
        //                if (treedata.url == '' || treedata.url == null || treedata.url == undefined){
        //                    var extraLength = treedata.extra.length;
        //                    if (treedata.isLeaf === 'true'){
        //                        $(this).editRow(rowid, true);
        //                        lastEditId = rowid;
        //                    }
        //                } else {
        //                    var st = "#t" + treedata.id;
        //                    if($(st).html() != null ) {
        //                        maintab.tabs('select',st);
        //                    } else {
        //                        
        //                        var name = treedata.pname;
        //                        if (rowid == 17) { // DISEASE
        //                             name = "Stored disease values";
        //                        }
        //                        maintab.tabs('add', st, name);
        //                        $(st,"#tabs").load(treedata.url);
        //                    }
        //                }
        //            }
        //        },
        
        gridComplete: function(){
            //            //enable the button
            $('#create').button( "option", "disabled", false );
            $(dataExchange.gridId).setGridWidth($('#model-selection-div').innerWidth());
           
        //	
        //            //gird load finish
        //            $(dataExchange.statusBar).html('Load finished!');
        //			
        //            //enable the legend
        //            $('#param-legend').show();
        //			
        //            //hide the model selection img
        //            $('#select-img').hide();
        //            alert(outerwidth);
        },
        onSelectRow : function (rowid, status){

            //            paramGrid.jqGrid('resetSelection');
            if (rowid !== lastEditId && !isRowTree(rowid)) { // make sure row is not a tree or the value column will be affected
                paramGrid.jqGrid('saveRow', lastEditId, null, null, null, function(){
                    var value = paramGrid.jqGrid('getCell',lastEditId,'value');
                //                    changeDiseaseStateValues(value);    
                }, null, null);
                lastEditId = rowid;
            }
            
            if (isRowEditable(rowid  - 1)) {
                
                //                if (rowid == 9) {
                //                    $(this).jqGrid('editRow', rowid, true, null, null, null, {}, function (rowid) {
                //                  
                //                        var value = paramGrid.jqGrid('getCell',rowid,'value');
                //                        changeDiseaseStateValues(value);
                //                  
                //                    }); 
                //                }
                var treedata = $(this).getRowData(rowid);
	        
                //don't open a tab if the url is empty
                if (treedata.url == '' || treedata.url == null || treedata.url == undefined){
                    var extraLength = treedata.extra.length;
                    if (treedata.isLeaf === 'true'){
                        $(this).editRow(rowid, true);
                        lastEditId = rowid;
                    }
                } else {
                    var st = "#t" + treedata.id;
                    if($(st).html() != null ) {
                        maintab.tabs('select',st);
                    } else {
                        
                        var name = treedata.pname;
                        //                        if (rowid == 17) { // DISEASE
                        //                            name = "Previously specified diseases";
                        //                        }
                        maintab.tabs('add', st, name);
                        $(st,"#tabs").load(treedata.url);
                    }
                }
            }
        },
        
        beforeSelectRow: function(rowid, e) {
            return isRowEditable(rowid - 1);
        }
    });
    
    var orgExpandNode = $.fn.jqGrid.expandNode,
    orgCollapseNode = $.fn.jqGrid.collapseNode;
    $.jgrid.extend({
        expandNode: function (rc) {
            $(dataExchange.gridId).setGridWidth($('#model-selection-div').innerWidth());
            return orgExpandNode.call(this, rc);
        },
        collapseNode: function (rc) {
            $(dataExchange.gridId).setGridWidth($('#model-selection-div').innerWidth());
            return orgCollapseNode.call(this, rc);
        }
    });
    
};

//function loadQueryObjectDatabasePage() {
//    console.log('calling query objects page');
//    $.ajax({
//        type: "GET",
//        url: "simulation/query_objects.php?",
//
//        async: true, /* If set to non-async, browser shows page as "Loading.."*/
//        cache: false,
//        timeout:50000, /* Timeout in ms */
//
//        success: function(jasonObj, statusText){ /* called when request to barge.php completes */
//            
//
//        },
//        error: function(XMLHttpRequest, textStatus, errorThrown){
//            if (textStatus == 'timeout') {
//                addmsg("<b> ERROR: </b>" + "Could not call object query page. Please try again.");
//            //                }
//            //                                setTimeout(
//            //                                    poll, /* Try again after.. */
//            //                                    15000); /* milliseconds (15seconds) */
//            }
//        }
//    });
//}

function queryDatabaseAndCreateTab() {
    
    //create the ins tab
    var tabid = "#object-query";
	
    if($(tabid).html() != null ) {
        //select the tab
        maintab.tabs('select', tabid);
    } else {	
        maintab.tabs('add', tabid, 'Previously specified diseases');
    //load the ins tab
    }
    
    $(tabid, "#tabs").load("simulation/query_objects.php");
}

//function changeDiseaseStateValues(popLocationValue) {
//    
//    var pop;
//    if (popLocationValue.toLowerCase() == 'us') {
//        pop = 300000000;
//    } else if (popLocationValue == '42003') { // allegheny
//        pop = 1218494;
//    } else if (popLocationValue == '53003') { // king county, wa
//        pop = 1931249;
//    } else if (popLocationValue == '06037') { // la county, ca
//        pop = 9818605;
//    } else {
//        return;
//    }
//    
//    paramGrid.jqGrid('setCell',13,'value', Math.round((pop * 0.94859)).toString(), '');
//    paramGrid.jqGrid('setCell',14,'value', Math.round((pop * 0.00538)).toString(), '');
//    paramGrid.jqGrid('setCell',15,'value', Math.round((pop * 0.00603)).toString(), '');
//    paramGrid.jqGrid('setCell',16,'value', Math.round((pop * 0.04)).toString(), '');
//}

function loadTimeStepUnitValues() {
    var box = $("#51_value");
    box.empty();

    box.append($("<option selected></option>").attr("value", "day").text("day")); 
    box.append($("<option disabled></option>").attr("value", "hour").text("hour"));
    box.append($("<option disabled></option>").attr("value", "millisecond").text("millisecond"));
    box.append($("<option disabled></option>").attr("value", "minute").text("minute"));
    box.append($("<option disabled></option>").attr("value", "month").text("month"));
    box.append($("<option disabled></option>").attr("value", "second").text("second"));
    box.append($("<option disabled></option>").attr("value", "year").text("year"));
            
}

function resetEpiSimulatorSelection() {
    
    resetSimulatorList();
    loadStateComboBoxValues();
    stateComboBoxOnChange(false);
}

function loadStateComboBoxValues() {
    
    //    var returnString = "select:Select State;";
    $.ajax({
        type: "GET",
        url: "simulation/population/location_data_request.php?requestType=states",

        async: false, /* If set to non-async, browser shows page as "Loading.."*/
        cache: false,
        timeout:50000, /* Timeout in ms */

        success: function(jasonObj, statusText){ /* called when request to barge.php completes */

            var box = $("#state-select");
            box.empty();
            box.append($("<option></option>").attr("value", "select").text("Select State"));
            jasonObj = $.parseJSON(jasonObj);
            for (var v in jasonObj) {
                //                if (v == 'California') {
                //                    box.append($("<option selected></option>").attr("value", jasonObj[v]).text(v)); 
                //                } else {
                box.append($("<option></option>").attr("value", jasonObj[v]).text(v)); 
            //                }
            }
            
        //            for (var v in jasonObj) {
        //                returnString = returnString + jasonObj[v] + ":" + v + ";";
        //            }       
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            addmsg(textStatus + " (" + errorThrown + ")");
            setTimeout(
                poll, /* Try again after.. */
                15000); /* milliseconds (15seconds) */
        }
    });
}

function stateComboBoxOnChange(changeSimulators) {
    
    var stateVal = $("#state-select").val();
    if (stateVal != 'select') {
        var countyList = getCountyComboBoxValues(stateVal);
        changeCountyComboBoxValues(countyList, stateVal);
        $("#county-select").attr('disabled', false);

        if (changeSimulators) { 
            changeSimulatorsForLocation();
        }
    } else {
        // disable county box
        var box = $("#county-select");
        box.empty();
        box.append($("<option selected></option>").attr("value", "select").text("Select County"));
        $("#county-select").attr('disabled', true);
        
        if (changeSimulators) {
            resetSimulatorList();
        }
    }

}

function countyComboBoxOnChange() {
    
    var box = $("#county-select");
    var countyVal = box.val();
    console.log(countyVal);
    if (countyVal != 'select') {
        changeSimulatorsForLocation();
    }
}

function removeFluteFromSimulatorList() {
    // remove flute
    var model = $('#model-combo');	
    model.empty();
        
    for (var i=0; i <simulatorListJson.data.length; i++) {
            
        if (simulatorListJson.data[i].hasOwnProperty('softwareIdentification')) {
            var simName = simulatorListJson.data[i].softwareIdentification['softwareName'];
            if (simName != 'FluTE') {
                var simDev = simulatorListJson.data[i].softwareIdentification['softwareDeveloper'];

                var simVer = simulatorListJson.data[i].softwareIdentification['softwareVersion'];
                var softType = simulatorListJson.data[i].softwareIdentification['softwareType'];
                if (softType.toLowerCase() == 'simulator') {
                    model.append('<option value="' + encodeURIComponent(JSON.stringify(simulatorListJson.data[i])) + '">' + simDev + ',' + simName + ',' + simVer + '</option>');
                }
            }
        }
    }
}

function resetSimulatorList() {
    var model = $('#model-combo');	
    model.empty();
        
    for (var i=0; i <simulatorListJson.data.length; i++) {
            
        if (simulatorListJson.data[i].hasOwnProperty('softwareIdentification')) {
            var simName = simulatorListJson.data[i].softwareIdentification['softwareName'];
            var simDev = simulatorListJson.data[i].softwareIdentification['softwareDeveloper'];

            var simVer = simulatorListJson.data[i].softwareIdentification['softwareVersion'];
            var softType = simulatorListJson.data[i].softwareIdentification['softwareType'];
            if (softType.toLowerCase() == 'simulator') {
                model.append('<option value="' + encodeURIComponent(JSON.stringify(simulatorListJson.data[i])) + '">' + simDev + ',' + simName + ',' + simVer + '</option>');
            }
            
        }
    }
}

function changeSimulatorsForLocation() {
    
    var selectedState = $("#state-select").val();
    var selectedCounty = $("#county-select").val();
    
    if (selectedState != "06" || selectedCounty != "06037") {
        removeFluteFromSimulatorList();
    } else {
        resetSimulatorList();
    }
}

function changeLocationsForFlute() {
    
    var box = $("#state-select");
    box.empty();
    box.append($("<option></option>").attr("value", "06").text("California"));
    
    box = $("#county-select");
    box.attr('disabled', false);
    box.empty();
    box.append($("<option selected></option>").attr("value", "06037").text("Los Angeles County"));
}

function resetLocations() {
    
    // get current selected state
    var selectedState = $("#state-select").val();
    loadStateComboBoxValues();
    $("#state-select").val(selectedState);
    
    var box = $("#county-select");
    var selectedCounty = box.val();
    stateComboBoxOnChange(false);
    
    box.val(selectedCounty);
}

function getCountyComboBoxValues(state) {
    
    var returnString;
    $.ajax({
        type: "GET",
        url: "simulation/population/location_data_request.php?requestType=counties&state=" + state,

        async: false, /* If set to non-async, browser shows page as "Loading.."*/
        cache: false,
        timeout:50000, /* Timeout in ms */

        success: function(jasonObj, statusText){ /* called when request to barge.php completes */

            returnString = jasonObj;
            
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            addmsg(textStatus + " (" + errorThrown + ")");
            setTimeout(
                poll, /* Try again after.. */
                15000); /* milliseconds (15seconds) */
        }
    });
    
    return returnString;
}

function changeCountyComboBoxValues(jasonObj, state) {
        
    var box = $("#county-select");
    box.empty();
    jasonObj = $.parseJSON(jasonObj);
    box.append($("<option></option>").attr("value", 'entire-state-' + state).text("Entire State"));
    for (var v in jasonObj) {
        if (v != state + "000") {
            //            if (v == "06037") {
            //                box.append($("<option selected></option>").attr("value", v).text(jasonObj[v])); 
            //            } else {
            box.append($("<option></option>").attr("value", v).text(jasonObj[v])); 
        //            }
        }
        
    }
}

function removeSelectStateItem() {
    
    $("#10_value option[value='select']").remove();
}

function clearCountyComboBoxValues() {
    var box = $("#11_value");
    box.empty();
    box.append($("<option></option>").attr("value", "select").text("Select"));
}

function checkStateOtherLocationValue(value) {
    
    if (value == '42660') {
        return true;
    } else {
        return false;
    }
}

function epidemicModelSelectOnChange() {
    
    simulatorArray = $('#model-combo').val().toString().split(",");
     
    for (var i = 0; i < simulatorArray.length; i++) {
        //                    alert(simulatorArray[i]);
        var obj = $.parseJSON(decodeURIComponent(simulatorArray[i]));
        var simName = obj.softwareIdentification['softwareName'];
        if (simName == 'FluTE') {
            changeLocationsForFlute();
            return;
        }
    }
    
    resetLocations();
}

function createOrSelectInsturctionTab(){
    //add instruction tab
	
    //create the ins tab
    var insId = "#instruction";
	
    if($(insId).html() != null ) {
        //select the tab
        maintab.tabs('select', insId);
    } else {	
        maintab.tabs('add', insId, 'About');
        //load the ins tab
        $(insId, "#tabs").load('about.html');
    }
  
}

function createOrSelectPopulationTab() {
      
    var st = "#population";
    if($(st).html() != null) {
        maintab.tabs('select',st);
    } else {
        maintab.tabs('add', st, "Population Initialization");
        $(st,"#tabs").load("simulation/population/population_tree.php");
    }
}

function adjustMainDivSize(){
    var topHeight = $("#top").height();
    var footerHeight = $("#footer").height();
	
    //set the correct main height
    var winHeight = $(window).height();
    $('#main').height(winHeight - topHeight - footerHeight - 10);
}

//trigger the resize event make sure the whole web page to 100%
function bottomBlankFix(){
    $(window).trigger('resize');
}

function addmsg(msg){

    var date = new Date();
    msg = addZero(date.getHours()) + ":" + addZero(date.getMinutes()) + ":" + addZero(date.getSeconds()) + ': ' + msg;

    if (firstLinePrinted) {
        firstLinePrinted = false;
    } else {
        msg = '<br>' + msg;
    }
        
    msg = msg + '<span id="caret_pos_holder"></span>';
        
    // the span helps set the caret position to the end
    tinyMCE.get('statustextarea').selection.select(tinyMCE.get('statustextarea').dom.select('span#caret_pos_holder')[0]); //select the span
    tinyMCE.get('statustextarea').dom.remove(tinyMCE.get('statustextarea').dom.select('span#caret_pos_holder')[0]); //remove the span
       
    tinyMCE.get('statustextarea').selection.setContent(msg);
    //        var height = document.getElementById('statustextarea' + '_ifr').scrollHeight;
    //        console.log(height);
    tinyMCE.get('statustextarea').getWin().scrollTo(0, 1000000);


}

function loadRegisteredModels(){
    $.ajax({
        type: "GET",
        url: "registered_models.php",

        async: true, /* If set to non-async, browser shows page as "Loading.."*/
        cache: false,
        timeout:15000, /* Timeout in ms */

        success: function(jasonObj, statusText){ /* called when request to barge.php completes */

            //            alert(jasonObj);
            jasonObj = $.parseJSON(jasonObj);
            if (jasonObj.exception != null) {
                addmsg("<b> ERROR: </b>" + "Could not get registered simulators from Apollo service. Error was: " 
                    + jasonObj.exception);
                return;
            }
            simulatorListJson = jasonObj;
            
            var model = $('#model-combo');
            model.val('UNDEF');
            model.attr('disabled', '');
            //            //			
            model.empty();
            
            for (var i=0; i <jasonObj.data.length; i++) {
            
                if (jasonObj.data[i].hasOwnProperty('softwareIdentification')) {
                    var simDev = jasonObj.data[i].softwareIdentification['softwareDeveloper'];
                    var simName = jasonObj.data[i].softwareIdentification['softwareName'];
                    var simVer = jasonObj.data[i].softwareIdentification['softwareVersion'];
                    var softType = jasonObj.data[i].softwareIdentification['softwareType'];
                    if (softType.toLowerCase() == 'simulator') {
                        model.append('<option value="' + encodeURIComponent(JSON.stringify(jasonObj.data[i])) + '">' + simDev + ',' + simName + ',' + simVer + '</option>');
                    }
                }
            }
            
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            addmsg("<b> ERROR: </b>" + "Call to get registered models timed out. Trying again in 5 seconds...");
            setTimeout(
                loadRegisteredModels(), /* Try again after.. */
                5000); /* milliseconds (5seconds) */
        }
    });
}

function clearRegisteredModels() {
    
    var model = $('#model-combo');
    model.attr('disabled', 'disabled');
    model.empty();
    model.append('<option value="select">Please select a disease...</option>');

}

function getParamArray() {
    var grid = $(dataExchange.gridId);
                    
    var rowData = grid.getRowData(); 
    var timeStepUnit = $("#51_value").val(); // get the time step unit from the select
                
    // check population location
    var selectedState = $("#state-select").val();
    var selectedCounty = $("#county-select").val();
    var selectedLocation;
    if (selectedState == 'select') { // no state selected
        addmsg('<b>ERROR: </b>' + "No state selected for the population location");
        return null;
//    } else if (checkStateOtherLocationValue(selectedState)) { // other location selected
//        selectedLocation = selectedState;
    } else if (selectedCounty == "select") { // state selected but no county selected
        addmsg('<b>ERROR: </b>' + "No county selected for the population location");
        return null;
    } else if (selectedCounty == ('entire-state-' + selectedState)) {
        selectedLocation = selectedState;
    } else {
        selectedLocation = selectedCounty;
    }
                
    var vaccNamedPriScheme = $("#27_value").val();
    var useAvControlMeasure = $("#14_value").is(':checked');
    var useVaccControlMeasure = $("#24_value").is(':checked');
    var useSchoolClosure = $("#34_value").is(':checked');
    var scReactiveTargetFacilities = $("#38_value").val();
    var useSchoolReactiveCm = $("#35_value").is(':checked');
    var useSchoolFixedCm = $("#44_value").is(':checked');
    var scFixedTargetFacilities = $("#47_value").val();

    console.log('setting values');
    rowData[50]['value'] = timeStepUnit; // set the time step unit to store the value instead of html
    rowData[13]['value'] = useAvControlMeasure;
    rowData[23]['value'] = useVaccControlMeasure;
    rowData[26]['value'] = vaccNamedPriScheme;
    rowData[33]['value'] = useSchoolClosure;
    rowData[37]['value'] = scReactiveTargetFacilities;
    rowData[34]['value'] = useSchoolReactiveCm;
    rowData[43]['value'] = useSchoolFixedCm;
    rowData[46]['value'] = scFixedTargetFacilities;
    rowData[49]['value'] = selectedLocation;
                
    console.log('set values');
                
    // replace the rows with the same parameter name with an adjusted one
    rowData[14]['pname'] = 'Antiviral Control Measure Compliance';
    rowData[15]['pname'] = 'Antiviral Treatment Response Delay';
    rowData[16]['pname'] = 'Antiviral Treatment Fixed Start Time'
                   
    rowData[24]['pname'] = 'Vaccination Control Measure Compliance';
    rowData[25]['pname'] = 'Vaccination Response Delay';
    rowData[26]['pname'] = 'Vaccination Named Prioritization Scheme';
    rowData[27]['pname'] = 'Vaccination Fixed Start Time';
                
    rowData[35]['pname'] = 'School Closure Reactive Compliance';
    rowData[36]['pname'] = 'School Closure Reactive Response Delay';
    rowData[37]['pname'] = 'School Closure Reactive Target Facilities';
    rowData[38]['pname'] = 'School Closure Reactive Duration';
                
    rowData[44]['pname'] = 'School Closure Fixed Compliance';
    rowData[45]['pname'] = 'School Closure Fixed Response Delay';
    rowData[46]['pname'] = 'School Closure Fixed Target Facilities';
    rowData[47]['pname'] = 'School Closure Fixed Duration';
    rowData[48]['pname'] = 'School Closure Fixed Start Time';
    rowData[49]['pname'] = 'Population Location';
                
    return rowData;
}

jQuery(document).ready(function(){
    //    var jur = $('#jurisdiction-combo');
    //    jur.val('UNDEF');
        
    //    $('#disease-combo').change(function(){
    //        var diseaseName = this.options[this.selectedIndex].value;
    //        if (diseaseName != 'select') {
    //            loadRegisteredModels();  
    //        } else {
    //            clearRegisteredModels();
    //        }
    //    })
	
    //    var model = $('#model-combo');

    loadParamGrid();
    loadRegisteredModels();
    // load location data
    loadStateComboBoxValues();
    //    var stateVal = $("#state-select").val();
    //    var countyList = getCountyComboBoxValues(stateVal);
    //    changeCountyComboBoxValues(countyList, stateVal);
    $("#county-select").attr('disabled', true);
        
    //adjust the main content div size
    adjustMainDivSize();
    //TODO I don't know why there will exist some blank at the bottom
    setTimeout("bottomBlankFix()", 50);

    //If the User resizes the window, adjust the #container height
    $(window).resize(adjustMainDivSize);

    //layout splitter
    $('#main').layout({
        resizerClass : 'ui-state-default',
        west__size : $('body').innerWidth() * 0.29, //width for the left panel
        west__resizable : true,
        west__closable : false,
        south__resizable : true,
        south__closable : false,
        west__onresize: function (pane, $Pane) {
            $(dataExchange.gridId).setGridWidth($('#model-selection-div').innerWidth());
        },
        south__onresize: function (pane, $Pane) {
            // the following will resize the status area
            var height = $('#south-div').innerHeight();
            var ifrheight = height - 130;
            var tblheight = height - 130;
            $('#statustextarea'+'_ifr').css('height', ifrheight + 'px');
            $('#statustextarea'+'_tbl').css('height', tblheight + 'px');
        }
    });
    //$.jgrid.defaults = $.extend($.jgrid.defaults,{loadui:"enable"});

    //center panel
    maintab = $('#tabs','#CenterPane').tabs({
        cache: false,
        add: function(e, ui) {
            // append close thingy
            $(ui.tab).parents('li:first')
            .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="Close Tab"></span>')
            .find('span.ui-tabs-close')
            .click(function() {
                maintab.tabs('remove', $('li', maintab).index($(this).parents('li:first')[0]));
            });
            // select just added tab
            maintab.tabs('select', '#' + ui.panel.id);
        },
        select: function(e, ui) {
            var tabname = ui.tab.text;
            runMethod(tabname);
        }
    });
    
    function clearTabs() {
        for (var i = $('#tabs','#CenterPane').tabs('length') - 1; i >= 1; i--) {
            $('#tabs','#CenterPane').tabs('remove', i);
        }
    }
    
    function runMethod(tabindex) {
        
        switch (tabindex) {
            
            case "Disease states over time":
                $("#result", "#tabs").load('result.html');
                break;

            case "Incidence over time":
                $("#incidence", "#tabs").load('incidence.html');
                break;
                
            default:
                break;
        }
    };
    
    function getConfigurationFileForRun(runId, simName, simDev, simVer, runNumber) {
                
        var tabid;
        runNumber = runNumber.toString();
  
        if (runNumber.indexOf(" and ") !== -1) {
            var splitRunNumber = runNumber.split(" and ");
            tabid = "#formatted-text-" + simName + "-" + splitRunNumber[1]; // tab ids can't use commas
              
        } else {
            tabid = "#formatted-text-" + simName + "-" + runNumber; // tab ids can't use commas
 
        }
        tabid = tabid.replace(/\./g, "-"); // can't use periods
                    
        if($(tabid).html() != null ) {
            //select the tab
            maintab.tabs('select', tabid);
            //clear current tab content
            $(tabid).empty();
        } else {
            //create the tab
                              
            maintab.tabs('add', tabid, simName + ' run ' +  runNumber + ': Configuration file');
        }
      
        $(tabid, "#tabs").load('configuration_file_text.php?modelIndex=' + encodeURIComponent(runId) + "&runId=" + encodeURIComponent(runId)
            + "&dev=" + simDev + "&name=" + simName + "&ver=" + simVer);

    }
    
    function loadFluteResultsFile(runId) {
        
        var md5RunId = calcMD5(runId);
        var tabid = "#flute-result-file"; // tab ids can't use commas
        
        if($(tabid).html() != null ) {
            //select the tab
            maintab.tabs('select', tabid);
            //clear current tab content
            $(tabid).empty();
        } else {
            //create the tab
            maintab.tabs('add', tabid,'FluTE: Results summary');
        }
        
        $(tabid, "#tabs").load('flute_results.php?md5RunId=' + md5RunId);
    }
    
    function startVisualization(runId, simName, runNumber, vizDev, vizName, vizVer, location) {
        
        $.ajax({
            type: "GET",
            url: "visualization/exec_visualization.php?runId=" + runId + "&vizDev=" + vizDev + "&vizName=" + vizName + "&vizVer=" + vizVer + "&location=" + location,

            async: true, /* If set to non-async, browser shows page as "Loading.."*/
            cache: false,
            timeout:50000, /* Timeout in ms */

            success: function(jasonObj, statusText){ /* called when request to barge.php completes */
                jasonObj = $.parseJSON(jasonObj);
                
                var exception = jasonObj.exception;
                //                if (exception != null) {
                
                var urls = jasonObj.data['urls'];
                var dev = jasonObj.data['visualizerDeveloper'];
                var name = jasonObj.data['visualizerName'];
                var ver = jasonObj.data['visualizerVersion'];
                runId = jasonObj.data['runId'];

                waitForVisualizations(runId, dev, name, ver, urls, simName, runNumber, vizName, location);

            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                if (textStatus == 'timeout') {
                    addmsg("<b> ERROR: </b>" + "Could not call run on " + vizName + ", please run epidemic simulator again.");
                //                }
                //                                setTimeout(
                //                                    poll, /* Try again after.. */
                //                                    15000); /* milliseconds (15seconds) */
                }
            }
        });
    }
    
    function waitForVisualizations(runId, dev, name, ver, urls, simName, runNumber, vizName, location) {
        
        $.ajax({
            type: "GET",
            url: "poller.php?runId=" + runId + "&dev=" + dev + "&name=" + name + "&ver=" + ver + "&type=visualization",

            async: true, /* If set to non-async, browser shows page as "Loading.."*/
            cache: false,
            timeout:50000, /* Timeout in ms */

            success: function(jasonObj, statusText){ /* called when request to barge.php completes */
                jasonObj = $.parseJSON(jasonObj);
                //                alert(jasonObj);
                var status = jasonObj.data['status_normal'];
                var message = jasonObj.data['message_normal'];
                
                addmsg("<b> VISUALIZER: </b><i>" + vizName + " </i><b>RUN ID: </b><i>" + runId  + " </i><b>VISUALIZER STATUS: </b><i>" + status  + " </i><b>MESSAGE: </b><i>" + message + "</i>"); /* Add response to a .msg div (with the "new" class)*/

                if (status != 'completed') {
                    setTimeout(
                        function() {
                            waitForVisualizations(runId, dev, name, ver, urls, simName, runNumber, vizName, location)
                        }, /* Request next message */
                        5000 /* ..after 1 seconds */
                        );
                } else {

                    numberOfVisualizationsFinished += 1;
                    var urlList = new Object();
                    for (var key in urls) {
                        
                        if (key == 'Disease states') {
                            urlList.disease_states = urls[key];
                        } else if (key == 'Incidence' || key == 'Combined incidence') {
                            urlList.incidence = urls[key];
                        } else {
                            urlList.gaia = urls[key];
                        }
                        
                    }
                    
                    var encUrls = JSON.stringify(urlList);

                    if (numberOfVisualizationsFinished == numberOfVisualizations) { // enable the button when the last visualization finishes
                        //enable the button
                        $('#create').button( "option", "disabled", false );
                    }

                    // need an index which is unique to the run and the visualizer
                    var index = runId.toString() + "v" + vizName;
                    dataExchange.model_urls[index] = encUrls;

                    // get run number

                    //create or select the tab for the result
                    var resultID;
                    runNumber = runNumber.toString();
                    var diseaseStatesRunNumber;
                    if (runNumber.indexOf(" and ") !== -1) {
                        var splitRunNumber = runNumber.split(" and ");
                        resultID = "#result-" + simName + "-" + splitRunNumber[1]; // tab ids can't use commas
                        diseaseStatesRunNumber = splitRunNumber[1];
                    } else {
                        resultID = "#result-" + simName + "-" + runNumber; // tab ids can't use commas
                        diseaseStatesRunNumber = runNumber;
                    }
                    
                    resultID = resultID.replace(/\./g, "-"); // can't use periods
                            
                    var incidenceID = "#incidence-" + simName + "-" + runNumber.replace(/ and /g, "");
                    incidenceID = incidenceID.replace(/\./g, "-"); // can't use periods
                    
                    var gaiaID = "#gaia-" + simName + "-" + runNumber;
                    gaiaID = gaiaID.replace(/\./g, "-"); // can't use periods
                    
                    var combinedIncidenceID = "#combined-incidence" + "-" + combinedRunNumber.replace(/ and /g, "");
                    combinedIncidenceID = combinedIncidenceID.replace(/\./g, "-"); // can't use periods

                    for (key in urls) {
                        
                        if (key == 'Disease states') {
                            
                            if (simName != 'FluTE') { // flute doesn't support disease state state charts right now
                            
                                if($(resultID).html() != null ) {
                                    //select the tab
                                    maintab.tabs('select', resultID);
                                    //clear current tab content
                                    $(resultID).empty();
                                } else {
                                    //create the tab
                                    maintab.tabs('add', resultID, simName + ' run ' +  diseaseStatesRunNumber + ': Disease states over time');
                                }
                    
                                //load the tab
                                //                            console.log(encodeURIComponent(runId));
                                $(resultID, "#tabs").load('visualization/disease_states.php?index=' + encodeURIComponent(index));
                            }
                        } else if (key == 'Incidence') {
                            if ($(incidenceID).html() != null) {
                                // select the tab
                                maintab.tabs('select', incidenceID);
                                //clear current tab content
                                $(incidenceID).empty();
                            } else {
                                // create the tab
                                maintab.tabs('add', incidenceID, simName + ' run ' + runNumber + ': Incidence over time');
                            }
                        
            
                            // load the tab
                            $(incidenceID, "#tabs").load('visualization/incidence.php?index=' + encodeURIComponent(index));
                        } else if (key == 'Combined incidence') {
                            if ($(combinedIncidenceID).html() != null) {
                                // select the tab
                                maintab.tabs('select', combinedIncidenceID);
                                //clear current tab content
                                $(combinedIncidenceID).empty();
                            } else {
                                // create the tab
                                maintab.tabs('add', combinedIncidenceID, 'Runs ' + combinedRunNumber + ': Incidence over time');
                            }
                        
            
                            // load the tab
                            $(combinedIncidenceID, "#tabs").load('visualization/incidence.php?index=' + encodeURIComponent(index));
                        }
                    
                        if ((simName == 'FRED' || simName == 'FluTE') && key.indexOf('GAIA') !== -1) {
                            if($(gaiaID).html() != null ) {
                                //select the tab
                                maintab.tabs('select', gaiaID);
                                //clear current tab content
                                $(gaiaID).empty();
                            } else {
                                //create the tab
                                maintab.tabs('add', gaiaID, simName + ' ' + runNumber + ': GAIA Visualization for Simulation');
                            }

                            //load the tab
                            $(gaiaID, "#tabs").load('visualization/gaia.php?index=' + encodeURIComponent(index) + '&location=' + location);
                        }
                 
                    }
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                if (textStatus == 'timeout') {
                    addmsg("<b> ERROR: </b>" + "Could not call getStatus on " + vizName + ", retrying in 5 seconds.");
                    setTimeout(
                        function() {
                            waitForVisualizations(runId, dev, name, ver, urls, simName, runNumber, vizName)
                        }, /* Request next message */
                        5000 /* ..after 1 seconds */
                        );
                }
            }
        });
        

    }
    
    function waitForSimulationsAndStartVisualizations(obj, runNumber, location) {
        
        var runId = obj['runId'];
        var simDev = obj['simulatorDeveloper'];
        var simName = obj['simulatorName'];
        var simVer = obj['simulatorVersion'];
        
        /* This requests the url "msgsrv.php"
        When it complete (or errors)*/
        $.ajax({
            type: "GET",
            url: "poller.php?runId=" + runId + "&dev=" + simDev + "&name=" + simName + "&ver=" + simVer + "&type=simulator",

            async: true, /* If set to non-async, browser shows page as "Loading.."*/
            cache: false,
            timeout:50000, /* Timeout in ms */

            success: function(jasonObj, statusText){ /* called when request to barge.php completes */
                jasonObj = $.parseJSON(jasonObj);
                var status_norm = jasonObj.data['status_normal'];
                var status_novacc = jasonObj.data['status_novacc'];
                var message_norm = jasonObj.data['message_normal'];
                var message_novacc = jasonObj.data['message_novacc'];
                
                
                if (status_novacc == 'null') {
                    addmsg("<b> SIMULATOR: </b><i>" + simName + "</i>" + " <b>RUN ID: </b><i>" + runId +  " </i><b>SIMULATOR STATUS: </b><i>" + status_norm  + " </i><b>MESSAGE: </b><i>" + message_norm + "</i>"); /* Add response to a .msg div (with the "new" class)*/
                } else {
                    var noVaccId = runId.split(";")[0];
                    var vaccId = runId.split(";")[1];
                    addmsg("<b> SIMULATOR: </b><i>" + simName + " </i><b>RUN ID: </b><i>" + noVaccId + " </i><b>SIMULATOR STATUS: </b><i>" + status_norm  + " </i><b>MESSAGE: </b><i>" + message_norm + "</i>"); /* Add response to a .msg div (with the "new" class)*/
                    addmsg("<b> SIMULATOR: </b><i>" + simName + " </i><b>RUN ID: </b><i>" + vaccId + " </i><b>SIMULATOR STATUS: </b><i>" + status_novacc  + " </i><b>MESSAGE: </b><i>" + message_novacc + "</i>"); /* Add response to a .msg div (with the "new" class)*/
                }
                
                if (status_norm != 'completed' || (status_novacc != 'null' && status_novacc != 'completed')) {
                    setTimeout(
                        function() {
                            waitForSimulationsAndStartVisualizations(obj, runNumber, location)
                        }, /* Request next message */
                        5000 /* ..after 1 seconds */
                        );
                } else {
                    finishedSimulators++;
                   
                    getConfigurationFileForRun(runId, simName, simDev, simVer, runNumber); 

                    // flute will only return an incidence chart
                    startVisualization(runId, simName, runNumber, 'nick', 'Image Visualizer', '1.0', location);

                    if (simName == 'FluTE') {
                        loadFluteResultsFile(runId); 
                    }

                    // flute only produces output by region for LA county
                    if (simName == 'FRED' || (simName == 'FluTE' && location == '06037')) {
                        if (runId.indexOf(";") !== -1) {
                            var runIds = runId.split(";");
                            var runNumbers = runNumber.split(" and ");
                            startVisualization(runIds[0], simName, runNumbers[1], 'PSC', 'GAIA', '1.0', location);
                            startVisualization(runIds[1], simName, runNumbers[0], 'PSC', 'GAIA', '1.0', location);
                        } else {
                            startVisualization(runId, simName, runNumber, 'PSC', 'GAIA', '1.0', location);
                        }
                    }
                                    
                    if (finishedSimulators == numSimulators && numberOfVisualizations == 0) {
                        $('#create').button( "option", "disabled", false );
                    }
                     
               
                    if (numSimulators > 1 && finishedSimulators == numSimulators) { // now all simulators have finished
                        startVisualization(combinedRunId, 'All simulators', numSimulators + 1, 'nick', 'Image Visualizer', '1.0', location);
                    }
                 
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                //                addmsg(textStatus);
                if (textStatus == 'timeout') {
                    addmsg("<b> Error: </b>" + "Could not call getStatus on " + simName + ", retrying in 5 seconds.");
                    setTimeout(
                        function() {
                            waitForSimulationsAndStartVisualizations(obj, runNumber)
                        }, /* Request next message */
                        5000 /* ..after 1 seconds */
                        );
                }
            }
        });
        
    }
	

    // bind form using ajaxForm
    $('#apollo-form').ajaxForm({
        // target identifies the element(s) to
        // update with the server response
        // target: '#apollo-chart',
        // dataType identifies the expected
        // content type of the server response
        dataType : 'json',
        timeout:50000, /* Timeout in ms */

        beforeSubmit : function(formData, jqForm, options) {
            //put the parameters value here
            
            try{
                var simulatorArray;
    
                if ($('#model-combo').val() == null) {
                    addmsg('<b>ERROR:</b> No epidemic simulator is selected');
                    return false;
                } else {
                    simulatorArray = $('#model-combo').val().toString().split(",");
                }
                
                clearTabs();
                // get the current tree grid data
                var rowData = getParamArray();
                if (rowData == null) {
                    // then there was an error already reported, so return
                    return false;
                }
                
                var exportData = JSON.stringify(rowData);
                var snomed = $('#snomed-ct-combo').val();
            
                
                var simDev = '';
                var simName = '';
                var simVer = '';
                
                for (var i = 0; i < simulatorArray.length; i++) {
                    //                    alert(simulatorArray[i]);
                    var obj = $.parseJSON(decodeURIComponent(simulatorArray[i]));
                    simDev += "," + encodeURIComponent(obj.softwareIdentification['softwareDeveloper']);
                    simName += "," + encodeURIComponent(obj.softwareIdentification['softwareName']);
                    simVer += "," + encodeURIComponent(obj.softwareIdentification['softwareVersion']);
                }
                
                dataExchange.model_urls = new Array();
                
                simDev = simDev.substring(1);
                simName = simName.substring(1);
                simVer = simVer.substring(1);

                // push the data to the server
                formData.push({
                    name : 'SNOMED',
                    value : snomed
                },{
                    name : 'Parameters',
                    value : exportData
                },{
                    name : 'simulatorDeveloper',
                    value : simDev
                },{
                    name : 'simulatorName',
                    value : simName
                },{
                    name : 'simulatorVersion',
                    value : simVer
                });

                // set the waiting feedback
                $('#create').button( "option", "disabled", true );
                //                $(dataExchange.statusBar).html('Waiting for the server response..');

                addmsg("Sending simulator requests to the Apollo service...");

                return true;
            }catch (err){
                // set the error message
                addmsg("<b> ERROR: </b> There was an error getting the data to submit to the Apollo service: " + err);
                return false;
            }

        },


        // success identifies the function to
        // invoke when the server response
        // has been received;
        success : function(jasonObj, statusText) {

            if (statusText != 'success') {// web server error
                addmsg("<b> ERROR: </b> There was an error submitting the data to the Apollo service; returned status was " + statusText);
                return;
            } else {           
                addmsg("The simulator requests were successfully submitted to the Apollo service.");
            }
            
            // handle apollo service exceptions here
            // these simulators won't be contained in the run IDs list
            for (var simulator in jasonObj.data.failedSimulators) {
                addmsg("<b> APOLLO SERVICE ERROR: </b>" + "Could not call run simulation for simulator " + simulator 
                    + "; error message was: " + jasonObj.data.failedSimulators[simulator]);
            }


            numSimulators = jasonObj.data.runIds.length;
            if (numSimulators == 0) {
                $('#create').button( "option", "disabled", false ); // reset the button
                return; // there were no simulators to run (all calls to runSimulation failed)
            }
            
            finishedSimulators = 0;
            numberOfVisualizations = 0;
            numberOfVisualizationsFinished = 0;
            var allRunIds = '';
            var allRunNums = '';
            
            if (numSimulators > 1) {
                numberOfVisualizations += 1; // one for the combined incidence
            }

            for (var i = 0; i < numSimulators; i++) {

                var simulatorObj = jasonObj.data.runIds[i];
                
                var runId = simulatorObj['runId'];
                
                var runNumber = '';  
                if (runId.indexOf(";") !== -1) {
                    // multiple control measure run
                    var runs = runId.split(";");
                    var splitRunId1 = runs[0].split("_");
                    var splitRunId2 = runs[1].split("_");
                    runNumber = splitRunId2[splitRunId2.length - 1].trim() + ' and ' + splitRunId1[splitRunId1.length - 1].trim();
                } else {
                    var splitRunId =   runId.split("_");
                    runNumber = splitRunId[splitRunId.length - 1];
                }
                       
               
                var simName = simulatorObj['simulatorName'];
                
               
                
                // flute can create an incidence chart now, but not disease states
                //                if (simName != 'FluTE') { // flute has no visualizations and shouldn't be in the combined variables
                    
                allRunIds += ':' + runId;
                allRunNums += ' and ' + runNumber;
                numberOfVisualizations += 1;
                //                }
                
                var location = simulatorObj['location'];
                // flute can only store regional data for LA county
                if (simName == 'FRED' || (simName == 'FluTE' && location == '06037')) {
                    if (runId.indexOf(";") !== -1) {
                        numberOfVisualizations += 2; // two for gaia (one with control measure, one without)
                    } else {
                        numberOfVisualizations += 1; // one for gaia
                    }
                }

                waitForSimulationsAndStartVisualizations(simulatorObj, runNumber, location);
            }

            combinedRunId = allRunIds.substring(1);
            combinedRunNumber = allRunNums.substring(5);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){

            if (textStatus == 'timeout') { 
                addmsg("<b> ERROR: </b>" + "Could not call run for simulators, please run epidemic simulators again.");
            //                setTimeout(
            //                    poll, /* Try again after.. */
            //                    15000); /* milliseconds (15seconds) */
            }
        }
    });

    //style the submit button
    $('#create').button({
        disabled : true //enable until everything is ready
    });
});