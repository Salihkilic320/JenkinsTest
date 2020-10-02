/**
 * Functie om van CSS style file te wisselen.
 * Wordt gebruikt voor de darkmode van de pagina.
 * @param {*} sheet De file waar je de huidige stijle mee wil verwisselen.
 * @see {toggle()} De functie die wisselen tussen de dark style en light style mogelijk maakt.
 */
function swapStyleSheet(sheet)
{
    document.getElementById('pagestyle').setAttribute('href', sheet);
    
}

/**
 * Constanten om de afbeeldingen aan te roepen.
 */
const docent = "../img/icons-scherm/docent.png";
const docentWit = "../img/icons-scherm/docent_wit.png";
const aanwezigheid = "../img/icons-scherm/aanwezigheid.png";
const aanwezigheidWit = "../img/icons-scherm/aanwezigheid_wit.png";
const addMessage = "../img/icons-scherm/addmessage.png";
const addMessageWit = "../img/icons-scherm/addmessage_wit.png"

/**
 * Functie om de inlog afbeelding te wijzigen
 * @note Deze apparte functie is nodig voor de niet ingelogde pagina buienrader en newsfeed.
 * @param {*} button De knop waar op gedrukt wordt om te wisselen van afbeelding.
 */
function toggleBasic(button) 
{
    switch (button.value) 
    {
        case "ONN":
            swapStyleSheet('../Css/Darkstyle.css')
            document.getElementById("docentLogoColorChange").src = docentWit;
            button.value = "OFF";

            break;
        case "OFF":
            swapStyleSheet('../Css/style.css')
            document.getElementById("docentLogoColorChange").src = docent;
            button.value = "ONN";
            break;
    }
}

/**
 * Functie van de Dark mode knop.
 * Zorgt er voor dat er gewisseld kan worden tussen:
 * - Darkstyle.css
 * - style.css
 * Zorgt ook dat de afbeeldingen gewisseld worden tussen donker en wit.
 * Waardoor de styling van de pagina verandert wordt.
 * @param {*} button De knop waar op gedrukt wordt om te wisselen van style.
 */
function toggle(button) 
{
        switch (button.value) {
            case "ONN":
                swapStyleSheet('../Css/Darkstyle.css')
                document.getElementById("docentLogoColorChange").src = docentWit;
                document.getElementById("aanwezigheidLogoColorChange").src = aanwezigheidWit;
                document.getElementById("addMessageLogoColorChange").src = addMessageWit;
                button.value = "OFF";

                break;
            case "OFF":
                swapStyleSheet('../Css/style.css')
                document.getElementById("docentLogoColorChange").src = docent;
                document.getElementById("aanwezigheidLogoColorChange").src = aanwezigheid;
                document.getElementById("addMessageLogoColorChange").src = addMessage;
                button.value = "ONN";
                break;
    }
}

/**
 * Verwijderd alle inhoudelijke data op de pagina.
 */
function clearAllData()
{
    document.getElementById("koptekst").innerHTML = '';
    document.getElementById("paginaInhoud").innerHTML = '';
    document.getElementById("toNewsfeed").innerHTML = '';
    document.getElementById("loginScreen").innerHTML ='';
    document.getElementById("logOFF").innerHTML ='';
    document.getElementById("aanwezigheidLogo").innerHTML ='';
    document.getElementById("addMessageLogo").innerHTML ='';
    document.getElementById("newsfeedLogo").innerHTML ='';
    document.getElementById("aanwezigheidCheck").innerHTML ='';
    document.getElementById("showTheMessage").innerHTML =''
}

function showBuienradar()
{
    clearAllData()
    checkIngelogd()
    document.getElementById("koptekst").innerHTML = 'Buienradar';
    document.getElementById("paginaInhoud").innerHTML = 
    '<iframe src="https://gadgets.buienradar.nl/gadget/zoommap/?lat=52.77917&lng=6.90694&overname=2&zoom=8&naam=Emmen&size=3&voor=1" scrolling=no width=550 height=512 frameborder=no></iframe>';
    document.getElementById("toNewsfeed").innerHTML = 
    '<button type="button" onclick="showNewsfeed()">Back to newsfeed</button>';
}

function showNewsfeed()
{
    clearAllData()
    checkIngelogd()
    document.getElementById("koptekst").innerHTML = 'NEWSFEED';
}

/**
 * BUGGGGGGGGG form al gedefineerd
 */
