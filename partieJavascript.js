//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

function recupererPremierEnfantDeTypeElement(n) {
    var x = n.firstChild;
    while (x.nodeType != 1) { // Test if x is an element node (and not a text node or other)
        x = x.nextSibling;
    }
    return x;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Change the content of the element with the ID "nom" with the string provided as a parameter
function showNameOnPage(new_name) {
    var htmlParentElementOfTheName = window.document.getElementById("id_name_to_replace");
    htmlParentElementOfTheName.innerHTML = new_name;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Load the XML file located at the given relative URL and return it. Asynchrone function 
// (deprecated but simple to use)
function loadHTTPXML(xmlDocumentUrl) {

    var httpAjax;

    httpAjax = window.XMLHttpRequest ?
        new XMLHttpRequest() :
        new ActiveXObject('Microsoft.XMLHTTP');

    if (httpAjax.overrideMimeType) {
        httpAjax.overrideMimeType('text/xml');
    }

    // Load the XML file using a synchronous XMLHttpRequest (the 3rd parameter is set to false)
    httpAjax.open('GET', xmlDocumentUrl, false);
    httpAjax.send();

    return httpAjax.responseXML;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
// Load the JSON file located at the given URL and return it
function chargerHttpJSON(jsonDocumentUrl) {

    var httpAjax;

    httpAjax = window.XMLHttpRequest ?
        new XMLHttpRequest() :
        new ActiveXObject('Microsoft.XMLHTTP');

    if (httpAjax.overrideMimeType) {
        httpAjax.overrideMimeType('text/xml');
    }

    // Load the JSON file using a synchronous XMLHttpRequest (the 3rd parameter is set to false)
    httpAjax.open('GET', jsonDocumentUrl, false);
    httpAjax.send();

    var responseData = eval("(" + httpAjax.responseText + ")");

    return responseData;
}


function login(email, mdp) {

    $.post("ActionServlet?todo=connexion",
        {
            mail: email,
            password: mdp
        }
    )
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Bouton2_ajaxEmployees(xmlDocumentUrl) {

    var xmlDocument = loadHTTPXML(xmlDocumentUrl);

    // Extract names from the XML document (using a stylesheet or JavaScript)
    var theNames = xmlDocument.getElementsByTagName("LastName");

    // Iterate through the list of names using a for loop and 
    // construct a string containing the names separated by spaces 
    // To get the length of a list: use the 'length' attribute
    // Access the text of a "LastName" node: NODE_NAME.firstChild.nodeValue
    var stringWithNames = "";
    for (i = 0; i < theNames.length; i++) {
        if (i > 0) {
            stringWithNames = stringWithNames + ", ";
        }
        stringWithNames = stringWithNames + theNames[i].firstChild.nodeValue + " ";
    }

    // Call (or copy) the function showNameOnPage(...) or use another method to modify the text of the "span" element
    showNameOnPage(stringWithNames);
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Bouton3_ajaxBibliographie(xmlDocumentUrl, xslDocumentUrl) {

    // Load the XSL file using a synchronous XMLHttpRequest
    var xslDocument = loadHTTPXML(xslDocumentUrl);

    // Create an XSL processor
    var xsltProcessor = new XSLTProcessor();

    // Import the .xsl file
    xsltProcessor.importStylesheet(xslDocument);

    // Load the XML file using a synchronous XMLHttpRequest
    var xmlDocument = loadHTTPXML(xmlDocumentUrl);

    // Create the XML document transformed by XSL
    var newXmlDocument = xsltProcessor.transformToDocument(xmlDocument);

    // Find the parent (whose ID is "here") of the element to be replaced in the current HTML document
    var elementHtmlParent = window.document.getElementById("id_element_to_replace");

    // Insert the transformed element into the HTML page
    elementHtmlParent.innerHTML = newXmlDocument.children[0].innerHTML;

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Bouton4_ajaxBibliographieAvecParametres(xmlDocumentUrl, xslDocumentUrl, paramXSL_type_reference) {

    // Load the XSL file using a synchronous XMLHttpRequest
    var xslDocument = loadHTTPXML(xslDocumentUrl);

    // Create an XSL processor
    var xsltProcessor = new XSLTProcessor();

    // Import the .xsl file
    xsltProcessor.importStylesheet(xslDocument);

    // Pass the parameter to the stylesheet
    xsltProcessor.setParameter("", "param_bibliographicalref_type", paramXSL_type_reference);

    // Load the XML file using a synchronous XMLHttpRequest
    var xmlDocument = loadHTTPXML(xmlDocumentUrl);

    // Create the XML document transformed by XSL
    var newXmlDocument = xsltProcessor.transformToDocument(xmlDocument);

    // Find the parent (whose ID is "here") of the element to be replaced in the current HTML document
    var elementHtmlParent = window.document.getElementById("id_element_to_replace");

    // Insert the transformed element into the HTML page
    elementHtmlParent.innerHTML = newXmlDocument.children[0].innerHTML;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function Bouton4_ajaxEmployeesTableau(xmlDocumentUrl, xslDocumentUrl) {
    // Comment out the following line that displays the dialog box!
    alert("Function to be completed...");
}

function Bouton5_changeBgColor() {
    document.body.style.backgroundColor = "blue";
    document.getElementById("myButton5").style.color = "#ffffff";
}

function Bouton6_resetBgColor() {
    document.body.style.backgroundColor = "white";
}

function Bouton7_ajaxPaysAvecParametres(xmlDocumentUrl, xslDocumentUrl, paramXSL_type_reference) {

    // Load the XSL file using a synchronous XMLHttpRequest
    var xslDocument = loadHTTPXML(xslDocumentUrl);

    // Create an XSL processor
    var xsltProcessor = new XSLTProcessor();

    // Import the .xsl file
    xsltProcessor.importStylesheet(xslDocument);

    // Pass the parameter to the stylesheet
    xsltProcessor.setParameter("", "country_code", paramXSL_type_reference);

    // Load the XML file using a synchronous XMLHttpRequest
    var xmlDocument = loadHTTPXML(xmlDocumentUrl);

    // Create the XML document transformed by XSL
    var newXmlDocument = xsltProcessor.transformToDocument(xmlDocument);

    // Find the parent (whose ID is "here") of the element to be replaced in the current HTML document
    var elementHtmlParent = window.document.getElementById("id_element_to_replace");

    // Insert the transformed element into the HTML page
    elementHtmlParent.innerHTML = newXmlDocument.children[0].innerHTML;
}

function Bouton8_loadsvg() {
    var svg = loadHTTPXML('worldHigh.svg');

    const s = new XMLSerializer();

    const str = s.serializeToString(svg);

    // Find the parent (whose ID is "here") of the element to be replaced in the current HTML document
    var elementHtmlParent = window.document.getElementById("id_element_to_replace");

    // Insert the transformed element into the HTML page
    elementHtmlParent.innerHTML = str;
}

function Bouton9_make_svg_clickable() {
    document.getElementById('leCercle').addEventListener('click', function () {
        document.getElementById('id_name_to_replace2').innerHTML = document.getElementById('leCercle').getAttribute('title');
    })
    document.getElementById('leRect').addEventListener('click', function () {
        document.getElementById('id_name_to_replace2').innerHTML = document.getElementById('leRect').getAttribute('title');
    })
    document.getElementById('laCourbe').addEventListener('click', function () {
        document.getElementById('id_name_to_replace2').innerHTML = document.getElementById('laCourbe').getAttribute('title');
    })
}

function Bouton10_make_country_clickable(xmlDocumentUrl, xslDocumentUrl) {

    countries = document.getElementsByClassName("land");
    for (i = 0; i < countries.length; ++i) {
        let country = countries[i];
        country.addEventListener('click', function () {
            //var xslDocument = loadHTTPXML(xslDocumentUrl);

            document.getElementById('Name').innerHTML = country.getAttribute('countryname');
        });
        country.addEventListener('mouseover', function () {
            country.style.fill = '#000000';
        });
        country.addEventListener('mouseleave', function () {
            country.style.fill = '#CCCCCC';
        });
    }
}