function showLogonPage()
{
    clearAllData()
    checkIngelogd()
    document.getElementById("loginScreen").innerHTML =
    '<h1>Login</h1><br>'+
    '<div id="error"></div>'+
    '<form id="form" method="GET">'+
        '<div class="loginForm">'+
            '<label for="name">Name</label><br>'+
            '<input id="name" name="name" type="text" placeholder="Username">'+
        '</div>'+
        '<div class="loginForm">'+
            '<label for="password">Password</label><br>'+
            '<input id="password" name="password" type="password" placeholder="Password">'+
        '</div>'+
        '<div>'+
            '<button onclick="/*!!!!!!!!!!!!!!!!!!!Hier is een bug*/showLogoffPage()" type="submit">Login</button>'+
        '</div><br><br>'+
        '<p><a href="mailto:someone@example.com">Forgot your password?</a></p>'+
    '</form>'+
    '<br>'+
    '<button type="button" onclick="showNewsfeed()">Back to newsfeed</button>'
}


function showLogoffPage()
{
    clearAllData()
    ingelogdtest()
    checkIngelogd()
    ShowNewsfeedLogin()
    document.getElementById("logOFF").innerHTML = 
    '<h1>Logoff</h1>'+
    '<form>'+
        '<p> Do you want to logout?</p>'+
        '<button type="button" onclick="loguitkill()">logoff</button>'+
        '<br>'+
        '<br>'+
        '<br>'+
    '</form>'+

    '<h1>Change password</h1>'+
    '<div id="error"></div>'+
    '<form id="formChange">'+
        'Username<br>'+
        '<input type="text" id="name" name="name" placeholder="Username">'+
        '<br>'+
        '<br>'+
        'Old password<br>'+
        '<input type="password" id="password" name="password" placeholder="Current password">'+
        '<br>'+
        '<br>'+
        'New password<br>'+
        '<input type="text" id="newPassword" name="newPassword" placeholder="New password">'+
        '<br>'+
        '<br>'+
        '<button onclick="changePassword()" type="submit">ChangePassword</button>'+
        '<br>'+
        '<br>'+
    '</form>'+

    '<h1>Change user Avatar</h1><br>'+
    '<form action="#">'+
        '<div>'+
            '<input type="hidden" id="user_id" value="75" />'+
            '<input type="file" id="avatar_img" accept="image/x-png" multiple />'+
        '</div>'+
        '<div>'+
            '<button id="btnSubmit" onclick="">Upload Avatar</button>'+
        '</div>'+
    '</form>';

}

function ShowNewsfeedLogin()
{
    clearAllData()
    checkIngelogd()
}

function ingelogdtest()
{
    window.localStorage.setItem('user','user')
}

function checkIngelogd()
{
    if (window.localStorage.length > 0)
    {
        clearAllData()
        document.getElementById("aanwezigheidLogo").innerHTML =
        '<img onclick="showWijzigBeschikbaarheid()" id="aanwezigheidLogoColorChange" src="../img/icons-scherm/aanwezigheid.png" alt="Aanwezigheid" class="image"></img>';
        
        document.getElementById("addMessageLogo").innerHTML =
        '<img onclick="showMessage()" id="addMessageLogoColorChange" src="../img/icons-scherm/addmessage.png" alt="Add Message" class="image"></img>';
    
        document.getElementById("newsfeedLogo").innerHTML =
        '<img onclick="showNewsfeedLogin()" src="../img/icons-scherm/logo.png" alt="Logo" class="image"></img>';
    }
}

function loguitkill()
{
    window.localStorage.clear()
    clearAllData()
    showNewsfeed()
}

function showWijzigBeschikbaarheid()
{
    clearAllDatx a()
    ShowNewsfeedLogin()
    document.getElementById("aanwezigheidCheck").innerHTML =
    '<h1>Wijzig Beschikbaarheid</h1>'+
    'Klik op een knop om je status te wijzigen:'+
    '<br><br>'+
    '<butten style="background-color: red;">Maak het rood</butten>'+
    '<br><br>'+
    '<butten style="background-color: yellow;"> Maak het geel</butten>'+
    '<br><br>'+
    '<butten style="background-color: green;">Maak het green</butten>'
}

 showMessage
{
    clearAllData()
    ShowNewsfeedLogin()
    document.getElementById("showTheMessage").innerHTML =
    '<h1>Message</h1><br>'+
    '<p>Upload your file here with the following extension : .jpg, .jpeg, png.</p>'+

    '<form id="form" enctype="multipart/form-data" method="POST">'+
        '<div class="form-group">'+
            '<input type="file" name="fileUpload" accept=".jpg, .jpeg, .png" class="form-control" id="image" onchange="validate_fileupload(this.value);">'+
        '</div>'+
        '<div class="form-group">'+
            '<button type="submit"> Uploaden </button>'+
        '</div>'+
    '</form><br>'+

    '<button onclick="remove()"> Remove all picture s </button><br>'+
    '<div id="result" class="result">'+
    '<style>div.result>img{height: 250px;border-radius: 10px;}</style>'
}

showMessage()